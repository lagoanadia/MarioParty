
package mariopartyv1;

public class CasillaEstrella extends Casilla {
    
    public CasillaEstrella(String nombre) {
        super(nombre);
    }

    @Override
    public void accion(Jugador j)
    {
        if(j.getMonedas()>20)
        {
            System.out.println("Cuantas monedas! Te las cambio por una estrella.");
            j.alterEstrellas(1);
            j.alterMonedas(-20);
            System.out.println(j.getNombre()+" monedas:"+j.getMonedas()+" estrellas:"+j.getEstrellas());
        }
        else
        {
             System.out.println(j.getNombre()+" le caen 10 monedas en la cabeza! Que suerte...");
             j.alterMonedas(10);
             System.out.println(j.getNombre()+" monedas:"+j.getMonedas());
        }
    }
    
    
    
}
