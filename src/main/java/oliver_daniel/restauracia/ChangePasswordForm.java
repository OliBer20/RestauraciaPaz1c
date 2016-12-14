package oliver_daniel.restauracia;

import java.awt.Color;
import javax.swing.JOptionPane;

public class ChangePasswordForm extends javax.swing.JDialog {

    private boolean boss = false;
    private boolean others = false;
    private HeslaDao hesla = ObjectFactory.INSTANCE.getHesla();

    public ChangePasswordForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bossRadio = new javax.swing.JRadioButton();
        othersRadio = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        stareHeslo = new javax.swing.JPasswordField();
        noveHeslo = new javax.swing.JPasswordField();
        ulozitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(370, 400));
        getContentPane().setLayout(null);

        bossRadio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bossRadio.setText("Boss");
        bossRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bossRadioActionPerformed(evt);
            }
        });
        getContentPane().add(bossRadio);
        bossRadio.setBounds(54, 18, 61, 25);

        othersRadio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        othersRadio.setText("Others");
        othersRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersRadioActionPerformed(evt);
            }
        });
        getContentPane().add(othersRadio);
        othersRadio.setBounds(236, 18, 75, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Zmena hesla:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(133, 61, 91, 17);
        getContentPane().add(stareHeslo);
        stareHeslo.setBounds(112, 140, 126, 22);
        getContentPane().add(noveHeslo);
        noveHeslo.setBounds(112, 224, 126, 22);

        ulozitButton.setBackground(new java.awt.Color(153, 153, 153));
        ulozitButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ulozitButton.setForeground(new java.awt.Color(255, 0, 0));
        ulozitButton.setText("Uložiť");
        ulozitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ulozitButton);
        ulozitButton.setBounds(145, 308, 69, 25);

        jLabel2.setText("Staré heslo:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(142, 117, 70, 16);

        jLabel3.setText("Nové heslo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(143, 201, 67, 16);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluu.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1, -4, 400, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bossRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bossRadioActionPerformed
        bossRadio.setForeground(Color.red);
        bossRadio.setSelected(true);
        othersRadio.setSelected(false);
        othersRadio.setForeground(Color.BLACK);
        boss = true;
        others = false;
    }//GEN-LAST:event_bossRadioActionPerformed

    private void othersRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersRadioActionPerformed
        bossRadio.setForeground(Color.BLACK);
        bossRadio.setSelected(false);
        othersRadio.setSelected(true);
        othersRadio.setForeground(Color.red);
        boss = false;
        others = true;
    }//GEN-LAST:event_othersRadioActionPerformed

    private void ulozitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitButtonActionPerformed
        String stareH = stareHeslo.getText().toString();
        String noveH = noveHeslo.getText().toString();
        prihlasenieForm p = new prihlasenieForm();
        if (boss) {

            if (hesla.dajHeslo("boss").getHeslo().equals(stareH)) {
                hesla.nastavHeslo("boss", noveH);
                p.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Skontrolujte si zapisane hesla!");
            }
        } else if (others) {
            if (hesla.dajHeslo("others").getHeslo().equals(stareH)) {
                hesla.nastavHeslo("others", noveH);
                p.setVisible(true);
                dispose();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Skontrolujte si zapisane hesla!");
        }

    }//GEN-LAST:event_ulozitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangePasswordForm dialog = new ChangePasswordForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bossRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField noveHeslo;
    private javax.swing.JRadioButton othersRadio;
    private javax.swing.JPasswordField stareHeslo;
    private javax.swing.JButton ulozitButton;
    // End of variables declaration//GEN-END:variables
}
