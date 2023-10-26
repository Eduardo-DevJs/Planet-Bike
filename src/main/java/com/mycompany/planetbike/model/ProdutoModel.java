/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.model;

/**
 *
 * @author kiepe
 */
public class ProdutoModel {
    private int id;
    private String nome;
    private String descricao;
    private int cpof;
    private int quantidade;
    private double valorUni;
    private double total;

    public ProdutoModel() {
    }

    public ProdutoModel(String nome, String descricao, int cpof, int quantidade, double valorUni, double total) {
        this.nome = nome;
        this.descricao = descricao;
        this.cpof = cpof;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCpof() {
        return cpof;
    }

    public void setCpof(int cpof) {
        this.cpof = cpof;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUni() {
        return valorUni;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
