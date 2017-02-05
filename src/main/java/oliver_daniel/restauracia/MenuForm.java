package oliver_daniel.restauracia;

import dao.PolozkaDao;
import entity.Polozka;
import factory.ObjectFactory;
import java.util.ArrayList;
import java.util.List;

public class MenuForm extends javax.swing.JFrame {

    private PolozkaDao polozkaDao;

    public MenuForm() {
        initComponents();
        polozkaDao = ObjectFactory.INSTANCE.getPolozkaDao();
        aktualizujZoznamJedal();
    }

    void aktualizujZoznamJedal() {
        List<Polozka> vsetkyPolozky = polozkaDao.dajPolozky();
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

    }//GEN-LAST:event_vymazDenneMenuButtonActionPerformed

    private void pridatJedloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatJedloButtonActionPerformed

    }//GEN-LAST:event_pridatJedloButtonActionPerformed

    private void aktualizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujButtonActionPerformed

    }//GEN-LAST:event_aktualizujButtonActionPerformed

    private void vymazOznActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazOznActionPerformed

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
