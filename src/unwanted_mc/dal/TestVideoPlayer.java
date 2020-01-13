/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import java.io.File;
import java.net.URL;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import unwanted_mc.be.Movie;

/**
 *
 * @author admin
 */
public class TestVideoPlayer {
    


public void start(Stage primaryStage) {

//The location of your file
/*Media media = new Media(new Movie(1, "Pony", 9, "src/Movie1.mp4", "12-December-2012"));

MediaPlayer mediaPlayer = new MediaPlayer(media);
mediaPlayer.setAutoPlay(true);
MediaView mediaView = new MediaView(mediaPlayer);

BorderPane borderPane = new BorderPane();
borderPane.setCenter(mediaView);
borderPane.setBottom(addToolBar());

borderPane.setStyle("-fx-background-color: Black");

Scene scene = new Scene(borderPane, 600, 600);
scene.setFill(Color.BLACK);

primaryStage.setTitle("Media Player!");
primaryStage.setScene(scene);
primaryStage.show();
}


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
                }
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
*/
    }

}