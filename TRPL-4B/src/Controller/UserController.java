package Controller;

import View.HomeView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.UIManager;

public class UserController {

    HomeView home;

    public UserController(HomeView home) {
        this.home = home;
        home.setVisible(true);
        home.PlayListener(new PlayListener());
        home.PlayMouseListener(new PlayMouseListnner());
        home.BantuanListener(new BantuanListener());
        home.BantuanMouseListener(new BantuanMouseListener());
        home.KeluarListener(new KeluarListener());
        home.KeluarMouseListener(new KeluarMouseListener());
        home.TentangListener(new TentangListener());
        home.TentangMouseListener(new TentangMouseListener());
    }

    private class TentangListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class TentangMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            home.getButton_Tentang().setSize(172, 60);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            home.getButton_Tentang().setSize(171, 59);
        }
    }

    private class KeluarMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            home.getButton_keluar().setSize(155, 60);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            home.getButton_keluar().setSize(153, 59);
        }
    }

    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class BantuanMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            home.getButton_Bantuan().setSize(170, 60);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            home.getButton_Bantuan().setSize(159, 59);
        }
    }

    private class BantuanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class PlayMouseListnner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            home.getButton_play().setSize(150, 60);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            home.getButton_play().setSize(147, 59);
        }
    }

    private class PlayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
