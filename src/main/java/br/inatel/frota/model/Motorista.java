package br.inatel.frota.model;

import java.time.LocalDate;

public class Motorista {

    private int idMotorista;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private boolean statusAtivo;

    public Motorista() {
    }

    public Motorista(String nome, String cpf, LocalDate dataNascimento, boolean statusAtivo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.statusAtivo = statusAtivo;
    }

    public Motorista(int idMotorista, String nome, String cpf, LocalDate dataNascimento, boolean statusAtivo) {
        this.idMotorista = idMotorista;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.statusAtivo = statusAtivo;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    @Override
    public String toString() {
        return String.format("Motorista [id=%d, nome=%s, cpf=%s, nasc=%s, ativo=%s]",
                idMotorista, nome, cpf, dataNascimento, statusAtivo ? "Sim" : "Nao");
    }
}
