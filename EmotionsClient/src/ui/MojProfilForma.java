/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import emotionstogether.User;

/**
 *
 * @author Aleksandra
 */
public class MojProfilForma extends javax.swing.JFrame {

    /**
     * Creates new form MojProfilForma
     */
    
    
    public MojProfilForma() {
        initComponents();
    }
    
    //OVDE SE KUCA KOD

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        podaci_lbl = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        username_txt_fld = new javax.swing.JTextField();
        password_txt_fld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        podaci_lbl.setText("Podaci Vaseg profila:");

        username_lbl.setText("Korisnicko ime:");

        password_lbl.setText("Lozinka:");

        username_txt_fld.setEnabled(false);

        password_txt_fld.setEnabled(false);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(podaci_lbl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(username_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(password_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(podaci_lbl)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_lbl)
                    .addComponent(username_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_lbl)
                    .addComponent(password_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void password_txt_fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_txt_fldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_txt_fldActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel password_lbl;
    private javax.swing.JTextField password_txt_fld;
    private javax.swing.JLabel podaci_lbl;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JTextField username_txt_fld;
    // End of variables declaration//GEN-END:variables
}
