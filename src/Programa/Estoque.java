/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import DAO.DAOEstoque;
import java.sql.SQLException;

/**
 *
 * @author Lucas Calzavara
 */
public class Estoque {
              private float valor;
	      private int qtd; 
	      private int cdbarra ;
	      private String marca;
	      private String descricao ;
	      private String fornecedor;
	      private float precocust;
	      private String un;
	      private String obs;

    public Estoque(float valor, int qtd, int cdbarra, String marca, String descricao, String fornecedor, float precocust, String un, String obs) {
        this.valor = valor;
        this.qtd = qtd;
        this.cdbarra = cdbarra;
        this.marca = marca;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.precocust = precocust;
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

    public float getPrecocust() {
        return precocust;
    }

    public void setPrecocust(float precocust) {
        this.precocust = precocust;
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
	      

    
    
    
   /*
    
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
    }*/
    
    
}
