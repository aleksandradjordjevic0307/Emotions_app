/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Request;
import communication.Response;
import communication.ResponseStatus;
import emotionstogether.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import communication.Operation;
import emotionstogether.Emotion;

/**
 *
 * @author Aleksandra
 */
public class ClientController {
    
     private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }
    
     private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

         System.out.println("Salje se zahtev serveru");
        
        ObjectOutputStream out = new ObjectOutputStream(sesija.Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);
         System.out.println("Poslat zahtev serveru");

        ObjectInputStream in = new ObjectInputStream(sesija.Session.getInstance().getSocket().getInputStream());
         Response response = (Response) in.readObject();
         //System.out.println(in.readObject());
         System.out.println("Primljen odgovor od servera");
         System.out.println("Podaci iz serverovog odgovora: " + data.toString());
         //User u = (User) data;
         //System.out.println("Korisnikov username iz clientController: " + ugetUsername());

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            System.out.println("prvo");
            throw response.getException(); 
        } else {
            System.out.println("drugo");
            return response.getData();   
        }

    }
    
    public void addUser(User user) throws Exception {
        System.out.println("Stigao u client controller i treba da posalje zahtev za dodavanje user-a");
        sendRequest(Operation.SO_CREATE_USER, user);
    }
    
    public void readUser(User user) throws Exception{
        System.out.println("Stigao u client controller i treba da procita korisnika");
        sendRequest(Operation.SO_READ_USER, user);
    }
    
    public void updateUser(User user) throws Exception{
        System.out.println("Stigao u client controller i treba da posalje zahtev za update korisnika");
        System.out.println("Novi username: " + user.getNoviUsername() + ", stari username: " + user.getUsername());
        sendRequest(Operation.SO_UPDATE_USER, user);
    }
    public void deleteUser(User user) throws Exception{
        System.out.println("Stigao u client controller i treba da posalje zahtev za brisanje korisnika");
        sendRequest(Operation.SO_DELETE_USER, user);
    }
    
    public User login(User user) throws Exception {
        System.out.println("Stigao u client controller i treba da posalje zahtev za login korisnika");
        return (User) sendRequest(Operation.SO_LOGIN, user);
    }
    
    public void addEmotion(Emotion e) throws Exception{
        System.out.println("Stigao u client controller i treba da posalje zahtev za dodavanje emocije");
        sendRequest(Operation.SO_CREATE_EMOTION, e);
    }
}
