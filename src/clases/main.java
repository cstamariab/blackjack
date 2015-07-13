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
public class main {

    public static void main(String[] args) {
        Mazo baraja= new Mazo(1);
        for (int i = 0; i < baraja.getCartas().size(); i++) {
            System.out.println(baraja.getCartas().get(i).getNumero()+" "+baraja.getCartas().get(i).getPalo());
        }
//        blackjack bj = new blackjack();
//        bj.jugar();
        
        
    }

}
