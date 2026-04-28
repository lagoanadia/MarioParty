package mariopartyv1;

public class Casilla 
{
    private Casilla siguiente;
    private String nombre;

    public Casilla(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setSiguiente(Casilla c)
    {
        this.siguiente = c;
    }

    public Casilla getSiguiente()
    {
        return siguiente;
    }
    public void accion()
    {
        
    }
}