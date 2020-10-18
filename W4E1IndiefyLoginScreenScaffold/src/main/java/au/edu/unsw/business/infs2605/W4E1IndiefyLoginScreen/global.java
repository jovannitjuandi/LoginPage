/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

/**
 *
 * @author Jovanni
 */
public class global {
    private static String currentUser;
    
    public static String getUser() {
        return currentUser;
    }
    
    public static void setUser(String username) {
        currentUser = username;
    }
}
