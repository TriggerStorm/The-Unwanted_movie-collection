/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import java.util.Calendar;
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;
import unwanted_mc.bll.BllManager;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class DalManager implements IDAL {
    
    private MovieDBDAO movieDBDao; 
    private CategoryDBDAO categoryDBDao;

    
    public DalManager() {
         movieDBDao = new MovieDBDAO();
         categoryDBDao = new CategoryDBDAO();
    }
    
    
    @Override
    public void addMovieToDB(String name, double rating, String filelink, Calendar lastview) {
    }
    
    
    @Override
    public void removeMovieFromDB(int id) {
    }
    
    
    @Override
    public Movie getMovie(int id) {
        return movieDBDao.getMovie(id);
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
        return categoryDBDao.getCategory(id);
        
    }
    
    
}
