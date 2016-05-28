/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import DAO.DAOFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucas Calzavara
 */
public class Fornecedor extends PessoaJuridica{
    private String pedidominimo;
   

    public Fornecedor(String cnpj, String razaosocial, String nomefantasia, String inscricaoestadual, String telefone, String rua, String bairro, String numero, String cidade, String uf, String pedidominimo, String observacoes) {
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
        this.pedidominimo = pedidominimo;
        this.observacoes = observacoes;
    }

    public Fornecedor() {
        
    }
    
   
    public String getPedidominimo() {
        return pedidominimo;
    }

    public void setPedidominimo(String pedidominimo) {
        this.pedidominimo = pedidominimo;
    }
    
    public boolean insere(){
        DAOFornecedor con = new DAOFornecedor();
        try {
            con.insere(this);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean altera(){
        DAOFornecedor con = new DAOFornecedor();
        try {
            con.atualiza(this);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean exclui(){
        DAOFornecedor con = new DAOFornecedor();
        try{
            con.exclui(cnpj);
            return true;
        } catch (SQLException ex){
            return false;
        }
    }
    
    public ArrayList<Fornecedor> ConsultaTodos(){
        ArrayList<Fornecedor> forn = new ArrayList<>();
        DAOFornecedor f = new DAOFornecedor();
        try {
            forn = (ArrayList<Fornecedor>) f.consultaTodos();
        } catch (SQLException ex) {

        }
        return forn;
    }
    
    public ArrayList<Fornecedor> ConsultaCnpj(){
        DAOFornecedor f = new DAOFornecedor();
        ArrayList<Fornecedor> forn = new ArrayList<>();
        try {
            forn = (ArrayList<Fornecedor>)f.consultaCnpj(cnpj);
        } catch (SQLException ex) {
            
        }
        return forn;
    }

    public ArrayList<Fornecedor> ConsultaRazao(){
        DAOFornecedor f = new DAOFornecedor();
        ArrayList<Fornecedor> forn = new ArrayList<>();
            try {
                forn = (ArrayList<Fornecedor>) f.consultaRazaoSocial(razaosocial);
            } catch (SQLException ex) {
                
            }
            return forn;
    }
}
