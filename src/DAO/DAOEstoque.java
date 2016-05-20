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
                Estoque cli = new Estoque(rs.getString("cnpj"), rs.getString("razaosocial"), rs.getString("nomefantasia"), rs.getString("inscricaoestadual"), rs.getString("telefone"), rs.getString("rua"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("uf"), rs.getString("pedidominimo"), rs.getString("observacoes"));
            forn.add(cli);
            }   
        }
       close();
        return forn; 
    }
    
    public List<Fornecedor> consultaRazaoSocial(String str) throws SQLException{
        List<Fornecedor> forn = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from fornecedor where razaosocial like '"+str+"%' order by razaosocial")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Fornecedor cli = new Fornecedor(rs.getString("cnpj"), rs.getString("razaosocial"), rs.getString("nomefantasia"), rs.getString("inscricaoestadual"), rs.getString("telefone"), rs.getString("rua"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("uf"), rs.getString("pedidominimo"), rs.getString("observacoes"));
            forn.add(cli);
            }   
        }
       close();
        return forn; 
    }
    
    public List<Fornecedor> consultaTodos() throws SQLException{
        List<Fornecedor> forn = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from fornecedor order by razaosocial")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Fornecedor cli = new Fornecedor(rs.getString("cnpj"), rs.getString("razaosocial"), rs.getString("nomefantasia"), rs.getString("inscricaoestadual"), rs.getString("telefone"), rs.getString("rua"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("uf"), rs.getString("pedidominimo"), rs.getString("observacoes"));
            forn.add(cli);
            }   
        }
       close();
        return forn; 
}
