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
import unwanted_mc.be.Category;
import unwanted_mc.be.Movie;




/*
 * @author Niclas, Martin, Michael and Alan
 */


public class CategoryDBDAO {
    
    private Category category;
     
    DBConnection dbc = new DBConnection();
   
    
    public Category getCategory(int id) {
        return category;
    }
    
    
     
    public Category addCategoryToDB(String name) {
   try ( Connection con = dbc.getConnection()) {
            String sql = "INSERT INTO Category (name) values (?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, name);
            p.executeUpdate();

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public Category removeCategoryFromDB(String name){
        try ( Connection con = dbc.getConnection()) {
            String sql = "DELETE FROM Category WHERE id=?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, category.getId());
            p.executeUpdate();

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     
      public List<Category> fetchAllCatagories() throws SQLException {
        List<Category> allCategories = new ArrayList<>();

        try ( Connection con = dbc.getConnection()) {
            String sql = "SELECT * FROM category";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                allCategories.add(new Category(id, name));
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCategories;
    }
      
      
    public Category editCategory(String name){
    try ( Connection con = dbc.getConnection()) {
            String sql = "UPDATE Category set name=?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, category.getCat());
            p.executeUpdate();

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
}