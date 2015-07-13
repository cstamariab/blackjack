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

    public Jugador(String nombre, int dinero) {
        super(nombre, dinero);
         this.manoJugador = new ArrayList();
    }

    public ArrayList<Carta> getManoJugador() {
        return this.manoJugador;
    }

    
    

   public Carta sacarCarta(Mazo mazo){
      
        return mazo.getCartas().remove(0);

   }

    public int apostar(int apuesta) {
        return apuesta;
    }

    public boolean retirarse() {
        return retirarse;
    }

}
