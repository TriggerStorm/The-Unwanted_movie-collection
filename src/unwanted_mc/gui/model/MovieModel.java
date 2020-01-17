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
 * @author Niclas, Martin, Michael and Alan
 */


public class MovieModel {
    
    private BllManager bllManager;
    private ObservableList<Movie> movieList;
   
    
    public MovieModel() {
        bllManager = new BllManager();
        getAllMovies();
        
        
    }
    
    
    public ObservableList<Movie> getAllMovies() {
        List<Movie> allMovies = bllManager.fetchAllMovies();
        System.out.println("mmfal");
        movieList = FXCollections.observableArrayList(allMovies);
        return movieList;
    }
    
    
    public void createMovie(String name, int rating, String filelink, String lastview) {
        Movie movie = bllManager.addMovieToDB(name, rating, filelink, lastview);
        movieList.add(movie);
    }
        
        
    public void editMovie(Movie movie, String name, int rating, String filelink, String lastview) {
        bllManager.editMovie(movie, name, rating, filelink, lastview); 
        
        
    }
        
    public void deleteMovie(Movie movie) {
        bllManager.removeMovieFromDB(movie);
        movieList.remove(movie); 
    }       
    
    public String ratingIntToString(int ratingInt){
        return bllManager.ratingIntToString(ratingInt);
    }
    
    public int ratingStringToInt(String ratingString){
       return bllManager.ratingStringToInt(ratingString);
    }
    
   /* 
    public void filterCategory(int id) {  // NOT FINISHED
        Movie movie = bllManager.removeMovieFromDB(id);
        movieList.remove(movie); 
    }
    */
    
}
