/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerForm;

import Database.dbLevel;
import Database.dbNhanVien;
import Models.MdLevel;
import Models.MdNhanVien;
import java.awt.Label;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



             



/**
 *
 * @author thanh
 */
public class trangChu extends javax.swing.JFrame {
    public static int Id;
    
    /**
     * Creates new form trangChu
     */
    public trangChu(){
        initComponents();
        rmAndAddJpanel(JpDiemDanh);
//        this.MtQuanLyNv.isDisplayable();
        HienthiDSUser();
        addLvCbx();
        addPermission();
        MtQuanLyNv.setEnabled(true);
    }
    public  void addLvCbx(){
        dbLevel dblv = new dbLevel();
        
        Vector<MdLevel> selecLv = dblv.selectLv();
//        cbb.setModel(cbm);
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        cbm.insertElementAt("Chọn level", 0);
        for(MdLevel mdlevel : selecLv){
            cbm.insertElementAt(mdlevel.name, mdlevel.id);
        }
        this.cbxLevels.setModel(cbm);
        
        cbxLevels.setSelectedIndex(0);
        
    }
    public void addPermission(){
        DefaultComboBoxModel cbmp = new DefaultComboBoxModel();
       
        cbmp.insertElementAt("admin", 0);
        cbmp.insertElementAt("NV", 1);
        cbmp.insertElementAt("Chọn Quuyền", 2);
        cbxPremission.setModel(cbmp);
        
        cbxPremission.setSelectedIndex(2);
    }
    public void HienthiDSUser()
    {
        
        
        
        dbNhanVien bangNV = new dbNhanVien();
        Vector<MdNhanVien> dataNV = bangNV.select();
        if(dataNV.size()>0)
        {
            DefaultTableModel dtm = (DefaultTableModel)tblQuanlyNV.getModel();
            dtm.setRowCount(0);
            for (MdNhanVien mdNhanVien : dataNV) {
                dtm.addRow(new Object[]{
                    mdNhanVien.id,
                    mdNhanVien.name,
                    mdNhanVien.email,
                    mdNhanVien.sex,
                    mdNhanVien.birthday,
                    mdNhanVien.address,
                    mdNhanVien.auther,
                    mdNhanVien.level
                });
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sex = new javax.swing.ButtonGroup();
        JpBody = new javax.swing.JPanel();
        JpQuanLyNhanVien = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanlyNV = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cbxPremission = new javax.swing.JComboBox<>();
        cbxLevels = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        rdbNam = new javax.swing.JRadioButton();
        tdbNu = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        JpDiemDanh = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JpThongKe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JpChinhSuaThongTin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JpDoiMatKhau = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JpThongTin = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JpTroGiup = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MtDiemDanh = new javax.swing.JMenuItem();
        MtThongke = new javax.swing.JMenuItem();
        MtThongTin = new javax.swing.JMenuItem();
        MtChinhSuaThongTin = new javax.swing.JMenuItem();
        MtDoiMatKhau = new javax.swing.JMenuItem();
        MtDangXuat = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MtQuanLyNv = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MtTroGiup = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Quản lý nhân viên");

        tblQuanlyNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Email", "Giới tính", "Ngày sinh", "Địa chỉ", "Auth", "Level"
            }
        ));
        jScrollPane1.setViewportView(tblQuanlyNV);

        jLabel8.setText("Tên");

        jLabel9.setText("Email");

        jLabel10.setText("Số ĐT");

        jLabel11.setText("Giới tính");

        jLabel12.setText("Ngày sinh ");

        jLabel13.setText("Quyền");

        jLabel14.setText("Địa chỉ");

        txtAddress.setText(" ");

        jLabel15.setText("Level");

        jLabel16.setText("Password ");

        cbxLevels.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearch.setText("Tìm kiếm");

        Sex.add(rdbNam);
        rdbNam.setText("nam");

        Sex.add(tdbNu);
        tdbNu.setText("Nữ");

        btnAdd.setText("Thêm");

        btnDelete.setText("Xóa");

        btnEdit.setText("Sửa");

