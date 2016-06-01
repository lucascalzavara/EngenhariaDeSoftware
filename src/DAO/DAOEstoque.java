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

/*
CREATE TABLE public.estoque
(
  cod integer NOT NULL,
  valor double precision NOT NULL,
  qtd integer NOT NULL,
  cdbarra integer,
  marca character varying(30) NOT NULL,
  descricao character varying(100),
  fornecedor character varying(19) NOT NULL,
  precocusto double precision,
  un character(3) NOT NULL,
  obs character(200),
  CONSTRAINT estoque_pkey PRIMARY KEY (cod),
  CONSTRAINT estoque_fornecedor_fkey FOREIGN KEY (fornecedor)
      REFERENCES public.fornecedor (cnpj) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
*/
public class DAOEstoque extends Conexao{
        
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
        try (PreparedStatement pstm = con.prepareStatement("Select * from estoque where descricao like '"+str+"%' order by razaosocial")) {
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
