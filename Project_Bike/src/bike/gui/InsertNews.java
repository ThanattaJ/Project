/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.gui;

/**
 *
 * @author user
 */
import bike.AdminNews;
import bike.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
public class InsertNews extends javax.swing.JFrame {
    private AdminNews admin = new AdminNews();
    
    /**
     * Creates new form adminNews
     */
    public InsertNews() {
        initComponents();
    }
    
    public void insertNews(){
//        String description = txtFieldNewsDescription.getText();
//        String detail = txtAreaNewsDetail.getText();
//        admin.insertNews(description, detail);
//        //Reset Text Fields
//        txtFieldNewsDescription.setText("");
//        txtAreaNewsDetail.setText("");
//        
//        JOptionPane.showMessageDialog(null, "Insert Sucessfully");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtDescription1 = new javax.swing.JLabel();
        txtFieldNewsDescription = new javax.swing.JTextField();
        txtDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNewsDetail = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelAddImage = new javax.swing.JPanel();
        jButtonAddImage = new javax.swing.JButton();

        jPanel9.setBackground(new java.awt.Color(13, 24, 35));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(55, 200, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 10, 60));

        jLabel11.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("1");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 20, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/circle.png"))); // NOI18N
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -6, 70, 60));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/notifications-button.png"))); // NOI18N
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(25, 41, 65));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(55, 200, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/man.png"))); // NOI18N
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(13, 24, 35));
        jLabel4.setText("NAME  SURNAME");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 50));

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 210, -1));

        jPanel10.setBackground(new java.awt.Color(13, 24, 35));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(55, 200, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel10.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 10, 60));

        jLabel12.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("1");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 20, 30));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/circle.png"))); // NOI18N
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -6, 70, 60));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/notifications-button.png"))); // NOI18N
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 730, 60));

        jPanel2.setBackground(new java.awt.Color(55, 200, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(19, 175, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/bike.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/profile-user.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 50, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/menu.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 50, 30));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/bike.png"))); // NOI18N
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 540));

        jPanel8.setBackground(new java.awt.Color(13, 24, 35));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SOCIETY");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 140, 50));

        jTextField1.setBackground(new java.awt.Color(13, 24, 35));
        jTextField1.setFont(new java.awt.Font("Leelawadee UI", 0, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Search");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 70, 30));
        jPanel8.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 120, 40));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("GREEN");
        jLabel27.setToolTipText("");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 130, 50));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/magnifying-glass.png"))); // NOI18N
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, 40));

        jPanel7.setBackground(new java.awt.Color(13, 24, 35));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 255));
        jLabel16.setText("     News");
        jLabel16.setToolTipText("");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 20));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("     Bike Repairing");
        jLabel17.setToolTipText("");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 140, 20));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("     Can Counter");
        jLabel18.setToolTipText("");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, 20));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("     Bike Sharing");
        jLabel19.setToolTipText("");
        jLabel19.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 140, 20));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("     History");
        jLabel20.setToolTipText("");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, 20));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("     PROFILE");
        jLabel21.setToolTipText("");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 140, 30));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("     Timer");
        jLabel22.setToolTipText("");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, 20));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("     Support");
        jLabel23.setToolTipText("");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, 20));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("MENU");
        jLabel24.setToolTipText("");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 30));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/chevron-arrow-down.png"))); // NOI18N
        jLabel25.setToolTipText("");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, 30));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/circle_mini.png"))); // NOI18N
        jLabel26.setToolTipText("");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 40, 40));

        jPanel8.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, -1, -1));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 880, 60));

        jPanel11.setBackground(new java.awt.Color(13, 24, 35));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 255, 255));
        jLabel29.setText("     News");
        jLabel29.setToolTipText("");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 20));

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("     Bike Repairing");
        jLabel30.setToolTipText("");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 140, 20));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("     Can Counter");
        jLabel31.setToolTipText("");
        jLabel31.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, 20));

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("     Bike Sharing");
        jLabel32.setToolTipText("");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 140, 20));

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("     History");
        jLabel33.setToolTipText("");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, 20));

        jLabel34.setBackground(new java.awt.Color(0, 0, 0));
        jLabel34.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("     PROFILE");
        jLabel34.setToolTipText("");
        jPanel11.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 140, 30));

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("     Timer");
        jLabel36.setToolTipText("");
        jLabel36.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, 20));

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("     Support");
        jLabel37.setToolTipText("");
        jLabel37.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, 20));

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("MENU");
        jLabel38.setToolTipText("");
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 30));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/chevron-arrow-down.png"))); // NOI18N
        jLabel39.setToolTipText("");
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, 30));

        jLabel40.setBackground(new java.awt.Color(0, 0, 0));
        jLabel40.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/circle_mini.png"))); // NOI18N
        jLabel40.setToolTipText("");
        jPanel11.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 40, 40));

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 480));

        txtDescription1.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtDescription1.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription1.setText("DESCRIPTION");
        jPanel5.add(txtDescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        txtFieldNewsDescription.setBackground(new java.awt.Color(51, 255, 255));
        txtFieldNewsDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFieldNewsDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNewsDescriptionActionPerformed(evt);
            }
        });
        jPanel5.add(txtFieldNewsDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 420, 40));

        txtDescription.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription.setText("DETAILS");
        jPanel5.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        txtAreaNewsDetail.setBackground(new java.awt.Color(0, 255, 255));
        txtAreaNewsDetail.setColumns(20);
        txtAreaNewsDetail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAreaNewsDetail.setRows(5);
        jScrollPane1.setViewportView(txtAreaNewsDetail);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 420, 170));

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel5.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 80, 30));

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INSERT");
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 40));

        jPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 740, 60));

        jPanelAddImage.setBackground(new java.awt.Color(13, 24, 35));
        jPanelAddImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanelAddImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 130, 120));

        jButtonAddImage.setText("BROWSE");
        jPanel5.add(jButtonAddImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String description = txtFieldNewsDescription.getText();
        String detail = txtAreaNewsDetail.getText();
        admin.insertNews(description, detail);
        //Reset Text Fields
        txtFieldNewsDescription.setText("");
        txtAreaNewsDetail.setText("");

        JOptionPane.showMessageDialog(null, "Insert Sucessfully");
    }//GEN-LAST:event_submitButtonActionPerformed

    private void txtFieldNewsDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNewsDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNewsDescriptionActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(InsertNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertNews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelAddImage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextArea txtAreaNewsDetail;
    private javax.swing.JLabel txtDescription;
    private javax.swing.JLabel txtDescription1;
    private javax.swing.JTextField txtFieldNewsDescription;
    // End of variables declaration//GEN-END:variables
}
