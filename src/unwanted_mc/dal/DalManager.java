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
import unwanted_mc.be.CatMovie;
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
    private CatMovieDBDAO catmovieDBDao;

    
    public DalManager() {
         movieDBDao = new MovieDBDAO();
         categoryDBDao = new CategoryDBDAO();
         catmovieDBDao = new CatMovieDBDAO();
    }
    
    
    
    @Override
    public Movie addMovieToDB(String name, int rating, String filelink, String lastview) {
        return movieDBDao.addMovieToDB(name, rating, filelink, lastview);
    }
        
    
    @Override
    public void removeMovieFromDB(int id) {
        movieDBDao.removeMovieFromDB(id);
    }
    
    
    @Override
    public Movie getMovie(List<Movie> allMovies, int id) {
        try {
            return movieDBDao.getMovie(allMovies, id);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    public Movie editMovie(String name, int rating, String filelink, String lastview) {
        return  movieDBDao.editMovie(name, rating, filelink, lastview);
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
    public CatMovie addCatMovieToDB(int movieID, int categoryID) {
        return catmovieDBDao.addCatMovieToDB(movieID, categoryID);
    }
    
    
    @Override
    public CatMovie removeCatMovieFromDB(int id) {
        return catmovieDBDao.removeCatMovieFromDB(id);
    }
    
           
    @Override
    public List<CatMovie> fetchAllCatMovies() {
        try {
            return catmovieDBDao.fetchAllCatMovies();
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    
    

    
    @Override
    public Category addCategoryToDB(String name) {
        return categoryDBDao.addCategoryToDB(name);
    }
    
    
    @Override
    public Category removeCategoryFromDB(String name) {
        return categoryDBDao.removeCategoryFromDB(name);
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
    public Category editCategory(String name) {
        return categoryDBDao.editCategory(name);
    }

    
    @Override
    public Category getCategory(List<Category> allCategories, int id) {
        try {
            return categoryDBDao.getCategory(allCategories,id);
        } catch (SQLException ex) {
            Logger.getLogger(DalManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    
}
