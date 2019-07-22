package com.opc.magiworld;

/**
 * Classe Game qui se charge du bon deroulement du jeu.
 */
public class Game {

    private Speaker speaker = new Speaker();

    public Game() {

        int idJoueur;
        int typePersonage;
        int level;
        int vie;
        int force;
        int agility;
        int intelligence;
        int attack ;
        int lifeMaxMage = 0;
        int j = 0;
        Personnage player1 = null;
        Personnage player2 = null;


        speaker.welcome();
        for (int i = 0; i < 2; i++) {
            idJoueur = i + 1;
            typePersonage = speaker.enterTypePersonage(i);
            do {
                level = speaker.enterLevel();

                vie = 5 * level;

                force = speaker.enterForce();

                agility = speaker.enterAgility();

                intelligence = speaker.enterIntelligence();

                if ((force + agility + intelligence) != level) {

                    speaker.messageErreurDifferenceLevel(level, force, agility, intelligence);
                }
            } while ((force + agility + intelligence) != level);

            if (idJoueur == 1) {
                switch (typePersonage) {
                    case 1:
                        player1 = new Guerrier(level, force, agility, intelligence, idJoueur);
                        break;
                    case 2:
                        player1 = new Rodeur(level, force, agility, intelligence, idJoueur);
                        break;
                    case 3:
                        player1 = new Mage(level, force, agility, intelligence, idJoueur);
                        lifeMaxMage = level * 5;
                        break;
                    default:
                }
                speaker.describePlayer(player1);
            }
            if (idJoueur == 2) {
                switch (typePersonage) {
                    case 1:
                        player2 = new Guerrier(level, force, agility, intelligence, idJoueur);
                        break;
                    case 2:
                        player2 = new Rodeur(level, force, agility, intelligence, idJoueur);
                        break;
                    case 3:
                        player2 = new Mage(level, force, agility, intelligence, idJoueur);
                        break;
                    default:
                }
                speaker.describePlayer(player2);
            }
        }
        do {

            if (j % 2 == 0) { // si c'est au tour du joueur 1
                j++;
                attack = speaker.chooseAction(player1.idJoueur, player1.vie);
                if (attack == 1) { // si joueur 1 a choisie une attaque basic
                    int damage = player1.getBasicDamage();
                    player2.vie = player2.vie - damage;
                    speaker.resultBasicAttack(player1.idJoueur, player1.getNameBasicAttack(), damage);
                }
                if (attack == 2) { // si joueur 1 a choisie une attaque spéciale
                    if (player1.getName() == "Guerrier") {
                        int damage = player1.getSpecialDamage();
                        player2.vie = player2.vie - damage;
                        speaker.resultSpecialAttackGuerrier(player1.idJoueur, player1.getNameSpecialAttack(), damage);
                        speaker.displayCollateralDamage(player1.idJoueur, player1.force / 2);
                    }
                    if (player1.getName() == "Rodeur") {
                        speaker.resultSpecialAttackRodeur(player1.idJoueur, player1.getNameSpecialAttack(), player1.getSpecialDamage());
                    }
                    if (player1.getName() == "Mage") {
                        int gain = player1.getSpecialDamage();
                        if (player1.vie + gain > lifeMaxMage) {
                            player1.vie = lifeMaxMage;
                        } else {
                            player1.vie = player1.vie + gain;
                        }
                        speaker.resultSpecialAttackMage(player1.idJoueur, player1.getNameSpecialAttack(), gain);
                    }
                }
            }
            if (j % 2 == 1) { //si c'est au tour du joueur 2
                j++;
                attack = speaker.chooseAction(player2.idJoueur, player2.vie);
                if (attack == 1) { // si joueur 1 a choisie une attaque basic
                    int damage = player2.getBasicDamage();
                    player1.vie = player1.vie - damage;
                    speaker.resultBasicAttack(player2.idJoueur, player2.getNameBasicAttack(), damage);
                }
                if (attack == 2) { // si joueur 1 a choisie une attaque spéciale
                    if (player2.getName() == "Guerrier") {
                        int damage = player2.getSpecialDamage();
                        player1.vie = player1.vie - damage;
                        speaker.resultSpecialAttackGuerrier(player2.idJoueur, player2.getNameSpecialAttack(), damage);
                        speaker.displayCollateralDamage(player2.idJoueur, player2.force / 2);

                    }
                    if (player2.getName() == "Rodeur") {
                        speaker.resultSpecialAttackRodeur(player2.idJoueur, player2.getNameSpecialAttack(), player2.getSpecialDamage());
                    }
                    if (player2.getName() == "Mage") {
                        int gain = player2.getSpecialDamage();
                        if (player2.vie + gain > lifeMaxMage) {
                            player2.vie = lifeMaxMage;
                        } else {
                            player2.vie = player2.vie + gain;
                        }
                        speaker.resultSpecialAttackMage(player2.idJoueur, player2.getNameSpecialAttack(), gain);
                    }
                }

            }
        }while (player1.vie > 0 || player2.vie > 0) ;
        if (player1.vie <= 0){
            speaker.displayPlayerDead(player1.idJoueur);
        }else if (player2.vie <= 0){
            speaker.displayPlayerDead(player2.idJoueur);
        }
    }
}
