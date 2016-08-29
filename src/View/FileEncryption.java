/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Alogorithm.Steganograph;
import General.Configuration;
import General.Nimbus;
import WaterMark.AddWaterMark;
import db.Dbcon;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Jithinpv
 */
public class FileEncryption extends javax.swing.JFrame {

    public static String encryption_password;
    File masterFile = null;
    File embedding_file = null;
    long max_allowed_file_size = 0;

    /**
     * Creates new form FileEncryption
     */
    public FileEncryption() {
        Nimbus.loadLoogAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        encrypt_button.setEnabled(true);
        loadWatermarkTemplates();
        Configuration.setIconOnLabel("blue_back_ground.jpg", main_label);
    }

    public FileEncryption(String masterFileName) {
        Nimbus.loadLoogAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        loadWatermarkTemplates();
        masterFile = new File(Configuration.masterPoolLocation + masterFileName);
        add_watermark_button.setEnabled(false);
        encrypt_button.setEnabled(false);
        max_allowed_file_size = Steganograph.getMaxAllowedFileSize(masterFile);
        max_file_size_label.setText((max_allowed_file_size / 1024) + " kb");
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
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        add_watermark_button = new javax.swing.JButton();
        encrypt_button = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        progress_bar = new javax.swing.JProgressBar();
        watermark_templates = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        max_file_size_label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selected_file_size_label = new javax.swing.JLabel();
        main_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 33, 121, -1));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 30, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose File");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 82, 121, -1));

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 78, 150, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Maximum file size");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 166, 164, -1));

        add_watermark_button.setText("Add Watermark");
        add_watermark_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_watermark_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(add_watermark_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 229, -1, -1));

        encrypt_button.setText("Embed");
        encrypt_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encrypt_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(encrypt_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 229, 81, -1));

        jButton4.setText("BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 229, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 111, 317, 20));
        getContentPane().add(progress_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 343, 25));

        getContentPane().add(watermark_templates, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 198, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Select water mark");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 201, -1, -1));

        max_file_size_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        max_file_size_label.setForeground(new java.awt.Color(255, 255, 255));
        max_file_size_label.setText("100 kb");
        getContentPane().add(max_file_size_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 166, 131, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Selected file size");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 146, 164, -1));

        selected_file_size_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selected_file_size_label.setForeground(new java.awt.Color(255, 255, 255));
        selected_file_size_label.setText("0 kb");
        getContentPane().add(selected_file_size_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 146, 131, -1));
        getContentPane().add(main_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 380, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkSizeLimit() {
        boolean distortion = false;
        long char_left = max_allowed_file_size - embedding_file.length();
        if (char_left < 0) {
            distortion = true;
        }

        return distortion;
    }

    private void loadWatermarkTemplates() {
        try {
            ResultSet rs = new Dbcon().select("select * from tbl_water_mark_config");
            while (rs.next()) {
                watermark_templates.addItem(rs.getString("template_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void encrypt_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encrypt_buttonActionPerformed
        // TODO add your handling code here:
        String password = new String(jPasswordField1.getPassword());
        String fileName = jLabel4.getText();
        if (password.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Enter password");
        } else if (password.trim().length() < 8) {
            JOptionPane.showMessageDialog(rootPane, "Password must be greater than or equal to 8");
        } else if (fileName.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Choose file to be encrypted");
        } else if (checkSizeLimit()) {
            JOptionPane.showMessageDialog(rootPane, "Please select file lesser than allowed size to avoid distortion");
            selected_file_size_label.setForeground(Color.red);
        } else {
            Dbcon dbcon = new Dbcon();
            dbcon.update("update tbl_encryption_log set encryption_start_time='" + System.currentTimeMillis() + "'where process_id='" + EmbedFile.process_id + "'");
            encryption_password = password;

            File outPutCipherFile = new File(Configuration.masterPoolLocation + FilenameUtils.getBaseName(masterFile.getName()) + "_cipher." + FilenameUtils.getExtension(masterFile.getName()));
            if (Steganograph.embedFile(masterFile, outPutCipherFile, embedding_file, 50, password)) {
                String sql = "update tbl_encryption_log set encryption_end_time='" + System.currentTimeMillis() + "' , cipher_file='"+outPutCipherFile.getName()+"' , cipher_file_size = '"+(outPutCipherFile.length()/1024)+"' where process_id='" + EmbedFile.process_id + "'";
                System.out.println(sql);
                dbcon.update(sql);
                JOptionPane.showMessageDialog(rootPane, "Successfully embeded data");
                this.dispose();
                SendFile send = new SendFile(outPutCipherFile);
                send.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Could not embed, please try again after some time");
            }
        }

    }//GEN-LAST:event_encrypt_buttonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        EmbedFile embedFile = new EmbedFile();
        embedFile.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog((Component) evt.getSource());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                String fileName = file.toString();
                String name = chooser.getSelectedFile().getName();
                jLabel4.setText(name);
                embedding_file = file;
                selected_file_size_label.setText((embedding_file.length() / 1024) + " kb");
                add_watermark_button.setEnabled(true);
            } catch (Exception ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean addWaterMark() {
        boolean success = false;
        String waterMarkName = watermark_templates.getSelectedItem().toString();
        ResultSet rs = new Dbcon().select("select * from tbl_water_mark_config where template_name = '" + waterMarkName + "'");
        try {
            if (rs.next()) {
                String title = rs.getString("title");
                String font_family = rs.getString("font_family");
                String font_size = rs.getString("font_size");
                String font_color = rs.getString("font_color");
                String opacityString = rs.getString("opacity");
                float opacity = Float.parseFloat(opacityString);
                opacity = opacity / 100;
                AddWaterMark.addNow(masterFile, font_family, Integer.parseInt(font_size), waterMarkName, opacity, font_color);
                success = true;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Watermark tempalte is corrupted!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    private void add_watermark_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_watermark_buttonActionPerformed
        // TODO add your handling code here:
        Dbcon dbcon = new Dbcon();
        dbcon.update("update tbl_encryption_log set water_mark_start_time='" + System.currentTimeMillis() + "' where process_id='" + EmbedFile.process_id + "'");

        if (addWaterMark()) {
            dbcon.update("update tbl_encryption_log set water_mark_end_time='" + System.currentTimeMillis() + "' where process_id='" + EmbedMessage.process_id + "'");
            waterMarkComplete();
            encrypt_button.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Adding watermark failed. Please try again later");
        }
    }//GEN-LAST:event_add_watermark_buttonActionPerformed

    private void waterMarkComplete() {
//        progressBarThread.complete = true;
        progress_bar.setValue(100);
    }

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
            java.util.logging.Logger.getLogger(FileEncryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileEncryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileEncryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileEncryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FileEncryption().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_watermark_button;
    private javax.swing.JButton encrypt_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel main_label;
    private javax.swing.JLabel max_file_size_label;
    private javax.swing.JProgressBar progress_bar;
    private javax.swing.JLabel selected_file_size_label;
    private javax.swing.JComboBox watermark_templates;
    // End of variables declaration//GEN-END:variables
}
