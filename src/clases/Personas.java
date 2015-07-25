/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;


public class Personas {
    
    public String nombre;
    public int dinero;

    public Personas(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }

    public Carta sacarCarta(Mazo mazo) {

        return mazo.getCartas().remove(0);

    }
    
}
