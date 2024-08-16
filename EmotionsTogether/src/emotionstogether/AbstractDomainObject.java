/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionstogether;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Aleksandra
 */
public abstract class AbstractDomainObject implements Serializable{
    
    public abstract String nazivTabele();
    public abstract String koloneZaInsert();
    public abstract String vrednostiZaInsert();
    //alijas za naziv tabele
    public abstract String alijasTabele();
    public abstract String join();
    public abstract String uslovZaSelect();
    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;
    public abstract String vrednostiZaUpdate();
    public abstract String uslovWhere();
}
