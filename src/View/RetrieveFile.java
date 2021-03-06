/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Alogorithm.SteganoInformation;
import Alogorithm.Steganograph;
import General.Configuration;
import General.Nimbus;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jithinpv
 */
public class RetrieveFile extends javax.swing.JFrame {

    /**
     * Creates new form RetrieveFile
     */
    File cipherFile;
    File retreivedFile;

    public RetrieveFile() {
        Nimbus.loadLoogAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        loadIcons();
    }

    private void loadIcons() {
        Configuration.setIconOnLabel("file.png", retreived_file_icon);
        retreived_file_icon.setVisible(false);
        sucess_label.setVisible(false);
        Configuration.setIconOnLabel("blue_back_ground.jpg", main_label);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        password_feild = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        retreived_file_icon = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sucess_label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        main_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose File");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 37, -1, -1));

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 33, 150, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 96, 99, -1));
        getContentPane().add(password_feild, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 93, 150, -1));

        jButton2.setText("RETRIEVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 154, 182, -1));

        retreived_file_icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        retreived_file_icon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retreived_file_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retreived_file_iconMouseClicked(evt);
            }
        });
        getContentPane().add(retreived_file_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 220, 183, 113));

        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 339, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 67, 297, 20));

        sucess_label.setForeground(new java.awt.Color(255, 255, 255));
        sucess_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sucess_label.setText("Sucessfully retreived. Click to open");
        getContentPane().add(sucess_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 188, 371, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 135, 371, 13));
        getContentPane().add(main_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 400, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog((Component) evt.getSource());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            cipherFile = file;
            try {
                String fileName = file.toString();
                String name = chooser.getSelectedFile().getName();
                jLabel4.setText(name);
            } catch (Exception ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String password = new String(password_feild.getPassword());
        String fileName = jLabel4.getText();
        if (fileName.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "choose file");
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Enter password");
        } else {
            SteganoInformation steganoInformation = new SteganoInformation(cipherFile);
            if (steganoInformation.isEster()) {
                //showEster(steganoInformation);
            } else if (!steganoInformation.isValid()) {
                JOptionPane.showMessageDialog(null, "File '" + cipherFile.getName()
                        + "' does not contain any message or file\nembedded using Seganograph 2.0.0 or later!", "Invalid Steganograph file!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    retreivedFile = Steganograph.retrieveFile(steganoInformation, password, true);
                    if (retreivedFile != null) {
                        JOptionPane.showMessageDialog(rootPane, "Sucessfully retreived");
                        retreived_file_icon.setVisible(true);
                        sucess_label.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Incorrect password");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect password");
                }
            }
            sucess_label.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

private void retreived_file_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retreived_file_iconMouseClicked
    try {
        if(retreivedFile!=null) {
            Desktop.getDesktop().open(retreivedFile);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(rootPane, "Could not open the file");
    }
}//GEN-LAST:event_retreived_file_iconMouseClicked

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
            java.util.logging.Logger.getLogger(RetrieveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetrieveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetrieveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetrieveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RetrieveFile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel main_label;
    private javax.swing.JPasswordField password_feild;
    private javax.swing.JLabel retreived_file_icon;
    private javax.swing.JLabel sucess_label;
    // End of variables declaration//GEN-END:variables
}
