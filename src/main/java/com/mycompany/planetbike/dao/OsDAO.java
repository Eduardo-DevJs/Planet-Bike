/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.dao;

import com.mycompany.planetbike.conexao.Conexao;
import com.mycompany.planetbike.model.OrdemModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dudu
 */
public class OsDAO {

    public List<OrdemModel> mostrarOrdens() {
        String sql = "SELECT * FROM ordens";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<OrdemModel> ordens = new ArrayList<OrdemModel>();

        try {
            con = Conexao.createConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                OrdemModel om = new OrdemModel();

                om.setOs(rs.getInt("os"));
                om.setDataOs(rs.getTimestamp("data_os"));
                om.setTipo(rs.getString("tipo"));
                om.setSituacao(rs.getString("situacao"));
                om.setFuncionario(rs.getString("funcionario"));
                om.setModelo(rs.getString("modelo"));
                om.setCor(rs.getString("cor"));
                om.setDescricao(rs.getString("descricao"));
                om.setValorTotal(new BigDecimal(rs.getString("valor_total")));
                om.setIdCliente(rs.getInt("id_cliente"));

             

                ordens.add(om);
            }

        } catch (Exception e) {
            System.out.println("Erro ao mostrar ordens (DAO) " + e);
        }

        return ordens;
    }
}
