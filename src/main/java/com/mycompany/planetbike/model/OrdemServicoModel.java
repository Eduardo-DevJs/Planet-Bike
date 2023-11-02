package com.mycompany.planetbike.model;

public class OrdemServicoModel {

    private int idOrdem;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public OrdemServicoModel() {
    }

    public OrdemServicoModel(int idOrdem, String nome, String email, String telefone, String cpf) {
        this.idOrdem = idOrdem;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
