package oliver_daniel.restauracia;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

public class VypisyFrame extends javax.swing.JFrame {

    private vypisDao vypis = ObjectFactory.INSTANCE.getVypis();
    private String zobrazeneObjednavky = "Zobrazene objednavky na: ";

    public VypisyFrame() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new VypisTableModel());
        jScrollPane1.setViewportView(jTable1);

        objednavkyDnesButton.setBackground(new java.awt.Color(204, 204, 204));
        objednavkyDnesButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        objednavkyDnesButton.setText("Objednavky Dnes");
        objednavkyDnesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objednavkyDnesButtonActionPerformed(evt);
            }
        });

        objednavkyMesiacButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        objednavkyMesiacButton.setText("Zobraz");
        objednavkyMesiacButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objednavkyMesiacButtonActionPerformed(evt);
            }
        });

        VypisButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        VypisButton.setText("Vypis objednavku");
        VypisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VypisButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Objednavky na deň:");

        zarobkyButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        zarobkyButton.setForeground(new java.awt.Color(51, 153, 0));
        zarobkyButton.setText("Vypis Zarobok");
        zarobkyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zarobkyButtonActionPerformed(evt);
            }
        });

        vypisZarobku.setEditable(false);
        vypisZarobku.setColumns(20);
        vypisZarobku.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        vypisZarobku.setRows(5);
        vypisZarobku.setText("\n");
        jScrollPane2.setViewportView(vypisZarobku);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Zobraz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("INFO:");

        jLabel7.setText("Objednavky na mesiac:");

        mesiacZobraz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Január", "Február", "Marec", "Apríl", "Máj", "Jún", "Júl", "August", "September", "Oktober", "November", "December" }));

        jLabel8.setText("Objednavky na rok:");

        rokZobraz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Dnešné objednávky:");

        vymazObjednavku.setBackground(new java.awt.Color(255, 102, 0));
        vymazObjednavku.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        vymazObjednavku.setForeground(new java.awt.Color(255, 255, 255));
        vymazObjednavku.setText("Vymaž označené");
        vymazObjednavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazObjednavkuActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(objednavkyDnesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(171, 171, 171)
                                        .addComponent(jLabel9)
                                        .addGap(19, 220, Short.MAX_VALUE)))))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(mesiacZobraz, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(objednavkyMesiacButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(rokZobraz, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(vymazObjednavku, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(VypisButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(zarobkyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(objednavkyDnesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(objednavkyMesiacButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mesiacZobraz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rokZobraz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vymazObjednavku, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zarobkyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VypisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
        int rok = Integer.parseInt(rokCombo.getSelectedItem().toString());
        int mesiac = Integer.parseInt(mesiacCombo.getSelectedItem().toString());
        int den = Integer.parseInt(denCombo.getSelectedItem().toString());
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
                obj.Odstran(objednavka);
                aktualizovatTabulku();
                vypisZarobku.setText(zobrazeneObjednavky);
                break;
            }

        }

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
