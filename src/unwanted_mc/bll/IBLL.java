/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.io.IOException;
import java.util.List;
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public interface IBLL {
    
    
    void addMovieToDB(String name, double rating, String filelink, String lastview);
    void removeMovieFromDB(int id);
    Movie getMovie(int id);
    List<Movie> fetchAllMovies();
    void editMovie(String name, double rating, String filelink, String lastview);
    List<Movie> findMoviesToRemove();

    void addMovieToCategory(int movieID, int categoryID);
    void removeMovieFromCategory(int movieID, int categoryID);
    
    void addCategoryToDB(String name);
    void removeCategoryFromDB(int id);
    Category getCategory(int id);
   

}
