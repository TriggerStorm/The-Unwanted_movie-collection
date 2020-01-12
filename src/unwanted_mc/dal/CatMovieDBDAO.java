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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import unwanted_mc.be.CatMovie;
import unwanted_mc.be.Movie;
import unwanted_mc.dal.MovieDBDAO;


/**
 * @author Niclas, Martin, Michael and Alan
 */


public class CatMovieDBDAO {
 
    DBConnection dbc = new DBConnection();
    private CatMovie catmovie;
    private MovieDBDAO movieDBDao;
    
    public CatMovie getCatMovie(int id) {
        return catmovie;
    }
    
    
    public CatMovie addCatMovieToDB(int categoryId, int movieId) {
        String sql = "INSERT INTO catmovie VALUES (?,?)";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, catmovie.getCategoryId());
            stmt.setInt(2, catmovie.getMovieId());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    catmovie.setId((int) generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(CatMovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CatMovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
    public CatMovie removeCatMovieFromDB(int id) {
        String sql = "DELETE FROM catmovie WHERE ID=?";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, catmovie.getId());                     // IS THIS 0 ??
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
        return null;
    }

      
    public List<CatMovie> fetchAllCatMovies() throws SQLException {
        List<CatMovie> allCatMovies = new ArrayList<>();
        try ( Connection con = dbc.getConnection()) {
            String sql = "SELECT * FROM catmovie";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int categoryId = rs.getInt("categoryId");
                int movieId = rs.getInt("movieId");
                allCatMovies.add(new CatMovie(id, categoryId, movieId));
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(CatMovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CatMovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCatMovies;
    }
      
    
    public List<Movie> getAllMoviesInACategory(int categoryId) throws SQLException {
        List<CatMovie> allCatMovies = fetchAllCatMovies();
        List<Movie> allMoviesInACategory = new ArrayList<>();
        List<Movie> allMovies = movieDBDao.fetchAllMovies();
        for(CatMovie catmovie : allCatMovies) {
            if(catmovie.getCategoryId() == categoryId) {
                int movieId = catmovie.getMovieId();
                Movie movieInCategory = movieDBDao.getMovie(allMovies, movieId);
                allMoviesInACategory.add(movieInCategory);
            }
        }
        return allMoviesInACategory;
    }
        
        
}
