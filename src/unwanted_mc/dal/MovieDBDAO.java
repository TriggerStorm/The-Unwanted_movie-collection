/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import java.util.Calendar;
import unwanted_mc.be.Movie;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class MovieDBDAO {
    private Movie testmovie = new Movie(1,"name", 8,"path", Calendar.getInstance() ); //TEST ONLY
    
    public Movie getMovie(int id) {
        return testmovie;
    }
}
