/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Dudu
 */
public class OrdemModel {

    private int os;
    private Timestamp dataOs;
    private String tipo;
    private String situacao;
    private String funcionario;
    private String modelo;
    private String cor;
    private String descricao;
    private BigDecimal valorTotal;
    private int idCliente;

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public Timestamp getDataOs() {
        return dataOs;
    }

    public void setDataOs(Timestamp dataOs) {
        this.dataOs = dataOs;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
