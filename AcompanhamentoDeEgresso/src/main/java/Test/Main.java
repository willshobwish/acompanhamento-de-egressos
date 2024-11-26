/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Egress;
import Model.User;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class Main {

    public static void main(String[] args) {
        User user = new User("a", "a", "a");
//        String[] social = {"a", "b", "c"};
        ArrayList<String> social = new ArrayList<>();
        social.add("a");
        social.add("a");
        social.add("a");

        Egress egress = new Egress("a", "a", "a", LocalDate.now(), LocalDate.now(), LocalDate.now(), social, false);
        System.out.println(egress instanceof User);
        System.out.println(user instanceof User);
        System.out.println(egress instanceof Egress);
        System.out.println(user instanceof Egress);

    }
}
