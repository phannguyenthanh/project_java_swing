/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author thanh
 */
public class MdLevel {
    public int      id;
    public String   name;
    public double   pay;
 

    public MdLevel() {
        id      = 0;
        name    ="";
        pay     =0;
       
    }

    public MdLevel(
    int      id,
    String   name,
    double   pay) 
    {
        this.id         =  id;
        this.name       =  name;
        this.pay        =  pay;
       
    }
}
