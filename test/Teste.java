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
import Programa.PessoaJuridica;
import java.util.List;

/**
 *
 * @author Lucas Calzavara
 */
public class Teste {
    
    public Teste() {
    }
    
    @Test
    public void teste(){
        Cliente c = new Cliente("1","1","1","1","1","1","1","1","1","1","1");
        DAOCliente con = new DAOCliente();
        try {
            con.insere(c);
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            assertEquals(c.getNomefantasia(), con.consulta(c.getNomefantasia()).getNomefantasia());
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    @After
    public void AfterTeste(){
        DAOCliente d = new DAOCliente();
        try {
            d.exclui("1");
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void teste1(){
        DAOCliente con = new DAOCliente();
        try {
            con.consulta("1");
        } catch (SQLException ex) {
            assertFalse(ex.getMessage().isEmpty());
        }  
    }
    
    @Test
    public void teste2(){
        Cliente c = new Cliente("12.345.678/0001-101","1","1","1","1","1","1","1","1","1","1");
        DAOCliente con = new DAOCliente();
        try {
            con.insere(c);
        } catch (SQLException ex) {
            assertFalse(ex.getMessage().isEmpty());
        }
        
    }
    @Test
    public void test3(){
        PessoaJuridica c = new PessoaJuridica();
        assertTrue(c.validaCnpj("12.345.678/0001-101"));
    
    }
    
    @Test
    public void teste8(){
        Cliente c = new Cliente("1","1","1","1","1","1","1","1","1","1","1");
        DAOCliente con = new DAOCliente();
        try {
            con.insere(c);
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.setCidade("2");
        try {
            con.atualiza(c);
            assertEquals("2", con.consulta("1").getCidade());
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    @After
    public void AfterTeste3(){
        DAOCliente d = new DAOCliente();
        try {
            d.exclui("1");
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void teste4(){
        DAOCliente con = new DAOCliente();
        try {
            List<Cliente> consultaTodos = con.consultaTodos();
            assertFalse(consultaTodos.isEmpty());
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void teste5(){
        DAOCliente con = new DAOCliente();
        try {
            List<Cliente> consulta = con.consultaRazaoSocial("1");
            assertFalse(consulta.isEmpty());
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
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
