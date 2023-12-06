package com.mycompany.planetbike.dao;

import com.mycompany.planetbike.conexao.Conexao;
import com.mycompany.planetbike.model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void CriarCliente(ClienteModel cm) {
        String sql = "INSERT INTO clientes (nome, celular, email, cpf, cep, endereco, complemento ) VALUES (?,?,?,?,?,?,?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = Conexao.createConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, cm.getNome());
            ps.setString(2, cm.getCelular());
            ps.setString(3, cm.getEmail());
            ps.setString(4, cm.getCpf());
            ps.setString(5, cm.getCep());
            ps.setString(6, cm.getEndereco());
            ps.setString(7, cm.getComplemento());

            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente (DAO) " + e);
        }
    }

    public List<ClienteModel> mostrarClientes() {
        String sql = "SELECT * FROM clientes";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ClienteModel> clientes = new ArrayList<ClienteModel>();

        try {
            con = Conexao.createConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ClienteModel clienteModel = new ClienteModel();

                clienteModel.setId_cliente(rs.getInt("id_cliente"));
                clienteModel.setNome(rs.getString("nome"));
                clienteModel.setCelular(rs.getString("celular"));
                clienteModel.setEmail(rs.getString("email"));
                clienteModel.setCpf(rs.getString("cpf"));
                clienteModel.setCep(rs.getString("cep"));
                clienteModel.setEndereco(rs.getString("endereco"));
                clienteModel.setComplemento(rs.getString("complemento"));

                clientes.add(clienteModel);
            }

        } catch (Exception e) {
            System.out.println("Erro ao mostrar clientes (DAO) " + e);
        }

        return clientes;
    }
    
     public void atulizarCliente(ClienteModel cm) {
        String sql = "UPDATE clientes SET nome=?, celular=?, email=?, cpf=?, cep=?, endereco=?, complemento=? WHERE id_cliente=?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, cm.getNome());
            ps.setString(2, cm.getCelular());
            ps.setString(3, cm.getEmail());
            ps.setString(4, cm.getCpf());
            ps.setString(5, cm.getCep());
            ps.setString(6, cm.getEndereco());
            ps.setString(7, cm.getComplemento());

            ps.setInt(8, cm.getId_cliente());

            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar clientes (DAO) " + e);
        }
    }
    
    public void excluirCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id_cliente=?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar cliente (DAO) " + e);
        }
    }
}
