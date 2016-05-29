/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import DAO.DAOVendas;
import Interface.InterfaceLocalizaCliente;
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
        try {
            con.insere(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Venda() {
        consultarNumero();
    }
}
