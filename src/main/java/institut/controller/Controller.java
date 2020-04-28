package institut.controller;

import institut.model.Fitxer;
import institut.model.Institut;
import institut.view.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Institut institut;
    private int idMatricula = 1;
    private Fitxer fitxer;

    public Controller(){
        view = new View();
        institut = new Institut();
        fitxer = new Fitxer();
        listeners();
    }
    public void listeners(){
        listenerMenuItem();
        listenerCanviNomInstitut();
        listenerBotonsCanviPanellAdministracio();
    }

    public void listenerMenuItem(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view.jmiHome){
                    view.jlTitol.setText("Inici");
                    view.canviPanell(view.jpInici);
                } else if(e.getSource()==view.jmiAdministracio){
                    view.jlTitol.setText("Administració");
                    view.canviPanell(view.jpAdministracio);
                } else if(e.getSource()==view.jmiTutor){
                    view.jlTitol.setText("Tutor");
                    view.canviPanell(view.jpTutor);
                }
            }
        };
        view.jmiHome.addActionListener(listener);
        view.jmiAdministracio.addActionListener(listener);
        view.jmiTutor.addActionListener(listener);
    }

    public void listenerCanviNomInstitut(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.jtfCanviNomInsti.getText().isEmpty()){
                    view.jlErrorCanviNom.setVisible(true);
                } else{
                    view.jlErrorCanviNom.setVisible(false);
                    institut.setNomInstitut(view.jtfCanviNomInsti.getText());
                    view.jlInstitut.setText(institut.getNomInstitut());
                    view.natejarTextField(view.jtfCanviNomInsti);
                    JOptionPane.showMessageDialog(view,"S'ha canviat correctament el nom de l'institut!");
                }
            }
        };
        view.jbCanviNomInsti.addActionListener(listener);
    }

    public void listenerBotonsCanviPanellAdministracio(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view.jbNovaMatricula){
                    view.canviPanell(view.jpNovaMatricula);
                } else if(e.getSource()==view.jbCanviarDadesAlumn){
                    view.canviPanell(view.jpCanviarDades);
                }
            }
        };
        view.jbNovaMatricula.addActionListener(listener);
        view.jbCanviarDadesAlumn.addActionListener(listener);
    }
}
