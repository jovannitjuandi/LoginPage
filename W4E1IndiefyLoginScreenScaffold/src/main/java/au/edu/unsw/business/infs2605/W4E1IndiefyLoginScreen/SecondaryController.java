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
    Button backButton;
    
    @FXML
    Button trackButton;
    
    @FXML
    Button displayButton;
    
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("LoginScreen");
    }
    
    @FXML 
    private void swithToDisplay() throws IOException {
        App.setRoot("display");
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
        
        trackColumn.setCellValueFactory(new PropertyValueFactory<userSong, String>("track"));
        albumColumn.setCellValueFactory(new PropertyValueFactory<userSong, String>("album"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<userSong, String>("artist"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<userSong, String>("genre"));
        
        songTable.setItems(data);
        songTable.getColumns().addAll(trackColumn, artistColumn, albumColumn, genreColumn);
    }
    
    public void initialize() throws SQLException{
        // What should the user see when the screen loads?
        System.out.println("HELLO");
        
        displayTable(global.getUser());
    }
}