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
import unwanted_mc.bll.DateConverter;


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
        movieDBDao.addMovieToDB(name, rating, filelink, lastview);
    }
        
    
    @Override
    public void removeMovieFromDB(Movie movieToRemove) {
        movieDBDao.removeMovieFromDB(movieToRemove);
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
    public void editMovie(String name, double rating, String filelink, String lastview) {
        movieDBDao.editMovie(name, rating, filelink, lastview);
    }

    
    @Override
    public List<Movie> findMoviesToRemove() {
        try {
            return movieDBDao.findMoviesToRemove();
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    public void updateLastView(int id, String dateNow) {
        movieDBDao.updateLastView(id, dateNow);
    }

    
    public boolean testForLastView(int id) {
        try {
            return movieDBDao.testForLastView(id);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    @Override
    public void addMovieToCategory(int movieID, int categoryID) {
        movieDBDao.addMovieToCategory(movieID, categoryID);
    }
    
    
    @Override
    public void removeMovieFromCategory(int movieID, int categoryID) {
        movieDBDao.removeMovieFromCategory(movieID, categoryID);
    }
    
    
    @Override
    public void addCategoryToDB(String name) {
        categoryDBDao.addCategoryToDB(name);
    }
    
    
    @Override
    public void removeCategoryFromDB(int id) {
        categoryDBDao.removeCategoryFromDB(id);
    }
    
    
        @Override
    public List<Category> fetchAllCatagories() {
        try {
            return categoryDBDao.fetchAllCatagories();
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Category getCategory(int id) {
        return categoryDBDao.getCategory(id);
    }
    
    
}
