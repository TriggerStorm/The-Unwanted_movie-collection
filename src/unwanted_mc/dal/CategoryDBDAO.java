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
    private DBConnection dbc;
/**
 * get the db connection
 */
    public CategoryDBDAO(){
       dbc = new DBConnection(); 
    }
   
    /**
     * get a list of categorys
     * @param allCategories
     * @param id
     * @return
     * @throws SQLException 
     */
    
    public Category getCategory(List<Category> allCategories, int id) throws SQLException {
      int allCategoriesSize = allCategories.size();
      Category testCat = new Category(9999, "no cat found");
      if (allCategoriesSize > 0){
            for (int i = 0; i < allCategories.size(); i++) {
            Category category = allCategories.get(i);
            int categoryId = category.getId();
            if (categoryId == id)  {
            return category;
            }
        }
      }
      return testCat;    
    }
    
    
    /**
     * add a value to the table category in the DB.
     * @param name 
     */
     
    public void addCategoryToDB(String name) {
   try ( Connection con = dbc.getConnection()) {
            String sql = "INSERT INTO category values (?)";
            PreparedStatement p = con.prepareStatement(sql);
            //PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            p.setString(1, name);
            p.executeUpdate();
            System.out.println("add dall");

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * removes a category where id match in DB.
     * @param name
     * @return 
     */
    
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
    
     /**
      * gets all values form the table category in DB. and all to a list of allCategories
      * @return
      * @throws SQLException 
      */
      public List<Category> fetchAllCategories() throws SQLException {
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
      
    /**
     * updates a value in the table Category in db. 
     * @param name
     * @return 
     */
    public Category editCategory(String name){
    try ( Connection con = dbc.getConnection()) {
            String sql = "UPDATE Category set name=?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, category.getName());
            p.executeUpdate();

        } catch (SQLServerException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(CategoryDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
}