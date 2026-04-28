
package mariopartyv1;


public class CasillaVerde extends Casilla {
    
    public CasillaVerde(String nombre) {
        super(nombre);
    }
    @Override  public void accion()
    {
        System.out.println("MALA SUERTE!");
        
    }
  
    
}
