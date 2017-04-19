/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news.gui;

import bike.news.Admin;
import bike.*;
import bike.database.Database;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
public class ShowNews extends javax.swing.JFrame {

    private Admin admin = new Admin();

    public ShowNews() {
        initComponents();
        layerUser();
       
    }
    
//    public void connectDB() throws SQLException{
//        try{
//            Database cndb = new Database();
//            Connection connect = Database.connectDb("win", "win016");
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Database connecting");
//        
//            Statement st = connect.createStatement(); 
//            String sql = "SELECT newsDescription,newsDetails MAX(newsID) FROM `News`";
//            ResultSet rs = st.executeQuery(sql);
//    
//            while(rs.next()){
//                this.numOfNews = rs.getInt("newsID");
//            }
//            
//            try {
//		if(connect != null){
//                    connect.close();
//		}
//		}catch (SQLException e){
//                    e.printStackTrace();
//		}
//        }
//        
//        catch(ClassNotFoundException cfe){
//            System.out.println(cfe);
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//    }
    
    public void layerUser(){
        int y = 20;
        String[] news = admin.selectTopicNews();
        JPanel[] jp = new JPanel[news.length];
        JLabel[] description = new JLabel[news.length];
        JLabel[] detail = new JLabel[news.length];
        JLabel[] id = new JLabel[news.length];
//        JButton[] delete = new JButton[numOfNews];
        for (int i = 0; i < news.length; i++) {
            int temp = 1;
            jp[i] = new JPanel();
            jp[i].setBackground(new java.awt.Color(204, 204, 204));
            jp[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            System.out.println(i);
            
            description[i] = new JLabel();
            description[i].setFont(new java.awt.Font("Leelawadee",0,11));
            description[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            description[i].setText("Description : ");
            jp[i].add(description[i],new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));
            
            detail[i] = new JLabel();
            detail[i].setFont(new java.awt.Font("Leelawadee",0,11));
            detail[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            detail[i].setText("Description : ");
            jp[i].add(detail[i],new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));
            
            id[i] = new JLabel();
            id[i].setFont(new java.awt.Font("Leelawadee",0,11));
            id[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            id[i].setText("Description : ");
            jp[i].add(id[i],new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));
            showNews.add(jp[i],new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 690, 100));
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

        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        showNews = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(25, 41, 65));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 730, 60));

        jPanel8.setBackground(new java.awt.Color(13, 24, 35));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SOCIETY");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 140, 50));
        jPanel8.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 120, 40));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("GREEN");
        jLabel12.setToolTipText("");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 130, 50));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/magnifying-glass.png"))); // NOI18N
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, 40));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 860, 60));

        jPanel3.setBackground(new java.awt.Color(19, 175, 248));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(13, 24, 35));
        jLabel4.setText("NAME  SURNAME");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 50));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student");
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, 50));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/man.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 200, 60));

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

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 540));

        jPanel4.setBackground(new java.awt.Color(55, 200, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 210, 60));

        jPanel2.setBackground(new java.awt.Color(55, 200, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 540));

        jPanel6.setBackground(new java.awt.Color(22, 31, 39));

        jPanel7.setBackground(new java.awt.Color(13, 24, 35));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 255));
        jLabel14.setText("     News");
        jLabel14.setToolTipText("");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 20));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("     Bike Repairing");
        jLabel16.setToolTipText("");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 140, 20));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("     Can Counter");
        jLabel17.setToolTipText("");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, 20));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("     Bike Sharing");
        jLabel18.setToolTipText("");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 140, 20));

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

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("MENU");
        jLabel19.setToolTipText("");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 30));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/chevron-arrow-down.png"))); // NOI18N
        jLabel15.setToolTipText("");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, 30));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/circle_mini.png"))); // NOI18N
        jLabel24.setToolTipText("");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 40, 40));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 150, 480));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/menu.png"))); // NOI18N
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 50, 30));

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/bike.png"))); // NOI18N
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        showNews.setBackground(new java.awt.Color(25, 41, 65));
        showNews.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(showNews, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 730, 420));

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
            java.util.logging.Logger.getLogger(ShowNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowNews().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel showNews;
    // End of variables declaration//GEN-END:variables

}

