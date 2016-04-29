/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Programa.Fornecedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOFornecedor {
    private final String nome = "postgres";
    private final String senha = "lucas";
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
    
    public void insere(Fornecedor c) throws SQLException{
        up("insert into fornecedor (cnpj, razaosocial, nomefantasia, inscricaoestadual, telefone, cidade, uf, rua, bairro, numero, pedidominimo,observacoes) values ('"+c.getCnpj()+"', '"+c.getRazaosocial()+"', '"+c.getNomefantasia()+"', '"+c.getInscricaoestadual()+"', '"+c.getTelefone()+"', '"+c.getCidade()+"', '"+c.getUf()+"', '"+c.getRua()+"', '"+c.getBairro()+"', '"+c.getNumero()+"', '"+c.getPedidominimo()+"','"+c.getObservacoes()+"');");
    }
    
    public void exclui(String cnpj) throws SQLException{
        up("delete from fornecedor where cnpj = '"+cnpj+"'");
    }
    
    public void atualiza(Fornecedor c) throws SQLException{
        up("update fornecedor set razaosocial ='"+c.getRazaosocial()+
                "', nomefantasia = '"+c.getNomefantasia()+"', inscricaoestadual = '"
                +c.getInscricaoestadual()+"', telefone ='"+c.getTelefone()+"', cidade = '"+c.getCidade()+
                "', uf = '"+c.getUf()+"', rua = '"+c.getRua()+"', bairro = '"+c.getBairro()+"', numero = '"
                +c.getNumero()+"', pedidominimo = '"+c.getPedidominimo()+"', observacoes = '"+c.getObservacoes()+"' where cnpj = '"+c.getCnpj()+"';");
    }
    
    public Fornecedor consulta(String cnpj) throws SQLException{
        Fornecedor c = new Fornecedor();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from fornecedor where cnpj = ?")) {
            pstm.setString(1, cnpj);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                c.setCnpj(rs.getString("cnpj"));
                c.setRazaosocial(rs.getString("razaosocial"));
                c.setNomefantasia(rs.getString("nomefantasia"));
                c.setInscricaoestadual(rs.getString("inscricaoestadual"));
                c.setTelefone(rs.getString("telefone"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setRua(rs.getString("rua"));
                c.setBairro(rs.getString("bairro"));
                c.setNumero(rs.getString("numero"));
                c.setPedidominimo("pedidominimo");
                c.setObservacoes(rs.getString("observacoes"));
            }   
        }
        close();
        return c;
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


    
}