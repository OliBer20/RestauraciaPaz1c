package oliver_daniel.restauracia;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

public class VypisyFrame extends javax.swing.JFrame {

    private vypisDao vypis = ObjectFactory.INSTANCE.getVypis();
    private String zobrazeneObjednavky = "Zobrazene objednavky na: ";
    private zoznamObjednavokForm zozObj;
    
    public VypisyFrame(zoznamObjednavokForm z) {
        initComponents();
        zozObj = z;
    }

    private VypisyFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        objednavkyDnesButton = new javax.swing.JButton();
        objednavkyMesiacButton = new javax.swing.JButton();
        VypisButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        zarobkyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vypisZarobku = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mesiacZobraz = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        rokZobraz = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        vymazObjednavku = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rokCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        mesiacCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        denCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 715));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Segoe UI Historic", 1, 13)); // NOI18N
        jTable1.setModel(new VypisTableModel());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 383, 778, 271);

        objednavkyDnesButton.setBackground(new java.awt.Color(204, 204, 204));
        objednavkyDnesButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        objednavkyDnesButton.setText("Objednavky Dnes");
        objednavkyDnesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objednavkyDnesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(objednavkyDnesButton);
        objednavkyDnesButton.setBounds(219, 13, 160, 63);

        objednavkyMesiacButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        objednavkyMesiacButton.setText("Zobraz");
        objednavkyMesiacButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objednavkyMesiacButtonActionPerformed(evt);
            }
        });
        getContentPane().add(objednavkyMesiacButton);
        objednavkyMesiacButton.setBounds(222, 92, 160, 63);

        VypisButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        VypisButton.setText("Vypis objednavku");
        VypisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VypisButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VypisButton);
        VypisButton.setBounds(466, 143, 147, 54);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Objednavky na deň:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(537, 21, 182, 22);

        zarobkyButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        zarobkyButton.setForeground(new java.awt.Color(51, 153, 0));
        zarobkyButton.setText("Vypis Zarobok");
        zarobkyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zarobkyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zarobkyButton);
        zarobkyButton.setBounds(644, 143, 134, 55);

        vypisZarobku.setEditable(false);
        vypisZarobku.setColumns(20);
        vypisZarobku.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        vypisZarobku.setRows(5);
        vypisZarobku.setText("\n");
        jScrollPane2.setViewportView(vypisZarobku);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(466, 240, 312, 111);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Zobraz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 179, 165, 65);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 83, 403, 2);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 168, 403, 2);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(0, 251, 403, 2);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("INFO:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(466, 211, 54, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Objednavky na mesiac:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(12, 103, 149, 16);

        mesiacZobraz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Január", "Február", "Marec", "Apríl", "Máj", "Jún", "Júl", "August", "September", "Oktober", "November", "December" }));
        getContentPane().add(mesiacZobraz);
        mesiacZobraz.setBounds(44, 126, 116, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Objednavky na rok:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(12, 188, 126, 16);

        rokZobraz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016" }));
        getContentPane().add(rokZobraz);
        rokZobraz.setBounds(46, 211, 119, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dnešné objednávky:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(12, 35, 141, 17);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(183, 376, 0, 0);

        vymazObjednavku.setBackground(new java.awt.Color(255, 0, 0));
        vymazObjednavku.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        vymazObjednavku.setForeground(new java.awt.Color(255, 255, 255));
        vymazObjednavku.setText("Vymaž označené");
        vymazObjednavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazObjednavkuActionPerformed(evt);
            }
        });
        getContentPane().add(vymazObjednavku);
        vymazObjednavku.setBounds(220, 260, 166, 61);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(466, 50, 312, 2);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(432, 0, 16, 360);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 358, 802, 11);

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        rokCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rok:");

        mesiacCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mesiac:");

        denCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Den:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rokCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(mesiacCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(denCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rokCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesiacCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(denCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(466, 59, 310, 71);

        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(670, 400, 48, 16);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alu2.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(-2, 0, 810, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VypisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VypisButtonActionPerformed

        int rok = Integer.parseInt(rokCombo.getSelectedItem().toString());
        int mesiac = Integer.parseInt(mesiacCombo.getSelectedItem().toString());
        int den = Integer.parseInt(denCombo.getSelectedItem().toString());
        vypis.vymazVsetkyJedla();
        List<Objednavka> objednavky = vypis.dajPodlaDatumu(rok, mesiac, den);
        for (Objednavka objednavka : objednavky) {
            vypis.pridajObjednavku(objednavka);
        }
        aktualizovatTabulku();
        zobrazeneObjednavky = "Zobrazene objednavky na: " + Integer.toString(den) + "." + Integer.toString(mesiac) + "." + Integer.toString(rok);
        vypisZarobku.setText(zobrazeneObjednavky);


    }//GEN-LAST:event_VypisButtonActionPerformed

    private void objednavkyDnesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objednavkyDnesButtonActionPerformed
        String s = "";
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int mesiac = cal.get(Calendar.MONTH) + 1;
        int den = cal.get(Calendar.DAY_OF_MONTH);
        zobrazeneObjednavky = "Zobrazene objednavky na den: " + Integer.toString(den) + "." + Integer.toString(mesiac) + "." + Integer.toString(year);
        vypisZarobku.setText(zobrazeneObjednavky);
        vypis.vymazVsetkyJedla();
        List<Objednavka> objednavky = vypis.dajDnesneObjednavky();
        for (Objednavka objednavka : objednavky) {
            vypis.pridajObjednavku(objednavka);
        }
        aktualizovatTabulku();

    }//GEN-LAST:event_objednavkyDnesButtonActionPerformed

    private void objednavkyMesiacButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objednavkyMesiacButtonActionPerformed
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int mesiac = 0;
        if (mesiacZobraz.getSelectedItem().toString().equals("Január")) {
            mesiac = 1;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("Február")) {
            mesiac = 2;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("Marec")) {
            mesiac = 3;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("Apríl")) {
            mesiac = 4;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("Máj")) {
            mesiac = 5;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("Jún")) {
            mesiac = 6;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("Júl")) {
            mesiac = 7;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("August")) {
            mesiac = 8;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("September")) {
            mesiac = 9;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("Oktober")) {
            mesiac = 10;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("November")) {
            mesiac = 11;
        }
        if (mesiacZobraz.getSelectedItem().toString().equals("December")) {
            mesiac = 12;
        }

        vypis.vymazVsetkyJedla();
        List<Objednavka> objednavky = vypis.dajPodlaMesiaca(year, mesiac);
        for (Objednavka objednavka : objednavky) {
            vypis.pridajObjednavku(objednavka);
        }
        aktualizovatTabulku();
        zobrazeneObjednavky = "Zobrazene objednavky na: " + mesiacZobraz.getSelectedItem().toString();
        vypisZarobku.setText(zobrazeneObjednavky);
    }//GEN-LAST:event_objednavkyMesiacButtonActionPerformed

    private void zarobkyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zarobkyButtonActionPerformed
        double zarobok = 0.0;
        int pocet = 0;
        List<Objednavka> objednavky = vypis.dajVsetkyObjednavky();
        for (Objednavka objednavka : objednavky) {
            zarobok += objednavka.getCenaJedla();
            pocet++;
        }
        zarobok = Math.round(zarobok * 10000.0) / 10000.0;
        vypisZarobku.setText(zobrazeneObjednavky + "\n" + "\n" + "Spolu za zobrazene objednavky: " + Double.toString(zarobok) + " €" + "\n" + "\n" + "Pocet objednavok: " + pocet);

    }//GEN-LAST:event_zarobkyButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rok = Integer.parseInt(rokZobraz.getSelectedItem().toString());
        vypis.vymazVsetkyJedla();
        List<Objednavka> objednavky = vypis.dajPodlaRoka(rok);
        for (Objednavka objednavka : objednavky) {
            vypis.pridajObjednavku(objednavka);
        }
        aktualizovatTabulku();
        zobrazeneObjednavky = "Zobrazene objednavky na: " + rokZobraz.getSelectedItem().toString();
        vypisZarobku.setText(zobrazeneObjednavky);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void vymazObjednavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazObjednavkuActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        ObjednavkyDao obj = ObjectFactory.INSTANCE.getObjednavkaDao();
        List<Objednavka> objednavky = obj.dajObjednavky();
        VypisTableModel model = (VypisTableModel) jTable1.getModel();
        Long valueAt = (Long) model.getValueAt(selectedRow, 0);

        for (Objednavka objednavka : objednavky) {
            if (objednavka.getId() == (valueAt)) {
                zobrazeneObjednavky = "Vymazana objednavka: " + objednavka.getNazovJedla() + " " + objednavka.getCenaJedla();
                objednavky.remove(objednavka);
                vypis.Odstran(objednavka);
                obj.Odstran(objednavka);
                aktualizovatTabulku();
                vypisZarobku.setText(zobrazeneObjednavky);
                break;
            }

        }
        zozObj.aktualizovatZoznamObjednavok();

    }//GEN-LAST:event_vymazObjednavkuActionPerformed

    private void aktualizovatTabulku() {
        VypisTableModel model = (VypisTableModel) jTable1.getModel();
        model.aktualizovat();
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
            java.util.logging.Logger.getLogger(VypisyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VypisyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VypisyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VypisyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private zoznamObjednavokForm z;
            public void run() {
                new VypisyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VypisButton;
    private javax.swing.JComboBox<String> denCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> mesiacCombo;
    private javax.swing.JComboBox<String> mesiacZobraz;
    private javax.swing.JButton objednavkyDnesButton;
    private javax.swing.JButton objednavkyMesiacButton;
    private javax.swing.JComboBox<String> rokCombo;
    private javax.swing.JComboBox<String> rokZobraz;
    private javax.swing.JButton vymazObjednavku;
    private javax.swing.JTextArea vypisZarobku;
    private javax.swing.JButton zarobkyButton;
    // End of variables declaration//GEN-END:variables
}
