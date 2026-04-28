package mariopartyv1;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida
{
    public static void main(String[] args) 
    {
       Jugador j1 = new Jugador();
       System.out.println("Nombre del jugador 1: "+j1.getNombre());
       
       System.out.println("Monedas del jugador 1: "+j1.getMonedas());
       System.out.println("Estrellas del jugador 1: "+j1.getEstrellas());
        
       j1.alterEstrellas(4);
       j1.alterMonedas(3);
        
       System.out.println("Monedas del jugador 1: "+j1.getMonedas());
       System.out.println("Estrellas del jugador 1: "+j1.getEstrellas());
       
       j1.alterEstrellas(-5);
       j1.alterMonedas(-53);
       
       System.out.println("Monedas del jugador 1: "+j1.getMonedas());
       System.out.println("Estrellas del jugador 1: "+j1.getEstrellas());
       
       Casilla c1 = new Casilla("c1");
       System.out.println("Nombre de la primera casilla: "+c1.getNombre());
       
       Casilla c2 = new Casilla("c2");  
       c1.setSiguiente(c2);
       
       System.out.println("Casilla despues de c1: "+c1.getSiguiente());
       
       j1.setCasilla(c1);
       System.out.println("Jugador 1 se encuentra en la casilla: "+j1.getCasilla());
       j1.avanzar();
       System.out.println("Ahora J1 esta en la casilla: "+j1.getCasilla());
    }
    
}
