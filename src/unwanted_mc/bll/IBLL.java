/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public interface IBLL {
    
    void addMovieToDB(String name, double rating, String filelink, Calendar lastview); // throws IOException {
    void removeMovieFromDB(int id); // throws IOException {
    Movie getMovie(int id); // throws IOException {
    void addMovieToCategory(int id, String category);
    void removeMovieFromCategory(int id, String category);
    
    void addCategoryToDB(String name);
    void removeCategoryFromDB(String name);
    Category getCategory(int id);
    
    
    
    //    List<Movie> addMovieToCollection(Movie movieToBeAdded);
    //    Movie stringToMovie(String t);
    //    String movieToString(Movie movie);
    //    List<Movie> getAllMovies(); // throws FileNotFoundException, IOException {


}
