package com.opc.magiworld;

/**
 * Classe abstraite definissant les attributs d'un personnage.
 */
public abstract class Personnage {

    int niveau, vie, force, agilite, intelligence;

    protected int idJoueur;

    public Personnage( int niveau, int force, int agilite,
                       int intelligence, int idJoueur) {

        this.niveau = niveau;
        this.vie = niveau * 5;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;

        this.idJoueur = idJoueur;

    }

    public  abstract String getName();

    public abstract String getWarCry();

    public abstract int getBasicDamage();

    public abstract String getNameBasicAttack();

    public abstract int getSpecialDamage();

    public abstract String getNameSpecialAttack();
}
