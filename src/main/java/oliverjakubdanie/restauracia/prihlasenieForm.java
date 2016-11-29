package oliverjakubdanie.restauracia;

import java.awt.Button;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import oliverjakubdanie.restauracia.zoznamObjednavokForm;

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

        ImageIcon imgBackground = new ImageIcon("C:\\Users\\Oliver\\Documents\\NetBeansProjects\\Restrauracia\\src\\main\\java\\oliverjakubdanie\\restauracia\\obrazokRest.jpg");
        pozadie.setIcon(imgBackground);
        nastavFotku("C:\\Users\\Oliver\\Documents\\NetBeansProjects\\Restrauracia\\src\\main\\java\\oliverjakubdanie\\restauracia\\jenna.jpg", bossButton);
        nastavFotku("C:\\Users\\Oliver\\Documents\\NetBeansProjects\\Restrauracia\\src\\main\\java\\oliverjakubdanie\\restauracia\\daniellll_1.jpg", ostatniButton);

    }

    public void nastavFotku(String cesta, JButton tlacidlo) {
        ImageIcon imageIcon = new ImageIcon(cesta);
        tlacidlo.setIcon(imageIcon);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bossButton = new javax.swing.JButton();
        ostatniButton = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        prihlasitsaButton = new javax.swing.JButton();
        bossText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hesloText = new javax.swing.JLabel();
        pozadie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);

        bossButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bossButtonActionPerformed(evt);
            }
        });

        ostatniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ostatniButtonActionPerformed(evt);
            }
        });

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

        prihlasitsaButton.setText("Prihlásiť sa");
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

        bossText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bossText.setForeground(new java.awt.Color(255, 255, 255));
        bossText.setText("BOSS");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Others");

        hesloText.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        hesloText.setForeground(new java.awt.Color(255, 255, 255));
        hesloText.setText("password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(ostatniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(hesloText))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(prihlasitsaButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(bossButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(bossText))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pozadie, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(ostatniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(hesloText)
                .addGap(106, 106, 106)
                .addComponent(prihlasitsaButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(bossButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(bossText))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pozadie, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ostatniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ostatniButtonActionPerformed

        hesloText.setText("Others password:");
        boss = false;
        others = true;

    }//GEN-LAST:event_ostatniButtonActionPerformed

    private void bossButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bossButtonActionPerformed

        hesloText.setText("Boss password:");
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton ostatniButton;
    private javax.swing.JLabel pozadie;
    private javax.swing.JButton prihlasitsaButton;
    // End of variables declaration//GEN-END:variables
}
