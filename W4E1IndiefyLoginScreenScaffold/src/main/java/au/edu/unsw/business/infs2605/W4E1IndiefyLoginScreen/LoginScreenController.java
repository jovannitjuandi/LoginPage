package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginScreenController {

    //Initiate JavaFX nodes (visual elements), how do we connect these variables to the FXML view?

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
     
    /* What should happen when you click the login button?
       How do we connect this function to the FXML view? */
    private void handleLoginButtonAction(ActionEvent event) {
        
        // Get the user's input from the GUI
/*
        if ()) {
          // What should the user see when the login is successful?
        } else {
          // What should the user see when the login is unsuccessful?
        }
        */
    }


    private void handleNextButtonAction(ActionEvent event) throws IOException {
        // What method should we call?
    }

    
    public void initialize() {
        // What should the user see when the screen loads?
    }

}

/*What should we test?*/
