/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package communication;

/**
 *
 * @author Aleksandra
 */
public interface Operation {
       
    public static final int SO_CREATE_USER = 1;
    public static final int SO_DELETE_USER = 2;
    public static final int SO_READ_USER = 3;
    public static final int SO_UPDATE_USER = 4;
    public static final int SO_LOGIN = 5;
    public static final int SO_CREATE_EMOTION = 6;
}
