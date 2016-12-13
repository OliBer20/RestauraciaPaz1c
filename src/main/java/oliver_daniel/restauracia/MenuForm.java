package oliver_daniel.restauracia;

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

    private VsetkyJedlaDao menu = ObjectFactory.INSTANCE.getMenu();
    private ObjednavkyDao objednavkaDao = ObjectFactory.INSTANCE.getObjednavkaDao();
    private DenneMenuDao denneMenu = ObjectFactory.INSTANCE.getDenneMenu();

    private int pocetKliknutiNaPolozkuVMenu = 0;
    private int pocetKliknutiNaPolozkuVDennomMenu = 0;

    public MenuForm() {
        initComponents();
        nacitajMenuZTxt();
        PridajKliknutyObjektDoDennehoMenu();
        VymazKliknutyObjektZDennehoMenu();
        AktualizujDenneMenu();
        AktualizujMenu();

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
        denneMenu.odober(jedlo);
        AktualizujDenneMenu();

    }

    public void presunJedloDoDennehoMEnu(String jedlo) {
        denneMenu.pridaj(jedlo);
        AktualizujDenneMenu();

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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nastavenie jedál a denného menu");
        setBackground(new java.awt.Color(255, 51, 51));
        setBounds(new java.awt.Rectangle(10, 10, 10, 10));
        setIconImages(null);
        setResizable(false);

        DenneMenuList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(DenneMenuList);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel1.setText("Denne menu:");

        ZoznamJedalList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(ZoznamJedalList);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setText("Zoznam jedal:");

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        vymazDenneMenuButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vymazDenneMenuButton.setForeground(new java.awt.Color(255, 0, 0));
        vymazDenneMenuButton.setText("Vymaz d. menu");
        vymazDenneMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazDenneMenuButtonActionPerformed(evt);
            }
        });

        pridatJedloButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pridatJedloButton.setForeground(new java.awt.Color(0, 153, 0));
        pridatJedloButton.setText("Pridat Jedlo");
        pridatJedloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatJedloButtonActionPerformed(evt);
            }
        });

        aktualizujButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        aktualizujButton.setText("Aktualizuj menu");
        aktualizujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pridatJedloButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aktualizujButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(pridatJedloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aktualizujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
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
        denneMenu.vymazVsetko();
        AktualizujDenneMenu();

    }//GEN-LAST:event_vymazDenneMenuButtonActionPerformed

    private void pridatJedloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatJedloButtonActionPerformed
        PridatNoveJedloDoMenuDialog p = new PridatNoveJedloDoMenuDialog(this, true);
        p.setVisible(true);

    }//GEN-LAST:event_pridatJedloButtonActionPerformed

    public void vypis() {
        JOptionPane.showMessageDialog(null, "uspesne");

    }

    private void aktualizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_aktualizujButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          AktualizujDenneMenu();
        AktualizujMenu();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void AktualizujDenneMenu() {
        List<String> DenneMenu = denneMenu.ziskajDenneMenu();
        String[] celeMenuPole = new String[DenneMenu.size()];
        for (int i = 0; i < DenneMenu.size(); i++) {
            celeMenuPole[i] = DenneMenu.get(i);
        }

        DenneMenuList.setListData(celeMenuPole);

    }

    public void AktualizujMenu() {
        List<String> menu = this.menu.ziskajVsetkyJedla();
        String[] celeMenuPole = new String[menu.size()];
        for (int i = 0; i < menu.size(); i++) {
            celeMenuPole[i] = menu.get(i);
        }

        ZoznamJedalList.setListData(celeMenuPole);

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pridatJedloButton;
    private javax.swing.JButton vymazDenneMenuButton;
    // End of variables declaration//GEN-END:variables
}
