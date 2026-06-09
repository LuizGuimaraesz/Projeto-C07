package br.inatel.frota.model;

import java.time.LocalDate;

public class Rastreador {

    private int idRastreador;
    private int idVeiculo;
    private String numeroSerie;
    private LocalDate dataAtivacao;

    public Rastreador() {
    }

    public Rastreador(int idVeiculo, String numeroSerie, LocalDate dataAtivacao) {
        this.idVeiculo = idVeiculo;
        this.numeroSerie = numeroSerie;
        this.dataAtivacao = dataAtivacao;
    }

    public Rastreador(int idRastreador, int idVeiculo, String numeroSerie, LocalDate dataAtivacao) {
        this.idRastreador = idRastreador;
        this.idVeiculo = idVeiculo;
        this.numeroSerie = numeroSerie;
        this.dataAtivacao = dataAtivacao;
    }

    public int getIdRastreador() {
        return idRastreador;
    }

    public void setIdRastreador(int idRastreador) {
        this.idRastreador = idRastreador;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDate getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDate dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    @Override
    public String toString() {
        return String.format("Rastreador [id=%d, idVeiculo=%d, serie=%s, ativacao=%s]",
                idRastreador, idVeiculo, numeroSerie, dataAtivacao);
    }
}
