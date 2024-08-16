/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.user;
import emotionstogether.AbstractDomainObject;
import emotionstogether.User;
import java.util.ArrayList;
import so.AbstractSO;
/**
 *
 * @author Aleksandra
 */
public class SOReadUser extends AbstractSO{
    
    private ArrayList<User> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof User)) {
            throw new Exception("Prosledjeni objekat nije instanca klase User!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> korisnici = broker.Broker.getInstance().select(ado);
        lista = (ArrayList<User>) (ArrayList<?>) korisnici;
        System.out.println("Duzina liste iz soReadUser"+lista.size());
    }

    public ArrayList<User> getLista() {
        return lista;
    }
}
