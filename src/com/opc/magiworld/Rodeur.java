package com.opc.magiworld;

/**
 * classe Rodeur definissant les attributs du character mage
 * et heritant des methodes de la classe Personnage.
 */
public class Rodeur extends Personnage {

    public Rodeur(int niveau, int force, int agilite, int intelligence, int idJoueur) {
        super(niveau, force, agilite, intelligence, idJoueur);
    }


    @Override
    public String getName() {
        return "Rodeur";
    }

    @Override
    public String getWarCry() {
        return "ssssccchhhhuuuuuutttt...";
    }

    @Override
    public int getBasicDamage() {

        return agilite;
    }

    @Override
    public String getNameBasicAttack() {
        return "Tir à l'arc";
    }

    @Override
    public int getSpecialDamage() {
        agilite = agilite + niveau/2;

        return niveau/2;
    }

    @Override
    public String getNameSpecialAttack() {
        return "Concentration";
    }
}
