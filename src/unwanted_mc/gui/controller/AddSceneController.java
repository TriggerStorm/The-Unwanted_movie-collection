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

/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class AddSceneController implements Initializable {

    @FXML
    private TextField txtField_title;
    @FXML
    private ChoiceBox<?> choiceBox_genre;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_openFileChooser(ActionEvent event) {
    }

    @FXML
    private void handle_cancelScene(ActionEvent event) {
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
    
}
