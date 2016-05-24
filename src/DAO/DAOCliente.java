/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Programa.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends Conexao {
        
    public void insere(Cliente c) throws SQLException{
        up("insert into cliente (cnpj, razaosocial, nomefantasia, inscricaoestadual, telefone, cidade, uf, rua, bairro, numero, observacoes) values ('"+c.getCnpj()+"', '"+c.getRazaosocial()+"', '"+c.getNomefantasia()+"', '"+c.getInscricaoestadual()+"', '"+c.getTelefone()+"', '"+c.getCidade()+"', '"+c.getUf()+"', '"+c.getRua()+"', '"+c.getBairro()+"', '"+c.getNumero()+"', '"+c.getObservacoes()+"');");
    }
    
    public void exclui(String cnpj) throws SQLException{
        up("delete from cliente where cnpj = '"+cnpj+"'");
    }
    
    public void atualiza(Cliente c) throws SQLException{
        up("update cliente set razaosocial ='"+c.getRazaosocial()+
                "', nomefantasia = '"+c.getNomefantasia()+"', inscricaoestadual = '"
                +c.getInscricaoestadual()+"', telefone ='"+c.getTelefone()+"', cidade = '"+c.getCidade()+
                "', uf = '"+c.getUf()+"', rua = '"+c.getRua()+"', bairro = '"+c.getBairro()+"', numero = '"
                +c.getNumero()+"', observacoes = '"+c.getObservacoes()+"' where cnpj = '"+c.getCnpj()+"';");
    }
    
    public List<Cliente> consultaCnpj(String str) throws SQLException{
        List<Cliente> clis = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from cliente where cnpj = '"+str+"'")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente(rs.getString("cnpj"), rs.getString("razaosocial"), rs.getString("nomefantasia"), rs.getString("inscricaoestadual"), rs.getString("telefone"), rs.getString("rua"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("uf"), rs.getString("observacoes"));
            clis.add(cli);
            }   
        }
       close();
        return clis; 
    }
    
    public List<Cliente> consultaRazaoSocial(String str) throws SQLException{
        List<Cliente> clis = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from cliente where razaosocial like '"+str+"%' order by razaosocial")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente(rs.getString("cnpj"), rs.getString("razaosocial"), rs.getString("nomefantasia"), rs.getString("inscricaoestadual"), rs.getString("telefone"), rs.getString("rua"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("uf"), rs.getString("observacoes"));
            clis.add(cli);
            }   
        }
       close();
        return clis; 
    }
    
    public List<Cliente> consultaTodos() throws SQLException{
        List<Cliente> clis = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from cliente order by razaosocial")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente(rs.getString("cnpj"), rs.getString("razaosocial"), rs.getString("nomefantasia"), rs.getString("inscricaoestadual"), rs.getString("telefone"), rs.getString("rua"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("uf"), rs.getString("observacoes"));
            clis.add(cli);
            }   
        }
       close();
        return clis; 
        
    }


    
}

