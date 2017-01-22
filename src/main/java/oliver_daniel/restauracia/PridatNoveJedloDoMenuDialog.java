package oliver_daniel.restauracia;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javax.swing.JOptionPane;

public class PridatNoveJedloDoMenuDialog extends javax.swing.JDialog {

    private jedloSCenouDao cena_jedla = ObjectFactory.INSTANCE.getCenyDao();
    private VsetkyJedlaDao zoznam_jedal = ObjectFactory.INSTANCE.getMenu();
    private ObjednavkyDao objednavky = ObjectFactory.INSTANCE.getObjednavkaDao();
    private DenneMenuDao jedla_v_dennom_menu = ObjectFactory.INSTANCE.getDenneMenu();

    private MenuForm m;

    public PridatNoveJedloDoMenuDialog(java.awt.Frame parent, boolean modal, MenuForm menu) {
        super(parent, modal);
        initComponents();
        m = menu;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NazovButton = new javax.swing.JTextField();
        CenaButton = new javax.swing.JTextField();
        pridajButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(435, 120));
        setPreferredSize(new java.awt.Dimension(370, 255));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pridat nove jedlo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(125, 4, 160, 22);
        getContentPane().add(NazovButton);
        NazovButton.setBounds(10, 70, 387, 30);
        getContentPane().add(CenaButton);
        CenaButton.setBounds(157, 135, 82, 30);

        pridajButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pridajButton.setForeground(new java.awt.Color(255, 51, 51));
        pridajButton.setText("Pridaj");
        pridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajButton);
        pridajButton.setBounds(160, 170, 80, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Nazov jedla:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 40, 79, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Cena:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 110, 37, 16);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 33, 411, 13);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluu.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1, 0, 430, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajButtonActionPerformed

        String nazov = "";
        Double cena = 0.0;
        boolean zadaneUdaje = true;
        if (!NazovButton.getText().toString().equals("")) {
            nazov = NazovButton.getText().toString();
        } else {
            zadaneUdaje = false;
        }
        if (!CenaButton.getText().toString().equals("")) {
            cena = Double.parseDouble(CenaButton.getText().toString());
        } else {
            zadaneUdaje = false;
        }

        if (zadaneUdaje) {
            zoznam_jedal.pridaj(nazov);
            jedloSCenou j = new jedloSCenou();
            j.setCena(cena);
            j.setJedlo(nazov);
            this.cena_jedla.pridajJedlo(j);

            m.AktualizujMenu();
            m.AktualizujComboBox();
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Zadaj vsetky udaje!");
        }

    }//GEN-LAST:event_pridajButtonActionPerformed

    public void AktualizujMenuACeny(String jedlo, double cena) {

        try (FileWriter writer = new FileWriter(new File("ceny.txt"), true)) {
            writer.append(jedlo + ";" + Double.toString(cena) + "\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(new File("zoznamJedal.txt"), true)) {
            writer.append(jedlo + "\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

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
            java.util.logging.Logger.getLogger(PridatNoveJedloDoMenuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridatNoveJedloDoMenuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridatNoveJedloDoMenuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridatNoveJedloDoMenuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private MenuForm m;

            public void run() {
                PridatNoveJedloDoMenuDialog dialog = new PridatNoveJedloDoMenuDialog(new javax.swing.JFrame(), true, this.m);
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
    private javax.swing.JTextField CenaButton;
    private javax.swing.JTextField NazovButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton pridajButton;
    // End of variables declaration//GEN-END:variables
}
