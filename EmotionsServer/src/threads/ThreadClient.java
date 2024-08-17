/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import communication.Operation;
import communication.Request;
import communication.Response;
import communication.ResponseStatus;
import controller.serverController;
import emotionstogether.Emotion;
import emotionstogether.User;


/**
 *
 * @author Aleksandra
 */
public class ThreadClient extends Thread{
    
    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                System.out.println("Server je primio podatke iz zahteva");
                Request request = (Request) in.readObject();
                System.out.println("Zahtev:" + request);
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
                System.out.println("Serverov odgovor iz threadClient: " + response);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request){
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            System.out.println(request.getOperation());
            switch(request.getOperation()) {
                case Operation.SO_CREATE_USER:
                    serverController.getInstance().addUser((User) request.getData());
                    System.out.println("Primljeni podaci od klijenta za dodavanje korisnika");
                    break;
                case Operation.SO_DELETE_USER:
                    //dodaj
                    serverController.getInstance().deleteUser((User) request.getData());
                    System.out.println("Primljeni podaci za brisanje korisnika");
                    break;
                case Operation.SO_READ_USER:
                    //dodaj
                    //serverController.getInstance().login((User)request.getData()); 
                    System.out.println("Primljeni podaci od klijenta za citanje korisnika");
                    break;
                case Operation.SO_UPDATE_USER:
                    //dodaj
                    serverController.getInstance().updateUser((User) request.getData());
                    System.out.println("Primljeni podaci za izmenu korisnika u thread client");
                    break;
                case Operation.SO_LOGIN:
                    User u = serverController.getInstance().login((User)request.getData());
                    response.setData(u);
                    System.out.println("Primljeni podaci od klijenta za logovanje korisnika");
                    break;
                case Operation.SO_CREATE_EMOTION:
                    serverController.getInstance().addEmotion((Emotion)request.getData());
                    System.out.println("Primljeni podaci od klijenta za dodavanje emocije");
                    break;
                default:
                    return null;
                        
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }
    
}
