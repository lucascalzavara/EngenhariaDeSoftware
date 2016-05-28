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
	hora varchar(8) not null,
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
	foreign key (numerovenda) references vendas (numero),
	foreign key (codigoproduto) references estoque (cod),
	primary key (numerovenda, codigoproduto)
);


*/

package DAO;

/**
 *
 * @author Lucas Calzavara
 */
public class DAOVendas extends Conexao {
    
}
