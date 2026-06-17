
package mariopartyv1;

import java.util.ArrayList;

public class Tablero 
{
  private ArrayList<Casilla> totCasillas = new ArrayList<>();
  private ArrayList<Jugador> totJugador = new ArrayList<>();   
  
  public void crearTablero()
  {
        CasillaAzul c1 = new CasillaAzul("c1");
        CasillaRoja c2 = new CasillaRoja("c2");
        CasillaVerde c3 = new CasillaVerde("c3");
        CasillaEstrella c4 = new CasillaEstrella("c4");
        CasillaRoja c5 = new CasillaRoja("c5");
        CasillaAzul c6 = new CasillaAzul("c6");
        CasillaVerde c7 = new CasillaVerde("c7");
        CasillaRoja c8 = new CasillaRoja("c8");
        CasillaAzul c9 = new CasillaAzul("c9");
        CasillaEstrella c10 = new CasillaEstrella("c10");
        c1.setSiguiente(c2);
        c2.setSiguiente(c3);
        c3.setSiguiente(c4);
        c4.setSiguiente(c5);
        c5.setSiguiente(c6);
        c6.setSiguiente(c7);
        c7.setSiguiente(c8);
        c8.setSiguiente(c9);
        c9.setSiguiente(c10);
        c10.setSiguiente(c1);
        totCasillas.add(c1);
        totCasillas.add(c2);
        totCasillas.add(c3);
        totCasillas.add(c4);
        totCasillas.add(c5);
        totCasillas.add(c6);
        totCasillas.add(c7);
        totCasillas.add(c8);
        totCasillas.add(c9);
        totCasillas.add(c10);
        
        
  }
  public void addJugador(Jugador j)
  {
      totJugador.add(j);
  }
  public void colocarJugadores()
  {
     
     for(Jugador j:totJugador)
     {
         j.setCasilla(totCasillas.get(0)); // en array dinamico hai que hacer .get() en vez de simplemente totCasillas(0)
     }
  }
   
}
