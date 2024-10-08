/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tourify.View;
import java.util.logging.*;

/**
 *
 * @author lenevo
 */
public class MainApp extends javax.swing.JFrame {

    /**
     * Creates new form java
     */
    public MainApp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationBar = new javax.swing.JPanel();
        bookingsButton = new javax.swing.JButton();
        tpButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tabPanel = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1440, 1024));

        navigationBar.setBackground(new java.awt.Color(0, 153, 102));

        bookingsButton.setBackground(new java.awt.Color(0, 153, 102));
        bookingsButton.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        bookingsButton.setForeground(new java.awt.Color(255, 255, 255));
        bookingsButton.setText("Bookings");
        bookingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingsButtonMouseClicked(evt);
            }
        });

        tpButton.setBackground(new java.awt.Color(0, 153, 102));
        tpButton.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        tpButton.setForeground(new java.awt.Color(255, 255, 255));
        tpButton.setText("Tour Packages");
        tpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpButtonMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Users");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 102));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tourify");

        javax.swing.GroupLayout navigationBarLayout = new javax.swing.GroupLayout(navigationBar);
        navigationBar.setLayout(navigationBarLayout);
        navigationBarLayout.setHorizontalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBarLayout.createSequentialGroup()
                .addGroup(navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navigationBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(navigationBarLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        navigationBarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bookingsButton, jButton1, tpButton});

        navigationBarLayout.setVerticalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBarLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(175, 175, 175)
                .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPanel.setPreferredSize(new java.awt.Dimension(100, 1024));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navigationBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        BookingsDashboard1 bDashboard = new BookingsDashboard1();
        tabPanel.add(bDashboard);
        TourPackageDashboard tpDashboard = new TourPackageDashboard();
        tabPanel.add(tpDashboard);
        users uDashboard = new users();
        tabPanel.add(uDashboard);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookingsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingsButtonMouseClicked
        // TODO add your handling code here:
        tabPanel.setSelectedIndex(0);
    }//GEN-LAST:event_bookingsButtonMouseClicked

    private void tpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpButtonMouseClicked
        // TODO add your handling code here:
        tabPanel.setSelectedIndex(1);
    }//GEN-LAST:event_tpButtonMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        tabPanel.setSelectedIndex(2);
    }//GEN-LAST:event_jButton1MouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
//            MainApp.util.logging.Logger.getLogger(MainApp.class.getName()).log(MainApp.util.logging.Level.SEVERE, null, ex);
        }
//            MainApp.util.logging.Logger.getLogger(MainApp.class.getName()).log(MainApp.util.logging.Level.SEVERE, null, ex);
//            MainApp.util.logging.Logger.getLogger(MainApp.class.getName()).log(MainApp.util.logging.Level.SEVERE, null, ex);
//            MainApp.util.logging.Logger.getLogger(MainApp.class.getName()).log(MainApp.util.logging.Level.SEVERE, null, ex);
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookingsButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel navigationBar;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JButton tpButton;
    // End of variables declaration//GEN-END:variables
}
