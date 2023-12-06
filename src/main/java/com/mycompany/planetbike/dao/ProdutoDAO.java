/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.dao;

import com.mycompany.planetbike.conexao.Conexao;
import com.mycompany.planetbike.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    Connection con = null;
    PreparedStatement pstm = null;

    public void CadastrarProduto(ProdutoModel produto) {
        String sql = "INSERT INTO produtos (nome,descricao,cfop,quantidade,valor_unitario,total) VALUES (?,?,?,?,?,?)";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setInt(3, produto.getCfop());
            pstm.setInt(4, produto.getQuantidade());
            pstm.setDouble(5, produto.getValorUni());
            pstm.setDouble(6, produto.getTotal());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro cadastrar Produto: " + e);
        }
    }

    public List<ProdutoModel> mostrarProdutos() {
        String sql = "SELECT * FROM produtos";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        ArrayList<ProdutoModel> produtos = new ArrayList<ProdutoModel>();

        try {
            connection = Conexao.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ProdutoModel pm = new ProdutoModel();

                pm.setId(rs.getInt("id_produto"));
                pm.setNome(rs.getString("nome"));
                pm.setDescricao(rs.getString("descricao"));
                pm.setCfop(rs.getInt("cfop"));
                pm.setQuantidade(rs.getInt("quantidade"));
                pm.setValorUni(rs.getInt("valor_unitario"));
                pm.setTotal(rs.getDouble("total"));

                produtos.add(pm);
            }

        } catch (Exception e) {
            System.out.println("Erro ao mostrar produtos DAO: " + e);
        }

        return produtos;
    }

    public void atualizarProduto(ProdutoModel pm) {
        String sql = "UPDATE produtos SET nome=?,descricao=?,cfop=?,quantidade=?, valor_unitario=?, total = ? WHERE id_produto=?";

        Connection connection = null;
        PreparedStatement prepareStatement = null;
        double total = pm.getQuantidade() * pm.getValorUni();
        try {

            connection = Conexao.createConnection();
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, pm.getNome());
            prepareStatement.setString(2, pm.getDescricao());
            prepareStatement.setInt(3, pm.getCfop());
            prepareStatement.setInt(4, pm.getQuantidade());
            prepareStatement.setDouble(5, pm.getValorUni());
            prepareStatement.setDouble(6, total);
            prepareStatement.setInt(7, pm.getId());

            prepareStatement.execute();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto: " + e);
        }
    }

    public void deletarProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id_produto=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.createConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }

}
