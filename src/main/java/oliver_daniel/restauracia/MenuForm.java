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
import oliver_daniel.restauracia.Jedlo;

public class MenuForm extends javax.swing.JFrame {

    private ObjednavkyDao objednavky = ObjectFactory.INSTANCE.getObjednavkaDao();
    private DenneMenuDao jedla_v_dennom_menu = ObjectFactory.INSTANCE.getDenneMenu();
    private JedloDao jedla = ObjectFactory.INSTANCE.getJedla();

    zoznamObjednavokForm zoznamObjednavok;

    private int pocetKliknutiNaPolozkuVMenu = 0;
    private int pocetKliknutiNaPolozkuVDennomMenu = 0;

    public MenuForm(zoznamObjednavokForm z) {
        initComponents();
        PridajKliknutyObjektDoDennehoMenu();
        VymazKliknutyObjektZDennehoMenu();
        AktualizujComboBox();
        AktualizujDenneMenu();
        AktualizujMenu();
        zoznamObjednavok = z;

    }

    private MenuForm() {
    }

    //Zdroj inspiracie:
    //http://stackoverflow.com/questions/4344682/double-click-event-on-jlist-element 
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
//Zdroj inspiracie:
        //http://stackoverflow.com/questions/4344682/double-click-event-on-jlist-element 
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

    public Long vratIDJedla(String jedlo) {
        Long id = null;
        List<Jedlo> j = jedla.dajJedla();
        for (Jedlo jedlo1 : j) {
            if (jedlo1.getNazov().equals(jedlo)) {
                id = jedlo1.getId();
                return id;
            }

        }
        return null;

    }

    private void odstranZDennehoMenu(String jedlo) {
        jedla_v_dennom_menu.odober(vratIDJedla(jedlo));
        AktualizujDenneMenu();

    }

    public void presunJedloDoDennehoMEnu(String jedlo) {
        List<Jedlo> jedla = this.jedla.dajJedla();
        Long id = null;
        for (Jedlo jedlo1 : jedla) {
            if (jedlo1.getNazov().equals(jedlo)) {
                id = jedlo1.getId();
            }
        }
        jedla_v_dennom_menu.pridaj(id);
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
        vymazOzn = new javax.swing.JButton();
        vyberJedlo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nastavenie jedál a denného menu");
        setBackground(new java.awt.Color(255, 51, 51));
        setBounds(new java.awt.Rectangle(10, 10, 10, 10));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1000, 415));
        setResizable(false);
        getContentPane().setLayout(null);

        DenneMenuList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(DenneMenuList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 52, 390, 315);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Denne menu:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 20, 113, 25);

        ZoznamJedalList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(ZoznamJedalList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(597, 52, 386, 315);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Zoznam jedal:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(740, 20, 119, 25);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

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

        vymazOzn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vymazOzn.setText("Vymaž");
        vymazOzn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazOznActionPerformed(evt);
            }
        });

        vyberJedlo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vyberJedloActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vymazat jedlo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pridatJedloButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vyberJedlo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aktualizujButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(vymazOzn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(pridatJedloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aktualizujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vyberJedlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vymazOzn)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(414, 0, 171, 380);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alu2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1000, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vymazDenneMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazDenneMenuButtonActionPerformed
        jedla_v_dennom_menu.vymazVsetko();
        AktualizujDenneMenu();

    }//GEN-LAST:event_vymazDenneMenuButtonActionPerformed

    private void pridatJedloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatJedloButtonActionPerformed
        PridatNoveJedloDoMenuDialog p = new PridatNoveJedloDoMenuDialog(this, true, this);
        p.setVisible(true);

    }//GEN-LAST:event_pridatJedloButtonActionPerformed


    private void aktualizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujButtonActionPerformed
        zoznamObjednavok.aktualizovatDenneMenu();
        this.dispose();
    }//GEN-LAST:event_aktualizujButtonActionPerformed

    private void vymazOznActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazOznActionPerformed
        Jedlo j = new Jedlo();
        String jedlo = vyberJedlo.getSelectedItem().toString();
        j.setNazov(jedlo);
        jedla.vymazJedlo(j);

        jedla_v_dennom_menu.odober(vratIDJedla(jedlo));
        AktualizujComboBox();
        AktualizujDenneMenu();
        AktualizujMenu();


    }//GEN-LAST:event_vymazOznActionPerformed

    private void vyberJedloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyberJedloActionPerformed


    }//GEN-LAST:event_vyberJedloActionPerformed

    public void AktualizujComboBox() {
        vyberJedlo.removeAllItems();
        vyberJedlo.addItem("Vyber jedlo:");
        List<Jedlo> menu = this.jedla.dajJedla();
        for (Jedlo jedlo : menu) {
            vyberJedlo.addItem(jedlo.getNazov());
        }

    }

    public void AktualizujDenneMenu() {
        List<Long> DenneMenu = jedla_v_dennom_menu.ziskajDenneMenu();
        String[] celeMenuPole = new String[DenneMenu.size()];
        for (int i = 0; i < DenneMenu.size(); i++) {
            celeMenuPole[i] = jedla.vratPodlaId(DenneMenu.get(i)).getNazov();
        }

        DenneMenuList.setListData(celeMenuPole);

    }

    public void AktualizujMenu() {
        List<Jedlo> menu = this.jedla.dajJedla();
        String[] celeMenuPole = new String[menu.size()];
        for (int i = 0; i < menu.size(); i++) {
            celeMenuPole[i] = menu.get(i).getNazov();
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pridatJedloButton;
    private javax.swing.JComboBox<String> vyberJedlo;
    private javax.swing.JButton vymazDenneMenuButton;
    private javax.swing.JButton vymazOzn;
    // End of variables declaration//GEN-END:variables
}
