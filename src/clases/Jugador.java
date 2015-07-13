/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Christian
 */
public class Jugador extends Personas {

    public static boolean retirarse = false;

    public Jugador(String nombre, int dinero) {
        super(nombre, dinero);
    }

    

    public int apostar(int apuesta) {
        return apuesta;
    }

    public boolean retirarse() {
        return retirarse;
    }

}
