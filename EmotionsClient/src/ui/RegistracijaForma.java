/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import controller.ClientController;
import emotionstogether.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aleksandra
 */
public class RegistracijaForma extends javax.swing.JFrame {

    /**
     * Creates new form RegistracijaForma
     */
    public RegistracijaForma() {
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

        korisnicko_ime_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        registracija_btn = new javax.swing.JButton();
        korisnicko_ime_txt_fld = new javax.swing.JTextField();
        password_txt_fld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        korisnicko_ime_lbl.setText("Korisničko ime:");

        password_lbl.setText("Šifra:");

        registracija_btn.setText("Registruj se");
        registracija_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registracija_btnActionPerformed(evt);
            }
        });

        korisnicko_ime_txt_fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                korisnicko_ime_txt_fldActionPerformed(evt);
            }
        });

        password_txt_fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_txt_fldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(korisnicko_ime_lbl)
                    .addComponent(password_lbl))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(korisnicko_ime_txt_fld, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(password_txt_fld))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registracija_btn)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(korisnicko_ime_lbl)
                    .addComponent(korisnicko_ime_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_lbl)
                    .addComponent(password_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(registracija_btn)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void korisnicko_ime_txt_fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_korisnicko_ime_txt_fldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_korisnicko_ime_txt_fldActionPerformed

    private void registracija_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registracija_btnActionPerformed

        try {
            if(korisnicko_ime_txt_fld.getText().isEmpty() || password_txt_fld.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Morate popuniti korisnicko ime i sifru.");
            }
            
            User u = new User();
            u.setUsername(korisnicko_ime_txt_fld.getText());
            u.setPassword(password_txt_fld.getText());
            
            ClientController.getInstance().addUser(u);
            System.out.println("Registr forma sad treba da cita usera");
            ClientController.getInstance().readUser(u);
            JOptionPane.showMessageDialog(this, "Uspesno ste kreirali profil");
            sesija.Session.getInstance().setUlogovani(u);
            this.dispose();
            /*UnesiEmocijuForma e = new UnesiEmocijuForma();
            e.setVisible(true);*/
            MeniAplikacije m = new MeniAplikacije();
            m.setVisible(true);
            
            
        } catch (Exception ex) {
            Logger.getLogger(RegistracijaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_registracija_btnActionPerformed

    private void password_txt_fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_txt_fldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_txt_fldActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel korisnicko_ime_lbl;
    private javax.swing.JTextField korisnicko_ime_txt_fld;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JTextField password_txt_fld;
    private javax.swing.JButton registracija_btn;
    // End of variables declaration//GEN-END:variables
}
