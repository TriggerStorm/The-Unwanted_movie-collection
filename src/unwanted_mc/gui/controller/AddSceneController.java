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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import unwanted_mc.be.Movie;

/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class AddSceneController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox_genre;
    @FXML
    private TextField txtField_filePath;
    @FXML
    private Button btn_chooseFile;
    @FXML
    private Button btn_cancel;
    @FXML
    private Button btn_confirm;
    @FXML
    private Button btn_createVisible;
    @FXML
    private Button btn_deleteGenre;
    @FXML
    private TextField txt_createGenre;
    @FXML
    private Button btn_createGenre;
    @FXML
    private TextField txtField_rating;
    @FXML
    private Button btn_editGenre;
    @FXML
    private ImageView bn_edit;

    private boolean edit;
    private Movie movieToEdit;
    private PrimarySceneController pSCon;
    
    @FXML
    private TextField txtField_name;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    /**
     * Sets the controller for the PrimaryScene.
     *
     * @param pSCon PrimaryController.
     */
    public void setContr(PrimarySceneController pCon) {
        this.pSCon = pSCon;
    }

    @FXML
    private void handle_openFileChooser(ActionEvent event) {
    }

    /**
     * Closes the stage.
     */
    @FXML
    private void handle_cancelScene(ActionEvent event) {
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void handle_saveSong(ActionEvent event) {
    }

    @FXML
    private void handle_createVisible(ActionEvent event) {
    }

    @FXML
    private void handle_deleteGenre(ActionEvent event) {
    }

    @FXML
    private void handle_createGenre(ActionEvent event) {
    }
    
    public void editMode(Movie selectedMovie) {
        edit = true;
        movieToEdit = selectedMovie;

        //sets the existing info of the selected movie.
        txtField_name.setText(movieToEdit.getName());
        txtField_rating.setText(movieToEdit.getStringRating()); //need to do get rating to string. NOT DONE!!!
        txtField_filePath.setText(movieToEdit.getFileLink());
        //choiceBox_genre.setValue(movieToEdit.getCat()); need to get fixt NOT DONE!!!
    }
}
