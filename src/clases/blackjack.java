/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.*;
import java.util.InputMismatchException;

/**
 *
 * @author Christian
 */
public class blackjack {

    public ArrayList<Jugador> jugadores;
    public int cantJugadores;
    public ArrayList<Carta> manoJugador;
    public int[] apuestas;

    private boolean turno = true;
    static boolean otraCarta = false;
    private String manoString = "";
    public int total;

    public Mazo mazo;

    private static final Scanner kbr = new Scanner(System.in);

    public blackjack(int cantidadJugadores) {
        this.cantJugadores = cantidadJugadores;
        this.mazo = new Mazo(this.cantJugadores);
        this.jugadores = addJugadores();
        System.out.println("Se han agregado " + this.jugadores.size());

    }

    public void jugar() {

        for (int i = 0; i < this.jugadores.size(); i++) {
            turno = true;
            this.manoString = "";
            while (turno == true) {
                System.out.println("Turno: " + this.jugadores.get(i).getNombre());
                System.out.println("Sacando Carta..");
                this.jugadores.get(i).getManoJugador().add(this.jugadores.get(i).sacarCarta(this.mazo));
                this.manoJugador = this.jugadores.get(i).getManoJugador();
                System.out.print("Su Mano es :");
                for (Carta cartas : manoJugador) {
                    this.manoString = cartas.getNumero() + " " + cartas.getPalo();
                }
                System.out.println(manoString);
                System.out.println("");
                OUTER:
                do {
                    try {
                        System.out.println("Desea sacar otra carta ? SI-NO");

                        String otra = kbr.next();
                        switch (otra) {
                            case "si":
                                otraCarta = true;
                                break OUTER;
                            case "no":
                                System.out.println("Termina tu turno");
                                System.out.println("=================");
                                otraCarta = false;
                                turno = false;
                                break OUTER;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Solo se permiten Letras y Palabras reservadas SI o NO");
                        kbr.nextLine();
                        continue;
                    }
                } while (true);

                while (otraCarta == true) {
                    this.total = 0;
                    this.jugadores.get(i).getManoJugador().add(this.jugadores.get(i).sacarCarta(this.mazo));
                    this.manoJugador = this.jugadores.get(i).getManoJugador();
                    for (Carta cartas : manoJugador) {
                        System.out.print(cartas.getNumero() + " " + cartas.getPalo() + " ");
                        System.out.println("");
                        this.total += cartas.getNumero();
                        
                    }
                    if (verCombinacion(i) == true) {
                        System.out.println("Encontre una A y K");
                        
                    }
                    System.out.println("Total: " + this.total);
                    OUTER:
                    do {
                        try {
                            System.out.println("Desea Sacar otra Carta ? SI-NO");
                            String otra = kbr.next();
                            switch (otra) {
                                case "si":
                                    otraCarta = true;
                                    break OUTER;
                                case "no":
                                    System.out.println("Termina tu turno");
                                    System.out.println("=================");
                                    otraCarta = false;
                                    turno = false;
                                    break OUTER;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Debes Ingresar solo Letras y las palabras reservadas SI o NO");
                            kbr.nextLine();
                            continue;
                        }
                    } while (true);
                }

            }
        }

    }

    private boolean verCombinacion(int pos) {
        boolean combinacion = false;
        this.manoJugador = this.jugadores.get(pos).getManoJugador();
        for (int i = 0; i < manoJugador.size(); i++) {
            if (this.manoJugador.get(i).getNumero() == 1) {
                System.out.println("Encontre un AS!");
                if(this.manoJugador.get(i).getNumero()==13){
                    System.out.println("Encontre una K");
                    combinacion = true;
                }
            }
        }

        return combinacion;
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
