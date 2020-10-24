/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

/**
 *
 * @author Jovanni
 */

public class displayController {
    @FXML
    Button trackButton;
    
    @FXML
    Button displayButton;
    
    @FXML 
    private void swithToTrack() throws IOException {
        App.setRoot("secondary");
    }
}
