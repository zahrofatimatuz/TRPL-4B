package Controller;

import Model.Koneksi;
import Model.UserModel;
import View.AboutView;
import View.AmbulanView;
import View.Gempa2View;
import View.HelpView;
import View.HomeView;
import View.IntroBanjir1View;
import View.IntroGempa1View;
import View.IntroKebakaran1View;
import View.Kebakaran2View;
import View.KorbanBanjirView;
import View.KorbanGempaView;
import View.KorbanKebakaranView;
import View.LevelKuisView;
import View.MenangKuisView;
import View.PanelBanjir2View;
import View.PanelBanjir3View;
import View.PanelBanjir4View;
import View.PanellBanjir1View;
import View.PilihanLevelView;
import View.PopUpDialogKorban1;
import View.PopUpDialogKorban2;
import View.PopUpDialogKorban3;
import View.PopUpDialogKorbanMenang;
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
import View.banjir2View;
import View.panelBakar1;
import View.panelBakar2;
import View.panelGempa2;
import View.panelGempa3;
import View.panelGempa1;
import View.panelGempa4;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
    private IntroBanjir1View introbanjir1 = new IntroBanjir1View();
    private IntroKebakaran1View introKebakaran1 = new IntroKebakaran1View();
    private IntroGempa1View introGempa1 = new IntroGempa1View();
    private KorbanBanjirView korban1 = new KorbanBanjirView();
    private KorbanGempaView korban2 = new KorbanGempaView();
    private KorbanKebakaranView korban3 = new KorbanKebakaranView();
    private AmbulanView ambulan = new AmbulanView();

    private banjir2View banjir2 = new banjir2View();
    private Gempa2View gempa2 = new Gempa2View();
    private Kebakaran2View bakar2 = new Kebakaran2View();
    private LevelKuisView kuis = new LevelKuisView();
    private MenangKuisView menangKuis = new MenangKuisView();
    private PopupKeluarView dialogKeluar;
    private PopUpRegisterView dialogRegister;
    private PopUpLoginView dialogLogin;
    private PopUpGantiPasswordView dialogGantiPass;
    private PopUpdialogView dialogPopUp;
    private PopUpdialog2View dialogPopUp2;
    private PopUpdialog3View dialogPopup3;
    private PopUpdialogwinView dialogPopupWin;
    private PopUpDialogKorban1 dialogKorban1;
    private PopUpDialogKorban2 dialogKorban2;
    private PopUpDialogKorban3 dialogKorban3;
    private PopUpDialogKorbanMenang dialogMenang;
    private Random random = new Random();
    public int idsoal;
    private static int soal[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private boolean lvl[] = {false, false, false, false, false};
    private static int nosoal = 1;
    private UserModel userM;
    private int darah;
    private int darah2;
    private boolean pause = false;
    private Timer time;
    private Timer timeWin;
    private int sekon = 5;
    private int sekons = 2;
    private int win = 5;
    private static int skor = 0;
    private static boolean level[] = {true, false, false};
    static GridBagLayout layout = new GridBagLayout();
    static GridBagLayout layout2 = new GridBagLayout();
    static GridBagLayout layout3 = new GridBagLayout();
    static PanellBanjir1View debog = new PanellBanjir1View();
    static PanelBanjir2View pelampung = new PanelBanjir2View();
    static PanelBanjir4View sapu = new PanelBanjir4View();
    static PanelBanjir3View galon = new PanelBanjir3View();
    static panelBakar1 gas = new panelBakar1();
    static panelBakar2 air = new panelBakar2();
    static panelBakar2 lap = new panelBakar2();
    Clip clip;
    static panelGempa1 meja = new panelGempa1();
    static panelGempa2 lari = new panelGempa2();
    static panelGempa3 lompat = new panelGempa3();
    static panelGempa4 tangga = new panelGempa4();
    public static int hasil[] = new int[3];
    public static int jawabBenar = 0;
    public static int jawabSalah = 0;
    public static String username = "";
    private boolean sound = true;
//    private boolean Pelampung = false;
//    private boolean Gas = false;
//    private boolean Debog = false;
//    private boolean bakar1 = false;
//    private boolean Gempa1 = false;
//    private boolean level2 = false;

    public UserController(awalanView awal, UserModel userM) throws SQLException {
//        playMusic("src//Music//Menu utama.wav");
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
        pilihLevel.KuisMouseListener(new KuisMouseListener());
        pilihLevel.Kebakaran2MouseListener(new Kebakaran2MouseListener());
        pilihLevel.getButton_Banjir1().setVisible(false);
        pilihLevel.getButton_gempa1().setVisible(false);
        pilihLevel.getButton_kebakaran1().setVisible(false);
        pilihLevel.getButton_Banjir2().setVisible(false);
        pilihLevel.getButton_gempa2().setVisible(false);
        pilihLevel.getButton_kebakaran2().setVisible(false);
//        dialogPopUp = new PopUpdialogView(pilihLevel, true);
//
//        dialogPopUp2 = new PopUpdialog2View(pilihLevel, true);
//
//        dialogPopup3 = new PopUpdialog3View(pilihLevel, true);
//
//        dialogPopupWin = new PopUpdialogwinView(pilihLevel, true);
    }

    public UserController(banjir1View banjir1, UserModel userM) throws SQLException {

        banjir1.setVisible(true);
        this.banjir1 = banjir1;
        this.userM = userM;
        darah = 3;

        banjir1.PauseListener(new PauseListener());
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

        dialogPopUp = new PopUpdialogView(pilihLevel, true);
        dialogPopUp.OKMouseListener(new popOkListener());
        dialogPopUp2 = new PopUpdialog2View(pilihLevel, true);
        dialogPopUp2.OK2MouseListener(new OK2Listenner());
        dialogPopup3 = new PopUpdialog3View(pilihLevel, true);
        dialogPopup3.OK3MouseListener(new OK3Listener());
        dialogPopupWin = new PopUpdialogwinView(pilihLevel, true);
        dialogPopupWin.OKMouseListener(new OKWinListener());
    }

    public UserController(kebakaran1View kebakaran1, UserModel userM) throws SQLException {
        this.kebakaran1 = kebakaran1;
        this.userM = userM;
        darah = 3;
        kebakaran1.setVisible(true);
        kebakaran1.PauseListener(new PauseListener());
        kebakaran1.AirListener(new AirListener());
        kebakaran1.GasListener(new GasListener());
        kebakaran1.LapListener(new LapListener());

        kebakaran1.getDynamic_Panel().setLayout(layout2);
        kebakaran1.getDynamic_Panel().add(air);
        kebakaran1.getDynamic_Panel().add(gas);
        kebakaran1.getDynamic_Panel().add(lap);
        kebakaran1.getDynamic_Panel().setVisible(false);

        dialogPopUp = new PopUpdialogView(pilihLevel, true);
        dialogPopUp.OKMouseListener(new popOkListener());

        dialogPopUp2 = new PopUpdialog2View(pilihLevel, true);
        dialogPopUp2.OK2MouseListener(new OK2Listenner());

        dialogPopup3 = new PopUpdialog3View(pilihLevel, true);
        dialogPopup3.OK3MouseListener(new OK3Listener());

        dialogPopupWin = new PopUpdialogwinView(pilihLevel, true);
        dialogPopupWin.OKMouseListener(new OKWinListener());
    }

    public UserController(gempa1View gempa1, UserModel userM) throws SQLException {
        this.gempa1 = gempa1;
        this.userM = userM;
        gempa1.setVisible(true);
        darah = 3;

        gempa1.LariListener(new LariListener());
        gempa1.MejaListener(new MejaListener());
        gempa1.JendelaListener(new JendelaListener());
        gempa1.TanggalaListener(new TanggaListener());

        gempa1.getDynamic_gempa().setLayout(layout3);
        gempa1.getDynamic_gempa().add(meja);
        gempa1.getDynamic_gempa().add(lari);
        gempa1.getDynamic_gempa().add(lompat);
        gempa1.getDynamic_gempa().add(tangga);
        gempa1.getDynamic_gempa().setVisible(false);

        dialogPopUp = new PopUpdialogView(pilihLevel, true);
        dialogPopUp.OKMouseListener(new popOkListener());

        dialogPopUp2 = new PopUpdialog2View(pilihLevel, true);
        dialogPopUp2.OK2MouseListener(new OK2Listenner());

        dialogPopup3 = new PopUpdialog3View(pilihLevel, true);
        dialogPopup3.OK3MouseListener(new OK3Listener());

        dialogPopupWin = new PopUpdialogwinView(pilihLevel, true);
        dialogPopupWin.OKMouseListener(new OKWinListener());
    }
//============================KORBAN=============================================================

    public UserController(KorbanBanjirView korban1, UserModel UserM) throws SQLException {
        this.korban1 = korban1;
        this.userM = UserM;
        korban1.setVisible(true);

        korban1.OkListener(new OkKorbanBanjir());
    }

    public UserController(KorbanGempaView korban2, UserModel UserM) throws SQLException {
        this.korban2 = korban2;
        this.userM = UserM;
        korban2.setVisible(true);
        korban2.OkListenerGempa(new OkKorbanGempa());
    }

    public UserController(KorbanKebakaranView korban3, UserModel UserM) throws SQLException {
        this.korban3 = korban3;
        this.userM = UserM;
        korban3.setVisible(true);
        korban3.OkListenerKebakaran(new OkKorbanKebakaran());
    }
//========================================USER CONTROLLER=====================================================

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
//===============================INTRO============================================================

    public UserController(IntroBanjir1View introBanjir1, UserModel userM) {
        this.introbanjir1 = introBanjir1;
        this.userM = userM;
        introBanjir1.setVisible(true);
        introBanjir1.okMouseListener(new okBanjirListenner());
    }

    public UserController(IntroKebakaran1View introKebakaran1, UserModel userM) {
        this.introKebakaran1 = introKebakaran1;
        this.userM = userM;
        introKebakaran1.setVisible(true);
        introKebakaran1.okMouseListener(new okKebakaranListenner());
    }

    public UserController(IntroGempa1View introGempa1, UserModel userM) {
        this.introGempa1 = introGempa1;
        this.userM = userM;
        introGempa1.setVisible(true);
        introGempa1.okMouseListener(new okGempaListenner());
    }
//===============================LEVEL 2=============================================================

    public UserController(banjir2View banjir2, UserModel userM) {
        darah2 = 3;
        this.banjir2 = banjir2;
        this.userM = userM;
        banjir2.setVisible(true);
        banjir2.DadaMouseListener(new DadaListener());
        banjir2.LututMouseListener(new LututListener());
        banjir2.KakiMouseListener(new KakiListener());
        banjir2.TanganMouseListener(new TanganListener());

        dialogKorban1 = new PopUpDialogKorban1(pilihLevel, true);
        dialogKorban1.OK1(new OkPopUp1lvl2Listener());

        dialogKorban2 = new PopUpDialogKorban2(pilihLevel, true);
        dialogKorban2.OK2(new OkPopUp2lvl2Listener());

        dialogKorban3 = new PopUpDialogKorban3(pilihLevel, true);
        dialogKorban3.OK3(new OkPopUp3lvl2Listener());

        dialogMenang = new PopUpDialogKorbanMenang(pilihLevel, true);
        dialogMenang.OKselamat(new OKselamat());
    }

    public UserController(Kebakaran2View bakar2, UserModel userM) {
        darah2 = 3;

        this.bakar2 = bakar2;
        this.userM = userM;
        bakar2.setVisible(true);

        bakar2.AirMaduLidahMouseListener(new MaduLidah());
        bakar2.EsBatuMouseListener(new EsBatu());
        bakar2.PastaMouseListener(new pasta());

        dialogKorban1 = new PopUpDialogKorban1(pilihLevel, true);
        dialogKorban1.OK1(new OkPopUp1lvl2Listener());

        dialogKorban2 = new PopUpDialogKorban2(pilihLevel, true);
        dialogKorban2.OK2(new OkPopUp2lvl2Listener());

        dialogKorban3 = new PopUpDialogKorban3(pilihLevel, true);
        dialogKorban3.OK3(new OkPopUp3lvl2Listener());

        dialogMenang = new PopUpDialogKorbanMenang(pilihLevel, true);
        dialogMenang.OKselamat(new OKselamat());
    }

    public UserController(Gempa2View gempa2, UserModel userM) {
        this.gempa2 = gempa2;
        this.userM = userM;
        gempa2.setVisible(true);
        darah2 = 3;
        gempa2.ObatMouseListener(new ObatListener());
        gempa2.ObatdanSapuMouseListener(new ObatdanSapuListener());
        gempa2.ObatdanTanduMouseListener(new ObatdanTanduListener());
        gempa2.TanduMouseListener(new TanduListener());

        dialogKorban1 = new PopUpDialogKorban1(pilihLevel, true);
        dialogKorban1.OK1(new OkPopUp1lvl2Listener());

        dialogKorban2 = new PopUpDialogKorban2(pilihLevel, true);
        dialogKorban2.OK2(new OkPopUp2lvl2Listener());

        dialogKorban3 = new PopUpDialogKorban3(pilihLevel, true);
        dialogKorban3.OK3(new OkPopUp3lvl2Listener());

        dialogMenang = new PopUpDialogKorbanMenang(pilihLevel, true);
        dialogMenang.OKselamat(new OKselamat());
    }

    public UserController(LevelKuisView kuis, UserModel userM) {
        this.kuis = kuis;
        this.userM = userM;
        kuis.setVisible(true);
        kuis.getLabel_Nama().setText(username);
        kuis.getLabel_Skor().setText(Integer.toString(skor));
        darah2 = 3;
        skor = 0;
        nosoal = 0;
        soal[0] = 0;
        soal[1] = 0;
        soal[2] = 0;
        soal[3] = 0;
        soal[4] = 0;
        soal[5] = 0;
        soal[6] = 0;
        soal[7] = 0;
        soal[8] = 0;
        soal[9] = 0;
        soal[10] = 0;
        soal[11] = 0;
        soal[12] = 0;
        soal[13] = 0;

        kuis.BackMouseListener(new BackKuisListener());
        kuis.jawabAMouseListener(new jawabAKuisListener());
        kuis.jawabBMouseListener(new jawabBKuisListener());
        kuis.jawabCMouseListener(new jawabCKuisListener());
        kuis.jawabDMouseListener(new jawabDKuisListener());
        kuis.PauseMouseListener(new PauseListener());
    }

    public UserController(MenangKuisView menangKuis, UserModel userM) {
        this.menangKuis = menangKuis;
        this.userM = userM;
        menangKuis.setVisible(true);
        menangKuis.getLabel_nama().setText(username);
        menangKuis.getLabel_Skor().setText(Integer.toString(skor));
        menangKuis.getLabel_jawabanBenar().setText(Integer.toString(jawabBenar));
        menangKuis.getLabel_jawabanSalah().setText(Integer.toString(jawabSalah));
        menangKuis.OK(new okMenang());

    }
//====================================================================================

    public void Pencocokan(String jawab) {
        System.out.println("jawaban :" + userM.getSoal05());
        if (userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabA().getText()) && jawab.equalsIgnoreCase("A")) {
            System.out.println("pilihan :" + kuis.getButton_jawabA().getText());
            skor += 10;
            jawabBenar += 1;
            setIcon(kuis.getButton_jawabA(), "/View/level3/opt-bener.png");
            kuis.getLabel_Skor().setText(Integer.toString(skor));
        } else if (userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabB().getText()) && jawab.equalsIgnoreCase("B")) {
            System.out.println("pilihan :" + kuis.getButton_jawabB().getText());
            skor += 10;
            jawabBenar += 1;
            setIcon(kuis.getButton_jawabB(), "/View/level3/opt-bener.png");
            kuis.getLabel_Skor().setText(Integer.toString(skor));
        } else if (userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabC().getText()) && jawab.equalsIgnoreCase("C")) {
            System.out.println("pilihan :" + kuis.getButton_jawabC().getText());
            skor += 10;
            jawabBenar += 1;
            setIcon(kuis.getButton_jawabC(), "/View/level3/opt-bener.png");
            kuis.getLabel_Skor().setText(Integer.toString(skor));
        } else if (userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabD().getText()) && jawab.equalsIgnoreCase("D")) {
            System.out.println("pilihan :" + kuis.getButton_jawabD().getText());
            skor += 10;
            jawabBenar += 1;
            setIcon(kuis.getButton_jawabD(), "/View/level3/opt-bener.png");
            kuis.getLabel_Skor().setText(Integer.toString(skor));
        } else if (!userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabD().getText()) && jawab.equalsIgnoreCase("D")) {
            setIcon(kuis.getButton_jawabD(), "/View/level3/opt-salah.png");
            jawabSalah += 1;
        } else if (!userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabC().getText()) && jawab.equalsIgnoreCase("C")) {
            setIcon(kuis.getButton_jawabC(), "/View/level3/opt-salah.png");
            jawabSalah += 1;
        } else if (!userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabB().getText()) && jawab.equalsIgnoreCase("B")) {
            setIcon(kuis.getButton_jawabB(), "/View/level3/opt-salah.png");
            jawabSalah += 1;
        } else if (!userM.getSoal05().equalsIgnoreCase(kuis.getButton_jawabA().getText()) && jawab.equalsIgnoreCase("A")) {
            setIcon(kuis.getButton_jawabA(), "/View/level3/opt-salah.png");
            jawabSalah += 1;
        }

    }

    public void cekLevel() {

        if (userM.getLevel1() >= 1 && userM.getLevel2() == 0 && userM.getLevel3() == 0) {
            System.out.println("level 1");
            pilihLevel.getButton_Level2().setEnabled(false);
            pilihLevel.getButton_Banjir2().setEnabled(false);
            pilihLevel.getButton_gempa2().setEnabled(false);
            pilihLevel.getButton_kebakaran2().setEnabled(false);
            pilihLevel.getButton_kuis().setEnabled(false);
            if (userM.getLevel1() == 3) {
                userM.tambahLevel2();
            }

        } else if (userM.getLevel2() >= 1 && userM.getLevel3() == 0) {
            System.out.println("level 2");
            pilihLevel.getButton_Level2().setEnabled(true);
            lvl[0] = true;
            pilihLevel.getButton_Banjir2().setEnabled(true);
            lvl[1] = true;
            pilihLevel.getButton_gempa2().setEnabled(true);
            lvl[2] = true;
            pilihLevel.getButton_kebakaran2().setEnabled(true);
            lvl[3] = true;
            pilihLevel.getButton_kuis().setEnabled(false);
            if (userM.getLevel2() == 3) {
                userM.tambahLevel3();
            }
        } else if (userM.getLevel3() >= 1) {
            System.out.println("Level 3");
            pilihLevel.getButton_Level2().setEnabled(true);
            lvl[0] = true;
            pilihLevel.getButton_Banjir2().setEnabled(true);
            lvl[1] = true;
            pilihLevel.getButton_gempa2().setEnabled(true);
            lvl[2] = true;
            pilihLevel.getButton_kebakaran2().setEnabled(true);
            lvl[3] = true;
            pilihLevel.getButton_kuis().setEnabled(true);
            lvl[4] = true;
        }
        userM.updateLevel(username);

    }

    public void setSoal() {
        setRandomSoal();
        userM.ambilSoal(idsoal);
        kuis.getLabel_soal().setText(userM.getSoal00());
        kuis.getButton_jawabA().setText(userM.getSoal01());
        kuis.getButton_jawabB().setText(userM.getSoal02());
        kuis.getButton_jawabC().setText(userM.getSoal03());
        kuis.getButton_jawabD().setText(userM.getSoal04());
    }

    public void pause() {
        if (pause) {
            kuis.getButton_jawabA().setEnabled(false);
            kuis.getButton_jawabB().setEnabled(false);
            kuis.getButton_jawabC().setEnabled(false);
            kuis.getButton_jawabD().setEnabled(false);

            banjir1.getPelampung().setEnabled(false);
            banjir1.getSapu().setEnabled(false);
            banjir1.getGalon().setEnabled(false);
            banjir1.getDebog().setEnabled(false);
            kebakaran1.getAir_button().setEnabled(false);
            kebakaran1.getGas_button().setEnabled(false);
            kebakaran1.getLap_button().setEnabled(false);
            gempa1.getButton_jendela().setEnabled(false);
            gempa1.getButton_lari().setEnabled(false);
            gempa1.getButton_meja().setEnabled(false);
            gempa1.getButton_tangga().setEnabled(false);

        } else {
            kuis.getButton_jawabA().setEnabled(true);
            kuis.getButton_jawabB().setEnabled(true);
            kuis.getButton_jawabC().setEnabled(true);
            kuis.getButton_jawabD().setEnabled(true);

            banjir1.getPelampung().setEnabled(true);
            banjir1.getSapu().setEnabled(true);
            banjir1.getGalon().setEnabled(true);
            banjir1.getDebog().setEnabled(true);
            kebakaran1.getAir_button().setEnabled(true);
            kebakaran1.getGas_button().setEnabled(true);
            kebakaran1.getLap_button().setEnabled(true);
            gempa1.getButton_jendela().setEnabled(true);
            gempa1.getButton_lari().setEnabled(true);
            gempa1.getButton_meja().setEnabled(true);
            gempa1.getButton_tangga().setEnabled(true);
        }
    }

    public void setRandomSoal() {
        do {
            idsoal = (random.nextInt(13) + 1);
        } while (soal[idsoal] == 1 && nosoal <= 9);
        soal[idsoal] = 1;

        if (nosoal == 9) {
            if (skor > userM.getskortertinggi()) {
                userM.setskortertinggi(skor);
                userM.updateSkorTertinggi(username);
                menangKuis.getLabel_SkorTertinggi().setText(Integer.toString(userM.getskortertinggi()));
                new UserController(menangKuis, userM);
                kuis.dispose();
            }
            menangKuis.getLabel_Skor().setText(Integer.toString(skor));
            menangKuis.getLabel_SkorTertinggi().setText(Integer.toString(userM.getskortertinggi()));
            new UserController(menangKuis, userM);
            kuis.dispose();
        }
        System.out.println("no soal : " + nosoal);
        System.out.println("idsoal :" + idsoal);
        nosoal += 1;
    }

    private void setIcon(JButton button, String resource) {
        button.setIcon(new ImageIcon(getClass().getResource(resource)));
    }

    private void setIconLabel(JLabel label, String resource) {
        label.setIcon(new ImageIcon(getClass().getResource(resource)));
    }

    private void playMusic(String resource) {
        AudioInputStream audio;

        try {
            audio = AudioSystem.getAudioInputStream(new File(resource));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void stopMusic() {
        if (clip.isRunning()) {

            clip.stop();
        }
    }

    private void timer(String frame) {
        ActionListener gameTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sekon--;
                if (frame.equalsIgnoreCase("banjir1")) {

                    if (sekon == 0) {
                        if (darah == 2) {
                            dialogPopUp.setVisible(true);
                            banjir1.getDynamicP().setVisible(false);
                        } else if (darah == 1) {
                            dialogPopUp2.setVisible(true);
                            banjir1.getDynamicP().setVisible(false);
                        } else if (darah == 0) {
                            try {
                                dialogPopup3.setVisible(true);
                                banjir1.dispose();
                                new UserController(pilihLevel, userM);

                            } catch (SQLException ex) {
                                Logger.getLogger(UserController.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else if (frame.equalsIgnoreCase("kebakaran1")) {
                    if (sekon == 0) {
                        if (darah == 2) {
                            dialogPopUp.setVisible(true);
                            kebakaran1.getDynamic_Panel().setVisible(false);
                        } else if (darah == 1) {
                            dialogPopUp2.setVisible(true);

                            kebakaran1.getDynamic_Panel().setVisible(false);
                        } else if (darah == 0) {
                            try {
                                dialogPopup3.setVisible(true);
                                kebakaran1.dispose();
                                new UserController(pilihLevel, userM);

                            } catch (SQLException ex) {
                                Logger.getLogger(UserController.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else if (frame.equalsIgnoreCase("gempa1")) {
                    if (sekon == 0) {
                        if (darah == 2) {
                            dialogPopUp.setVisible(true);
                            gempa1.getDynamic_gempa().setVisible(false);
                        } else if (darah == 1) {
                            dialogPopUp2.setVisible(true);
                            gempa1.getDynamic_gempa().setVisible(false);
                        } else if (darah == 0) {
                            try {
                                dialogPopup3.setVisible(true);
                                gempa1.dispose();
                                new UserController(pilihLevel, userM);

                            } catch (SQLException ex) {
                                Logger.getLogger(UserController.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        };
        time = new Timer(1000, gameTimer);
        time.start();
    }

    private void pindahsoal() {
        ActionListener gameTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sekons--;
                if (sekons == 0) {
                    setSoal();
                    sekons = 2;
                    time.stop();
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
                    timeWin.stop();
                    dialogPopupWin.setVisible(true);
                    if (!dialogPopupWin.isVisible()) {
                        banjir1.dispose();
                        kebakaran1.dispose();
                        gempa1.dispose();
                        try {
                            new UserController(pilihLevel, userM);

                        } catch (SQLException ex) {
                            Logger.getLogger(UserController.class
                                    .getName()).log(Level.SEVERE, null, ex);
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
        } else if (frame.equalsIgnoreCase("gempa1")) {
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

    private void minDarah2(String frame) throws SQLException {

        darah2--;
        if (frame.equalsIgnoreCase("banjir2")) {
            if (darah2 == 2) {
                setIconLabel(banjir2.getLabel_darah(), "/View/Level/75_.png");
                dialogKorban1.setVisible(true);

            } else if (darah2 == 1) {
                setIconLabel(banjir2.getLabel_darah(), "/View/Level/50_.png");
                dialogKorban2.setVisible(true);

            } else if (darah2 == 0) {
                setIconLabel(banjir2.getLabel_darah(), "/View/Level/25_.png");
                dialogKorban3.setVisible(true);
                banjir2.dispose();
                ambulan.setVisible(true);

            }
        } else if (frame.equalsIgnoreCase("bakar2")) {
            if (darah2 == 2) {
                setIconLabel(kebakaran1.getLabel_darah(), "/View/Level/50_.png");
                dialogKorban2.setVisible(true);
            } else if (darah2 == 1) {
                setIconLabel(kebakaran1.getLabel_darah(), "/View/Level/25_.png");
                dialogKorban3.setVisible(true);
            }else if (darah2 == 0) {
                bakar2.dispose();
                ambulan.setVisible(true);
            }
            
        } else if (frame.equalsIgnoreCase("gempa2")) {
            if (darah2 == 2) {
                setIconLabel(gempa2.getLabel_darah(), "/View/Level/75_.png");
                dialogKorban1.setVisible(true);
            } else if (darah2 == 1) {
                setIconLabel(gempa2.getLabel_darah(), "/View/Level/50_.png");
                dialogKorban2.setVisible(true);
            } else if (darah2 == 0) {
                setIconLabel(gempa2.getLabel_darah(), "/View/Level/25_.png");
                dialogKorban3.setVisible(true);
                gempa2.dispose();
                ambulan.setVisible(true);
            }
        }
    }

    private void resetInputan() {
        dialogRegister.get_Username().setText("");
        dialogRegister.get_Password().setText("");
        dialogLogin.getTextField_Username().setText("");
        dialogLogin.getPasswordField_Password().setText("");

    }



    private class okMenang implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            menangKuis.dispose();
            try {
                new UserController(pilihLevel, userM);
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

    private class OKselamat implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                dialogMenang.setVisible(false);

                if (!dialogMenang.isVisible()) {
                    banjir2.dispose();
                    bakar2.dispose();
                    gempa2.dispose();
                    new UserController(pilihLevel, userM);

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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class PauseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pause) {
                pause = false;
                pause();
            } else {
                pause = true;
                pause();
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

    private class jawabDKuisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pause == false) {
                Pencocokan("D");
                pindahsoal();
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
            setIcon(kuis.getButton_jawabD(), "/View/level3/opt-soalhover.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(kuis.getButton_jawabD(), "/View/level3/opt-soal.png");
        }
    }

    private class jawabCKuisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pause == false) {
                Pencocokan("C");
                pindahsoal();

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
            setIcon(kuis.getButton_jawabC(), "/View/level3/opt-soalhover.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(kuis.getButton_jawabC(), "/View/level3/opt-soal.png");
        }
    }

    private class jawabBKuisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pause == false) {
                Pencocokan("B");
                pindahsoal();
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
            setIcon(kuis.getButton_jawabB(), "/View/level3/opt-soalhover.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(kuis.getButton_jawabB(), "/View/level3/opt-soal.png");
        }
    }

    private class jawabAKuisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pause == false) {
                Pencocokan("A");
                pindahsoal();
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
            setIcon(kuis.getButton_jawabA(), "/View/level3/opt-soalhover.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(kuis.getButton_jawabA(), "/View/level3/opt-soal.png");
        }
    }

    private class BackKuisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            soal[0] = 0;
            soal[1] = 0;
            soal[2] = 0;
            soal[3] = 0;
            soal[4] = 0;
            soal[5] = 0;
            soal[6] = 0;
            soal[7] = 0;
            soal[8] = 0;
            soal[9] = 0;
            soal[10] = 0;
            soal[11] = 0;
            soal[12] = 0;
            soal[13] = 0;
            skor = 0;
            nosoal = 0;
            kuis.dispose();
            try {
                new UserController(pilihLevel, userM);
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

    private class KuisMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pilihLevel.getButton_kuis().isEnabled()) {
                setSoal();
                new UserController(kuis, userM);
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

    private class EsBatu implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("kebakaran2");
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

    private class pasta implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("kebakaran2");
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

    private class MaduLidah implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogMenang.setVisible(true);
            userM.tambahLevel2();
            cekLevel();
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

    private class TanduListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("gempa2");
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

    private class ObatdanTanduListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogMenang.setVisible(true);
            userM.tambahLevel2();
            cekLevel();
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

    private class ObatdanSapuListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("gempa2");
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

    private class ObatListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("gempa2");
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

    private class OkPopUp3lvl2Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogKorban3.dispose();
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

    private class OkPopUp2lvl2Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogKorban2.dispose();
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

    private class OkPopUp1lvl2Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogKorban1.dispose();
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

    private class OkKorbanGempa implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(gempa2, userM);
            korban2.dispose();
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

    private class TanggaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            gempa1.getDynamic_gempa().setVisible(true);
            meja.setVisible(false);
            lari.setVisible(false);
            lompat.setVisible(false);
            tangga.setVisible(true);
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

    private class OkKorbanKebakaran implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            new UserController(bakar2, userM);
            korban3.dispose();
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
//===============================Button OK level2=============================================

    private class OkKorbanBanjir implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            korban1.dispose();
            new UserController(banjir2, userM);
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

    private class TanganListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("banjir2");
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

    private class KakiListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("banjir2");
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

    private class LututListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                minDarah2("banjir2");
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

    private class DadaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogMenang.setVisible(true);
            userM.tambahLevel2();
            cekLevel();;
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

    private class okGempaListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                introGempa1.dispose();
                new UserController(gempa1, userM);
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

    private class okKebakaranListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                introKebakaran1.dispose();
                new UserController(kebakaran1, userM);
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

    private class okBanjirListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                introbanjir1.dispose();
                new UserController(banjir1, userM);
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

//VIEW Gempa 1
    private class JendelaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            gempa1.getDynamic_gempa().setVisible(true);
            meja.setVisible(false);
            lari.setVisible(false);
            tangga.setVisible(false);
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
            tangga.setVisible(false);
            lompat.setVisible(false);
            timerWin();
            userM.tambahLevel1();
            cekLevel();
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
            tangga.setVisible(false);
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
//=======================================================================    

//VIEW Kebakaran 1    
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
            userM.tambahLevel1();
            cekLevel();
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
//=======================================================================     

//VIEW Pop up 
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
//=======================================================================    

//VIEW Banjir1
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

    private class PisangListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            banjir1.getDynamicP().setVisible(true);
            pelampung.setVisible(false);
            debog.setVisible(true);
            galon.setVisible(false);
            sapu.setVisible(false);
//            Debog = true;
//            bakar1 = true;
            timerWin();
            userM.getLevel1();
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
            timerWin();
            userM.tambahLevel1();
            cekLevel();
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
//=======================================================================

//VIEW Pilih Level
    private class Kebakaran1MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pilihLevel.getButton_kebakaran1().isEnabled()) {

                new UserController(introKebakaran1, userM);
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

                new UserController(introGempa1, userM);
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
            if (pilihLevel.getButton_Banjir1().isEnabled()) {

                new UserController(introbanjir1, userM);
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

    private class Gempa2MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pilihLevel.getButton_gempa2().isEnabled()) {

                try {
                    new UserController(korban2, userM);
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

    private class Kebakaran2MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pilihLevel.getButton_kebakaran2().isEnabled()) {
                try {
                    ;
                    new UserController(korban3, userM);
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

    private class Banjir2MouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pilihLevel.getButton_Banjir2().isEnabled()) {

                try {
                    new UserController(korban1, userM);
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
//=======================================================================

//VIEW Home
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
            cekLevel();
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
            dialogKeluar.dispose();
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
            setIcon(dialogKeluar.getButton_ya(), "/View/ExitPopUp/btn-ya-entered.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogKeluar.getButton_ya(), "/View/ExitPopUp/btn-ya.png");
        }
    }

//=======================================================================
//VIEW Login
    private class MasukLoginMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {

                username = dialogLogin.getTextField_Username().getText();
                String pass = dialogLogin.getPasswordField_Password().getText();

                userM.Login(username, pass);
                if (username.equals("") || pass.equals("")) {
                    JOptionPane.showMessageDialog(home, "Username atau password tidak boleh kosong!!");
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
//=======================================================================
}
