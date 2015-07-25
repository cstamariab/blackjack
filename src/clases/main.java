/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Christian
 */
public class main {

    public static Scanner kbr = new Scanner(System.in);

    public static void main(String[] args) {
        int jugadores;
        do {
            try {
                System.out.println("Ingrese Cantidad de Jugadores");
                jugadores= kbr.nextInt();
                blackjack bj = new blackjack(jugadores);
                bj.jugar();
                break;
                
            } catch (InputMismatchException e) {
                System.out.println("Error Solo puedes ingresar numeros");
                kbr.nextLine();
                continue;
            }
        } while (true);

        

    }

}
