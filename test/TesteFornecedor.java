/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Programa.Fornecedor;
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
public class TesteFornecedor {
    
    public TesteFornecedor() {
    }
    
    @Test
    public void testeFornecedorInsere(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12,34","teste");
        assertTrue(f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoCnpj1(){
        Fornecedor f = new Fornecedor("1a.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoCnpj2(){
        Fornecedor f = new Fornecedor("12.345.678/901234", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoInscricao(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "12345a6", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoTel1(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(1a)3456-7890", "teste", "teste", "123", "teste", "TS", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoTel2(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)345-7890", "teste", "teste", "123", "teste", "TS", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoNum(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "1a23", "teste", "TS", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoUf1(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "aS", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradUf2o(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "T4", "12,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoPreco1(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12a,34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoPreco2(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12,","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorInsereErradoPreco3(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34", "teste", "teste", "123456", "(12)3456-7890", "teste", "teste", "123", "teste", "TS", "12.34","teste");
        assertTrue(!f.insere());
    }
    
    @Test
    public void testeFornecedorConsultaTodos(){
        Fornecedor f = new Fornecedor();
        assertTrue(!f.ConsultaTodos().isEmpty());
    }
    
    @Test
    public void testeFornecedorConsultaCnpj(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34");
        assertTrue(f.ConsultaCnpj().get(0).getCnpj().equals("12.345.678/9012-34"));
    }
    
    @Test
    public void testeFornecedorConsultaRazao(){
        Fornecedor f = new Fornecedor("teste", 1);
        assertTrue(!f.ConsultaRazao().isEmpty());
    }
    
    @Test
    public void testeFornecedorExclui(){
        Fornecedor f = new Fornecedor("12.345.678/9012-34");
        assertTrue(f.exclui());
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
