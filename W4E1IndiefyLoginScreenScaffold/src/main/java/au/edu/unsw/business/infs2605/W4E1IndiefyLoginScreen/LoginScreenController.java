package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

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
    private void handleLoginButtonAction(ActionEvent event) throws SQLException {
        
        // Get the user's input from the GUI 
        String username = nametext.getText();
        String password = passtext.getText();
        boolean successfulLogin = DatabaseManager.login(username, password);
        
        if (successfulLogin) {
          // What should the user see when the login is successful?
          nextbutton.setVisible(true);
          incorrecttext.setVisible(false);
          successfultext.setText("Login Successful, Jovanni Tjuandi (z5213864)!");
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

    
    public void initialize() throws SQLException{
        // What should the user see when the screen loads?
        nextbutton.setVisible(false);
        successfultext.setVisible(false);
        incorrecttext.setVisible(false);
        
        DatabaseManager.addUser("Jovanni", "123");
        DatabaseManager.addUser("Gracia", "456");
        DatabaseManager.addUser("Tjuandi", "789");
        DatabaseManager.addUser("z5213864", "zpass");
        
        DatabaseManager.addUserSong("Jov", "Glacier", "DJ ABC", "Frozen Chimps", "EDM");
        DatabaseManager.addUserSong("Jov", "Foot Roll", "LIL X", "Gray", "Rap");
        DatabaseManager.addUserSong("Jov", "Solid", "Duke Bronze", "Saxline", "RnB");
        DatabaseManager.addUserSong("Jov", "Breeze", "DJ ABC", "Frozen Chimps", "EDM");
    }

}

/*What should we test?*/
