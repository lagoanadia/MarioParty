
package mariopartyv1;


public class CasillaVerde extends Casilla {
    
    public CasillaVerde(String nombre) {
        super(nombre);
    }
    @Override  public void accion(Jugador j)
    {
        System.out.println(j.getNombre()+" que afortunado! ganas 3 monedas. Yay!");
        j.alterMonedas(3);
        System.out.println("monedas:"+j.getMonedas());
        
    }
  
    
}
