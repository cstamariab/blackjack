/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Christian
 */
public class Mazo {

    public static String[] palos = {"diamantes", "tréboles", "corazones", "espadas"};
    private ArrayList<Carta> cartas;

    public Mazo() {

        cartas = new ArrayList<Carta>();
        for (String palo : palos) {
            for (int i = 1; i < 13; i++) {
                this.cartas.add(new Carta(palo, i));
            }
        }
        revolverMazo();
    }

    public Carta sacarCarta() {

        return this.cartas.remove(0);

    }

    private void revolverMazo() {

        Collections.shuffle(cartas);
    }

    public static String[] getPalos() {
        return palos;
    }

    public static void setPalos(String[] palos) {
        Mazo.palos = palos;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

}
