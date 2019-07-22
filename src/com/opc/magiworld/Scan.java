package com.opc.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * classe verifiant les entrees des joueurs correspondent aux entrees valides
 * du jeu.
 */
public class Scan {

    public static int readIntChoicePerso() {
        boolean error;
        int x = 0;
        do {
            try {
                Scanner KB = new Scanner(System.in);
                x = KB.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                // accept integer only.
                System.out.println("Entrée invalide, entrez un nombre entier.");
                error = true;
            }
            if (x < 1 || x >3){
                System.out.println("Entrez un choix valide (1 ou 2 ou 3).");
                error = true;
            }
        }
        while (error);

        return (x);
    }

    public static int readIntChoiceFeature() {
        boolean error;
        int x = 0;
        do {
            try {
                Scanner KB = new Scanner(System.in);
                error = false;
                x = KB.nextInt();
            } catch (InputMismatchException e) {
                // accept integer only.
                System.out.println("Entrée invalide, entrez un nombre entier.");
                error = true;
            }
            if (x < 1 || x >100){
                System.out.println("Entrez une valeur valide (entre 1 et 100).");
                error = true;
            }
        }
        while (error);
        return (x);
    }

    public static int readIntChoiceAction() {
        boolean error;
        int x = 0;
        do {
            try {
                Scanner KB = new Scanner(System.in);
                error = false;
                x = KB.nextInt();
            } catch (InputMismatchException e) {
                // accept integer only.
                System.out.println("Entrée invalide, entrez un nombre entier.");
                error = true;
            }
            if (x < 1 || x >2){
                System.out.println("Entrez une attaque valide (1 ou 2).");
                error = true;
            }
        }
        while (error);
        return (x);
    }
}
