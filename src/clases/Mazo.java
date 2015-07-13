/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Christian
 */
public class Mazo {

    public static String[] palos = {"diamantes", "tréboles", "corazones", "espadas"};
    private ArrayList<Carta> baraja;
    private int cantidadJugadores;
    private int aleatorio;

    public Mazo(int cantJugadores) {

        Random rnd = new Random();
        this.cantidadJugadores = cantJugadores + 1;
        this.aleatorio = (int) (rnd.nextDouble() * 3 + 1);

        this.cantidadJugadores += this.aleatorio;

        this.baraja = new ArrayList();

        for (String palo : palos) {
            for (int i = 1; i < 14; i++) {
                for (int j = 1; j < this.cantidadJugadores + 1; j++) {
                    this.baraja.add(new Carta(palo, i));
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
