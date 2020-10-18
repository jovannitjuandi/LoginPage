package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class SecondaryController {
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("LoginScreen");
    }
    
    @FXML
    TableView<userSong> songTable;
    
    @FXML
    TableColumn<userSong, String> trackColumn;
    
    @FXML
    TableColumn<userSong, String> albumColumn;
    
    @FXML
    TableColumn<userSong, String> artistColumn;
    
    @FXML
    TableColumn<userSong, String> genreColumn;
    
    @FXML
    public void displayTable(String user) throws SQLException {
        DatabaseManager.openSong();
        
        ObservableList<userSong> data = FXCollections.observableArrayList();
        data = DatabaseManager.getAllSong(user);
        
        data.add(new userSong(new SimpleStringProperty("A"), new SimpleStringProperty("A"), new SimpleStringProperty("A"), new SimpleStringProperty("A")));
        
        
        
        System.out.println("Arraysize: " + data.size());
        System.out.println("ArrayItem: " + data.get(2).getTrack());
         
        trackColumn.setCellValueFactory(new PropertyValueFactory<userSong, String>("track"));
        
        songTable.setItems(data);
        songTable.getColumns().addAll(trackColumn, artistColumn, albumColumn, genreColumn);
    }
    
    public void initialize() throws SQLException{
        // What should the user see when the screen loads?
        System.out.println("HELLO");
        
        displayTable("Jov");
    }
}