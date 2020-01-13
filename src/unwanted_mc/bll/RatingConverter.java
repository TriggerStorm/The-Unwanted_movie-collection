/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;


/**
 * @author Niclas, Martin, Michael and Alan
 */


public class RatingConverter {
    
    public String RatingIntToString(int ratingInt) {
        String ratingString = String.valueOf(ratingInt);
        return ratingString;
    }
    
    
    public int RatingStringToInt(String ratingString) {
        int ratingInt = Integer.parseInt(ratingString);
        return ratingInt;
    }
    
    
    
    public double percentToDecimal(int percentRating) {
        double decimalRating = percentRating / 10;
        return decimalRating;
    }
    
    
     public int decimalToPercent(double decimalRating) {
        int percentRating = (int) (decimalRating * 10);
        return percentRating;
    }
}
