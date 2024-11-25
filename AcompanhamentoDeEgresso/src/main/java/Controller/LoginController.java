/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;

/**
 *
 * @author Administrator
 */
public class LoginController {
    public LoginController(){}
    private Administrator admin = new Administrator();
    
    public boolean authenticate (String email, String password) {  
        return (admin.getEmail().equals(email) && admin.getPassword().equals(password));
    }
}
