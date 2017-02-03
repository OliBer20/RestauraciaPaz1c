package oliver_daniel.restauracia;

import factory.ObjectFactory;
import dao.ObjednavkyDao;
import dao.PolozkaDao;
import entity.Polozka;
import dao.KategoriaDao;
import java.awt.Color;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.Objednavka;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class zoznamObjednavokForm extends javax.swing.JFrame {

    private ObjednavkyDao objednavkaDao = ObjectFactory.INSTANCE.getObjednavkaDao();

    private KategoriaDao kategorie = ObjectFactory.INSTANCE.getKategoriaDao();
    private PolozkaDao polozkaDao = ObjectFactory.INSTANCE.getPolozkaDao();

    private double suma;
    private int pocet;
    private Map<Polozka, Integer> polozkyVObjednavke = new HashMap<>();

    public zoznamObjednavokForm() {

        initComponents();
        ((ObjednavkaTableModel) ObjednavkyTable.getModel()).setMap(polozkyVObjednavke);
        aktualizujInfo();
        aktualizujPolozky();
        nastavPodlaPrihlaseneho();

    }

    public void nastavPodlaPrihlaseneho() {

        if (zistiPrihlaseneho().equals("boss")) {
            vypisObjednavkyButton.setEnabled(true);

        } else {
            vypisObjednavkyButton.setEnabled(false);
        }

    }

    public String zistiPrihlaseneho() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("prihlasenyPrava.txt"));
            String s = sc.next();
            return s;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return null;
    }

    public void nastavText(String s) {
        informaciaText.setText(s);
    }

    void aktualizujObsahObjednavky() {
        ((ObjednavkaTableModel) ObjednavkyTable.getModel()).aktualizovat();
    }

    void aktualizujPocetSumu(int novyPocet, double novaSuma) {
        pocet = novyPocet;
        suma = novaSuma;
        pocetPoloziekVObjednavke.setText(pocet + "");
        sumaObjednavky.setText(suma + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pridajObjednavkuButton = new javax.swing.JButton();
        ComboJedla = new javax.swing.JComboBox<>();
        ComboNapoje = new javax.swing.JComboBox<>();
        informaciaText = new javax.swing.JTextField();
        infoLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pocetPoloziekVObjednavke = new javax.swing.JLabel();
        sumaObjednavky = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        denneMenuButton = new javax.swing.JButton();
        vypisObjednavkyButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ObjednavkyTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pridajNapojButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        vymazPredosluButton = new javax.swing.JButton();
        pridatObjednavku = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        popis = new javax.swing.JTextField();
        jedloPocet = new javax.swing.JTextField();
        napojPocet = new javax.swing.JTextField();

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alu2.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(690, 640));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel1.setText("Jedlo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 110, 55, 26);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel3.setText("Nápoj:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 160, 61, 26);

        pridajObjednavkuButton.setText("Pridaj");
        pridajObjednavkuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajObjednavkuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajObjednavkuButton);
        pridajObjednavkuButton.setBounds(390, 110, 70, 25);

        ComboJedla.setForeground(new java.awt.Color(102, 102, 102));
        ComboJedla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vyber Jedlo:" }));
        getContentPane().add(ComboJedla);
        ComboJedla.setBounds(80, 110, 220, 30);

        ComboNapoje.setForeground(new java.awt.Color(102, 102, 102));
        ComboNapoje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vyber Nápoj:" }));
        getContentPane().add(ComboNapoje);
        ComboNapoje.setBounds(80, 160, 220, 30);

        informaciaText.setEditable(false);
        informaciaText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        informaciaText.setForeground(new java.awt.Color(255, 51, 51));
        informaciaText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        informaciaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informaciaTextActionPerformed(evt);
            }
        });
        getContentPane().add(informaciaText);
        informaciaText.setBounds(10, 540, 640, 33);

        infoLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setText("Informácia:");
        getContentPane().add(infoLabel);
        infoLabel.setBounds(290, 510, 86, 19);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tekton Pro Cond", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Objednávka:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Odhlásiť sa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SUMA:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pocet Poloziek:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("€");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ks");

        pocetPoloziekVObjednavke.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pocetPoloziekVObjednavke.setText("0");

        sumaObjednavky.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        sumaObjednavky.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pocetPoloziekVObjednavke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(60, 60, 60)
                        .addComponent(sumaObjednavky, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(pocetPoloziekVObjednavke, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(sumaObjednavky, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 13, 660, 80);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        denneMenuButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        denneMenuButton.setText("Denné Menu");
        denneMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denneMenuButtonActionPerformed(evt);
            }
        });

        vypisObjednavkyButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vypisObjednavkyButton.setText("Vypisy");
        vypisObjednavkyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vypisObjednavkyButtonActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 0));
        jButton3.setText("Pridaj polozku");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(denneMenuButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vypisObjednavkyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(denneMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vypisObjednavkyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(490, 90, 170, 180);

        ObjednavkyTable.setFont(new java.awt.Font("Segoe UI Historic", 1, 13)); // NOI18N
        ObjednavkyTable.setModel(new ObjednavkaTableModel());
        ObjednavkyTable.setFocusable(false);
        ObjednavkyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ObjednavkyTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ObjednavkyTable);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 331, 640, 170);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 150, 462, 2);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 200, 462, 10);

        pridajNapojButton.setText("Pridaj");
        pridajNapojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajNapojButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajNapojButton);
        pridajNapojButton.setBounds(390, 160, 70, 25);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 280, 462, 10);

        vymazPredosluButton.setBackground(new java.awt.Color(255, 0, 0));
        vymazPredosluButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vymazPredosluButton.setForeground(new java.awt.Color(255, 255, 255));
        vymazPredosluButton.setText("Vymaž obsah objednávky");
        vymazPredosluButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazPredosluButtonActionPerformed(evt);
            }
        });
        getContentPane().add(vymazPredosluButton);
        vymazPredosluButton.setBounds(440, 290, 210, 30);

        pridatObjednavku.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pridatObjednavku.setForeground(new java.awt.Color(255, 0, 0));
        pridatObjednavku.setText("Pridať celú objednavku");
        pridatObjednavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatObjednavkuActionPerformed(evt);
            }
        });
        getContentPane().add(pridatObjednavku);
        pridatObjednavku.setBounds(10, 290, 230, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Popis Objednavky:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 210, 140, 16);
        getContentPane().add(popis);
        popis.setBounds(10, 240, 460, 30);

        jedloPocet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jedloPocetActionPerformed(evt);
            }
        });
        getContentPane().add(jedloPocet);
        jedloPocet.setBounds(310, 110, 70, 30);
        getContentPane().add(napojPocet);
        napojPocet.setBounds(310, 160, 70, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajObjednavkuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajObjednavkuButtonActionPerformed

        if (!ComboJedla.getSelectedItem().equals(ComboJedla.getItemAt(0))) {

            String nazov = ComboJedla.getSelectedItem().toString();
            Polozka p = polozkaDao.dajPodlaNazvu(nazov);

            int pocet = 0;
            if (jedloPocet.getText().toString().equals("")) {
                pocet = 1;
            } else {
                pocet = Integer.parseInt(jedloPocet.getText());
            }
            jedloPocet.setText(null);

            if (polozkyVObjednavke.containsKey(p)) {
                polozkyVObjednavke.put(p, polozkyVObjednavke.get(p) + pocet);
            } else {
                polozkyVObjednavke.put(p, pocet);
            }

            ComboJedla.setSelectedIndex(0);

            aktualizujPocetSumu(this.pocet + pocet, suma + pocet * p.getCena());

            informaciaText.setBackground(Color.GREEN);
            informaciaText.setText("Pridane jedlo");

        } else {
            JOptionPane.showMessageDialog(null, "Nevybrate jedlo!");
        }

        aktualizujObsahObjednavky();
    }//GEN-LAST:event_pridajObjednavkuButtonActionPerformed

    private void denneMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denneMenuButtonActionPerformed
        MenuForm menuForm = new MenuForm();
        menuForm.setVisible(true);

    }//GEN-LAST:event_denneMenuButtonActionPerformed

    private void vypisObjednavkyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vypisObjednavkyButtonActionPerformed
        VypisyFrame v = new VypisyFrame(this);
        v.setVisible(true);

    }//GEN-LAST:event_vypisObjednavkyButtonActionPerformed

    private void ObjednavkyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ObjednavkyTableMouseClicked

    }//GEN-LAST:event_ObjednavkyTableMouseClicked

    public void aktualizujPolozky() {
        ComboNapoje.removeAllItems();
        ComboJedla.removeAllItems();

        ComboNapoje.addItem("Vyber Nápoj:");
        ComboJedla.addItem("Vyber jedlo:");

        List<Polozka> nap = polozkaDao.dajPolozky();
        for (Polozka s : nap) {
            if (s.getKategoria().getNazov().equals("Napoj")) {
                ComboNapoje.addItem(s.getNazov());
            } else if (s.getKategoria().getNazov().equals("Jedlo")) {
                ComboJedla.addItem(s.getNazov());
            }
        }
    }


    private void pridajNapojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajNapojButtonActionPerformed

        if (!ComboNapoje.getSelectedItem().toString().equals(ComboNapoje.getItemAt(0))) {

            String nazov = ComboNapoje.getSelectedItem().toString();
            Polozka p = polozkaDao.dajPodlaNazvu(nazov);

            int pocet = 0;
            if (napojPocet.getText().toString().equals("")) {
                pocet = 1;
            } else {
                pocet = Integer.parseInt(napojPocet.getText());
            }
            napojPocet.setText(null);

            if (polozkyVObjednavke.containsKey(p)) {
                polozkyVObjednavke.put(p, polozkyVObjednavke.get(p) + pocet);
            } else {
                polozkyVObjednavke.put(p, pocet);
            }

            ComboNapoje.setSelectedIndex(0);
            aktualizujPocetSumu(this.pocet + pocet, suma + pocet * p.getCena());

            informaciaText.setBackground(Color.GREEN);
            informaciaText.setText("Pridany napoj");
        } else {
            JOptionPane.showMessageDialog(null, "Nevybraty napoj!");
        }
        aktualizujObsahObjednavky();
    }//GEN-LAST:event_pridajNapojButtonActionPerformed

    private void informaciaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informaciaTextActionPerformed

    }//GEN-LAST:event_informaciaTextActionPerformed

    private void vymazPredosluButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazPredosluButtonActionPerformed

        Set<Polozka> set = new HashSet<>();
        for (Polozka pol : polozkyVObjednavke.keySet()) {
            set.add(pol);
        }
        polozkyVObjednavke.keySet().removeAll(set);

        aktualizujObsahObjednavky();
        aktualizujPocetSumu(0, 0);

        informaciaText.setText("Neulozena objednavka do systemu!");

    }//GEN-LAST:event_vymazPredosluButtonActionPerformed

    private void aktualizujInfo() {

        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        informaciaText.setText("Dobrý deň! Dnešný dátum je: " + Integer.toString(day) + "." + Integer.toString(month) + "." + Integer.toString(year));

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        prihlasenieForm p = new prihlasenieForm();
        p.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PridajPolozkuDialog p = new PridajPolozkuDialog(this, true);
        p.setVisible(true);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void pridatObjednavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatObjednavkuActionPerformed

        Objednavka obje = new Objednavka();
        obje.setPolozky(polozkyVObjednavke);
        obje.setSuma(suma);
        if (!popis.getText().toString().equals("")) {
            obje.setPopis(popis.getText().toString());
        } else {
            obje.setPopis("Nezadany popis");
        }
        obje.setCasObjednavky(new Date(System.currentTimeMillis()));
        objednavkaDao.pridajObjednavku(obje);

        informaciaText.setText("Uspesne pridana objednavka");

        aktualizujPocetSumu(0, 0);
        popis.setText(null);

        polozkyVObjednavke.clear();
        aktualizujObsahObjednavky();

    }//GEN-LAST:event_pridatObjednavkuActionPerformed

    private void jedloPocetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jedloPocetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jedloPocetActionPerformed

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
    private javax.swing.JTable ObjednavkyTable;
    private javax.swing.JButton denneMenuButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JTextField informaciaText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jedloPocet;
    private javax.swing.JTextField napojPocet;
    private javax.swing.JLabel pocetPoloziekVObjednavke;
    private javax.swing.JTextField popis;
    private javax.swing.JButton pridajNapojButton;
    private javax.swing.JButton pridajObjednavkuButton;
    private javax.swing.JButton pridatObjednavku;
    private javax.swing.JLabel sumaObjednavky;
    private javax.swing.JButton vymazPredosluButton;
    private javax.swing.JButton vypisObjednavkyButton;
    // End of variables declaration//GEN-END:variables

}
