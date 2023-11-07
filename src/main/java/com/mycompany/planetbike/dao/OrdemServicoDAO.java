package com.mycompany.planetbike.dao;

import com.mycompany.planetbike.conexao.Conexao;
import com.mycompany.planetbike.model.OrdemServicoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    public void CreateOrdemServico(OrdemServicoModel osm) {
        String sql = "INSERT INTO ordens (nome,cpf,email,telefone)  VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = Conexao.createConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, osm.getNome());
            ps.setString(2, osm.getCpf());
            ps.setString(3, osm.getEmail());
            ps.setString(4, osm.getTelefone());

            ps.execute();

        } catch (Exception e) {
            System.out.println("erro ao cadastrar ordem: " + e);
        }
    }

    public List<OrdemServicoModel> ShowOrdens() {

        String sql = "SELECT * FROM ordens";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<OrdemServicoModel> ordens = new ArrayList<OrdemServicoModel>();

        try {

            connection = Conexao.createConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServicoModel osm = new OrdemServicoModel();

                osm.setIdOrdem(rs.getInt("id_ordem"));
                osm.setNome(rs.getString("nome"));
                osm.setCpf(rs.getString("cpf"));
                osm.setEmail(rs.getString("email"));
                osm.setTelefone(rs.getString("telefone"));

                ordens.add(osm);

            }

        } catch (Exception e) {

            System.out.println("erro em mostrar ordem: " + e);

        }

        return ordens;

    }

    public void UpdateOrdemDeServico(OrdemServicoModel osm) {

        String sql = "UPDATE SET ordens nome = ?, cpf = ?, email = ?, telefone = ? WHERE id_ordem = ?";

        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = Conexao.createConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, osm.getNome());
            ps.setString(2, osm.getEmail());
            ps.setString(3, osm.getTelefone());
            ps.setInt(4, osm.getIdOrdem());

            ps.execute();

        } catch (Exception e) {

            System.out.println("erro em atualizar ordem: " + e);

        }

    }

    public void DeleteOrdemServico(int id) {

        String sql = "DELETE FROM ordens WHERE id_ordem = ?";

        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = Conexao.createConnection();
            ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();

        } catch (Exception e) {

            System.out.println("erro em deletar ordem: " + e);

        }

    }

}
