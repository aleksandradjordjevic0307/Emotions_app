/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import java.util.ArrayList;
import so.AbstractSO;
import emotionstogether.AbstractDomainObject;
import emotionstogether.User;



/**
 *
 * @author Aleksandra
 */
public class SOLogIn extends AbstractSO {
    User ulogovan;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof User)) {
            throw new Exception("Prosledjeni objekat nije instanca klase User!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        User u = (User) ado;

        ArrayList<User> korisnici
                = (ArrayList<User>) (ArrayList<?>) broker.Broker.getInstance().select(ado);

        for (User user : korisnici) {
            if (user.getUsername().equals(u.getUsername())
                    && user.getPassword().equals(u.getPassword())) {
                ulogovan = user;
                return;
            }
        }

        //ove bi trebalo da se na kraju postavi JOptionPane koji govori korisniku da ne postoji korisnik sa kredencijalima
        throw new Exception("Ne postoji korisnik sa tim kredencijalima.");
        
        
    }

    public User getUlogovani() {
        return ulogovan;
    }
    
}
