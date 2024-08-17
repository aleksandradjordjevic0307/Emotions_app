/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.user;

import broker.Broker;
import emotionstogether.AbstractDomainObject;
import emotionstogether.User;
import java.util.ArrayList;
import so.AbstractSO;


/**
 *
 * @author Aleksandra
 */
public class SOUpdateUser extends AbstractSO{

    
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof User)) {
            throw new Exception("Prosledjeni objekat nije instanca klase User!");
        }
        User u = (User) ado;

        ArrayList<User> korisnici = (ArrayList<User>) (ArrayList<?>) Broker.getInstance().select(ado);

        for (User user : korisnici) {
            if (!user.getUsername().equals(u.getNoviUsername())) {
                    throw new Exception("Korisnik sa tim kredencijalima vec postoji!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Broker.getInstance().update(ado);
    }
    
}
