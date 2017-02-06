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
        zozObj = (zoznamObjednavokForm) parent;
        aktualizujKategorieCombo();
        aktualizujPolozkyCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        nazov = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cena = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pridajButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        napojeCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        vymazNapoj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        kategoriaCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jedlaCombo = new javax.swing.JComboBox<>();
        vymazJedlo = new javax.swing.JButton();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluu.jpg"))); // NOI18N
        jLabel4.setText("Kategória");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(520, 310));
        getContentPane().setLayout(null);
        getContentPane().add(nazov);
        nazov.setBounds(20, 40, 120, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Názov:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(58, 8, 39, 16);

        cena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cenaActionPerformed(evt);
            }
        });
        getContentPane().add(cena);
        cena.setBounds(160, 40, 91, 30);

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
        pridajButton.setBounds(420, 40, 65, 30);

        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 110, 490, 2);

        napojeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                napojeComboActionPerformed(evt);
            }
        });
        getContentPane().add(napojeCombo);
        napojeCombo.setBounds(130, 140, 270, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Vymaž nápoj:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 150, 120, 16);

        vymazNapoj.setBackground(new java.awt.Color(255, 51, 0));
        vymazNapoj.setForeground(new java.awt.Color(255, 255, 255));
        vymazNapoj.setText("vymaž");
        vymazNapoj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazNapojActionPerformed(evt);
            }
        });
        getContentPane().add(vymazNapoj);
        vymazNapoj.setBounds(420, 140, 69, 30);

        jLabel5.setText("Kategória:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 10, 80, 16);

        getContentPane().add(kategoriaCombo);
        kategoriaCombo.setBounds(280, 40, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Vymaž jedlo:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 210, 90, 16);

        getContentPane().add(jedlaCombo);
        jedlaCombo.setBounds(130, 200, 270, 30);

        vymazJedlo.setBackground(new java.awt.Color(255, 0, 51));
        vymazJedlo.setForeground(new java.awt.Color(255, 255, 255));
        vymazJedlo.setText("vymaž");
        vymazJedlo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazJedloActionPerformed(evt);
            }
        });
        getContentPane().add(vymazJedlo);
        vymazJedlo.setBounds(420, 200, 70, 30);

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

    public void aktualizujKategorieCombo() {
        kategoriaCombo.removeAllItems();
        List<Kategoria> nap = kategoriaDao.dajVsetkyKategorie();
        for (Kategoria n : nap) {
            kategoriaCombo.addItem(n.getNazov());
        }
    }

    public void aktualizujPolozkyCombo() {
        napojeCombo.removeAllItems();
        jedlaCombo.removeAllItems();
        List<Polozka> nap = polozkaDao.dajPolozky();
        for (Polozka n : nap) {
            if (n.getKategoria().getNazov().equals("Napoj")) {
                napojeCombo.addItem(n.getNazov());
            } else {
                jedlaCombo.addItem(n.getNazov());
            }
        }

    }

    private void napojeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_napojeComboActionPerformed
    }//GEN-LAST:event_napojeComboActionPerformed

    private void vymazNapojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazNapojActionPerformed

        String nazov = napojeCombo.getSelectedItem().toString();
        Polozka polozka = polozkaDao.dajPodlaNazvu(nazov);
        polozkaDao.vymazPolozku(polozka);

        aktualizujPolozkyCombo();
        zozObj.aktualizujPolozky();

    }//GEN-LAST:event_vymazNapojActionPerformed

    private void cenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cenaActionPerformed

    private void vymazJedloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazJedloActionPerformed
        String nazov = jedlaCombo.getSelectedItem().toString();
        Polozka polozka = polozkaDao.dajPodlaNazvu(nazov);
        polozkaDao.vymazPolozku(polozka);

        aktualizujPolozkyCombo();
        zozObj.aktualizujPolozky();
    }//GEN-LAST:event_vymazJedloActionPerformed

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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jedlaCombo;
    private javax.swing.JComboBox<String> kategoriaCombo;
    private javax.swing.JComboBox<String> napojeCombo;
    private javax.swing.JTextField nazov;
    private javax.swing.JButton pridajButton;
    private javax.swing.JButton vymazJedlo;
    private javax.swing.JButton vymazNapoj;
    // End of variables declaration//GEN-END:variables
}
