/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.emotions;
import emotionstogether.AbstractDomainObject;
import so.AbstractSO;
import emotionstogether.Emotion;

/**
 *
 * @author Aleksandra
 */
public class SOCreateEmotion extends AbstractSO{
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Emotion)){
            throw new Exception("Uneti objekat nije klase Emotion!");
        } 
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        System.out.println("Usao u execute deo soCreateEmotion");
       broker.Broker.getInstance().insert(ado);
    }
    
    
    
}
