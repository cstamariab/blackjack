/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author Christian
 */
public class main {
private static Scanner kbr = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Bienvenidos a BlackJack 21");
        System.out.println("Escriba Cantidad de jugadores: ");
        blackjack bj = new blackjack(kbr.nextInt());
        bj.jugar();

    }

}
