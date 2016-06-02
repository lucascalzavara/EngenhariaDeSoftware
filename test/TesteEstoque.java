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
import java.util.List;

/**
 *
 * @author koala_bolo
 */
public class TesteEstoque {
    
    public TesteEstoque() {
    }
    /*
    @Test
    public void testeEstoqueInsere(){
        Estoque c = new Estoque("a");
        assertTrue(c.insere());
    }
    */
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
    public void testeClienteConsultaTodos(){
        Estoque c = new Estoque();
        assertTrue(!c.ConsultaTodos().isEmpty());
    }
    /*
    @Test
    public void testeEstoqueConsultaCod(){
       Estoque c = new Estoque(2);
        assertTrue(c.ConsultaCod().getCod().equals(2));
    }
    */
    @Test
    public void testeClienteConsultaDescri(){
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
    }
    
    @AfterClass
    public static void tearDownClass() {
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