package institut.view;

import com.toedter.calendar.JDateChooser;

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
    public JLabel jlNovesDadesAlumne,jlNouDni,jlNouNom,jlNouCognom,jlNouTel,jlNouCorreu,jlNouPoblació,jlNouAddress,jlNouNaixament;
    public JTextField jtfNouDNI,jtfNouNom,jtfNouCognom,jtfNouTel,jtfNouCorreu,jtfNouPoblació,jtfNouAddress;
    public JLabel iconNouDni,iconNouNom,iconNouCognom,iconNouTel,iconNouCorreu,iconNouPoblació,iconNouAddress,iconNouNaixament;
    public JButton jbNouDades,jbFerMatricula;
    public JDateChooser jdcNouNaix;
    /*<-----------------Tutor----------------------->*/
    public JLabel jlAlumnesTutor,jlAlumneCanviNota;
    public JTable jtTaulaAlumnesTutor,jtTaulaNotesAlum;
    public DefaultTableModel dtModelAlumnesTutor,dtModelTaulaNotesAlum;
    /*<-----------------Inici----------------------->*/
    public JLabel jlInici,jlErrorCanviNom;
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
        dissenyNovaMatricula();
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
        jpCanviarDades = (JPanel) this.getContentPane().getComponent(2);
        jpNovaMatricula2 = (JPanel) this.getContentPane().getComponent(4);
        jpTutorNotes = (JPanel) this.getContentPane().getComponent(5);

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
        ImageIcon image = new ImageIcon(despl.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        menu.setIcon(image);

        jmiHome = new JMenuItem("Home");
        ImageIcon home = new ImageIcon("img/home.png");
        jmiHome.setIcon(new ImageIcon(home.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH)));
        jmiAdministracio = new JMenuItem("Administració");
        ImageIcon admin = new ImageIcon("img/folder-open.png");
        jmiAdministracio.setIcon(new ImageIcon(admin.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH)));
        jmiTutor = new JMenuItem("Tutor");
        ImageIcon tutor = new ImageIcon("img/user-tie.png");
        jmiTutor.setIcon(new ImageIcon(tutor.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH)));
        menu.add(jmiHome);
        menu.addSeparator();
        menu.add(jmiAdministracio);
        menu.addSeparator();
        menu.add(jmiTutor);
        menuBar.add(menu);

        jlInstitut = creacioJLabel("Cirvianum",100,0,menuBar.getWidth(),40,SwingConstants.CENTER,titol);
        menuBar.add(jlInstitut);
        this.setJMenuBar(menuBar);
        this.validate();
        this.repaint();
    }
    private void dissenyTitol() {
        jlTitol= creacioJLabel("Inici",0,0,jpTitol.getWidth(),40,SwingConstants.CENTER,titol);
        jpTitol.add(jlTitol);
    }

    private void dissenyInici(){
        jpInici = (JPanel) this.getContentPane().getComponent(0);
        String text = "Benvinguts al software sobre el control d'instituts. pots canviar el nom del institut aquí:";
        jlInici = creacioJLabel(text,20,60,this.getWidth()-40,40,-1,cos);

        jtfCanviNomInsti = new JTextField();
        jtfCanviNomInsti.setBounds(80,110,this.getWidth()-160,30);

        String textError = "No és pot canviar el nom de l'institut perquè no s'ha introduït un nou nom!";
        jlErrorCanviNom = creacioJLabel(textError,80,145,this.getWidth()-160,30,SwingConstants.CENTER,null);
        jlErrorCanviNom.setForeground(Color.RED);
        jlErrorCanviNom.setVisible(false);

        jbCanviNomInsti = new JButton();
        jbCanviNomInsti.setText("Canviar");
        jbCanviNomInsti.setBounds(280,175,this.getWidth()-560,30);
        Component array [] = {jlInici,jtfCanviNomInsti,jlErrorCanviNom,jbCanviNomInsti};
        afegirComponents(jpInici,array);
        jpInici.setVisible(true);
        jpInici.setBackground(Color.LIGHT_GRAY);
    }

    private void dissenyAdministracio(){
        jpAdministracio = (JPanel) this.getContentPane().getComponent(1);
        jlSelAlumMatricula = creacioJLabel("SELECCIONAR ALUMNE:",30,15,201,30,SwingConstants.LEFT,cos);

        jbNovaMatricula = new JButton("Crear nova Matricula");
        jbNovaMatricula.setBounds(400,70,230,50);

        jbCanviarDadesAlumn = new JButton("Canviar dades alumne seleccionat");
        jbCanviarDadesAlumn.setBounds(400,165,230,50);

        jtfBuscarAlumn = creacioJTextField(30,60,201,30);
        jtfBuscarAlumn.setHorizontalAlignment(SwingConstants.LEFT);

        modelLlistaAlumn = new DefaultListModel();
        jlLlistaAlumn = new JList(modelLlistaAlumn);
        jlLlistaAlumn.setBounds(30,100,201,150);
        JScrollPane scrollLlista = new JScrollPane(jlLlistaAlumn,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollLlista.setBounds(30,100,jlLlistaAlumn.getWidth(),jlLlistaAlumn.getHeight());

        jlMateriesCursades = creacioJLabel("Materies Matriculades Per L'alumne:",30,270,this.getWidth()-60,30,SwingConstants.CENTER,cos);

        modelTaulamateriesMatriculades = new DefaultTableModel();
        modelTaulamateriesMatriculades.addColumn("Modul");
        modelTaulamateriesMatriculades.addColumn("Nº UF");
        modelTaulamateriesMatriculades.addColumn("Nom UF");
        modelTaulamateriesMatriculades.addColumn("Hores");
        jtMateries = new JTable(modelTaulamateriesMatriculades);
        jtMateries.setEnabled(false);
        jtMateries.setBounds(30,300,this.getWidth()-60,200);
        JScrollPane scrolltaula = new JScrollPane(jtMateries,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrolltaula.setBounds(30,300,jtMateries.getWidth(),jtMateries.getHeight());

        jbGenerarBulleti = new JButton("Generar Bulletí de notes");
        jbGenerarBulleti.setBounds(200,520,this.getWidth()-400,40);
        Component array [] = {jlSelAlumMatricula,jbNovaMatricula,jbCanviarDadesAlumn,jtfBuscarAlumn,jlLlistaAlumn,scrollLlista,jlMateriesCursades,jtMateries,scrolltaula,jbGenerarBulleti};
        afegirComponents(jpAdministracio,array);
    }
    private void dissenyTutor(){
        jpTutor = (JPanel) this.getContentPane().getComponent(5);
        String text = "Llista d'alumnes (doble click per entrar a les seves notes) :";
        jlAlumnesTutor = creacioJLabel(text,0,15,this.getWidth(),30,SwingConstants.CENTER,cos);

        dtModelAlumnesTutor = new DefaultTableModel();
        dtModelAlumnesTutor.addColumn("DNI");
        dtModelAlumnesTutor.addColumn("Nom");
        dtModelAlumnesTutor.addColumn("Cognoms");
        jtTaulaAlumnesTutor = new JTable(dtModelAlumnesTutor);
        jtTaulaAlumnesTutor.setBounds(20,45,this.getWidth()-40,500);
        jtTaulaAlumnesTutor.setEnabled(false);
        JScrollPane scrollTaula = new JScrollPane(jtTaulaAlumnesTutor,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTaula.setBounds(20,45,jtTaulaAlumnesTutor.getWidth(),jtTaulaAlumnesTutor.getHeight());
        Component array [] = {jlAlumnesTutor,jtTaulaAlumnesTutor,scrollTaula};
        afegirComponents(jpTutor,array);
    }
    private  void dissenyNovaMatricula(){
        jpNovaMatricula = (JPanel) this.getContentPane().getComponent(3);
        jpNovaMatricula.setBackground(Color.LIGHT_GRAY);
        //public JLabel jlNouAddress,jlNouNaixament;
        jlNovesDadesAlumne = creacioJLabel("Dades de l'alumne",20,15,this.getWidth()-40,30,SwingConstants.CENTER,cos);
        jlNouDni = creacioJLabel("DNI:",175,70,150,30,-1,cos);
        jtfNouDNI = creacioJTextField(375,70,200,30);
        jlNouNom = creacioJLabel("Nom: ",175,110,150,30,-1,cos);
        jtfNouNom = creacioJTextField(375,110,200,30);
        jlNouCognom = creacioJLabel("Cognoms:",175,150,150,30,-1,cos);
        jtfNouCognom = creacioJTextField(375,150,200,30);
        jlNouTel = creacioJLabel("Telèfon: ",175,190,150,30,-1,cos);
        jtfNouTel = creacioJTextField(375,190,200,30);
        jlNouCorreu = creacioJLabel("Correu electrònic: ",175,230,150,30,-1,cos);
        jtfNouCorreu = creacioJTextField(375,230,200,30);
        jlNouPoblació = creacioJLabel("Població: ",175,270,150,30,-1,cos);
        jtfNouPoblació = creacioJTextField(375,270,200,30);
        jlNouAddress = creacioJLabel("Adreça: ",175,310,150,30,-1,cos);
        jtfNouAddress = creacioJTextField(375,310,200,30);
        jlNouNaixament = creacioJLabel("Data de naixament:",175,350,300,30,-1,cos);
        jdcNouNaix = new JDateChooser();
        jdcNouNaix.setBounds(375,350,200,30);
        jbNouDades = new JButton("Següent");
        jbNouDades.setBounds(300,430,150,50);
        Component []components = {jlNovesDadesAlumne,jlNouDni,jtfNouDNI,jlNouNom,jtfNouNom,jlNouCognom,jtfNouCognom, jlNouTel,jtfNouTel,jlNouCorreu,jtfNouCorreu,jlNouPoblació,jtfNouPoblació,jlNouAddress,jtfNouAddress,jlNouNaixament,jdcNouNaix,jbNouDades};
        afegirComponents(jpNovaMatricula,components);

    }

    public void canviPanell(JPanel mostrar){
        JPanel [] array = {jpInici,jpAdministracio,jpCanviarDades,jpNovaMatricula,jpNovaMatricula2,jpTutor,jpTutorNotes};
        for(JPanel a : array){
            if(a!=mostrar){
                a.setVisible(false);
            }
        }
        mostrar.setVisible(true);
    }

    public void natejarTextField(JTextField nateja){
        nateja.setText("");
    }
    public void natejarTextField(JTextField [] nateja){
        for(JTextField a : nateja){
            a.setText("");
        }
    }
    public JLabel creacioJLabel(String text, int x,int y, int width, int height,int alignment, Font font){
        JLabel jlabel = new JLabel(text);
        jlabel.setBounds(x,y,width,height);
        if(alignment!=-1){
            jlabel.setHorizontalAlignment(alignment);
        }
        if(font!=null){
            jlabel.setFont(font);
        }
        return jlabel;
    }
    public JTextField creacioJTextField(int x,int y, int width, int height){
        JTextField jtf = new JTextField();
        jtf.setBounds(x,y,width,height);
        return jtf;
    }
    public void afegirComponents(JPanel panell, Component []array){
        for(Component a : array){
            panell.add(a);
        }
    }
}
