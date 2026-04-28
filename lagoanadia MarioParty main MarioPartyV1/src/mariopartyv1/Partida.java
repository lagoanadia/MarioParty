package mariopartyv1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Partida {

    public static void main(String[] args) {
    
        Tablero tablero = new Tablero();
        tablero.crearTablero();
        Jugador j1 = new Jugador();
        tablero.addJugador(j1);
        tablero.colocarJugadores();
        
       
      
       int pasos = j1.tirarDado();
       System.out.println(j1.getCasilla());
       System.out.println(pasos);
       j1.avanzar(pasos);
       System.out.println(j1.getCasilla());
       j1.getCasilla().accion(j1);
    }

}
