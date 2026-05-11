
package MarioParty;

public class CasillaAzul extends Casilla {
    
    public CasillaAzul(String nombre) {
        super(nombre);
    }

    @Override
    public void accion(Jugador j) 
    {
        System.out.println(j.getNombre()+" que afortunado! ganas 3 monedas. Yay!");
        j.alterMonedas(3);
        System.out.println("monedas:"+j.getMonedas());
    }
        @Override 
    public String getColor()
    {
     return "Azul";
    }
    
  
}
