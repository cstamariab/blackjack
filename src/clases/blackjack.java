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

    public blackjack(int cantidadJugadores) {
        this.mazo = new Mazo(cantidadJugadores);
    }

    public void ganar(int total) {
        if (total >= 21) {
            System.out.println("Has perdido");
        }
    }

    public void jugar() {

       
    }

}
