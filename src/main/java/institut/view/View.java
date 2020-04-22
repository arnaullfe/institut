package institut.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class View<JDataChooser> extends JFrame {
    public ImageIcon iiValid,iiNoValid;
    /*<-----------------FONTS------------------------->*/
    public Font titol = new Font("Dyuthi",Font.BOLD,40);
    public Font cos = new Font("Liberation Serif",Font.ITALIC,18);
    /*<-----------------PANELLS----------------------->*/
    public JPanel jpInici,jpAdministracio,jpCanviarDades,jpNovaMatricula,jpNovaMatricula2,jpTutor,jpTutorNotes,jpTitol;
    /*<-----------------ADMINISTRACIÓ----------------------->*/
    public JLabel jlSelAlumMatricula,jlMateriesCursades;
    public JButton jbNovaMatricula, jbCanviarDadesAlumn, jbGenerarBulleti;
    public JList jlLlistaAlumn;
    public DefaultListModel modelLlistaAlumn;
    public JTextField jtfBuscarAlumn;
    public JTable jtMateries;
    public DefaultTableModel modelTaulamateriesMatriculades;
    /*<-----------------CanviarDades----------------------->*/
    public JLabel jlCanviDNI,jlCanviNom,jlCanviCognom,jlCanviTel,jlCanviCorreu,jlCanviPoblació,jlCanviAddress,jlCanviNaixament;
    public JTextField jtCanviDNI,jtCanviNom,jtCanviCognom,jtCanviTel,jtCanviCorreu,jtCanviPoblació,jtCanviAddress;
    public JLabel iconCanviDni,iconCanviNom,iconCanviCognom,iconCanviTel,iconCanviCorreu,iconCanviPoblació,iconCanviAddress,iconCanviNaixament;
    public JButton jbGuardarCanvis,jbCancelCanvis;
    public JDataChooser jdcCanviNaix;
    /*<-----------------NovaMatricula----------------------->*/
    public JLabel jlNouDni,jlNouNom,jlNouCognom,jlNouTel,jlNouCorreu,jlNouPoblació,jlNouAddress,jlNuNaixament;
    public JTextField jtNouDNI,jtNouNom,jtNouCognom,jtNouTel,jtNouCorreu,jtNouPoblació,jtNouAddress;
    public JLabel iconNouDni,iconNouNom,iconNouCognom,iconNouTel,iconNouCorreu,iconNouPoblació,iconNouAddress,iconNouNaixament;
    public JButton jbNouSeguent,jbFerMatricula;
    public JDataChooser jdcNouNaix;
    /*<-----------------Tutor----------------------->*/
    public JLabel jlAlumnesTutor,jlAlumneCanviNota;
    public JTable jtTaulaAlumnesTutor,jtTaulaNotesAlum;
    public DefaultTableModel dtModelAlumnesTutor,dtModelTaulaNotesAlum;
    /*<-----------------Inici----------------------->*/
    public JLabel jlInici;
    public JTextField jtfCanviNomInsti;
    public JButton jbCanviNomInsti;
    /*<-----------------titol----------------------->*/
    public JLabel jlTitol;
    /*<-----------------MENU----------------------->*/
    public JLabel jlInstitut;
    public JMenuBar menuBar;
    public JMenu menu;
    public JMenuItem jmiHome,jmiAdministracio,jmiTutor;

    public View(){
        this.setVisible(true);
        this.setSize(700,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(null);
        iniciarComponents();

    }

    public void iniciarComponents(){
        crearPanells();
        dissenyMenu();
        dissenyTitol();
        dissenyInici();
        dissenyAdministracio();
        dissenyTutor();
        omplirImageIcon();
    }
    public void crearPanells(){
        for(int i=0;i<7;i++){
            JPanel panell = new JPanel();
            panell.setBounds(0, 40, this.getWidth(), this.getHeight()-40);
            panell.setLayout(null);
            panell.setBackground(Color.LIGHT_GRAY);
            panell.setVisible(false);
            this.getContentPane().add(panell);
        }

        jpTitol = new JPanel();
        jpTitol.setBounds(0,0,this.getWidth(),40);
        jpTitol.setLayout(null);
        this.getContentPane().add(jpTitol);
    }
    private void omplirImageIcon() {
        ImageIcon valid = new ImageIcon("img/icons/valid.png");
        //iiValid = new ImageIcon(valid.getImage().getScaledInstance(iconCanviDni.getWidth(), iconCanviDni.getHeight(), Image.SCALE_SMOOTH));
        ImageIcon noValid = new ImageIcon("img/icons/no_valid.png");
        //iiNoValid = new ImageIcon(noValid.getImage().getScaledInstance(iconCanviDni.getWidth(), iconCanviDni.getHeight(), Image.SCALE_SMOOTH));
    }
    private void dissenyMenu(){
        menuBar = new JMenuBar();
        menuBar.setBounds(0,0,this.getWidth(),40);
        menu = new JMenu();
        menu.setBounds(0,0,40,40);
        ImageIcon despl = new ImageIcon("img/icon.png");
        ImageIcon image = new ImageIcon(despl.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH));
        menu.setIcon(image);

        jmiHome = new JMenuItem("Inici");
        jmiHome.setName("home");
        jmiAdministracio = new JMenuItem("Administració");
        jmiAdministracio.setName("Administracio");
        jmiTutor = new JMenuItem("Tutor");
        jmiTutor.setName("Tutor");
        menu.add(jmiHome);
        menu.addSeparator();
        menu.add(jmiAdministracio);
        menu.addSeparator();
        menu.add(jmiTutor);
        menuBar.add(menu);

        jlInstitut = new JLabel("Cirvianum");
        jlInstitut.setBounds(100,0,menuBar.getWidth(),40);
        jlInstitut.setHorizontalAlignment(SwingConstants.CENTER);
        jlInstitut.setFont(titol);
        menuBar.add(jlInstitut);
        this.setJMenuBar(menuBar);
        this.validate();
        this.repaint();
    }
    private void dissenyTitol() {
        jlTitol = new JLabel("Inici");
        jlTitol.setBounds(0,0,jpTitol.getWidth(),40);
        jlTitol.setFont(titol);
        jlTitol.setHorizontalAlignment(SwingConstants.CENTER);
        jpTitol.add(jlTitol);
    }

    private void dissenyInici(){
        jpInici = (JPanel) this.getContentPane().getComponent(0);
        jlInici = new JLabel("Benvinguts al software sobre el control d'instituts. pots canviar el nom del institut aquí:");
        jlInici.setBounds(20,60,this.getWidth()-40,40);
        jlInici.setFont(cos);
        jpInici.add(jlInici);

        jtfCanviNomInsti = new JTextField();
        jtfCanviNomInsti.setBounds(80,110,this.getWidth()-160,30);
        jpInici.add(jtfCanviNomInsti);

        jbCanviNomInsti = new JButton();
        jbCanviNomInsti.setText("Canviar");
        jbCanviNomInsti.setBounds(280,170,this.getWidth()-560,30);
        jpInici.add(jbCanviNomInsti);
        jpInici.setVisible(true);
        jpInici.setBackground(Color.LIGHT_GRAY);
    }

    private void dissenyAdministracio(){
        jpAdministracio = (JPanel) this.getContentPane().getComponent(1);
        jlSelAlumMatricula = new JLabel("SELECCIONAR ALUMNE:");
        jlSelAlumMatricula.setFont(cos);
        jlSelAlumMatricula.setBounds(30,15,201,30);
        jlSelAlumMatricula.setHorizontalAlignment(SwingConstants.LEFT);
        jpAdministracio.add(jlSelAlumMatricula);

        jbNovaMatricula = new JButton();
        jbNovaMatricula.setText("Crear nova Matricula");
        jbNovaMatricula.setBounds(400,70,230,50);
        jpAdministracio.add(jbNovaMatricula);

        jbCanviarDadesAlumn = new JButton();
        jbCanviarDadesAlumn.setText("Canviar dades alumne seleccionat");
        jbCanviarDadesAlumn.setBounds(400,165,230,50);
        jpAdministracio.add(jbCanviarDadesAlumn);

        jtfBuscarAlumn = new JTextField();
        jtfBuscarAlumn.setBounds(30,60,201,30);
        jtfBuscarAlumn.setHorizontalAlignment(SwingConstants.LEFT);
        jpAdministracio.add(jtfBuscarAlumn);

        modelLlistaAlumn = new DefaultListModel();
        jlLlistaAlumn = new JList(modelLlistaAlumn);
        jlLlistaAlumn.setBounds(30,100,201,150);
        jpAdministracio.add(jlLlistaAlumn);
        JScrollPane scrollLlista = new JScrollPane(jlLlistaAlumn,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollLlista.setBounds(30,100,jlLlistaAlumn.getWidth(),jlLlistaAlumn.getHeight());
        jpAdministracio.add(scrollLlista);

        jlMateriesCursades = new JLabel("Materies Matriculades Per L'alumne:");
        jlMateriesCursades.setBounds(30,270,this.getWidth()-60,30);
        jlMateriesCursades.setFont(cos);
        jlMateriesCursades.setHorizontalAlignment(SwingConstants.CENTER);
        jpAdministracio.add(jlMateriesCursades);

        modelTaulamateriesMatriculades = new DefaultTableModel();
        modelTaulamateriesMatriculades.addColumn("Modul");
        modelTaulamateriesMatriculades.addColumn("Nº UF");
        modelTaulamateriesMatriculades.addColumn("Nom UF");
        modelTaulamateriesMatriculades.addColumn("Hores");
        jtMateries = new JTable(modelTaulamateriesMatriculades);
        jtMateries.setEnabled(false);
        jtMateries.setBounds(30,300,this.getWidth()-60,200);
        jpAdministracio.add(jtMateries);
        JScrollPane scrolltaula = new JScrollPane(jtMateries,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrolltaula.setBounds(30,300,jtMateries.getWidth(),jtMateries.getHeight());
        jpAdministracio.add(scrolltaula);

        jbGenerarBulleti = new JButton();
        jbGenerarBulleti.setText("Generar Bulletí de notes");
        jbGenerarBulleti.setBounds(200,520,this.getWidth()-400,40);
        jpAdministracio.add(jbGenerarBulleti);

    }
    private void dissenyTutor(){
        jpTutor = (JPanel) this.getContentPane().getComponent(5);
    }
}
