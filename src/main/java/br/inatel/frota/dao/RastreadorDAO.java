package br.inatel.frota.dao;

import br.inatel.frota.db.Conexao;
import br.inatel.frota.model.Rastreador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RastreadorDAO {

    public void inserir(Rastreador r) {
        String sql = "INSERT INTO Rastreador (id_veiculo, numero_serie, data_ativacao) VALUES (?, ?, ?)";
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, r.getIdVeiculo());
            ps.setString(2, r.getNumeroSerie());
            ps.setObject(3, r.getDataAtivacao());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    r.setIdRastreador(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir rastreador: " + e.getMessage(), e);
        }
    }

    public void atualizar(Rastreador r) {
        String sql = "UPDATE Rastreador SET id_veiculo = ?, numero_serie = ?, data_ativacao = ? WHERE id_rastreador = ?";
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, r.getIdVeiculo());
            ps.setString(2, r.getNumeroSerie());
            ps.setObject(3, r.getDataAtivacao());
            ps.setInt(4, r.getIdRastreador());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar rastreador: " + e.getMessage(), e);
        }
    }

    public void deletar(int idRastreador) {
        String sql = "DELETE FROM Rastreador WHERE id_rastreador = ?";
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRastreador);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar rastreador: " + e.getMessage(), e);
        }
    }

    public List<Rastreador> listar() {
        String sql = "SELECT id_rastreador, id_veiculo, numero_serie, data_ativacao FROM Rastreador ORDER BY id_rastreador";
        List<Rastreador> lista = new ArrayList<>();
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar rastreadores: " + e.getMessage(), e);
        }
        return lista;
    }

    public Rastreador buscarPorNumeroSerie(String numeroSerie) {
        String sql = "SELECT id_rastreador, id_veiculo, numero_serie, data_ativacao FROM Rastreador WHERE numero_serie = ?";
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numeroSerie);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar rastreador: " + e.getMessage(), e);
        }
        return null;
    }

    // JOIN
    // lista cada rastreador junto da placa do veiculo q ele ta instalado
    public List<String> listarComVeiculo() {
        String sql =
                "SELECT r.id_rastreador, r.numero_serie, r.data_ativacao, v.placa "
              + "FROM Rastreador r "
              + "INNER JOIN Veiculo v ON r.id_veiculo = v.id_veiculo "
              + "ORDER BY r.id_rastreador";
        List<String> lista = new ArrayList<>();
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(String.format("Rastreador #%d | Serie: %s | Ativacao: %s | Veiculo: %s",
                        rs.getInt("id_rastreador"),
                        rs.getString("numero_serie"),
                        rs.getObject("data_ativacao", LocalDate.class),
                        rs.getString("placa")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro no JOIN rastreador/veiculo: " + e.getMessage(), e);
        }
        return lista;
    }

    private Rastreador mapear(ResultSet rs) throws SQLException {
        return new Rastreador(
                rs.getInt("id_rastreador"),
                rs.getInt("id_veiculo"),
                rs.getString("numero_serie"),
                rs.getObject("data_ativacao", LocalDate.class));
    }
}
