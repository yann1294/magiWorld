package com.opc.magiworld;

/**
 * classe Guerrier heritant de la classe Personnage
 */
public class Guerrier extends Personnage {

    private Speaker speaker = new Speaker();

    public Guerrier( int niveau, int force, int agilite, int intelligence, int idJoueur) {
        super(niveau, force, agilite, intelligence, idJoueur);
    }



    @Override
    public int getBasicDamage (){
        return force;

    }

    @Override
    public String getNameBasicAttack() {
        return "Coup d'épée";
    }


    @Override
    public int getSpecialDamage(){

        int damage = 2 * force;
        collateralDamage();
        return damage;

    }

    @Override
    public String getNameSpecialAttack() {
        return "Coup de rage";
    }

    private void collateralDamage(){
        int collateralDamage = force / 2;

        vie = vie - collateralDamage;

    }
    @Override
    public String getName() {
        return "Guerrier";
    }


    @Override
    public String getWarCry() {
        return "WOOOOAAARRGG";
    }
}
