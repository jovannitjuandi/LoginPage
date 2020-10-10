package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginScreenController {

    //Initiate JavaFX nodes (visual elements), how do we connect these variables to the FXML view?
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
     
    /* What should happen when you click the login button?
       How do we connect this function to the FXML view? */
    
    @FXML
    Button loginbutton;
    
    @FXML 
    TextField nametext;
    
    @FXML
    PasswordField passtext;
    
    @FXML
    Button nextbutton;
    
    @FXML
    Text incorrecttext;
    
    @FXML
    Text successfultext;
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        
        // Get the user's input from the GUI 
        String username = nametext.getText();
        String password = passtext.getText();
        boolean condition1 = (username.toUpperCase()).equals("PRETENTIOUS");
        boolean condition2 = password.equals("Hipster");
        boolean condition = (condition1)&(condition2);
        
        if (condition) {
          // What should the user see when the login is successful?
          nextbutton.setVisible(true);
          incorrecttext.setVisible(false);
          successfultext.setText("Login Successful, " + username + " (z5123456)!");
          successfultext.setVisible(true);
        } else {
          // What should the user see when the login is unsuccessful?
          successfultext.setVisible(false);
          nextbutton.setVisible(false);
          incorrecttext.setVisible(true);
        }
        
    }

    
    @FXML
    private void handleNextButtonAction(ActionEvent event) throws IOException {
        // What method should we call?
        switchToSecondary();
    }

    
    public void initialize() {
        // What should the user see when the screen loads?
        nextbutton.setVisible(false);
        successfultext.setVisible(false);
        incorrecttext.setVisible(false);
    }

}

/*What should we test?*/
