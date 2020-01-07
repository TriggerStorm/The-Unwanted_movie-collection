/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import unwanted_mc.be.Movie;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class MovieDBDAO {
    
        DBConnection dbc = new DBConnection();

    private Movie movie = new Movie(1,"name", 8,"path", "070120" ); //TEST ONLY
    
    public Movie getMovie(int id) {
        return movie;
    }
    
     public void addMovieToDB(Movie movie) {
        String stat = "INSERT INTO Song VALUES (?,?,?,?)";
        try (Connection xd = dbc.getConnection()) {
            PreparedStatement stmt = xd.prepareStatement(stat, PreparedStatement.RETURN_GENERATED_KEYS);
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
    }
     
     
      public void removeMovieFromDB(Movie movie) {
        String stat = "DELETE FROM song WHERE ID=?";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(stat);
            stmt.setInt(1, movie.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
    }

      
}
