/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.dao;

import com.mycompany.planetbike.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mycompany.planetbike.model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mferreira
 */
public class UsuarioDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    
    public ResultSet AutenticarLoginAdmin(UsuarioModel user){
        String sql = "select * from admin where login = ? and senha = ?";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getLogin());
            pstm.setString(2,user.getSenha());
            ResultSet rset = pstm.executeQuery();
            return rset;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Login Admin:"+e);
            return null;
        }   
    }
    
    public ResultSet AutenticarLogin(UsuarioModel user){
        String sql = "select * from usuario where login = ? and senha = ?";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getLogin());
            pstm.setString(2,user.getSenha());
            ResultSet rset = pstm.executeQuery();
            return rset;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Login Admin:"+e);
            return null;
        }   
    }
    
    public void CadastrarUsuario(UsuarioModel func){
        String sql = "insert into usuario (login,senha,perfil) values(?,?,?)";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, func.getLogin());
            pstm.setString(2, func.getSenha());
            pstm.setString(3, func.getPerfil());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Cadastro de funcionario:"+e);
        }
    }
    
    public List<UsuarioModel> MostrarFunci(){
        String sql = "select * from usuario";
        con = Conexao.createConnection();
        ArrayList<UsuarioModel> funcs = new ArrayList<>();
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            while(rset.next()){
                UsuarioModel func = new UsuarioModel();
                func.setLogin(rset.getString("login"));
                func.setPerfil(rset.getString("perfil"));
                func.setSenha(rset.getString("senha"));
                func.setId(rset.getInt("Id"));
                funcs.add(func);
            }
            return funcs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro mostrar funcionario: "+e);
            return null;
        }
    }
    
    public void DeletarFunc(int id){
        String sql = "delete from usuario where id = ?";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Funcionario Deletado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar funcionario:"+e);
        }
    }
    
    public void AtualizarFuncionario(UsuarioModel func){
        String sql = "update usuario set login = ?, senha =?, perfil = ? where id =?";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, func.getLogin());
            pstm.setString(2, func.getSenha());
            pstm.setString(3, func.getPerfil());
            pstm.setInt(4, func.getId());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Funcionario Editado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionario: "+e);
        }
    }
}
