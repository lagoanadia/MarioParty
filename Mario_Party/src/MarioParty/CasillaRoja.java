
package MarioParty;

public class CasillaRoja extends Casilla {
    
    public CasillaRoja(String nombre) {
        super(nombre);
    }
      @Override
    public void accion(Jugador j) 
    {
        System.out.println(j.getNombre()+" pierdes 5 monedas... Aw!");
        j.alterMonedas(-5);
        System.out.println("monedas:"+j.getMonedas());
    } 
    @Override 
    public String getColor()
    {
      return "Roja";
    }
 }
