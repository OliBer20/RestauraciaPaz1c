package oliverjakubdanie.restauracia;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MenuForm extends javax.swing.JFrame {

    List<JednaPolozkaMenu> polozky = new ArrayList<>();

    private Menu menu = new Menu();
    private DenneMenu denneMenu = new DenneMenu();

    private ObjednavkyDao objednavkaDao = ObjednavkaDaoFactory.INSTANCE.getObjednavkaDao();

    public Menu getMenu() {
        return menu;
    }

    private int pocetKliknutiNaPolozkuVMenu = 0;
    private int pocetKliknutiNaPolozkuVDennomMenu = 0;

    public MenuForm() {
        initComponents();
        nacitajMenuZTxt();
        PridajKliknutyObjektDoDennehoMenu();
        VymazKliknutyObjektZDennehoMenu();
        //  pridajZTxtDoDoMenuPriSpusteni();
        // chcel som dorobit aby pri otvoreni okna uz po pridani denneho menu nacitalo to co bolo pridane
        // do okienka denneho menu, aby sa nemuselo na novo pridavat.. zatial nefunguje

    }

    public void pridajZTxtDoDoMenuPriSpusteni() {

        Scanner sc = null;
        List<JednaPolozkaMenu> polozky = new ArrayList<>();
        try {
            sc = new Scanner(new File("denneMenu.txt"));
            while (sc.hasNextLine()) {
                if (!sc.nextLine().equals("")) {
                    String s = sc.nextLine();
                    JednaPolozkaMenu j = new JednaPolozkaMenu();
                    j.setNazov(s);
                    polozky.add(j);
                }
            }

            denneMenu.setZoznamDennehoMenu(polozky);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void zapisDoTxt() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("denneMenu.txt"));
            pw.write("");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(new File("denneMenu.txt"), true)) {

            for (int i = 0; i < denneMenu.getZoznamDennehoMenu().size(); i++) {
                writer.append(denneMenu.getZoznamDennehoMenu().get(i).getNazov() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

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
        JednaPolozkaMenu j = new JednaPolozkaMenu();
        j.setNazov(jedlo);

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
            celeMenuPole[i] = CeleMenu.get(i).getNazov();
        }

        ZoznamJedalList.setListData(celeMenuPole);

    }

    public boolean niejeVMenu(String jedlo) {
        List<JednaPolozkaMenu> dMenu = denneMenu.getZoznamDennehoMenu();

        for (JednaPolozkaMenu polozka : dMenu) {
            if (polozka.getNazov().equals(jedlo)) {
                return false;
            }
        }
        return true;

    }

    public void presunJedloDoDennehoMEnu(String jedlo) {
        boolean uzSaTamNachadza = niejeVMenu(jedlo);

        if (uzSaTamNachadza) {
            JednaPolozkaMenu noveJedlo = new JednaPolozkaMenu();
            noveJedlo.setNazov(jedlo);
            List<JednaPolozkaMenu> dMenu = denneMenu.getZoznamDennehoMenu();
            denneMenu.getZoznamDennehoMenu().add(noveJedlo);
            AktualizujDenneMenu();

        }
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
        refreshButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DenneMenuList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(DenneMenuList);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel1.setText("Denne menu:");

        ZoznamJedalList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(ZoznamJedalList);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setText("Zoznam jedal:");

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

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

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        closeButton.setText("CLOSE");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pridatJedloButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(vymazDenneMenuButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(closeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aktualizujButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pridatJedloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aktualizujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
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
        PridatNoveJedloDoMenuDialog p = new PridatNoveJedloDoMenuDialog(this, true);
        p.setVisible(true);
        
       //PridatNoveJedloDoMenu pridatNoveJedloDoMenu = new PridatNoveJedloDoMenu();
       // pridatNoveJedloDoMenu.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_pridatJedloButtonActionPerformed

    public void vypis() {
        JOptionPane.showMessageDialog(null, "uspesne");

    }

    private void aktualizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujButtonActionPerformed
        zapisDoTxt();
        this.setVisible(false);
        dispose();

    }//GEN-LAST:event_aktualizujButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        nacitajMenuZTxt();

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_closeButtonActionPerformed

    public void AktualizujDenneMenu() {
        List<JednaPolozkaMenu> DenneMenu = denneMenu.getZoznamDennehoMenu();
        String[] celeMenuPole = new String[DenneMenu.size()];
        for (int i = 0; i < DenneMenu.size(); i++) {
            celeMenuPole[i] = DenneMenu.get(i).getNazov();
        }

        DenneMenuList.setListData(celeMenuPole);

    }

    public void nacitajMenuZTxt() {
        Scanner sc = null;
        List<String> menuu = new ArrayList<>();
        try {
            sc = new Scanner(new File("zoznamJedal.txt"));
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] polozky = s.split(";");
                menuu.add(polozky[0]);

            }
            String[] menu = new String[menuu.size()];
            for (int i = 0; i < menu.length; i++) {
                menu[i] = menuu.get(i);
            }

            ZoznamJedalList.setListData(menu);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

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
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pridatJedloButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton vymazDenneMenuButton;
    // End of variables declaration//GEN-END:variables
}
