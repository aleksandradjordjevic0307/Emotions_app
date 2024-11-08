/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author Aleksandra
 */
public class RecnikEmocijaForma extends javax.swing.JFrame {

    /**
     * Creates new form RecnikEmocijaForma
     */
    public RecnikEmocijaForma() {
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

        emo_vocabulary_txt_area = new java.awt.TextArea();
        back_emo_btn = new javax.swing.JButton();
        bck_menu_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emo_vocabulary_txt_area.setColumns(1);
        emo_vocabulary_txt_area.setEditable(false);
        emo_vocabulary_txt_area.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        emo_vocabulary_txt_area.setText("Strah - osecanje koje subjekat oseca u situacijama u kojima procenjuje da je ugrozena neka njegova vrednost i da ne bi mogao da se adekvatno suprotstavi objektima ili situacijama koje ga ugrozavaju. \n\nLjutnja (bes) - subjekt oseca ljutnju kada procenjuje da se neko neopravdano ponasa na nacin koji ugrozava neku subjektovu vrednost.\n\nSreca - osecanje koje subjekt oseca kada je ostvarena neka od njegovih najvecih zelja, odnosno afirmisana neka od najvisih vrednosti.\n\nTuga - subjekt oseca tugu ili zalost u situacijama u kojima procenjuje da nepovratno gubi nesto sto mu je vredno.\n\nPoverenje - osecanje poverenja se javlja kada je subjekt procenio drugu osobu kao dobronamernu, pouzdanu i odgovornu. \n\n");

        back_emo_btn.setText("Nazad na dodavanje emocije");
        back_emo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_emo_btnActionPerformed(evt);
            }
        });

        bck_menu_btn.setText("Nazad na glavni meni");
        bck_menu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bck_menu_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emo_vocabulary_txt_area, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bck_menu_btn)
                            .addComponent(back_emo_btn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emo_vocabulary_txt_area, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bck_menu_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back_emo_btn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_emo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_emo_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        UnesiEmocijuForma u = new UnesiEmocijuForma();
        u.setVisible(true);
    }//GEN-LAST:event_back_emo_btnActionPerformed

    private void bck_menu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bck_menu_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MeniAplikacije m = new MeniAplikacije();
        m.setVisible(true);
    }//GEN-LAST:event_bck_menu_btnActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_emo_btn;
    private javax.swing.JButton bck_menu_btn;
    private java.awt.TextArea emo_vocabulary_txt_area;
    // End of variables declaration//GEN-END:variables
}
