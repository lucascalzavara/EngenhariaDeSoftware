/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import DAO.DAOEstoque;
import DAO.DAOVendas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Calzavara
 */
public class Venda {
    Cliente cliente;
    String formapagamento;
    int qtdparcela;
    float valorparcela;
    String tipofrete;
    String placaveiculo;
    String cnpjtransportadora;
    String data;
    String hora;
    int numero;
    float valortotal=0;
    float desconto=0;
    float valorfinal=0;
    String adicional;
    ArrayList<ItemPedido> pedido = new ArrayList<>();

    public Venda(Cliente cliente, String formapagamento, int qtdparcela, float valorparcela, String tipofrete, String placaveiculo, String cnpjtransportadora, String data, String hora, int numero, String adicional, float desconto, float valortotal, float valorfinal) {
        this.cliente = cliente;
        this.formapagamento = formapagamento;
        this.qtdparcela = qtdparcela;
        this.valorparcela = valorparcela;
        this.tipofrete = tipofrete;
        this.placaveiculo = placaveiculo;
        this.cnpjtransportadora = cnpjtransportadora;
        this.data = data;
        this.hora = hora;
        this.numero = numero;
        this.adicional = adicional;
        this.desconto=desconto;
        this.valorfinal=valorfinal;
        this.valortotal=valortotal;
    }
    
    public Venda(int numero){
        this.numero=numero;
    }
    
    public Venda (String razaoSocial){
        this.cliente = new Cliente(razaoSocial, 1);
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public int getQtdparcela() {
        return qtdparcela;
    }

    public void setQtdparcela(int qtdparcela) {
        this.qtdparcela = qtdparcela;
    }

    public float getValorparcela() {
        return valorparcela;
    }

    public void setValorparcela(float valorparcela) {
        this.valorparcela = valorparcela;
    }

    public String getTipofrete() {
        return tipofrete;
    }

    public void setTipofrete(String tipofrete) {
        this.tipofrete = tipofrete;
    }

    public String getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(String placaveiculo) {
        this.placaveiculo = placaveiculo;
    }

    public String getCnpjtransportadora() {
        return cnpjtransportadora;
    }

    public void setCnpjtransportadora(String cnpjtransportadora) {
        this.cnpjtransportadora = cnpjtransportadora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getValortodal() {
        return valortotal;
    }

    public void setValortodal(float valortodal) {
        this.valortotal = valortodal;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(float valorfinal) {
        this.valorfinal = valorfinal;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public ArrayList<ItemPedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<ItemPedido> pedido) {
        this.pedido = pedido;
    }
    
    

    public boolean insereItemPedido(int quantidade, Estoque estoque){
        if(verificaItemPedido(estoque.getCod())){
            pedido.add(new ItemPedido(quantidade, estoque));
            calculaValores();
            return true;
        }
        return false;
    }
    
    public void calculaValores(){
        valortotal=0;
        for (int i = 0; i < pedido.size(); i++){
            valortotal+=pedido.get(i).valortotal;
        }
        if(desconto>valortotal)
            desconto=0;
        valorfinal=valortotal-desconto;
        
        if(qtdparcela > 0){
            valorparcela = valorfinal/qtdparcela;
        }
    }
    
    public boolean verificaItemPedido(int cod){
        for (int i = 0; i < pedido.size(); i++)
            if(pedido.get(i).getEstoque().getCod() == cod)
                return false;
        return true;
    }
    
    public boolean removeItemPedido(int i){
        if(i>=0 && i<pedido.size()){  
            pedido.remove(i);
            calculaValores();
            return true;
        }
        return false;
    }
    
    public boolean calculaDesconto(float desconto){
        if(desconto<0 || desconto > valortotal)
            return false;
        else{
            this.desconto=desconto;
            calculaValores();
            return true;
        }
    }
    
    public boolean calculaParcela(int qtd){
        if(qtd < 1){
            return false;
        }else{
            qtdparcela=qtd;
            valorparcela=valorfinal/qtd;
            return true;
        }
    }
    
    public void consultarNumero(){
        DAOVendas con = new DAOVendas();
        try {
            numero=con.consultaNumero()+1;
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean vendaConfirma(){
        DAOVendas con = new DAOVendas();
        DAOEstoque est = new DAOEstoque();
        try {
            atualizaEstoque();
            con.insere(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void atualizaEstoque() throws SQLException{
        DAOEstoque e = new DAOEstoque();
        for(int i = 0; i<pedido.size(); i++){
            e.atualizaQuantidade(pedido.get(i).getEstoque().getCod(), pedido.get(i).getEstoque().getQtd()-pedido.get(i).getQuantidade());
        }
    }
    
    public ArrayList<Venda> consultaTodos(){
        DAOVendas v = new DAOVendas();
        ArrayList<Venda> vendas = null;
        try{
            vendas = v.consultaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
    
    public ArrayList<Venda> consultaNumero(){
        DAOVendas v = new DAOVendas();
        ArrayList<Venda> vendas = null;
        try {
            vendas = v.consultaNumero(numero);
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
    
    public ArrayList<Venda> consultaCliente(){
        DAOVendas v = new DAOVendas();
        ArrayList<Venda> vendas = null;
        try{
            vendas = v.consultaCliente(cliente.getRazaosocial());
        } catch (SQLException ex){
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
    
    public void consultaPedido(){
        DAOVendas v = new DAOVendas();
        try {
            pedido = v.consultaPedido(numero);
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean exclui(){
        DAOVendas v = new DAOVendas();
        try {
            v.exclui(numero);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    

    public Venda() {
        consultarNumero();
    }
}
