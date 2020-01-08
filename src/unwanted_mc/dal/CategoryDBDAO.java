/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import unwanted_mc.be.Category;




/*
 * @author Niclas, Martin, Michael and Alan
 */


public class CategoryDBDAO {
    
    private Category category; //TEST ONLY
     
    DBConnection connectDAO = new DBConnection();
   
    
    public Category getCategory(int id) {
        return category;
    }
    
    
     
    public void addCategoryToDB(String name) {
   try ( Connection con = connectDAO.getConnection()) {
            String sql = "INSERT INTO Category (name) values (?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, name);
            p.executeUpdate();

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    
    public void removeCategoryFromDB(String name){
        try ( Connection con = connectDAO.getConnection()) {
            String sql = "DELETE FROM Category WHERE id=?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, category.getId());
            p.executeUpdate();

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void editCategoryFromDB(String name){
    try ( Connection con = connectDAO.getConnection()) {
            String sql = "UPDATE Category set name=?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, category.getName());
            p.executeUpdate();

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}