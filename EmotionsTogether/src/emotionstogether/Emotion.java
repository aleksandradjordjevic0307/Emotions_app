/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionstogether;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Aleksandra
 */
public class Emotion extends AbstractDomainObject{
    
       private Date date;
    private String emotion;
    private String username;
    
    public Emotion() {
    }

    public Emotion(Date date, String emotion, String username) {
        this.date = date;
        this.emotion = emotion;
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    @Override
    public String nazivTabele() {
       return "emotions";
    }

    @Override
    public String koloneZaInsert() {
        return "(emotion, date, username)";
    }

    @Override
    public String vrednostiZaInsert() {
            return "'" + emotion + "'" + ", "+ "'" + date + "'" + ", " + "'" + username + "'";        
    }

    @Override
    public String alijasTabele() {
        return "e";
    }

    @Override
    public String join() {
       return "";
    }

    @Override
    public String uslovZaSelect() {
       return  "Username = '" + username + "'";
               //+ "AND" + "Date='" + date + "'";     
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Emotion e = new Emotion(rs.getDate("emotion"),
                    rs.getString("date"),
                   rs.getString("username"));
                    
            lista.add(e);
        }

        rs.close();
        return lista;
    }

    @Override
    public String vrednostiZaUpdate() {
          return " emotion = '" + emotion + "', date = '" + date;
          
    }

    @Override
    public String uslovWhere() {
        return "Username = '" + username; 
    }
    
 
    
}
