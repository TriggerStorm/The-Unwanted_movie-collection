/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void addMovieToDB(String name, double rating, String filelink, String lastview) {
    }
    
    
    @Override
    public void removeMovieFromDB(int id) {
    }
    
    
    @Override
    public Movie getMovie(int id) {
        return movieDBDao.getMovie(id);
    }
    
    
    @Override
    public List<Movie> fetchAllMovies() {
        try {
            return movieDBDao.fetchAllMovies();
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
