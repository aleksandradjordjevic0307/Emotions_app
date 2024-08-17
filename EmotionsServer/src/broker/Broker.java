/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package broker;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import emotionstogether.AbstractDomainObject;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aleksandra
 */
public class Broker {
    
    private static Broker instance;
    private Connection connection;
    
    //konstruktor
    private Broker() {
        try {
            /*Properties properties = new Properties();
            properties.load(new FileInputStream("dbconfig.properties"));*/
            //String url = properties.getProperty("url");
            //String username = properties.getProperty("korisnickoIme");
            //String password = properties.getProperty("sifra");
            //connection = DriverManager.getConnection(url, username, password);
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Connection details
            String url = "jdbc:mysql://localhost:3306/emotions_db";
            String user = "root";
            String password = "";
            
            //establish the connection
            connection = DriverManager.getConnection(url, user, password);
             System.out.println("Konektovani na bazu.\n"); 
            /*This means that SQL statements are grouped into transactions that 
            must be explicitly committed. This provides more control over the transaction process.*/
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return connection;
    }

    public static Broker getInstance() {
        if (instance == null) {
            instance = new Broker();
        }
        return instance;
    }
    
    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println("Upit za insert: " + upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }
    
     public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " WHERE " + ado.uslovZaSelect();
        
        //SELECT * FROM users WHERE PASSWORD="user" AND USERNAME="user"
        System.out.println("Upit za select: " + upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.vratiListu(rs);
    }
     
      public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaUpdate() + " WHERE " + ado.uslovWhere();
        System.out.println("Upit za update: " + upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.uslovWhere();
        System.out.println("Upit za delete: " + upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

}
