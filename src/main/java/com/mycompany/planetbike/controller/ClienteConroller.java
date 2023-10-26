package com.mycompany.planetbike.controller;

import com.mycompany.planetbike.model.ClienteModel;
import com.mycompany.planetbike.dao.ClienteDAO;

public class ClienteConroller {
    public boolean CriarCliente(String nome, String celular, String email, String cpf, String cep, String endereco, String complemento){
        if(nome != null && nome.length() > 0 && celular != null && email != null && email.length() > 0 && cpf != null && cpf != null && cpf.length() > 0 && cep != null && cep.length() > 0){
            ClienteModel cmod = new ClienteModel(nome, celular, email, cpf, cep, endereco, complemento);
            ClienteDAO cdao = new ClienteDAO();
            cdao.CriarCliente(cmod);
            
            return true;
        }
        
        return false;
        
    }
}
