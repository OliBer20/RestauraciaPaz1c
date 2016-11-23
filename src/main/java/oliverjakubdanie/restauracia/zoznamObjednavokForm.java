package oliverjakubdanie.restauracia;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class zoznamObjednavokForm extends javax.swing.JFrame {

    private ObjednavkyDao zoznamObj = ObjednavkaDaoFactory.INSTANCE.getObjednavkaDao();
    private cenyJedal ceny = new cenyJedal();

    public zoznamObjednavokForm() {

        initComponents();
        aktualizovatZoznamObjednavok();
        aktualizovatDenneMenu();
        aktualizujInfo();

    }

    public void aktualizovatDenneMenu() {
        ComboJedla.removeAllItems();
        ComboJedla.addItem("Vyber polozku:");
        Scanner sc = null;
        try {
            sc = new Scanner(new File("denneMenu.txt"));
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] ss = s.split(";");
                ComboJedla.addItem(ss[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }

    private void aktualizovatZoznamObjednavok() {

        ObjednavkaTableModel model = (ObjednavkaTableModel) ObjednavkyTable.getModel();
        model.aktualizovat();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pridajObjednavkuButton = new javax.swing.JButton();
        ComboJedla = new javax.swing.JComboBox<>();
        ComboNapoje = new javax.swing.JComboBox<>();
        IneZapisCenu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        IneZapisNazov = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        informaciaText = new javax.swing.JTextField();
        infoLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        zobrazObjednavkyButton = new javax.swing.JButton();
        denneMenuButton = new javax.swing.JButton();
        vycistiObj = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ObjednavkyTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pridajNapojButton = new javax.swing.JButton();
        pridajIneButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel1.setText("Jedlo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel3.setText("Nápoj:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel2.setText("Iné:");

        pridajObjednavkuButton.setText("Pridaj");
        pridajObjednavkuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajObjednavkuButtonActionPerformed(evt);
            }
        });

        ComboJedla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vyber Jedlo:" }));

        ComboNapoje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vyber nápoj:", "Cola 250ml", "Sprite 250ml", "Fanta 250ml", "Vino 3dc" }));

        jLabel5.setText("Cena:");

        IneZapisNazov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IneZapisNazovActionPerformed(evt);
            }
        });

        jLabel6.setText("Názov:");

        informaciaText.setEditable(false);
        informaciaText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        informaciaText.setForeground(new java.awt.Color(255, 51, 51));
        informaciaText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        informaciaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informaciaTextActionPerformed(evt);
            }
        });

        infoLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        infoLabel.setText("Informácia:");

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel4.setFont(new java.awt.Font("Tekton Pro Cond", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Objednávka:");

        refreshButton.setText("Refresh");
        refreshButton.setPreferredSize(new java.awt.Dimension(103, 25));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        zobrazObjednavkyButton.setText("Zobraz obj.");
        zobrazObjednavkyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazObjednavkyButtonActionPerformed(evt);
            }
        });

        denneMenuButton.setText("Denné Menu");
        denneMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denneMenuButtonActionPerformed(evt);
            }
        });

        vycistiObj.setText("Vycistit obj.");
        vycistiObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vycistiObjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vycistiObj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazObjednavkyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(denneMenuButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(denneMenuButton)
                .addGap(18, 18, 18)
                .addComponent(zobrazObjednavkyButton)
                .addGap(18, 18, 18)
                .addComponent(vycistiObj)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        ObjednavkyTable.setModel(new ObjednavkaTableModel());
        ObjednavkyTable.setFocusable(false);
        ObjednavkyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ObjednavkyTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ObjednavkyTable);

        pridajNapojButton.setText("Pridaj");
        pridajNapojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajNapojButtonActionPerformed(evt);
            }
        });

        pridajIneButton.setText("Pridaj");
        pridajIneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajIneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(informaciaText)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(21, 21, 21)
                                                        .addComponent(ComboJedla, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(IneZapisNazov, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(34, 34, 34)
                                                                .addComponent(IneZapisCenu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ComboNapoje, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(41, 41, 41))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(jLabel6)
                                                .addGap(100, 100, 100)
                                                .addComponent(jLabel5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(pridajIneButton)
                                                .addGap(13, 13, 13))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(pridajNapojButton)
                                                    .addComponent(pridajObjednavkuButton))
                                                .addGap(12, 12, 12)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(infoLabel)
                .addGap(261, 261, 261))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ComboJedla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pridajObjednavkuButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(ComboNapoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pridajNapojButton)
                                .addGap(12, 12, 12)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(IneZapisNazov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IneZapisCenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pridajIneButton))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informaciaText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IneZapisNazovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IneZapisNazovActionPerformed

    }//GEN-LAST:event_IneZapisNazovActionPerformed

    private void zobrazObjednavkyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazObjednavkyButtonActionPerformed
    }//GEN-LAST:event_zobrazObjednavkyButtonActionPerformed


    private void pridajObjednavkuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajObjednavkuButtonActionPerformed

        String jedlo = ComboJedla.getSelectedItem().toString();
        Objednavka o = new Objednavka();
        o.setNazovJedla(jedlo);
        o.setId(0);
        double cena = ceny.ziskajCenu(jedlo);
        o.setCenaJedla(cena);
        o.setCasObjednavky(null);
        zoznamObj.pridaj(o);

        aktualizovatZoznamObjednavok();

        ComboJedla.setSelectedIndex(0);
        ComboNapoje.setSelectedIndex(0);
        IneZapisNazov.setText(null);
        IneZapisCenu.setText(null);

        informaciaText.setBackground(Color.GREEN);
        informaciaText.setText("Pridana objednavka: " + jedlo + " " + Double.toString(cena) + "€");

    }//GEN-LAST:event_pridajObjednavkuButtonActionPerformed

    private void denneMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denneMenuButtonActionPerformed
        MenuForm menuForm = new MenuForm();
        menuForm.setVisible(true);

    }//GEN-LAST:event_denneMenuButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        aktualizovatDenneMenu();
        ceny.naplnMapuJedlamiZTxt();

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void vycistiObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vycistiObjActionPerformed


    }//GEN-LAST:event_vycistiObjActionPerformed

    private void ObjednavkyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ObjednavkyTableMouseClicked
        ObjednavkaTableModel o = new ObjednavkaTableModel();
        Objednavka obj = o.dajKliknutuObjednavku(jTable1.rowAtPoint(evt.getPoint()));
        String nazov = obj.getNazovJedla();
        Date datum = obj.getCasObjednavky();
        zoznamObj.Odstran(obj);

        aktualizovatZoznamObjednavok();

    }//GEN-LAST:event_ObjednavkyTableMouseClicked

    private void pridajIneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajIneButtonActionPerformed
        String ine = IneZapisNazov.getText();
        Objednavka o = new Objednavka();
        o.setNazovJedla(ine);
        o.setId(0);
        double cena = Double.parseDouble(IneZapisCenu.getText());
        o.setCenaJedla(cena);
        o.setCasObjednavky(null);
        zoznamObj.pridaj(o);

        aktualizovatZoznamObjednavok();

        ComboJedla.setSelectedIndex(0);
        ComboNapoje.setSelectedIndex(0);
        IneZapisNazov.setText(null);
        IneZapisCenu.setText(null);

        informaciaText.setBackground(Color.GREEN);
        informaciaText.setText("Pridana objednavka: " + ine + " " + Double.toString(cena) + "€");
    }//GEN-LAST:event_pridajIneButtonActionPerformed

    private void pridajNapojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajNapojButtonActionPerformed
        String napoj = ComboNapoje.getSelectedItem().toString();
        Objednavka o = new Objednavka();
        o.setNazovJedla(napoj);
        o.setId(0);
        double cena = (ceny.ziskajCenu(napoj));
        o.setCenaJedla(cena);
        o.setCasObjednavky(null);
        zoznamObj.pridaj(o);

        aktualizovatZoznamObjednavok();

        ComboJedla.setSelectedIndex(0);
        ComboNapoje.setSelectedIndex(0);
        IneZapisNazov.setText(null);
        IneZapisCenu.setText(null);

        informaciaText.setBackground(Color.GREEN);
        informaciaText.setText("Pridana objednavka: " + napoj + " " + Double.toString(cena) + "€");
    }//GEN-LAST:event_pridajNapojButtonActionPerformed

    private void informaciaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informaciaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_informaciaTextActionPerformed

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
            java.util.logging.Logger.getLogger(zoznamObjednavokForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(zoznamObjednavokForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(zoznamObjednavokForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(zoznamObjednavokForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new zoznamObjednavokForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJedla;
    private javax.swing.JComboBox<String> ComboNapoje;
    private javax.swing.JTextField IneZapisCenu;
    private javax.swing.JTextField IneZapisNazov;
    private javax.swing.JTable ObjednavkyTable;
    private javax.swing.JButton denneMenuButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JTextField informaciaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pridajIneButton;
    private javax.swing.JButton pridajNapojButton;
    private javax.swing.JButton pridajObjednavkuButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton vycistiObj;
    private javax.swing.JButton zobrazObjednavkyButton;
    // End of variables declaration//GEN-END:variables

    private void aktualizujInfo() {

        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        informaciaText.setText("Dobrý deň! Dnešný dátum je: " + Integer.toString(day) + "." + Integer.toString(month) + "." + Integer.toString(year));

    }
}
