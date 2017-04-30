package bike_gui;

import bike.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GreenSociety extends javax.swing.JFrame {
    private Authenication ac = new Authenication();
    private Register rs = new Register();
    private Sharing sh = new Sharing();
    private Notification nf = new Notification();
    private Support sp = new Support();
    private int countBorrow[];
    private int availableItem[];
    private String nameOfItem[];
    private String pathOfItem[];
    private int cpOfItem[];
    private JSpinner itemOfUser[];

    public GreenSociety() {
        initComponents();
        login.setVisible(true);
        forgotPassPage.setVisible(false);
        registerPage.setVisible(false);
        warning.setVisible(false);
        setLocationRelativeTo(null);
        sPassB.setVisible(false);
        sEmailB.setVisible(false);
        mainAdminSetVisible();
        mainAdmin.setVisible(false);
        mainUserSetVisibe();
        mainUser.setVisible(false);
        setBorderTextfield();
    }

    private void mainAdminSetVisible() {
        cpPage.setVisible(false);
        sharingPage.setVisible(false);
        titleSignout.setVisible(false);
        userProfilePage.setVisible(false);
    }

    private void mainUserSetVisibe() {
        sh.setDataOfItem();
        settingItem();
        startSetVisible();
        setLocationRelativeTo(null);
    }

    public void startSetVisible() {
        cpPage1.setVisible(false);
        titleSignout1.setVisible(false);
        sharingStep1.setVisible(false);
        sharingStep3.setVisible(false);
        timePageT.setVisible(false);
        timePageF.setVisible(false);
        textNotHis.setVisible(false);
        iconNotHis.setVisible(false);
        circleMini.setVisible(false);
        circleNoti.setVisible(false);
        userProfilePage1.setVisible(false);
        supportPage1.setVisible(false);
    }

    public void setBorderTextfield() {
        search1.setBorder(null);
        nameProfile1.setBorder(null);
        genderProfile1.setBorder(null);
        congenProfile1.setBorder(null);
        emailProfile1.setBorder(null);
        telProfile1.setBorder(null);
        search.setBorder(null);
        nameProfile.setBorder(null);
        genderProfile.setBorder(null);
        congenProfile.setBorder(null);
        emailProfile.setBorder(null);
        telProfile.setBorder(null);
        nameOfUser.setBorder(null);
        surnameOfUser.setBorder(null);
        itemName.setBorder(null);
        itemAmount.setBorder(null);
        itemId.setBorder(null);
        email.setBorder(null);
        forgotEmail.setBorder(null);
    }

    public void notiTime() {
        JOptionPane.showMessageDialog(this, "Time left : 10 minutes");
    }

    public String password(String oldPass, String newPass) {//พาสเวิร์ดที่ user ใส่มาสองรอบต้องเป็นตัวเดียวกัน
        String password = "";
        if (oldPass.equals(newPass)) {
            password = newPass;
        } else {
            JOptionPane.showMessageDialog(null, "These passwords don't match. Try again?",
                    "Check Password", JOptionPane.WARNING_MESSAGE);
            jPasswordSignUp.requestFocusInWindow();
        }
        return password;
    }

    public void setBorrowStep1() {
        int x = 50;
        int y = 50;
        JPanel sharingPage1 = new JPanel();
        sharingPage1.setBackground(new java.awt.Color(25, 41, 65));
        sharingPage1.setEnabled(false);
        sharingPage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        s1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        s1.setForeground(new java.awt.Color(255, 255, 255));
        s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/Step1.png"))); // NOI18N
        sharingPage1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 180, 40));
        isCp.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        isCp.setForeground(new java.awt.Color(255, 255, 255));
        isCp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sharingPage1.add(isCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 180, 30));

        JPanel[] jp = new JPanel[nameOfItem.length];
        JLabel[] imgItem = new JLabel[nameOfItem.length];
        JLabel[] available = new JLabel[nameOfItem.length];
        itemOfUser = new JSpinner[nameOfItem.length];
        for (int i = 0; i < nameOfItem.length; i++) {
            jp[i] = new JPanel();
            jp[i].setBackground(new java.awt.Color(13, 24, 35));
            jp[i].setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), nameOfItem[i] + "(" + cpOfItem[i] + " CP)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Leelawadee", 0, 18), new java.awt.Color(19, 175, 248)));
            jp[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            imgItem[i] = new JLabel();
            imgItem[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imgItem[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource(pathOfItem[i])).getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT))); // NOI18N
            jp[i].add(imgItem[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 130));

            available[i] = new JLabel();
            available[i].setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
            available[i].setForeground(new java.awt.Color(102, 204, 255));
            available[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            available[i].setText("Available :" + availableItem[i] + " Items");
            jp[i].add(available[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 20));

            itemOfUser[i] = new JSpinner();
            itemOfUser[i].setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
            itemOfUser[i].setModel(new javax.swing.SpinnerNumberModel(0, 0, availableItem[i], 1));
            itemOfUser[i].setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            itemOfUser[i].setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
            itemOfUser[i].setPreferredSize(new java.awt.Dimension(60, 25));
            jp[i].add(itemOfUser[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));
            sharingPage1.add(jp[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, 300, 170));
            if (x == 390) {
                x = 50;
                y += 210;
            } else {
                x += 340;
            }
        }
        y += 180;
        sharingPage1.add(nextStep, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, y, 60, 50));
        sharingScroll.setViewportView(sharingPage1);
    }

    public void settingItem() {
        nameOfItem = sh.getNameItem();
        pathOfItem = sh.getPathImgItem();
        availableItem = sh.getAvailableItem();
        cpOfItem = sh.getItemCP();
        countBorrow = new int[nameOfItem.length];
    }

    public void insertBorrow() throws SelectItemException {
        int temp = 0;
        int num[] = new int[itemOfUser.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) itemOfUser[i].getValue();
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) {
                temp++;
            }
        }
        if (num.length == temp) {
            SelectItemException slt = new SelectItemException();
            throw slt;
        }
        for (int i = 0; i < countBorrow.length; i++) {
            countBorrow[i] = num[i];
        }
        sh.setNumBikeUser(countBorrow);
    }

    public void setBorrowDetail() {
        String tmp = "";
        for (int i = 0; i < countBorrow.length; i++) {
            if (countBorrow[i] != 0) {
                tmp += "- " + nameOfItem[i] + " : " + countBorrow[i] + "<br>";
            }
        }
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String now = "Start: " + df.format(sh.getTime().getBorrowTime());
        String re = "End: " + df.format(sh.getTime().getReturnTime());
        tmp += now + "<br>" + re;
        detailData.setText("<html><body>" + tmp + "</body></html>");
    }

    public void clearingSharing() {
        sh.editStep();
        settingItem();
        for (int i = 0; i < countBorrow.length; i++) {
            countBorrow[i] = 0;
        }
        detailData.setText("");
    }

    public void setDataUserProfile() {
        if (User.getPositon().equals("-")) {
            userID1.setText(User.getUserId() + "");
            nameProfile1.setText(User.getFirstName() + " " + User.getLastName());
            genderProfile1.setText(User.getGender());
            birthProfile1.setText(User.getBirthDate());
            departProfile1.setText(User.getDept());
            congenProfile1.setText(User.getCongenitialDisease());
            emailProfile1.setText(User.getEmail());
            telProfile1.setText(User.getTel());
            imageProfile1.setIcon(new javax.swing.ImageIcon(getClass().getResource(User.getImgPath())));
        } else if (User.getPositon().equalsIgnoreCase("Officer") || User.getPositon().equalsIgnoreCase("Technician")) {
            userID.setText(User.getUserId() + "");
            nameProfile.setText(User.getFirstName() + " " + User.getLastName());
            genderProfile.setText(User.getGender());
            birthProfile.setText(User.getBirthDate());
            departProfile.setText(User.getDept());
            congenProfile.setText(User.getCongenitialDisease());
            emailProfile.setText(User.getEmail());
            telProfile.setText(User.getTel());
            imageProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource(User.getImgPath())));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainUser = new javax.swing.JPanel();
        barSearch1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        iconSearch1 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        backMenuBar1 = new javax.swing.JPanel();
        menuBar1 = new javax.swing.JPanel();
        news1 = new javax.swing.JLabel();
        bikeRepair1 = new javax.swing.JLabel();
        canCounter1 = new javax.swing.JLabel();
        bikeSharing1 = new javax.swing.JLabel();
        history1 = new javax.swing.JLabel();
        profile1 = new javax.swing.JLabel();
        timer1 = new javax.swing.JLabel();
        support1 = new javax.swing.JLabel();
        menu1 = new javax.swing.JLabel();
        arrowDownIcon1 = new javax.swing.JLabel();
        circleMini = new javax.swing.JLabel();
        titleSignout1 = new javax.swing.JLabel();
        barUser1 = new javax.swing.JPanel();
        pic1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        backBarUser1 = new javax.swing.JPanel();
        backBarIcon1 = new javax.swing.JPanel();
        barIcon1 = new javax.swing.JPanel();
        iconMenu1 = new javax.swing.JLabel();
        iconBike1 = new javax.swing.JLabel();
        iconProfile1 = new javax.swing.JLabel();
        signout1 = new javax.swing.JButton();
        barNoti1 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        circleNoti = new javax.swing.JLabel();
        iconNoti1 = new javax.swing.JLabel();
        supportPage1 = new javax.swing.JPanel();
        barTitle1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bodySupport1 = new javax.swing.JPanel();
        jLBShowingResult1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLBWhatsearch1 = new javax.swing.JLabel();
        resultScroll1 = new javax.swing.JScrollPane();
        jTAShowyouSearch = new javax.swing.JTextArea();
        contactScroll1 = new javax.swing.JScrollPane();
        jTAContact = new javax.swing.JTextArea();
        titleContactSupport1 = new javax.swing.JLabel();
        userProfilePage1 = new javax.swing.JPanel();
        editProfileBut1 = new javax.swing.JButton();
        titleUserId1 = new javax.swing.JLabel();
        userID1 = new javax.swing.JLabel();
        imageProfile1 = new javax.swing.JLabel();
        titleAbout1 = new javax.swing.JLabel();
        titleNameProfile1 = new javax.swing.JLabel();
        nameProfile1 = new javax.swing.JTextField();
        titleGenderProfile1 = new javax.swing.JLabel();
        genderProfile1 = new javax.swing.JTextField();
        titlebBirthProfile1 = new javax.swing.JLabel();
        birthProfile1 = new javax.swing.JFormattedTextField();
        titleDepartProfile1 = new javax.swing.JLabel();
        departProfile1 = new javax.swing.JLabel();
        titleCongenProfile1 = new javax.swing.JLabel();
        congenProfile1 = new javax.swing.JTextField();
        titleContact1 = new javax.swing.JLabel();
        titleEmailProfile1 = new javax.swing.JLabel();
        emailProfile1 = new javax.swing.JTextField();
        titleTelProfile1 = new javax.swing.JLabel();
        telProfile1 = new javax.swing.JTextField();
        chooseImgProfileBut1 = new javax.swing.JButton();
        pathImgProfile1 = new javax.swing.JLabel();
        submitProfile1 = new javax.swing.JButton();
        warningProfile1 = new javax.swing.JLabel();
        timePageT = new javax.swing.JPanel();
        timewatch = new javax.swing.JPanel();
        titleNow = new javax.swing.JLabel();
        timeLeftShow = new javax.swing.JLabel();
        endTime = new javax.swing.JLabel();
        iconClockBig = new javax.swing.JLabel();
        timeupPage = new javax.swing.JPanel();
        titleItemTimeUp = new javax.swing.JLabel();
        timeupInside = new javax.swing.JPanel();
        listTimeup = new javax.swing.JLabel();
        itemListShow = new javax.swing.JPanel();
        itemListShowInsidee = new javax.swing.JPanel();
        listShow = new javax.swing.JLabel();
        titleItemListShow = new javax.swing.JLabel();
        sharingScroll = new javax.swing.JScrollPane();
        sharingStep1 = new javax.swing.JPanel();
        nextStep = new javax.swing.JButton();
        s1 = new javax.swing.JLabel();
        isCp = new javax.swing.JLabel();
        timePageF = new javax.swing.JPanel();
        textNotHis = new javax.swing.JLabel();
        iconNotHis = new javax.swing.JLabel();
        sharingStep3 = new javax.swing.JPanel();
        textYourCP = new javax.swing.JLabel();
        cpUser = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        textRemain = new javax.swing.JLabel();
        point1 = new javax.swing.JLabel();
        textCpUse = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        cpUse = new javax.swing.JLabel();
        point2 = new javax.swing.JLabel();
        pointRemain = new javax.swing.JLabel();
        point3 = new javax.swing.JLabel();
        detailBox = new javax.swing.JPanel();
        detailData = new javax.swing.JLabel();
        backStep1 = new javax.swing.JButton();
        cancleBut = new javax.swing.JButton();
        borrowBut = new javax.swing.JButton();
        s9 = new javax.swing.JLabel();
        cpPage1 = new javax.swing.JPanel();
        showCp = new javax.swing.JLabel();
        circleCp = new javax.swing.JLabel();
        History = new javax.swing.JPanel();
        detailBoxHistory = new javax.swing.JPanel();
        poinsHis = new javax.swing.JLabel();
        actionHis = new javax.swing.JLabel();
        titleHistory = new javax.swing.JLabel();
        point4 = new javax.swing.JLabel();
        login = new javax.swing.JPanel();
        GreenSociety = new javax.swing.JLabel();
        iconEmail = new javax.swing.JLabel();
        iconKey = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        sEmailG = new javax.swing.JLabel();
        sEmailB = new javax.swing.JLabel();
        showPass = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        sPassG = new javax.swing.JLabel();
        sPassB = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        signin = new javax.swing.JButton();
        backLogin = new javax.swing.JLabel();
        menuSignup = new javax.swing.JLabel();
        forgotPass = new javax.swing.JLabel();
        titleSignup = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        forgotPassPage = new javax.swing.JPanel();
        inputForgot = new javax.swing.JPanel();
        titleForgotPass = new javax.swing.JLabel();
        s10 = new javax.swing.JSeparator();
        titleEmail = new javax.swing.JLabel();
        forgotEmail = new javax.swing.JTextField();
        titleNewPass = new javax.swing.JLabel();
        titleConPass = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        submitPass = new javax.swing.JLabel();
        star1 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        backSignin = new javax.swing.JLabel();
        Background1 = new javax.swing.JLabel();
        registerPage = new javax.swing.JPanel();
        backSigninRegis = new javax.swing.JLabel();
        jPanelSignUp = new javax.swing.JPanel();
        jLbSignUp = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldTelophone = new javax.swing.JTextField();
        jTfFirstName = new javax.swing.JTextField();
        jLbLastName = new javax.swing.JLabel();
        jLbDateOfBirth = new javax.swing.JLabel();
        jLabelStarLN = new javax.swing.JLabel();
        jComboBoxPosition = new javax.swing.JComboBox<>();
        jLbGender = new javax.swing.JLabel();
        jLbPassWord = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLbFirstName = new javax.swing.JLabel();
        jLbStarId = new javax.swing.JLabel();
        jLbStarFirstName = new javax.swing.JLabel();
        jLbStarGender = new javax.swing.JLabel();
        jLbStarBirthDay = new javax.swing.JLabel();
        jLbStarPassword = new javax.swing.JLabel();
        jLbPosition = new javax.swing.JLabel();
        jLbStarPosition = new javax.swing.JLabel();
        jLbCongenitialDisease = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLbTelophone = new javax.swing.JLabel();
        jLbStarTelophone = new javax.swing.JLabel();
        jTextFieldConDisease = new javax.swing.JTextField();
        jLbEmail = new javax.swing.JLabel();
        jLbStarEmail = new javax.swing.JLabel();
        jPasswordSignUp = new javax.swing.JPasswordField();
        jPasswordConfirmPassSignup = new javax.swing.JPasswordField();
        jLbConfirmPassWord = new javax.swing.JLabel();
        jLbStarConfirmPass = new javax.swing.JLabel();
        jButtonSignUp = new javax.swing.JButton();
        jRadioButtonGenderFemale = new javax.swing.JRadioButton();
        jRadioButtonGenderMale = new javax.swing.JRadioButton();
        jLabelPictureProfileRegister = new javax.swing.JLabel();
        jButtonChooseFileForUpload = new javax.swing.JButton();
        jLabelPartPictureUserUpload = new javax.swing.JLabel();
        jLbId = new javax.swing.JLabel();
        jLabelEmailNotCorrect = new javax.swing.JLabel();
        jLabelNoticSurname = new javax.swing.JLabel();
        jLabelifLengthId = new javax.swing.JLabel();
        jLabelNoticNewPass = new javax.swing.JLabel();
        jLabelNoticName = new javax.swing.JLabel();
        jLabelNoticGender = new javax.swing.JLabel();
        jLabelNoticBirthDate = new javax.swing.JLabel();
        jLabelNoticPosition = new javax.swing.JLabel();
        jLabelNoticTel = new javax.swing.JLabel();
        jLabelNoticOldPass = new javax.swing.JLabel();
        jDateChooserBirthDate = new com.toedter.calendar.JDateChooser();
        jFormatTextFieldForId = new javax.swing.JFormattedTextField();
        Backgroung2 = new javax.swing.JLabel();
        mainAdmin = new javax.swing.JPanel();
        barSearch = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        iconSearch = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        backMenuBar = new javax.swing.JPanel();
        menuBar = new javax.swing.JPanel();
        news = new javax.swing.JLabel();
        bikeRepair = new javax.swing.JLabel();
        canCounter = new javax.swing.JLabel();
        bikeSharing = new javax.swing.JLabel();
        history = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        support = new javax.swing.JLabel();
        titleSignout = new javax.swing.JLabel();
        arrowDownIcon = new javax.swing.JLabel();
        barUser = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        position = new javax.swing.JLabel();
        backBarUser = new javax.swing.JPanel();
        backBarIcon = new javax.swing.JPanel();
        barIcon = new javax.swing.JPanel();
        iconMenu = new javax.swing.JLabel();
        iconBike = new javax.swing.JLabel();
        iconProfile = new javax.swing.JLabel();
        signout = new javax.swing.JButton();
        barNoti = new javax.swing.JPanel();
        userProfilePage = new javax.swing.JPanel();
        editProfileBut = new javax.swing.JButton();
        titleUserId = new javax.swing.JLabel();
        userID = new javax.swing.JLabel();
        imageProfile = new javax.swing.JLabel();
        titleAbout = new javax.swing.JLabel();
        titleNameProfile = new javax.swing.JLabel();
        nameProfile = new javax.swing.JTextField();
        titleGenderProfile = new javax.swing.JLabel();
        genderProfile = new javax.swing.JTextField();
        titlebBirthProfile = new javax.swing.JLabel();
        birthProfile = new javax.swing.JFormattedTextField();
        titleDepartProfile = new javax.swing.JLabel();
        departProfile = new javax.swing.JLabel();
        titleCongenProfile = new javax.swing.JLabel();
        congenProfile = new javax.swing.JTextField();
        titleContact = new javax.swing.JLabel();
        titleEmailProfile = new javax.swing.JLabel();
        emailProfile = new javax.swing.JTextField();
        titleTelProfile = new javax.swing.JLabel();
        telProfile = new javax.swing.JTextField();
        chooseImgProfileBut = new javax.swing.JButton();
        pathImgProfile = new javax.swing.JLabel();
        submitProfile = new javax.swing.JButton();
        warningProfile = new javax.swing.JLabel();
        cpPage = new javax.swing.JPanel();
        titleCountCan = new javax.swing.JLabel();
        titleNameUser = new javax.swing.JLabel();
        s3 = new javax.swing.JSeparator();
        s4 = new javax.swing.JSeparator();
        nameOfUser = new javax.swing.JTextField();
        countOfCan = new javax.swing.JTextField();
        submitBut = new javax.swing.JButton();
        cancleAdminBut = new javax.swing.JButton();
        titleLastname = new javax.swing.JLabel();
        surnameOfUser = new javax.swing.JTextField();
        s5 = new javax.swing.JSeparator();
        sharingPage = new javax.swing.JPanel();
        menuSharing = new javax.swing.JPanel();
        menuAdd = new javax.swing.JButton();
        menuEdit = new javax.swing.JButton();
        menuDelete = new javax.swing.JButton();
        backAdd = new javax.swing.JPanel();
        backEdit = new javax.swing.JPanel();
        backDelete = new javax.swing.JPanel();
        sharingPageTab = new javax.swing.JPanel();
        layerAddItem = new javax.swing.JPanel();
        titleItemId = new javax.swing.JLabel();
        s6 = new javax.swing.JSeparator();
        s7 = new javax.swing.JSeparator();
        titleItemName = new javax.swing.JLabel();
        itemName = new javax.swing.JTextField();
        titleItemCount = new javax.swing.JLabel();
        s8 = new javax.swing.JSeparator();
        itemAmount = new javax.swing.JTextField();
        submitButSharing = new javax.swing.JButton();
        cancleButSharing = new javax.swing.JButton();
        itemId = new javax.swing.JTextField();
        notiSharing = new javax.swing.JLabel();
        itemList = new javax.swing.JButton();
        itemListScroll = new javax.swing.JScrollPane();
        itemListPage = new javax.swing.JPanel();
        titleItemList = new javax.swing.JLabel();
        closeBut = new javax.swing.JLabel();
        titleWhat = new javax.swing.JLabel();
        radioType = new javax.swing.JRadioButton();
        radioEquip = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barSearch1.setBackground(new java.awt.Color(13, 24, 35));
        barSearch1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        barSearch1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 120, 40));

        iconSearch1.setFont(new java.awt.Font("Leelawadee UI", 0, 20)); // NOI18N
        iconSearch1.setForeground(new java.awt.Color(255, 255, 255));
        iconSearch1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/search.png"))); // NOI18N
        iconSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconSearch1MouseClicked(evt);
            }
        });
        barSearch1.add(iconSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 60, 50));

        title1.setBackground(new java.awt.Color(0, 0, 0));
        title1.setFont(new java.awt.Font("Leelawadee", 0, 30)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("GREEN  SOCIETY");
        title1.setToolTipText("");
        barSearch1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 60));

        search1.setBackground(new java.awt.Color(13, 24, 35));
        search1.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        search1.setForeground(new java.awt.Color(255, 255, 255));
        search1.setText("Search");
        search1.setBorder(null);
        search1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search1FocusLost(evt);
            }
        });
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search1KeyPressed(evt);
            }
        });
        barSearch1.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 120, 30));

        mainUser.add(barSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 900, 60));

        backMenuBar1.setBackground(new java.awt.Color(22, 31, 39));
        backMenuBar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuBar1.setBackground(new java.awt.Color(13, 24, 35));
        menuBar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        news1.setBackground(new java.awt.Color(0, 0, 0));
        news1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        news1.setForeground(new java.awt.Color(255, 255, 255));
        news1.setText("     News");
        news1.setToolTipText("");
        news1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBar1.add(news1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 20));

        bikeRepair1.setBackground(new java.awt.Color(0, 0, 0));
        bikeRepair1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        bikeRepair1.setForeground(new java.awt.Color(255, 255, 255));
        bikeRepair1.setText("     Bike Repairing");
        bikeRepair1.setToolTipText("");
        bikeRepair1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBar1.add(bikeRepair1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 140, 20));

        canCounter1.setBackground(new java.awt.Color(0, 0, 0));
        canCounter1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        canCounter1.setForeground(new java.awt.Color(255, 255, 255));
        canCounter1.setText("     Can Counter");
        canCounter1.setToolTipText("");
        canCounter1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        canCounter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canCounter1MouseClicked(evt);
            }
        });
        menuBar1.add(canCounter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, 20));

        bikeSharing1.setBackground(new java.awt.Color(255, 255, 255));
        bikeSharing1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        bikeSharing1.setForeground(new java.awt.Color(255, 255, 255));
        bikeSharing1.setText("     Bike Sharing");
        bikeSharing1.setToolTipText("");
        bikeSharing1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bikeSharing1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bikeSharing1MouseClicked(evt);
            }
        });
        menuBar1.add(bikeSharing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 140, 20));

        history1.setBackground(new java.awt.Color(0, 0, 0));
        history1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        history1.setForeground(new java.awt.Color(255, 255, 255));
        history1.setText("     History");
        history1.setToolTipText("");
        history1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBar1.add(history1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, 20));

        profile1.setBackground(new java.awt.Color(0, 0, 0));
        profile1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        profile1.setForeground(new java.awt.Color(255, 255, 255));
        profile1.setText("     PROFILE");
        profile1.setToolTipText("");
        profile1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profile1MouseClicked(evt);
            }
        });
        menuBar1.add(profile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 140, 30));

        timer1.setBackground(new java.awt.Color(0, 0, 0));
        timer1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        timer1.setForeground(new java.awt.Color(255, 255, 255));
        timer1.setText("     Timer");
        timer1.setToolTipText("");
        timer1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        timer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timer1MouseClicked(evt);
            }
        });
        menuBar1.add(timer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, 20));

        support1.setBackground(new java.awt.Color(0, 0, 0));
        support1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        support1.setForeground(new java.awt.Color(255, 255, 255));
        support1.setText("     Support");
        support1.setToolTipText("");
        support1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        support1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                support1MouseClicked(evt);
            }
        });
        menuBar1.add(support1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, 20));

        menu1.setBackground(new java.awt.Color(0, 0, 0));
        menu1.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        menu1.setForeground(new java.awt.Color(255, 255, 255));
        menu1.setText("MENU");
        menu1.setToolTipText("");
        menuBar1.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 30));

        arrowDownIcon1.setBackground(new java.awt.Color(0, 0, 0));
        arrowDownIcon1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        arrowDownIcon1.setForeground(new java.awt.Color(255, 255, 255));
        arrowDownIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowDownIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/chevron-arrow-down.png"))); // NOI18N
        arrowDownIcon1.setToolTipText("");
        menuBar1.add(arrowDownIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, 30));

        circleMini.setBackground(new java.awt.Color(0, 0, 0));
        circleMini.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        circleMini.setForeground(new java.awt.Color(255, 255, 255));
        circleMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/circle_mini.png"))); // NOI18N
        circleMini.setToolTipText("");
        menuBar1.add(circleMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 20, 20));

        titleSignout1.setBackground(new java.awt.Color(0, 0, 0));
        titleSignout1.setFont(new java.awt.Font("Leelawadee", 0, 13)); // NOI18N
        titleSignout1.setForeground(new java.awt.Color(255, 255, 255));
        titleSignout1.setText("     SIGN OUT");
        titleSignout1.setToolTipText("");
        menuBar1.add(titleSignout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 140, 30));

        backMenuBar1.add(menuBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        mainUser.add(backMenuBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 150, 480));

        barUser1.setBackground(new java.awt.Color(19, 175, 248));
        barUser1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barUser1.add(pic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        name1.setBackground(new java.awt.Color(0, 0, 0));
        name1.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        name1.setForeground(new java.awt.Color(13, 24, 35));
        name1.setText("THANATTA");
        name1.setToolTipText("");
        name1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        barUser1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 20));

        mainUser.add(barUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 200, 60));

        backBarUser1.setBackground(new java.awt.Color(55, 200, 255));
        backBarUser1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mainUser.add(backBarUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 210, 60));

        backBarIcon1.setBackground(new java.awt.Color(55, 200, 255));
        backBarIcon1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barIcon1.setBackground(new java.awt.Color(19, 175, 248));
        barIcon1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/menu.png"))); // NOI18N
        barIcon1.add(iconMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 50, 30));

        iconBike1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconBike1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/bike.png"))); // NOI18N
        barIcon1.add(iconBike1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        iconProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconProfile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/profile-user.png"))); // NOI18N
        barIcon1.add(iconProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 50, 50));

        signout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/signout.png"))); // NOI18N
        signout1.setContentAreaFilled(false);
        signout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signout1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signout1MouseExited(evt);
            }
        });
        signout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signout1ActionPerformed(evt);
            }
        });
        barIcon1.add(signout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 50, 50));

        backBarIcon1.add(barIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 540));

        mainUser.add(backBarIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 540));

        barNoti1.setBackground(new java.awt.Color(13, 24, 35));
        barNoti1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setBackground(new java.awt.Color(55, 200, 255));
        jSeparator4.setForeground(new java.awt.Color(55, 200, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        barNoti1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 10, 60));

        circleNoti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        circleNoti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/circle.png"))); // NOI18N
        barNoti1.add(circleNoti, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

        iconNoti1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconNoti1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/notifications-button.png"))); // NOI18N
        barNoti1.add(iconNoti1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        mainUser.add(barNoti1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 770, 60));

        supportPage1.setBackground(new java.awt.Color(25, 41, 65));
        supportPage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barTitle1.setBackground(new java.awt.Color(15, 30, 52));
        barTitle1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(19, 175, 248));
        jLabel3.setText("Support");
        barTitle1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 50));

        supportPage1.add(barTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 50));

        bodySupport1.setBackground(new java.awt.Color(25, 41, 65));
        bodySupport1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLBShowingResult1.setBackground(new java.awt.Color(255, 255, 255));
        jLBShowingResult1.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLBShowingResult1.setForeground(new java.awt.Color(255, 255, 255));
        jLBShowingResult1.setText("Showing results for:");
        bodySupport1.add(jLBShowingResult1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, 30));
        bodySupport1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 220, 10));

        jLBWhatsearch1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLBWhatsearch1.setForeground(new java.awt.Color(255, 255, 255));
        bodySupport1.add(jLBWhatsearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 220, 30));

        jTAShowyouSearch.setEditable(false);
        jTAShowyouSearch.setBackground(new java.awt.Color(25, 41, 65));
        jTAShowyouSearch.setColumns(20);
        jTAShowyouSearch.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jTAShowyouSearch.setForeground(new java.awt.Color(255, 255, 255));
        jTAShowyouSearch.setRows(5);
        jTAShowyouSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(19, 175, 248), 1, true));
        resultScroll1.setViewportView(jTAShowyouSearch);

        bodySupport1.add(resultScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 420, 300));

        jTAContact.setEditable(false);
        jTAContact.setBackground(new java.awt.Color(25, 41, 65));
        jTAContact.setColumns(20);
        jTAContact.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jTAContact.setForeground(new java.awt.Color(255, 255, 255));
        jTAContact.setRows(5);
        jTAContact.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(19, 175, 248), 1, true));
        contactScroll1.setViewportView(jTAContact);

        bodySupport1.add(contactScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 270, 300));

        titleContactSupport1.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        titleContactSupport1.setForeground(new java.awt.Color(255, 255, 255));
        titleContactSupport1.setText("Contact");
        bodySupport1.add(titleContactSupport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        supportPage1.add(bodySupport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 770, 370));

        mainUser.add(supportPage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 420));

        userProfilePage1.setBackground(new java.awt.Color(25, 41, 65));
        userProfilePage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editProfileBut1.setBackground(new java.awt.Color(126, 192, 237));
        editProfileBut1.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        editProfileBut1.setForeground(new java.awt.Color(255, 255, 255));
        editProfileBut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/editProfile.png"))); // NOI18N
        editProfileBut1.setContentAreaFilled(false);
        editProfileBut1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editProfileBut1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editProfileBut1MouseExited(evt);
            }
        });
        editProfileBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileBut1ActionPerformed(evt);
            }
        });
        userProfilePage1.add(editProfileBut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 3, 110, 40));

        titleUserId1.setBackground(new java.awt.Color(55, 200, 255));
        titleUserId1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        titleUserId1.setForeground(new java.awt.Color(255, 255, 255));
        titleUserId1.setText("User ID :");
        userProfilePage1.add(titleUserId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, -1));

        userID1.setBackground(new java.awt.Color(55, 200, 255));
        userID1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        userID1.setForeground(new java.awt.Color(19, 175, 248));
        userID1.setText("1");
        userID1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        userProfilePage1.add(userID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 60, 20));
        userProfilePage1.add(imageProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 170));

        titleAbout1.setBackground(new java.awt.Color(13, 24, 35));
        titleAbout1.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleAbout1.setForeground(new java.awt.Color(255, 255, 255));
        titleAbout1.setText("ABOUT");
        userProfilePage1.add(titleAbout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        titleNameProfile1.setBackground(new java.awt.Color(55, 200, 255));
        titleNameProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleNameProfile1.setForeground(new java.awt.Color(236, 233, 233));
        titleNameProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNameProfile1.setText("Name :");
        userProfilePage1.add(titleNameProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 80, 20));

        nameProfile1.setEditable(false);
        nameProfile1.setBackground(new java.awt.Color(25, 41, 65));
        nameProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        nameProfile1.setForeground(new java.awt.Color(19, 175, 248));
        nameProfile1.setText("Thanatta  Opatkajonyos");
        nameProfile1.setBorder(null);
        userProfilePage1.add(nameProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 380, 40));

        titleGenderProfile1.setBackground(new java.awt.Color(55, 200, 255));
        titleGenderProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleGenderProfile1.setForeground(new java.awt.Color(236, 233, 233));
        titleGenderProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleGenderProfile1.setText("Gender :");
        userProfilePage1.add(titleGenderProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 90, 40));

        genderProfile1.setEditable(false);
        genderProfile1.setBackground(new java.awt.Color(25, 41, 65));
        genderProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        genderProfile1.setForeground(new java.awt.Color(19, 175, 248));
        genderProfile1.setText("Female");
        genderProfile1.setBorder(null);
        userProfilePage1.add(genderProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 70, 40));

        titlebBirthProfile1.setBackground(new java.awt.Color(55, 200, 255));
        titlebBirthProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titlebBirthProfile1.setForeground(new java.awt.Color(236, 233, 233));
        titlebBirthProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlebBirthProfile1.setText("Birthday :");
        userProfilePage1.add(titlebBirthProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 90, 40));

        birthProfile1.setEditable(false);
        birthProfile1.setBackground(new java.awt.Color(25, 41, 65));
        birthProfile1.setBorder(null);
        birthProfile1.setForeground(new java.awt.Color(19, 175, 248));
        birthProfile1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-M-d"))));
        birthProfile1.setToolTipText("yyy-mm-dd");
        birthProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        birthProfile1.setName(""); // NOI18N
        userProfilePage1.add(birthProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 131, 230, 40));

        titleDepartProfile1.setBackground(new java.awt.Color(55, 200, 255));
        titleDepartProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleDepartProfile1.setForeground(new java.awt.Color(236, 233, 233));
        titleDepartProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDepartProfile1.setText("Department :");
        userProfilePage1.add(titleDepartProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 130, 40));

        departProfile1.setBackground(new java.awt.Color(55, 200, 255));
        departProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        departProfile1.setForeground(new java.awt.Color(19, 175, 248));
        departProfile1.setText("School of Information Technology");
        userProfilePage1.add(departProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 330, 40));

        titleCongenProfile1.setBackground(new java.awt.Color(55, 200, 255));
        titleCongenProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleCongenProfile1.setForeground(new java.awt.Color(236, 233, 233));
        titleCongenProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCongenProfile1.setText("Congenitial Disease :");
        userProfilePage1.add(titleCongenProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 210, 40));

        congenProfile1.setEditable(false);
        congenProfile1.setBackground(new java.awt.Color(25, 41, 65));
        congenProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        congenProfile1.setForeground(new java.awt.Color(19, 175, 248));
        congenProfile1.setText("ภูมิแพ้");
        congenProfile1.setBorder(null);
        congenProfile1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userProfilePage1.add(congenProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 280, 40));

        titleContact1.setBackground(new java.awt.Color(13, 24, 35));
        titleContact1.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleContact1.setForeground(new java.awt.Color(255, 255, 255));
        titleContact1.setText("Contact");
        userProfilePage1.add(titleContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 30));

        titleEmailProfile1.setBackground(new java.awt.Color(55, 200, 255));
        titleEmailProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleEmailProfile1.setForeground(new java.awt.Color(236, 233, 233));
        titleEmailProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleEmailProfile1.setText("Email :");
        userProfilePage1.add(titleEmailProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 70, 20));

        emailProfile1.setEditable(false);
        emailProfile1.setBackground(new java.awt.Color(25, 41, 65));
        emailProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        emailProfile1.setForeground(new java.awt.Color(19, 175, 248));
        emailProfile1.setText("thanatta.o@mail.kmutt.ac.th");
        emailProfile1.setBorder(null);
        userProfilePage1.add(emailProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 380, 40));

        titleTelProfile1.setBackground(new java.awt.Color(55, 200, 255));
        titleTelProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleTelProfile1.setForeground(new java.awt.Color(236, 233, 233));
        titleTelProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTelProfile1.setText("Telephone :");
        userProfilePage1.add(titleTelProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 130, 40));

        telProfile1.setEditable(false);
        telProfile1.setBackground(new java.awt.Color(25, 41, 65));
        telProfile1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        telProfile1.setForeground(new java.awt.Color(19, 175, 248));
        telProfile1.setText("0900000000");
        telProfile1.setBorder(null);
        userProfilePage1.add(telProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 270, -1));

        chooseImgProfileBut1.setBackground(new java.awt.Color(126, 192, 237));
        chooseImgProfileBut1.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        chooseImgProfileBut1.setForeground(new java.awt.Color(255, 255, 255));
        chooseImgProfileBut1.setText("Choose Profile");
        chooseImgProfileBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgProfileBut1ActionPerformed(evt);
            }
        });
        userProfilePage1.add(chooseImgProfileBut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        pathImgProfile1.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        pathImgProfile1.setForeground(new java.awt.Color(255, 255, 255));
        pathImgProfile1.setText("No Select File.");
        userProfilePage1.add(pathImgProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 245, 80, -1));

        submitProfile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMini.png"))); // NOI18N
        submitProfile1.setContentAreaFilled(false);
        submitProfile1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitProfile1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitProfile1MouseExited(evt);
            }
        });
        submitProfile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitProfile1ActionPerformed(evt);
            }
        });
        userProfilePage1.add(submitProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 110, 50));

        warningProfile1.setBackground(new java.awt.Color(55, 200, 255));
        warningProfile1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        warningProfile1.setForeground(new java.awt.Color(255, 51, 51));
        warningProfile1.setText("Your name is incorrect");
        userProfilePage1.add(warningProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 150, 30));

        mainUser.add(userProfilePage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 420));

        timePageT.setBackground(new java.awt.Color(25, 41, 65));
        timePageT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timewatch.setBackground(new java.awt.Color(255, 255, 255));
        timewatch.setEnabled(false);
        timewatch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleNow.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNow.setText("Now:");
        timewatch.add(titleNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 70, 40));

        timeLeftShow.setFont(new java.awt.Font("Leelawadee", 0, 30)); // NOI18N
        timeLeftShow.setForeground(new java.awt.Color(255, 51, 51));
        timewatch.add(timeLeftShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 450, 40));

        endTime.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        timewatch.add(endTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 490, 20));

        iconClockBig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconClockBig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/clockBig.png"))); // NOI18N
        timewatch.add(iconClockBig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 130));

        timePageT.add(timewatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 660, 130));

        timeupPage.setBackground(new java.awt.Color(15, 30, 52));
        timeupPage.setEnabled(false);
        timeupPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleItemTimeUp.setFont(new java.awt.Font("Leelawadee", 0, 26)); // NOI18N
        titleItemTimeUp.setForeground(new java.awt.Color(255, 255, 255));
        titleItemTimeUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleItemTimeUp.setText("TIME'S UP");
        timeupPage.add(titleItemTimeUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 50));

        timeupInside.setBackground(new java.awt.Color(13, 24, 35));
        timeupInside.setEnabled(false);
        timeupInside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listTimeup.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        listTimeup.setForeground(new java.awt.Color(55, 200, 255));
        listTimeup.setText("-  B01    Amount  : 3");
        listTimeup.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        timeupInside.add(listTimeup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 430, 250));

        timeupPage.add(timeupInside, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 290));

        timePageT.add(timeupPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 510, 380));

        itemListShow.setBackground(new java.awt.Color(15, 30, 52));
        itemListShow.setEnabled(false);
        itemListShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemListShowInsidee.setBackground(new java.awt.Color(13, 24, 35));
        itemListShowInsidee.setEnabled(false);
        itemListShowInsidee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listShow.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        listShow.setForeground(new java.awt.Color(55, 200, 255));
        listShow.setText("-  B01    Amount  : 3");
        listShow.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        itemListShowInsidee.add(listShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 320, 160));

        titleItemListShow.setFont(new java.awt.Font("Leelawadee", 0, 22)); // NOI18N
        titleItemListShow.setForeground(new java.awt.Color(255, 255, 255));
        titleItemListShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleItemListShow.setText("Item List");
        itemListShowInsidee.add(titleItemListShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        itemListShow.add(itemListShowInsidee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 350, 200));

        timePageT.add(itemListShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 390, 220));

        mainUser.add(timePageT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 421));

        sharingScroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 41, 65), 1, true));

        sharingStep1.setBackground(new java.awt.Color(25, 41, 65));
        sharingStep1.setEnabled(false);
        sharingStep1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nextStep.setBackground(new java.awt.Color(25, 41, 65));
        nextStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/right arrow.png"))); // NOI18N
        nextStep.setContentAreaFilled(false);
        nextStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextStepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextStepMouseExited(evt);
            }
        });
        nextStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextStepActionPerformed(evt);
            }
        });
        sharingStep1.add(nextStep, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 60, 50));

        s1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        s1.setForeground(new java.awt.Color(255, 255, 255));
        s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/Step1.png"))); // NOI18N
        sharingStep1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 40));

        isCp.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        isCp.setForeground(new java.awt.Color(255, 255, 255));
        isCp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isCp.setText("Your CP : 1000 Points ");
        sharingStep1.add(isCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 180, 30));

        sharingScroll.setViewportView(sharingStep1);

        mainUser.add(sharingScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 58, 770, 422));

        timePageF.setBackground(new java.awt.Color(25, 41, 65));
        timePageF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textNotHis.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        textNotHis.setForeground(new java.awt.Color(255, 255, 255));
        textNotHis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textNotHis.setText("ยังไม่มีประวัติการยืม");
        timePageF.add(textNotHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 180, 40));

        iconNotHis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/notHis.png"))); // NOI18N
        timePageF.add(iconNotHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        mainUser.add(timePageF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 420));

        sharingStep3.setBackground(new java.awt.Color(25, 41, 65));
        sharingStep3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textYourCP.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        textYourCP.setForeground(new java.awt.Color(255, 255, 255));
        textYourCP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textYourCP.setText("Your CP :");
        sharingStep3.add(textYourCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 80, 20));

        cpUser.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        cpUser.setForeground(new java.awt.Color(255, 255, 255));
        cpUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cpUser.setText("1000");
        sharingStep3.add(cpUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 110, 20));
        sharingStep3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 110, 10));

        textRemain.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        textRemain.setForeground(new java.awt.Color(255, 255, 255));
        textRemain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textRemain.setText("Remaining Points : ");
        sharingStep3.add(textRemain, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 170, 40));

        point1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        point1.setForeground(new java.awt.Color(255, 255, 255));
        point1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1.setText("Points");
        sharingStep3.add(point1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 80, 20));

        textCpUse.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        textCpUse.setForeground(new java.awt.Color(255, 255, 255));
        textCpUse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textCpUse.setText("CP Use :");
        sharingStep3.add(textCpUse, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 80, 20));
        sharingStep3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 110, 10));

        cpUse.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        cpUse.setForeground(new java.awt.Color(255, 255, 255));
        cpUse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cpUse.setText("160");
        sharingStep3.add(cpUse, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 110, 20));

        point2.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        point2.setForeground(new java.awt.Color(255, 255, 255));
        point2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2.setText("Points");
        sharingStep3.add(point2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 80, 20));

        pointRemain.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        pointRemain.setForeground(new java.awt.Color(255, 255, 255));
        pointRemain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pointRemain.setText("840");
        pointRemain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        sharingStep3.add(pointRemain, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 40));

        point3.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        point3.setForeground(new java.awt.Color(255, 255, 255));
        point3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point3.setText("Points");
        sharingStep3.add(point3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 100, 40));

        detailBox.setBackground(new java.awt.Color(13, 24, 35));
        detailBox.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Borrow Detail", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Leelawadee", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        detailBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailData.setBackground(new java.awt.Color(13, 24, 35));
        detailData.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        detailData.setForeground(new java.awt.Color(55, 200, 255));
        detailData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        detailData.setToolTipText("detail");
        detailData.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detailBox.add(detailData, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 380, 180));

        sharingStep3.add(detailBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 460, 240));

        backStep1.setBackground(new java.awt.Color(25, 41, 65));
        backStep1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/left arrow.png"))); // NOI18N
        backStep1.setContentAreaFilled(false);
        backStep1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backStep1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backStep1MouseExited(evt);
            }
        });
        backStep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backStep1ActionPerformed(evt);
            }
        });
        sharingStep3.add(backStep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 60, 60));

        cancleBut.setBackground(new java.awt.Color(25, 41, 65));
        cancleBut.setForeground(new java.awt.Color(255, 255, 255));
        cancleBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancle.png"))); // NOI18N
        cancleBut.setToolTipText("cancle");
        cancleBut.setContentAreaFilled(false);
        cancleBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancleButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancleButMouseExited(evt);
            }
        });
        cancleBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButActionPerformed(evt);
            }
        });
        sharingStep3.add(cancleBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 60, 50));

        borrowBut.setBackground(new java.awt.Color(25, 41, 65));
        borrowBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/BorrowBut.png"))); // NOI18N
        borrowBut.setContentAreaFilled(false);
        borrowBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                borrowButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                borrowButMouseExited(evt);
            }
        });
        borrowBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowButActionPerformed(evt);
            }
        });
        sharingStep3.add(borrowBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 140, 60));

        s9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        s9.setForeground(new java.awt.Color(255, 255, 255));
        s9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/Step3.png"))); // NOI18N
        sharingStep3.add(s9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        mainUser.add(sharingStep3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 421));

        cpPage1.setBackground(new java.awt.Color(25, 41, 65));
        cpPage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showCp.setFont(new java.awt.Font("Leelawadee", 0, 80)); // NOI18N
        showCp.setForeground(new java.awt.Color(255, 255, 255));
        showCp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showCp.setText("200");
        cpPage1.add(showCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 310, 260));

        circleCp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        circleCp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/oval.png"))); // NOI18N
        cpPage1.add(circleCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 370, 350));

        History.setBackground(new java.awt.Color(13, 24, 35));
        History.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailBoxHistory.setBackground(new java.awt.Color(255, 255, 255));
        detailBoxHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        poinsHis.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        poinsHis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poinsHis.setText("200 Points");
        detailBoxHistory.add(poinsHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 116, 40));

        actionHis.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        actionHis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actionHis.setText("4 Cans");
        detailBoxHistory.add(actionHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 82, -1));

        History.add(detailBoxHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 230, -1));

        titleHistory.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        titleHistory.setForeground(new java.awt.Color(255, 255, 255));
        titleHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleHistory.setText("HISTORY");
        History.add(titleHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 270, -1));

        cpPage1.add(History, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 270, 110));

        point4.setFont(new java.awt.Font("Leelawadee", 0, 40)); // NOI18N
        point4.setForeground(new java.awt.Color(255, 255, 255));
        point4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point4.setText("Points");
        cpPage1.add(point4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 310, 210));

        mainUser.add(cpPage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 421));

        getContentPane().add(mainUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GreenSociety.setFont(new java.awt.Font("Leelawadee", 0, 48)); // NOI18N
        GreenSociety.setForeground(new java.awt.Color(255, 255, 255));
        GreenSociety.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GreenSociety.setText("Green Society");
        login.add(GreenSociety, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 340, 70));

        iconEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/mail.png"))); // NOI18N
        login.add(iconEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 30, 30));

        iconKey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/pass.png"))); // NOI18N
        login.add(iconKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 30, 30));

        email.setBackground(new java.awt.Color(17, 20, 25));
        email.setFont(new java.awt.Font("Leelawadee", 0, 15)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setText("Email");
        email.setBorder(null);
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        login.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 240, 30));

        sEmailG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sEmailG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/gray.png"))); // NOI18N
        login.add(sEmailG, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        sEmailB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sEmailB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/blue.png"))); // NOI18N
        login.add(sEmailB, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        showPass.setFont(new java.awt.Font("Leelawadee", 0, 15)); // NOI18N
        showPass.setForeground(new java.awt.Color(153, 153, 153));
        showPass.setText("Password");
        login.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 259, 70, 30));

        password.setBackground(new java.awt.Color(17, 20, 25));
        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        login.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 240, 30));

        sPassG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sPassG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/gray.png"))); // NOI18N
        login.add(sPassG, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 286, -1, 10));

        sPassB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sPassB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/blue.png"))); // NOI18N
        login.add(sPassB, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 286, -1, 10));

        warning.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warning.setForeground(new java.awt.Color(255, 51, 51));
        warning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warning.setText("Your username or password is incorrect.");
        login.add(warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 280, 20));

        signin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/signinBut.png"))); // NOI18N
        signin.setContentAreaFilled(false);
        signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signinMouseExited(evt);
            }
        });
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        login.add(signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 300, 30));

        backLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/backLogin.PNG"))); // NOI18N
        backLogin.setLabelFor(this);
        login.add(backLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        menuSignup.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        menuSignup.setForeground(new java.awt.Color(255, 255, 255));
        menuSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSignup.setText("Sign Up");
        menuSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSignupMouseClicked(evt);
            }
        });
        login.add(menuSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 60, 30));

        forgotPass.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        forgotPass.setForeground(new java.awt.Color(204, 204, 204));
        forgotPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPass.setText("Forgot Password?");
        forgotPass.setToolTipText("");
        forgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPassMouseClicked(evt);
            }
        });
        login.add(forgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 120, 30));

        titleSignup.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        titleSignup.setForeground(new java.awt.Color(102, 102, 102));
        titleSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSignup.setText("Don't have an account? ");
        titleSignup.setToolTipText("");
        login.add(titleSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 140, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/background.jpg"))); // NOI18N
        login.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        forgotPassPage.setBackground(new java.awt.Color(255, 255, 255));
        forgotPassPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputForgot.setBackground(new java.awt.Color(0, 0, 0));
        inputForgot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleForgotPass.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleForgotPass.setForeground(new java.awt.Color(255, 255, 255));
        titleForgotPass.setText("Forgot Password");
        inputForgot.add(titleForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 199, 50));
        inputForgot.add(s10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 480, -1));

        titleEmail.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        titleEmail.setForeground(new java.awt.Color(114, 118, 120));
        titleEmail.setText("Your Email");
        inputForgot.add(titleEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 80, 30));

        forgotEmail.setBackground(new java.awt.Color(0, 0, 0));
        forgotEmail.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        forgotEmail.setForeground(new java.awt.Color(153, 153, 153));
        forgotEmail.setText("Email");
        forgotEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        forgotEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                forgotEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                forgotEmailFocusLost(evt);
            }
        });
        inputForgot.add(forgotEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 340, 30));

        titleNewPass.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        titleNewPass.setForeground(new java.awt.Color(114, 118, 120));
        titleNewPass.setText("New Password");
        inputForgot.add(titleNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 100, 30));

        titleConPass.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        titleConPass.setForeground(new java.awt.Color(114, 118, 120));
        titleConPass.setText("Confirm Password");
        inputForgot.add(titleConPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 120, 30));

        jPasswordField1.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        inputForgot.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 340, 30));

        jPasswordField2.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        inputForgot.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 340, 30));

        submitPass.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        submitPass.setForeground(new java.awt.Color(114, 118, 120));
        submitPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submitPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitPass.png"))); // NOI18N
        submitPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitPassMouseExited(evt);
            }
        });
        inputForgot.add(submitPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 360, 40));

        star1.setBackground(new java.awt.Color(0, 0, 0));
        star1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        star1.setForeground(new java.awt.Color(19, 175, 248));
        star1.setText("*");
        inputForgot.add(star1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 30, 20));

        star2.setBackground(new java.awt.Color(0, 0, 0));
        star2.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        star2.setForeground(new java.awt.Color(19, 175, 248));
        star2.setText("*");
        inputForgot.add(star2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 30, 20));

        star3.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        star3.setForeground(new java.awt.Color(19, 175, 248));
        star3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star3.setText("*");
        inputForgot.add(star3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 20, 20));

        forgotPassPage.add(inputForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 520, 360));

        backSignin.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        backSignin.setForeground(new java.awt.Color(255, 255, 255));
        backSignin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backSignin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/backStepLogin.png"))); // NOI18N
        backSignin.setText("   Back to Sign in");
        backSignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSigninMouseClicked(evt);
            }
        });
        forgotPassPage.add(backSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        Background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/background.jpg"))); // NOI18N
        forgotPassPage.add(Background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(forgotPassPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        registerPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backSigninRegis.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        backSigninRegis.setForeground(new java.awt.Color(255, 255, 255));
        backSigninRegis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backSigninRegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/backStepLogin.png"))); // NOI18N
        backSigninRegis.setText("   Back to Sign in");
        backSigninRegis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSigninRegisMouseClicked(evt);
            }
        });
        registerPage.add(backSigninRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        jPanelSignUp.setBackground(new java.awt.Color(0, 0, 0));
        jPanelSignUp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbSignUp.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLbSignUp.setForeground(new java.awt.Color(255, 255, 255));
        jLbSignUp.setText("SignUp");
        jPanelSignUp.add(jLbSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 195, 40));
        jPanelSignUp.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 640, 10));

        jTextFieldTelophone.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldTelophone.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jTextFieldTelophone.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldTelophone.setText("090xxxxxxx");
        jTextFieldTelophone.setToolTipText("");
        jTextFieldTelophone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldTelophone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTelophoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTelophoneFocusLost(evt);
            }
        });
        jPanelSignUp.add(jTextFieldTelophone, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 240, 30));

        jTfFirstName.setBackground(new java.awt.Color(0, 0, 0));
        jTfFirstName.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jTfFirstName.setForeground(new java.awt.Color(102, 102, 102));
        jTfFirstName.setText("John");
        jTfFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTfFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTfFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTfFirstNameFocusLost(evt);
            }
        });
        jPanelSignUp.add(jTfFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 230, 30));

        jLbLastName.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbLastName.setForeground(new java.awt.Color(255, 255, 255));
        jLbLastName.setText("LastName");
        jPanelSignUp.add(jLbLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 60, 20));

        jLbDateOfBirth.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbDateOfBirth.setForeground(new java.awt.Color(255, 255, 255));
        jLbDateOfBirth.setText("Date of Birth");
        jPanelSignUp.add(jLbDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 70, 20));

        jLabelStarLN.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLabelStarLN.setForeground(new java.awt.Color(19, 175, 248));
        jLabelStarLN.setText("*");
        jLabelStarLN.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLabelStarLN, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 30, 30));

        jComboBoxPosition.setBackground(new java.awt.Color(0, 0, 0));
        jComboBoxPosition.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jComboBoxPosition.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือก..", "นักศึกษา ", "อาจารย์และบุคลากร ", "ช่าง ", "เจ้าหน้าที่" }));
        jPanelSignUp.add(jComboBoxPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 240, 30));

        jLbGender.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbGender.setForeground(new java.awt.Color(255, 255, 255));
        jLbGender.setText("Gender");
        jPanelSignUp.add(jLbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 40, 20));

        jLbPassWord.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbPassWord.setForeground(new java.awt.Color(255, 255, 255));
        jLbPassWord.setText("Password");
        jPanelSignUp.add(jLbPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 50, 20));

        jTextFieldSurname.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldSurname.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jTextFieldSurname.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldSurname.setText("Wick");
        jTextFieldSurname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldSurname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSurnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSurnameFocusLost(evt);
            }
        });
        jPanelSignUp.add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 240, 30));

        jLbFirstName.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbFirstName.setForeground(new java.awt.Color(255, 255, 255));
        jLbFirstName.setText("FirstName");
        jPanelSignUp.add(jLbFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 60, 20));

        jLbStarId.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarId.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarId.setText("*");
        jLbStarId.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 30, 30));

        jLbStarFirstName.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarFirstName.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarFirstName.setText("*");
        jLbStarFirstName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 20, 20));

        jLbStarGender.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarGender.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarGender.setText("*");
        jLbStarGender.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 30, 20));

        jLbStarBirthDay.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarBirthDay.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarBirthDay.setText("*");
        jLbStarBirthDay.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarBirthDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 30, 30));

        jLbStarPassword.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarPassword.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarPassword.setText("*");
        jLbStarPassword.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 30, 30));

        jLbPosition.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbPosition.setForeground(new java.awt.Color(255, 255, 255));
        jLbPosition.setText("Position");
        jPanelSignUp.add(jLbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 50, 20));

        jLbStarPosition.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarPosition.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarPosition.setText("*");
        jLbStarPosition.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 30, 30));

        jLbCongenitialDisease.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbCongenitialDisease.setForeground(new java.awt.Color(255, 255, 255));
        jLbCongenitialDisease.setText("Congenitial Disease (โรคประจำตัว)");
        jPanelSignUp.add(jLbCongenitialDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 200, 20));

        jTextFieldEmail.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldEmail.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setText("example@gmail.com");
        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusLost(evt);
            }
        });
        jPanelSignUp.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 540, 30));

        jLbTelophone.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbTelophone.setForeground(new java.awt.Color(255, 255, 255));
        jLbTelophone.setText("Telophone");
        jPanelSignUp.add(jLbTelophone, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 60, 20));

        jLbStarTelophone.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarTelophone.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarTelophone.setText("*");
        jLbStarTelophone.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarTelophone, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 30, 30));

        jTextFieldConDisease.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldConDisease.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldConDisease.setText("If you have");
        jTextFieldConDisease.setToolTipText("");
        jTextFieldConDisease.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldConDisease.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldConDiseaseFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldConDiseaseFocusLost(evt);
            }
        });
        jPanelSignUp.add(jTextFieldConDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 240, 30));

        jLbEmail.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLbEmail.setText("E-Mail");
        jPanelSignUp.add(jLbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 40, 20));

        jLbStarEmail.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarEmail.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarEmail.setText("*");
        jLbStarEmail.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 30, 30));

        jPasswordSignUp.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordSignUp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPasswordSignUp.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordSignUp.setText("Oldpassword");
        jPasswordSignUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPasswordSignUp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordSignUpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordSignUpFocusLost(evt);
            }
        });
        jPanelSignUp.add(jPasswordSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 240, 30));

        jPasswordConfirmPassSignup.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordConfirmPassSignup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPasswordConfirmPassSignup.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordConfirmPassSignup.setText("Newpassword");
        jPasswordConfirmPassSignup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPasswordConfirmPassSignup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordConfirmPassSignupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordConfirmPassSignupFocusLost(evt);
            }
        });
        jPanelSignUp.add(jPasswordConfirmPassSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 240, 30));

        jLbConfirmPassWord.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbConfirmPassWord.setForeground(new java.awt.Color(255, 255, 255));
        jLbConfirmPassWord.setText("Comfirm Password");
        jPanelSignUp.add(jLbConfirmPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 100, 20));

        jLbStarConfirmPass.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbStarConfirmPass.setForeground(new java.awt.Color(19, 175, 248));
        jLbStarConfirmPass.setText("*");
        jLbStarConfirmPass.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanelSignUp.add(jLbStarConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 30, 30));

        jButtonSignUp.setBackground(new java.awt.Color(0, 255, 255));
        jButtonSignUp.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jButtonSignUp.setForeground(new java.awt.Color(51, 51, 51));
        jButtonSignUp.setText("SIGN UP");
        jButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignUpActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jButtonSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 100, 30));

        jRadioButtonGenderFemale.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonGenderFemale.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jRadioButtonGenderFemale.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonGenderFemale.setText("Female");
        jRadioButtonGenderFemale.setDisplayedMnemonicIndex(0);
        jRadioButtonGenderFemale.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButtonGenderFemaleFocusGained(evt);
            }
        });
        jPanelSignUp.add(jRadioButtonGenderFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, -1));

        jRadioButtonGenderMale.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonGenderMale.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jRadioButtonGenderMale.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonGenderMale.setText("Male");
        jRadioButtonGenderMale.setDisplayedMnemonicIndex(1);
        jRadioButtonGenderMale.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButtonGenderMaleFocusGained(evt);
            }
        });
        jPanelSignUp.add(jRadioButtonGenderMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jLabelPictureProfileRegister.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLabelPictureProfileRegister.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPictureProfileRegister.setText("Picture Profile: ");
        jPanelSignUp.add(jLabelPictureProfileRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, 20));

        jButtonChooseFileForUpload.setBackground(new java.awt.Color(0, 204, 255));
        jButtonChooseFileForUpload.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jButtonChooseFileForUpload.setForeground(new java.awt.Color(255, 255, 255));
        jButtonChooseFileForUpload.setText("Choose File");
        jButtonChooseFileForUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseFileForUploadActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jButtonChooseFileForUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 100, -1));

        jLabelPartPictureUserUpload.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLabelPartPictureUserUpload.setForeground(new java.awt.Color(102, 102, 102));
        jLabelPartPictureUserUpload.setText("Not Select File");
        jLabelPartPictureUserUpload.setToolTipText("");
        jPanelSignUp.add(jLabelPartPictureUserUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 160, 20));

        jLbId.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jLbId.setForeground(new java.awt.Color(255, 255, 255));
        jLbId.setText("ID");
        jPanelSignUp.add(jLbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 20, 20));

        jLabelEmailNotCorrect.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelEmailNotCorrect.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelEmailNotCorrect, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 280, 20));

        jLabelNoticSurname.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticSurname.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 180, 20));

        jLabelifLengthId.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelifLengthId.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelifLengthId, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 220, 20));

        jLabelNoticNewPass.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticNewPass.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 130, 20));

        jLabelNoticName.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticName.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 180, 20));

        jLabelNoticGender.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticGender.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 180, 20));

        jLabelNoticBirthDate.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticBirthDate.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 160, 20));

        jLabelNoticPosition.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticPosition.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 180, 20));

        jLabelNoticTel.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticTel.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 170, 20));

        jLabelNoticOldPass.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        jLabelNoticOldPass.setForeground(new java.awt.Color(255, 0, 0));
        jPanelSignUp.add(jLabelNoticOldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 180, 20));

        jDateChooserBirthDate.setBackground(new java.awt.Color(0, 0, 0));
        jDateChooserBirthDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSignUp.add(jDateChooserBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 240, 30));

        jFormatTextFieldForId.setBackground(new java.awt.Color(0, 0, 0));
        jFormatTextFieldForId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jFormatTextFieldForId.setForeground(new java.awt.Color(102, 102, 102));
        jFormatTextFieldForId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("00000000000"))));
        jFormatTextFieldForId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormatTextFieldForIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormatTextFieldForIdFocusLost(evt);
            }
        });
        jPanelSignUp.add(jFormatTextFieldForId, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 240, 30));

        registerPage.add(jPanelSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 680, 500));

        Backgroung2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/background.jpg"))); // NOI18N
        Backgroung2.setText("jLabel1");
        registerPage.add(Backgroung2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        getContentPane().add(registerPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        mainAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barSearch.setBackground(new java.awt.Color(13, 24, 35));
        barSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        barSearch.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 120, 40));

        iconSearch.setFont(new java.awt.Font("Leelawadee UI", 0, 20)); // NOI18N
        iconSearch.setForeground(new java.awt.Color(255, 255, 255));
        iconSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/search.png"))); // NOI18N
        iconSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconSearchMouseClicked(evt);
            }
        });
        barSearch.add(iconSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 60, 50));

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Leelawadee", 0, 30)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("GREEN  SOCIETY");
        title.setToolTipText("");
        barSearch.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 60));

        search.setBackground(new java.awt.Color(13, 24, 35));
        search.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.setBorder(null);
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        barSearch.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 120, 30));

        mainAdmin.add(barSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 900, 60));

        backMenuBar.setBackground(new java.awt.Color(22, 31, 39));
        backMenuBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuBar.setBackground(new java.awt.Color(13, 24, 35));
        menuBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        news.setBackground(new java.awt.Color(0, 0, 0));
        news.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        news.setForeground(new java.awt.Color(255, 255, 255));
        news.setText("     News");
        news.setToolTipText("");
        news.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBar.add(news, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 20));

        bikeRepair.setBackground(new java.awt.Color(0, 0, 0));
        bikeRepair.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        bikeRepair.setForeground(new java.awt.Color(255, 255, 255));
        bikeRepair.setText("     Bike Repairing");
        bikeRepair.setToolTipText("");
        bikeRepair.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBar.add(bikeRepair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 140, 20));

        canCounter.setBackground(new java.awt.Color(0, 0, 0));
        canCounter.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        canCounter.setForeground(new java.awt.Color(255, 255, 255));
        canCounter.setText("     Can Counter");
        canCounter.setToolTipText("");
        canCounter.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        canCounter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canCounterMouseClicked(evt);
            }
        });
        menuBar.add(canCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, 20));

        bikeSharing.setBackground(new java.awt.Color(255, 255, 255));
        bikeSharing.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        bikeSharing.setForeground(new java.awt.Color(255, 255, 255));
        bikeSharing.setText("     Bike Sharing");
        bikeSharing.setToolTipText("");
        bikeSharing.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bikeSharing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bikeSharingMouseClicked(evt);
            }
        });
        menuBar.add(bikeSharing, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 140, 20));

        history.setBackground(new java.awt.Color(0, 0, 0));
        history.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        history.setForeground(new java.awt.Color(255, 255, 255));
        history.setText("     History");
        history.setToolTipText("");
        history.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBar.add(history, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, 20));

        profile.setBackground(new java.awt.Color(0, 0, 0));
        profile.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setText("     PROFILE");
        profile.setToolTipText("");
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        menuBar.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 140, 30));

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("MENU");
        menu.setToolTipText("");
        menuBar.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 30));

        timer.setBackground(new java.awt.Color(0, 0, 0));
        timer.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        timer.setForeground(new java.awt.Color(255, 255, 255));
        timer.setText("     Timer");
        timer.setToolTipText("");
        timer.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        timer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timerMouseClicked(evt);
            }
        });
        menuBar.add(timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, 20));

        support.setBackground(new java.awt.Color(0, 0, 0));
        support.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        support.setForeground(new java.awt.Color(255, 255, 255));
        support.setText("     Support");
        support.setToolTipText("");
        support.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBar.add(support, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, 20));

        titleSignout.setBackground(new java.awt.Color(0, 0, 0));
        titleSignout.setFont(new java.awt.Font("Leelawadee", 0, 13)); // NOI18N
        titleSignout.setForeground(new java.awt.Color(255, 255, 255));
        titleSignout.setText("     SIGN OUT");
        titleSignout.setToolTipText("");
        menuBar.add(titleSignout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 140, 30));

        arrowDownIcon.setBackground(new java.awt.Color(0, 0, 0));
        arrowDownIcon.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        arrowDownIcon.setForeground(new java.awt.Color(255, 255, 255));
        arrowDownIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowDownIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/chevron-arrow-down.png"))); // NOI18N
        arrowDownIcon.setToolTipText("");
        menuBar.add(arrowDownIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, 30));

        backMenuBar.add(menuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        mainAdmin.add(backMenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 150, 480));

        barUser.setBackground(new java.awt.Color(19, 175, 248));
        barUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barUser.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        name.setBackground(new java.awt.Color(0, 0, 0));
        name.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        name.setForeground(new java.awt.Color(13, 24, 35));
        name.setText("NAME");
        name.setToolTipText("");
        name.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        barUser.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 50));

        position.setBackground(new java.awt.Color(0, 0, 0));
        position.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        position.setForeground(new java.awt.Color(255, 255, 255));
        position.setText("Student");
        position.setToolTipText("");
        position.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        barUser.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, 50));

        mainAdmin.add(barUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 200, 60));

        backBarUser.setBackground(new java.awt.Color(55, 200, 255));
        backBarUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mainAdmin.add(backBarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 210, 60));

        backBarIcon.setBackground(new java.awt.Color(55, 200, 255));
        backBarIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barIcon.setBackground(new java.awt.Color(19, 175, 248));
        barIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/menu.png"))); // NOI18N
        barIcon.add(iconMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 50, 30));

        iconBike.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconBike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/bike.png"))); // NOI18N
        barIcon.add(iconBike, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        iconProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/profile-user.png"))); // NOI18N
        barIcon.add(iconProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 50, 50));

        signout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/signout.png"))); // NOI18N
        signout.setContentAreaFilled(false);
        signout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signoutMouseExited(evt);
            }
        });
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });
        barIcon.add(signout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 50, 50));

        backBarIcon.add(barIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 540));

        mainAdmin.add(backBarIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 540));

        barNoti.setBackground(new java.awt.Color(13, 24, 35));
        barNoti.setLayout(null);
        mainAdmin.add(barNoti, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 770, 60));

        userProfilePage.setBackground(new java.awt.Color(25, 41, 65));
        userProfilePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editProfileBut.setBackground(new java.awt.Color(126, 192, 237));
        editProfileBut.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        editProfileBut.setForeground(new java.awt.Color(255, 255, 255));
        editProfileBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/editProfile.png"))); // NOI18N
        editProfileBut.setContentAreaFilled(false);
        editProfileBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editProfileButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editProfileButMouseExited(evt);
            }
        });
        editProfileBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButActionPerformed(evt);
            }
        });
        userProfilePage.add(editProfileBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 3, 110, 40));

        titleUserId.setBackground(new java.awt.Color(55, 200, 255));
        titleUserId.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        titleUserId.setForeground(new java.awt.Color(255, 255, 255));
        titleUserId.setText("User ID :");
        userProfilePage.add(titleUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, -1));

        userID.setBackground(new java.awt.Color(55, 200, 255));
        userID.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        userID.setForeground(new java.awt.Color(19, 175, 248));
        userID.setText("1");
        userID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        userProfilePage.add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 60, 20));
        userProfilePage.add(imageProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 170));

        titleAbout.setBackground(new java.awt.Color(13, 24, 35));
        titleAbout.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleAbout.setForeground(new java.awt.Color(255, 255, 255));
        titleAbout.setText("ABOUT");
        userProfilePage.add(titleAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        titleNameProfile.setBackground(new java.awt.Color(55, 200, 255));
        titleNameProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleNameProfile.setForeground(new java.awt.Color(236, 233, 233));
        titleNameProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNameProfile.setText("Name :");
        userProfilePage.add(titleNameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 80, 20));

        nameProfile.setEditable(false);
        nameProfile.setBackground(new java.awt.Color(25, 41, 65));
        nameProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        nameProfile.setForeground(new java.awt.Color(19, 175, 248));
        nameProfile.setText("Thanatta  Opatkajonyos");
        nameProfile.setBorder(null);
        userProfilePage.add(nameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 380, 40));

        titleGenderProfile.setBackground(new java.awt.Color(55, 200, 255));
        titleGenderProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleGenderProfile.setForeground(new java.awt.Color(236, 233, 233));
        titleGenderProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleGenderProfile.setText("Gender :");
        userProfilePage.add(titleGenderProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 90, 20));

        genderProfile.setEditable(false);
        genderProfile.setBackground(new java.awt.Color(25, 41, 65));
        genderProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        genderProfile.setForeground(new java.awt.Color(19, 175, 248));
        genderProfile.setText("F");
        genderProfile.setBorder(null);
        userProfilePage.add(genderProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 70, 20));

        titlebBirthProfile.setBackground(new java.awt.Color(55, 200, 255));
        titlebBirthProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titlebBirthProfile.setForeground(new java.awt.Color(236, 233, 233));
        titlebBirthProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlebBirthProfile.setText("Birthday :");
        userProfilePage.add(titlebBirthProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 100, 40));

        birthProfile.setEditable(false);
        birthProfile.setBackground(new java.awt.Color(25, 41, 65));
        birthProfile.setBorder(null);
        birthProfile.setForeground(new java.awt.Color(19, 175, 248));
        birthProfile.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-M-d"))));
        birthProfile.setToolTipText("yyy-mm-dd");
        birthProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        birthProfile.setName(""); // NOI18N
        userProfilePage.add(birthProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 220, -1));

        titleDepartProfile.setBackground(new java.awt.Color(55, 200, 255));
        titleDepartProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleDepartProfile.setForeground(new java.awt.Color(236, 233, 233));
        titleDepartProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDepartProfile.setText("Department :");
        userProfilePage.add(titleDepartProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 130, 40));

        departProfile.setBackground(new java.awt.Color(55, 200, 255));
        departProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        departProfile.setForeground(new java.awt.Color(19, 175, 248));
        departProfile.setText("School of Information Technology");
        userProfilePage.add(departProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 330, 40));

        titleCongenProfile.setBackground(new java.awt.Color(55, 200, 255));
        titleCongenProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleCongenProfile.setForeground(new java.awt.Color(236, 233, 233));
        titleCongenProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCongenProfile.setText("Congenitial Disease :");
        userProfilePage.add(titleCongenProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 210, 40));

        congenProfile.setEditable(false);
        congenProfile.setBackground(new java.awt.Color(25, 41, 65));
        congenProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        congenProfile.setForeground(new java.awt.Color(19, 175, 248));
        congenProfile.setText("ภูมิแพ้");
        congenProfile.setBorder(null);
        congenProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userProfilePage.add(congenProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 280, 40));

        titleContact.setBackground(new java.awt.Color(13, 24, 35));
        titleContact.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleContact.setForeground(new java.awt.Color(255, 255, 255));
        titleContact.setText("Contact");
        userProfilePage.add(titleContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 30));

        titleEmailProfile.setBackground(new java.awt.Color(55, 200, 255));
        titleEmailProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleEmailProfile.setForeground(new java.awt.Color(236, 233, 233));
        titleEmailProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleEmailProfile.setText("Email :");
        userProfilePage.add(titleEmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 70, 20));

        emailProfile.setEditable(false);
        emailProfile.setBackground(new java.awt.Color(25, 41, 65));
        emailProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        emailProfile.setForeground(new java.awt.Color(19, 175, 248));
        emailProfile.setText("thanatta.o@mail.kmutt.ac.th");
        emailProfile.setBorder(null);
        userProfilePage.add(emailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 380, 40));

        titleTelProfile.setBackground(new java.awt.Color(55, 200, 255));
        titleTelProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleTelProfile.setForeground(new java.awt.Color(236, 233, 233));
        titleTelProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTelProfile.setText("Telephone :");
        userProfilePage.add(titleTelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 130, 40));

        telProfile.setEditable(false);
        telProfile.setBackground(new java.awt.Color(25, 41, 65));
        telProfile.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        telProfile.setForeground(new java.awt.Color(19, 175, 248));
        telProfile.setText("0900000000");
        telProfile.setBorder(null);
        userProfilePage.add(telProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 270, -1));

        chooseImgProfileBut.setBackground(new java.awt.Color(126, 192, 237));
        chooseImgProfileBut.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        chooseImgProfileBut.setForeground(new java.awt.Color(255, 255, 255));
        chooseImgProfileBut.setText("Choose Profile");
        chooseImgProfileBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgProfileButActionPerformed(evt);
            }
        });
        userProfilePage.add(chooseImgProfileBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        pathImgProfile.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        pathImgProfile.setForeground(new java.awt.Color(255, 255, 255));
        pathImgProfile.setText("No Select File.");
        userProfilePage.add(pathImgProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 245, 80, -1));

        submitProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMini.png"))); // NOI18N
        submitProfile.setContentAreaFilled(false);
        submitProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitProfileMouseExited(evt);
            }
        });
        submitProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitProfileActionPerformed(evt);
            }
        });
        userProfilePage.add(submitProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 110, 50));

        warningProfile.setBackground(new java.awt.Color(55, 200, 255));
        warningProfile.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        warningProfile.setForeground(new java.awt.Color(255, 51, 51));
        warningProfile.setText("Your name is incorrect");
        userProfilePage.add(warningProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 150, 30));

        mainAdmin.add(userProfilePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 420));

        cpPage.setBackground(new java.awt.Color(25, 41, 65));
        cpPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleCountCan.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleCountCan.setForeground(new java.awt.Color(255, 255, 255));
        titleCountCan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCountCan.setText("Count of Can :");
        cpPage.add(titleCountCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 130, 40));

        titleNameUser.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleNameUser.setForeground(new java.awt.Color(255, 255, 255));
        titleNameUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNameUser.setText("Firstname User :");
        cpPage.add(titleNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 160, 60));

        s3.setForeground(new java.awt.Color(255, 255, 255));
        cpPage.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 240, 10));

        s4.setForeground(new java.awt.Color(255, 255, 255));
        cpPage.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 240, 10));

        nameOfUser.setBackground(new java.awt.Color(25, 41, 65));
        nameOfUser.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        nameOfUser.setForeground(new java.awt.Color(153, 153, 153));
        nameOfUser.setText("    Name");
        nameOfUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameOfUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameOfUserFocusLost(evt);
            }
        });
        cpPage.add(nameOfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 230, 30));

        countOfCan.setBackground(new java.awt.Color(25, 41, 65));
        countOfCan.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        countOfCan.setForeground(new java.awt.Color(153, 153, 153));
        countOfCan.setText("    Count");
        countOfCan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countOfCanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                countOfCanFocusLost(evt);
            }
        });
        cpPage.add(countOfCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 240, 30));

        submitBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submit.png"))); // NOI18N
        submitBut.setContentAreaFilled(false);
        submitBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButMouseExited(evt);
            }
        });
        submitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButActionPerformed(evt);
            }
        });
        cpPage.add(submitBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 150, -1));

        cancleAdminBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancleBut.png"))); // NOI18N
        cancleAdminBut.setContentAreaFilled(false);
        cancleAdminBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancleAdminButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancleAdminButMouseExited(evt);
            }
        });
        cancleAdminBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleAdminButActionPerformed(evt);
            }
        });
        cpPage.add(cancleAdminBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 160, -1));

        titleLastname.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        titleLastname.setForeground(new java.awt.Color(255, 255, 255));
        titleLastname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLastname.setText("Lastname User :");
        cpPage.add(titleLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 160, 60));

        surnameOfUser.setBackground(new java.awt.Color(25, 41, 65));
        surnameOfUser.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        surnameOfUser.setForeground(new java.awt.Color(153, 153, 153));
        surnameOfUser.setText("    Surname");
        surnameOfUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                surnameOfUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                surnameOfUserFocusLost(evt);
            }
        });
        cpPage.add(surnameOfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 230, 30));

        s5.setForeground(new java.awt.Color(255, 255, 255));
        cpPage.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 240, 10));

        mainAdmin.add(cpPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 421));

        sharingPage.setBackground(new java.awt.Color(25, 41, 65));
        sharingPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuSharing.setBackground(new java.awt.Color(13, 24, 35));
        menuSharing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuAdd.setBackground(new java.awt.Color(13, 24, 35));
        menuAdd.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        menuAdd.setForeground(new java.awt.Color(102, 102, 102));
        menuAdd.setText("Add Item");
        menuAdd.setToolTipText("");
        menuAdd.setContentAreaFilled(false);
        menuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddActionPerformed(evt);
            }
        });
        menuSharing.add(menuAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 50));

        menuEdit.setBackground(new java.awt.Color(13, 24, 35));
        menuEdit.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        menuEdit.setForeground(new java.awt.Color(102, 102, 102));
        menuEdit.setText("Edit Item");
        menuEdit.setToolTipText("");
        menuEdit.setContentAreaFilled(false);
        menuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditActionPerformed(evt);
            }
        });
        menuSharing.add(menuEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 10, 120, 50));

        menuDelete.setBackground(new java.awt.Color(25, 41, 65));
        menuDelete.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        menuDelete.setForeground(new java.awt.Color(102, 102, 102));
        menuDelete.setText("Delete Item");
        menuDelete.setToolTipText("");
        menuDelete.setContentAreaFilled(false);
        menuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteActionPerformed(evt);
            }
        });
        menuSharing.add(menuDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 50));

        backAdd.setBackground(new java.awt.Color(25, 41, 65));

        javax.swing.GroupLayout backAddLayout = new javax.swing.GroupLayout(backAdd);
        backAdd.setLayout(backAddLayout);
        backAddLayout.setHorizontalGroup(
            backAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        backAddLayout.setVerticalGroup(
            backAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        menuSharing.add(backAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, -1));

        backEdit.setBackground(new java.awt.Color(25, 41, 65));

        javax.swing.GroupLayout backEditLayout = new javax.swing.GroupLayout(backEdit);
        backEdit.setLayout(backEditLayout);
        backEditLayout.setHorizontalGroup(
            backEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        backEditLayout.setVerticalGroup(
            backEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        menuSharing.add(backEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 130, -1));

        backDelete.setBackground(new java.awt.Color(25, 41, 65));

        javax.swing.GroupLayout backDeleteLayout = new javax.swing.GroupLayout(backDelete);
        backDelete.setLayout(backDeleteLayout);
        backDeleteLayout.setHorizontalGroup(
            backDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        backDeleteLayout.setVerticalGroup(
            backDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        menuSharing.add(backDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 140, -1));

        sharingPage.add(menuSharing, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        sharingPageTab.setBackground(new java.awt.Color(25, 41, 65));
        sharingPageTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layerAddItem.setBackground(new java.awt.Color(13, 24, 35));
        layerAddItem.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Add Item", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Leelawadee", 0, 20), new java.awt.Color(3, 153, 223))); // NOI18N
        layerAddItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleItemId.setBackground(new java.awt.Color(255, 255, 255));
        titleItemId.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        titleItemId.setForeground(new java.awt.Color(255, 255, 255));
        titleItemId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleItemId.setText("Item ID :");
        layerAddItem.add(titleItemId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, 40));
        layerAddItem.add(s6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 150, 10));
        layerAddItem.add(s7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 170, 10));

        titleItemName.setBackground(new java.awt.Color(255, 255, 255));
        titleItemName.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        titleItemName.setForeground(new java.awt.Color(255, 255, 255));
        titleItemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleItemName.setText("Item Name :");
        layerAddItem.add(titleItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 30));

        itemName.setBackground(new java.awt.Color(13, 24, 35));
        itemName.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        itemName.setForeground(new java.awt.Color(153, 153, 153));
        itemName.setText("Name");
        itemName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemNameFocusLost(evt);
            }
        });
        layerAddItem.add(itemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, 30));

        titleItemCount.setBackground(new java.awt.Color(255, 255, 255));
        titleItemCount.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        titleItemCount.setForeground(new java.awt.Color(255, 255, 255));
        titleItemCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleItemCount.setText("Item Amount :");
        layerAddItem.add(titleItemCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 130, 30));
        layerAddItem.add(s8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 150, 20));

        itemAmount.setBackground(new java.awt.Color(13, 24, 35));
        itemAmount.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        itemAmount.setForeground(new java.awt.Color(153, 153, 153));
        itemAmount.setText("Count");
        itemAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemAmountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemAmountFocusLost(evt);
            }
        });
        layerAddItem.add(itemAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 140, 30));

        submitButSharing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMini.png"))); // NOI18N
        submitButSharing.setContentAreaFilled(false);
        submitButSharing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButSharingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButSharingMouseExited(evt);
            }
        });
        submitButSharing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButSharingActionPerformed(evt);
            }
        });
        layerAddItem.add(submitButSharing, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 110, -1));

        cancleButSharing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancleMini.png"))); // NOI18N
        cancleButSharing.setContentAreaFilled(false);
        cancleButSharing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancleButSharingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancleButSharingMouseExited(evt);
            }
        });
        cancleButSharing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButSharingActionPerformed(evt);
            }
        });
        layerAddItem.add(cancleButSharing, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 90, 40));

        itemId.setEditable(false);
        itemId.setBackground(new java.awt.Color(13, 24, 35));
        itemId.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        itemId.setForeground(new java.awt.Color(153, 153, 153));
        itemId.setText("ID");
        itemId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemIdFocusLost(evt);
            }
        });
        layerAddItem.add(itemId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, 30));

        notiSharing.setBackground(new java.awt.Color(13, 24, 35));
        notiSharing.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        notiSharing.setForeground(new java.awt.Color(130, 255, 134));
        notiSharing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notiSharing.setText("Success!!!");
        notiSharing.setToolTipText("");
        layerAddItem.add(notiSharing, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 310, 30));

        itemList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/itemList.png"))); // NOI18N
        itemList.setToolTipText("Item List");
        itemList.setContentAreaFilled(false);
        itemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itemListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                itemListMouseExited(evt);
            }
        });
        itemList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListActionPerformed(evt);
            }
        });
        layerAddItem.add(itemList, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 50, -1));

        sharingPageTab.add(layerAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 350, 270));

        itemListScroll.setBackground(new java.awt.Color(13, 24, 35));

        itemListPage.setBackground(new java.awt.Color(13, 24, 35));
        itemListPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleItemList.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleItemList.setForeground(new java.awt.Color(255, 255, 255));
        titleItemList.setText("Item List");
        itemListPage.add(titleItemList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 60));

        closeBut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/delete-button.png"))); // NOI18N
        closeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButMouseClicked(evt);
            }
        });
        itemListPage.add(closeBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 50, 40));

        itemListScroll.setViewportView(itemListPage);

        sharingPageTab.add(itemListScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 710, 330));

        titleWhat.setBackground(new java.awt.Color(255, 255, 255));
        titleWhat.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        titleWhat.setForeground(new java.awt.Color(255, 255, 255));
        titleWhat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleWhat.setText("What item do you want to ___? ");
        sharingPageTab.add(titleWhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, 50));

        radioType.setBackground(new java.awt.Color(25, 41, 65));
        radioType.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        radioType.setForeground(new java.awt.Color(19, 175, 248));
        radioType.setText("Type Bicycle");
        radioType.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        radioType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTypeActionPerformed(evt);
            }
        });
        sharingPageTab.add(radioType, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, 40));

        radioEquip.setBackground(new java.awt.Color(25, 41, 65));
        radioEquip.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        radioEquip.setForeground(new java.awt.Color(19, 175, 248));
        radioEquip.setText("Equipment");
        radioEquip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radioEquip.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        radioEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEquipActionPerformed(evt);
            }
        });
        sharingPageTab.add(radioEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 140, 40));

        sharingPage.add(sharingPageTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 770, 360));

        mainAdmin.add(sharingPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 770, 421));

        getContentPane().add(mainAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        if (email.getText().equals("Email") || new String(password.getPassword()).equals("")) {
            warning.setVisible(true);
        } else {
            String username = email.getText();
            String pass = new String(password.getPassword());
            boolean correct = ac.login(username, pass);
            if (correct == true) {
                if (User.getPositon().equals("-")) {
                    login.setVisible(false);
                    mainUser.setVisible(true);
                    mainUserSetVisibe();
                    mainAdmin.setVisible(false);
                    mainAdminSetVisible();
                    name1.setText(User.getFirstName().toUpperCase());
                    pic1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(User.getImgPath())).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
                    boolean status = sh.checkStatus();
                    System.out.println(status);
                    if (status == false) {
                        boolean timesup = sh.remaintoReturn();
                        System.out.println(timesup);
                        if (timesup == false) {
                            try {
                                sh.checkTime();
                            } catch (InterruptedException ie) {
                                ie.printStackTrace();
                            }
                        } else {
                            sh.timesupCP();
                            circleMini.setVisible(true);
                            circleNoti.setVisible(true);
                        }
                    }
                } else if (User.getPositon().equalsIgnoreCase("Officer") || User.getPositon().equalsIgnoreCase("Technician")) {
                    login.setVisible(false);
                    mainAdmin.setVisible(true);
                    mainAdminSetVisible();
                    mainUser.setVisible(false);
                    mainUserSetVisibe();
                    name.setText(User.getFirstName().toUpperCase());
                    pic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(User.getImgPath())).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
                    position.setText(User.getPositon());
                }
            } else if (correct == false) {
                warning.setVisible(true);
            }
        }
    }//GEN-LAST:event_signinActionPerformed

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        if (email.getText().equals("Email")) {
            email.setForeground(new Color(255, 255, 255));
            email.setText("");
        }
        sEmailB.setVisible(true);
        sEmailG.setVisible(false);
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        if (email.getText().equals("") || email.getText().length() == 0) {
            email.setForeground(new Color(153, 153, 153));
            email.setText("Email");
        }
        sEmailB.setVisible(false);
        sEmailG.setVisible(true);
    }//GEN-LAST:event_emailFocusLost

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        if (showPass.getText().equals("Password")) {
            showPass.setVisible(false);
        }
        sPassB.setVisible(true);
        sPassG.setVisible(false);
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        if (password.getText().equals("") || password.getText().length() == 0) {
            showPass.setVisible(true);
        }
        sPassB.setVisible(false);
        sPassG.setVisible(true);
    }//GEN-LAST:event_passwordFocusLost

    private void signinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinMouseEntered
        signin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/signinButClick.png")));
    }//GEN-LAST:event_signinMouseEntered

    private void signinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinMouseExited
        signin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/signinBut.png")));
    }//GEN-LAST:event_signinMouseExited

    private void iconSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSearchMouseClicked
        search.requestFocusInWindow();
    }//GEN-LAST:event_iconSearchMouseClicked

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        if (search.getText().equals("Search")) {
            search.setText("");
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if (search.getText().equals("") || search.getText().length() == 0) {
            search.setText("Search");
        }
    }//GEN-LAST:event_searchFocusLost

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if (search.getText().equals("") || search.getText().length() == 0) {
            search.setText("Search");
        }
    }//GEN-LAST:event_searchActionPerformed

    private void canCounterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canCounterMouseClicked
        canCounter.setForeground(new java.awt.Color(19, 175, 248));
        cpPage.setVisible(true);
        nameOfUser.setText("    Name");
        surnameOfUser.setText("    Surname");
        countOfCan.setText("    Count");
        nameOfUser.setForeground(new Color(153, 153, 153, 150));
        surnameOfUser.setForeground(new Color(153, 153, 153, 150));
        countOfCan.setForeground(new Color(153, 153, 153, 150));
        bikeSharing.setForeground(new java.awt.Color(255, 255, 255));
        sharingPage.setVisible(false);
    }//GEN-LAST:event_canCounterMouseClicked

    private void bikeSharingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bikeSharingMouseClicked
        bikeSharing.setForeground(new java.awt.Color(19, 175, 248));
        menuAdd.setForeground(new Color(102, 102, 102));
        menuEdit.setForeground(new Color(102, 102, 102));
        menuDelete.setForeground(new Color(102, 102, 102));
        sharingPage.setVisible(true);
        menuSharing.setVisible(true);
        backAdd.setVisible(false);
        backEdit.setVisible(false);
        backDelete.setVisible(false);
        sharingPageTab.setVisible(false);
        radioType.setSelected(false);
        radioEquip.setSelected(false);
        layerAddItem.setVisible(false);
        canCounter.setForeground(new java.awt.Color(255, 255, 255));
        cpPage.setVisible(false);
        itemListScroll.setVisible(false);
        sh.selectAllItemID();
    }//GEN-LAST:event_bikeSharingMouseClicked

    private void timerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timerMouseClicked

    }//GEN-LAST:event_timerMouseClicked

    private void signoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseEntered
        titleSignout.setVisible(true);
    }//GEN-LAST:event_signoutMouseEntered

    private void signoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseExited
        titleSignout.setVisible(false);
    }//GEN-LAST:event_signoutMouseExited

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, "Do you want to Sign out ?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            User.setUserId(0);
            User.setOfficeId(null);
            User.setFirstName(null);
            User.setLastName(null);
            User.setGender(null);
            User.setBirthDate(null);
            User.setCongenitialDisease(null);
            User.setEmail(null);
            User.setTel(null);
            User.setDept(null);
            User.setDeptId(null);
            User.setPositon(null);
            User.setImgPath(null);
            login.setVisible(true);
            mainAdmin.setVisible(false);
            mainUser.setVisible(false);
            password.setText("");
            showPass.setVisible(true);
            email.setText("Email");
            email.setForeground(new Color(153, 153, 153));
            warning.setVisible(false);
            mainAdminSetVisible();
            mainUserSetVisibe();
        }
    }//GEN-LAST:event_signoutActionPerformed

    private void nameOfUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameOfUserFocusGained
        if (nameOfUser.getText().equals("    Name")) {
            nameOfUser.setForeground(new Color(255, 255, 255));
            nameOfUser.setText("");
        }
    }//GEN-LAST:event_nameOfUserFocusGained

    private void nameOfUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameOfUserFocusLost
        if (nameOfUser.getText().equals("") || nameOfUser.getText().length() == 0) {
            nameOfUser.setForeground(new Color(153, 153, 153, 150));
            nameOfUser.setText("    Name");
        }
    }//GEN-LAST:event_nameOfUserFocusLost

    private void countOfCanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countOfCanFocusGained
        if (countOfCan.getText().equals("    Count")) {
            countOfCan.setForeground(new Color(255, 255, 255));
            countOfCan.setText("");
        }
    }//GEN-LAST:event_countOfCanFocusGained

    private void countOfCanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countOfCanFocusLost
        if (countOfCan.getText().equals("") || countOfCan.getText().length() == 0) {
            countOfCan.setForeground(new Color(153, 153, 153, 150));
            countOfCan.setText("    Count");
        }
    }//GEN-LAST:event_countOfCanFocusLost

    private void submitButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButMouseEntered
        submitBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitClick.png")));
    }//GEN-LAST:event_submitButMouseEntered

    private void submitButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButMouseExited
        submitBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submit.png")));
    }//GEN-LAST:event_submitButMouseExited

    private void submitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButActionPerformed
        String name = nameOfUser.getText();
        String surname = surnameOfUser.getText();
        String can = countOfCan.getText();
        if (name.equals("    Name") || surname.equals("    Surname")) {
            JOptionPane.showMessageDialog(this, "Please EnterName and Surname", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int c = Integer.parseInt(can);
                sh.getCp().increseCp(name, surname, c);
                JOptionPane.showMessageDialog(this, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
                nameOfUser.setForeground(new Color(153, 153, 153, 150));
                nameOfUser.setText("    Name");
                countOfCan.setForeground(new Color(153, 153, 153, 150));
                countOfCan.setText("    Count");
                surnameOfUser.setForeground(new Color(153, 153, 153, 150));
                surnameOfUser.setText("    Surname");
            } catch (SelectMemberNameException smn) {
                JOptionPane.showMessageDialog(this, smn.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(this, "Can of Count not correct, Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_submitButActionPerformed

    private void cancleAdminButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleAdminButMouseEntered
        cancleAdminBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancleButClick.png")));
    }//GEN-LAST:event_cancleAdminButMouseEntered

    private void cancleAdminButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleAdminButMouseExited
        cancleAdminBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancleBut.png")));
    }//GEN-LAST:event_cancleAdminButMouseExited

    private void cancleAdminButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleAdminButActionPerformed
        nameOfUser.setForeground(new Color(153, 153, 153, 150));
        nameOfUser.setText("    Name");
        countOfCan.setForeground(new Color(153, 153, 153, 150));
        countOfCan.setText("    Count");
        surnameOfUser.setForeground(new Color(153, 153, 153, 150));
        surnameOfUser.setText("    Surname");
    }//GEN-LAST:event_cancleAdminButActionPerformed

    private void surnameOfUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_surnameOfUserFocusGained
        if (surnameOfUser.getText().equals("    Surname")) {
            surnameOfUser.setForeground(new Color(255, 255, 255));
            surnameOfUser.setText("");
        }
    }//GEN-LAST:event_surnameOfUserFocusGained

    private void surnameOfUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_surnameOfUserFocusLost
        if (surnameOfUser.getText().equals("") || surnameOfUser.getText().length() == 0) {
            surnameOfUser.setForeground(new Color(153, 153, 153, 150));
            surnameOfUser.setText("    Surname");
        }
    }//GEN-LAST:event_surnameOfUserFocusLost

    private void menuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddActionPerformed
        titleItemName.setForeground(new Color(255, 255, 255));
        titleItemCount.setForeground(new Color(255, 255, 255));
        titleItemId.setForeground(new Color(255, 255, 255));
        menuAdd.setForeground(new Color(255, 255, 255));
        menuEdit.setForeground(new Color(102, 102, 102));
        menuDelete.setForeground(new Color(102, 102, 102));
        backAdd.setVisible(true);
        backEdit.setVisible(false);
        backDelete.setVisible(false);
        sharingPageTab.setVisible(true);
        titleWhat.setText("What's item do you want to add?");
        radioType.setSelected(false);
        radioEquip.setSelected(false);
        radioType.setVisible(true);
        radioEquip.setVisible(true);
        layerAddItem.setVisible(false);
        layerAddItem.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Add Item", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Leelawadee", 0, 20), new java.awt.Color(3, 153, 223)));
        itemListScroll.setVisible(false);
        notiSharing.setVisible(false);
        itemName.setVisible(true);
        itemAmount.setVisible(true);
        titleItemCount.setVisible(true);
        titleItemName.setVisible(true);
        s7.setVisible(true);
        s8.setVisible(true);
    }//GEN-LAST:event_menuAddActionPerformed

    private void menuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditActionPerformed
        titleItemName.setForeground(new Color(255, 255, 255));
        titleItemCount.setForeground(new Color(255, 255, 255));
        titleItemId.setForeground(new Color(255, 255, 255));
        menuAdd.setForeground(new Color(102, 102, 102));
        menuEdit.setForeground(new Color(255, 255, 255));
        menuDelete.setForeground(new Color(102, 102, 102));
        backAdd.setVisible(false);
        backEdit.setVisible(true);
        backDelete.setVisible(false);
        sharingPageTab.setVisible(true);
        titleWhat.setText("What's item do you want to edit?");
        radioType.setSelected(false);
        radioEquip.setSelected(false);
        radioType.setVisible(false);
        radioEquip.setVisible(false);
        layerAddItem.setVisible(true);
        layerAddItem.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Edit Item", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Leelawadee", 0, 20), new java.awt.Color(3, 153, 223)));
        itemListScroll.setVisible(false);
        notiSharing.setVisible(false);
        itemId.setText("ID");
        itemId.setEditable(true);
        itemId.setForeground(new Color(153, 153, 153, 150));
        itemName.setText("Name");
        itemName.setForeground(new Color(153, 153, 153, 150));
        itemName.setVisible(true);
        itemAmount.setText("Count");
        itemAmount.setForeground(new Color(153, 153, 153, 150));
        itemAmount.setVisible(true);
        itemList.setVisible(true);
        titleItemCount.setVisible(true);
        titleItemName.setVisible(true);
        s7.setVisible(true);
        s8.setVisible(true);
    }//GEN-LAST:event_menuEditActionPerformed

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteActionPerformed
        titleItemName.setForeground(new Color(255, 255, 255));
        titleItemCount.setForeground(new Color(255, 255, 255));
        titleItemId.setForeground(new Color(255, 255, 255));
        menuAdd.setForeground(new Color(102, 102, 102));
        menuEdit.setForeground(new Color(102, 102, 102));
        menuDelete.setForeground(new Color(255, 255, 255));
        backAdd.setVisible(false);
        backEdit.setVisible(false);
        backDelete.setVisible(true);
        sharingPageTab.setVisible(true);
        titleWhat.setText("What's item do you want to delete?");
        radioType.setSelected(false);
        radioEquip.setSelected(false);
        layerAddItem.setVisible(true);
        layerAddItem.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Delete Item", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Leelawadee", 0, 20), new java.awt.Color(3, 153, 223)));
        itemListScroll.setVisible(false);
        notiSharing.setVisible(false);
        itemId.setText("ID");
        itemId.setForeground(new Color(153, 153, 153, 150));
        itemId.setEditable(true);
        itemName.setText("Name");
        itemName.setForeground(new Color(153, 153, 153, 150));
        itemName.setVisible(false);
        itemAmount.setText("Count");
        itemAmount.setForeground(new Color(153, 153, 153, 150));
        itemAmount.setVisible(false);
        itemList.setVisible(true);
        titleItemCount.setVisible(false);
        titleItemName.setVisible(false);
        s7.setVisible(false);
        s8.setVisible(false);
        radioEquip.setVisible(false);
        radioType.setVisible(false);
    }//GEN-LAST:event_menuDeleteActionPerformed

    private void itemNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemNameFocusGained
        if (itemName.getText().equals("Name")) {
            itemName.setForeground(new Color(255, 255, 255));
            itemName.setText("");
        }
    }//GEN-LAST:event_itemNameFocusGained

    private void itemNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemNameFocusLost
        if (itemName.getText().equals("") || itemName.getText().length() == 0) {
            itemName.setForeground(new Color(153, 153, 153, 150));
            itemName.setText("Name");
        }
    }//GEN-LAST:event_itemNameFocusLost

    private void itemAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemAmountFocusGained
        if (itemAmount.getText().equals("Count")) {
            itemAmount.setForeground(new Color(255, 255, 255));
            itemAmount.setText("");
        }
    }//GEN-LAST:event_itemAmountFocusGained

    private void itemAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemAmountFocusLost
        if (itemAmount.getText().equals("") || itemAmount.getText().length() == 0) {
            itemAmount.setForeground(new Color(153, 153, 153, 150));
            itemAmount.setText("Count");
        }
    }//GEN-LAST:event_itemAmountFocusLost

    private void submitButSharingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButSharingMouseEntered
        submitButSharing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMiniClick.png")));
    }//GEN-LAST:event_submitButSharingMouseEntered

    private void submitButSharingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButSharingMouseExited
        submitButSharing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMini.png")));
    }//GEN-LAST:event_submitButSharingMouseExited

    private void submitButSharingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButSharingActionPerformed
        if (backAdd.isVisible()) {
            String id = itemId.getText();
            String name = itemName.getText();
            titleItemName.setForeground(new Color(255, 255, 255));
            titleItemCount.setForeground(new Color(255, 255, 255));
            try {
                int count = Integer.parseInt(itemAmount.getText());
                if (name.equals("Name")) {
                    titleItemName.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                } else {
                    sh.addItem(id, name, count);
                    notiSharing.setText("Success.");
                    notiSharing.setForeground(new Color(130, 255, 134));
                    notiSharing.setVisible(true);
                    itemId.setForeground(new Color(153, 153, 153, 150));
                    itemId.setText("ID");
                    itemName.setForeground(new Color(153, 153, 153, 150));
                    itemName.setText("Name");
                    itemAmount.setForeground(new Color(153, 153, 153, 150));
                    itemAmount.setText("Count");
                }
            } catch (NumberFormatException ne) {
                if (name.equals("Name")) {
                    titleItemName.setForeground(new Color(255, 51, 51));
                    titleItemCount.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                } else {
                    titleItemCount.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                }
            }

        } else if (backEdit.isVisible()) {
            boolean check = false;
            String id = itemId.getText();
            String allId[] = sh.getItemID();
            for (int i = 0; i < allId.length; i++) {
                if (id.equals(allId[i])) {
                    check = true;
                }
            }
            String name = itemName.getText();
            titleItemName.setForeground(new Color(255, 255, 255));
            titleItemCount.setForeground(new Color(255, 255, 255));
            titleItemId.setForeground(new Color(255, 255, 255));

            try {
                int count = Integer.parseInt(itemAmount.getText());
                if (check == false && name.equals("Name")) {
                    titleItemId.setForeground(new Color(255, 51, 51));
                    titleItemName.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                } else if (name.equals("Name") && check == true) {
                    titleItemName.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                } else if (check == false) {
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                    titleItemId.setForeground(new Color(255, 51, 51));
                } else {
                    sh.editItem(id, name, count);
                    notiSharing.setText("Success.");
                    notiSharing.setForeground(new Color(130, 255, 134));
                    notiSharing.setVisible(true);
                    itemId.setForeground(new Color(153, 153, 153, 150));
                    itemId.setText("ID");
                    itemName.setForeground(new Color(153, 153, 153, 150));
                    itemName.setText("Name");
                    itemAmount.setForeground(new Color(153, 153, 153, 150));
                    itemAmount.setText("Count");
                }
            } catch (NumberFormatException ne) {
                if (check == false && name.equals("Name")) {
                    titleItemId.setForeground(new Color(255, 51, 51));
                    titleItemName.setForeground(new Color(255, 51, 51));
                    titleItemCount.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                } else if (name.equals("Name") && check == true) {
                    titleItemName.setForeground(new Color(255, 51, 51));
                    titleItemCount.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                } else if (check == false) {
                    titleItemId.setForeground(new Color(255, 51, 51));
                    titleItemCount.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                } else {
                    titleItemCount.setForeground(new Color(255, 51, 51));
                    notiSharing.setText("Not Success,Please enter again");
                    notiSharing.setForeground(new Color(255, 51, 51));
                    notiSharing.setVisible(true);
                }
            }

        } else if (backDelete.isVisible()) {
            boolean check = false;
            titleItemId.setForeground(new Color(255, 255, 255));
            String id = itemId.getText();
            String allId[] = sh.getItemID();
            for (int i = 0; i < allId.length; i++) {
                if (id.equals(allId[i])) {
                    check = true;
                }
            }
            if (check == true) {
                sh.deleteItem(id);
            } else if (check == false) {
                notiSharing.setText("Not Success,Please enter again");
                notiSharing.setForeground(new Color(255, 51, 51));
                notiSharing.setVisible(true);
                titleItemId.setForeground(new Color(255, 51, 51));
            }

        }
    }//GEN-LAST:event_submitButSharingActionPerformed

    private void cancleButSharingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleButSharingMouseEntered
        cancleButSharing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancleMiniClick.png")));
    }//GEN-LAST:event_cancleButSharingMouseEntered

    private void cancleButSharingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleButSharingMouseExited
        cancleButSharing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancleMini.png")));
    }//GEN-LAST:event_cancleButSharingMouseExited

    private void cancleButSharingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButSharingActionPerformed
        itemId.setForeground(new Color(153, 153, 153, 150));
        itemId.setText("ID");
        itemName.setForeground(new Color(153, 153, 153, 150));
        itemName.setText("Name");
        itemAmount.setForeground(new Color(153, 153, 153, 150));
        itemAmount.setText("Count");
        titleItemName.setForeground(new Color(255, 255, 255));
        titleItemCount.setForeground(new Color(255, 255, 255));
        titleItemId.setForeground(new Color(255, 255, 255));
        notiSharing.setVisible(false);
        if (backAdd.isVisible()) {
            radioType.setSelected(false);
            radioEquip.setSelected(false);
            layerAddItem.setVisible(false);
        } else if (backEdit.isVisible()) {
            layerAddItem.setVisible(true);
        } else if (backEdit.isVisible()) {
            layerAddItem.setVisible(true);
        }
    }//GEN-LAST:event_cancleButSharingActionPerformed

    private void itemIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemIdFocusGained
        if (itemId.getText().equals("ID")) {
            itemId.setForeground(new Color(255, 255, 255));
            itemId.setText("");
        }
    }//GEN-LAST:event_itemIdFocusGained

    private void itemIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemIdFocusLost
        if (itemId.getText().equals("") || itemId.getText().length() == 0) {
            itemId.setForeground(new Color(153, 153, 153, 150));
            itemId.setText("ID");
        }
    }//GEN-LAST:event_itemIdFocusLost

    private void itemListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemListMouseEntered
        itemList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/itemListClick.png")));
    }//GEN-LAST:event_itemListMouseEntered

    private void itemListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemListMouseExited
        itemList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/itemList.png")));
    }//GEN-LAST:event_itemListMouseExited

    private void itemListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListActionPerformed
        itemListScroll.setVisible(true);
        layerAddItem.setVisible(false);
        itemListScroll.getViewport().setViewPosition(new Point(0, 0));
        int y = 70;
        String all[] = sh.selectAllAdmin();
        JPanel[] jp = new JPanel[all.length];
        JLabel[] detail = new JLabel[all.length];
        for (int i = 0; i < all.length; i++) {
            jp[i] = new JPanel();
            jp[i].setBackground(new Color(102, 102, 102));
            jp[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            detail[i] = new JLabel();
            detail[i].setFont(new java.awt.Font("Leelawadee", 0, 18));
            detail[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            detail[i].setText(all[i]);

            jp[i].add(detail[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, 580, 30));
            itemListPage.add(jp[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(40, y, 600, 50));
            y += 70;
        }
        itemListScroll.setViewportView(itemListPage);
    }//GEN-LAST:event_itemListActionPerformed

    private void closeButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButMouseClicked
        itemListScroll.setVisible(false);
        layerAddItem.setVisible(true);
    }//GEN-LAST:event_closeButMouseClicked

    private void radioTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTypeActionPerformed
        layerAddItem.setVisible(true);
        radioEquip.setSelected(false);
        if (backAdd.isVisible()) {
            itemId.setText(sh.selectItemIdBike());
            itemId.setEditable(false);
            notiSharing.setVisible(false);
            titleItemName.setVisible(true);
            itemName.setVisible(true);
            titleItemCount.setVisible(true);
            itemAmount.setVisible(true);
            s7.setVisible(true);
            s8.setVisible(true);
            itemList.setVisible(false);
        }
    }//GEN-LAST:event_radioTypeActionPerformed

    private void radioEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEquipActionPerformed
        layerAddItem.setVisible(true);
        radioType.setSelected(false);
        if (backAdd.isVisible()) {
            itemId.setText(sh.selectItemIdEquip());
            itemId.setEditable(false);
            notiSharing.setVisible(false);
            titleItemName.setVisible(true);
            itemName.setVisible(true);
            titleItemCount.setVisible(true);
            itemAmount.setVisible(true);
            s7.setVisible(true);
            s8.setVisible(true);
            itemList.setVisible(false);
        }
    }//GEN-LAST:event_radioEquipActionPerformed

    private void iconSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSearch1MouseClicked
        search1.requestFocusInWindow();
    }//GEN-LAST:event_iconSearch1MouseClicked

    private void search1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search1FocusGained
        if (search1.getText().equals("Search")) {
            search1.setText("");
        }
    }//GEN-LAST:event_search1FocusGained

    private void search1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search1FocusLost
        if (search1.getText().equals("") || search.getText().length() == 0) {
            search1.setText("Search");
        }
    }//GEN-LAST:event_search1FocusLost

    private void canCounter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canCounter1MouseClicked
        canCounter1.setForeground(new java.awt.Color(19, 175, 248));
        bikeSharing1.setForeground(new java.awt.Color(240, 240, 240));
        timer1.setForeground(new java.awt.Color(240, 240, 240));
        profile1.setForeground(new java.awt.Color(240, 240, 240));
        support1.setForeground(new java.awt.Color(240, 240, 240));
        cpPage1.setVisible(true);
        sharingScroll.setVisible(false);
        sharingStep3.setVisible(false);
        timePageT.setVisible(false);
        timePageF.setVisible(false);
        userProfilePage1.setVisible(false);
        supportPage1.setVisible(false);
        sh.getCp().selectCP();
        showCp.setText(sh.getCp().getCp() + "");
        (sh.getCp()).selectTrans();
        actionHis.setText(sh.getCp().getAction());
        poinsHis.setText(sh.getCp().getCount() + " Points");
    }//GEN-LAST:event_canCounter1MouseClicked

    private void bikeSharing1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bikeSharing1MouseClicked
        bikeSharing1.setForeground(new java.awt.Color(19, 175, 248));
        canCounter1.setForeground(new java.awt.Color(240, 240, 240));
        timer1.setForeground(new java.awt.Color(240, 240, 240));
        profile1.setForeground(new java.awt.Color(240, 240, 240));
        support1.setForeground(new java.awt.Color(240, 240, 240));
        cpPage1.setVisible(false);
        timePageT.setVisible(false);
        timePageF.setVisible(false);
        userProfilePage1.setVisible(false);
        supportPage1.setVisible(false);
        sharingScroll.setVisible(true);
        settingItem();
        sh.editStep();
        setBorrowStep1();
        sharingStep3.setVisible(false);
        sh.getCp().selectCP();
        isCp.setText("Your CP : " + sh.getCp().getCp() + " Points");
        int countHis = sh.countHis();
        if (countHis != 0) {
            boolean check = sh.checkStatus();
            if (check == false) {
                boolean timesup = sh.remaintoReturn();
                if (timesup == true) {
                    JOptionPane.showMessageDialog(this, "Please return Items before borrow.", "Warning", JOptionPane.OK_OPTION);
                    timer1.setForeground(new java.awt.Color(19, 175, 248));
                    bikeSharing1.setForeground(new java.awt.Color(240, 240, 240));
                    canCounter1.setForeground(new java.awt.Color(240, 240, 240));
                    profile1.setForeground(new java.awt.Color(240, 240, 240));
                    cpPage1.setVisible(false);
                    timePageT.setVisible(false);
                    timePageF.setVisible(false);
                    sharingScroll.setVisible(false);
                    sharingStep3.setVisible(false);
                    userProfilePage1.setVisible(false);
                    timePageT.setVisible(true);
                    timeupPage.setVisible(true);
                    listTimeup.setText(sh.itemMustReturn());
                    timewatch.setVisible(false);
                    itemListShow.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_bikeSharing1MouseClicked

    private void timer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timer1MouseClicked
        timer1.setForeground(new java.awt.Color(19, 175, 248));
        bikeSharing1.setForeground(new java.awt.Color(240, 240, 240));
        canCounter1.setForeground(new java.awt.Color(240, 240, 240));
        profile1.setForeground(new java.awt.Color(240, 240, 240));
        support1.setForeground(new java.awt.Color(240, 240, 240));
        cpPage1.setVisible(false);
        timePageT.setVisible(false);
        timePageF.setVisible(false);
        sharingScroll.setVisible(false);
        sharingStep1.setVisible(false);
        sharingStep3.setVisible(false);
        userProfilePage1.setVisible(false);
        supportPage1.setVisible(false);
        int num = sh.countHis();
        boolean status = sh.checkStatus();
        if (status == false) {
            boolean timesup = sh.remaintoReturn();
            timePageT.setVisible(true);
            timePageF.setVisible(false);
            if (timesup == true) {
                //โชว์ของยังไม่คืน
                timeupPage.setVisible(true);
                listTimeup.setText("<html><body>" + sh.itemMustReturn() + "</body></html>");
                timewatch.setVisible(false);
                itemListShow.setVisible(false);
                timeupPage.setVisible(true);
            } else if (timesup == false) {
                //โชว์ 2.ยิมแล้ว เวลา + รายการของ
                timeupPage.setVisible(false);
                Date current = new Date();
                timePageT.setVisible(true);
                timewatch.setVisible(true);
                itemListShow.setVisible(true);
                endTime.setText("End:    " + current.getDate() + " / " + (current.getMonth() + 1) + " / " + (current.getYear() + 1900) + "  18 : 00");
                timeLeftShow.setText(sh.getTimeDetail());
                new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        endTime.setText("End:    " + current.getDate() + " / " + (current.getMonth() + 1) + " / " + (current.getYear() + 1900) + "  18 : 00");
                        timeLeftShow.setText(sh.getTimeDetail());
                    }
                }).start();
                listShow.setText("<html><body>" + sh.itemMustReturn() + "</body></html>");
            }
        } else if (status == true) {
            timePageT.setVisible(false);
            timePageF.setVisible(true);
            timewatch.setVisible(false);
            if (num == 0) {
                textNotHis.setVisible(true);
                iconNotHis.setVisible(true);
            } else {
                int y = 50;
                String his[] = sh.showHis();
                JPanel[] jp = new JPanel[num];
                JLabel[] detailBorrow = new JLabel[num];
                JLabel[] icon = new JLabel[num];
                for (int i = 0; i < num; i++) {
                    jp[i] = new JPanel();
                    jp[i].setBackground(new Color(102, 102, 102));
                    jp[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                    detailBorrow[i] = new JLabel();
                    detailBorrow[i].setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
                    detailBorrow[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    detailBorrow[i].setText(his[i]);
                    jp[i].add(detailBorrow[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 490, 50));
                    icon[i] = new JLabel();
                    icon[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    icon[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/clock.png"))); // NOI18N
                    jp[i].add(icon[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 50, 50));
                    timePageF.add(jp[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(50, y, 660, 50));
                    y += 70;
                }
            }
        }
    }//GEN-LAST:event_timer1MouseClicked

    private void signout1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signout1MouseEntered
        titleSignout1.setVisible(true);
    }//GEN-LAST:event_signout1MouseEntered

    private void signout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signout1MouseExited
        titleSignout1.setVisible(false);
    }//GEN-LAST:event_signout1MouseExited

    private void signout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signout1ActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, "Do you want to Sign out ?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            User.setUserId(0);
            User.setOfficeId(null);
            User.setFirstName(null);
            User.setLastName(null);
            User.setGender(null);
            User.setBirthDate(null);
            User.setCongenitialDisease(null);
            User.setEmail(null);
            User.setTel(null);
            User.setDept(null);
            User.setDeptId(null);
            User.setPositon(null);
            User.setImgPath(null);
            login.setVisible(true);
            mainAdmin.setVisible(false);
            mainUser.setVisible(false);
            password.setText("");
            showPass.setVisible(true);
            email.setText("Email");
            email.setForeground(new Color(153, 153, 153));
            warning.setVisible(false);
            mainAdminSetVisible();
            mainUserSetVisibe();
        }
    }//GEN-LAST:event_signout1ActionPerformed

    private void backStep1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backStep1MouseEntered
        backStep1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/left arrow click.png")));
    }//GEN-LAST:event_backStep1MouseEntered

    private void backStep1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backStep1MouseExited
        backStep1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/left arrow.png")));
    }//GEN-LAST:event_backStep1MouseExited

    private void backStep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backStep1ActionPerformed
        sh.editStep();
        detailData.setText("");
        sharingScroll.setVisible(true);
        sharingStep3.setVisible(false);
    }//GEN-LAST:event_backStep1ActionPerformed

    private void cancleButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleButMouseEntered
        cancleBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancleClick.png")));
        cancleBut.getToolTipText();
    }//GEN-LAST:event_cancleButMouseEntered

    private void cancleButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleButMouseExited
        cancleBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/cancle.png")));
    }//GEN-LAST:event_cancleButMouseExited

    private void cancleButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButActionPerformed
        sh.editStep();
        settingItem();
        sharingScroll.setVisible(true);
        setBorrowStep1();
        sharingStep3.setVisible(false);
        for (int i = 0; i < countBorrow.length; i++) {
            countBorrow[i] = 0;
        }
    }//GEN-LAST:event_cancleButActionPerformed

    private void borrowButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowButMouseEntered
        borrowBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/BorrowButClick.png")));
    }//GEN-LAST:event_borrowButMouseEntered

    private void borrowButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowButMouseExited
        borrowBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/BorrowBut.png")));
    }//GEN-LAST:event_borrowButMouseExited

    private void borrowButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowButActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, "Do you want to Borrow?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            backStep1.setEnabled(false);
            try {
                sh.startBorrow();
                settingItem();
                sharingScroll.setVisible(true);
                setBorrowStep1();
                sharingStep3.setVisible(false);
                for (int i = 0; i < countBorrow.length; i++) {
                    countBorrow[i] = 0;
                }
                sh.getCp().selectCP();
                isCp.setText("Your CP : " + sh.getCp().getCp() + " Points");
            } catch (InterruptedException ie) {
                JOptionPane.showMessageDialog(this, ie.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_borrowButActionPerformed

    private void backSigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSigninMouseClicked
        login.setVisible(true);
        forgotPassPage.setVisible(false);
    }//GEN-LAST:event_backSigninMouseClicked

    private void forgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPassMouseClicked
        forgotPassPage.setVisible(true);
        login.setVisible(false);
    }//GEN-LAST:event_forgotPassMouseClicked

    private void submitPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitPassMouseEntered
        submitPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitPassClick.png")));
    }//GEN-LAST:event_submitPassMouseEntered

    private void submitPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitPassMouseExited
        submitPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitPass.png")));
    }//GEN-LAST:event_submitPassMouseExited

    private void forgotEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forgotEmailFocusGained
        if (forgotEmail.getText().equals("Email")) {
            forgotEmail.setText("");
            forgotEmail.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_forgotEmailFocusGained

    private void forgotEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forgotEmailFocusLost
        if (forgotEmail.getText().equals("") || forgotEmail.getText().length() == 0) {
            forgotEmail.setText("Email");
            forgotEmail.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_forgotEmailFocusLost

    private void profile1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile1MouseClicked
        profile1.setForeground(new java.awt.Color(19, 175, 248));
        bikeSharing1.setForeground(new java.awt.Color(240, 240, 240));
        canCounter1.setForeground(new java.awt.Color(240, 240, 240));
        timer1.setForeground(new java.awt.Color(240, 240, 240));
        cpPage1.setVisible(false);
        timePageT.setVisible(false);
        timePageF.setVisible(false);
        sharingScroll.setVisible(false);
        sharingStep3.setVisible(false);
        userProfilePage1.setVisible(true);
        chooseImgProfileBut1.setVisible(false);
        pathImgProfile1.setVisible(false);
        submitProfile1.setVisible(false);
        warningProfile1.setVisible(false);
        if (genderProfile1.getText().equalsIgnoreCase("f")) {
            genderProfile1.setText("Female");
        } else if (genderProfile1.getText().equalsIgnoreCase("m")) {
            genderProfile1.setText("Male");
        }
        setDataUserProfile();

        imageProfile1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(User.getImgPath())).getImage().getScaledInstance(200, 170, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_profile1MouseClicked

    private void editProfileBut1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileBut1MouseEntered
        editProfileBut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/editProfileClick.png")));
    }//GEN-LAST:event_editProfileBut1MouseEntered

    private void editProfileBut1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileBut1MouseExited
        editProfileBut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/editProfile.png")));
    }//GEN-LAST:event_editProfileBut1MouseExited

    private void editProfileBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileBut1ActionPerformed
        chooseImgProfileBut1.setVisible(true);
        pathImgProfile1.setVisible(true);
        submitProfile1.setVisible(true);
        nameProfile1.setEditable(true);
        nameProfile1.setBackground(Color.white);
        genderProfile1.setEditable(true);
        genderProfile1.setBackground(Color.white);
        birthProfile1.setEditable(true);
        birthProfile1.setBackground(Color.white);
        congenProfile1.setEditable(true);
        congenProfile1.setBackground(Color.white);
        emailProfile1.setEditable(true);
        emailProfile1.setBackground(Color.white);
        telProfile1.setEditable(true);
        telProfile1.setBackground(Color.white);
        warningProfile1.setVisible(false);
    }//GEN-LAST:event_editProfileBut1ActionPerformed

    private void submitProfile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProfile1ActionPerformed
        int i = nameProfile1.getText().indexOf(" ");
        warningProfile1.setVisible(false);
        if (i == -1) {
            warningProfile1.setVisible(true);
        } else {
            if (pathImgProfile1.getText().equals("No Select File.")) {
                pathImgProfile1.setText(User.getImgPath());
            }
            if (genderProfile1.getText().equalsIgnoreCase("female")) {
                genderProfile1.setText("F");
            } else if (genderProfile1.getText().equalsIgnoreCase("male")) {
                genderProfile1.setText("M");
            }
            ac.updateProfile(nameProfile1.getText(), genderProfile1.getText(), birthProfile1.getText(), congenProfile1.getText(), emailProfile1.getText(), telProfile1.getText(), pathImgProfile1.getText());
            chooseImgProfileBut1.setVisible(false);
            pathImgProfile1.setVisible(false);
            submitProfile1.setVisible(false);
            nameProfile1.setEditable(false);
            genderProfile1.setEditable(false);
            birthProfile1.setEditable(false);
            congenProfile1.setEditable(false);
            emailProfile1.setEditable(false);
            telProfile1.setEditable(false);
            warningProfile1.setVisible(false);
            nameProfile1.setBackground(new Color(25, 41, 65));
            genderProfile1.setBackground(new Color(25, 41, 65));
            birthProfile1.setBackground(new Color(25, 41, 65));
            congenProfile1.setBackground(new Color(25, 41, 65));
            emailProfile1.setBackground(new Color(25, 41, 65));
            telProfile1.setBackground(new Color(25, 41, 65));
            pathImgProfile1.setText("No Select File.");
            setDataUserProfile();

        }
    }//GEN-LAST:event_submitProfile1ActionPerformed

    private void chooseImgProfileBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgProfileBut1ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.toString();
            pathImgProfile1.setText(path);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            pathImgProfile1.setText("No Select File.");
        }
    }//GEN-LAST:event_chooseImgProfileBut1ActionPerformed

    private void submitProfile1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitProfile1MouseEntered
        submitProfile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMiniClick.png")));
    }//GEN-LAST:event_submitProfile1MouseEntered

    private void submitProfile1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitProfile1MouseExited
        submitProfile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMini.png")));
    }//GEN-LAST:event_submitProfile1MouseExited

    private void editProfileButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileButMouseEntered
        editProfileBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/editProfileClick.png")));
    }//GEN-LAST:event_editProfileButMouseEntered

    private void editProfileButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileButMouseExited
        editProfileBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/editProfile.png")));
    }//GEN-LAST:event_editProfileButMouseExited

    private void editProfileButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButActionPerformed
        chooseImgProfileBut.setVisible(true);
        pathImgProfile.setVisible(true);
        submitProfile.setVisible(true);
        nameProfile.setEditable(true);
        nameProfile.setBackground(Color.white);
        genderProfile.setEditable(true);
        genderProfile.setBackground(Color.white);
        birthProfile.setEditable(true);
        birthProfile.setBackground(Color.white);
        congenProfile.setEditable(true);
        congenProfile.setBackground(Color.white);
        emailProfile.setEditable(true);
        emailProfile.setBackground(Color.white);
        telProfile.setEditable(true);
        telProfile.setBackground(Color.white);
        warningProfile.setVisible(false);
    }//GEN-LAST:event_editProfileButActionPerformed

    private void chooseImgProfileButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgProfileButActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.toString();
            pathImgProfile.setText(path);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            pathImgProfile.setText("No Select File.");
        }
    }//GEN-LAST:event_chooseImgProfileButActionPerformed

    private void submitProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitProfileMouseEntered
        submitProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMiniClick.png")));
    }//GEN-LAST:event_submitProfileMouseEntered

    private void submitProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitProfileMouseExited
        submitProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/submitMini.png")));
    }//GEN-LAST:event_submitProfileMouseExited

    private void submitProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProfileActionPerformed
        int i = nameProfile.getText().indexOf(" ");
        warningProfile.setVisible(false);
        if (i == -1) {
            warningProfile.setVisible(true);
        } else {
            if (pathImgProfile.getText().equals("No Select File.")) {
                pathImgProfile.setText(User.getImgPath());
            }
            if (genderProfile.getText().equalsIgnoreCase("female")) {
                genderProfile.setText("F");
            } else if (genderProfile.getText().equalsIgnoreCase("male")) {
                genderProfile.setText("M");
            }
            ac.updateProfile(nameProfile.getText(), genderProfile.getText(), birthProfile.getText(), congenProfile.getText(), emailProfile.getText(), telProfile.getText(), pathImgProfile.getText());
            chooseImgProfileBut.setVisible(false);
            pathImgProfile.setVisible(false);
            submitProfile.setVisible(false);
            nameProfile.setEditable(false);
            genderProfile.setEditable(false);
            birthProfile.setEditable(false);
            congenProfile.setEditable(false);
            emailProfile.setEditable(false);
            telProfile.setEditable(false);
            warningProfile.setVisible(false);
            nameProfile.setBackground(new Color(25, 41, 65));
            genderProfile.setBackground(new Color(25, 41, 65));
            birthProfile.setBackground(new Color(25, 41, 65));
            congenProfile.setBackground(new Color(25, 41, 65));
            emailProfile.setBackground(new Color(25, 41, 65));
            telProfile.setBackground(new Color(25, 41, 65));
            pathImgProfile.setText("No Select File.");
            setDataUserProfile();

        }
    }//GEN-LAST:event_submitProfileActionPerformed

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        profile.setForeground(new java.awt.Color(19, 175, 248));
        bikeSharing.setForeground(new java.awt.Color(240, 240, 240));
        canCounter.setForeground(new java.awt.Color(240, 240, 240));
        cpPage.setVisible(false);
        sharingPage.setVisible(false);
        userProfilePage.setVisible(true);
        chooseImgProfileBut.setVisible(false);
        pathImgProfile.setVisible(false);
        submitProfile.setVisible(false);
        warningProfile.setVisible(false);
        if (genderProfile.getText().equalsIgnoreCase("f")) {
            genderProfile.setText("Female");
        } else if (genderProfile.getText().equalsIgnoreCase("m")) {
            genderProfile.setText("Male");
        }
        setDataUserProfile();
        imageProfile.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(User.getImgPath())).getImage().getScaledInstance(200, 170, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_profileMouseClicked

    private void nextStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextStepActionPerformed
        Date dt = new Date();
        try {
            insertBorrow();
            sh.borrowStep();
            sh.setPointUse();
            sh.getCp().selectCP();
            (sh.getCp()).checkCp();
            sh.enterTime(dt.getDate(), dt.getMonth() + 1, dt.getYear() + 1900, 18, 0, 0);
            sharingScroll.setVisible(false);
            sharingStep3.setVisible(true);
            setBorrowDetail();
            int point = (sh.getCp()).getCp();
            cpUser.setText(point + "");
            int pointUse = (sh.getCp()).getCpUse();
            cpUse.setText(pointUse + "");
            pointRemain.setText((point - pointUse) + "");
            borrowBut.setEnabled(true);
        } catch (CanCountException cce) {
            JOptionPane.showMessageDialog(this, cce.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SelectItemException s) {
            JOptionPane.showMessageDialog(this, s.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nextStepActionPerformed

    private void nextStepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextStepMouseExited
        nextStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/right arrow.png")));
    }//GEN-LAST:event_nextStepMouseExited

    private void nextStepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextStepMouseEntered
        nextStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_gui/picture/right arrow click.png")));
    }//GEN-LAST:event_nextStepMouseEntered

    private void backSigninRegisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSigninRegisMouseClicked
        login.setVisible(true);
        registerPage.setVisible(false);
    }//GEN-LAST:event_backSigninRegisMouseClicked

    private void jTextFieldTelophoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTelophoneFocusGained
        if (jTextFieldTelophone.getText().equals("090xxxxxxx")) {
            jTextFieldTelophone.setText("");
            jTextFieldTelophone.setForeground(new java.awt.Color(255, 255, 255));
        }
        jTextFieldTelophone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jTextFieldTelophoneFocusGained

    private void jTextFieldTelophoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTelophoneFocusLost
        if (jTextFieldTelophone.getText().equals("") || jTextFieldTelophone.getText().length() == 0) {
            jTextFieldTelophone.setForeground(new Color(153, 153, 153, 150));
            jTextFieldTelophone.setText("090xxxxxxx");
        }
        jTextFieldTelophone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jTextFieldTelophoneFocusLost

    private void jTfFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTfFirstNameFocusGained
        if (jTfFirstName.getText().equals("John")) {
            jTfFirstName.setText("");
            jTfFirstName.setForeground(new java.awt.Color(255, 255, 255));
        }
        jTfFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jTfFirstNameFocusGained

    private void jTfFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTfFirstNameFocusLost
        if (jTfFirstName.getText().equals("") || jTfFirstName.getText().length() == 0) {
            jTfFirstName.setForeground(new Color(153, 153, 153, 150));
            jTfFirstName.setText("John");
        }
        jTfFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jTfFirstNameFocusLost

    private void jTextFieldSurnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSurnameFocusGained
        if (jTextFieldSurname.getText().equals("Wick")) {
            jTextFieldSurname.setText("");
            jTextFieldSurname.setForeground(new java.awt.Color(255, 255, 255));
        }
        jTextFieldSurname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jTextFieldSurnameFocusGained

    private void jTextFieldSurnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSurnameFocusLost
        if (jTextFieldSurname.getText().equals("") || jTfFirstName.getText().length() == 0) {
            jTextFieldSurname.setForeground(new Color(153, 153, 153, 150));
            jTextFieldSurname.setText("Wick");
        }
        jTextFieldSurname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jTextFieldSurnameFocusLost

    private void jTextFieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusGained
        if (jTextFieldEmail.getText().equals("example@gmail.com")) {
            jTextFieldEmail.setText("");
            jTextFieldEmail.setForeground(new java.awt.Color(255, 255, 255));
        }
        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jTextFieldEmailFocusGained

    private void jTextFieldEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusLost
        if (jTextFieldEmail.getText().equals("") || jTfFirstName.getText().length() == 0) {
            jTextFieldEmail.setForeground(new Color(153, 153, 153, 150));
            jTextFieldEmail.setText("example@gmail.com");
        }
        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jTextFieldEmailFocusLost

    private void jTextFieldConDiseaseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldConDiseaseFocusGained
        if (jTextFieldConDisease.getText().equals("If you have")) {
            jTextFieldConDisease.setText("");
            jTextFieldConDisease.setForeground(new java.awt.Color(255, 255, 255));
        }
        jTextFieldConDisease.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jTextFieldConDiseaseFocusGained

    private void jTextFieldConDiseaseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldConDiseaseFocusLost
        if (jTextFieldConDisease.getText().equals("") || jTfFirstName.getText().length() == 0) {
            jTextFieldConDisease.setForeground(new Color(153, 153, 153, 150));
            jTextFieldConDisease.setText("If you have");
        }
        jTextFieldConDisease.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jTextFieldConDiseaseFocusLost

    private void jPasswordSignUpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordSignUpFocusGained
        jPasswordSignUp.setText("");
        jPasswordSignUp.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordSignUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jPasswordSignUpFocusGained

    private void jPasswordSignUpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordSignUpFocusLost
        jPasswordSignUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jPasswordSignUpFocusLost

    private void jPasswordConfirmPassSignupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordConfirmPassSignupFocusGained
        jPasswordConfirmPassSignup.setText("");
        jPasswordConfirmPassSignup.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordConfirmPassSignup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jPasswordConfirmPassSignupFocusGained

    private void jPasswordConfirmPassSignupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordConfirmPassSignupFocusLost
        jPasswordConfirmPassSignup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jPasswordConfirmPassSignupFocusLost

    private void jButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignUpActionPerformed
        String name = null;
        String surname = null;
        String gender = null;
        Date birthDate = null;
        String conDisease = null;
        String email = null;
        String tel = null;
        String deptID = null;
        String oldPass = null;
        String newPass = null;
        StringBuffer sb = null;
        String position = null;
        String telephone = null;
        String picture = null;
        jLabelNoticName.setText("");
        jLabelNoticSurname.setText("");
        jLabelNoticGender.setText("");
        jLabelNoticBirthDate.setText("");
        jLabelNoticNewPass.setText("");
        jLabelNoticOldPass.setText("");
        jLabelNoticPosition.setText("");
        jLabelNoticTel.setText("");
        jLabelEmailNotCorrect.setText("");
        jLabelifLengthId.setText("");
        //jTfFirstName----------------------------------------------------------
        boolean checkName = jTfFirstName.getText().equals("John") == false;
        if (checkName) {
            name = jTfFirstName.getText();
        } else {
            jLabelNoticName.setText("Name is empty!");
        }

        //jTfSurName----------------------------------------------------------
        boolean checkSurname = jTextFieldSurname.getText().equals("Wick") == false;
        if (checkSurname) {
            surname = jTextFieldSurname.getText();
        } else {
            jLabelNoticSurname.setText("Surname is empty!");
        }

        //jRadio Gender---------------------------------------------------------
        boolean checkGender = jRadioButtonGenderMale.getActionCommand().equals("1")
                || jRadioButtonGenderFemale.getActionCommand().equals("0");
        if (jRadioButtonGenderMale.getActionCommand().equals("1")) {
            gender = "M";
        } else if (jRadioButtonGenderFemale.getActionCommand().equals("0")) {
            gender = "F";
        } else {
            jLabelNoticGender.setText("Gender is empty!");
        }

        //jDateChooserBirthDate-------------------------------------------------
        if (jDateChooserBirthDate.getDate() != null) {
            birthDate = jDateChooserBirthDate.getDate();
        } else {
            jLabelNoticBirthDate.setText("Birthdate is empty!");
        }
        boolean checkBirthDate = jDateChooserBirthDate.getDate() != null;

        //jComboBoxPosition-----------------------------------------------------
        if (jComboBoxPosition.getSelectedIndex() == 0) {
            position = "-";
        } else if (jComboBoxPosition.getSelectedIndex() == 1) {
            position = "Student";
        } else if (jComboBoxPosition.getSelectedIndex() == 2) {
            position = "Professor";
        } else if (jComboBoxPosition.getSelectedIndex() == 3) {
            position = "Technician";
        } else if (jComboBoxPosition.getSelectedIndex() == 4) {
            position = "Official";
        } else {
            jLabelNoticPosition.setText("Position is empty!");
        }

        //jFormatTextFieldForId-----------------------------------------------------
        boolean checkIdTextField = jFormatTextFieldForId.getValue() != null;
        if (checkIdTextField) {
            deptID = (String) jFormatTextFieldForId.getValue();
            int temp = deptID.length();
            if (temp > 11) {
                jLabelifLengthId.setText("Error incorrect");
            }
        } else {
            jLabelifLengthId.setText("ID is empty!");
        }

        //jLbCongenitialDisease-----------------------------------------------------
        if (jTextFieldConDisease.getText().equals("If you have") == false) {
            conDisease = jTextFieldConDisease.getText();
        } else {
            conDisease = null;
        }

//        jTextFieldTelophone----------------------------------------------------------
        boolean checkTelNumber = jTextFieldTelophone.getText().equals("090xxxxxxx") == false;
        if (checkTelNumber) {
            telephone = jTextFieldTelophone.getText();
        } else {
            jLabelNoticTel.setText("Telophone number is empty!");
        }

//        jTextFieldEmail-------------------------------------------------------
        boolean checkEmailTextField = jTextFieldEmail.getText().equals("example@gmail.com") == false;
        if (checkEmailTextField) {
            email = jTextFieldEmail.getText();
        } else {
            jLabelEmailNotCorrect.setText("Email is empty!");
        }

//        jPasswordSignUp-------------------------------------------------------
        if (jPasswordSignUp.getText().equals("Oldpassword") == false
                && jPasswordConfirmPassSignup.getText().equals("Newpassword") == false) {
            oldPass = jPasswordSignUp.getText();
            newPass = jPasswordConfirmPassSignup.getText();
            String password = password(oldPass, newPass);
            sb = rs.encocdMd5(password);
        } else {
            jLabelNoticOldPass.setText("Password is empty!");
        }

        boolean checkEmail = rs.connectDBforCheckEmail(email);
        if (jLabelPartPictureUserUpload.getText().equals("Not Select File")) {
            picture = "default";
        } else {
            picture = jLabelPartPictureUserUpload.getText();
        }

        if ((checkName) && (checkSurname) && (checkGender)
                && (checkBirthDate) && (checkEmailTextField) && (checkTelNumber)
                && (checkIdTextField) && (sb != null)) {
            if (checkEmail == true) {
                ac.insertDataUser(name, surname, gender, birthDate, conDisease, email,
                        telephone, deptID, sb, position, picture);
                login.setVisible(true);
                registerPage.setVisible(false);
            } else if (checkEmail == false) {
                jLabelEmailNotCorrect.setText("This email is already registered");
            }
        }
    }//GEN-LAST:event_jButtonSignUpActionPerformed

    private void jRadioButtonGenderFemaleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButtonGenderFemaleFocusGained
        jRadioButtonGenderFemale.setActionCommand("0");
    }//GEN-LAST:event_jRadioButtonGenderFemaleFocusGained

    private void jRadioButtonGenderMaleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButtonGenderMaleFocusGained
        jRadioButtonGenderMale.setActionCommand("1");
    }//GEN-LAST:event_jRadioButtonGenderMaleFocusGained

    private void jButtonChooseFileForUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseFileForUploadActionPerformed
        JFileChooser file = new JFileChooser();
        String userhome = System.getProperty("user.home");
        file.setCurrentDirectory(new File(userhome));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLabelPartPictureUserUpload.setText(path);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            jLabelPartPictureUserUpload.setText("No File Select");
        }
    }//GEN-LAST:event_jButtonChooseFileForUploadActionPerformed

    private void menuSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSignupMouseClicked
        registerPage.setVisible(true);
        login.setVisible(false);
    }//GEN-LAST:event_menuSignupMouseClicked

    private void jFormatTextFieldForIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormatTextFieldForIdFocusGained
        jFormatTextFieldForId.setForeground(new java.awt.Color(255, 255, 255));
        jFormatTextFieldForId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 175, 248)));
    }//GEN-LAST:event_jFormatTextFieldForIdFocusGained

    private void jFormatTextFieldForIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormatTextFieldForIdFocusLost
        jFormatTextFieldForId.setForeground(new Color(153, 153, 153, 150));
        jFormatTextFieldForId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jFormatTextFieldForIdFocusLost

    private void support1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_support1MouseClicked
        canCounter1.setForeground(new java.awt.Color(240, 240, 240));
        bikeSharing1.setForeground(new java.awt.Color(240, 240, 240));
        timer1.setForeground(new java.awt.Color(240, 240, 240));
        profile1.setForeground(new java.awt.Color(240, 240, 240));
        support1.setForeground(new java.awt.Color(19, 175, 248));
        cpPage1.setVisible(false);
        sharingScroll.setVisible(false);
        sharingStep3.setVisible(false);
        timePageT.setVisible(false);
        timePageF.setVisible(false);
        userProfilePage1.setVisible(false);
        supportPage1.setVisible(true);
        jTAContact.setText(sp.contact());
        jTAShowyouSearch.setText("");
    }//GEN-LAST:event_support1MouseClicked

    private void search1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyPressed
        jTAShowyouSearch.setText("");
        jTAShowyouSearch.setLineWrap (true); 
        jTAContact.setText(sp.contact()); 
        sp.setOutput("");
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            String whatToSearch = search1.getText();
            sp.searchSupport(whatToSearch);
            jLBWhatsearch1.setText(whatToSearch);
            jTAShowyouSearch.setText(sp.getOutput()); 
            canCounter1.setForeground(new java.awt.Color(240, 240, 240));
            bikeSharing1.setForeground(new java.awt.Color(240, 240, 240));
            timer1.setForeground(new java.awt.Color(240, 240, 240));
            profile1.setForeground(new java.awt.Color(240, 240, 240));
            support1.setForeground(new java.awt.Color(19, 175, 248));
            cpPage1.setVisible(false);
            sharingScroll.setVisible(false);
            sharingStep3.setVisible(false);
            timePageT.setVisible(false);
            timePageF.setVisible(false);
            userProfilePage1.setVisible(false);
            supportPage1.setVisible(true);
        }
    }//GEN-LAST:event_search1KeyPressed

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
            java.util.logging.Logger.getLogger(GreenSociety.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GreenSociety.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GreenSociety.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GreenSociety.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GreenSociety().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Background1;
    private javax.swing.JLabel Backgroung2;
    private javax.swing.JLabel GreenSociety;
    private javax.swing.JPanel History;
    private javax.swing.JLabel actionHis;
    private javax.swing.JLabel arrowDownIcon;
    private javax.swing.JLabel arrowDownIcon1;
    private javax.swing.JPanel backAdd;
    private javax.swing.JPanel backBarIcon;
    private javax.swing.JPanel backBarIcon1;
    private javax.swing.JPanel backBarUser;
    private javax.swing.JPanel backBarUser1;
    private javax.swing.JPanel backDelete;
    private javax.swing.JPanel backEdit;
    private javax.swing.JLabel backLogin;
    private javax.swing.JPanel backMenuBar;
    private javax.swing.JPanel backMenuBar1;
    private javax.swing.JLabel backSignin;
    private javax.swing.JLabel backSigninRegis;
    private javax.swing.JButton backStep1;
    private javax.swing.JPanel barIcon;
    private javax.swing.JPanel barIcon1;
    private javax.swing.JPanel barNoti;
    private javax.swing.JPanel barNoti1;
    private javax.swing.JPanel barSearch;
    private javax.swing.JPanel barSearch1;
    private javax.swing.JPanel barTitle1;
    private javax.swing.JPanel barUser;
    private javax.swing.JPanel barUser1;
    private javax.swing.JLabel bikeRepair;
    private javax.swing.JLabel bikeRepair1;
    private javax.swing.JLabel bikeSharing;
    private javax.swing.JLabel bikeSharing1;
    private javax.swing.JFormattedTextField birthProfile;
    private javax.swing.JFormattedTextField birthProfile1;
    private javax.swing.JPanel bodySupport1;
    private javax.swing.JButton borrowBut;
    private javax.swing.JLabel canCounter;
    private javax.swing.JLabel canCounter1;
    private javax.swing.JButton cancleAdminBut;
    private javax.swing.JButton cancleBut;
    private javax.swing.JButton cancleButSharing;
    private javax.swing.JButton chooseImgProfileBut;
    private javax.swing.JButton chooseImgProfileBut1;
    private javax.swing.JLabel circleCp;
    private javax.swing.JLabel circleMini;
    private javax.swing.JLabel circleNoti;
    private javax.swing.JLabel closeBut;
    private javax.swing.JTextField congenProfile;
    private javax.swing.JTextField congenProfile1;
    private javax.swing.JScrollPane contactScroll1;
    private javax.swing.JTextField countOfCan;
    private javax.swing.JPanel cpPage;
    private javax.swing.JPanel cpPage1;
    private javax.swing.JLabel cpUse;
    private javax.swing.JLabel cpUser;
    private javax.swing.JLabel departProfile;
    private javax.swing.JLabel departProfile1;
    private javax.swing.JPanel detailBox;
    private javax.swing.JPanel detailBoxHistory;
    private javax.swing.JLabel detailData;
    private javax.swing.JButton editProfileBut;
    private javax.swing.JButton editProfileBut1;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailProfile;
    private javax.swing.JTextField emailProfile1;
    private javax.swing.JLabel endTime;
    private javax.swing.JTextField forgotEmail;
    private javax.swing.JLabel forgotPass;
    private javax.swing.JPanel forgotPassPage;
    private javax.swing.JTextField genderProfile;
    private javax.swing.JTextField genderProfile1;
    private javax.swing.JLabel history;
    private javax.swing.JLabel history1;
    private javax.swing.JLabel iconBike;
    private javax.swing.JLabel iconBike1;
    private javax.swing.JLabel iconClockBig;
    private javax.swing.JLabel iconEmail;
    private javax.swing.JLabel iconKey;
    private javax.swing.JLabel iconMenu;
    private javax.swing.JLabel iconMenu1;
    private javax.swing.JLabel iconNotHis;
    private javax.swing.JLabel iconNoti1;
    private javax.swing.JLabel iconProfile;
    private javax.swing.JLabel iconProfile1;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel iconSearch1;
    private javax.swing.JLabel imageProfile;
    private javax.swing.JLabel imageProfile1;
    private javax.swing.JPanel inputForgot;
    private javax.swing.JLabel isCp;
    private javax.swing.JTextField itemAmount;
    private javax.swing.JTextField itemId;
    private javax.swing.JButton itemList;
    private javax.swing.JPanel itemListPage;
    private javax.swing.JScrollPane itemListScroll;
    private javax.swing.JPanel itemListShow;
    private javax.swing.JPanel itemListShowInsidee;
    private javax.swing.JTextField itemName;
    private javax.swing.JButton jButtonChooseFileForUpload;
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JComboBox<String> jComboBoxPosition;
    private com.toedter.calendar.JDateChooser jDateChooserBirthDate;
    private javax.swing.JFormattedTextField jFormatTextFieldForId;
    private javax.swing.JLabel jLBShowingResult1;
    private javax.swing.JLabel jLBWhatsearch1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEmailNotCorrect;
    private javax.swing.JLabel jLabelNoticBirthDate;
    private javax.swing.JLabel jLabelNoticGender;
    private javax.swing.JLabel jLabelNoticName;
    private javax.swing.JLabel jLabelNoticNewPass;
    private javax.swing.JLabel jLabelNoticOldPass;
    private javax.swing.JLabel jLabelNoticPosition;
    private javax.swing.JLabel jLabelNoticSurname;
    private javax.swing.JLabel jLabelNoticTel;
    private javax.swing.JLabel jLabelPartPictureUserUpload;
    private javax.swing.JLabel jLabelPictureProfileRegister;
    private javax.swing.JLabel jLabelStarLN;
    private javax.swing.JLabel jLabelifLengthId;
    private javax.swing.JLabel jLbConfirmPassWord;
    private javax.swing.JLabel jLbCongenitialDisease;
    private javax.swing.JLabel jLbDateOfBirth;
    private javax.swing.JLabel jLbEmail;
    private javax.swing.JLabel jLbFirstName;
    private javax.swing.JLabel jLbGender;
    private javax.swing.JLabel jLbId;
    private javax.swing.JLabel jLbLastName;
    private javax.swing.JLabel jLbPassWord;
    private javax.swing.JLabel jLbPosition;
    private javax.swing.JLabel jLbSignUp;
    private javax.swing.JLabel jLbStarBirthDay;
    private javax.swing.JLabel jLbStarConfirmPass;
    private javax.swing.JLabel jLbStarEmail;
    private javax.swing.JLabel jLbStarFirstName;
    private javax.swing.JLabel jLbStarGender;
    private javax.swing.JLabel jLbStarId;
    private javax.swing.JLabel jLbStarPassword;
    private javax.swing.JLabel jLbStarPosition;
    private javax.swing.JLabel jLbStarTelophone;
    private javax.swing.JLabel jLbTelophone;
    private javax.swing.JPanel jPanelSignUp;
    private javax.swing.JPasswordField jPasswordConfirmPassSignup;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordSignUp;
    private javax.swing.JRadioButton jRadioButtonGenderFemale;
    private javax.swing.JRadioButton jRadioButtonGenderMale;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextArea jTAContact;
    private javax.swing.JTextArea jTAShowyouSearch;
    private javax.swing.JTextField jTextFieldConDisease;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldTelophone;
    private javax.swing.JTextField jTfFirstName;
    private javax.swing.JPanel layerAddItem;
    private javax.swing.JLabel listShow;
    private javax.swing.JLabel listTimeup;
    private javax.swing.JPanel login;
    private javax.swing.JPanel mainAdmin;
    private javax.swing.JPanel mainUser;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel menu1;
    private javax.swing.JButton menuAdd;
    private javax.swing.JPanel menuBar;
    private javax.swing.JPanel menuBar1;
    private javax.swing.JButton menuDelete;
    private javax.swing.JButton menuEdit;
    private javax.swing.JPanel menuSharing;
    private javax.swing.JLabel menuSignup;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JTextField nameOfUser;
    private javax.swing.JTextField nameProfile;
    private javax.swing.JTextField nameProfile1;
    private javax.swing.JLabel news;
    private javax.swing.JLabel news1;
    private javax.swing.JButton nextStep;
    private javax.swing.JLabel notiSharing;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel pathImgProfile;
    private javax.swing.JLabel pathImgProfile1;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pic1;
    private javax.swing.JLabel poinsHis;
    private javax.swing.JLabel point1;
    private javax.swing.JLabel point2;
    private javax.swing.JLabel point3;
    private javax.swing.JLabel point4;
    private javax.swing.JLabel pointRemain;
    private javax.swing.JLabel position;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel profile1;
    private javax.swing.JRadioButton radioEquip;
    private javax.swing.JRadioButton radioType;
    private javax.swing.JPanel registerPage;
    private javax.swing.JScrollPane resultScroll1;
    private javax.swing.JLabel s1;
    private javax.swing.JSeparator s10;
    private javax.swing.JSeparator s3;
    private javax.swing.JSeparator s4;
    private javax.swing.JSeparator s5;
    private javax.swing.JSeparator s6;
    private javax.swing.JSeparator s7;
    private javax.swing.JSeparator s8;
    private javax.swing.JLabel s9;
    private javax.swing.JLabel sEmailB;
    private javax.swing.JLabel sEmailG;
    private javax.swing.JLabel sPassB;
    private javax.swing.JLabel sPassG;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JPanel sharingPage;
    private javax.swing.JPanel sharingPageTab;
    private javax.swing.JScrollPane sharingScroll;
    private javax.swing.JPanel sharingStep1;
    private javax.swing.JPanel sharingStep3;
    private javax.swing.JLabel showCp;
    private javax.swing.JLabel showPass;
    private javax.swing.JButton signin;
    private javax.swing.JButton signout;
    private javax.swing.JButton signout1;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JButton submitBut;
    private javax.swing.JButton submitButSharing;
    private javax.swing.JLabel submitPass;
    private javax.swing.JButton submitProfile;
    private javax.swing.JButton submitProfile1;
    private javax.swing.JLabel support;
    private javax.swing.JLabel support1;
    private javax.swing.JPanel supportPage1;
    private javax.swing.JTextField surnameOfUser;
    private javax.swing.JTextField telProfile;
    private javax.swing.JTextField telProfile1;
    private javax.swing.JLabel textCpUse;
    private javax.swing.JLabel textNotHis;
    private javax.swing.JLabel textRemain;
    private javax.swing.JLabel textYourCP;
    private javax.swing.JLabel timeLeftShow;
    private javax.swing.JPanel timePageF;
    private javax.swing.JPanel timePageT;
    private javax.swing.JLabel timer;
    private javax.swing.JLabel timer1;
    private javax.swing.JPanel timeupInside;
    private javax.swing.JPanel timeupPage;
    private javax.swing.JPanel timewatch;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel titleAbout;
    private javax.swing.JLabel titleAbout1;
    private javax.swing.JLabel titleConPass;
    private javax.swing.JLabel titleCongenProfile;
    private javax.swing.JLabel titleCongenProfile1;
    private javax.swing.JLabel titleContact;
    private javax.swing.JLabel titleContact1;
    private javax.swing.JLabel titleContactSupport1;
    private javax.swing.JLabel titleCountCan;
    private javax.swing.JLabel titleDepartProfile;
    private javax.swing.JLabel titleDepartProfile1;
    private javax.swing.JLabel titleEmail;
    private javax.swing.JLabel titleEmailProfile;
    private javax.swing.JLabel titleEmailProfile1;
    private javax.swing.JLabel titleForgotPass;
    private javax.swing.JLabel titleGenderProfile;
    private javax.swing.JLabel titleGenderProfile1;
    private javax.swing.JLabel titleHistory;
    private javax.swing.JLabel titleItemCount;
    private javax.swing.JLabel titleItemId;
    private javax.swing.JLabel titleItemList;
    private javax.swing.JLabel titleItemListShow;
    private javax.swing.JLabel titleItemName;
    private javax.swing.JLabel titleItemTimeUp;
    private javax.swing.JLabel titleLastname;
    private javax.swing.JLabel titleNameProfile;
    private javax.swing.JLabel titleNameProfile1;
    private javax.swing.JLabel titleNameUser;
    private javax.swing.JLabel titleNewPass;
    private javax.swing.JLabel titleNow;
    private javax.swing.JLabel titleSignout;
    private javax.swing.JLabel titleSignout1;
    private javax.swing.JLabel titleSignup;
    private javax.swing.JLabel titleTelProfile;
    private javax.swing.JLabel titleTelProfile1;
    private javax.swing.JLabel titleUserId;
    private javax.swing.JLabel titleUserId1;
    private javax.swing.JLabel titleWhat;
    private javax.swing.JLabel titlebBirthProfile;
    private javax.swing.JLabel titlebBirthProfile1;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userID1;
    private javax.swing.JPanel userProfilePage;
    private javax.swing.JPanel userProfilePage1;
    private javax.swing.JLabel warning;
    private javax.swing.JLabel warningProfile;
    private javax.swing.JLabel warningProfile1;
    // End of variables declaration//GEN-END:variables
}
