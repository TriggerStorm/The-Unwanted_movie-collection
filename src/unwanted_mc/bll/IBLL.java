/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import unwanted_mc.be.CatMovie;
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public interface IBLL {
    
    
   Movie addMovieToDB(String name, int rating, String filelink, String lastview);
    void removeMovieFromDB(int id);
    Movie getMovie(List<Movie> allMovies, int id);
    List<Movie> fetchAllMovies();
    Movie editMovie(String name, int rating, String filelink, String lastview);
    List<Movie> findMoviesToRemove();
    void updateLastView(int id, String dateNow);
    boolean testForLastView(int id);
 
    CatMovie addCatMovieToDB(int movieID, int categoryID);
    CatMovie removeCatMovieFromDB(int id);
    List<CatMovie> fetchAllCatMovies();

    Category addCategoryToDB(String name);
    Category removeCategoryFromDB(String name);
    List<Category> fetchAllCatagories();
    Category editCategory(String name);
    Category getCategory(int id);
 
// From DateConverter    
    String dateNowToString();
    LocalDate stringToLocalDate(String dateString);

 // From RatingConverter   
    String ratingIntToString(int ratingInt);
    int ratingStringToInt(String ratingString);
    double percentToDecimal(int percentRating);
    int decimalToPercent(double decimalRating);

// From SearchFilter
    List<Movie> searchByName(List<Movie> allMovies, String query);
    List<Movie> searchByRatingAbove(List<Movie> allMovies, String query);
    List<Movie> searchByRatingBelow(List<Movie> allMovies, String query);

}
