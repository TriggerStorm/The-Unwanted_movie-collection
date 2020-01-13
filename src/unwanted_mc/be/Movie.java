/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.be;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class Movie {
    private int id;
    private String name;
    private int rating;
    private String filelink;
    private String lastview;
    private String stringRating;
    private String catString;
    
    
    public Movie(int id, String name, int rating, String filelink, String lastview) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.filelink = filelink;        
        this.lastview = lastview;

    }


    public void setCatString(String catString) {
        this.catString = catString;
    }

    public String getCatString() {
        return catString;
    }

    
    
    public int getId() {
        return id;
    }

    
    
    public String getName() {
        return name;
    }

    
    
   public int getRating() {
        return rating;
    }
   
   
   
    public String getFileLink() {
        return filelink;
    }
   
    
    
    public String getLastView() {
        return lastview;
    }
    
    
    
    public void setId(int id) { // may not need this. If not set id variable to final
        this.id = id;
    }

    
    
   public void setName(String name) {
        this.name = name;
    }

   
   
    public void setRating(int rating) {
        this.rating = rating;
    }

     
    
    public void setFileLink(String filelink) {  // probably unnecessay method
        this.filelink = filelink;
    }
    
    
    
     public void setLastView(String lastview) {  // probably unnecessay method
        this.lastview = lastview;
    }
   
     
     
    @Override
    public String toString() {  // May be needed
        return name + "," + rating + "," + filelink + ',' + lastview;
    }
  
    public void setStringRating(String stringRating){
        this.stringRating = stringRating;
    }
    
    public String getStringRating(){
    return this.stringRating;
    }
}
