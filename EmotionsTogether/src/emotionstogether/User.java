/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionstogether;

//import controller.serverController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Aleksandra
 */
public class User extends AbstractDomainObject{
    
    private String username;
    private String password;

    public void setNoviUsername(String noviUsername) {
        this.noviUsername = noviUsername;
    }

    public void setNoviPassword(String noviPassword) {
        this.noviPassword = noviPassword;
    }

    public String getNoviUsername() {
        return noviUsername;
    }

    public String getNoviPassword() {
        return noviPassword;
    }
    private String noviUsername;
    private String noviPassword;
    private int id;

    
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String nazivTabele() {
        return "users";
    }

    @Override
    public String koloneZaInsert() {
        return "(username, password)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + username + "'" + ", " + "'" + password + "'";
    }

    @Override
    public String alijasTabele() {
        return "u";
    }

    @Override
    public String join() {
        return " JOIN EMOTIONS E ON (E.USERNAME = U.USERNAME) ";
    }

    @Override
    public String uslovZaSelect() {
        return "username = '" + username + "'";
        //AND Password = '" + password + "' "
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
       //nemamo u aplikaciji nikakvo vracanje svih korisnika
       //int rowCount = 0;
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        System.out.println(rs);
        /*while (rs.next()) {
                rowCount++;
            }*/
        System.out.println("Dodavanje korisnika u listu");
        while (rs.next()) {
            User u = new User(rs.getString("username"), rs.getString("password"));
            lista.add(u);
            System.out.println("Korisnik dodat u listu");
        }

        rs.close();
        
       return lista;
    }

    @Override
    public String vrednostiZaUpdate() {
         return "username = '" + noviUsername + "', password = '" + noviPassword + "' ";
    }

    @Override
    public String uslovWhere() {
        return "username = '" + username + "' ";
    }

   
   
    
    
    
}
