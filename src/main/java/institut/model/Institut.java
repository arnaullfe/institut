package institut.model;

import java.util.ArrayList;

public class Institut {
    private String nomInstitut;
    private ArrayList<Matricula> matricules = new ArrayList<>();
    private ArrayList<Modul> moduls = new ArrayList<>();

    public Institut() {
    }

    public String getNomInstitut() {
        return nomInstitut;
    }

    public void setNomInstitut(String nomInstitut) {
        this.nomInstitut = nomInstitut;
    }

    public ArrayList<Matricula> getMatricules() {
        return matricules;
    }

    public void setMatricules(ArrayList<Matricula> matricules) {
        this.matricules = matricules;
    }

    public ArrayList<Modul> getModuls() {
        return moduls;
    }

    public void setModuls(ArrayList<Modul> moduls) {
        this.moduls = moduls;
    }
}
