/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thanh
 */
public class DB {
    static String user = "root";
    static String password = "";
    static String url =  "jdbc:mysql://localhost:3306/account?useUnicode=true&characterEncoding=utf8";
    
    public static Connection connectionCSDL()
    {
        Connection cnn = null;
        try {
            cnn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi kết nối Database .", "lỗi", 0);
        }
        return cnn;
        
    }
    
}