        javax.swing.GroupLayout JpQuanLyNhanVienLayout = new javax.swing.GroupLayout(JpQuanLyNhanVien);
        JpQuanLyNhanVien.setLayout(JpQuanLyNhanVienLayout);
        JpQuanLyNhanVienLayout.setHorizontalGroup(
            JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpQuanLyNhanVienLayout.createSequentialGroup()
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rdbNam))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpQuanLyNhanVienLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(169, 169, 169)
                                                .addComponent(jLabel11)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tdbNu))
                                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(179, 179, 179)
                                                .addComponent(jLabel10)))
                                        .addGap(41, 41, 41)
                                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(cbxPremission, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxLevels, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(0, 279, Short.MAX_VALUE))
                            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(40, 40, 40))
                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        JpQuanLyNhanVienLayout.setVerticalGroup(
            JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpQuanLyNhanVienLayout.createSequentialGroup()
                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxPremission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(33, 33, 33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbNam)
                    .addComponent(tdbNu)
                    .addComponent(cbxLevels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16))
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
        );

        JpDiemDanh.setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        JpDiemDanh.add(jTextField1);
        jTextField1.setBounds(130, 50, 220, 30);

        jButton1.setText("Điểm danh");
        JpDiemDanh.add(jButton1);
        jButton1.setBounds(10, 50, 90, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ĐIỂM DANH");
        JpDiemDanh.add(jLabel3);
        jLabel3.setBounds(10, 0, 110, 40);

        jLabel1.setText("Thống kê");

        jLabel5.setText("Chỉnh sửa thông");

        javax.swing.GroupLayout JpChinhSuaThongTinLayout = new javax.swing.GroupLayout(JpChinhSuaThongTin);
        JpChinhSuaThongTin.setLayout(JpChinhSuaThongTinLayout);
        JpChinhSuaThongTinLayout.setHorizontalGroup(
            JpChinhSuaThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpChinhSuaThongTinLayout.createSequentialGroup()
                .addContainerGap(507, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(378, 378, 378))
        );
        JpChinhSuaThongTinLayout.setVerticalGroup(
            JpChinhSuaThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpChinhSuaThongTinLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel5)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpThongKeLayout = new javax.swing.GroupLayout(JpThongKe);
        JpThongKe.setLayout(JpThongKeLayout);
        JpThongKeLayout.setHorizontalGroup(
            JpThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpThongKeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(378, 378, 378))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpThongKeLayout.createSequentialGroup()
                .addComponent(JpChinhSuaThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpThongKeLayout.setVerticalGroup(
            JpThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpThongKeLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpChinhSuaThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Đổi mật khẩu");

        javax.swing.GroupLayout JpDoiMatKhauLayout = new javax.swing.GroupLayout(JpDoiMatKhau);
        JpDoiMatKhau.setLayout(JpDoiMatKhauLayout);
        JpDoiMatKhauLayout.setHorizontalGroup(
            JpDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDoiMatKhauLayout.createSequentialGroup()
                .addContainerGap(540, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(378, 378, 378))
        );
        JpDoiMatKhauLayout.setVerticalGroup(
            JpDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDoiMatKhauLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel2)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        jLabel4.setText("Thông tin");

        javax.swing.GroupLayout JpThongTinLayout = new javax.swing.GroupLayout(JpThongTin);
        JpThongTin.setLayout(JpThongTinLayout);
        JpThongTinLayout.setHorizontalGroup(
            JpThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpThongTinLayout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(378, 378, 378))
        );
        JpThongTinLayout.setVerticalGroup(
            JpThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpThongTinLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel4)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        jLabel7.setText("Trợ giúp");

        javax.swing.GroupLayout JpTroGiupLayout = new javax.swing.GroupLayout(JpTroGiup);
        JpTroGiup.setLayout(JpTroGiupLayout);
        JpTroGiupLayout.setHorizontalGroup(
            JpTroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpTroGiupLayout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(411, 411, 411))
        );
        JpTroGiupLayout.setVerticalGroup(
            JpTroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTroGiupLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel7)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpBodyLayout = new javax.swing.GroupLayout(JpBody);
        JpBody.setLayout(JpBodyLayout);
        JpBodyLayout.setHorizontalGroup(
            JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpDiemDanh, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JpBodyLayout.createSequentialGroup()
                    .addComponent(JpQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpTroGiup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpBodyLayout.setVerticalGroup(
            JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpDiemDanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpThongTin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpTroGiup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu2.setText("Hệ thống");

        MtDiemDanh.setText("Điểm danh");
        MtDiemDanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MtDiemDanhActionPerformed(evt);
            }
        });
        jMenu2.add(MtDiemDanh);

        MtThongke.setText("Thống kê");
        MtThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MtThongkeActionPerformed(evt);
            }
        });
        jMenu2.add(MtThongke);

        MtThongTin.setText("Thông tin cá nhân");
        MtThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MtThongTinActionPerformed(evt);
            }
        });
        jMenu2.add(MtThongTin);

        MtChinhSuaThongTin.setText("Chỉnh sửa thông tin");
        MtChinhSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MtChinhSuaThongTinActionPerformed(evt);
            }
        });
        jMenu2.add(MtChinhSuaThongTin);

        MtDoiMatKhau.setText("Đổi mật khẩu");
        MtDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MtDoiMatKhauActionPerformed(evt);
            }
        });
        jMenu2.add(MtDoiMatKhau);

        MtDangXuat.setText("Đang xuất");
        jMenu2.add(MtDangXuat);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Quản lý");

        MtQuanLyNv.setText("Nhân viên");
        MtQuanLyNv.setEnabled(false);
        MtQuanLyNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MtQuanLyNvActionPerformed(evt);
            }
        });
        jMenu3.add(MtQuanLyNv);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Trợ giúp");

        MtTroGiup.setText("Trợ giúp");
        MtTroGiup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MtTroGiupActionPerformed(evt);
            }
        });
        jMenu1.add(MtTroGiup);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    public void rmAndAddJpanel(JPanel nameJpanel){
        JpBody.removeAll();
        JpBody.repaint();
        JpBody.revalidate();
        
//        add
        JpBody.add(nameJpanel);
        JpBody.repaint();
        JpBody.revalidate();
    }
    
    private void MtThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtThongkeActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpThongKe); 
    }//GEN-LAST:event_MtThongkeActionPerformed

    private void MtThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtThongTinActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpThongTin);
    }//GEN-LAST:event_MtThongTinActionPerformed

    private void MtChinhSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtChinhSuaThongTinActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpChinhSuaThongTin);
    }//GEN-LAST:event_MtChinhSuaThongTinActionPerformed

    private void MtDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtDoiMatKhauActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpDoiMatKhau);
    }//GEN-LAST:event_MtDoiMatKhauActionPerformed

    private void MtDiemDanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtDiemDanhActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpDiemDanh);
    }//GEN-LAST:event_MtDiemDanhActionPerformed

    private void MtQuanLyNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtQuanLyNvActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpQuanLyNhanVien);
    }//GEN-LAST:event_MtQuanLyNvActionPerformed

    private void MtTroGiupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtTroGiupActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpTroGiup);
    }//GEN-LAST:event_MtTroGiupActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(trangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpBody;
    private javax.swing.JPanel JpChinhSuaThongTin;
    private javax.swing.JPanel JpDiemDanh;
    private javax.swing.JPanel JpDoiMatKhau;
    private javax.swing.JPanel JpQuanLyNhanVien;
    private javax.swing.JPanel JpThongKe;
    private javax.swing.JPanel JpThongTin;
    private javax.swing.JPanel JpTroGiup;
    private javax.swing.JMenuItem MtChinhSuaThongTin;
    private javax.swing.JMenuItem MtDangXuat;
    private javax.swing.JMenuItem MtDiemDanh;
    private javax.swing.JMenuItem MtDoiMatKhau;
    private javax.swing.JMenuItem MtQuanLyNv;
    private javax.swing.JMenuItem MtThongTin;
    private javax.swing.JMenuItem MtThongke;
    private javax.swing.JMenuItem MtTroGiup;
    private javax.swing.ButtonGroup Sex;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbxLevels;
    private javax.swing.JComboBox<String> cbxPremission;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JTable tblQuanlyNV;
    private javax.swing.JRadioButton tdbNu;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void foreach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
