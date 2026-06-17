package mariopartyv1;

import java.util.ArrayList;

public abstract class Casilla 
{
    private ArrayList<Casilla> siguientes= new ArrayList<>(); // varias opciones
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
       siguientes.add(c);
    }
    public ArrayList<Casilla> getSiguienteList()
    {
        return siguientes;
    }

    public Casilla getSiguiente()
    {
     
        //por ahora no implemento bifurcaciones pero dejo el arraylist listo.
        return siguientes.get(0);
    }
    public abstract void accion(Jugador j);
   
}