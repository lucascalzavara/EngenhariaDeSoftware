/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import Interface.InterfaceLocalizaCliente;
import java.util.ArrayList;

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
    float valortodal;
    float desconto;
    float valorfinal;
    String adicional;
    ArrayList<Estoque> pedido;

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
        return valortodal;
    }

    public void setValortodal(float valortodal) {
        this.valortodal = valortodal;
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

    
    

    public Venda() {
    }
    
    public void selecionaCliente(){
        
    }
}
