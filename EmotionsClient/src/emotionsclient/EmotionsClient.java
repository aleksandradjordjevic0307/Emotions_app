/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package emotionsclient;
import java.io.*;
import java.net.*;
import ui.PocetnaFormaKlijent;
/**
 *
 * @author Aleksandra
 */
public class EmotionsClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here



        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 10000;

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server: " + socket);

            // Input stream to receive data from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Output stream to send data to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send message to server
            out.println("Hello from client");

            // Receive echo message from server
            String response = in.readLine();
            System.out.println("Received from server: " + response);
            
            PocetnaFormaKlijent mf = new PocetnaFormaKlijent();
            mf.setVisible(true);

            // Close streams and socket
            /*in.close();
            out.close();
            socket.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
