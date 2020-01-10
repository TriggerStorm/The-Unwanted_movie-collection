/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import java.util.List;
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public interface IDAL {
    
     
    void addMovieToDB(String name, double rating, String filelink, String lastview);
    void removeMovieFromDB(Movie movieToRemove);
    Movie getMovie(int id);
    List<Movie> fetchAllMovies();
    void editMovie(String name, double rating, String filelink, String lastview);
    List<Movie> findMoviesToRemove();
    void updateLastView(int id, String dateNow);
    boolean testForLastView(int id);
 
    void addMovieToCategory(int movieID, int categoryID);
    void removeMovieFromCategory(int movieID, int categoryID);
    
    void addCategoryToDB(String name);
    void removeCategoryFromDB(int id);
    List<Category> fetchAllCatagories();
    void editCategory(String name);
    Category getCategory(int id);
   
    
}
