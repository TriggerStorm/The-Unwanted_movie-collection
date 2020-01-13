/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unwanted_mc.be;


/*
 * @author Niclas, Martin, Michael and Alan
 */


public class Category {
    int id;
    String cat;
    
    
    public Category(int id, String cat) {
    this.id = id;
    this.cat = cat;
    }

    
    public int getId() {
        return id;
    }

    
    public String getCat() {
        return cat;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public void setName(String cat) {
        this.cat = cat;
    }

}
