
package mariopartyv1;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador 
{
   private String nombre;
   private int numEstrellas;
   private int numMonedas;  
   private Casilla casilla;
   private Tablero tablero;
   
   public Jugador()
   {
       nombre = "Bot";
       numEstrellas = 0;
       numMonedas =0;
       
   }
   public int alterEstrellas(int cantidad)
  {
       numEstrellas += cantidad;
       if(numEstrellas <0)
       {
           numEstrellas=0;
       }
      return numEstrellas;
  } 
   
  public int alterMonedas(int cantidad)
  {
       numMonedas += cantidad;
       if(numMonedas <0)    
       {
           numMonedas=0;
       }
      return numMonedas;
  }
  public void setNombre(String nombre)
  {
      this.nombre = nombre;
  }
  public String getNombre()
  {
      return nombre;
  }
  public Casilla getCasilla()
  {
      return casilla;
  }
   public int getMonedas()
  {
      return numMonedas;
  }
    public int getEstrellas()
  {
      return numEstrellas;
  }
    
  public void setCasilla(Casilla c)
  {
      this.casilla = c;
  }
  public void setTablero(Tablero t)
  {
      this.tablero = t;
  }
  public Tablero getTablero()
  {
      return tablero;
  }
  public int tirarDado()
  {
        Random dado = new Random();
        int pasos = dado.nextInt(6) + 1;;
       return pasos;
  }
  
  public void avanzar(int pasos)
  {
        Scanner sc = new Scanner(System.in);
    for(int i=0; i<pasos;i++)
    {
        if(casilla.getSiguienteList().size()==1)
     {
         casilla = casilla.getSiguiente();
     }
        else
        {
            System.out.println("Bifurcacion!");
           for(int j=0; j<casilla.getSiguienteList().size();j++ )
           {
               System.out.println(j + ") " + casilla.getSiguienteList().get(j).getNombre());
              
           }
            System.out.println("Que camino escojes?");
            int opcion = 0;
            opcion = sc.nextInt();
            casilla = casilla.getSiguienteList().get(opcion);           
        }
        /// CONSULTADO ///////////////////////////
        if(casilla instanceof CasillaEstrella)
      {
         casilla.accion(this);
          pasos++;
          
      }
    }
  }
   
    public void mostrarHastaEstrella()
    {  
        Casilla cTemp = casilla;
       while(!(cTemp instanceof CasillaEstrella)) // mientras la casilla temporal no sea Estrella.
       {
           cTemp = cTemp.getSiguiente();
           System.out.println(cTemp.getNombre());      
       }
    }
    public void mostrarSiguientes(int cantidad)
    {
        int distancia = 0;
        Casilla cTemp = casilla;
        while(distancia<cantidad)
        {
            cTemp = cTemp.getSiguiente();
            distancia++;
        }
        if(cTemp instanceof CasillaRoja) System.out.println("Roja");
        if(cTemp instanceof CasillaAzul) System.out.println("Azul");
        if(cTemp instanceof CasillaVerde) System.out.println("Verde");
        if(cTemp instanceof CasillaEstrella) System.out.println("Estrella");
       System.out.println("Distancia: "+distancia);
    }
       
  }


