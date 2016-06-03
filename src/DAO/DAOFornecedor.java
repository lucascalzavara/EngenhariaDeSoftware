/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
CREATE TABLE public.fornecedor
(
  cnpj character varying(50) NOT NULL,
  razaosocial character varying(100) NOT NULL,
  nomefantasia character varying(100) NOT NULL,
  inscricaoestadual character varying(50),
  telefone character varying(13),
  cidade character varying(50),
  uf character varying(20),
  rua character varying(50) NOT NULL,
  bairro character varying(50) NOT NULL,
  numero character varying(10),
  pedidominimo character varying(10),
  observacoes character varying(200),
  CONSTRAINT fornecedor_pkey PRIMARY KEY (cnpj)
)
*/

package DAO;

import Programa.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOFornecedor extends Conexao{
       
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
    
    public List<Fornecedor> consultaCnpj(String str) throws SQLException{
        List<Fornecedor> forn = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select * from fornecedor where cnpj = '"+str+"'")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Fornecedor cli = new Fornecedor(rs.getString("cnpj"), rs.getString("razaosocial"), rs.getString("nomefantasia"), rs.getString("inscricaoestadual"), rs.getString("telefone"), rs.getString("rua"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cidade"), rs.getString("uf"), rs.getString("pedidominimo"), rs.getString("observacoes"));
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


    
}