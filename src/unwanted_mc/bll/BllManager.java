/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private SearchFilter searcher;
    private DateConverter timeconverter;
    
    
    
    public BllManager() {
  

        dalManager = new DalManager();
        searcher = new SearchFilter();
        timeconverter = new DateConverter();
    }
    
 
  
    @Override
    public Movie addMovieToDB(String name, double rating, String filelink, String lastview) {
        return dalManager.addMovieToDB(name, rating, filelink, lastview);
    }
        
    
    @Override
    public void removeMovieFromDB(int id) {
        dalManager.removeMovieFromDB(id);
    }
    
    
    @Override
    public Movie getMovie(int id) {
        return dalManager.getMovie(id);
    }
    
    
    @Override
    public List<Movie> fetchAllMovies() {
        return dalManager.fetchAllMovies();
    }

    
    @Override
    public Movie editMovie(String name, double rating, String filelink, String lastview) {
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
    public Category removeCategoryFromDB(int id) {
        return dalManager.removeCategoryFromDB(id);
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
    
    
}
    
