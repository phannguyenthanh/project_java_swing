/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.MdLevel;
import Models.MdNhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    
    public boolean addNV(MdNhanVien NV) 
    {
//        Date date = new Date();
        Connection cnn = DB.connectionCSDL();
        if(cnn!=null)
        {
            String sql = "INSERT INTO tbSinhvien VALUES(NULL,?,?,?,?,?,?,?,?,'2018-10-25','2018-10-25','1975-12-06',0,30,1,NULL,?,?)";
//            https://gpcoder.com/2217-lay-ngay-gio-hien-tai-trong-java/
            long millis=System.currentTimeMillis();  
            Date date=new Date(millis);  
//            System.out.println();  
            
            
            SimpleDateFormat formatDate = new SimpleDateFormat("dd-mm-yyyy");
            PreparedStatement stm;
            try {
                stm = cnn.prepareStatement(sql);
                stm.setString(1, NV.email);
                stm.setString(2, NV.name);
                stm.setString(3, NV.password);
                stm.setInt(4,  Integer.parseInt(NV.sex));
                stm.setString(5, NV.address);
                stm.setDate(6, (Date) formatDate.parse(NV.birthday));
                stm.setInt(7, Integer.parseInt(NV.auther));
                stm.setInt(8, Integer.parseInt(NV.level));
//                stm.setDate(9, date);
//                stm.setDate(10, Date());
            
                int n = stm.executeUpdate();
                if(n<=0)
                    return false;
                else
                    return true;
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (ParseException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
                
            
        }
        else
            return false;
    }


}
