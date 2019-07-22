package com.opc.magiworldTest;

import com.opc.magiworld.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Speaker speaker = new Speaker();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void welcome(){
        speaker.welcome();
        String output = outContent.toString().replace("\r\n", "\n");

        assertEquals("Bienvenue dans MagiWorld !!!\n", output);
    }


    @Test
    void Given_describePlayer_When_PlayerIsGuerrier_Then_DisplayGuerrierFeatures() {
        Personnage player = new Guerrier(30, 10, 10, 10,1 );
        speaker.describePlayer(player);

        String output = outContent.toString().replace("\r\n", "\n");

        assertEquals("WOOOOAAARRGG Je suis le Guerrier Joueur 1 de niveau 30 je possède 150 points de vie, 10 de force, 10 d'agilité et 10 d'intelligence !\n", output);

    }
    @Test
    void Given_describePlayer_When_PlayerIsRodeur_Then_DisplayRodeurFeatures() {
        Personnage player = new Rodeur(30, 10, 10, 10,1 );
        speaker.describePlayer(player);

        String output = outContent.toString().replace("\r\n", "\n");

        assertEquals("ssssccchhhhuuuuuutttt... Je suis le Rodeur Joueur 1 de niveau 30 je possède 150 points de vie, 10 de force, 10 d'agilité et 10 d'intelligence !\n", output);

    }@Test
    void Given_describePlayer_When_PlayerIsmage_Then_DisplayMageFeatures() {
        Personnage player = new Mage(60, 20, 20, 20,2 );
        speaker.describePlayer(player);

        String output = outContent.toString().replace("\r\n", "\n");

        assertEquals("Abracadabra !! Je suis le Mage Joueur 2 de niveau 60 je possède 300 points de vie, 20 de force, 20 d'agilité et 20 d'intelligence !\n", output);

    }
}
