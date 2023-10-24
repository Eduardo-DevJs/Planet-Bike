/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mferreira
 */
public class Conexao {
    public static final String url = "jdbc:mysql://localhost/bd_planetbike";
    public static final String user = "root";
    public static final String pass = "";
    
    public static Connection createConnection(){
        Connection con = null;
         try {
            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na Conexao"+e);
        }
        return con;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection con = createConnection();
        if(con!=null){
            con.close();
            JOptionPane.showMessageDialog(null, "Conexão realizada");
        }
    }
}
