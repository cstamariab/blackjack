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

    private boolean jugando = true;
    private boolean turno = true;
    private boolean sacarCarta = false;
    public Mazo mazo;
    private static Scanner kbr = new Scanner(System.in);
    public ArrayList<Jugador> jugadores;
    public int cantJugadores;
    public Carta carta;

    public blackjack(int cantidadJugadores) {
        this.cantJugadores = cantidadJugadores;
        this.mazo = new Mazo(this.cantJugadores);
    }

    public void jugar() {

        this.jugadores = addJugadores();
        
        for (int i = 0; i < this.jugadores.size(); i++) {
            this.turno = true;
            while (turno) {
                System.out.println("Turno del jugador ");
                System.out.println("Sacando Carta..");
                this.jugadores.get(i).getManoJugador().add(this.jugadores.get(i).sacarCarta(this.mazo));
                System.out.println(this.jugadores.get(i).getManoJugador().get(0).getNumero());
                this.turno = false;
            }
        }
    }

    public ArrayList addJugadores() {

        this.jugadores = new ArrayList();

        for (int i = 1; i < this.cantJugadores + 1; i++) {

            System.out.println("Ingrese Cantidad de Dinero del Jugador " + i + " :");

            this.jugadores.add(new Jugador("jugador " + i, kbr.nextInt()));
        }
        return this.jugadores;
    }

}
