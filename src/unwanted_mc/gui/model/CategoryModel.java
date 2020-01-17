/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.gui.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import unwanted_mc.be.Category;
import unwanted_mc.bll.BllManager;


/**
 * @author Niclas, Martin, Michael and Alan
 */


public class CategoryModel {
    
    private BllManager bllManager;
    private ObservableList<Category> categoryList;

    /**
     * get a connection to the BllManager and call getAllCategories.
     */
    public CategoryModel() {
        bllManager = new BllManager();
        getAllCategories();
    }
        
   

    /**
     * gets a list of all categories and make a new observable list and add
     * all the values. and retun the new list
     * @return 
     */
    public ObservableList<Category> getAllCategories() {
        List<Category> allCategories = bllManager.fetchAllCategories();
       
        categoryList = FXCollections.observableArrayList(allCategories);
        return categoryList;
    }
    
    /**
     * add a category to db
     * @param name 
     */
    public void createCategory(String name) {
        bllManager.addCategoryToDB(name);
        
    }
        
     /**
      * updates the value of a category.
      * @param name 
      */   
    public void editCategory(String name) {
        Category category = bllManager.editCategory(name);
        categoryList.add(category); 
    }
        /**
         * delete selected categoty form db and remove from the category list.
         * @param name 
         */
    public void deleteCategory(String name) {
        Category category = bllManager.removeCategoryFromDB(name);
        categoryList.remove(category); 
    }       
        
    /**
     * filter the category and retun remove category form list.
     * @param name 
     */
    public void filterCategory(String name) {  // NOT FINISHED
        Category category = bllManager.removeCategoryFromDB(name);
        categoryList.remove(category); 
    }
    
    
}
