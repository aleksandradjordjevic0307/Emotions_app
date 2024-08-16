/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.user;
import emotionstogether.AbstractDomainObject;
import so.AbstractSO;
import emotionstogether.User;
import java.util.ArrayList;
import broker.Broker;





/**
 *
 * @author Aleksandra
 */
public class SOCreateUser extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof User)){
            throw new Exception("Uneti objekat nije klase User!");
        }
        
        User u = (User) ado;
        //sada je potrebno da prodjemo kroz listu svih korisnika da proverimo da li
        //vec postoji uneto korisnicko ime
        ArrayList<User> korisnici = (ArrayList<User>)(ArrayList<?>) Broker.getInstance().select(ado);
        for(User korisnik : korisnici){
            if(korisnik.getUsername().equals(u.getUsername())){
                throw new Exception("Vec postoji korisnik sa unetim korisnickim imenom"); 
                
            }
        }
         
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Broker.getInstance().insert(ado);
    }
       
}
