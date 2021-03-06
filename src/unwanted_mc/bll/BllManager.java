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


/** This class manages the connection between GUI and DAL.
*
 *  @author Niclas, Martin, Michael and Alan
 */


public class BllManager implements IBLL {
    
    private IDAL dalManager;
    private DateConverter timeconverter;
    private RatingConverter ratingconverter;
    private SearchFilter searcher;
/*
    this make a connection to the Dall, DateConverter, RatingConverter and SearchFilter
    */
    
    public BllManager() {
  
        dalManager = new DalManager();
        timeconverter = new DateConverter();
        ratingconverter = new RatingConverter();
        searcher = new SearchFilter();

    }
    
 
    
    //__________________________________________________________________________                       
    //      
    //      Movie
    //__________________________________________________________________________
    
  
    @Override
    public Movie addMovieToDB(String name, int rating, String filelink, String lastview) {
        return dalManager.addMovieToDB(name, rating, filelink, lastview);
    }
        
    
    @Override
    public void removeMovieFromDB(Movie movie) {
        dalManager.removeMovieFromDB(movie);
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
    public Movie editMovie(Movie movie,String name, int rating, String filelink, String lastview) {
        return dalManager.editMovie(movie, name, rating, filelink, lastview);
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

    
    
   //__________________________________________________________________________                       
    //      
    //      Category 
    //__________________________________________________________________________
    
    
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
    public void addCategoryToDB(String name) {
        dalManager.addCategoryToDB(name);
    }
    
    
    @Override
    public Category removeCategoryFromDB(String name) {
        return dalManager.removeCategoryFromDB(name);
    }
    
    
        @Override
        public List<Category> fetchAllCategories() {
        return dalManager.fetchAllCategories();
    }

    
    @Override
    public Category editCategory(String name) {
        return dalManager.editCategory(name);
    }

    @Override
    public Category getCategory(List<Category> allCategories, int id) {
        return dalManager.getCategory(allCategories,id);
    }
    
    
    
    //__________________________________________________________________________                       
    //      
    //      DateConvter 
    //__________________________________________________________________________
    
        
    @Override
    public String dateNowToString() {
        return dateNowToString();
    }
    
    
    @Override
    public LocalDate stringToLocalDate(String dateString) {
        return stringToLocalDate(dateString);
    }
    
    
     
    //__________________________________________________________________________                       
    //      
    //      RatingConverter
    //__________________________________________________________________________
    
  
      @Override
    public String ratingIntToString(int ratingInt) {
        return ratingconverter.RatingIntToString(ratingInt);
    }

    
    @Override
    public int ratingStringToInt(String ratingString) {
        return ratingconverter.RatingStringToInt(ratingString);
    }

    
    public double percentToDecimal(int percentRating) {
        return ratingconverter.percentToDecimal(percentRating);
    }
   
    
    public int decimalToPercent(double decimalRating) {
        return ratingconverter.decimalToPercent(decimalRating);
    }
    
    
    
    //__________________________________________________________________________                       
    //      
    //      SearchFilter
    //__________________________________________________________________________
    

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
    
