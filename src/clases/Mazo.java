/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Christian
 */
public class Mazo {

    public static String[] palos = {"diamantes", "treboles", "corazones", "espadas"};
    private ArrayList<Carta> baraja;
    private int cantidadJugadores;
    private int aleatorio;
    static String palo2;
    public Mazo(int cantJugadores) {

        Random rnd = new Random();
        this.cantidadJugadores = cantJugadores + 1;
        this.aleatorio = (int) (rnd.nextDouble() * 3 + 1);

        this.cantidadJugadores += this.aleatorio;

        this.baraja = new ArrayList();
        for (int j = 1; j < this.cantidadJugadores + 1; j++) {
            for (String palo : palos) {

                for (int i = 1; i < 14; i++) {
                    switch (palo) {
                        case "diamantes":
                            palo2 = "1";
                            break;
                        case "treboles":
                            palo2 = "0";
                            break;
                        case "corazones":
                            palo2 = "2";
                            break;
                        case "picas":
                            palo2 = "3";
                            break;
                    }
                    
                    this.baraja.add(new Carta(palo, i, new ImageIcon(getClass().getResource("/IMG/" + i + "_" + palo2 + ".png"))));

                }
            }
        }

        revolverMazo();
    }

    private void revolverMazo() {

        Collections.shuffle(baraja);
    }

    public static String[] getPalos() {
        return palos;
    }

    public ArrayList<Carta> getCartas() {
        return baraja;
    }

}
