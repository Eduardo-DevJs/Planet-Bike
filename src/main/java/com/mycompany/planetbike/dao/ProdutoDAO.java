/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.dao;

import com.mycompany.planetbike.conexao.Conexao;
import com.mycompany.planetbike.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    
    Connection con = null;
    PreparedStatement pstm = null;
    public void CadastrarProduto(ProdutoModel produto){
        String sql = "insert into produtos (nome,descricao,cfop,quantidade,valor_unitario,total) values(?,?,?,?,?,?)";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setInt(3,produto.getCfop());
            pstm.setInt(4,produto.getQuantidade());
            pstm.setDouble(5, produto.getValorUni());
            pstm.setDouble(6, produto.getTotal());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro cadastrar Produto:"+e);
        }
    }
}
