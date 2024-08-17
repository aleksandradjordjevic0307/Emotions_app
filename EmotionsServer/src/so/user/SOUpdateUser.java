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
        System.out.println("------------------------------------------\nStigao u validate SOUpdateUser");
        if (!(ado instanceof User)) {
            throw new Exception("Prosledjeni objekat nije instanca klase User!");
        }
        /*OBJASNJENJE: 
        -pravim korisnika u koji ce prosledjeni ado da se ucita; taj ado sadrzi 
        svoj stari username, novi username, stari password i novi password*/
        User u = (User) ado;
       
        
        
        //pravim novog korisnika sa novim usernaemom i passwordom ado-a
        //i transformisem ga u ado, jer select priam ado. Select gleda username
        //sto je u nasem slucaju stari username za gornji ado, i zato ne moze da se izvrsi
        //pa zato mu prosledjujemo usera koji ima kredencijale koji su zapravo novi kredencijali gornjeg ado
        //i onda taj select proverava da li taj user postoji u bazi, ako ne postoji, dozvolice izvrsavanje
        User novi = new User();
        novi.setUsername(u.getNoviUsername());
        novi.setPassword(u.getNoviPassword());
        AbstractDomainObject novi_ado = (AbstractDomainObject) novi;
        
        ArrayList<User> korisnici = (ArrayList<User>) (ArrayList<?>) Broker.getInstance().select(novi_ado);
        
        for (User user : korisnici) {
    
            if (user.getUsername().equals(novi.getUsername())) {
                //ovde za svakog korisnika vucemo username i poredimo sa usernameom novog korisnika (novi username naseg ado)
                //ako neki ima te podatke, onda nece moci da se izvrsi
                    throw new Exception("Korisnik sa tim kredencijalima vec postoji!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Broker.getInstance().update(ado);
    }
    
}
