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
public class Jugador extends Personas {

    public static boolean retirarse = false;
    public ArrayList<Carta> manoJugador = null;
    public int total ;

    public Jugador(String nombre, int dinero) {
        super(nombre, dinero);
        this.manoJugador = new ArrayList();
        this.total = 0;
    }

    public int getTotal() {
        return total;
    }

    public int setTotal(int total) {
       return this.total += total;
    }
    
    public ArrayList<Carta> getManoJugador() {
        return this.manoJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public Carta sacarCarta(Mazo mazo) {

        return mazo.getCartas().remove(0);

    }

    public int apostar(int apuesta) {
        return apuesta;
    }

    public boolean retirarse() {
        return retirarse;
    }

}
