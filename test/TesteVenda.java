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
        assertTrue(v.vendaConfirma());
    }
    /*
    @Test
    public void testeVendaInsereErrado(){
        Venda v = new Venda(new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste"), "À vista", 2, "Emitente", "AAA-1234", "11.222.333/4444-55", "25-02-2016", "08:23 - AM", 12345, "teste", 3);
        v.insereItemPedido(22, new Estoque(12345, 1234, 22, 78954, "teste", "teste", "99.888.777/6666-55", 2, "UN", "teste"));
        assertTrue(!v.vendaConfirma());
    }
    */
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
