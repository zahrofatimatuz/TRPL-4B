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
import View.PopupKeluarView;
import View.awalanView;
import View.banjir1View;
import View.gempa1View;
import View.kebakaran1View;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class UserController {

    private HomeView home = new HomeView();
    private awalanView awal = new awalanView();
    private AboutView about = new AboutView();
    private HelpView help = new HelpView();
    private banjir1View banjir1 = new banjir1View();
    private kebakaran1View kebakaran1 = new kebakaran1View();
    private gempa1View gempa1 = new gempa1View();
    private PilihanLevelView pilihLevel = new PilihanLevelView();
    private PopupKeluarView dialogKeluar;
    private PopUpRegisterView dialogRegister;
    private PopUpLoginView dialogLogin;
    private PopUpGantiPasswordView dialogGantiPass;
    private UserModel userM;
    public static String username = "";
    private boolean sound = true;

    public UserController(awalanView awal, UserModel userM) throws SQLException {
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

    public UserController(HomeView home, UserModel userM) throws SQLException {

        this.userM = userM;
        this.home = home;
        home.setVisible(true);
        System.out.println(username);
        home.PlayMouseListener(new PlayMouseListnner());
        home.BantuanMouseListener(new BantuanMouseListener());
        home.KeluarMouseListener(new KeluarMouseListener());
        home.TentangMouseListener(new TentangMouseListener());
        home.GantiPasswordMouseListener(new GantiPassMouseListener());
        home.SoundMouseListener(new SoundMouseListener());

        dialogGantiPass = new PopUpGantiPasswordView(awal, true);
        dialogGantiPass.BatalMouseListener(new BatalGantiPassMouseListener());
        dialogGantiPass.SimpanMouseListener(new SimpanGantiPassMouseListener());

        dialogKeluar = new PopupKeluarView(awal, true);
        dialogKeluar.YaMouseListener(new YaMouseListener());
        dialogKeluar.TidakMouseListener(new TidakMouseListener());

    }

    public UserController(banjir1View banjir1, UserModel userM) throws SQLException {

        banjir1.setVisible(true);
    }

    public UserController(kebakaran1View kebakaran1, UserModel userM) throws SQLException {

        kebakaran1.setVisible(true);
    }

    public UserController(gempa1View gempa1, UserModel userM) throws SQLException {

        gempa1.setVisible(true);
    }

    public UserController(AboutView about, UserModel userM) throws SQLException {

        this.about = about;
        this.userM = userM;
        about.setVisible(true);
        about.KembaliMouseListener(new KembaliAboutMouseListener());
    }

    public UserController(HelpView help, UserModel userM) throws SQLException {

        this.help = help;
        this.userM = userM;
        help.setVisible(true);
        help.KembaliMouseListener(new KembaliHelpMouseListener());
    }

    public UserController(PilihanLevelView pilihLevel, UserModel userM) throws SQLException {

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

    public void resetInputan() {
        dialogRegister.get_Username().setText("");
        dialogRegister.get_Password().setText("");
    }

    private class TidakMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogKeluar.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogKeluar.getButton_tidak(), "/View/ExitPopUp/btn-tidak-entered.png");

        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogKeluar.getButton_tidak(), "/View/ExitPopUp/btn-tidak.png");
        }
    }

    private class YaMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(awal, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            home.dispose();
            dialogKeluar.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogKeluar.getButton_ya(), "/View/ExitPopUp/btn-ya-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogKeluar.getButton_ya(), "/View/ExitPopUp/btn-ya.png");
        }
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
            try {
                new UserController(kebakaran1, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            pilihLevel.dispose();
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
            try {
                new UserController(gempa1, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            pilihLevel.dispose();
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
            try {
                new UserController(banjir1, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            pilihLevel.dispose();
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
            String passLama = dialogGantiPass.getPasswordField_PasswordLama().getText();
            String passbaru = dialogGantiPass.getPasswordField_PasswordBaru().getText();
            String passKonfirmasi = dialogGantiPass.getPasswordField_KonfirmasiBaru().getText();

            userM.cekPasswordLama(username, passLama);
            if (passLama.equals("") || passbaru.equals("") || passKonfirmasi.equals("")) {
                JOptionPane.showMessageDialog(home, "Data Tidak Boleh Kosong!!");
            } else if (userM.getResult() <= 0) {
                JOptionPane.showMessageDialog(home, "Password Anda Salah!!");
            } else {
                if (passbaru.equalsIgnoreCase(passKonfirmasi)) {
                    userM.updatePassword(username, passbaru);
                    JOptionPane.showMessageDialog(home, "Password berhasil diubah");
                    dialogGantiPass.dispose();
                } else {
                    JOptionPane.showMessageDialog(home, "Password baru tidak cocok!!");
                }
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogGantiPass.getButton_Simpan(), "/View/RegisterandLogin/btn-simpan-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogGantiPass.getButton_Simpan(), "/View/RegisterandLogin/btn-Simpan.png");
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
            setIcon(dialogGantiPass.getButton_Batal(), "/View/RegisterandLogin/btn-batal-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogGantiPass.getButton_Batal(), "/View/RegisterandLogin/btn-Batal.png");
        }
    }

    private class KembaliHelpMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(home, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            setIcon(help.getButton_Kembali(), "/View/Help/btn-back-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(help.getButton_Kembali(), "/View/Help/btn-back.png");
        }
    }

    private class KembaliAboutMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(home, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            setIcon(about.getButton_kembali(), "/View/About/btn-back-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(about.getButton_kembali(), "/View/About/btn-back.png");
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
            setIcon(home.getButton_gantiPassword(), "/View/Home/btn-gantipassword-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(home.getButton_gantiPassword(), "/View/Home/btn-gantipassword.png");
        }
    }

    private class SoundMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (sound) {
                sound = false;
                setIcon(home.getButton_sound(), "/View/Home/btn-soundx.png");
            } else {
                sound = true;
                setIcon(home.getButton_sound(), "/View/Home/btn-sound.png");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (sound) {
                setIcon(home.getButton_sound(), "/View/Home/btn-sound-entered.png");

            } else {
                setIcon(home.getButton_sound(), "/View/Home/btn-soundx-entered.png");
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (sound) {
                setIcon(home.getButton_sound(), "/View/Home/btn-sound.png");

            } else {
                setIcon(home.getButton_sound(), "/View/Home/btn-soundX.png");
            }
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
            setIcon(dialogLogin.getButton_Batal(), "/View/RegisterandLogin/btn-batal-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogLogin.getButton_Batal(), "/View/RegisterandLogin/btn-Batal.png");
        }
    }

    private class MasukLoginMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                username = dialogLogin.getTextField_Username().getText();
                String pass = dialogLogin.getPasswordField_Password().getText();

                userM.Login(username, pass);

                if (userM.getResult() > 0) {
                    new UserController(home, userM);
                    home.getLabel_profilUser().setText(username);
                    System.out.println(username);
                    awal.dispose();
                } else {
                    JOptionPane.showMessageDialog(home, "Username atau password anda salah!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogLogin.getButton_Masuk(), "/View/RegisterandLogin/btn-masuk-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogLogin.getButton_Masuk(), "/View/RegisterandLogin/btn-Masuk.png");
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
            setIcon(awal.getButton_Masuk(), "/View/RegisterandLogin/btn-masuk-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(awal.getButton_Masuk(), "/View/RegisterandLogin/btn-Masuk.png");
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
            setIcon(dialogRegister.getButton_batal(), "/View/RegisterandLogin/btn-batal-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogRegister.getButton_batal(), "/View/RegisterandLogin/btn-Batal.png");
        }
    }

    private class SimpanMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                System.out.println("bisa");
                String username = dialogRegister.getTextField_Username();
                String pass = dialogRegister.getPasswordField_Password();
                userM.cekUsername(username);
                if (dialogRegister.getTextField_Username().equals("")
                        || dialogRegister.getPasswordField_Password().equals("")) {
                    JOptionPane.showMessageDialog(home, "Username dan Password tidak boleh kosong!!");
                } else {
                    if (userM.getResult() == 0) {
                        JOptionPane.showMessageDialog(home, "berhasil disimpan");
                        userM.tambahUser(username, pass);
                        dialogRegister.dispose();
                        resetInputan();
                    } else {
                        JOptionPane.showMessageDialog(home, "Username sudah dipakai");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogRegister.getButton_simpan(), "/View/RegisterandLogin/btn-simpan-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogRegister.getButton_simpan(), "/View/RegisterandLogin/btn-Simpan.png");
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
            setIcon(awal.getButton_Register(), "/View/RegisterandLogin/btn-register-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(awal.getButton_Register(), "/View/RegisterandLogin/btn-register.png");

        }
    }

    private class TentangMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(about, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            setIcon(home.getButton_Tentang(), "/View/Home/btn-about-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(home.getButton_Tentang(), "/View/Home/btn-about.png");
        }
    }

    private class KeluarMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogKeluar.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(home.getButton_keluar(), "/View/Home/btn-exit-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(home.getButton_keluar(), "/View/Home/btn-exit.png");
        }
    }

    private class BantuanMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(help, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            setIcon(home.getButton_Bantuan(), "/View/Home/btn-help-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(home.getButton_Bantuan(), "/View/Home/btn-help.png");
        }
    }

    private class PlayMouseListnner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(pilihLevel, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            setIcon(home.getButton_play(), "/View/Home/btn-main-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(home.getButton_play(), "/View/Home/btn-main.png");
        }
    }
}
