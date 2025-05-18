package com.example.esirunv2.core;

import java.time.LocalDate;
import java.time.Period;

public class CartePersonnelle extends TitreTransport{

    private TypeCart typeCart;
    public CartePersonnelle(Personne personne) throws ReductionImpossibleException {
        if(personne.handicaped) {
            id=globalId++;
            this.dateAchat = LocalDate.now();
            dateExperation = dateAchat.plusYears(1);
            this.prix = 5000 * 0.5;
            typeCart=TypeCart.SOLIDARITE;
        }
            else{
                if(personne instanceof Employe) {
                    id=globalId++;
                    this.dateAchat = LocalDate.now();
                    dateExperation = dateAchat.plusYears(1);
                    this.prix = 5000 * 0.6;
                    typeCart=TypeCart.PARTENAIRE;
                }
                else {
                    if(Period.between(personne.dateNaissance,LocalDate.now()).getYears()<=25)
                    {
                        id=globalId++;
                        this.dateAchat = LocalDate.now();
                        dateExperation = dateAchat.plusYears(1);
                        this.prix = 5000 * 0.7;
                        typeCart=TypeCart.JUNIOR;
                    }
                    else {
                       if (Period.between(personne.dateNaissance,LocalDate.now()).getYears()>=65)
                       {
                           id=globalId++;
                           this.dateAchat = LocalDate.now();
                           dateExperation = dateAchat.plusYears(1);
                           this.prix = 5000 * 0.75;
                           typeCart=TypeCart.SENIOR;
                       }
                       else {
                           throw new ReductionImpossibleException("Création de carte personnelle refusée pour " +personne.nom+personne.prenom+". Vous n'avez droit à aucune réduction.");
                       }
                    }
                }
        }
    }

    public CartePersonnelle() {}

    public boolean estValide(LocalDate date)throws TitreNonValideException{

        if(date.isBefore(dateExperation)) {
            return true;
        }
        else {
            throw new TitreNonValideException("Carte personnelle numéro "+ id+" invalide");
        }
    }

    public String getType()
    {
        return typeCart.toString();
    }
}
