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
    /**
     * gets a list off all movie and make a new obseverble list and add all
     * values to the new list and retun it.
     * @return 
     */
    
    public ObservableList<Movie> getAllMovies() {
        List<Movie> allMovies = bllManager.fetchAllMovies();
        movieList = FXCollections.observableArrayList(allMovies);
        return movieList;
    }
    
    /**
     * create a new movie in the db and to the moiveList.
     * @param name
     * @param rating
     * @param filelink
     * @param lastview 
     */
    public void createMovie(String name, int rating, String filelink, String lastview) {
        Movie movie = bllManager.addMovieToDB(name, rating, filelink, lastview);
        movieList.add(movie);
    }
        
    /**
     * updated the selceted movie.
     * @param movie
     * @param name
     * @param rating
     * @param filelink
     * @param lastview 
     */
    public void editMovie(Movie movie, String name, int rating, String filelink, String lastview) {
        bllManager.editMovie(movie, name, rating, filelink, lastview); 
        
        
    }
     /**
      * delete the selectet movie form db and movieList.
      * @param movie 
      */
    public void deleteMovie(Movie movie) {
        bllManager.removeMovieFromDB(movie);
        movieList.remove(movie); 
    }       
    /**
     * convert rating from int to string
     * @param ratingInt
     * @return 
     */
    public String ratingIntToString(int ratingInt){
        return bllManager.ratingIntToString(ratingInt);
    }
    /**
     * convert sting rating to int.
     * @param ratingString
     * @return 
     */
    public int ratingStringToInt(String ratingString){
       return bllManager.ratingStringToInt(ratingString);
    }
    
    
}
