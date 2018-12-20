/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.MdLevel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class dbLevel {
    public Vector<MdLevel> selectLv()
    {
        Vector<MdLevel> ds = new Vector<MdLevel>();
        Connection cnn = DB.connectionCSDL();
        if(cnn!=null)
        {

            String sql = "SELECT * FROM levels";
            
            Statement stm;
            try {
                stm = cnn.createStatement();
                
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
    
                    MdLevel Lv          = new MdLevel();
                    Lv.id               = rs.getInt("id");
                    Lv.name             = rs.getString("name");
                    Lv.pay              = rs.getDouble("pay");
                   
                    ds.add(Lv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
           

        }
        return ds;
    }
}
