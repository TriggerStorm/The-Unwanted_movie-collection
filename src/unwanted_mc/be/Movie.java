/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.be;

/**
 *
 * @author Niclas, Martin, Micheal and Alan
 */
public class Movie {
    private int id;
    private String title;
    private String category;
    private double rating;
    private int duration;  // in seconds
    private String path;

    
    
    
    public Movie(int id, String title , String category, int rating, int duration, String path) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.duration = duration;        
        this.path = path;

    }

    
    
    public int getId() {
        return id;
    }

    
    
    public String getTitle() {
        return title;
    }

    
   
   public String getCategory() {
        return category;
    }

    
    
   public double getRating() {
        return rating;
    }
   
   
   
 public int getDuration() {
        return duration;
    }
   
    
   
    public String getPath() {
        return path;
    }
   
    
    
    public void setId() { // may not need this. If not set id variable to final
        this.id = id;
    }

    
    
   public void setTitle(String title) {
        this.title = title;
    }

   
    
    public void setCategory(String category) {
        this.category = category;
    }

    
   
    public void setRating(double rating) {
        this.rating = rating;
    }

     
     public void setDuration(int duration) {  // probably unnecessay method
        this.duration = duration;
    }
   
     
     
    public void setPath(String path) {  // probably unnecessay method
        this.path = path;
    }
    
    @Override
    public String toString() {
        return title + "," + "," + category + "," + rating + "," + duration + ',' + path;
    }
  
    
}
