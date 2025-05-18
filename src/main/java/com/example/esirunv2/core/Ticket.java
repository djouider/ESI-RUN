package com.example.esirunv2.core;

import java.time.LocalDate;

public class Ticket extends TitreTransport{

    private boolean Valable;


    public Ticket()
    {
        id=globalId++;
        dateAchat= LocalDate.now();
        dateExperation = dateAchat;
        prix=50;
        Valable=true;
    }

    public boolean estValide(LocalDate date) throws TitreNonValideException
    {
        if(date.isEqual(dateExperation) && Valable)
            return true;
        else throw new TitreNonValideException("Ticket numéro"+id+ "expiré - valable uniquement le :"+ dateExperation);

    }


}
