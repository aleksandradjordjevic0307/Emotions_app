/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import emotionstogether.User;
import so.login.SOLogIn;
import so.user.SOCreateUser;
import so.emotions.SOCreateEmotion;
import emotionstogether.Emotion;
import so.user.SODeleteUser;
import so.user.SOReadUser;
import so.user.SOUpdateUser;


/**
 *
 * @author Aleksandra
 */
public class serverController{
    
    private static serverController instance;

    public serverController() {
    }
    
    public static serverController getInstance() {
        if (instance == null) {
            instance = new serverController();
        }
        return instance;
    }
    
    public User login(User user) throws Exception {
        SOLogIn so = new SOLogIn();
        so.templateExecute(user);
        return so.getUlogovani();
    }
    
     public void addUser(User user) throws Exception {
         (new SOCreateUser()).templateExecute(user);
    }
     
    public User readUser(User user) throws Exception{
        SOReadUser so = new SOReadUser();
        so.templateExecute(user);
        System.out.println("Iscitani korisnik: " + user.getUsername());
        return user;
    }
     
     public void addEmotion(Emotion emotion) throws Exception{
         (new SOCreateEmotion()).templateExecute(emotion);
         System.out.println("Dodavanje emocije server controller");
     }
     
     public void updateUser(User u) throws Exception{
         SOUpdateUser so = new SOUpdateUser();
         so.templateExecute(u);
         System.out.println("Korisnik je promenjen iz serverController");
     }
    
     public void deleteUser (User u) throws Exception{
         SODeleteUser so = new SODeleteUser();
         so.templateExecute(u);
         System.out.println("Brisanje korisnika server controller");
     }
     
}
