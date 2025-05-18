package com.example.esirunv2.core;

public class MoyenTransport implements Suspendable{
    private String identifiant;
    private boolean suspendu;

    public MoyenTransport(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiant() { return identifiant; }    
    public String toString() { return identifiant ;}

    public void suspendre() {suspendu = true;}
    public void reactiver() {suspendu = false;}

    public String getEtat(){
        return suspendu ? "SUSPENDED" : "REACTIVED";
    }

    public boolean estSuspendu(){
        return suspendu;
    }

    @Override
    public int hashCode() {
        return identifiant.hashCode();
    }

    public int compareTo(Suspendable o) {
            return hashCode() - ((MoyenTransport) o).hashCode();
    }
}