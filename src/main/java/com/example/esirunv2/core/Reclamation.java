package com.example.esirunv2.core;
import java.time.LocalDate;

public class Reclamation implements Comparable{
    private static int compteur = 1; 
    private int numero;
    private LocalDate date;
    private Personne personne;
    private TypeReclamation type;
    private Suspendable cible;
    private String description;


    public Reclamation(Personne personne, TypeReclamation type, Suspendable cible, String description, LocalDate date) {
        this.personne = personne;
        this.type = type;
        this.cible = cible;
        this.description = description;
        this.date = date;
        this.numero = compteur;
        compteur++;
    }

    public Suspendable getCible() { return cible; }
    public int getNumero() { return numero; }
    public LocalDate getDate() { return date; }
    public Personne getPersonne() { return personne; }
    public String getDescription() { return description; }
    public TypeReclamation getType() {return type;}

    public String toString(){
        return type.toString();// à compléter
    }
      public int compareTo(Object o) {
//        if (o instanceof Reclamation){
//            Reclamation r = (Reclamation) o;
//            return numero - r.getNumero();
//        } else {
//            System.out.println("Erreur de comparison o !instanceof Reclamation");
//            return 0;
//        }
        if (type.equals(((Reclamation) o).getType())){
        Reclamation r = (Reclamation) o;
        return numero - r.getNumero();
    }
            else {
        return type.compareTo(((Reclamation) o).getType());
    }
      }



//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Reclamation ){
//
//        }
//    }
}
