/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.time.LocalDate;
import java.util.List;
import unwanted_mc.be.CatMovie;
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;
import unwanted_mc.dal.DalManager;
import unwanted_mc.dal.IDAL;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class BllManager implements IBLL {
    
    private IDAL dalManager;
    private DateConverter timeconverter;
    private RatingConverter ratingconverter;
    private SearchFilter searcher;

    
    public BllManager() {
  
        dalManager = new DalManager();
        timeconverter = new DateConverter();
        ratingconverter = new RatingConverter();
        searcher = new SearchFilter();

    }
    
 
    
    
    
  
    @Override
    public Movie addMovieToDB(String name, int rating, String filelink, String lastview) {
        return dalManager.addMovieToDB(name, rating, filelink, lastview);
    }
        
    
    @Override
    public void removeMovieFromDB(int id) {
        dalManager.removeMovieFromDB(id);
    }
    
    
    @Override
    public Movie getMovie(List<Movie> allMovies, int id) {
        return dalManager.getMovie(allMovies, id);
    }
    
    
    @Override
    public List<Movie> fetchAllMovies() {
        return dalManager.fetchAllMovies();
    }

    
    @Override
    public Movie editMovie(String name, int rating, String filelink, String lastview) {
        return dalManager.editMovie(name, rating, filelink, lastview);
    }

    
    @Override
    public List<Movie> findMoviesToRemove() {
        return dalManager.findMoviesToRemove();
    }

    
    public void updateLastView(int id, String dateNow) {
        dalManager.updateLastView(id, dateNow);
    }

    
    public boolean testForLastView(int id) {
        return dalManager.testForLastView(id);
    }

    
    
   
    
    
    @Override
    public CatMovie addCatMovieToDB(int movieID, int categoryID) {
        return dalManager.addCatMovieToDB(movieID, categoryID);
    }
    
    
    @Override
    public CatMovie removeCatMovieFromDB(int id) {
        return dalManager.removeCatMovieFromDB(id);
    }
    
    
    
    @Override
    public List<CatMovie> fetchAllCatMovies() {
        return dalManager.fetchAllCatMovies();
    }
    
    
    
    
    
    
    @Override
    public Category addCategoryToDB(String name) {
        return dalManager.addCategoryToDB(name);
    }
    
    
    @Override
    public Category removeCategoryFromDB(String name) {
        return dalManager.removeCategoryFromDB(name);
    }
    
    
        @Override
    public List<Category> fetchAllCatagories() {
        return dalManager.fetchAllCatagories();
    }

    
    @Override
    public Category editCategory(String name) {
        return dalManager.editCategory(name);
    }

    @Override
    public Category getCategory(int id) {
        return dalManager.getCategory(id);
    }
    
    
    
    
    
// From DateConverter        
    @Override
    public String dateNowToString() {
        return dateNowToString();
    }
    
    
    @Override
    public LocalDate stringToLocalDate(String dateString) {
        return stringToLocalDate(dateString);
    }
    
    
     
    
    
// From RatingConverter   
      @Override
    public String ratingIntToString(int ratingInt) {
        return ratingIntToString(ratingInt);
    }

    
    @Override
    public int ratingStringToInt(String ratingString) {
        return ratingStringToInt(ratingString);
    }

    
    public double percentToDecimal(int percentRating) {
        return percentToDecimal(percentRating);
    }
   
    
    public int decimalToPercent(double decimalRating) {
        return decimalToPercent(decimalRating);
    }
    
    
    
    
    
// From SearchFilter
    @Override
    public List<Movie> searchByName(List<Movie> allMovies, String query) {
        return searchByName(allMovies, query);
    }

    
    @Override
    public List<Movie> searchByRatingAbove(List<Movie> allMovies, String query) {
        return searchByRatingAbove(allMovies, query);
    }

        
    @Override
    public List<Movie> searchByRatingBelow(List<Movie> allMovies, String query) {
        return searchByRatingBelow(allMovies, query);
    }

    
}
    
