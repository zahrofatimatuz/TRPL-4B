/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author rkhis
 */
public class MenangKuisView extends javax.swing.JFrame {

    /**
     * Creates new form MenangKuisView
     */
    public MenangKuisView() {
        initComponents();
        setLocationRelativeTo(this);
    }
    
    public void OK(MouseListener l) {
        this.Button_ok.addMouseListener(l);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_nama = new javax.swing.JLabel();
        Label_jawabanSalah = new javax.swing.JLabel();
        Label_jawabanBenar = new javax.swing.JLabel();
        Label_Skor = new javax.swing.JLabel();
        Label_SkorTertinggi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Button_ok = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_nama.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        Label_nama.setForeground(new java.awt.Color(255, 255, 255));
        Label_nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_nama.setText("sd");
        getContentPane().add(Label_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 120, 40));
        getContentPane().add(Label_jawabanSalah, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 60, 30));
        getContentPane().add(Label_jawabanBenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 60, 30));
        getContentPane().add(Label_Skor, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 60, 30));
        getContentPane().add(Label_SkorTertinggi, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 380, 60, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Jawaban Salah  :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Jawaban Benar : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Skor                 : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Skor Tertinggi  : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, -1, -1));

        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 354, 240, 290));

        Button_ok.setText("OK");
        getContentPane().add(Button_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 680, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Home/bg-Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenangKuisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenangKuisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenangKuisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenangKuisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenangKuisView().setVisible(true);
            }
        });
    }

    public JLabel getLabel_nama() {
        return Label_nama;
    }

    public void setLabel_nama(JLabel Label_nama) {
        this.Label_nama = Label_nama;
    }
    
    
    public JLabel getLabel_Skor() {
        return Label_Skor;
    }

    public void setLabel_Skor(JLabel Label_Skor) {
        this.Label_Skor = Label_Skor;
    }

    public JLabel getLabel_SkorTertinggi() {
        return Label_SkorTertinggi;
    }

    public void setLabel_SkorTertinggi(JLabel Label_SkorTertinggi) {
        this.Label_SkorTertinggi = Label_SkorTertinggi;
    }

    public JLabel getLabel_jawabanBenar() {
        return Label_jawabanBenar;
    }

    public void setLabel_jawabanBenar(JLabel Label_jawabanBenar) {
        this.Label_jawabanBenar = Label_jawabanBenar;
    }

    public JLabel getLabel_jawabanSalah() {
        return Label_jawabanSalah;
    }

    public void setLabel_jawabanSalah(JLabel Label_jawabanSalah) {
        this.Label_jawabanSalah = Label_jawabanSalah;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_ok;
    private javax.swing.JLabel Label_Skor;
    private javax.swing.JLabel Label_SkorTertinggi;
    private javax.swing.JLabel Label_jawabanBenar;
    private javax.swing.JLabel Label_jawabanSalah;
    private javax.swing.JLabel Label_nama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}