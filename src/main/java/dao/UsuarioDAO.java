/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.UsuarioModel;

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
    
    public ResultSet AutenticarLoginFuncionario(UsuarioModel user){
        String sql = "select * from funcionario where login = ? and senha = ?";
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
}
