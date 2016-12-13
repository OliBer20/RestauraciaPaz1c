package oliver_daniel.restauracia;

import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import oliver_daniel.restauracia.zoznamObjednavokForm;

public class prihlasenieForm extends javax.swing.JFrame {

    private String bossHeslo = "boss123";
    private String othersHeslo = "others123";
    private Boolean boss = false;
    private Boolean others = false;

    public Boolean getBoss() {
        return boss;
    }

    public Boolean getOthers() {
        return others;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public void setOthers(Boolean others) {
        this.others = others;
    }

    public prihlasenieForm() {

        initComponents();

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        prihlasitsaButton = new javax.swing.JButton();
        bossText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hesloText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bossButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ostatniButton = new javax.swing.JButton();
        pozadie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(590, 500));
        setMinimumSize(new java.awt.Dimension(590, 500));
        getContentPane().setLayout(null);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(200, 290, 173, 39);

        prihlasitsaButton.setBackground(new java.awt.Color(0, 0, 0));
        prihlasitsaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vstupit.png"))); // NOI18N
        prihlasitsaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasitsaButtonActionPerformed(evt);
            }
        });
        prihlasitsaButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prihlasitsaButtonKeyPressed(evt);
            }
        });
        getContentPane().add(prihlasitsaButton);
        prihlasitsaButton.setBounds(230, 350, 119, 49);

        bossText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bossText.setForeground(new java.awt.Color(255, 255, 255));
        bossText.setText("BOSS");
        getContentPane().add(bossText);
        bossText.setBounds(130, 50, 48, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Others");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 50, 61, 22);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(676, 212, 0, 0);

        hesloText.setBackground(new java.awt.Color(0, 0, 0));
        hesloText.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        hesloText.setForeground(new java.awt.Color(255, 51, 51));
        hesloText.setText("password:");
        getContentPane().add(hesloText);
        hesloText.setBounds(230, 260, 110, 24);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        bossButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boss.png"))); // NOI18N
        bossButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bossButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bossButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bossButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(70, 90, 160, 140);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        ostatniButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/people.png"))); // NOI18N
        ostatniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ostatniButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ostatniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ostatniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(330, 90, 160, 140);

        pozadie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaur.jpg"))); // NOI18N
        getContentPane().add(pozadie);
        pozadie.setBounds(0, 0, 580, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ostatniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ostatniButtonActionPerformed
        jPanel1.setBackground(new Color(102,102,102));
        jPanel2.setBackground(Color.RED);
        boss = false;
        others = true;

    }//GEN-LAST:event_ostatniButtonActionPerformed

    private void bossButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bossButtonActionPerformed
        jPanel1.setBackground(Color.RED);
        jPanel2.setBackground(new Color(102,102,102));
        boss = true;
        others = false;

    }//GEN-LAST:event_bossButtonActionPerformed

    public void prihlasenyBoss() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("prihlasenyPrava.txt"));
            pw.write("boss");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public void prihlasenyOther() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("prihlasenyPrava.txt"));
            pw.write("others");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }
    private void prihlasitsaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prihlasitsaButtonActionPerformed

        String s = jPasswordField1.getText();
        jPasswordField1.setText(null);
        if (boss) {
            if (bossHeslo.equals(s)) {
                prihlasenyBoss();
                zoznamObjednavokForm z = new zoznamObjednavokForm();
                z.setVisible(true);
                this.setVisible(false);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Nesprávne heslo!!");
            }
        } else if (others) {
            if (othersHeslo.equals(s)) {
                prihlasenyOther();
                zoznamObjednavokForm z = new zoznamObjednavokForm();
                z.setVisible(true);
                this.setVisible(false);
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nesprávne heslo!!");
        }


    }//GEN-LAST:event_prihlasitsaButtonActionPerformed

    private void prihlasitsaButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prihlasitsaButtonKeyPressed

    }//GEN-LAST:event_prihlasitsaButtonKeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        //prihlasenie cez enter v passworde
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {

            String s = jPasswordField1.getText();
            jPasswordField1.setText(null);
            if (boss) {
                if (bossHeslo.equals(s)) {
                    prihlasenyBoss();
                    zoznamObjednavokForm z = new zoznamObjednavokForm();
                    z.setVisible(true);
                    this.setVisible(false);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Nesprávne heslo!!");
                }
            } else if (others) {
                if (othersHeslo.equals(s)) {
                    prihlasenyOther();
                    zoznamObjednavokForm z = new zoznamObjednavokForm();
                    z.setVisible(true);
                    this.setVisible(false);
                    dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nesprávne heslo!!");
            }

        }


    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(prihlasenieForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prihlasenieForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prihlasenieForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prihlasenieForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prihlasenieForm().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bossButton;
    private javax.swing.JLabel bossText;
    private javax.swing.JLabel hesloText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton ostatniButton;
    private javax.swing.JLabel pozadie;
    private javax.swing.JButton prihlasitsaButton;
    // End of variables declaration//GEN-END:variables
}
