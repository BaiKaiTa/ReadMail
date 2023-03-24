/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author ByKyTa
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.mail.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public frmLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đăng Nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username:");
        jPanel2.add(jLabel3);

        txtUserName.setText("bykyta269@gmail.com");
        jPanel2.add(txtUserName);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password:");
        jPanel2.add(jLabel4);

        txtPassword.setText("HoMinhTrung69123");
        jPanel2.add(txtPassword);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        btnDangNhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel3.add(btnDangNhap);

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel3.add(btnThoat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int KiemTraKetNoi(){
        try {
                URL url = new URL("https://www.google.com");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                if (con.getResponseCode() == 200){
                    return 1;
                }
            } catch (Exception exception) {     
            }
        return 0;
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        loadSettings();
        if(KiemTraKetNoi()==1)
        {
            try {
		saveProperties(	txtUserName.getText(), txtPassword.getText());				
		dispose();                
            try {
                frmMailClient frmNhanMail=new frmMailClient(txtUserName.getText(), txtPassword.getText());
                frmNhanMail.setpassword(txtPassword.getText());
                frmNhanMail.setUserName(txtUserName.getText());
                frmNhanMail.setVisible(true);
            } catch (MessagingException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi: " +ex.getMessage(), "Thông báo",1);
            }
                new frmLogin().setVisible(false);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Lỗi đăng nhập: " + ex.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
		}
        }
        else
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại kết nối Internet!", "Thông báo", 1);
        
    }//GEN-LAST:event_btnDangNhapActionPerformed
    private void loadSettings() {       
		Properties configProps = null;
		try 
                {
			configProps = loadProperties();
		} 
                catch (IOException ex) 
                {
			JOptionPane.showMessageDialog(this, "Error reading settings: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
    private Properties configProps;
    private File configFile = new File("smtp.properties"); 
    public Properties loadProperties() throws IOException {
		Properties defaultProps = new Properties();
		defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
		defaultProps.setProperty("mail.smtp.port", "587");
		defaultProps.setProperty("mail.user", "tom@gmail.com");
		defaultProps.setProperty("mail.password", "secret");
		defaultProps.setProperty("mail.smtp.starttls.enable", "true");
		defaultProps.setProperty("mail.smtp.auth", "true");
		
		configProps = new Properties(defaultProps);
		
		// loads properties from file
		if (configFile.exists()) {
			InputStream inputStream = new FileInputStream(configFile);
			configProps.load(inputStream);
			inputStream.close();
		}
		
		return configProps;
	}
    public void saveProperties(String user, String pass) throws IOException {
		configProps.setProperty("mail.smtp.host", "smtp.gmail.com");
		configProps.setProperty("mail.smtp.port", "587");
		configProps.setProperty("mail.user", user);
		configProps.setProperty("mail.password", pass);
		configProps.setProperty("mail.smtp.starttls.enable", "true");
		configProps.setProperty("mail.smtp.auth", "true");
		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "host setttings");
		outputStream.close();
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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
