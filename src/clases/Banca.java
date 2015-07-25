/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class Banca extends Personas {

    private int puntoExtra;
    public ArrayList<Carta> manoBanca;

    public Banca(String nombre, int dinero) {
        super(nombre, dinero);
        this.manoBanca = new ArrayList();
    }

    public ArrayList<Carta> getManoBanca() {
        return manoBanca;
    }

   

}
