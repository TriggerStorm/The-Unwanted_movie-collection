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
        
        
public class SearchFilterByRatingAbove {
    
    /**
     * Filters a list of songs and returns a filtered list matching the search
     * query.
     *
     * @param searchBase The list of movies to filter.
     * @param query The search query.
     * @return A list of movies that matches the search query.
     */
    
    public List<Movie> search(List<Movie> searchBase, String query) {
        //case insensitive and partial search
        List<Movie> filtered = new ArrayList();
        
        if (query.isEmpty()) {
            return searchBase;
        }
        double value = Double.parseDouble(query);

        for (Movie movie : searchBase) {
            if (movie.getRating() >= value ) {
                filtered.add(movie);
            } 
        }
        return filtered;
    }

}
