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
    public ArrayList<Carta> manoBanca;
    public int[] apuestas;
    public ArrayList puntajes;

    private boolean turno = true;
    static boolean otraCarta = false;
    private String manoString = "";
    public int total;
    public int totalBanca;

    public Mazo mazo;
    public Banca banca;
    private static final Scanner kbr = new Scanner(System.in);
    private boolean turnoBanca;

    public blackjack(int cantidadJugadores) {
        this.cantJugadores = cantidadJugadores;
        this.mazo = new Mazo(this.cantJugadores);
        this.jugadores = addJugadores();
        System.out.println("Se han agregado " + this.jugadores.size());
        this.puntajes = new ArrayList();
        this.banca = new Banca("Banca", 1000000);

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
                        if (verCombinacion(i) == true) {
                            do {
                                try {
                                    System.out.println("Que Puntaje desea ? 11 o 21");
                                    int puntaje = kbr.nextInt();
                                    if (puntaje == 11) {
                                        this.total += 11;
                                        break;
                                    } else if (puntaje == 21) {
                                        this.total += 21;
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Solo puedes Ingresar 11 o 21");
                                    kbr.nextLine();
                                    continue;
                                }
                            } while (true);
                        } else {
                            this.total += cartas.getNumero();
                        }

                    }
                    this.puntajes.add(this.total);
                    System.out.println("Total: " + this.total);
                    OUTER:
                    if (cuentaValues(this.total) == true) {
                        otraCarta = false;
                        turno = false;
                        break;

                    } else {
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
            totalBanca = 0;
            do {

                System.out.println("Turno de la Banca");

                this.manoBanca = banca.getManoBanca();
                if (manoBanca == null) {
                    this.manoBanca.add(banca.sacarCarta(this.mazo));
                    
                } else {
                    
                    if (totalBanca <= 11) {
                        this.manoBanca.add(banca.sacarCarta(this.mazo));

                    }
                    if (totalBanca > 11 && totalBanca <= 16) {
                        this.manoBanca.add(banca.sacarCarta(this.mazo));
                        if (cuentaValues(totalBanca)) {
                            System.out.println("Eliminado");
                            turnoBanca = false;
                        }
                    }
                    if (totalBanca > 16 && totalBanca < 22) {
                        if (cuentaValues(totalBanca)) {
                            System.out.println("Eliminado");
                            turnoBanca = false;
                        }
                        totalBanca++;

                    }
                    for (Carta carta : manoBanca) {
                        System.out.println(carta.getNumero() + " " + carta.getPalo());
                        totalBanca += carta.getValor();
                    }

                }
            } while (turnoBanca = true);

        }

    }

    private boolean cuentaValues(int total) {
        this.total = total;
        if (this.total > 21) {
            System.out.println("Te Pasaste Has sido Eliminado de la ronda");
            return true;
        } else {
            return false;
        }
    }

    private boolean verCombinacion(int pos) {
        int posicionAs;
        int posicionK;
        boolean combinacion = false;
        this.manoJugador = this.jugadores.get(pos).getManoJugador();
        for (int i = 0; i < manoJugador.size(); i++) {
            if (this.manoJugador.get(i).getNumero() == 1) {
                System.out.println("Encontre un AS!");
                posicionAs = i;
                for (int j = 0; j < this.manoJugador.size(); j++) {
                    if (j == posicionAs) {
                        j++;
                    } else if (this.manoJugador.get(j).getNumero() == 13 && this.manoJugador.get(j).getPalo().equals(this.manoJugador.get(posicionAs).getPalo())) {
                        System.out.println("Encontre una combinacion AS y K del mismo Palo");
                        combinacion = true;
                    }
                }
            }
            if (this.manoJugador.get(i).getNumero() == 13) {
                System.out.println("Encontre un K!");
                posicionK = i;
                for (int j = 0; j < this.manoJugador.size(); j++) {
                    if (j == posicionK) {
                        j++;
                    } else if (this.manoJugador.get(j).getNumero() == 1 && this.manoJugador.get(j).getPalo().equals(this.manoJugador.get(posicionK).getPalo())) {
                        System.out.println("Encontre una combinacion AS y K del mismo Palo");
                        combinacion = true;
                    }
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
