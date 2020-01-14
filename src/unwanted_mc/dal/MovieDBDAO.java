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


public class MovieDBDAO {
    
    DBConnection dbc = new DBConnection();
    private Movie movie; // = new Movie(1,"MovieTest1", 8,"src/Movie1.MP4", "11 January 2020" ); //TEST ONLY
    private DateConverter dateconverter = new DateConverter();  // Use manager later
    private CatMovieDBDAO catMovieDBDao = new CatMovieDBDAO();
    
    
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
    
    
     public Movie addMovieToDB(String name, double rating, String filelink, String lastview) {
        String sql = "INSERT INTO movie VALUES (?,?,?,?)";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, movie.getName());
            stmt.setDouble(2, movie.getRating());
            stmt.setString(3, movie.getFileLink());
            stmt.setString(4, movie.getLastView());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    movie.setId((int) generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
      public void removeMovieFromDB(int id) {
        String stat = "DELETE FROM movie WHERE ID=?";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(stat);
            stmt.setInt(1, movie.getId());                      // IS THIS 0 ??
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
    }

      
      
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
                String lastview = rs.getString("lastview");
                String catString = catMovieDBDao.getAllCategoriesOfAMovie(id);
                allMovies.add(new Movie(id, name, rating, filelink, lastview, catString));
                
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMovies;
    }
      
    
    
    public Movie editMovie(String name, int rating, String filelink, String lastview) {
        try (//Get a connection to the database.
            Connection con = dbc.getConnection()) {
            //Create a prepared statement.
            String sql = "UPDATE movie SET name = ?, rating = ?, filelink = ?, lastview = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Set parameter values.
            pstmt.setString(1, name);
            pstmt.setInt(2, rating);
            pstmt.setString(3, filelink);
            pstmt.setString(4, lastview);
            //Execute SQL query.
            pstmt.executeUpdate();
            movie.setName(name);
            movie.setRating(rating);
            movie.setFileLink(filelink);
            movie.setLastView(lastview);
            return movie;
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    public List<Movie> findMoviesToRemove() throws SQLException {  // Creates a list of movies that have a rating below 6, and haven't been played in two years.
        List<Movie> allMovies = new ArrayList<>();
        List<Movie> moviesToDelete = new ArrayList<>();
        allMovies = fetchAllMovies();
        for(Movie movie : allMovies) {
            String lastViewedDate = movie.getLastView();
            int movieId = movie.getId();
            boolean overTwoYears = testForLastView(movieId);
            if ((movie.getRating() < 6) && (overTwoYears)) {
            moviesToDelete.add(movie);
            }
        }
        return moviesToDelete;
    }
    
    
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
           
            movie.setLastView(dateNow);
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean testForLastView(int id) throws SQLException {
        boolean overTwoYears = false;
        List<Movie> allMovies = fetchAllMovies();
        Movie movieToTest = getMovie(allMovies, id);
        LocalDate dateNow = LocalDate.now();
        String lastViewed = movieToTest.getLastView();
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
