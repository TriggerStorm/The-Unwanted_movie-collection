/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import unwanted_mc.be.Movie;
import unwanted_mc.bll.DateConverter;


/*
 * @author Niclas, Martin, Michael and Alan
 */

/**
 * get the connection to the DB
 * 
 */
public class MovieDBDAO {
    
    DBConnection dbc = new DBConnection();
   // private Movie movie; // = new Movie(1,"MovieTest1", 8,"src/Movie1.MP4", "11 January 2020" ); //TEST ONLY
    private DateConverter dateconverter = new DateConverter();  // Use manager later
    private CatMovieDBDAO catMovieDBDao = new CatMovieDBDAO();

   
    /**
     * get all the movies
     * @param allMovies
     * @param id
     * @return
     * @throws SQLException 
     */
    
    public Movie getMovie(List<Movie> allMovies, int id) throws SQLException {
         for (int i = 0; i < allMovies.size(); i++) {
            Movie movie = allMovies.get(i);
            int movieId = movie.getId();
            if (movieId == id)  {
            return movie;
            }
        }
        return null;
    }
    
    /**
     * add values in the the table movies in the DB. and add them to a list.
     * @param name
     * @param rating
     * @param filelink
     * @param lastview
     * @return 
     */
     public Movie addMovieToDB(String name, int rating, String filelink, String lastview) { 
        String sql = "INSERT INTO movies(name, filelink, rating, lastview) VALUES (?,?,?,?)";
        Movie m = new Movie(name, rating, filelink, lastview);
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, filelink);
            stmt.setInt(3, rating);
            stmt.setString(4, lastview);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating movie failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    m.setId((int) generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating movie failed, no ID obtained.");
                } 
                return m;
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     /**
      * remove value form the table movies where id match in the DB.
      * @param movie 
      */
      public void removeMovieFromDB(Movie movie) {
        String stat = "DELETE FROM movies WHERE id =?";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(stat);
            stmt.setInt(1,movie.getId());                      // IS THIS 0 ??
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
    }

      /**
       * gets the vallue of the table moives in the db and add to a list allMovies.
       * @return
       * @throws SQLException 
       */
      
    public List<Movie> fetchAllMovies() throws SQLException {
        List<Movie> allMovies = new ArrayList<>();

        try ( Connection con = dbc.getConnection()) {
            String sql = "SELECT * FROM movies";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int rating = rs.getInt("rating");
                String filelink = rs.getString("filelink");    
                String FPL = rs.getString("lastview");                             //rs.getString("lastview");
                String catString = ("mokdata");                           //catMovieDBDao.getAllCategoriesOfAMovie(id);
                allMovies.add(new Movie(id, name, rating, filelink, FPL, catString));
                
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMovies;
    }
      
    /**
     * updates the values in the table movies in the DB.
     * @param movie
     * @param name
     * @param rating
     * @param filelink
     * @param lastview
     * @return 
     */
    
    public Movie editMovie(Movie movie, String name, int rating, String filelink, String lastview) {
        try (//Get a connection to the database.
            Connection con = dbc.getConnection()) {
            //Create a prepared statement.
            String sql = "UPDATE movies SET name = ?, filelink = ?, rating = ?, lastview = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Set parameter values.
            pstmt.setString(1, name);
            pstmt.setInt(3, rating);
            pstmt.setString(2, filelink);
            pstmt.setString(4, lastview);
            pstmt.setInt(5, movie.getId());
            //Execute SQL query.
            pstmt.executeUpdate();
            movie.setName(name);
            movie.setFileLink(filelink);
            movie.setRating(rating);
            movie.setFPL(lastview); 
            return movie;
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    /**
     * gets all movies and checks if the rating is below and extenden the date value.
     * and returns a list of movies to delete
     * @return
     * @throws SQLException 
     */
    public List<Movie> findMoviesToRemove() throws SQLException {  // Creates a list of movies that have a rating below 6, and haven't been played in two years.
        List<Movie> allMovies = new ArrayList<>();
        List<Movie> moviesToDelete = new ArrayList<>();
        allMovies = fetchAllMovies();
        for(Movie movie : allMovies) {
            String lastViewedDate = movie.getFPL();
            int movieId = movie.getId();
            boolean overTwoYears = testForLastView(movieId);
            if ((movie.getRating() < 6) && (overTwoYears)) {
            moviesToDelete.add(movie);
            }
        }
        return moviesToDelete;
    }
    
    /**
     * updates the value lastview in the DB where id match.
     * @param id
     * @param dateNow 
     */
    public void updateLastView(int id, String dateNow) {
        try (//Get a connection to the database.
            Connection con = dbc.getConnection()) {
            //Create a prepared statement.

            String sql = "UPDATE movie SET lastview = dateNow WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Set parameter values.
         
            pstmt.setString(4, dateNow);
            //Execute SQL query.
            pstmt.executeUpdate();
           
            //movie.setFPL(dateNow);
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * test if the value of last viewd is extenden date and return a list overTwoYears.
     * @param id
     * @return
     * @throws SQLException 
     */
    public boolean testForLastView(int id) throws SQLException {
        boolean overTwoYears = false;
        List<Movie> allMovies = fetchAllMovies();
        Movie movieToTest = getMovie(allMovies, id);
        LocalDate dateNow = LocalDate.now();
        String lastViewed = movieToTest.getFPL();
        dateconverter.stringToLocalDate(lastViewed);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        LocalDate lastViewedDate = LocalDate.parse(lastViewed, formatter);
        Period period = Period.between(dateNow, lastViewedDate);
        int diff = period.getDays();
        if (diff > 730) {
            overTwoYears = true;
        }
        return overTwoYears;
    }

    
}
