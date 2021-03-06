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
    Text incorrecttext;
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws SQLException, IOException {
        
        // Get the user's input from the GUI 
        String username = nametext.getText();
        String password = passtext.getText();
        boolean successfulLogin = DatabaseManager.login(username, password);
        
        if (successfulLogin) {
          // What should the user see when the login is successful?
          //nextbutton.setVisible(true);
          global.setUser(username.toLowerCase());
          switchToSecondary();
          incorrecttext.setVisible(false);
        } else {
          // What should the user see when the login is unsuccessful?
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
        incorrecttext.setVisible(false);
        
        DatabaseManager.addUser("jovanni", "123");
        DatabaseManager.addUser("gracia", "456");
        DatabaseManager.addUser("tjuandi", "789");
        DatabaseManager.addUser("z5213864", "zpass");
        
        DatabaseManager.addUserSong("jovanni", "Glacier", "DJ ABC", "Frozen Chimps", "EDM");
        DatabaseManager.addUserSong("jovanni", "Foot Roll", "LIL X", "Gray", "Rap");
        DatabaseManager.addUserSong("jovanni", "Solid", "Duke Bronze", "Saxline", "RnB");
        DatabaseManager.addUserSong("jovanni", "Breeze", "DJ ABC", "Frozen Chimps", "EDM");
        
        DatabaseManager.addUserSong("tjuandi", "Numb", "Linkin Park", "Meteora", "Rock");
        DatabaseManager.addUserSong("tjuandi", "In The End", "Black Veil Bride", "Wild Ones", "Metal");
        DatabaseManager.addUserSong("tjuandi", "Animals", "Martin Garrix", "Animals", "EDM");
        DatabaseManager.addUserSong("tjuandi", "Faint", "Linkin Park", "Meteora", "Metal");
        DatabaseManager.addUserSong("tjuandi", "Virus", "Martin Garrix", "Virus", "EDM");
    }

}

/*What should we test?*/
