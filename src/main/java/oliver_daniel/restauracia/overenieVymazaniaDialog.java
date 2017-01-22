package oliver_daniel.restauracia;

public class overenieVymazaniaDialog extends javax.swing.JDialog {

    private DenneMenuDao jedla_v_dennom_menu = ObjectFactory.INSTANCE.getDenneMenu();
    private ObjednavkyDao objednavky = ObjectFactory.INSTANCE.getObjednavkaDao();
    private jedloSCenouDao ceny_jedal = ObjectFactory.INSTANCE.getCenyDao();
    private vypisDao vypisy = ObjectFactory.INSTANCE.getVypis();
    private VsetkyJedlaDao zoznam_jedal = ObjectFactory.INSTANCE.getMenu();
    private NapojeDao zoznam_napojov = ObjectFactory.INSTANCE.getNapoje();
    private NapojeDao ceny_napojov = ObjectFactory.INSTANCE.getCenyNapojovDao();

    private String db;
    private zoznamObjednavokForm zozObj;

    public overenieVymazaniaDialog(java.awt.Frame parent, boolean modal, String databaza, zoznamObjednavokForm z) {
        super(parent, modal);
        initComponents();
        db = databaza;
        zozObj = z;
        databazaLabel.setText(databaza);
    }

    public void odstranenie() {

        if (db.equals("Objednavky")) {
            objednavky.odstranVsetko();
            zozObj.aktualizovatZoznamObjednavok();
            zozObj.aktualizovatDenneMenu();
            zozObj.nastavText("Vymazana databaza objednavok!");
        }
        if (db.equals("Ceny jedal")) {
            ceny_jedal.vymazVsetkyJedla();
            zozObj.aktualizovatZoznamObjednavok();
            zozObj.nastavText("Vymazana databaza cien jedal!");
        }
        if (db.equals("Ceny napojov")) {
            ceny_napojov.vymazVsetkyNapoje();
            zozObj.aktualizovatZoznamObjednavok();
            zozObj.nastavText("Vymazana databaza cien napojov!");
        }
        if (db.equals("Denne menu")) {
            jedla_v_dennom_menu.vymazVsetko();
            zozObj.aktualizovatDenneMenu();
            zozObj.aktualizovatZoznamObjednavok();
            zozObj.nastavText("Vymazana databaza denneho menu!");
        }
        if (db.equals("Zoznam jedal")) {
            zoznam_jedal.vymazVsetko();
            zozObj.aktualizovatDenneMenu();
            zozObj.aktualizovatZoznamObjednavok();
            zozObj.nastavText("Vymazana databaza zoznamu jedal!");
        }
        if (db.equals("Vypisy")) {
            vypisy.vymazVsetkyJedla();
            zozObj.aktualizovatZoznamObjednavok();
            zozObj.nastavText("Vymazana databaza vypisov");
        }
         if (db.equals("Napoje")) {
            zoznam_napojov.vymazVsetkyNapoje();
            zozObj.aktualizovatZoznamObjednavok();
            zozObj.aktualizujNapoje();
            zozObj.nastavText("Vymazana databaza napojov");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anoButton = new javax.swing.JButton();
        nieButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        databazaLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(270, 160));
        setPreferredSize(new java.awt.Dimension(272, 218));
        getContentPane().setLayout(null);

        anoButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        anoButton.setForeground(new java.awt.Color(255, 51, 0));
        anoButton.setText("Áno");
        anoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(anoButton);
        anoButton.setBounds(51, 121, 60, 30);

        nieButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nieButton.setText("Nie");
        nieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nieButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nieButton);
        nieButton.setBounds(147, 121, 60, 30);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Naozaj chcete  vymazať");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("databázu:");

        databazaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        databazaLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(databazaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(databazaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(12, 13, 224, 91);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluu.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-7, -5, 290, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoButtonActionPerformed

        odstranenie();
        dispose();


    }//GEN-LAST:event_anoButtonActionPerformed

    private void nieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nieButtonActionPerformed
        dispose();
    }//GEN-LAST:event_nieButtonActionPerformed

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
            java.util.logging.Logger.getLogger(overenieVymazaniaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(overenieVymazaniaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(overenieVymazaniaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(overenieVymazaniaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String s;
            private zoznamObjednavokForm zozObj;

            public void run() {
                overenieVymazaniaDialog dialog = new overenieVymazaniaDialog(new javax.swing.JFrame(), true, this.s, this.zozObj);
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
    private javax.swing.JButton anoButton;
    private javax.swing.JLabel databazaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nieButton;
    // End of variables declaration//GEN-END:variables
}
