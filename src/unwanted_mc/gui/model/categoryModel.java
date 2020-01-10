/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import unwanted_mc.be.Category;
/**
 *
 * @author Martin Park Broderse
 */
public class categoryModel {
    private ObservableList<Category> allCategories;

    public ObservableList<Category> getallCategories() {
        allCategories = FXCollections.observableArrayList();
        allCategories.addAll(allCategories);
        return allCategories;
    }
    
}
