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
    private int user_id;

  
    public Emotion() {
    }

    public Emotion(Date date, String emotion, int user_id) {
        this.date = date;
        this.emotion = emotion;
        this.user_id = user_id;
    }

     public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
  
    public Date getDate() {
        return date;
    }

    public String getEmotion() {
        return emotion;
    }
    

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    
    @Override
    public String nazivTabele() {
       return "emotions";
    }

    @Override
    public String koloneZaInsert() {
        return "(user_id, emotion, date)";
    }

    @Override
    public String vrednostiZaInsert() {
            return "'" + user_id + "'" + ", "+ "'" + emotion + "'" + ", " + "'" + date + "'";
            
            
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
       return  "User_id = '" + user_id + "'";
               //+ "AND" + "Date='" + date + "'";
     
       
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Emotion e = new Emotion(rs.getDate("date"),
                    rs.getString("emotion"),
                   rs.getInt("user_id"));
                    

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
        return "user_id = '" + user_id; 
    }
    
 
    
}
