/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
***Código de criação das tabelas***

create table vendas (
	cnpjcliente varchar(18) not null,
	formapagamento varchar(9) not null,
	qtdparcelas int,
	valorparcela float,
	tipofrete varchar(22) not null,
	placaveiculo varchar(8),
	cnpjtransportadora varchar(18),
	data date not null,
	hora varchar(10) not null,
	numeropedido int primary key,
	valortotal float not null,
	desconto float,
	valorfinal float not null,
	adicional varchar(500),
	foreign key (cnpjcliente) references cliente (cnpj)
);


create table item_pedido(
	numerovenda int,
	codigoproduto int,
	quantidade int not null,
	valor float not null,
	foreign key (numerovenda) references vendas (numeropedido) on delete cascade,
	foreign key (codigoproduto) references estoque (cod),
	primary key (numerovenda, codigoproduto)
);

drop table item_pedido, vendas;

select * from vendas;
select * from item_pedido;


*/

package DAO;


import Programa.Cliente;
import Programa.Estoque;
import Programa.ItemPedido;
import Programa.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucas Calzavara
 */
public class DAOVendas extends Conexao {
    public void insere (Venda v) throws SQLException{
        up("insert into vendas (cnpjcliente, formapagamento, qtdparcelas, valorparcela, tipofrete, "+
                "placaveiculo, cnpjtransportadora, data, hora, numeropedido, valortotal, desconto, valorfinal, "+
                "adicional) values ('"+v.getCliente().getCnpj()+"', '"+v.getFormapagamento()+"', "
                + v.getQtdparcela()+", "+v.getValorparcela()+", '"+v.getTipofrete()+"', '"+
                v.getPlacaveiculo()+"', '"+v.getCnpjtransportadora()+"','"+v.getData()+"', '"+v.getHora()+"', "
                +v.getNumero()+", "+v.getValortodal()+", "+v.getDesconto()+", "+v.getValorfinal()+", "+
                "'"+v.getAdicional()+"')");
        for(int i = 0; i<v.getPedido().size(); i++){
            up("insert into item_pedido (numerovenda, codigoproduto, quantidade, valor)"
                    + "values ("+v.getNumero()+", "+v.getPedido().get(i).getEstoque().getCod()+","
                    +v.getPedido().get(i).getQuantidade()+","+v.getPedido().get(i).getValortotal()+")");
        }
    }
    
    public void exclui (int numero) throws SQLException{
        up("delete from vendas where numeropedido = "+numero);
    }
    
    public int consultaNumero() throws SQLException{
        int num = 0;
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select max(numeropedido) as max from vendas")) {
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                num = rs.getInt("max");
            } 
        }
       close();
       return num;
    }
    
    public ArrayList<Venda> consultaTodos() throws SQLException{
        ArrayList<Venda> vendas = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("select * from vendas, cliente where cnpjcliente=cnpj order by numeropedido")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Venda venda = new Venda(
                        new Cliente(rs.getString("cnpj"), 
                            rs.getString("razaosocial"), 
                            rs.getString("nomefantasia"), 
                            rs.getString("inscricaoestadual"), 
                            rs.getString("telefone"), 
                            rs.getString("rua"), 
                            rs.getString("bairro"), 
                            rs.getString("numero"), 
                            rs.getString("cidade"), 
                            rs.getString("uf"), 
                            rs.getString("observacoes")), 
                        
                        rs.getString("formapagamento"), 
                        rs.getInt("qtdparcelas"), 
                        rs.getFloat("valorparcela"), 
                        rs.getString("tipofrete"), 
                        rs.getString("placaveiculo"), 
                        rs.getString("cnpjtransportadora"), 
                        rs.getString("data"), 
                        rs.getString("hora"), 
                        rs.getInt("numeropedido"), 
                        rs.getString("adicional"),
                        rs.getFloat("desconto"),
                        rs.getFloat("valortotal"),
                        rs.getFloat("valorfinal"));
                vendas.add(venda);
            }
        }
        close();
        return vendas;
    }
    
    public ArrayList<Venda> consultaNumero(int num) throws SQLException{
        ArrayList<Venda> vendas = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("select * from vendas, cliente where cnpjcliente=cnpj and numeropedido = "+num)) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Venda venda = new Venda(
                        new Cliente(rs.getString("cnpj"), 
                            rs.getString("razaosocial"), 
                            rs.getString("nomefantasia"), 
                            rs.getString("inscricaoestadual"), 
                            rs.getString("telefone"), 
                            rs.getString("rua"), 
                            rs.getString("bairro"), 
                            rs.getString("numero"), 
                            rs.getString("cidade"), 
                            rs.getString("uf"), 
                            rs.getString("observacoes")), 
                        
                        rs.getString("formapagamento"), 
                        rs.getInt("qtdparcelas"), 
                        rs.getFloat("valorparcela"), 
                        rs.getString("tipofrete"), 
                        rs.getString("placaveiculo"), 
                        rs.getString("cnpjtransportadora"), 
                        rs.getString("data"), 
                        rs.getString("hora"), 
                        rs.getInt("numeropedido"), 
                        rs.getString("adicional"),
                        rs.getFloat("desconto"),
                        rs.getFloat("valortotal"),
                        rs.getFloat("valorfinal"));
                vendas.add(venda);
            }
        }
        close();
        return vendas;
    }
    
    public ArrayList<ItemPedido> consultaPedido(int numero) throws SQLException{
        ArrayList<ItemPedido> pedido = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("select * from item_pedido, vendas, estoque where numeropedido = numerovenda and codigoproduto=cod and numerovenda = "+numero+" order by descricao")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ItemPedido item = new ItemPedido(
                        rs.getInt("quantidade"),
                        rs.getFloat("valortotal"),
                        new Estoque(rs.getInt("cod"), 
                                rs.getFloat("valor"), 
                                rs.getInt("qtd"), 
                                rs.getInt("cdbarra"), 
                                rs.getString("marca"), 
                                rs.getString("descricao"), 
                                rs.getString("fornecedor"), 
                                rs.getFloat("precocusto"), 
                                rs.getString("un"), 
                                rs.getString("obs")));
                pedido.add(item);
            }
        }
        close();
        return pedido;
    }
    public ArrayList<Venda> consultaCliente(String razao) throws SQLException{
        ArrayList<Venda> vendas = new ArrayList<>();
        conec();
        try (PreparedStatement pstm = con.prepareStatement("select * from vendas, cliente where cnpjcliente=cnpj and razaosocial like '"+razao+"' order by razaosocial")) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Venda venda = new Venda(
                        new Cliente(rs.getString("cnpj"), 
                            rs.getString("razaosocial"), 
                            rs.getString("nomefantasia"), 
                            rs.getString("inscricaoestadual"), 
                            rs.getString("telefone"), 
                            rs.getString("rua"), 
                            rs.getString("bairro"), 
                            rs.getString("numero"), 
                            rs.getString("cidade"), 
                            rs.getString("uf"), 
                            rs.getString("observacoes")), 
                        
                        rs.getString("formapagamento"), 
                        rs.getInt("qtdparcelas"), 
                        rs.getFloat("valorparcela"), 
                        rs.getString("tipofrete"), 
                        rs.getString("placaveiculo"), 
                        rs.getString("cnpjtransportadora"), 
                        rs.getString("data"), 
                        rs.getString("hora"), 
                        rs.getInt("numeropedido"), 
                        rs.getString("adicional"),
                        rs.getFloat("desconto"),
                        rs.getFloat("valortotal"),
                        rs.getFloat("valorfinal"));
                vendas.add(venda);
            }
        }
        close();
        return vendas;
    }
    
}


