package oliver_daniel.restauracia;

import dao.KategoriaDao;
import dao.PolozkaDao;
import entity.Kategoria;
import entity.Polozka;
import factory.ObjectFactory;
import java.util.List;
import javax.swing.JOptionPane;

public class PridajPolozkuDialog extends javax.swing.JDialog {

    private PolozkaDao polozkaDao = ObjectFactory.INSTANCE.getPolozkaDao();
    private KategoriaDao kategoriaDao = ObjectFactory.INSTANCE.getKategoriaDao();
    private zoznamObjednavokForm zozObj;

    public PridajPolozkuDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        zozObj = (zoznamObjednavokForm)parent;
        aktualizujKategorieCombo();
        aktualizujPolozkyCombo();
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
        polozkaCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        vymazButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        kategoriaCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(440, 168));
        getContentPane().setLayout(null);
        getContentPane().add(nazov);
        nazov.setBounds(20, 30, 120, 22);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Názov:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(58, 8, 39, 16);
        getContentPane().add(cena);
        cena.setBounds(160, 30, 91, 22);

        jLabel2.setText("Cena:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 10, 34, 16);

        pridajButton.setBackground(new java.awt.Color(51, 153, 0));
        pridajButton.setForeground(new java.awt.Color(255, 255, 255));
        pridajButton.setText("pridaj");
        pridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajButton);
        pridajButton.setBounds(420, 30, 65, 25);

        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 63, 490, 2);

        polozkaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polozkaComboActionPerformed(evt);
            }
        });
        getContentPane().add(polozkaCombo);
        polozkaCombo.setBounds(139, 80, 160, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Vymaž položku:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 80, 120, 16);

        vymazButton.setBackground(new java.awt.Color(255, 51, 0));
        vymazButton.setForeground(new java.awt.Color(255, 255, 255));
        vymazButton.setText("vymaž");
        vymazButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazButtonActionPerformed(evt);
            }
        });
        getContentPane().add(vymazButton);
        vymazButton.setBounds(420, 80, 69, 25);

        jLabel5.setText("Kategória:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 10, 80, 16);

        kategoriaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(kategoriaCombo);
        kategoriaCombo.setBounds(280, 30, 120, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluu.jpg"))); // NOI18N
        jLabel4.setText("Kategória");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-9, -10, 510, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajButtonActionPerformed

        try {
            Polozka n = new Polozka();
            n.setNazov(nazov.getText());
            n.setCena(Double.parseDouble(this.cena.getText()));
            
            Kategoria kategoria = kategoriaDao.dajKategoriu(kategoriaCombo.getSelectedItem().toString());
            n.setKategoria(kategoria);
            
            polozkaDao.pridajPolozku(n);
            
            aktualizujPolozkyCombo();
            zozObj.aktualizujPolozky();
            
            nazov.setText(null);
            this.cena.setText(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Desatinne cislo zadavaj cez bodku!");
        }


    }//GEN-LAST:event_pridajButtonActionPerformed

    public void aktualizujKategorieCombo(){
        kategoriaCombo.removeAllItems();
        List<Kategoria> nap = kategoriaDao.dajVsetkyKategorie();
        for (Kategoria n : nap) {
            kategoriaCombo.addItem(n.getNazov());
        }
    }
    
    public void aktualizujPolozkyCombo() {
        polozkaCombo.removeAllItems();
        List<Polozka> nap = polozkaDao.dajPolozky();
        for (Polozka n : nap) {
            polozkaCombo.addItem(n.getNazov());
        }

    }

    private void polozkaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polozkaComboActionPerformed
    }//GEN-LAST:event_polozkaComboActionPerformed

    private void vymazButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazButtonActionPerformed

        String nazov = polozkaCombo.getSelectedItem().toString();

        Polozka polozka = polozkaDao.dajPodlaNazvu(nazov);
        polozkaDao.vymazPolozku(polozka);

        aktualizujPolozkyCombo();
        zozObj.aktualizujPolozky();

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
            java.util.logging.Logger.getLogger(PridajPolozkuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridajPolozkuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridajPolozkuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridajPolozkuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private zoznamObjednavokForm zozObj;

            public void run() {
                PridajPolozkuDialog dialog = new PridajPolozkuDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> kategoriaCombo;
    private javax.swing.JTextField nazov;
    private javax.swing.JComboBox<String> polozkaCombo;
    private javax.swing.JButton pridajButton;
    private javax.swing.JButton vymazButton;
    // End of variables declaration//GEN-END:variables
}
