package br.inatel.frota.model;

public class Dependente {

    private int idDependente;
    private int idMotorista;
    private String nomeDependente;

    public Dependente() {
    }

    public Dependente(int idMotorista, String nomeDependente) {
        this.idMotorista = idMotorista;
        this.nomeDependente = nomeDependente;
    }

    public Dependente(int idDependente, int idMotorista, String nomeDependente) {
        this.idDependente = idDependente;
        this.idMotorista = idMotorista;
        this.nomeDependente = nomeDependente;
    }

    public int getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(int idDependente) {
        this.idDependente = idDependente;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    @Override
    public String toString() {
        return String.format("Dependente [id=%d, idMotorista=%d, nome=%s]",
                idDependente, idMotorista, nomeDependente);
    }
}
