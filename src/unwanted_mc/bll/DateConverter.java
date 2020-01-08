/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.bll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
 
/*
 * @author Niclas, Martin, Michael and Alan
 */
        
        
public class DateConverter {

    
    public String dateNowToString() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateNow = now.format(formatter);
        return dateNow;
    } 
   
    
    public LocalDate stringToDateNow(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        LocalDate dateNow = LocalDate.parse(dateString, formatter);
        return dateNow;
    }

}
