/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.user;
import broker.Broker;
import emotionstogether.AbstractDomainObject;
import emotionstogether.User;
import so.AbstractSO;

/**
 *
 * @author Aleksandra
 */
public class SODeleteUser extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof User)) {
            throw new Exception("Prosledjeni objekat nije instanca klase User!");
        }    
    }
       
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       Broker.getInstance().delete(ado);
    }
   
    
}
