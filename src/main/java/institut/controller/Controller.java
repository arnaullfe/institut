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
    }

    public void listenerMenuItem(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view.jmiHome){
                    view.jlTitol.setText("Inici");
                    view.jpInici.setVisible(true);
                    view.jpAdministracio.setVisible(false);
                    view.jpTutor.setVisible(false);
                } else if(e.getSource()==view.jmiAdministracio){
                    view.jlTitol.setText("Administració");
                    view.jpInici.setVisible(false);
                    view.jpAdministracio.setVisible(true);
                    view.jpTutor.setVisible(false);
                } else if(e.getSource()==view.jmiTutor){
                    view.jlTitol.setText("Tutor");
                    view.jpInici.setVisible(false);
                    view.jpAdministracio.setVisible(false);
                    view.jpTutor.setVisible(true);

                }
            }
        };
        view.jmiHome.addActionListener(listener);
        view.jmiAdministracio.addActionListener(listener);
        view.jmiTutor.addActionListener(listener);
    }


}
