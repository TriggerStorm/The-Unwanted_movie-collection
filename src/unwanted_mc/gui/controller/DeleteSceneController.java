/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import unwanted_mc.be.Movie;
import unwanted_mc.gui.model.movieModel;


/**
 * FXML Controller class
 *
 * @author Niclas, Martin, Michael and Alan
 */



public class DeleteSceneController implements Initializable {

    @FXML
    private Button bn_cancel;
    @FXML
    private Button bn_delete;
    @FXML
    private Label lbl_title;

    
    private PrimarySceneController pSCon;
    private Movie selectedMovie;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setContr(PrimarySceneController pSCon) {
        this.pSCon = pSCon;
    }
    
    private void updateAllMovie() {
    pSCon.refreshAllMovie();
    }
    public void setDeleteMovieLabel(Movie movie) {
        selectedMovie = movie;
        lbl_title.setText(selectedMovie.getName());
    }
   
    @FXML
    private void handle_closeScene(MouseEvent event) {
        Stage stage = (Stage) bn_cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handle_deleteMovie(MouseEvent event) {
         //Deletes the selected song from the database.
       // movieModel.deleteMovie(selectedMovie); // need to set move to String in model NOT DONE!
        updateAllMovie();// updates the tbv with movies.
        Stage stage;
        stage = (Stage) bn_delete.getScene().getWindow();
        stage.close();
    }

}
