package oliver_daniel.restauracia;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class zoznamObjednavokForm extends javax.swing.JFrame {

    private DenneMenuDao jedla_v_dennom_menu = ObjectFactory.INSTANCE.getDenneMenu();
    private ObjednavkyDao objednavky = ObjectFactory.INSTANCE.getObjednavkaDao();
    private jedloSCenouDao ceny_jedal = ObjectFactory.INSTANCE.getCenyDao();
    private NapojeDao ceny_napojov = ObjectFactory.INSTANCE.getCenyNapojovDao();
    private vypisDao vypisy = ObjectFactory.INSTANCE.getVypis();
    private VsetkyJedlaDao zoznam_jedal = ObjectFactory.INSTANCE.getMenu();
    private NapojeDao zoznam_napojov = ObjectFactory.INSTANCE.getNapoje();

    private boolean vymazanePredosle = false;

    public zoznamObjednavokForm() {

        initComponents();
        aktualizovatZoznamObjednavok();
        aktualizovatDenneMenu();
        aktualizujInfo();
        aktualizujNapoje();
        nastavPodlaPrihlaseneho();

    }

    public void nastavPodlaPrihlaseneho() {

        if (zistiPrihlaseneho().equals("boss")) {
            vypisObjednavkyButton.setEnabled(true);
            okButton.setEnabled(true);
            okButton.setForeground(Color.red);

        } else {
            vypisObjednavkyButton.setEnabled(false);
            okButton.setEnabled(false);
            okButton.setForeground(Color.gray);

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

    public void aktualizovatDenneMenu() {
        ComboJedla.removeAllItems();
        ComboJedla.addItem("Vyber polozku:");
        for (String j : jedla_v_dennom_menu.ziskajDenneMenu()) {
            ComboJedla.addItem(j);
        }

    }

    public void nastavText(String s) {
        informaciaText.setText(s);
    }

    public void aktualizovatZoznamObjednavok() {
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        denneMenuButton = new javax.swing.JButton();
        vypisObjednavkyButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ObjednavkyTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pridajNapojButton = new javax.swing.JButton();
        pridajIneButton = new javax.swing.JButton();
        vymazatCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        napojeButton = new javax.swing.JButton();
        vymazPredosluButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

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
        setMinimumSize(new java.awt.Dimension(653, 635));
        setPreferredSize(new java.awt.Dimension(637, 582));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jedlo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 76, 55, 26);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nápoj:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 127, 61, 26);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Iné:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 200, 38, 26);

        pridajObjednavkuButton.setText("Pridaj");
        pridajObjednavkuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajObjednavkuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajObjednavkuButton);
        pridajObjednavkuButton.setBounds(397, 80, 70, 25);

        ComboJedla.setForeground(new java.awt.Color(102, 102, 102));
        ComboJedla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vyber Jedlo:" }));
        getContentPane().add(ComboJedla);
        ComboJedla.setBounds(94, 81, 271, 22);

        ComboNapoje.setForeground(new java.awt.Color(102, 102, 102));
        ComboNapoje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vyber Nápoj:" }));
        getContentPane().add(ComboNapoje);
        ComboNapoje.setBounds(91, 132, 166, 22);
        getContentPane().add(IneZapisCenu);
        IneZapisCenu.setBounds(251, 205, 73, 22);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cena:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(268, 177, 50, 16);

        IneZapisNazov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IneZapisNazovActionPerformed(evt);
            }
        });
        getContentPane().add(IneZapisNazov);
        IneZapisNazov.setBounds(92, 205, 125, 22);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Názov:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(129, 177, 50, 16);

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
        informaciaText.setBounds(12, 546, 613, 33);

        infoLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setText("Informácia:");
        getContentPane().add(infoLabel);
        infoLabel.setBounds(276, 520, 86, 19);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 13, 625, 56);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vypisObjednavkyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(denneMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(denneMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vypisObjednavkyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(486, 76, 139, 140);

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
        jScrollPane3.setBounds(12, 296, 613, 211);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(12, 112, 462, 2);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(12, 168, 462, 2);

        pridajNapojButton.setText("Pridaj");
        pridajNapojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajNapojButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajNapojButton);
        pridajNapojButton.setBounds(397, 131, 70, 25);

        pridajIneButton.setText("Pridaj");
        pridajIneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajIneButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajIneButton);
        pridajIneButton.setBounds(396, 204, 70, 25);

        vymazatCombo.setForeground(new java.awt.Color(102, 102, 102));
        vymazatCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Objednávky", "Ceny jedál", "Ceny nápojov", "Denné Menu", "Zoznam jedál", "Výpisy", "Napoje" }));
        vymazatCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazatComboActionPerformed(evt);
            }
        });
        getContentPane().add(vymazatCombo);
        vymazatCombo.setBounds(130, 260, 180, 22);

        jLabel7.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Vymazať všetky:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(12, 258, 103, 16);

        okButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 0, 0));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton);
        okButton.setBounds(330, 260, 49, 25);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(12, 236, 462, 10);

        napojeButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        napojeButton.setForeground(new java.awt.Color(0, 153, 0));
        napojeButton.setText("Nápoje");
        napojeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                napojeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(napojeButton);
        napojeButton.setBounds(264, 131, 102, 25);

        vymazPredosluButton.setBackground(new java.awt.Color(255, 0, 0));
        vymazPredosluButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vymazPredosluButton.setForeground(new java.awt.Color(255, 255, 255));
        vymazPredosluButton.setText("Vymaž predošlu objednavku");
        vymazPredosluButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazPredosluButtonActionPerformed(evt);
            }
        });
        getContentPane().add(vymazPredosluButton);
        vymazPredosluButton.setBounds(410, 260, 215, 25);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alu2.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 640, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IneZapisNazovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IneZapisNazovActionPerformed

    }//GEN-LAST:event_IneZapisNazovActionPerformed

    private void vymazatComboActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void pridajObjednavkuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajObjednavkuButtonActionPerformed

        if (!ComboJedla.getSelectedItem().equals(ComboJedla.getItemAt(0))) {
            String jedlo = ComboJedla.getSelectedItem().toString();

            Objednavka o = new Objednavka();
            jedloSCenou j = new jedloSCenou();
            j.setJedlo(jedlo);
            o.setNazov(jedlo);
            o.setId(0);
            double cena = (ceny_jedal.ziskajCenu(j));
            o.setCena(cena);
            o.setCasObjednavky(null);

            objednavky.pridaj(o);
            vymazanePredosle = false;

            aktualizovatZoznamObjednavok();

            ComboJedla.setSelectedIndex(0);
            ComboNapoje.setSelectedIndex(0);
            IneZapisNazov.setText(null);
            IneZapisCenu.setText(null);

            informaciaText.setBackground(Color.GREEN);
            informaciaText.setText("Pridana objednavka: " + jedlo + " " + Double.toString(cena) + "€");

        } else {
            JOptionPane.showMessageDialog(null, "Nevybrate jedlo!");
        }


    }//GEN-LAST:event_pridajObjednavkuButtonActionPerformed

    private void denneMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denneMenuButtonActionPerformed
        MenuForm menuForm = new MenuForm(this);
        menuForm.setVisible(true);

    }//GEN-LAST:event_denneMenuButtonActionPerformed

    private void vypisObjednavkyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vypisObjednavkyButtonActionPerformed
        VypisyFrame v = new VypisyFrame(this);
        v.setVisible(true);

    }//GEN-LAST:event_vypisObjednavkyButtonActionPerformed

    private void ObjednavkyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ObjednavkyTableMouseClicked

    }//GEN-LAST:event_ObjednavkyTableMouseClicked

    private void pridajIneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajIneButtonActionPerformed
        boolean ok = true;
        if (IneZapisNazov.getText().equals(" ") || IneZapisNazov.getText().equals(null)) {
            ok = false;
        }
        if (IneZapisCenu.getText().equals("")) {
            ok = false;
        }

        try {
            double cena = Double.parseDouble(IneZapisCenu.getText());
        } catch (Exception e) {
            ok = false;
        }

        if (ok) {
            String ine = IneZapisNazov.getText();
            Objednavka o = new Objednavka();
            o.setNazov(ine);
            o.setId(0);
            double cena = 0;
            cena = Double.parseDouble(IneZapisCenu.getText());
            o.setCena(cena);
            o.setCasObjednavky(null);
            objednavky.pridaj(o);
            vymazanePredosle = false;

            aktualizovatZoznamObjednavok();

            ComboJedla.setSelectedIndex(0);
            ComboNapoje.setSelectedIndex(0);
            IneZapisNazov.setText(null);
            IneZapisCenu.setText(null);

            informaciaText.setBackground(Color.GREEN);
            informaciaText.setText("Pridana objednavka: " + ine + " " + Double.toString(cena) + "€");
        } else {
            JOptionPane.showMessageDialog(null, "Zadaj vhodne udaje!");
        }

    }//GEN-LAST:event_pridajIneButtonActionPerformed

    public void aktualizujNapoje() {
        ComboNapoje.removeAllItems();
        ComboNapoje.addItem("Vyber Nápoj:");
        List<Napoj> nap = zoznam_napojov.dajNapoje();
        for (Napoj s : nap) {
            ComboNapoje.addItem(s.getNazov());
        }
    }

    private void pridajNapojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajNapojButtonActionPerformed

        if (!ComboNapoje.getSelectedItem().toString().equals(ComboNapoje.getItemAt(0))) {
            String napoj = ComboNapoje.getSelectedItem().toString();
            Objednavka o = new Objednavka();
            Napoj n = new Napoj();
            n.setNazov(napoj);
            o.setNazov(napoj);
            o.setId(0);
            double cena = (ceny_napojov.ziskajCenu(n));
            o.setCena(cena);
            o.setCasObjednavky(null);

            objednavky.pridaj(o);
            vymazanePredosle = false;

            aktualizovatZoznamObjednavok();

            ComboJedla.setSelectedIndex(0);
            ComboNapoje.setSelectedIndex(0);
            IneZapisNazov.setText(null);
            IneZapisCenu.setText(null);

            informaciaText.setBackground(Color.GREEN);
            informaciaText.setText("Pridana objednavka: " + napoj + " " + Double.toString(cena) + "€");
        } else {
            JOptionPane.showMessageDialog(null, "Nevybraty napoj!");
        }

    }//GEN-LAST:event_pridajNapojButtonActionPerformed

    private void informaciaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informaciaTextActionPerformed

    }//GEN-LAST:event_informaciaTextActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        int index = vymazatCombo.getSelectedIndex();
        if (index == 0) {
            overenieVymazaniaDialog s = new overenieVymazaniaDialog(this, true, "Objednavky", this);
            s.setVisible(true);
        }
        if (index == 1) {
            overenieVymazaniaDialog s = new overenieVymazaniaDialog(this, true, "Ceny jedal", this);
            s.setVisible(true);
        }
        if (index == 2) {
            overenieVymazaniaDialog s = new overenieVymazaniaDialog(this, true, "Ceny napojov", this);
            s.setVisible(true);
        }
        if (index == 3) {
            overenieVymazaniaDialog s = new overenieVymazaniaDialog(this, true, "Denne menu", this);
            s.setVisible(true);
        }
        if (index == 4) {
            overenieVymazaniaDialog s = new overenieVymazaniaDialog(this, true, "Zoznam jedal", this);
            s.setVisible(true);
        }
        if (index == 5) {
            overenieVymazaniaDialog s = new overenieVymazaniaDialog(this, true, "Vypisy", this);
            s.setVisible(true);
        }
        if (index == 6) {
            overenieVymazaniaDialog s = new overenieVymazaniaDialog(this, true, "Napoje", this);
            s.setVisible(true);
        }


    }//GEN-LAST:event_okButtonActionPerformed

    private void napojeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_napojeButtonActionPerformed
        PridajNapojDialog p = new PridajNapojDialog(this, true, this);
        p.setVisible(true);

    }//GEN-LAST:event_napojeButtonActionPerformed

    private void vymazPredosluButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazPredosluButtonActionPerformed

        if (!vymazanePredosle) {
            vymazanePredosle = true;
            objednavky.vymazPredosluObjednavku();
            aktualizovatZoznamObjednavok();
            informaciaText.setText("Vymazana predosla objednavka!");
        }
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton napojeButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton pridajIneButton;
    private javax.swing.JButton pridajNapojButton;
    private javax.swing.JButton pridajObjednavkuButton;
    private javax.swing.JButton vymazPredosluButton;
    private javax.swing.JComboBox<String> vymazatCombo;
    private javax.swing.JButton vypisObjednavkyButton;
    // End of variables declaration//GEN-END:variables

}
