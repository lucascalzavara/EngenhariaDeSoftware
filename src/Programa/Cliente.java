/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import DAO.DAOCliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucas Calzavara
 */
public class Cliente extends PessoaJuridica {


    public Cliente(String cnpj, String razaosocial, String nomefantasia, String inscricaoestadual, String telefone, String rua, String bairro, String numero, String cidade, String uf, String observacoes) {
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
        this.nomefantasia = nomefantasia;
        this.inscricaoestadual = inscricaoestadual;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.observacoes = observacoes;
    }
    
    public Cliente (String cnpj){
        this.cnpj = cnpj;
    }

    public Cliente (String razaosocial, int razao){
        this.razaosocial = razaosocial;
    }
    
    public Cliente(){
        
    }
  
    public boolean insere(){
        DAOCliente con = new DAOCliente();
        if(validaDados()){
            try {
                con.insere(this);
                return true;
            } catch (SQLException ex) {
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean altera(){
        DAOCliente con = new DAOCliente();
        if(validaDados()){
            try {
                con.atualiza(this);
                return true;
            } catch (SQLException ex) {
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean exclui(){
        DAOCliente con = new DAOCliente();
        try{
            con.exclui(cnpj);
            return true;
        } catch(SQLException ex){
            return false;
        }
    }
    
    public ArrayList<Cliente> ConsultaTodos(){
        ArrayList<Cliente> clis = new ArrayList<>();
        DAOCliente c = new DAOCliente();
        try {
            clis = (ArrayList<Cliente>) c.consultaTodos();
        } catch (SQLException ex) {
            
        }
        return clis;
    }
    
    public ArrayList<Cliente> ConsultaCnpj(){
        DAOCliente c = new DAOCliente();
        ArrayList<Cliente> forn = new ArrayList<>();
        try {
            forn = (ArrayList<Cliente>)c.consultaCnpj(cnpj);
        } catch (SQLException ex) {
            
        }
        return forn;
    }

    public ArrayList<Cliente> ConsultaRazao(){
        DAOCliente c = new DAOCliente();
        ArrayList<Cliente> forn = new ArrayList<>();
            try {
                forn = (ArrayList<Cliente>) c.consultaRazaoSocial(razaosocial);
            } catch (SQLException ex) {
                
            }
            return forn;
    }
    
}