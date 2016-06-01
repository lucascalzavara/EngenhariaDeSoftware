/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author Michel
 */
public class PessoaJuridica {

    String cnpj;
    String razaosocial;
    String nomefantasia;
    String inscricaoestadual;
    String telefone;
    String rua;
    String bairro;
    String numero;
    String cidade;
    String uf;
    String observacoes;

    public boolean validaDados(){
        if(!cnpj.matches("[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}"))
            return false;
        if(!inscricaoestadual.isEmpty())
            if(!inscricaoestadual.matches("[0-9]+"))
                return false;
        if(!telefone.isEmpty()||!telefone.equals("(  )    -    "))
            if(!telefone.matches("\\([0-9]{2}\\)[0-9]{4}-[0-9]{4}"))
                return false;
        if(!numero.matches("[0-9]+"))
            return false;
        if(!cidade.matches("[a-zA-Z]+"))
            return false;
        if(!uf.matches("[A-Z]{2}"))
            return false;
        return true;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    

}
