/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Programa.Estoque;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Calzavara
 */
public class DAOEstoque extends Conexao{
        
    public void insere(Estoque c) throws SQLException{
        up("insert into estoque (cod,valor,qtd,cdbarra,marca,descricao,fornecedor,precocusto,un,obs) values ("+c.getCod()+", "+c.getValor()+", "+c.getQtd()+", "+c.getCdbarra()+", '"+c.getMarca()+"', '"+c.getDescricao()+"', '"+c.getFornecedor()+"', "+c.getPrecocusto()+", '"+c.getUn()+"', '"+c.getObs()+"')");
    }
    
    public void exclui(int cod) throws SQLException{
        up("delete from estoque where cod = "+cod);
    }
    
    public void atualiza(Estoque c) throws SQLException{
        up("update estoque set valor ="+c.getValor()+
                ", qtd = "+c.getQtd()+",un = '"+c.getUn()+"',descricao = '"+c.getDescricao()+"',marca = '" +c.getMarca()+"',cdbarra = "+c.getCdbarra()+",fornecedor = '"
                +c.getFornecedor()+"', precocusto ="+c.getPrecocusto()+", obs = '"+c.getObs()+
                "' where cod = "+c.getCod()+";");
    }
    
    public List<Estoque> consultaCod(int cd) throws SQLException{
        List<Estoque> estoq = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from estoque where cod = "+cd+"")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Estoque cli = new Estoque(rs.getInt("cod"), rs.getFloat("valor"), rs.getInt("qtd"), rs.getInt("cdbarra"), rs.getString("marca"), rs.getString("descricao"), rs.getString("fornecedor"), rs.getFloat("precocusto"), rs.getString("un"),rs.getString("obs"));
            estoq.add(cli);
            }   
        }
       close();
        return estoq; 
    }
    public List<Estoque> consultaDescricao(String str) throws SQLException{
        List<Estoque> estoq = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from estoque where descricao like '"+str+"%' order by descricao")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
               Estoque cli = new Estoque(rs.getInt("cod"), rs.getFloat("valor"), rs.getInt("qtd"), rs.getInt("cdbarra"), rs.getString("marca"), rs.getString("descricao"), rs.getString("fornecedor"), rs.getFloat("precocusto"), rs.getString("un"),rs.getString("obs"));
            estoq.add(cli);
            }   
        }
       close();
        return estoq; 
    }
    
    
    
    public List<Estoque> consultaTodos() throws SQLException{
        List<Estoque> estoq = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from estoque order by descricao")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            Estoque cli = new Estoque(rs.getInt("cod"), rs.getFloat("valor"), rs.getInt("qtd"), rs.getInt("cdbarra"), rs.getString("marca"), rs.getString("descricao"), rs.getString("fornecedor"), rs.getFloat("precocusto"), rs.getString("un"),rs.getString("obs")); 
            estoq.add(cli);
            }   
        }
       close();
        return estoq; 
    }
    
    public void atualizaQuantidade(int cod, int qtd) throws SQLException{
        up("update estoque set qtd = "+qtd+" where cod = "+cod);
    }
}
