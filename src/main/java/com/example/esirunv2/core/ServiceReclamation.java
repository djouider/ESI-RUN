package com.example.esirunv2.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ServiceReclamation {
    private  final int SEUIL = 3;
    private  Map<TypeReclamation,TreeSet<Reclamation>> reclamationsParType = new TreeMap<>();
    private  Map<Personne, TreeSet<Reclamation>> reclamationsParPersonne = new HashMap<>();
    private  Map<Suspendable, TreeSet<Reclamation>> reclamationsParSuspendable = new HashMap<>();


    public void soumettre(Reclamation r){

        TreeSet<Reclamation> Tree =reclamationsParType.get(r.getType());
        if(Tree==null){
            Tree = new TreeSet<Reclamation>();
            Tree.add(r);
            reclamationsParType.put(r.getType(),Tree);
        }
        else {
            Tree.add(r);
        }

        Tree =reclamationsParPersonne.get(r.getPersonne());
        if(Tree==null){
            Tree = new TreeSet<Reclamation>();
            Tree.add(r);
            reclamationsParPersonne.put(r.getPersonne(),Tree);
        }
        else {
            Tree.add(r);
        }

        Tree =reclamationsParSuspendable.get(r.getCible());
        if(Tree==null){
            Tree = new TreeSet<Reclamation>();
            Tree.add(r);
            reclamationsParSuspendable.put(r.getCible(),Tree);
        }
        else {
            Tree.add(r);
            if (Tree.size() >= SEUIL) {
                r.getCible().suspendre();
            }
        }

//        afficherReclamations();


//         reclamationsParPersonne.put(r.getPersonne(), reclamations);
//
//         reclamationsParSuspendable.put(r.getCible(),reclamations);
    }

    public void resoudre(Reclamation r){
        TreeSet<Reclamation> Tree =reclamationsParType.get(r.getType());
        if(Tree==null){
        }
        else {
            Tree.remove(r);
        }

        Tree =reclamationsParPersonne.get(r.getPersonne());
        if(Tree==null){
        }
        else {
            Tree.remove(r);
        }

        Tree =reclamationsParSuspendable.get(r.getCible());
        if(Tree==null){
        }
        else {
            Tree.remove(r);
            if (Tree.size() < SEUIL) {
                r.getCible().reactiver();
            }
        }

    }

    public void afficherReclamations(){

        for (TypeReclamation key : reclamationsParType.keySet()) {
            System.out.println("---------------------Reclamation de type "+key.toString());
            TreeSet<Reclamation> value = reclamationsParType.get(key);
            for (Reclamation o : value) {
                System.out.println("Reclamation #"+o.getNumero());
                System.out.println("Date :"+o.getDate()+"| Type :"+o.getType()+"| Cible :"+o.getCible()+"| Description :"+o.getDescription()+"| Soumise par :"+o.getPersonne().toString()+"\n");
            }
        }
    }

    public void afficherReclamations(Personne p){
            TreeSet<Reclamation> value = reclamationsParPersonne.get(p);
            for (Reclamation o : value) {
                System.out.println("Reclamation #" + o.getNumero());
                System.out.println("Date :" + o.getDate() + "| Type :" + o.getType() + "| Cible :" + o.getCible() + "| Description :" + o.getDescription() + "| Soumise par :" + o.getPersonne().toString()+"\n");}
    }

    public void afficherReclamations(Suspendable p){
        TreeSet<Reclamation> value = reclamationsParSuspendable.get(p);
        for (Reclamation o : value) {
            System.out.println("Reclamation #" + o.getNumero());
            System.out.println("Date :" + o.getDate() + "| Type :" + o.getType() + "| Cible :" + o.getCible() + "| Description :" + o.getDescription() + "| Soumise par :" + o.getPersonne().toString()+"\n");}
    }
}