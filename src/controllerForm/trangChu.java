/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerForm;

import Database.dbLevel;
import Database.dbNhanVien;
import Database.dbWorkday;
import Models.MdLevel;
import Models.MdNhanVien;
import Models.MdWorkday;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Label;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author thanh
 */
public class trangChu extends javax.swing.JFrame {

    public String user ;
    public String pass;
    private int ID;
    
    /**
     * Creates new form trangChu
     */
    public trangChu(String name,String pass){
        
        this.user = name;
        this.pass = pass;
    }  
    public trangChu() {
        initComponents();
        rmAndAddJpanel(JpDiemDanh);
        HienthiDSUser();
        addLvCbx();
        addPermission();
        HienthiDSUWorkday(ID);
//      sLbDDId.setText(this.user);
        
        
        MtQuanLyNv.setEnabled(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);

    }
    
    public void detailUser(String user,String pass){
        login Login = new login();
        dbNhanVien bangNV   = new dbNhanVien();
//      System.out.println(Login.userName);
        Vector<MdNhanVien> dataNV = bangNV.detail( user,pass);
//        boolean result      = bangNV.detail(Id);
//        MdNhanVien NV       = new MdNhanVien();
//       LbDDName.setText("dsf");

        System.out.println(dataNV);
        for (MdNhanVien mdNhanVien : dataNV) {
            LbDDId.setText(Integer.toString(mdNhanVien.id));
            LbDDName.setText(mdNhanVien.name);
            LbDDEmail.setText(mdNhanVien.email);
            LbDDIdAdd.setText(mdNhanVien.address);
            LbDDSex.setText(mdNhanVien.sex);
            LbDDbirthday.setText(mdNhanVien.birthday);
            LbDDIdLv.setText(mdNhanVien.level);
        }
        
    }
     public void editlUser(String user,String pass){
        login Login = new login();
        dbNhanVien bangNV   = new dbNhanVien();
//        System.out.println(Login.userName);
        Vector<MdNhanVien> dataNV = bangNV.detail( user,pass);


        System.out.println(dataNV);
        for (MdNhanVien mdNhanVien : dataNV) {
            
            this.ID = mdNhanVien.id;
            txtEName1.setText(mdNhanVien.name);
            txtEEmail1.setText(mdNhanVien.email);
            txtEAddress1.setText(mdNhanVien.address);
            LbDDSex.setText(mdNhanVien.sex);
            
            if(mdNhanVien.sex=="Nam"){
                rdbENam1.setSelected(true);
            }else{
                rdbENu1.setSelected(true);
            }
            
            txtEBirthday1.setText(mdNhanVien.birthday);
            cbxEPremission1.setSelectedItem(mdNhanVien.auther);
            cbxELevels1.setSelectedItem(mdNhanVien.level);
        }
        System.out.println(this.ID);
        
    }
    
    public void detail(String user,String pass){
        login Login = new login();
        dbNhanVien bangNV   = new dbNhanVien();
//        this.ID
//        System.out.println(Login.userName);
        Vector<MdNhanVien> dataNV = bangNV.detail( user,pass);
//        boolean result      = bangNV.detail(Id);
//        MdNhanVien NV       = new MdNhanVien();
//       LbDDName.setText("dsf");

        System.out.println(dataNV);
        for (MdNhanVien mdNhanVien : dataNV) {
            LbDDId.setText(Integer.toString(mdNhanVien.id));
            LbDDName.setText(mdNhanVien.name);
            LbDDEmail.setText(mdNhanVien.email);
            LbDDIdAdd.setText(mdNhanVien.address);
            LbDDSex.setText(mdNhanVien.sex);
            LbDDbirthday.setText(mdNhanVien.birthday);
            LbDDIdLv.setText(mdNhanVien.level);
        }
        
    }
    public void addLvCbx() {
        dbLevel dblv = new dbLevel();

        Vector<MdLevel> selecLv = dblv.selectLv();
//        cbb.setModel(cbm);
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        cbm.addElement("Chọn level");
        for (MdLevel mdlevel : selecLv) {

            cbm.addElement(mdlevel.name);
        }
        cbxLevels.setModel(cbm);
        cbxLevels.setSelectedIndex(0);
        
        cbxELevels1.setModel(cbm);
        cbxELevels1.setSelectedIndex(0);

    }

