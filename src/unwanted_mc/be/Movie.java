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
    //private String lastviewed;
    private String stringRating;
    private String catString;
    private String FPL;
    
    
    public Movie(int id, String name, int rating, String filelink, String FPL, String catString) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.filelink = filelink;        
        this.FPL = FPL;                           //this.lastviewed = lastviewed;
        this.catString = catString;

    }
    public Movie(String name, int rating, String filelink, String FPL) {
        
        this.name = name;
        this.rating = rating;
        this.filelink = filelink;        
        this.FPL = FPL;                           //this.lastviewed = lastviewed;
        

    }


    public void setCatString(String catString) {
        this.catString = catString;
    }

    public String getFPL() {
        return FPL;
    }

    public void setFPL(String FPL) {
        this.FPL = FPL;
    }

    /*public String getLastviewed() {
        return lastviewed;
    }
      public void setLastviewed(String lastviewed) {
        this.lastviewed = lastviewed;
    }*/

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

    @Override
    public String toString() {
        return "" + rating + "";
    }
   
   
   
    public String getFileLink() {
        return filelink;
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

     
    
    public void setFileLink(String filelink) {
        this.filelink = filelink;
    }
    
  
  
     
     
    /*@Override
    public String toString() {  // May be needed
        return name + "," + rating + "," + filelink + ',' + FPL;
    }*/
  
    public void setStringRating(String stringRating){
        this.stringRating = stringRating;
    }
    
    public String getStringRating(){
        return this.stringRating;
    }
}
