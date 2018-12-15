/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.MdNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class dbNhanVien {
    public Vector<MdNhanVien> select()
    {
        Vector<MdNhanVien> ds = new Vector<MdNhanVien>();
        Connection cnn = DB.connectionCSDL();
        if(cnn!=null)
        {
//            String sql = "SELECT sv.*,lh.Tenlop FROM tbSinhvien as sv "
//                    + "INNER JOIN tbLophoc AS lh ON sv.malop=lh.Malop";
            String sql = "SELECT us.*,lv.name as namelv FROM users As us INNER JOIN levels As lv ON us.level_id = lv.id";
            
                Statement stm;
            try {
                stm = cnn.createStatement();
                
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
    
                    MdNhanVien Nv       = new MdNhanVien();
                    Nv.id               = rs.getInt("id");
                    Nv.email            = rs.getString("email");
                    Nv.name             = rs.getString("name");
                    Nv.password         = rs.getString("password");
                    Nv.sex              = rs.getInt("sex")==1?"Nam":"nữ";
                    Nv.address          = rs.getString("address");
                    Nv.birthday         = rs.getString("birthday");
                    Nv.level            = rs.getString("namelv");
                    Nv.auther          = rs.getInt("author")==1?"Nhân viên":"Admin";
                    Nv.status           = rs.getInt("status")==0?"Chưa điểm danh":"Đã điểm danh";
                    ds.add(Nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
           

        }
        return ds;
    }
//    public boolean ThemSinhvien(clsSinhvien sv)
//    {
//        Connection cnn = Database.KetnoiCSDL();
//        if(cnn!=null)
//        {
//            String sql = "INSERT INTO tbSinhvien VALUES(NULL,?,?,?,?,?)";
//            try {
//                PreparedStatement stm = cnn.prepareStatement(sql);
//                stm.setString(1, sv.masv);
//                stm.setString(2, sv.hoten);
//                stm.setBoolean(3, sv.gioitinh);
//                stm.setString(4, sv.diachi);
//                stm.setInt(5, sv.malop);
//                int n = stm.executeUpdate();
//                if(n<=0)
//                    return false;
//                else
//                    return true;
//            } catch (SQLException ex) {
//                Logger.getLogger(tbLophoc.class.getName()).log(Level.SEVERE, null, ex);
//                return false;
//            }
//        }
//        
//        else
//            return false;
//    }
}
