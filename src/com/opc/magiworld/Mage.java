package com.opc.magiworld;

/**
 * classe Mage definissant les attributs du character mage
 * et heritant des methodes de la classe Personnage.
 */
public class Mage extends Personnage {

    public Mage(int niveau, int force, int agilite, int intelligence, int idJoueur) {
        super(niveau, force, agilite, intelligence, idJoueur);
    }



    @Override
    public String getName() {
        return "Mage";
    }
    @Override
    public String getWarCry() {
        return "Abracadabra !!";
    }

    @Override
    public int getBasicDamage() {

        return intelligence;
    }

    @Override
    public String getNameBasicAttack() {
        return "Boule de feu";
    }

    @Override
    public int getSpecialDamage() {
        int gain = intelligence * 2;

        return gain;
    }

    @Override
    public String getNameSpecialAttack() {
        return "Soin";
    }
}
