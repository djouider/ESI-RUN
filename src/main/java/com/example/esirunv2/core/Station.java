package com.example.esirunv2.core;
public class Station implements Suspendable{
    private String nom;
    private boolean suspendu;

    public Station(String nom) {
        this.nom = nom;
        suspendu = false;
    }

    public String getNom() { return nom;  }

    @Override
    public String toString() { return "Station de " + nom ;}

    public void suspendre(){
        suspendu = true;
    }

    public void reactiver() {suspendu = false;}

    public String getEtat(){
        return suspendu ? "SUSPENDED" : "REACTIVED";
    }

    public boolean estSuspendu(){
        return suspendu;
    }

    public int hashCode() {
        return nom.hashCode();
    }


    public int compareTo(Suspendable o) {
            return hashCode() - ((Station) o).hashCode();
    }
}
