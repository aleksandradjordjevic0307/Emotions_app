/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import controller.ClientController;
import emotionstogether.Emotion;
import emotionstogether.User;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sesija.Session;


/**
 *
 * @author Aleksandra
 */
public class UnesiEmocijuForma extends javax.swing.JFrame {

    /**
     * Creates new form YearInPixelsMoja
     */
    public UnesiEmocijuForma() {
        initComponents();
    }

    LocalDate currentDate = LocalDate.now();
    int godina = currentDate.getYear();
    int dan = currentDate.getDayOfMonth();
    int mesec = currentDate.getMonthValue();
    
    String datum = dan+"/"+mesec+"/"+godina;
    
   
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        datum_lbl = new javax.swing.JLabel();
        datum_txt_fld = new javax.swing.JTextField();
        emocija_lbl = new javax.swing.JLabel();
        emocija_combo_box = new javax.swing.JComboBox<>();
        btnSacuvaj = new javax.swing.JButton();
        btnPrikazi = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        emo_vocabulary_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        datum_lbl.setText("Danasnji datum ");

        datum_txt_fld.setEditable(false);
        datum_txt_fld.setText(datum);
        datum_txt_fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datum_txt_fldActionPerformed(evt);
            }
        });

        emocija_lbl.setText("Vase osecanje");

        emocija_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SREĆA", "TUGA", "BES", "POVERENJE", "STRAH"}));
        emocija_combo_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emocija_combo_boxActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnPrikazi.setText("Prikazi");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        back_btn.setText("Nazad");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        emo_vocabulary_btn.setText("Recnik emocija");
        emo_vocabulary_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emo_vocabulary_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPrikazi, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datum_lbl)
                            .addComponent(datum_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emocija_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emo_vocabulary_btn)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emocija_lbl)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datum_lbl)
                    .addComponent(emocija_lbl))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datum_txt_fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emocija_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emo_vocabulary_btn))
                .addGap(65, 65, 65)
                .addComponent(btnSacuvaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrikazi)
                    .addComponent(back_btn))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datum_txt_fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datum_txt_fldActionPerformed
        // TODO add your handling code here:     
    }//GEN-LAST:event_datum_txt_fldActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            
            String username = sesija.Session.getInstance().getUlogovani().getUsername();


            System.out.println("Stampanje datuma iz forme unesiEmociju: " + currentDate);
            String emotion = (String) emocija_combo_box.getSelectedItem();
            System.out.println("Stampanje unete emocije iz forme unesiEmociju: " + emotion);
           
            
            Emotion e = new Emotion();
            Date datum = Date.valueOf(currentDate);
            e.setDate(datum);
            e.setEmotion(emotion);
            e.setUsername(username);
          
            ClientController.getInstance().addEmotion(e);
            
            JOptionPane.showMessageDialog(this, "Uspesno ste uneli emociju");
            this.dispose();
            MeniAplikacije m = new MeniAplikacije();
            m.setVisible(true);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnPrikaziActionPerformed

    private void emocija_combo_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emocija_combo_boxActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_emocija_combo_boxActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MeniAplikacije m = new MeniAplikacije();
        m.setVisible(true);
    }//GEN-LAST:event_back_btnActionPerformed

    private void emo_vocabulary_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emo_vocabulary_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        RecnikEmocijaForma re = new RecnikEmocijaForma();
        re.setVisible(true);
    }//GEN-LAST:event_emo_vocabulary_btnActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel datum_lbl;
    private javax.swing.JTextField datum_txt_fld;
    private javax.swing.JButton emo_vocabulary_btn;
    private javax.swing.JComboBox<String> emocija_combo_box;
    private javax.swing.JLabel emocija_lbl;
    private javax.swing.JColorChooser jColorChooser1;
    // End of variables declaration//GEN-END:variables
}
