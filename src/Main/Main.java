/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import GUI.LoginForm;
/**
 *
 * @author jeje
 */
public class Main {
    public static void main(String[] args) {
        try {
            new LoginForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
