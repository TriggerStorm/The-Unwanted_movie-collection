/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.gui.controller;

import java.io.IOException;
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
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;
import unwanted_mc.gui.model.categoryModel;
import unwanted_mc.gui.model.movieModel;

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
    private Button bn_edit;

    private boolean edit;
    private boolean editCat;
    private Movie movieToEdit;
    private PrimarySceneController pSCon;
    private movieModel movieModel;
    private categoryModel categoryModel;
    private Category CategoryToEdit;
    
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
    public void setContr(PrimarySceneController pSCon) {
        this.pSCon = pSCon;
    }
    
    /**
     * updates all movie the tbv in the PrimaryScene 
     */
    private void updateAllMovie() {
    pSCon.refreshAllMovie();
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

    /**
     * Checks the selected mode (new or edit) and saves the song.
     */
    @FXML
    private void handle_saveMovie(ActionEvent event) throws InterruptedException, IOException {
        if (!edit) {
           // movieModel.createMovie(txtField_name.getText().trim(),
                  //  movieModel.ratingToString(txtField_rating.getText().trim()),// need to make a converter for the rating to string.
                 //   choiceBox_genre.getSelectionModel().getSelectedItem(),
                  //  txtField_filePath.getText());
        } else {
           // movieModel.editMovie(movieToEdit,
            //        txtField_name.getText().trim(),
            //        movieModel.ratingToString(txtField_rating.getText().trim()),// need to make a converter for the rating to string.
              //      choiceBox_genre.getSelectionModel().getSelectedItem(),
                //    txtField_filePath.getText());
        }

        updateAllMovie();

        Stage stage;
        stage = (Stage) btn_confirm.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handle_createVisible(ActionEvent event) {
        txt_createGenre.setVisible(true);
        btn_createGenre.setVisible(true);
    }

    @FXML
    private void handle_deleteGenre(ActionEvent event) {
        String name = choiceBox_genre.getSelectionModel().getSelectedItem();
        categoryModel.deleteCategory(name);
        choiceBox_genre.getItems().remove(name);
    }

    @FXML
    private void handle_createGenre(ActionEvent event) {
        String name = txt_createGenre.getText().trim();
        categoryModel.createCategory(name);
        choiceBox_genre.getItems().add(name);
        txt_createGenre.setVisible(false); //makes the button invisible.
        btn_createGenre.setVisible(false); //makes the button invisible.
    }
    
    public void editMode(Movie selectedMovie) {
        edit = true;
        movieToEdit = selectedMovie;

        //sets the existing info of the selected movie.
        txtField_name.setText(movieToEdit.getName());
        txtField_rating.setText(movieToEdit.getStringRating()); //need to do get rating to string. NOT DONE!!!
        txtField_filePath.setText(movieToEdit.getFileLink());
        //choiceBox_genre.setValue(movieToEdit.getCat()); //need to get fixt NOT DONE!!! dont have cat in Movie be.
    }

    public void editModeCat(Category selectedCat){
    editCat = true;
    CategoryToEdit = selectedCat;
    
    choiceBox_genre.setValue(CategoryToEdit.getCat());
    }
    @FXML
    private void btn_editGenre(ActionEvent event) {
        
        
        
    }
}
