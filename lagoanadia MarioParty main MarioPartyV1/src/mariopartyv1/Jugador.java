
package mariopartyv1;

import java.util.Random;
import java.util.ArrayList;

public class Jugador 
{
   private String nombre;
   private int numEstrellas;
   private int numMonedas;  
   private Casilla casilla;
   
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
  public int tirarDado()
  {
        Random dado = new Random();
        int pasos = dado.nextInt(6) + 1;;
       return pasos;
  }
  public void avanzar(int pasos)
  {
      
    for(int i=0; i<pasos;i++)
    {
        if(casilla.getSiguienteList().size()==1)
     {
         casilla = casilla.getSiguiente();
     }
        else
        {
            System.out.println("Bifurcacion!");
        }
        if(casilla instanceof CasillaEstrella)
      {
         casilla.accion(this);
          pasos++;
          
      }
    }
     
       
        
  }
}
