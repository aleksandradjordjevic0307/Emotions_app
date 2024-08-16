/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package emotionsserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import database.DataBaseMethods;
//import ui.MainForm;

/**
 *
 * @author Aleksandra
 */
public class EmotionsServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        
        DataBaseMethods dbm = new DataBaseMethods();
        Connection conn = dbm.connectToDatabase();
   
             
        //Starting the main form
       /* MainForm mf = new MainForm();
        mf.setVisible(true);*/
       
         
        final int PORT = 10000;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started, waiting for client...");

            Socket clientSocket = serverSocket.accept();
            //System.out.println("Client connected: " + clientSocket);*/

            // Input stream to receive data from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Output stream to send data to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from client: " + message);
                // Echo the message back to client
                out.println("Hello from server" );
            }

            // Close streams and socket
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    
    
    
}