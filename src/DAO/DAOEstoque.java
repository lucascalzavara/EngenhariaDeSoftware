/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Programa.Estoque;
import Programa.Fornecedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Calzavara
 */
public class DAOEstoque {
    private final String nome = "postgres";
    private final String senha = "shaco123";
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String driver = "org.postgresql.Driver";
    private Connection con;
    private Statement stm;
    private ResultSet res;
    
    public void conec(){
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url, nome, senha);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erro: "+e);
        }
    }
        
    public void close(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void up(String sql) throws SQLException{
        conec();
        stm = con.createStatement();
        stm.executeUpdate(sql);
        close();
    }
    
    public void insere(Estoque c) throws SQLException{
        up("insert into estoque (cod,valor,qtd,cdbarra,marca,descricao,fornecedor,precocusto,un,obs) values ("+c.getCod()+", "+c.getValor()+", "+c.getQtd()+", "+c.getCdbarra()+", '"+c.getMarca()+"', '"+c.getDescricao()+"', '"+c.getFornecedor()+"', "+c.getPrecocusto()+", '"+c.getUn()+"', '"+c.getObs()+"')");
    }
    
    public void exclui(String cod) throws SQLException{
        up("delete from estoque where cod = "+cod);
    }
    
    public void atualiza(Estoque c) throws SQLException{
        up("update estoque set valor ="+c.getValor()+
                ", qtd = "+c.getQtd()+", fornecedor = '"
                +c.getFornecedor()+"', precocusto ="+c.getPrecocusto()+", obs = '"+c.getObs()+
                "' where cod = "+c.getCod()+";");
    }
    
    public List<Estoque> consultaCod(int cd) throws SQLException{
        List<Estoque> estoq = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from estoque where cod = "+cd+"")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Estoque cli = new Estoque(rs.getFloat("valor"), rs.getInt("qtd"), rs.getInt("cdbarra"), rs.getString("marca"), rs.getString("descricao"), rs.getString("fornecedor"), rs.getFloat("precocusto"), rs.getString("un"), rs.getString("obs"));
            estoq.add(cli);
            }   
        }
       close();
        return estoq; 
    }
    public List<Estoque> consultaDescricao(String str) throws SQLException{
        List<Estoque> estoq = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from estoque where descricao like '"+str+"%' order by razaosocial")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Estoque cli = new Estoque(rs.getFloat("valor"), rs.getInt("qtd"), rs.getInt("cdbarra"), rs.getString("marca"), rs.getString("descricao"), rs.getString("fornecedor"), rs.getFloat("precocusto"), rs.getString("un"), rs.getString("obs"));
            estoq.add(cli);
            }   
        }
       close();
        return estoq; 
    }
    
    
    
    public List<Estoque> consultaTodos() throws SQLException{
        List<Estoque> estoq = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from estoque order by cod")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            Estoque cli = new Estoque(rs.getFloat("valor"), rs.getInt("qtd"), rs.getInt("cdbarra"), rs.getString("marca"), rs.getString("descricao"), rs.getString("fornecedor"), rs.getFloat("precocusto"), rs.getString("un"), rs.getString("obs")); 
            estoq.add(cli);
            }   
        }
       close();
        return estoq; 
}
}
