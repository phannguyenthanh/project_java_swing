/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.MdWorkday;
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
public class dbWorkday {
    public Vector<MdWorkday> select(int id) {
        Vector<MdWorkday> ds = new Vector<MdWorkday>();
        Connection cnn = DB.connectionCSDL();
        if (cnn != null) {
//            String sql = "SELECT sv.*,lh.Tenlop FROM tbSinhvien as sv "
//                    + "INNER JOIN tbLophoc AS lh ON sv.malop=lh.Malop";
            String sql = "SELECT *  FROM workday WHERE user_id="+id;

            Statement stm;
            try {
                stm = cnn.createStatement();

                ResultSet rs = stm.executeQuery(sql);
                while (rs.next())//duyệt từng bản ghi kết quả select
                {

                    MdWorkday wd = new MdWorkday();
                    wd.id = rs.getInt("id");
                    wd.user_id = rs.getInt("user_id");
                    wd.workday = rs.getInt("workday");
                    wd.monthday = rs.getInt("monthday");
     
                    ds.add(wd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return ds;
    }

}
