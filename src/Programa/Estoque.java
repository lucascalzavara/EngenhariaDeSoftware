/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import DAO.DAOEstoque;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucas Calzavara
 */
public class Estoque {
              private int cod;

    public Estoque(float aFloat, int aInt, int aInt0, String string, String string0, String string1, float aFloat0, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
              private float valor;
	      private int qtd; 
	      private int cdbarra ;
	      private String marca;
	      private String descricao ;
	      private String fornecedor;
	      private float precocusto;
	      private String un;
	      private String obs;

    public Estoque(int cod,float valor, int qtd, int cdbarra, String marca, String descricao, String fornecedor, float precocust, String un, String obs) {
        this.cod=cod;
        this.valor = valor;
        this.qtd = qtd;
        this.cdbarra = cdbarra;
        this.marca = marca;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.precocusto = precocust;
        this.un = un;
        this.obs = obs;
    }

    public Estoque() {
    }
              
    

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getCdbarra() {
        return cdbarra;
    }

    public void setCdbarra(int cdbarra) {
        this.cdbarra = cdbarra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(float precocust) {
        this.precocusto = precocust;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
	     
    
    public boolean insere(){
        DAOEstoque con = new DAOEstoque();
        try {
            con.insere(this);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean altera(){
        DAOEstoque con = new DAOEstoque();
        try {
            con.atualiza(this);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean exclui(){
        DAOEstoque con = new DAOEstoque();
        try{
            con.exclui(Integer.toString(cod));
            return true;
        } catch(SQLException ex){
            return false;
        }
    }
    
    public ArrayList<Estoque> ConsultaTodos(){
        ArrayList<Estoque> Estoq = new ArrayList<>();
        DAOEstoque con = new DAOEstoque();
        try {
            Estoq = (ArrayList<Estoque>) con.consultaTodos();
        } catch (SQLException ex) {
            
        }
        return Estoq;
    }
    
    public ArrayList<Estoque> ConsultaCod(){
        DAOEstoque c = new DAOEstoque();
        ArrayList<Estoque> estoq = new ArrayList<>();
        try {
            estoq = (ArrayList<Estoque>)c.consultaCod(cod);
        } catch (SQLException ex) {
            
        }
        return estoq;
    }

    public ArrayList<Estoque> ConsultaDescricao(){
        DAOEstoque c = new DAOEstoque();
        ArrayList<Estoque> estoq = new ArrayList<>();
            try {
                estoq = (ArrayList<Estoque>) c.consultaDescricao(descricao);
            } catch (SQLException ex) {
                
            }
            return estoq;
    }
    
}
