/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import java.sql.SQLException;
import broker.Broker;
import emotionstogether.AbstractDomainObject;

/**
 *
 * @author Aleksandra
 */
public abstract class AbstractSO {
    
    protected abstract void validate(AbstractDomainObject ado) throws Exception;
    protected abstract void execute(AbstractDomainObject ado) throws Exception;

    public void templateExecute(AbstractDomainObject ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    public void commit() throws SQLException {
        Broker.getInstance().getConnection().commit();
    }

    public void rollback() throws SQLException {
        Broker.getInstance().getConnection().rollback();
    }
    
}
