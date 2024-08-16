/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Aleksandra
 */
public class ThreadServer extends Thread{
    
    private ServerSocket serverSocket;
    
    public ThreadServer() {
        try {
            serverSocket = new ServerSocket(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            System.out.println("Startovao je server");
        while(!serverSocket.isClosed()){
           
            Socket socket = serverSocket.accept();
            ThreadClient thread = new ThreadClient(socket);
            System.out.println("Dosao je klijent");
            thread.start();
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    
}
