/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author thanh
 */
public class MdNhanVien {
    public int     id;
    public String  email;
    public String  name;
    public String  password;
    public String  sex;
    public String  address;
    public String  birthday;
    public String  level;
    public String  auther;
    public String  status;
    
    
    

    public MdNhanVien() {
        id      = 0;
        email   ="";
        name    ="";
        password="";
        sex     ="";
        address ="";
        birthday    ="";
        level   ="";
        auther  ="";
        status  ="";
    }

    public MdNhanVien(
    int     id,
    String  email,
    String  name,
    String  password,
    String  sex,
    String  address,
    String  birthday,
    String  level,
    String  auther,
    String  status) 
    {
        this.id      =  id;
        this.email   =  email;
        this.name    =  name;
        this.password=  password;
        this.sex     =  sex;
        this.address =  address;
        this.birthday    =  birthday;
        this.level   =  level;
        this.auther  =  auther;
        this.status  =  status;
    }

  
}
