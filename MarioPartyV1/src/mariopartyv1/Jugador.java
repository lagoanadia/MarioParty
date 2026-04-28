
package mariopartyv1;

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
  public String getCasilla()
  {
      return casilla.getNombre();
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
  public String avanzar()
  {
        casilla = casilla.getSiguiente();
        return casilla.getNombre();
  }
}
