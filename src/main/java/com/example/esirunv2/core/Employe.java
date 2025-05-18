package com.example.esirunv2.core;// Classe Employé

import java.time.LocalDate;

public class Employe extends Personne {

    private TypeFonction typefonction;
    private String matricule;

    public Employe(String nom, String prenom, LocalDate dateNaissance,boolean handicap, String matricule, TypeFonction typefonction) {
        super(nom,prenom,dateNaissance,handicap);
        this.typefonction = typefonction;
        this.matricule = matricule;
    }
    public Employe(String matricule, TypeFonction typefonction) {
        this.typefonction = typefonction;
        this.matricule = matricule;
    }

    public Employe(){}

    public void SetFields(String nom, String prenom, LocalDate dateNaissance,boolean handicap) {
        super.SetFields(nom,prenom,dateNaissance,handicap);
    }


    public String getmatricule() {
        return matricule;
    }
    public TypeFonction getTypefonction() {
        return typefonction;
    }

    @Override
    public int compareTo(Personne o) {
        if (o instanceof Employe){
            return matricule.compareTo(((Employe) o).matricule);
        } else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        return this.matricule.hashCode();
    }
    
}