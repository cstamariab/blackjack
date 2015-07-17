/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import javax.swing.ImageIcon;

/**
 *
 * @author Christian
 */
public class Carta {
   private String palo;
   private int numero;
   public ImageIcon imagen ;

    public Carta(String palo, int numero,ImageIcon img) {
        this.palo = palo;
       this.numero = numero;
       this.imagen = img;
               
    }

    public ImageIcon getImagen() {
        return imagen;
    }
    
    
    public String getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
   
   

    
}
