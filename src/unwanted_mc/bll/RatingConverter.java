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
    /*
    takes the rating int and convertes it to string.
    */
    public String RatingIntToString(int ratingInt) {
        String ratingString = String.valueOf(ratingInt);
        return ratingString;
    }
    /*
    takes the rating string and convertes it to int.
    */
    
    public int RatingStringToInt(String ratingString) {
        int ratingInt = Integer.parseInt(ratingString);
        return ratingInt;
    }
    
    /*
    takes the procent rating and converts it to a decimal rating.
    */
    
    public double percentToDecimal(int percentRating) {
        double decimalRating = percentRating / 10;
        return decimalRating;
    }
    /*
    takes the decimal rating and converts it in to procent rating.
    */
    
     public int decimalToPercent(double decimalRating) {
        int percentRating = (int) (decimalRating * 10);
        return percentRating;
    }
}
