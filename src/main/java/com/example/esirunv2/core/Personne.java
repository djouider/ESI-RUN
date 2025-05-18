package com.example.esirunv2.core;

import java.time.LocalDate;

// Classe abstraite Personne
public abstract class Personne {

    protected  String nom;
    protected  String prenom;
    protected  LocalDate dateNaissance;
    protected  boolean handicaped;

    public Personne(String nom,String prenom,LocalDate dateNaissance,boolean handicaped)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
        this.handicaped=handicaped;
    }

    public Personne() {}
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public LocalDate getDateNaissance() {return dateNaissance;}
    public boolean getHandicaped() {return handicaped;}

    public void SetFields(String nom,String prenom,LocalDate dateNaissance,boolean handicaped){
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
        this.handicaped=handicaped;
    }

}
