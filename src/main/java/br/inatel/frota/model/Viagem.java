package br.inatel.frota.model;

import java.time.LocalDateTime;

public class Viagem {

    private int idViagem;
    private int idVeiculo;
    private int idMotorista;
    private LocalDateTime dataHoraSaida;
    private String destino;

    public Viagem() {
    }

    public Viagem(int idVeiculo, int idMotorista, LocalDateTime dataHoraSaida, String destino) {
        this.idVeiculo = idVeiculo;
        this.idMotorista = idMotorista;
        this.dataHoraSaida = dataHoraSaida;
        this.destino = destino;
    }

    public Viagem(int idViagem, int idVeiculo, int idMotorista, LocalDateTime dataHoraSaida, String destino) {
        this.idViagem = idViagem;
        this.idVeiculo = idVeiculo;
        this.idMotorista = idMotorista;
        this.dataHoraSaida = dataHoraSaida;
        this.destino = destino;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return String.format("Viagem [id=%d, idVeiculo=%d, idMotorista=%d, saida=%s, destino=%s]",
                idViagem, idVeiculo, idMotorista, dataHoraSaida, destino);
    }
}
