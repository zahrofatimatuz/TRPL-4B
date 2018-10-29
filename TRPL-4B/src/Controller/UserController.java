package Controller;

import Model.Koneksi;
import Model.UserModel;
import View.AboutView;
import View.HelpView;
import View.HomeView;
import View.PanelBanjir2View;
import View.PanelBanjir3View;
import View.PanelBanjir4View;
import View.PanellBanjir1View;
import View.PilihanLevelView;
import View.PopUpGantiPasswordView;
import View.PopUpLoginView;
import View.PopUpRegisterView;
import View.PopupKeluarView;
import View.awalanView;
import View.banjir1View;
import View.gempa1View;
import View.kebakaran1View;
import View.PopUpdialogView;
import View.PopUpdialog2View;
import View.PopUpdialog3View;
import View.PopUpdialogwinView;
import View.panelBakar1;
import View.panelBakar2;
import View.panelGempa2;
import View.panelGempa3;
import View.panelGempa1;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
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
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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
    private PopUpdialogView dialogPopUp;
    private PopUpdialog2View dialogPopUp2;
    private PopUpdialog3View dialogPopup3;
    private PopUpdialogwinView dialogPopupWin;
    private UserModel userM;
    private int darah;
    private Timer time;
    private Timer timeWin;
    private int sekon = 5;
    private int win =5;
    GridBagLayout layout = new GridBagLayout();
    GridBagLayout layout2 = new GridBagLayout();
    GridBagLayout layout3 = new GridBagLayout();
    PanellBanjir1View debog = new PanellBanjir1View();
    PanelBanjir2View pelampung = new PanelBanjir2View();
    PanelBanjir4View sapu = new PanelBanjir4View();
    PanelBanjir3View galon = new PanelBanjir3View();
    panelBakar1 gas = new panelBakar1();
    panelBakar2 air = new panelBakar2();
    panelBakar2 lap = new panelBakar2();
    
    panelGempa1 meja = new panelGempa1();
    panelGempa2 lari = new panelGempa2();
    panelGempa3 lompat = new panelGempa3();
    
    public static String username = "";
    private boolean sound = true;
    private boolean Pelampung = false;
    private boolean Gas = false;
    private boolean Debog = false;
    private boolean bakar1 = false;
    private boolean Gempa1 = false;
    private boolean level2 = false;

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
        home.getLabel_profilUser().setText(username);
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

        this.banjir1 = banjir1;
        this.userM = userM;
        darah = 3;
        banjir1.setVisible(true);

        banjir1.PelampungListener(new PelampungListener());
        banjir1.PisangListener(new PisangListener());
        banjir1.GalonListener(new GalonListener());
        banjir1.SapuListener(new SapuListener());

        banjir1.getDynamicP().setLayout(layout);
        banjir1.getDynamicP().add(pelampung);
        banjir1.getDynamicP().add(debog);
        banjir1.getDynamicP().add(sapu);
        banjir1.getDynamicP().add(galon);
        banjir1.getDynamicP().setVisible(false);
        
        dialogPopUp = new PopUpdialogView(banjir1, true);
        dialogPopUp.OKMouseListener(new popOkListener());

        dialogPopUp2 = new PopUpdialog2View(banjir1, true);
        dialogPopUp2.OK2MouseListener(new OK2Listenner());

        dialogPopup3 = new PopUpdialog3View(banjir1, true);
        dialogPopup3.OK3MouseListener(new OK3Listener());

        dialogPopupWin = new PopUpdialogwinView(banjir1, true);
        dialogPopupWin.OKMouseListener(new OKWinListener());

    }

    public UserController(kebakaran1View kebakaran1, UserModel userM) throws SQLException {
        this.kebakaran1 = kebakaran1;
        this.userM = userM;
        darah = 3;
        kebakaran1.setVisible(true);

        kebakaran1.AirListener(new AirListener());
        kebakaran1.GasListener(new GasListener());
        kebakaran1.LapListener(new LapListener());

        kebakaran1.getDynamic_Panel().setLayout(layout2);
        kebakaran1.getDynamic_Panel().add(air);
        kebakaran1.getDynamic_Panel().add(gas);
        kebakaran1.getDynamic_Panel().add(lap);
        kebakaran1.getDynamic_Panel().setVisible(false);
        
        dialogPopUp = new PopUpdialogView(kebakaran1, true);
        dialogPopUp.OKMouseListener(new popOkListener());

        dialogPopUp2 = new PopUpdialog2View(kebakaran1, true);
        dialogPopUp2.OK2MouseListener(new OK2Listenner());

        dialogPopup3 = new PopUpdialog3View(kebakaran1, true);
        dialogPopup3.OK3MouseListener(new OK3Listener());

        dialogPopupWin = new PopUpdialogwinView(kebakaran1, true);
        dialogPopupWin.OKMouseListener(new OKWinListener());
    }

    public UserController(gempa1View gempa1, UserModel userM) throws SQLException {
        this.gempa1=gempa1;
        this.userM=userM;
        gempa1.setVisible(true);
        darah = 3;
        
        gempa1.LariListener(new LariListener());
        gempa1.MejaListener(new MejaListener());
        gempa1.JendelaListener(new JendelaListener());
        
        gempa1.getDynamic_gempa().setLayout(layout3);
        gempa1.getDynamic_gempa().add(meja);
        gempa1.getDynamic_gempa().add(lari);
        gempa1.getDynamic_gempa().add(lompat);
        gempa1.getDynamic_gempa().setVisible(false);
//        gempa1.getDynamic_Panel().add(tangga);
        dialogPopUp = new PopUpdialogView(kebakaran1, true);
        dialogPopUp.OKMouseListener(new popOkListener());

        dialogPopUp2 = new PopUpdialog2View(kebakaran1, true);
        dialogPopUp2.OK2MouseListener(new OK2Listenner());

        dialogPopup3 = new PopUpdialog3View(kebakaran1, true);
        dialogPopup3.OK3MouseListener(new OK3Listener());

        dialogPopupWin = new PopUpdialogwinView(kebakaran1, true);
        dialogPopupWin.OKMouseListener(new OKWinListener());
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
        pilihLevel.KembaliMouseListener(new KembaliPilihLevel());
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

//        pilihLevel.getButton_gempa1().setEnabled(Gempa1);
//        pilihLevel.getButton_kebakaran1().setEnabled(bakar1);
//        System.out.println(bakar1);
//        pilihLevel.getButton_Level2().setEnabled(level2);

    }

    private void setIcon(JButton button, String resource) {
        button.setIcon(new ImageIcon(getClass().getResource(resource)));
    }

    private void setIconLabel(JLabel label, String resource) {
        label.setIcon(new ImageIcon(getClass().getResource(resource)));
    }

    private void timer(String frame) {
        ActionListener gameTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sekon--;
                if (frame.equalsIgnoreCase("banjir1")) {
                    if (sekon == 0) {
                        if (Pelampung || Debog) {
                            dialogPopupWin.setVisible(true);
                            if (!dialogPopupWin.isVisible()) {
                                    banjir1.dispose();
                                try {
                                    new UserController(pilihLevel, userM);
                                } catch (SQLException ex) {
                                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } 
                        else if (darah == 2) {
                            dialogPopUp.setVisible(true);
                            banjir1.getDynamicP().setVisible(false);
                        } else if (darah == 1) {
                            dialogPopUp2.setVisible(true);
                            banjir1.getDynamicP().setVisible(false);
                        } else if (darah == 0) {
                            dialogPopup3.setVisible(true);
                            if (!dialogPopup3.isVisible()) {
                            banjir1.dispose();
                                try {
                                    new UserController(pilihLevel, userM);
                                } catch (SQLException ex) {
                                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                } else if (frame.equalsIgnoreCase("kebakaran1")) {
                    if (sekon == 0) {
                        if (Gas) {

                            dialogPopupWin.setVisible(true);
                            if (!dialogPopupWin.isVisible()) {
                                try {
                                    new UserController(pilihLevel, userM);
                                } catch (SQLException ex) {
                                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else if (darah == 2) {
                            dialogPopUp.setVisible(true);

                            kebakaran1.getDynamic_Panel().setVisible(false);
                        } else if (darah == 1) {
                            dialogPopUp2.setVisible(true);

                            kebakaran1.getDynamic_Panel().setVisible(false);
                        } else if (darah == 0) {
                            dialogPopup3.setVisible(true);

                            kebakaran1.dispose();
                            if (!dialogPopup3.isVisible()) {
                                try {
                                    new UserController(pilihLevel, userM);
                                } catch (SQLException ex) {
                                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }else if (frame.equalsIgnoreCase("gempa1")) {
                    if (sekon == 0) {
                        if (Gas) {

                            dialogPopupWin.setVisible(true);
                            if (!dialogPopupWin.isVisible()) {
                                try {
                                    new UserController(pilihLevel, userM);
                                } catch (SQLException ex) {
                                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else if (darah == 2) {
                            dialogPopUp.setVisible(true);
                            gempa1.getDynamic_gempa().setVisible(false);
                        } else if (darah == 1) {
                            dialogPopUp2.setVisible(true);
                            gempa1.getDynamic_gempa().setVisible(false);
                        } else if (darah == 0) {
                            dialogPopup3.setVisible(true);
                            gempa1.dispose();
                            if (!dialogPopup3.isVisible()) {
                                try {
                                    new UserController(pilihLevel, userM);
                                } catch (SQLException ex) {
                                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            }
        };
        time = new Timer(1000, gameTimer);
        time.start();
    }
   
    private void timerWin() {
        ActionListener timerWin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win--;
                //System.out.println("sekon "+win);
                    if (win == 0) {
                            dialogPopupWin.setVisible(true);
                            if (!dialogPopupWin.isVisible()) {
                                    banjir1.dispose();
                                    kebakaran1.dispose();
                                    gempa1.dispose();
                                try {
                                    new UserController(pilihLevel, userM);
                                } catch (SQLException ex) {
                                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                            }          
                        } 
                    }
                
            }
        };
        timeWin = new Timer(1000, timerWin);
        timeWin.start();
    }

    private void minDarah(String frame) throws SQLException {

        darah--;
        if (frame.equalsIgnoreCase("banjir1")) {
            if (darah == 2) {
                setIconLabel(banjir1.getLabel_darah(), "/View/Level/75_.png");
                timer("banjir1");
                sekon = 5;

            } else if (darah == 1) {
                setIconLabel(banjir1.getLabel_darah(), "/View/Level/50_.png");
                timer("banjir1");
                sekon = 5;

            } else if (darah == 0) {
                setIconLabel(banjir1.getLabel_darah(), "/View/Level/25_.png");
                timer("banjir1");
                sekon = 5;

            }
        } else if (frame.equalsIgnoreCase("kebakaran1")) {
            if (darah == 2) {
                setIconLabel(kebakaran1.getLabel_darah(), "/View/Level/75_.png");
                timer("kebakaran1");
                sekon = 5;

            } else if (darah == 1) {
                setIconLabel(kebakaran1.getLabel_darah(), "/View/Level/50_.png");
                timer("kebakaran1");
                sekon = 5;

            } else if (darah == 0) {
                setIconLabel(kebakaran1.getLabel_darah(), "/View/Level/25_.png");
                timer("kebakaran1");
                sekon = 5;

            }
        }else if (frame.equalsIgnoreCase("gempa1")) {
            if (darah == 2) {
                setIconLabel(gempa1.getLabel_darah(), "/View/Level/75_.png");
                timer("gempa1");
                sekon = 5;

            } else if (darah == 1) {
                setIconLabel(gempa1.getLabel_darah(), "/View/Level/50_.png");
                timer("gempa1");
                sekon = 5;

            } else if (darah == 0) {
                setIconLabel(gempa1.getLabel_darah(), "/View/Level/25_.png");
                timer("gempa1");
                sekon = 5;

            }
        }
        
    }

    private void resetInputan() {
        dialogRegister.get_Username().setText("");
        dialogRegister.get_Password().setText("");
        dialogLogin.getTextField_Username().setText("");
        dialogLogin.getPasswordField_Password().setText("");

    }

    private class JendelaListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            gempa1.getDynamic_gempa().setVisible(true);
            meja.setVisible(false);
            lari.setVisible(false);
            lompat.setVisible(true);
            try {
                minDarah("gempa1");
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
            }

        @Override
        public void mouseExited(MouseEvent e) {
            }
    }

    private class MejaListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            gempa1.getDynamic_gempa().setVisible(true);
            meja.setVisible(true);
            lari.setVisible(false);
            lompat.setVisible(false);
            timerWin();
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

    private class LariListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            gempa1.getDynamic_gempa().setVisible(true);
            lari.setVisible(true);
            meja.setVisible(false);
            lompat.setVisible(false);
            try {
                minDarah("gempa1");
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
            }

        @Override
        public void mouseExited(MouseEvent e) {
            }
    }

    private class OKWinListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(pilihLevel, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            dialogPopupWin.dispose();
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

    private class LapListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah("kebakaran1");
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            kebakaran1.getDynamic_Panel().setVisible(true);
            lap.setVisible(true);
            gas.setVisible(false);
            air.setVisible(false);
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

    private class GasListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            kebakaran1.getDynamic_Panel().setVisible(true);
            lap.setVisible(false);
            gas.setVisible(true);
            air.setVisible(false);
            timerWin();
            
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

    private class AirListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah("kebakaran1");
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            kebakaran1.getDynamic_Panel().setVisible(true);
            lap.setVisible(false);
            gas.setVisible(false);
            air.setVisible(true);
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

    private class OK3Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogPopup3.dispose();
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

    private class OK2Listenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogPopUp2.dispose();
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

    private class popOkListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogPopUp.dispose();
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

    private class GalonListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah("banjir1");
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            banjir1.getDynamicP().setVisible(true);
            galon.setVisible(true);
            sapu.setVisible(false);
            debog.setVisible(false);
            pelampung.setVisible(false);
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

    private class SapuListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah("banjir1");
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            banjir1.getDynamicP().setVisible(true);
            galon.setVisible(false);
            sapu.setVisible(true);
            debog.setVisible(false);
            pelampung.setVisible(false);
            sekon = 4;
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

    private class KembaliPilihLevel implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            try {
                new UserController(home, userM);
                pilihLevel.dispose();
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
            setIcon(pilihLevel.getButton_kembali(), "/View/About/btn-back-entered.png");

        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(pilihLevel.getButton_kembali(), "/View/About/btn-back.png");
        }
    }

    private class PisangListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            banjir1.getDynamicP().setVisible(true);
            pelampung.setVisible(false);
            debog.setVisible(true);
            galon.setVisible(false);
            sapu.setVisible(false);
            Debog = true;
            bakar1 = true;
            timerWin();
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

    private class PelampungListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            banjir1.getDynamicP().setVisible(true);
            pelampung.setVisible(true);
            debog.setVisible(false);
            sapu.setVisible(false);
            galon.setVisible(false);
            Pelampung = true;
            bakar1 = true;
            timerWin();
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
            if (pilihLevel.getButton_Level2().isEnabled()) {
                pilihLevel.getButton_Banjir1().setVisible(false);
                pilihLevel.getButton_gempa1().setVisible(false);
                pilihLevel.getButton_kebakaran1().setVisible(false);
                pilihLevel.getButton_Banjir2().setVisible(true);
                pilihLevel.getButton_gempa2().setVisible(true);
                pilihLevel.getButton_kebakaran2().setVisible(true);
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Kebakaran1MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pilihLevel.getButton_kebakaran1().isEnabled()) {
                try {
                    new UserController(kebakaran1, userM);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                pilihLevel.dispose();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class Gempa1MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pilihLevel.getButton_gempa1().isEnabled()) {

                try {
                    new UserController(gempa1, userM);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                pilihLevel.dispose();
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
                if (username.equals("") || pass.equals("")) {
                    JOptionPane.showMessageDialog(home, "Data tidak boleh kosong");
                } else {
                    if (userM.getResult() > 0) {
                        new UserController(home, userM);

                        System.out.println(username);
                        awal.dispose();
                    } else {
                        JOptionPane.showMessageDialog(home, "Username atau password anda salah!!");
                    }
                }
                resetInputan();
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
                resetInputan();
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
