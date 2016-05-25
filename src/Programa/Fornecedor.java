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
public class Fornecedor {
    private String cnpj;
    private String razaosocial;
    private String nomefantasia;
    private String inscricaoestadual;
    private String telefone;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;
    private String pedidominimo;
    private String observacoes;

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
    
    public Fornecedor (String cnpj){
        this.cnpj = cnpj;
    }
    
    public Fornecedor (String razaosocial, int razao){
        this.razaosocial = razaosocial;
    }

    public Fornecedor() {
        
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPedidominimo() {
        return pedidominimo;
    }

    public void setPedidominimo(String pedidominimo) {
        this.pedidominimo = pedidominimo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
