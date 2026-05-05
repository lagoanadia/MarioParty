
package mariopartyv1;
import java.util.Random;

public class CasillaVerde extends Casilla {
    
    private Random r = new Random();
    
    public CasillaVerde(String nombre) 
    {
        super(nombre);   
      
    }
    @Override  public void accion(Jugador j)
    {
        int efecto = r.nextInt(3);
        System.out.println("El jugador "+j.getNombre()+" ha caido en una casilla verde.");
        System.out.println("Para decidir el efecto que tendra esta casilla el jugador tira un dado del 1-3.");
        System.out.println(j.getNombre()+" ha tirado: "+efecto);
        
        if(efecto == 1)
        {
          for(Jugador jug: j.getTablero().getTotJ())
          {
              jug.alterMonedas(3);
              System.out.println(jug.getNombre()+" recibe 3 monedas!");
          }
        }
        if(efecto==2)
        {
           
            int pasos = r.nextInt(6);
            System.out.println(j.getNombre()+" cae en un agujero misterioso y se mueve "+pasos+" casillas más.");
            j.avanzar(pasos);
            System.out.println("El jugador ahora se encuentra en: "+j.getCasilla());
        }
        if(efecto==3)
        {
            System.out.println("Y...!! No pasa... nada *silencio incomodo*");
        }
    }
  
    
}
