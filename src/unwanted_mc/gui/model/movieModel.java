/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.gui.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import unwanted_mc.be.Movie;
import unwanted_mc.bll.BllManager;

/**
 *
 * @author admin
 */
public class movieModel {
    
    private BllManager bllManager;
    private ObservableList<Movie> movieList;

    
    public movieModel() {
        bllManager = new BllManager();
        getAllMovies();
    }
    
    
    public ObservableList<Movie> getAllMovies() {
        List<Movie> allMovies = bllManager.fetchAllMovies();
       
        movieList = FXCollections.observableArrayList(allMovies);
        return movieList;
    }
    
    
    public void createMovie(String name, double rating, String filelink, String lastview) {
        Movie movie = bllManager.addMovieToDB(name, rating, filelink, lastview);
        movieList.add(movie);
    }
        
        
    public void editMovie(String name, double rating, String filelink, String lastview) {
        Movie movie = bllManager.editMovie(name, rating, filelink, lastview);
        movieList.add(movie); 
    }
        
    public void deleteMovie(int id) {
        bllManager.removeMovieFromDB(id);
        movieList.remove(id); 
    }       
        
   /* 
    public void filterCategory(int id) {  // NOT FINISHED
        Movie movie = bllManager.removeMovieFromDB(id);
        movieList.remove(movie); 
    }
    */
    
}
