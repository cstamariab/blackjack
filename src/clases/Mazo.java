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
    public String palo2;
    public int val;

    public Mazo(int cantJugadores) {

        Random rnd = new Random();
        this.cantidadJugadores = cantJugadores + 1;
        this.aleatorio = (int) (rnd.nextDouble() * 3 + 1);

        this.cantidadJugadores += this.aleatorio;

        this.baraja = new ArrayList();
        for (int j = 1; j < this.cantidadJugadores + 1; j++) {
            for (String palo : palos) {

                for (int i = 1; i < 14; i++) {

                    switch (i) {
                        case 1:
                            val = 1;
                            break;
                        case 2:
                            val = 2;
                            break;
                        case 3:
                            val = 3;
                            break;
                        case 4:
                            val = 4;
                            break;
                        case 5:
                            val = 5;
                            break;
                        case 6:
                            val = 6;
                            break;
                        case 7:
                            val = 7;
                            break;
                        case 8:
                            val = 8;
                            break;
                        case 9:
                            val = 9;
                            break;
                        case 10:
                            val = 10;
                            break;
                        case 11:
                            val = 10;
                            break;
                        case 12:
                            val = 10;
                            break;
                        case 13:
                            val = 10;
                    }

                    this.baraja.add(new Carta(palo, i, val));

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
