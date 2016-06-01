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
import Programa.Cliente;
import DAO.DAOCliente;
import java.util.List;

/**
 *
 * @author Lucas Calzavara
 */
public class TesteCliente {
    
    public TesteCliente() {
    }
    
    @Test
    public void testeClienteInsere(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste");
        assertTrue(c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoCnpj(){
        Cliente c = new Cliente("12.345.678/9012-3a", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoCnpj2(){
        Cliente c = new Cliente("12.345.678/901234", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoInscricao(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "1a23456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoTel1(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(123456-7890", "teste", "teste", "123", "teste", "TS", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoTel2(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(a2)3456-7890", "teste", "teste", "123", "teste", "TS", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoNum(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "1a23", "teste", "TS", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoCidade(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "test45e", "TS", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoUf1(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "T1", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteInsereErradoUf2(){
        Cliente c = new Cliente("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "Ts", "teste");
        assertTrue(!c.insere());
    }
    
    @Test
    public void testeClienteConsultaTodos(){
        Cliente c = new Cliente();
        assertTrue(!c.ConsultaTodos().isEmpty());
    }
    
    @Test
    public void testeClienteConsultaCnpj(){
        Cliente c = new Cliente("12.345.678/9012-34");
        assertTrue(c.ConsultaCnpj().get(0).getCnpj().equals("12.345.678/9012-34"));
    }
    
    @Test
    public void testeClienteConsultaRazao(){
        Cliente c = new Cliente("teste", 1);
        assertTrue(!c.ConsultaRazao().isEmpty());
    }
    
    @Test
    public void testeClienteExclui(){
        Cliente c = new Cliente("12.345.678/9012-34");
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
