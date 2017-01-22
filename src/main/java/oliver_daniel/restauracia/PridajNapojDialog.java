package oliver_daniel.restauracia;

import java.util.List;

public class PridajNapojDialog extends javax.swing.JDialog {
    
    private NapojeDao napoje = ObjectFactory.INSTANCE.getNapoje();
    private jedloSCenouDao ceny = ObjectFactory.INSTANCE.getCenyDao();
    private zoznamObjednavokForm zozObj;
    
    public PridajNapojDialog(java.awt.Frame parent, boolean modal, zoznamObjednavokForm z) {
        super(parent, modal);
        initComponents();
        zozObj = z;
        aktualizujNapojCombo();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nazov = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cena = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pridajButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        napojCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        vymazButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(440, 168));
        getContentPane().setLayout(null);
        getContentPane().add(nazov);
        nazov.setBounds(20, 32, 120, 22);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Názov:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(58, 8, 39, 16);
        getContentPane().add(cena);
        cena.setBounds(182, 32, 91, 22);

        jLabel2.setText("Cena:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(205, 8, 34, 16);

        pridajButton.setBackground(new java.awt.Color(51, 153, 0));
        pridajButton.setForeground(new java.awt.Color(255, 255, 255));
        pridajButton.setText("pridaj");
        pridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajButton);
        pridajButton.setBounds(330, 30, 65, 25);

        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 63, 442, 2);

        napojCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                napojComboActionPerformed(evt);
            }
        });
        getContentPane().add(napojCombo);
        napojCombo.setBounds(129, 77, 139, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Vymaž nápoj:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 80, 88, 16);

        vymazButton.setBackground(new java.awt.Color(255, 51, 0));
        vymazButton.setForeground(new java.awt.Color(255, 255, 255));
        vymazButton.setText("vymaž");
        vymazButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazButtonActionPerformed(evt);
            }
        });
        getContentPane().add(vymazButton);
        vymazButton.setBounds(330, 80, 69, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluu.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-9, -10, 440, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajButtonActionPerformed
        Napoj n = new Napoj();
        n.setNapoj(nazov.getText());
        Double cena = Double.parseDouble(this.cena.getText());
        n.setCena(cena);
        napoje.pridajNapoj(n);
        
        ceny.pridajNapoj(n);
        aktualizujNapojCombo();
        zozObj.aktualizujNapoje();
        nazov.setText(null);
        this.cena.setText(null);

    }//GEN-LAST:event_pridajButtonActionPerformed
    
    public void aktualizujNapojCombo() {
        napojCombo.removeAllItems();
        List<Napoj> nap = napoje.dajNapoje();
        for (Napoj n : nap) {
            napojCombo.addItem(n.getNapoj());
        }
        
    }

    private void napojComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_napojComboActionPerformed
    }//GEN-LAST:event_napojComboActionPerformed

    private void vymazButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazButtonActionPerformed
        Napoj n = new Napoj();
        String napoj = napojCombo.getSelectedItem().toString();
        n.setNapoj(napoj);
        napoje.vymazNapoj(n);
        aktualizujNapojCombo();
         zozObj.aktualizujNapoje();

    }//GEN-LAST:event_vymazButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(PridajNapojDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridajNapojDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridajNapojDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridajNapojDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private zoznamObjednavokForm zozObj;
            
            public void run() {
                PridajNapojDialog dialog = new PridajNapojDialog(new javax.swing.JFrame(), true, this.zozObj);
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
    private javax.swing.JTextField cena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> napojCombo;
    private javax.swing.JTextField nazov;
    private javax.swing.JButton pridajButton;
    private javax.swing.JButton vymazButton;
    // End of variables declaration//GEN-END:variables
}
