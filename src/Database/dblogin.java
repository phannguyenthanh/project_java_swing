/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thanh
 */
public class dblogin {
    public int checkLogin(String email, String pass)
    {
        int result      = 0;
        Connection cnn  = DB.connectionCSDL();
        String sql ;
        sql = "SELECT * FROM users"+" WHERE email = '"+email+"' AND password ='"+pass+"'";

        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery(sql);
            while (rs.next()) {                
                result++;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(dblogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, result, "lỗi", 0);
        }
        
        return result;
    }
}
