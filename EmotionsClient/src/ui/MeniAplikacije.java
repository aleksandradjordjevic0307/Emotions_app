/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;

/**
 *
 * @author Aleksandra
 */
public class MeniAplikacije extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaStranicaAplikacije
     */
    public MeniAplikacije() {
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

        unesiEmocijuBtn = new javax.swing.JButton();
        pregledEmocijaBtn = new javax.swing.JButton();
        mojProfilBtn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        unesiEmocijuBtn.setText("Unesi emociju");
        unesiEmocijuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unesiEmocijuBtnActionPerformed(evt);
            }
        });

        pregledEmocijaBtn.setText("Pregled mojih emocija");
        pregledEmocijaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pregledEmocijaBtnActionPerformed(evt);
            }
        });

        mojProfilBtn.setText("Moj profil");
        mojProfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mojProfilBtnActionPerformed(evt);
            }
        });

        logout_btn.setText("Izloguj se");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unesiEmocijuBtn)
                    .addComponent(pregledEmocijaBtn)
                    .addComponent(mojProfilBtn)
                    .addComponent(logout_btn))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unesiEmocijuBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pregledEmocijaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mojProfilBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logout_btn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unesiEmocijuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unesiEmocijuBtnActionPerformed
        
        this.setVisible(false);
        UnesiEmocijuForma em = new UnesiEmocijuForma();
        em.setVisible(true);
    }//GEN-LAST:event_unesiEmocijuBtnActionPerformed

    private void mojProfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mojProfilBtnActionPerformed

        this.setVisible(false);
        MojProfilForma mp = new MojProfilForma();
        mp.setVisible(true);
    
        
    }//GEN-LAST:event_mojProfilBtnActionPerformed

    private void pregledEmocijaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pregledEmocijaBtnActionPerformed
        //prikaz emocija
        //proveri da li ces kao formu da prikazes ili na neki drugi nacin
    }//GEN-LAST:event_pregledEmocijaBtnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
        sesija.Session.getInstance().setUlogovani(null);
        this.dispose();
        JOptionPane.showMessageDialog(this, "Uspesno ste se izlogovali!");
        LogInForma lf = new LogInForma();
        lf.setVisible(true);
    }//GEN-LAST:event_logout_btnActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton mojProfilBtn;
    private javax.swing.JButton pregledEmocijaBtn;
    private javax.swing.JButton unesiEmocijuBtn;
    // End of variables declaration//GEN-END:variables
}
