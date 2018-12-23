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

    public Vector<MdNhanVien> select() {
        Vector<MdNhanVien> ds = new Vector<MdNhanVien>();
        Connection cnn = DB.connectionCSDL();
        if (cnn != null) {
//            String sql = "SELECT sv.*,lh.Tenlop FROM tbSinhvien as sv "
//                    + "INNER JOIN tbLophoc AS lh ON sv.malop=lh.Malop";
            String sql = "SELECT us.*,lv.name as namelv FROM users As us INNER JOIN levels As lv ON us.level_id = lv.id";

            Statement stm;
            try {
                stm = cnn.createStatement();

                ResultSet rs = stm.executeQuery(sql);
                while (rs.next())//duyệt từng bản ghi kết quả select
                {

                    MdNhanVien Nv = new MdNhanVien();
                    Nv.id = rs.getInt("id");
                    Nv.email = rs.getString("email");
                    Nv.name = rs.getString("name");
                    Nv.password = rs.getString("password");
                    Nv.sex = rs.getInt("sex") == 1 ? "Nam" : "nữ";
                    Nv.address = rs.getString("address");
                    Nv.birthday = rs.getString("birthday");
                    Nv.level = rs.getString("namelv");
                    Nv.auther = rs.getInt("author") == 1 ? "Nhân viên" : "Admin";
                    Nv.status = rs.getInt("status") == 0 ? "Chưa điểm danh" : "Đã điểm danh";
                    ds.add(Nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return ds;
    }

    public Vector<MdNhanVien> search(String search) {
        Vector<MdNhanVien> ds = new Vector<MdNhanVien>();
        Connection cnn = DB.connectionCSDL();
        if (cnn != null) {
//            String sql = "SELECT sv.*,lh.Tenlop FROM tbSinhvien as sv "
//                    + "INNER JOIN tbLophoc AS lh ON sv.malop=lh.Malop";
            String sql = "SELECT us.*,lv.name as namelv FROM users As us INNER JOIN levels As lv ON us.level_id = lv.id WHERE us.name LIKE '%" + search + "%'";

            Statement stm;
            try {
                stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next())//duyệt từng bản ghi kết quả select
                {

                    MdNhanVien Nv = new MdNhanVien();
                    Nv.id = rs.getInt("id");
                    Nv.email = rs.getString("email");
                    Nv.name = rs.getString("name");
                    Nv.password = rs.getString("password");
                    Nv.sex = rs.getInt("sex") == 1 ? "Nam" : "nữ";
                    Nv.address = rs.getString("address");
                    Nv.birthday = rs.getString("birthday");
                    Nv.level = rs.getString("namelv");
                    Nv.auther = rs.getInt("author") == 1 ? "Nhân viên" : "Admin";
                    Nv.status = rs.getInt("status") == 0 ? "Chưa điểm danh" : "Đã điểm danh";
                    ds.add(Nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return ds;
    }

    public boolean addNV(String email, String name, String password, String sex, String address, String birthday, String auther, int level) {
//        Date date = new Date();
        Connection cnn = DB.connectionCSDL();
        if (cnn != null) {
            String sql = "INSERT INTO users VALUES(NULL,?,?,?,?,?,?,?,?,'2018-10-25','2018-10-25','1975-12-06',0,30,1,NULL,?,NULL)";
//            https://gpcoder.com/2217-lay-ngay-gio-hien-tai-trong-java/
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
//            System.out.println();  

            SimpleDateFormat formatDate = new SimpleDateFormat("dd-mm-yyyy");
            PreparedStatement stm;
            try {
                stm = cnn.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, name);
                stm.setString(3, password);
                stm.setInt(4, Integer.parseInt(sex));
                stm.setString(5, address);
                stm.setString(6, birthday);
                stm.setInt(7, Integer.parseInt(auther));
                stm.setInt(8, level);
                stm.setDate(9, date);
//                stm.setDate(10, Date());

                int n = stm.executeUpdate();
                if (n <= 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean UpdateNV(int id, String email, String name, String password, String sex, String address, String birthday, String auther, int level) {
//        Date date = new Date();
        Connection cnn = DB.connectionCSDL();
        if (cnn != null) {
            if ("".equals(password)) {
                    String sql = "UPDATE users SET email=?,name=?,sex=?,address=?,birthday=?,author=?,level_id=?,updated_at=? WHERE id=?";
//              https://gpcoder.com/2217-lay-ngay-gio-hien-tai-trong-java/
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
//              System.out.println();  

                SimpleDateFormat formatDate = new SimpleDateFormat("dd-mm-yyyy");
                PreparedStatement stm;  
                try {
                    stm = cnn.prepareStatement(sql);
                    stm.setString(1, email);
                    stm.setString(2, name);
                    stm.setInt(3, Integer.parseInt(sex));
                    stm.setString(4, address);
                    stm.setString(5, birthday);
                    stm.setInt(6, Integer.parseInt(auther));
                    stm.setInt(7, level);
                    stm.setDate(8, date);
                    stm.setInt(9, id);
//                stm.setDate(10, Date());

                    int n = stm.executeUpdate();
                    if (n <= 0) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } else {
                String sql = "UPDATE users SET email=?,name=?,password=?,sex=?,address=?,birthday=?,author=?,level_id=?,updated_at=? WHERE id=?";
//            https://gpcoder.com/2217-lay-ngay-gio-hien-tai-trong-java/
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
//            System.out.println();  

                SimpleDateFormat formatDate = new SimpleDateFormat("dd-mm-yyyy");
                PreparedStatement stm;
                try {
                    stm = cnn.prepareStatement(sql);
                    stm.setString(1, email);
                    stm.setString(2, name);
                    stm.setString(3, password);
                    stm.setInt(4, Integer.parseInt(sex));
                    stm.setString(5, address);
                    stm.setString(6, birthday);
                    stm.setInt(7, Integer.parseInt(auther));
                    stm.setInt(8, level);
                    stm.setDate(9, date);
                    stm.setInt(10, id);
//                stm.setDate(10, Date());

                    int n = stm.executeUpdate();
                    if (n <= 0) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }

        } else {
            return false;
        }
    }

    public boolean remove(int id) {
//        Date date = new Date();
        Connection cnn = DB.connectionCSDL();
        if (cnn != null) {
            String sql = "DELETE FROM users WHERE id =?";
//            https://gpcoder.com/2217-lay-ngay-gio-hien-tai-trong-java/
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
//            System.out.println();  

            SimpleDateFormat formatDate = new SimpleDateFormat("dd-mm-yyyy");
            PreparedStatement stm;
            try {
                stm = cnn.prepareStatement(sql);
                stm.setInt(1, id);

                int n = stm.executeUpdate();
                if (n <= 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        } else {
            return false;
        }
    }


     public Vector<MdNhanVien> detail(String name,String pass) {
        Vector<MdNhanVien> ds = new Vector<MdNhanVien>();
        Connection cnn = DB.connectionCSDL();
        if (cnn != null) {
//            String sql = "SELECT sv.*,lh.Tenlop FROM tbSinhvien as sv "
//                    + "INNER JOIN tbLophoc AS lh ON sv.malop=lh.Malop";
            String sql = "SELECT us.*,lv.name as namelv FROM users As us INNER JOIN levels As lv ON us.level_id = lv.id WHERE us.name = '"+name+"' AND us.password='"+pass+"'";

            Statement stm;
            try {
                stm = cnn.createStatement();

                ResultSet rs = stm.executeQuery(sql);
                while (rs.next())//duyệt từng bản ghi kết quả select
                {

                    MdNhanVien Nv = new MdNhanVien();
                    Nv.id = rs.getInt("id");
                    Nv.email = rs.getString("email");
                    Nv.name = rs.getString("name");
                    Nv.password = rs.getString("password");
                    Nv.sex = rs.getInt("sex") == 1 ? "Nam" : "nữ";
                    Nv.address = rs.getString("address");
                    Nv.birthday = rs.getString("birthday");
                    Nv.level = rs.getString("namelv");
                    Nv.auther = rs.getInt("author") == 1 ? "Nhân viên" : "Admin";
                    Nv.status = rs.getInt("status") == 0 ? "Chưa điểm danh" : "Đã điểm danh";
                    ds.add(Nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return ds;
    }


}
