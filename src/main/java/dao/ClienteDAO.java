package dao;

import com.mycompany.planetbike.conexao.Conexao;
import com.mycompany.planetbike.model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {
    public void CriarCliente(ClienteModel cm){
        String sql = "INSERT INTO clientes (nome, celular, email, cpf, cep, endereco, complemento ) VALUES (?,?,?,?,?,?,?)";
        
        Connection con = null;
        PreparedStatement ps =null;
        
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
}
