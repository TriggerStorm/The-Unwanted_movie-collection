/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import unwanted_mc.be.Movie;
import unwanted_mc.gui.model.CategoryModel;
import unwanted_mc.gui.model.MovieModel;


/**
 * @author Niclas, Martin, Michael and Alan
 */


public class PrimarySceneController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TableView<Movie> tbv_allMovie;
    @FXML
    private TableColumn<Movie, String> col_name; 
    @FXML
    private TableColumn<Movie, String> col_rating; 
    @FXML
    private TableColumn<Movie, String> col_category;
    @FXML
    private TableColumn<Movie, String> col_lastview;
    @FXML
    private TextField txt_search;
    @FXML
    private Button bn_editMovie;
    @FXML
    private Button bn_removeMovie;
    @FXML
    private Button bn_addMovie;
    @FXML
    private Button bn_play;
    
    private Movie movie;
    private MovieModel movieModel;
    private CategoryModel categoryModel;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingTableView();
        categoryModel = new CategoryModel();
    }    
    private void settingTableView() {
        movieModel = new MovieModel();
        

        //  allMovie table view
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_category.setCellValueFactory(new PropertyValueFactory<>("catString"));
        col_rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        col_lastview.setCellValueFactory(new PropertyValueFactory<>("FPL"));
        
        tbv_allMovie.setItems(movieModel.getAllMovies());
        

    }
    
    
    @FXML
    private void handle_createMoive(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/unwanted_mc/gui/view/addScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<AddSceneController>getController().setMovieModel(movieModel);

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
    }
    /**
     * Handles the selecting of movie, shown in the allMovies in which the user
     * can then delete, edit
     *
     * @param event - MouseEvent controls the selection of movie in library
     */
    @FXML
    private void handle_getMovie(MouseEvent event) { // pick  selected movie
        movie = tbv_allMovie.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void handle_EditSong(ActionEvent event) throws IOException {
        Movie selectedMovie = tbv_allMovie.getSelectionModel().getSelectedItem();

        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/unwanted_mc/gui/view/addScene.fxml"));
        root = (Parent) fxmlLoader.load();
        AddSceneController controller = (AddSceneController) fxmlLoader.getController();
        fxmlLoader.<AddSceneController>getController().setMovieModel(movieModel);
        
        controller.editMode(selectedMovie); //set mode to edit movie.
        Stage addStage = new Stage();
        Scene addScene = new Scene(root);
        
       
        addStage.setScene(addScene);
        addStage.show();
    }
    
    @FXML
    private void handle_deleteMovie(ActionEvent event) throws IOException { // deletion of songs
        Movie selectedMovie = tbv_allMovie.getSelectionModel().getSelectedItem();
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/unwanted_mc/gui/view/DeleteScene.fxml"));
        root = (Parent) fxmlLoader.load();
        DeleteSceneController controller = (DeleteSceneController) fxmlLoader.getController();
        fxmlLoader.<DeleteSceneController>getController().setMovieModel(movieModel);
        controller.setContr(this);
        controller.setDeleteMovieLabel(selectedMovie);

        Stage addStage = new Stage();
        Scene addScene = new Scene(root);

       
        addStage.setScene(addScene);
        addStage.show();
        
    }
    
    public void refreshAllMovie() {
        tbv_allMovie.getItems().clear();
        tbv_allMovie.setItems(movieModel.getAllMovies());
    }

    @FXML
        private void handle_playVideo(ActionEvent event) { //throws MalformedURLException {
//  COMPLIES.  UNTESTED!!!
System.out.println("test point 0a");            
        Stage videoStage = new Stage();
    
System.out.println("test point 1");            
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("mp4 Files", "*.mp4"),
                new FileChooser.ExtensionFilter("mpeg4 Files", "*.mpeg4")
        );

 //       File movieFile = fileChooser.showOpenDialog(null);
        if ( true ) {  //movieFile != null
  MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File( tbv_allMovie.getSelectionModel().getSelectedItem().getFileLink()).toURI().toString()));

//            String moviePATH = "src/Movie1.mp4";  //movieFile.getAbsolutePath();
 //           txtField_filePath.setText(moviePATH);
System.out.println("test point 3");            

//            Media media = new Media(new File(moviePATH).toURI().toString());        //  Instantiate the javafx.scene.media.Media class by passing the location of the audio file in its constructor.
//            MediaPlayer mediaPlayer = new MediaPlayer(media);       //  Pass the Media class object to the new instance of javafx.scene.media.MediaPlayer object.
            mediaPlayer.setAutoPlay(true);       //  Invoke the MediaPlayer object's play() method when onReady event is triggered.

            MediaView mediaView = new MediaView(mediaPlayer);
            System.out.println("test 1");
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(mediaView);
//            borderPane.setBottom(addToolBar());

            borderPane.setStyle("-fx-background-color: Black");
System.out.println("test point 3");            

            Scene scene = new Scene(borderPane, 1334, 750);
            scene.setFill(Color.BLACK);

            videoStage.setTitle("Media Player!");
            videoStage.setScene(scene);
            videoStage.show();
                  
 System.out.println("test point 4");            

        }
    }
}
