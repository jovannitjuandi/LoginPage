package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("LoginScreen");
    }
}