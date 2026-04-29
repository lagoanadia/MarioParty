package mariopartyv1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Partida {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rondas=0;
        Tablero tablero = new Tablero();
        Jugador j = new Jugador();
        tablero.crearTablero();
        tablero.addJ(j);
        tablero.colocarJugadores(); 
        int ans=0;
        int d=0;
        
        
        
     ///////////////////////////////////////   
       rondas = sc.nextInt();
       for(int i=0; i<rondas;i++)
       {
           System.out.println("///////////////////////////////////");
       int pasos = j.tirarDado();
       System.out.println("Celda actual del Jugador: "+j.getCasilla().getNombre());
       System.out.println("Juagdor avanaza:"+pasos);
       j.avanzar(pasos);
       System.out.println("Juagdor llega a casilla: "+j.getCasilla().getNombre());
       j.getCasilla().accion(j);
       
       }
      ///////////////////////////////////////////
       //System.out.println("Celdas delante del Jugador:");
       //System.out.println("Input o Estrella?");
       //ans = sc.nextInt(); 
        
       //if(ans==1){j.mostrarHastaEstrella();}
       
       //if(ans==0)
       //{
        //   d = sc.nextInt();
          // j.mostrarSiguientes(d);
       //}
    }

}
