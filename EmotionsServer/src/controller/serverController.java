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
import so.user.SOReadUser;


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
     }
    
     
}