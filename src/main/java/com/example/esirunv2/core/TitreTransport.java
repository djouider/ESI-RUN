package com.example.esirunv2.core;

import java.time.LocalDate;

// Classe abstraite pour les titres de transport

public abstract class TitreTransport
{
 static int globalId;
    protected int id;
    protected LocalDate dateAchat;
    protected LocalDate dateExperation;
    protected double prix;

    public LocalDate getDateAchat() {
        return dateAchat;
    }
    public int getId()
    {
        return id;
    }
    public double getPrix()
    {
        return prix;
    }

    public abstract boolean estValide(LocalDate date)throws TitreNonValideException;



}
