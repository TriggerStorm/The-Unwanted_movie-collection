/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import unwanted_mc.be.Movie;
//import org.controlsfx.dialog.ExceptionDialog;
//import javafx.scene.control.Dialog<ButtonType>;

/**
 * @author Niclas, Martin, Michael and Alan
 */


public class VideoPlayerController {
    @FXML private MediaView mediaView;    
    @FXML private Button playPauseButton;
    private MediaPlayer mediaPlayer;    
    private boolean playing = false;
    private Movie movie = new Movie(1, "Pony", 9, "src/Movie1.mp4", "12-December-2012");
    
    public void initialize() {  //URL url, ResourceBundle rb) {
        URL url = VideoPlayerController.class.getResource("src/Movie1.mp4");        
        Media media = new Media(url.toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setOnEndOfMedia(
            new Runnable() {
                public void run() {
                    playing = false;
                    playPauseButton.setText("Play");
                    mediaPlayer.seek(Duration.ZERO);
                    mediaPlayer.pause();
                }
            }
        );
        mediaPlayer.setOnError(
            new Runnable() {
                public void run() {
/*                    ExceptionDialogs dialog =
                        new ExceptionDialog(mediaPlayer.getError());
                    dialog.showAndWait();
 */               }
            }
        );
        
        mediaPlayer.setOnReady(
            new Runnable() {
                public void run() {
                    DoubleProperty width = mediaView.fitWidthProperty();
                    DoubleProperty height = mediaView.fitHeightProperty();
                    width.bind(Bindings.selectDouble(
                        mediaView.sceneProperty(), "width"));
                    width.bind(Bindings.selectDouble(
                        mediaView.sceneProperty(), "height"));
                }
            }
        );
    }  
        
        
    @FXML 
    private void playPauseButtonPressed(ActionEvent e) {
        playing = !playing;
        
        if(playing) {
            playPauseButton.setText("Pause");
            mediaPlayer.play();
        } else {
            playPauseButton.setText("Play");
            mediaPlayer.pause();

        }
    }
}
