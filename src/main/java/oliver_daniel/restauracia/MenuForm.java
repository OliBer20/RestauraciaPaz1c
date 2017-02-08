package oliver_daniel.restauracia;

import dao.DenneMenuDao;
import dao.PolozkaDao;
import entity.Kategoria;
import entity.Polozka;
import factory.ObjectFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MenuForm extends javax.swing.JFrame {

    private DenneMenuDao jedla_v_dennom_menu = ObjectFactory.INSTANCE.getDenneMenu();
    private PolozkaDao jedla = ObjectFactory.INSTANCE.getPolozkaDao();

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

    void aktualizujZoznamJedal() {
        List<Polozka> vsetkyPolozky = jedla.dajPolozky();
        List<String> nazvy = new ArrayList<>();
        for (Polozka polozka : vsetkyPolozky) {
            if (polozka.getKategoria().getNazov().equals("Jedlo")) {
                nazvy.add(polozka.getNazov());
            }
        }
        String nazvyPole[] = new String[nazvy.size()];
        for (int i = 0; i < nazvy.size(); i++) {
            nazvyPole[i] = nazvy.get(i);
        }
        
        ZoznamJedalList.setListData(nazvyPole);
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
        aktualizujButton = new javax.swing.JButton();
        vymazOzn = new javax.swing.JButton();
        vyberJedlo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

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
        jLabel1.setText("Denne menu:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 20, 113, 25);

        ZoznamJedalList.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(ZoznamJedalList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(597, 52, 386, 315);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vyberJedlo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aktualizujButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(vymazOzn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(vymazDenneMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aktualizujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vyberJedlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vymazOzn)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(414, 0, 171, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vymazDenneMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazDenneMenuButtonActionPerformed
        jedla_v_dennom_menu.vymazVsetko();
        AktualizujDenneMenu();
    }//GEN-LAST:event_vymazDenneMenuButtonActionPerformed

    private void aktualizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujButtonActionPerformed
        zoznamObjednavok.aktualizovatDenneMenu();
        this.dispose();
    }//GEN-LAST:event_aktualizujButtonActionPerformed

    private void vymazOznActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazOznActionPerformed
        String nazov = vyberJedlo.getSelectedItem().toString();
        Polozka polozka = jedla.dajPodlaNazvu(nazov);
        jedla.vymazPolozku(polozka);
        jedla_v_dennom_menu.odober(polozka);
        AktualizujMenu();
        AktualizujDenneMenu();
        AktualizujComboBox();
    }//GEN-LAST:event_vymazOznActionPerformed

    private void vyberJedloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vyberJedloActionPerformed


    }//GEN-LAST:event_vyberJedloActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DenneMenuList;
    private javax.swing.JList<String> ZoznamJedalList;
    private javax.swing.JButton aktualizujButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> vyberJedlo;
    private javax.swing.JButton vymazDenneMenuButton;
    private javax.swing.JButton vymazOzn;
    // End of variables declaration//GEN-END:variables

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
                        Object Polozka = DenneMenuList.getModel().getElementAt(index);
                        odstranZDennehoMenu(Polozka.toString());
                    }
                    pocetKliknutiNaPolozkuVDennomMenu = 0;
                }
            }

        });

    }

     private void odstranZDennehoMenu(String jedlo) {
        jedla_v_dennom_menu.odober(jedla.dajPodlaNazvu(jedlo));
        AktualizujDenneMenu();

    }
     
     public void presunJedloDoDennehoMEnu(String jedlo) {
        List<Polozka> jedla = this.jedla.dajPolozky();
        Long id = null;
        for (Polozka jedlo1 : jedla) {
            if (jedlo1.getNazov().equals(jedlo)) {
                id = jedlo1.getId();
            }
        }
        jedla_v_dennom_menu.pridaj(id);
        AktualizujDenneMenu();

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

     public void AktualizujComboBox() {
        vyberJedlo.removeAllItems();
        vyberJedlo.addItem("Vyber jedlo:");
        List<Polozka> menu = this.jedla.dajPolozky();
        Kategoria k = new Kategoria();
        k.setNazov("Jedlo");
        for (Polozka jedlo : menu) {
             if(jedlo.getKategoria().getNazov().equals(k.getNazov())){
                        vyberJedlo.addItem(jedlo.getNazov());

            }
        }

    }

     public void AktualizujDenneMenu() {
        List<Polozka> DenneMenu = jedla_v_dennom_menu.ziskajDenneMenu();
        String[] celeMenuPole = new String[DenneMenu.size()];
        for (int i = 0; i < DenneMenu.size(); i++) {
            celeMenuPole[i] = DenneMenu.get(i).getNazov();
        }
        DenneMenuList.setListData(celeMenuPole);

    }

    public void AktualizujMenu() {
        List<Polozka> jedla = new ArrayList<>();
        for (Polozka polozka : this.jedla.dajPolozky()) {
            if(polozka.getKategoria().getNazov().equals("Jedlo")){
                jedla.add(polozka);
            }
        }
         String [] poleJedal = new String[jedla.size()];
        for (int i = 0; i < jedla.size(); i++) {
            poleJedal[i] = jedla.get(i).getNazov();
        }
       //String [] poleJedal = jedla.toArray(new String[jedla.size()]);
        ZoznamJedalList.setListData(poleJedal);

        System.out.println(Integer.toString(jedla.size()));

    }
}
