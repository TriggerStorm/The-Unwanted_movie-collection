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
import java.util.logging.Level;
import java.util.logging.Logger;
import unwanted_mc.be.CatMovie;


/**
 * @author Niclas, Martin, Michael and Alan
 */


public class CatMovieDBDAO {
 
        DBConnection dbc = new DBConnection();
        private CatMovie catmovie;
   
    
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
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
      public CatMovie removeCatMovieFromDB(int id) {
        String sql = "DELETE FROM catmovie WHERE ID=?";
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, catmovie.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
        return null;
    }

      
}
