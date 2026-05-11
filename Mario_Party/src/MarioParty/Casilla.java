package MarioParty;

import java.util.ArrayList;

public abstract class Casilla 
{
    // ==================== ATRIBUTOS ====================
    private ArrayList<Casilla> siguientes = new ArrayList<>(); // varias opciones
    private String nombre;
   
    // ==================== CONSTRUCTOR ====================
    public Casilla(String nombre)
    {
        this.nombre = nombre;
    }
    
    // ==================== GETTERS ====================
    public String getNombre()
    {
        return nombre;
    }
    
    public ArrayList<Casilla> getSiguienteList()
    {
        return siguientes;
    }
    
    public Casilla getSiguiente()
    {
        return siguientes.get(0);
    }
    
    // ==================== SETTERS ====================
    public void setSiguiente(Casilla c)
    {
        siguientes.add(c);
    }
    
    // ==================== METODOS ABSTRACTOS ====================
    public abstract void accion(Jugador j);
    
    public abstract String getColor();
}