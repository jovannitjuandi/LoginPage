/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jovanni
 */
public class userSong {
    SimpleStringProperty track;
    SimpleStringProperty artist;
    SimpleStringProperty album;
    SimpleStringProperty genre;
    
    public userSong (SimpleStringProperty tr, SimpleStringProperty ar, SimpleStringProperty al, SimpleStringProperty ge) {
        track = tr;
        artist = ar;
        album = al;
        genre = ge;
    }
    
    public SimpleStringProperty getTrack () {
        return track;
    }
    
    public SimpleStringProperty getArtist () {
        return artist;
    }
    
    public SimpleStringProperty getAlbum () {
        return album;
    }
    
    public SimpleStringProperty getGenre () {
        return genre;
    }
}
