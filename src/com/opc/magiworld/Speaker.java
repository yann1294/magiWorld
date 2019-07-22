package com.opc.magiworld;

public class Speaker {

    public void welcome(){
        System.out.println("Bienvenue dans MagiWorld !!!");
    }

    public int enterTypePersonage(int i){
        int typePersonage;
        System.out.println("Création du personnage du Joueur " + (i + 1));
        System.out.println("Veuillez choisir votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        typePersonage = Scan.readIntChoicePerso();
        return typePersonage;

    }

    public int enterLevel(){
        int level;
        System.out.println("Niveau du personnage ? (min 1, max 100)");
        level = Scan.readIntChoiceFeature();
        return level;
    }

    public int enterForce(){
        int force;
        System.out.println("Force du personnage ?(min 0, max 100)");
        force = Scan.readIntChoiceFeature();
        return force;
    }

    public int enterAgility(){
        int agility;
        System.out.println("Agilité du personnage ?(min 0, max 100)");
        agility = Scan.readIntChoiceFeature();
        return agility;
    }

    public int enterIntelligence(){
        int intelligence;
        System.out.println("Intelligence du personnage ?(min 0, max 100)");
        intelligence = Scan.readIntChoiceFeature();
        return intelligence;
    }

    public void messageErreurDifferenceLevel(int niveau, int force, int agilite, int intelligence){
        System.out.println("Un personnage de niveau " + niveau + " ne peut pas avoir " + force + " de force" +
                " + " + agilite + " d'agilité + " + intelligence + " d’intelligence : le total doit faire " + niveau);

    }

    public void describePlayer(Personnage player) {
        System.out.println(player.getWarCry() + " Je suis le " + player.getName()+ " Joueur " + player.idJoueur + " de niveau " +
                player.niveau + " je possède " + player.vie + " points de vie, " + player.force + " de force, "
                + player.agilite + " d'agilité et " + player.intelligence + " d'intelligence !");
    }

    public int chooseAction(int numPlayer, int life) {
        int action;
        do {
            System.out.println("Joueur " + numPlayer + " (" + life + " point de vie) veuillez choisir votre action " +
                    "(1 : Attaque basique   2 : Attaque spéciale)");
            action = Scan.readIntChoiceAction();

        } while (action < 1 || action > 2);
        return action;
    }

    public void resultBasicAttack(int idJoueur, String basicAttackName, int damage){
        int otherPlayer;
        System.out.println("Joueur " + idJoueur + " utilise " + basicAttackName + " et inflige " + damage + " dommages");
        if (idJoueur == 1){
            otherPlayer = 2;
        }else {
            otherPlayer = 1;
        }
        System.out.println("Joueur " + otherPlayer + " perd " + damage + " points de vie");
    }

    public void resultSpecialAttackGuerrier(int idJoueur, String specialAttackName, int damage){
        int otherPlayer;
        System.out.println("Joueur " + idJoueur + " utilise " + specialAttackName + " et inflige " + damage + " dommages");
        if (idJoueur == 1){
            otherPlayer = 2;
        }else {
            otherPlayer = 1;
        }
        System.out.println("Joueur " + otherPlayer + " perd " + damage + " points de vie");

    }

    public void displayCollateralDamage(int idJoueur, int collateralDamage){
        System.out.println("Joueur "+ idJoueur + " perd "+ collateralDamage + " points de vie");
    }

    public void resultSpecialAttackRodeur(int idJoueur, String specialAttackName, int gain) {
        System.out.println("Joueur " + idJoueur + " utilise " + specialAttackName + " et gagne " + gain + " points d'agilité");
    }
    public void resultSpecialAttackMage(int idJoueur, String specialAttackName, int gain){
        System.out.println("Joueur " + idJoueur + " utilise " + specialAttackName + " et gagne " + gain + " points de vie");
    }

    public void displayPlayerDead(int idJoueur){
        System.out.println("Joueur " + idJoueur + " est mort");
        System.out.println("Joueur " + idJoueur + " a perdu !");

    }
}
