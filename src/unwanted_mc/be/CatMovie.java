/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.be;

/**
 *
 * @author admin
 */
public class CatMovie {

    int id;
    int categoryId;
    int movieId;
    
    
    public CatMovie(int id, int categoryId, int movieId) {
        this.id = id;
        this.categoryId = categoryId;
        this.movieId = movieId;
    }

    
    public int getId() {
        return id;
    }

    
    public int getCategoryId() {
        return categoryId;
    }

    
    public int getMovieId() {
        return movieId;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    
    public void setCategoryID(int categoryId) {
        this.categoryId = categoryId;
    }
    
    
     public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
     
     
}
