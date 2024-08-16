/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesija;

import emotionstogether.User;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Aleksandra
 */
public class Session {
    
    private static Session instance;
    private Socket socket;
    private User ulogovani;

    private Session() {
        try {
            System.out.println("Kreiranje soketa");
            socket = new Socket("localhost", 10000);
            System.out.println("Soket kreiran");
        } catch (IOException ex) {
            System.out.println("Greska u sesiji");
        }
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        System.out.println("Napravljena instanca sesije");
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(User ulogovani) {
        this.ulogovani = ulogovani;
        System.out.println("Ulogovani user: " + ulogovani);
    }

    public User getUlogovani() {
        return ulogovani;
    }
    
}
