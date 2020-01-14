/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import unwanted_mc.gui.controller.VideoPlayerController;

import unwanted_mc.gui.controller.VideoPlayerController;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class TheUnWanted_MovieCollection extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/PrimaryScene.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateNow = now.format(formatter);
        
        System.out.println("localdate - " + LocalDate.now());
        System.out.println("string version - " + dateNow);

        launch(args);
    }
    
}
