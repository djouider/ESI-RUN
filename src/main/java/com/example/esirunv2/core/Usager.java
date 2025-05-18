package com.example.esirunv2.core;
// Classe Usager

import java.time.LocalDate;

public class Usager extends Personne {

    static private int Globalid=0;
    private int id;

    public Usager(String nom,String prenom,LocalDate dateNaissance,boolean handicaped) {
        super(nom, prenom, dateNaissance, handicaped);
        id = Globalid;
        Globalid++;
    }

    public Usager() {
        id = Globalid;
        Globalid++;
    }

    public void SetFields(String nom,String prenom,LocalDate dateNaissance,boolean handicaped){
        super.SetFields( nom, prenom, dateNaissance, handicaped );
    }

    @Override
    public int compareTo(Personne o) {
        return toString().compareTo(o.toString());
    }

    public int hashCode() {
        return this.toString().hashCode();
    }
}