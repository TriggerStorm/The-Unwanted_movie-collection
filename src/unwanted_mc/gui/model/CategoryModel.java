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

    
    public CategoryModel() {
        bllManager = new BllManager();
        getAllCategories();
    }
        
    
    public void addCategoryToDB(String name) {
        
    }

    
    public ObservableList<Category> getAllCategories() {
        List<Category> allCategories = bllManager.fetchAllCategories();
       
        categoryList = FXCollections.observableArrayList(allCategories);
        System.out.println("all cat model");
        return categoryList;
    }
    
    
    public void createCategory(String name) {
        bllManager.addCategoryToDB(name);
        
    }
        
        
    public void editCategory(String name) {
        Category category = bllManager.editCategory(name);
        categoryList.add(category); 
    }
        
    public void deleteCategory(String name) {
        Category category = bllManager.removeCategoryFromDB(name);
        categoryList.remove(category); 
    }       
        
    
    public void filterCategory(String name) {  // NOT FINISHED
        Category category = bllManager.removeCategoryFromDB(name);
        categoryList.remove(category); 
    }
    
    
}
