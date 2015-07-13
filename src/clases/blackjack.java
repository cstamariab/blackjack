/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.*;

/**
 *
 * @author Christian
 */
public class blackjack {

    private boolean sacarCarta = true;
    public Mazo mazo;

    public blackjack() {
        this.mazo = new Mazo();
    }

    public void ganar(int total) {
        if (total >= 21) {
            System.out.println("Has perdido");
        }
    }

    public void jugar() {

        Carta carta = mazo.sacarCarta();
        int total = 0;
        System.out.println(carta.getNumero() + " " + carta.getPalo() + " " + mazo.getCartas().size());

        while (sacarCarta) {
            if (mazo.getCartas().size() > 0) {
                Scanner in = new Scanner(System.in);
                System.out.println("Desea sacar otra carta ?");

                if (in.next().equals("si")) {

                    System.out.println(mazo.sacarCarta().getNumero() + " " + mazo.sacarCarta().getPalo());
                    total += mazo.sacarCarta().getNumero();
                    ganar(total);
                    sacarCarta = true;
                } else {
                    sacarCarta = false;
                }
            } else {
                sacarCarta = false;
            }

        }

    }

}
