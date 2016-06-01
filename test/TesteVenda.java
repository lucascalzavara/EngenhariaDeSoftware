/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Programa.Cliente;
import Programa.Estoque;
import Programa.Fornecedor;
import Programa.Venda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Calzavara
 */
public class TesteVenda {
    
    public TesteVenda() {
    }
    
    @Test
    public void testeVendaInsere(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoFormaPagamento1(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoFormaPagamento2(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista1", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoQtdParcelas(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", -2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoTipoFrete(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitenate", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoPlacaVeiculo1(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "aaa-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoPlcaVeiculo2(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoPlacaVeiculo3(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoCnpjTransportadora(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.3334444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoData1(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-99-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoData2(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2a16", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoData3(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "99-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoHora1(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:3 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoHora2(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "8:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoHora3(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    @Test
    public void testeVendaInsereErradoNumero(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", -12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        v.calculaValores();
        assertTrue(!v.vendaConfirma());
    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste");
        c.insere();
        Fornecedor f = new Fornecedor("99.888.777/6666-55", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12,34","teste");
        f.insere();
        Estoque e = new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste");
        e.insere();
    }
    
    @AfterClass
    public static void tearDownClass() {
        Venda v = new Venda(12345);
        v.exclui();
        new Cliente("12.345.678/9012-34").exclui();
        Estoque e = new Estoque();
        e.setCod(12345);
        e.exclui();
        new Fornecedor("99.888.777/6666-55").exclui();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
