/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author rkhis
 */
public class PopUpdialog2View extends javax.swing.JDialog {

    /**
     * Creates new form popUpdialog2
     */
    public PopUpdialog2View(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        setBackground(new Color(0,0,0,0));
    }
    
    public void OK2MouseListener(MouseListener l) {
        this.button_ok2.addMouseListener(l);
    }

    public JButton getButton_ok() {
        return button_ok2;
    }

    public void setButton_ok(JButton button_ok) {
        this.button_ok2 = button_ok;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_ok2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_ok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/PopUp/Ok.png"))); // NOI18N
        button_ok2.setBorderPainted(false);
        button_ok2.setContentAreaFilled(false);
        button_ok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_ok2.setFocusable(false);
        button_ok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ok2ActionPerformed(evt);
            }
        });
        getContentPane().add(button_ok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 50, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Level/popup3.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_ok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ok2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_ok2ActionPerformed

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
            java.util.logging.Logger.getLogger(PopUpdialog2View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUpdialog2View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUpdialog2View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUpdialog2View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopUpdialog2View dialog = new PopUpdialog2View(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ok2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}