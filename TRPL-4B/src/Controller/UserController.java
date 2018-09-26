package Controller;

import Model.Koneksi;
import Model.UserModel;
import View.AboutView;
import View.HelpView;
import View.HomeView;
import View.PilihanLevelView;
import View.PopUpGantiPasswordView;
import View.PopUpLoginView;
import View.PopUpRegisterView;
import View.awalanView;
import java.awt.Button;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class UserController {

    HomeView home = new HomeView();
    awalanView awal = new awalanView();
    AboutView about = new AboutView();
    HelpView help = new HelpView();
    PilihanLevelView pilihLevel = new PilihanLevelView();
    PopUpRegisterView dialogRegister;
    PopUpLoginView dialogLogin;
    PopUpGantiPasswordView dialogGantiPass;
    UserModel userM;

    public UserController(awalanView awal, UserModel userM) {
        this.awal = awal;
        this.userM = userM;
        awal.setVisible(true);
        awal.MasukMouseListener(new MasukAwalMouseListnner());
        awal.RegisteredMouseListener(new RegisteredMouseListener());

        dialogRegister = new PopUpRegisterView(awal, true);
        dialogRegister.SimpanMouseListener(new SimpanMouseListener());
        dialogRegister.BatalMouseListener(new BatalMouseListener());

        dialogLogin = new PopUpLoginView(awal, true);
        dialogLogin.MasukMouseListener(new MasukLoginMouseListener());
        dialogLogin.BatalMouseListener(new BatalLoginMouseListener());
    }

    public UserController(HomeView home, UserModel userM) {
        this.userM = userM;
        this.home = home;
        home.setVisible(true);
        home.PlayMouseListener(new PlayMouseListnner());
        home.BantuanMouseListener(new BantuanMouseListener());
        home.KeluarMouseListener(new KeluarMouseListener());
        home.TentangMouseListener(new TentangMouseListener());
        home.GantiPasswordMouseListener(new GantiPassMouseListener());
        home.SoundMouseListener(new SoundMouseListener());
        home.SoundxMouseListener(new SoundxMouseListener());

        dialogGantiPass = new PopUpGantiPasswordView(awal, true);
        dialogGantiPass.BatalMouseListener(new BatalGantiPassMouseListener());
        dialogGantiPass.SimpanMouseListener(new SimpanGantiPassMouseListener());
    }

    public UserController(AboutView about, UserModel userM) {
        this.about = about;
        this.userM = userM;
        about.setVisible(true);
        about.KembaliMouseListener(new KembaliAboutMouseListener());
    }

    public UserController(HelpView help, UserModel userM) {
        this.help = help;
        this.userM = userM;
        help.setVisible(true);
        help.KembaliMouseListener(new KembaliHelpMouseListener());
    }

    public UserController(PilihanLevelView pilihLevel, UserModel userM) {
        this.pilihLevel = pilihLevel;
        this.userM = userM;
        pilihLevel.setVisible(true);
        pilihLevel.Level1MouseListener(new Level1MouseListener());
        pilihLevel.Banjir1MouseListener(new Banjir1MouseListener());
        pilihLevel.Gempa1MouseListener(new Gempa1MouseListener());
        pilihLevel.Kebakaran1MouseListener(new Kebakaran1MouseListener());
        pilihLevel.Level2MouseListener(new Level2MouseListener());
        pilihLevel.Banjir2MouseListener(new Banjir2MouseListener());
        pilihLevel.Gempa2MouseListener(new Gempa2MouseListener());
        pilihLevel.Kebakaran2MouseListener(new Kebakaran2MouseListener());
        pilihLevel.getButton_Banjir1().setVisible(false);
        pilihLevel.getButton_gempa1().setVisible(false);
        pilihLevel.getButton_kebakaran1().setVisible(false);
        pilihLevel.getButton_Banjir2().setVisible(false);
        pilihLevel.getButton_gempa2().setVisible(false);
        pilihLevel.getButton_kebakaran2().setVisible(false);
    }

    private void setIcon(JButton button, String resource) {
        button.setIcon(new ImageIcon(getClass().getResource(resource)));

    }

    private class Gempa2MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Kebakaran2MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Banjir2MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
       }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
       }
    }

    private class Level2MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        pilihLevel.getButton_Banjir1().setVisible(false);
        pilihLevel.getButton_gempa1().setVisible(false);
        pilihLevel.getButton_kebakaran1().setVisible(false);
        pilihLevel.getButton_Banjir2().setVisible(true);
        pilihLevel.getButton_gempa2().setVisible(true);
        pilihLevel.getButton_kebakaran2().setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
         }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Kebakaran1MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Gempa1MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Banjir1MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Level1MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            pilihLevel.getButton_Banjir1().setVisible(true);
            pilihLevel.getButton_gempa1().setVisible(true);
            pilihLevel.getButton_kebakaran1().setVisible(true);
            pilihLevel.getButton_Banjir2().setVisible(false);
            pilihLevel.getButton_gempa2().setVisible(false);
            pilihLevel.getButton_kebakaran2().setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class SimpanGantiPassMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class BatalGantiPassMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogGantiPass.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class KembaliHelpMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(home, userM);
            help.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class KembaliAboutMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(home, userM);
            about.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class SoundxMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class GantiPassMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogGantiPass.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class SoundMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class BatalLoginMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogLogin.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class MasukLoginMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(home, userM);
            awal.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class MasukAwalMouseListnner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogLogin.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class BatalMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogRegister.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class SimpanMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class RegisteredMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogRegister.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class TentangMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(about, userM);
            home.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class KeluarMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(awal, userM);
            home.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class BantuanMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(help, userM);
            home.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class PlayMouseListnner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(pilihLevel, userM);
            home.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
