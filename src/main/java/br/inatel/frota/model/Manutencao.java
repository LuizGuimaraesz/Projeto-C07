package br.inatel.frota.model;

import java.time.LocalDate;

public class Manutencao {

    private int idManutencao;
    private int idVeiculo;
    private int idOficina;
    private LocalDate dataServico;
    private double custoTotal;

    public Manutencao() {
    }

    public Manutencao(int idVeiculo, int idOficina, LocalDate dataServico, double custoTotal) {
        this.idVeiculo = idVeiculo;
        this.idOficina = idOficina;
        this.dataServico = dataServico;
        this.custoTotal = custoTotal;
    }

    public Manutencao(int idManutencao, int idVeiculo, int idOficina, LocalDate dataServico, double custoTotal) {
        this.idManutencao = idManutencao;
        this.idVeiculo = idVeiculo;
        this.idOficina = idOficina;
        this.dataServico = dataServico;
        this.custoTotal = custoTotal;
    }

    public int getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(int idManutencao) {
        this.idManutencao = idManutencao;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public LocalDate getDataServico() {
        return dataServico;
    }

    public void setDataServico(LocalDate dataServico) {
        this.dataServico = dataServico;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    @Override
    public String toString() {
        return String.format("Manutencao [id=%d, idVeiculo=%d, idOficina=%d, data=%s, custo=R$ %.2f]",
                idManutencao, idVeiculo, idOficina, dataServico, custoTotal);
    }
}
