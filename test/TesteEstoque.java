/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Programa.Estoque;
import DAO.DAOEstoque;
import Programa.Fornecedor;
import java.util.List;

/**
 *
 * @author koala_bolo
 */
public class TesteEstoque {
    
    public TesteEstoque() {
    }
    
    @Test
    public void testeEstoqueInsere(){
        Estoque c = new Estoque(1,1,1,1, "a", "a", "11.111.111/1111-11", 1, "a", "a");
        assertTrue(c.insere());
    }
    
    @Test
    public void testeEstoqueInsereErradoValor(){
        Estoque c = new Estoque(1,-1,1,1, "a", "a", "a", 1, "a", "a");
        assertTrue(!c.insere());
    }
    @Test
    public void testeEstoqueInsereErradoCod(){
        Estoque c = new Estoque(-1,1,1,1, "a", "a", "a", 1, "a", "a");
        assertTrue(!c.insere());
    }
    @Test
    public void testeEstoqueInsereErradoQtd(){
        Estoque c = new Estoque(1,1,-1,1, "a", "a", "a", 1, "a", "a");
        assertTrue(!c.insere());
    }
    @Test
    public void testeEstoqueInsereErradoCdbarra(){
        Estoque c = new Estoque(1,1,1,-1, "a", "a", "a", 1, "a", "a");
        assertTrue(!c.insere());
    }
    @Test
    public void testeEstoqueInsereErradoPreco(){
        Estoque c = new Estoque(1,1,1,1, "a", "a", "a", -1, "a", "a");
        assertTrue(!c.insere());
    }
    
  
    @Test
    public void testeEstoqueConsultaTodos(){
        Estoque c = new Estoque();
        assertTrue(!c.ConsultaTodos().isEmpty());
    }
    
    @Test
    public void testeEstoqueConsultaCod(){
       Estoque c = new Estoque(1);
        assertTrue(c.ConsultaCod().get(0).getCod()==1);
    }
    
    @Test
    public void testeEstoqueConsultaDescri(){
        Estoque c = new Estoque("a");
        assertTrue(!c.ConsultaDescricao().isEmpty());
    }
    
    @Test
    public void testeEstoqueExclui(){
        Estoque c = new Estoque(1);
        assertTrue(c.exclui());
    }
    
    @BeforeClass
    public static void setUpClass() {
        Fornecedor a = new Fornecedor ("11.111.111/1111-11","a","a","12","(44)4444-4444","a","a","11","a","UF","1.11","a");
        a.insere();
    }
    
    @AfterClass
    public static void tearDownClass() {
        Fornecedor a = new Fornecedor ("11.111.111/1111-11","a","a","12","(44)4444-4444","a","a","11","a","UF","1.11","a");
        a.exclui();
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