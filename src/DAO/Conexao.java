/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Calzavara
 */
public class Conexao {
    private final String nome = "postgres";
    private final String senha = "root";
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String driver = "org.postgresql.Driver";
    Connection con;
    private Statement stm;
    private ResultSet res;
    
    public void conec(){
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url, nome, senha);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erro: "+e);
        }
    }
        
    public void close(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void up(String sql) throws SQLException{
        conec();
        stm = con.createStatement();
        stm.executeUpdate(sql);
        close();
    }
}
