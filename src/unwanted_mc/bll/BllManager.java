/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.util.List;
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;
import unwanted_mc.dal.DalManager;
import unwanted_mc.dal.IDAL;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class BllManager implements IBLL{
    
    private IDAL dalManager;
       
    
    
    public BllManager() {
  

        dalManager = new DalManager();
    }
    
 
 
    @Override
    public void addMovieToDB(String name, double rating, String filelink, String lastview) {
    }
    
    
    @Override
    public void removeMovieFromDB(int id) {
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
    public void editMovie(String name, double rating, String filelink, String lastview) {
    }
    
    
    @Override
    public void addMovieToCategory(int movieID, int categoryID) {
    }
    
    
    @Override
    public void removeMovieFromCategory(int movieID, int categoryID) {
    }
    
    
    @Override
    public void addCategoryToDB(String name) {
    }
    
    
    @Override
    public void removeCategoryFromDB(int id){
    }
    
    
    @Override
    public Category getCategory(int id) {
        return dalManager.getCategory(id);
    }
    
    
}
    
