/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author Lucas Calzavara
 */
public class ItemPedido {
    int quantidade;
    float valortotal;
    Estoque estoque;

    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public ItemPedido(int quantidade, Estoque estoque) {
        this.quantidade = quantidade;
        this.estoque = estoque;
        this.valortotal = quantidade*estoque.getValor();
    }

    public ItemPedido(int quantidade, float valortotal, Estoque estoque) {
        this.quantidade = quantidade;
        this.valortotal = valortotal;
        this.estoque = estoque;
    }

    
    
    
    
}
