/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serializables;

import Model.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class UserSerializable extends SerializableObject {
    
    private static UserSerializable instance;
    private List<User> users = new ArrayList<>();
    private List<PendentMilestone> pendentMilestones = new ArrayList<>();
    private User userSession;
    private Administrator admin = new Administrator();
    
    private UserSerializable() {
        super("users.bin");
        try {
            users = (ArrayList<User>) this.readObjects();
        } catch (Exception ex) {
            System.out.println("Error to load initial data on UserSerializable");
        }
    }
    
    public static UserSerializable getInstance() {
        if (instance == null) {
            instance = new UserSerializable();
        }
        return instance;
    }

    public String createUser(User user) {
        try {
            users.add(user);
            this.writeObjects(users);
            return "Associado criado com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao criar novo Associado";
        }
    }
}