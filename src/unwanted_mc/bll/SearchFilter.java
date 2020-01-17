/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.util.ArrayList;
import java.util.List;
import unwanted_mc.be.Movie;

/*
 * @author Niclas, Martin, Michael and Alan
 */
        
        
public class SearchFilter {

    /**
     * Filters a list of Movies and returns a filtered list matching the search
     @param allMovies
     @param query
     */
    
    public List<Movie> searchByName(List<Movie> allMovies, String query) {
        //case insensitive and partial search
        List<Movie> filtered = new ArrayList();

        if (query.isEmpty()) {
            return allMovies;
        }
        for (Movie movie : allMovies) {
            if (movie.getName().toLowerCase().contains(query.trim().toLowerCase())) {
                filtered.add(movie);
            } 
        }
        return filtered;
    }

    /**
     * Filters a list of Movies by rating above and returns a filtered list matching the search
     @param allMovies
     @param query
     */
    
     public List<Movie> searchByRatingAbove(List<Movie> allMovies, String query) {
        //case insensitive and partial search
        List<Movie> filtered = new ArrayList();
        
        if (query.isEmpty()) {
            return allMovies;
        }
        double value = Double.parseDouble(query);

        for (Movie movie : allMovies) {
            if (movie.getRating() >= value ) {
                filtered.add(movie);
            } 
        }
        return filtered;
    }

      /**
     * Filters a list of Movies by rating below and returns a filtered list matching the search
     @param allMovies
     @param query
     */
     
      public List<Movie> searchByRatingBelow(List<Movie> allMovies, String query) {
        //case insensitive and partial search
        List<Movie> filtered = new ArrayList();
        
        if (query.isEmpty()) {
            return allMovies;
        }
        double value = Double.parseDouble(query);

        for (Movie movie : allMovies) {
            if (movie.getRating() <= value ) {
                filtered.add(movie);
            } 
        }
        return filtered;
    }

}
