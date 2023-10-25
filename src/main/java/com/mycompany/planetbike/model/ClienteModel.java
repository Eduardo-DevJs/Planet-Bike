package com.mycompany.planetbike.model;

public class ClienteModel {
    private int id_cliente;
    private String nome;
    private String celular;
    private String email;
    private String cpf;
    private String cep;
    private String endereco;
    private String complemento;

    
    public ClienteModel(){
        
    }

    public ClienteModel(String nome, String celular, String email, String cpf, String cep, String endereco, String complemento) {
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;

    }
    
   
    public ClienteModel(int id_cliente, String nome, String celular, String email, String cpf, String cep, String endereco) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    
}