    public void addPermission() {
        DefaultComboBoxModel cbmp = new DefaultComboBoxModel();

        cbmp.addElement("Chọn Quuyền");
        cbmp.addElement("Nhân viên");
        cbmp.addElement("Admin");
        
        cbxEPremission1.setModel(cbmp);
        cbxEPremission1.setSelectedIndex(0);
        
        cbxPremission.setModel(cbmp);
        cbxPremission.setSelectedIndex(0);
        
        
    }

    public void HienthiDSUser() {

        dbNhanVien bangNV = new dbNhanVien();
        Vector<MdNhanVien> dataNV = bangNV.select();
        if (dataNV.size() > 0) {
            DefaultTableModel dtm = (DefaultTableModel) tblQuanlyNV.getModel();
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
    public void HienthiDSUWorkday(int idUser) {

        dbWorkday bangW = new dbWorkday();
//      int idUser = (int) this.ID;
//        System.out.println(idUser+"us");
        Vector<MdWorkday> dataW = bangW.select(idUser);
        if (dataW.size() > 0) {
            DefaultTableModel dtm = (DefaultTableModel) tbUWorkday.getModel();
            dtm.setRowCount(0);

            for (MdWorkday mdw : dataW) {
                dtm.addRow(new Object[]{
                    mdw.id,
                    mdw.workday,
                    mdw.monthday,
                    mdw.hours,
                   
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
        ESex = new javax.swing.ButtonGroup();
        JpBody = new javax.swing.JPanel();
        JpQuanLyNhanVien = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanlyNV = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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
        rdbNu = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnSave = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        JpDiemDanh = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        LbDDId = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        LbDDSex = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        LbDDbirthday = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        LbDDIdAdd = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        LbDDIdLv = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        LbDDName = new javax.swing.JLabel();
        LbDDEmail = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        JpThongKe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUWorkday = new javax.swing.JTable();
        JpDoiMatKhau = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JpThongTin = new javax.swing.JPanel();
        JpTroGiup = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JpEditInfo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtEPassword1 = new javax.swing.JPasswordField();
        txtEAddress1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEEmail1 = new javax.swing.JTextField();
        rdbENam1 = new javax.swing.JRadioButton();
        rdbENu1 = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        txtEBirthday1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEName1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbxEPremission1 = new javax.swing.JComboBox<>();
        cbxELevels1 = new javax.swing.JComboBox<>();
        btnEUpdate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MtDiemDanh = new javax.swing.JMenuItem();
        MtThongke = new javax.swing.JMenuItem();
        MtChinhSuaThongTin = new javax.swing.JMenuItem();
        MtDoiMatKhau = new javax.swing.JMenuItem();
        MtDangXuat = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MtQuanLyNv = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MtTroGiup = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1060, 700));
        setMinimumSize(new java.awt.Dimension(1050, 690));
        setPreferredSize(new java.awt.Dimension(1010, 600));
        setSize(new java.awt.Dimension(1060, 700));

        JpQuanLyNhanVien.setPreferredSize(new java.awt.Dimension(1060, 700));

        jLabel6.setText("Quản lý nhân viên");

        tblQuanlyNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Email", "Giới tính", "Ngày sinh", "Địa chỉ", "Auth", "Level"
            }
        ));
        tblQuanlyNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanlyNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuanlyNV);

        jLabel8.setText("Tên");

        jLabel9.setText("Email");

        jLabel11.setText("Giới tính");

        jLabel12.setText("Ngày sinh ");

        jLabel13.setText("Quyền");

        jLabel14.setText("Địa chỉ");

        txtAddress.setText(" ");

        jLabel15.setText("Level");

        jLabel16.setText("Password ");

        cbxLevels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLevelsActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        Sex.add(rdbNam);
        rdbNam.setText("nam");

        Sex.add(rdbNu);
        rdbNu.setText("Nữ");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRefresh.setText("khôi phục");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

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
                                        .addComponent(rdbNu))
                                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(72, 72, 72)
                                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(78, 78, 78)
                                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(cbxPremission, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxLevels, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(0, 329, Short.MAX_VALUE))
                            .addGroup(JpQuanLyNhanVienLayout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRefresh)
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
                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    .addComponent(rdbNu)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch))
                    .addGroup(JpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        JpDiemDanh.setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        JpDiemDanh.add(jTextField1);
        jTextField1.setBounds(170, 50, 220, 30);

        jButton1.setText("Điểm danh");
        JpDiemDanh.add(jButton1);
        jButton1.setBounds(10, 50, 120, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ĐIỂM DANH");
        JpDiemDanh.add(jLabel3);
        jLabel3.setBounds(0, 0, 950, 40);

        jLabel18.setText("ID");
        JpDiemDanh.add(jLabel18);
        jLabel18.setBounds(20, 120, 14, 17);

        LbDDId.setText("jLabel18");
        JpDiemDanh.add(LbDDId);
        LbDDId.setBounds(170, 120, 300, 17);
        JpDiemDanh.add(jLabel23);
        jLabel23.setBounds(20, 180, 0, 0);

        jLabel25.setText("Giới tính");
        JpDiemDanh.add(jLabel25);
        jLabel25.setBounds(20, 210, 55, 17);

        LbDDSex.setText("jLabel18");
        JpDiemDanh.add(LbDDSex);
        LbDDSex.setBounds(170, 210, 430, 17);

        jLabel27.setText("Ngày Sinh");
        JpDiemDanh.add(jLabel27);
        jLabel27.setBounds(20, 240, 70, 17);

        LbDDbirthday.setText("jLabel18");
        JpDiemDanh.add(LbDDbirthday);
        LbDDbirthday.setBounds(170, 240, 520, 17);

        jLabel29.setText("Địa chỉ");
        JpDiemDanh.add(jLabel29);
        jLabel29.setBounds(20, 270, 46, 17);

        LbDDIdAdd.setText("jLabel18");
        JpDiemDanh.add(LbDDIdAdd);
        LbDDIdAdd.setBounds(170, 270, 540, 17);

        jLabel31.setText("Level");
        JpDiemDanh.add(jLabel31);
        jLabel31.setBounds(20, 300, 37, 17);

        LbDDIdLv.setText("jLabel18");
        JpDiemDanh.add(LbDDIdLv);
        LbDDIdLv.setBounds(170, 300, 410, 17);

        jLabel22.setText("Name");
        JpDiemDanh.add(jLabel22);
        jLabel22.setBounds(20, 150, 41, 17);

        LbDDName.setText("jLabel18");
        JpDiemDanh.add(LbDDName);
        LbDDName.setBounds(170, 150, 310, 17);

        LbDDEmail.setText("jLabel18");
        JpDiemDanh.add(LbDDEmail);
        LbDDEmail.setBounds(170, 180, 390, 17);

        jLabel24.setText("Emai");
        JpDiemDanh.add(jLabel24);
        jLabel24.setBounds(20, 180, 33, 17);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống kê");

        tbUWorkday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "số ngày làm / tháng", "Tháng", "Tổng thời gian "
            }
        ));
        jScrollPane2.setViewportView(tbUWorkday);

        javax.swing.GroupLayout JpThongKeLayout = new javax.swing.GroupLayout(JpThongKe);
        JpThongKe.setLayout(JpThongKeLayout);
        JpThongKeLayout.setHorizontalGroup(
            JpThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
        );
        JpThongKeLayout.setVerticalGroup(
            JpThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpThongKeLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1790, Short.MAX_VALUE))
        );

        jLabel2.setText("Đổi mật khẩu");

        javax.swing.GroupLayout JpDoiMatKhauLayout = new javax.swing.GroupLayout(JpDoiMatKhau);
        JpDoiMatKhau.setLayout(JpDoiMatKhauLayout);
        JpDoiMatKhauLayout.setHorizontalGroup(
            JpDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDoiMatKhauLayout.createSequentialGroup()
                .addContainerGap(592, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(378, 378, 378))
        );
        JpDoiMatKhauLayout.setVerticalGroup(
            JpDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDoiMatKhauLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel2)
                .addContainerGap(1034, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpThongTinLayout = new javax.swing.GroupLayout(JpThongTin);
        JpThongTin.setLayout(JpThongTinLayout);
        JpThongTinLayout.setHorizontalGroup(
            JpThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1106, Short.MAX_VALUE)
        );
        JpThongTinLayout.setVerticalGroup(
            JpThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2118, Short.MAX_VALUE)
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
                .addContainerGap(983, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CHỈNH SƯA THÔNG TIN");

        txtEAddress1.setText(" ");

        jLabel17.setText("Địa chỉ");

        jLabel19.setText("Password ");

        ESex.add(rdbENam1);
        rdbENam1.setText("nam");

        ESex.add(rdbENu1);
        rdbENu1.setText("Nữ");

        jLabel20.setText("Giới tính");

        jLabel21.setText("Ngày sinh ");

        jLabel10.setText("Email");

        jLabel26.setText("Tên");

        jLabel28.setText("Quyền");

        cbxELevels1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxELevels1ActionPerformed(evt);
            }
        });

        btnEUpdate.setText("Cập nhập ");
        btnEUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpEditInfoLayout = new javax.swing.GroupLayout(JpEditInfo);
        JpEditInfo.setLayout(JpEditInfoLayout);
        JpEditInfoLayout.setHorizontalGroup(
            JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpEditInfoLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JpEditInfoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpEditInfoLayout.createSequentialGroup()
                        .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpEditInfoLayout.createSequentialGroup()
                                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(JpEditInfoLayout.createSequentialGroup()
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel17))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpEditInfoLayout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(169, 169, 169)
                                            .addComponent(jLabel20)))
                                    .addGroup(JpEditInfoLayout.createSequentialGroup()
                                        .addComponent(txtEEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdbENam1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbENu1))
                            .addGroup(JpEditInfoLayout.createSequentialGroup()
                                .addComponent(txtEPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(txtEAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpEditInfoLayout.createSequentialGroup()
                                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEName1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(72, 72, 72)
                                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(txtEBirthday1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(78, 78, 78)
                        .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(cbxEPremission1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxELevels1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpEditInfoLayout.setVerticalGroup(
            JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpEditInfoLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpEditInfoLayout.createSequentialGroup()
                        .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEBirthday1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEPremission1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpEditInfoLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(33, 33, 33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbENam1)
                    .addComponent(rdbENu1)
                    .addComponent(cbxELevels1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEUpdate)
                .addGap(0, 2532, Short.MAX_VALUE))
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
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpEditInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpBodyLayout.setVerticalGroup(
            JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpDiemDanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpThongTin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JpBodyLayout.createSequentialGroup()
                    .addComponent(JpQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(504, Short.MAX_VALUE)))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpTroGiup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JpEditInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    public void rmAndAddJpanel(JPanel nameJpanel) {
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

    private void MtChinhSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MtChinhSuaThongTinActionPerformed
        // TODO add your handling code here:
        rmAndAddJpanel(JpEditInfo);
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtAddress.setText("");
        txtBirthday.setText("");
        cbxPremission.setSelectedIndex(0);
        cbxLevels.setSelectedIndex(0);

        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnAdd.setEnabled(false);


    }//GEN-LAST:event_btnAddActionPerformed

    private void cbxLevelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLevelsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLevelsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        dbNhanVien AddNV = new dbNhanVien();

        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String sex = rdbNam.isSelected() ? "1" : "0";
        String address = txtAddress.getText();
        String birthday = txtBirthday.getText();
        String auther = cbxPremission.getSelectedItem() == "admin" ? "0" : "1";
        int level = cbxLevels.getSelectedIndex();

        if ("".equals(name) || "".equals(email) || "".equals(password) || "".equals(sex) || "".equals(address) || "".equals(birthday) || "Chọn Quuyền".equals(auther) || level == 0) {

            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ .", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            boolean result = AddNV.addNV(email, name, password, sex, address, birthday, auther, level);

            if (result) {
                JOptionPane.showMessageDialog(null, "Tạo thành công .", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                HienthiDSUser();

                txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtAddress.setText("");
                txtBirthday.setText("");

                rdbNam.setSelected(false);
                rdbNu.setSelected(false);

                cbxPremission.setSelectedIndex(0);
                cbxLevels.setSelectedIndex(0);

                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Không tạo được nhân viên .", "Thông báo", JOptionPane.WARNING_MESSAGE);

            }
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtAddress.setText("");
        txtBirthday.setText("");
        txtSearch.setText("");

        rdbNam.setSelected(false);
        rdbNu.setSelected(false);

        cbxPremission.setSelectedIndex(0);
        cbxLevels.setSelectedIndex(0);

        btnAdd.setEnabled(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        

        HienthiDSUser();


    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblQuanlyNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanlyNVMouseClicked
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) tblQuanlyNV.getModel();

        txtName.setText((String) model.getValueAt(tblQuanlyNV.getSelectedRow(), 1));
        txtEmail.setText((String) model.getValueAt(tblQuanlyNV.getSelectedRow(), 2));

        if ((String) model.getValueAt(tblQuanlyNV.getSelectedRow(), 3) == "Nam") {
            rdbNam.setSelected(true);
        } else {
            rdbNu.setSelected(true);
        }

        txtBirthday.setText((String) model.getValueAt(tblQuanlyNV.getSelectedRow(), 4));
        txtAddress.setText((String) model.getValueAt(tblQuanlyNV.getSelectedRow(), 5));

        cbxPremission.setSelectedItem((String) model.getValueAt(tblQuanlyNV.getSelectedRow(), 6));
        cbxLevels.setSelectedItem((String) model.getValueAt(tblQuanlyNV.getSelectedRow(), 7));

        btnDelete.setEnabled(true);
        btnEdit.setEnabled(true);
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);


    }//GEN-LAST:event_tblQuanlyNVMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:

        dbNhanVien tbNhanvien = new dbNhanVien();
        DefaultTableModel model = (DefaultTableModel) tblQuanlyNV.getModel();

        int idUser = (int) model.getValueAt(tblQuanlyNV.getSelectedRow(), 0);
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String sex = rdbNam.isSelected() ? "1" : "0";
        String address = txtAddress.getText();
        String birthday = txtBirthday.getText();
        String auther = cbxPremission.getSelectedItem() == "admin" ? "0" : "1";
        int level = cbxLevels.getSelectedIndex();

        if (name == "" || email == "" || password == "" || sex == "" || address == "" || birthday == "" || auther == "Chọn Quuyền" || level == 0) {

            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ .", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            boolean result = tbNhanvien.UpdateNV(idUser, email, name, password, sex, address, birthday, auther, level);

            if (result) {
                JOptionPane.showMessageDialog(null, "Cập nhập thành công .", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                HienthiDSUser();

                txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtAddress.setText("");
                txtBirthday.setText("");

                rdbNam.setSelected(false);
                rdbNu.setSelected(false);

                cbxPremission.setSelectedIndex(0);
                cbxLevels.setSelectedIndex(0);

                btnAdd.setEnabled(true);
                btnDelete.setEnabled(true);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Cập nhập thất bại .", "Thông báo", JOptionPane.WARNING_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) tblQuanlyNV.getModel();
        int idUser = (int) model.getValueAt(tblQuanlyNV.getSelectedRow(), 0);
        dbNhanVien tbNhanvien = new dbNhanVien();

        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {

            boolean result = tbNhanvien.remove(idUser);

            if (result) {
                JOptionPane.showMessageDialog(null, "Xóa thành công .", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                HienthiDSUser();

                txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtAddress.setText("");
                txtBirthday.setText("");

                rdbNam.setSelected(false);
                rdbNu.setSelected(false);

                cbxPremission.setSelectedIndex(0);
                cbxLevels.setSelectedIndex(0);

                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại .", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText();
        dbNhanVien bangNV = new dbNhanVien();

        Vector<MdNhanVien> dataNV = bangNV.search(search);
        if (dataNV.size() > 0) {
            DefaultTableModel dtm = (DefaultTableModel) tblQuanlyNV.getModel();
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
            txtName.setText("");
            txtEmail.setText("");
            txtPassword.setText("");
            txtAddress.setText("");
            txtBirthday.setText("");

            rdbNam.setSelected(false);
            rdbNu.setSelected(false);

            cbxPremission.setSelectedIndex(0);
            cbxLevels.setSelectedIndex(0);
        } else {

            JOptionPane.showMessageDialog(null, "Không tìm thấy .", "Thông báo", JOptionPane.WARNING_MESSAGE);

            txtName.setText("");
            txtEmail.setText("");
            txtPassword.setText("");
            txtAddress.setText("");
            txtBirthday.setText("");

            rdbNam.setSelected(false);
            rdbNu.setSelected(false);

            cbxPremission.setSelectedIndex(0);
            cbxLevels.setSelectedIndex(0);
            
            HienthiDSUser();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbxELevels1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxELevels1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxELevels1ActionPerformed

    private void btnEUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUpdateActionPerformed
        // TODO add your handling code here:
        dbNhanVien tbNhanvien = new dbNhanVien();
        DefaultTableModel model = (DefaultTableModel) tblQuanlyNV.getModel();

        int idUser = (int) this.ID;
        String name = txtEName1.getText();
        String email = txtEEmail1.getText();
        String password = txtEPassword1.getText();
        String sex = rdbENam1.isSelected() ? "1" : "0";
        String address = txtEAddress1.getText();
        String birthday = txtEBirthday1.getText();
        String auther = cbxEPremission1.getSelectedItem() == "admin" ? "0" : "1";
        int level = cbxELevels1.getSelectedIndex();

        if (name == "" || email == "" || sex == "" || address == "" || birthday == "" || auther == "Chọn Quuyền" || level == 0) {

            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ .", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            boolean result = tbNhanvien.UpdateNV(idUser, email, name, password, sex, address, birthday, auther, level);

            if (result) {
                JOptionPane.showMessageDialog(null, "Cập nhập thành công .", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
              


            } else {
                JOptionPane.showMessageDialog(null, "Cập nhập thất bại .", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEUpdateActionPerformed

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
    private javax.swing.ButtonGroup ESex;
    private javax.swing.JPanel JpBody;
    private javax.swing.JPanel JpDiemDanh;
    private javax.swing.JPanel JpDoiMatKhau;
    private javax.swing.JPanel JpEditInfo;
    private javax.swing.JPanel JpQuanLyNhanVien;
    private javax.swing.JPanel JpThongKe;
    private javax.swing.JPanel JpThongTin;
    private javax.swing.JPanel JpTroGiup;
    private javax.swing.JLabel LbDDEmail;
    private javax.swing.JLabel LbDDId;
    private javax.swing.JLabel LbDDIdAdd;
    private javax.swing.JLabel LbDDIdLv;
    private javax.swing.JLabel LbDDName;
    private javax.swing.JLabel LbDDSex;
    private javax.swing.JLabel LbDDbirthday;
    private javax.swing.JMenuItem MtChinhSuaThongTin;
    private javax.swing.JMenuItem MtDangXuat;
    private javax.swing.JMenuItem MtDiemDanh;
    private javax.swing.JMenuItem MtDoiMatKhau;
    private javax.swing.JMenuItem MtQuanLyNv;
    private javax.swing.JMenuItem MtThongke;
    private javax.swing.JMenuItem MtTroGiup;
    private javax.swing.ButtonGroup Sex;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEUpdate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbxELevels1;
    private javax.swing.JComboBox<String> cbxEPremission1;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdbENam1;
    private javax.swing.JRadioButton rdbENu1;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tbUWorkday;
    private javax.swing.JTable tblQuanlyNV;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtEAddress1;
    private javax.swing.JTextField txtEBirthday1;
    private javax.swing.JTextField txtEEmail1;
    private javax.swing.JTextField txtEName1;
    private javax.swing.JPasswordField txtEPassword1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void foreach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
