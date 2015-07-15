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

    public ArrayList<Jugador> jugadores;
    public int cantJugadores;
    public ArrayList<Carta> manoJugador;
    private boolean jugando = true;
    private boolean turno = true;
    static boolean otraCarta = false;
    private String manoString = "";
    public int total;

    public Mazo mazo;
    public Carta carta;

    private static final Scanner kbr = new Scanner(System.in);

    public blackjack(int cantidadJugadores) {
        this.cantJugadores = cantidadJugadores;
        this.mazo = new Mazo(this.cantJugadores);
        this.jugadores = addJugadores();
        System.out.println("Se han agregado " + this.jugadores.size());
    }

    public void jugar() {

        for (int i = 0; i < this.jugadores.size(); i++) {
            this.turno = true;
            this.manoString = "";
            while (turno) {
                System.out.println("Turno: " + this.jugadores.get(i).getNombre());
                System.out.println("Sacando Carta..");
                this.jugadores.get(i).getManoJugador().add(this.jugadores.get(i).sacarCarta(this.mazo));
                this.manoJugador = this.jugadores.get(i).getManoJugador();
                System.out.print("Su Mano es :");
                for (Carta cartas : manoJugador) {
                    this.manoString = cartas.getNumero() + " " + cartas.getPalo();

                }

                System.out.println(manoString);
                System.out.println("Desea sacar otra carta ?");
                kbr.nextLine();
                String otra = kbr.next();
                if (otra.equals("si")) {
                    otraCarta = true;
                }
                while (otraCarta == true) {
                    this.total = 0;
                    this.jugadores.get(i).getManoJugador().add(this.jugadores.get(i).sacarCarta(this.mazo));
                    this.manoJugador = this.jugadores.get(i).getManoJugador();
                    for (Carta cartas : manoJugador) {
                        
                        System.out.print(cartas.getNumero() + " " + cartas.getPalo() + " ");
                        System.out.println("");
                        this.total += cartas.getNumero();

                    }
                    System.out.println("Total: " + this.total);

                    if (total > 21) {
                        System.out.println("PERDISTE");
                        otraCarta = false;
                        turno = false;
                    } else {
                        System.out.println("Desea sacar otra carta ?");

                        if (kbr.next().equals("si")) {
                            otraCarta = true;
                        } else {
                            this.jugadores.get(i).setTotal(total);
                            System.out.println("Total 2: " + this.jugadores.get(i).getTotal());
                            otraCarta = false;
                        }
                    }
                }
                turno = false;
            }
        }

    }

    private ArrayList addJugadores() {

        this.jugadores = new ArrayList();

        for (int i = 0; i < this.cantJugadores; i++) {

            System.out.println("Ingrese Cantidad de Dinero del Jugador " + i + " :");

            this.jugadores.add(new Jugador("jugador " + i, kbr.nextInt()));
        }
        return this.jugadores;
    }

}
