package oliverjakubdanie.restauracia;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MenuForm extends javax.swing.JFrame {

    private Menu menu = new Menu();
    private DenneMenu denneMenu = new DenneMenu();

    public Menu getMenu() {
        return menu;
    }

    private int pocetKliknutiNaPolozkuVMenu = 0;
    private int pocetKliknutiNaPolozkuVDennomMenu = 0;

    public MenuForm() {
        initComponents();
        AktualizujMenu();
        PridajKliknutyObjektDoDennehoMenu();
        VymazKliknutyObjektZDennehoMenu();

    }

    public void VymazKliknutyObjektZDennehoMenu() {
        DenneMenuList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                pocetKliknutiNaPolozkuVDennomMenu++;

                if (pocetKliknutiNaPolozkuVDennomMenu == 1) {
                    int index = DenneMenuList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object jedlo = DenneMenuList.getModel().getElementAt(index);
                        odstranZDennehoMenu(jedlo.toString());
                    }
                    pocetKliknutiNaPolozkuVDennomMenu = 0;
                }
            }

        });

    }

    public void PridajKliknutyObjektDoDennehoMenu() {

        ZoznamJedalList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                pocetKliknutiNaPolozkuVMenu++;

                if (pocetKliknutiNaPolozkuVMenu == 1) {
                    int index = ZoznamJedalList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object jedlo = ZoznamJedalList.getModel().getElementAt(index);
                        presunJedloDoDennehoMEnu(jedlo.toString());
                    }
                    pocetKliknutiNaPolozkuVMenu = 0;
                }
            }
        });

    }

    private void odstranZDennehoMenu(String jedlo) {
        List<JednaPolozkaMenu> dMenu = denneMenu.getZoznamDennehoMenu();
        List<JednaPolozkaMenu> noveDenneMenu = new ArrayList<>();
        JednaPolozkaMenu j = prerobStringNaJedlo(jedlo);

        for (JednaPolozkaMenu polozka : dMenu) {
            if (!polozka.getNazov().equals(j.getNazov())) {
                noveDenneMenu.add(polozka);
            }
        }
        denneMenu.setZoznamDennehoMenu(noveDenneMenu);

        AktualizujDenneMenu();

    }

    private void zobrazMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        List<JednaPolozkaMenu> CeleMenu = menu.getMenu();
        String[] celeMenuPole = new String[CeleMenu.size()];
        for (int i = 0; i < CeleMenu.size(); i++) {
            celeMenuPole[i] = CeleMenu.get(i).getNazov() + " " + CeleMenu.get(i).getCena();
        }

        ZoznamJedalList.setListData(celeMenuPole);

    }

    public void presunJedloDoDennehoMEnu(String jedlo) {

        denneMenu.getZoznamDennehoMenu().add(prerobStringNaJedlo(jedlo));
        AktualizujDenneMenu();

    }

    public JednaPolozkaMenu prerobStringNaJedlo(String jedlo) {
        JednaPolozkaMenu noveJedlo = new JednaPolozkaMenu();
        Scanner s = null;
        String nazovJedla = "";
        Double cena = 0.0;
        try {
            s = new Scanner(jedlo);
            s.useLocale(Locale.US);
            while (s.hasNext()) {
                String slovo = s.next();
                nazovJedla += slovo + " ";

                noveJedlo.setNazov(nazovJedla);
                if (s.hasNextDouble()) {
                    cena = s.nextDouble();
                    noveJedlo.setCena(cena);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }

        return noveJedlo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DenneMenuList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ZoznamJedalList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        vymazDenneMenuButton = new javax.swing.JButton();
        pridatJedloButton = new javax.swing.JButton();
        aktualizujButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(DenneMenuList);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel1.setText("Denne menu:");

        ZoznamJedalList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        ZoznamJedalList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Grilovanz encian 25.50" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ZoznamJedalList);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setText("Zoznam jedal:");

        jPanel1.setBackground(new java.awt.Color(204, 0, 204));

        vymazDenneMenuButton.setText("Vymaz denne menu");
        vymazDenneMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazDenneMenuButtonActionPerformed(evt);
            }
        });

        pridatJedloButton.setText("Pridat Jedlo");
        pridatJedloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatJedloButtonActionPerformed(evt);
            }
        });

        aktualizujButton.setText("Aktualizuj menu");
        aktualizujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vymazDenneMenuButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aktualizujButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pridatJedloButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pridatJedloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aktualizujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(135, 135, 135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vymazDenneMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazDenneMenuButtonActionPerformed

        List<JednaPolozkaMenu> list = new ArrayList<>();
        denneMenu.setZoznamDennehoMenu(list);
        AktualizujDenneMenu();

    }//GEN-LAST:event_vymazDenneMenuButtonActionPerformed

    private void pridatJedloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatJedloButtonActionPerformed
        PridatNoveJedloDoMenu pridatNoveJedloDoMenu = new PridatNoveJedloDoMenu();
        pridatNoveJedloDoMenu.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_pridatJedloButtonActionPerformed

    public void vypis() {
        JOptionPane.showMessageDialog(null, "uspesne");

    }

    private void aktualizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujButtonActionPerformed
       zoznamObjednavokForm z = new zoznamObjednavokForm(denneMenu.getZoznamDennehoMenu());
        this.setVisible(false);
        dispose();

    }//GEN-LAST:event_aktualizujButtonActionPerformed

    public void AktualizujDenneMenu() {
        List<JednaPolozkaMenu> DenneMenu = denneMenu.getZoznamDennehoMenu();
        String[] celeMenuPole = new String[DenneMenu.size()];
        for (int i = 0; i < DenneMenu.size(); i++) {
            celeMenuPole[i] = DenneMenu.get(i).getNazov() + " " + DenneMenu.get(i).getCena();
        }

        DenneMenuList.setListData(celeMenuPole);

    }

    public void AktualizujMenu() {
        List<JednaPolozkaMenu> menu = this.menu.getMenu();
        String[] celeMenuPole = new String[menu.size()];
        for (int i = 0; i < menu.size(); i++) {
            celeMenuPole[i] = menu.get(i).getNazov() + " " + menu.get(i).getCena();
        }

        ZoznamJedalList.setListData(celeMenuPole);

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuForm().setVisible(true);
            }
        });
    }

    public JList<String> getZoznamJedalList() {
        return ZoznamJedalList;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DenneMenuList;
    private javax.swing.JList<String> ZoznamJedalList;
    private javax.swing.JButton aktualizujButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pridatJedloButton;
    private javax.swing.JButton vymazDenneMenuButton;
    // End of variables declaration//GEN-END:variables
}
