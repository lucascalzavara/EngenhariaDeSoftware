/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
***Código de criação das tabelas***

create table vendas (
	cnpjcliente varchar(18) not null,
	formapagamento varchar(7) not null,
	qtdparcelas int,
	valorparcela float,
	tipofrete varchar(22) not null,
	placaveiculo varchar(8),
	cnpjtransportadora varchar(18),
	data date not null,
	hora varchar(10) not null,
	numero int primary key,
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
	foreign key (numerovenda) references vendas (numero) on delete cascade,
	foreign key (codigoproduto) references estoque (cod),
	primary key (numerovenda, codigoproduto)
);

drop table item_pedido, vendas;

select * from vendas;
select * from item_pedido;


*/

package DAO;


import Programa.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas Calzavara
 */
public class DAOVendas extends Conexao {
    public void insere (Venda v) throws SQLException{
        up("insert into vendas (cnpjcliente, formapagamento, qtdparcelas, valorparcela, tipofrete, "+
                "placaveiculo, cnpjtransportadora, data, hora, numero, valortotal, desconto, valorfinal, "+
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
    
    public void exclui (String numero) throws SQLException{
        up("delete from vendas where numero = "+numero);
    }
    
    public int consultaNumero() throws SQLException{
        int num = 0;
        conec();
        try (PreparedStatement pstm = con.prepareStatement("Select max(numero) as max from vendas")) {
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                num = rs.getInt("max");
            } 
        }
       close();
       return num;
    }
}
