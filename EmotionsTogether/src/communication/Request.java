/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Aleksandra
 */
public class Request implements Serializable{
    //ovaj zahtev prosledjuje koju operaciju treba izvrsiti
    //i nad kojim podacima (prosledjeni su, takodje)
    
    private int operation;
    private Object data;

    public Request() {
    }

    public Request(int operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public int getOperation() {
        return operation;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
    
}
