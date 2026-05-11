package MarioParty;

public abstract class Item
{
    // ==================== ATRIBUTOS ====================
    private String nombre;
    
    // ==================== CONSTRUCTOR ====================
    public Item(String nombre)
    {
        this.nombre = nombre;
    }
    
    // ==================== GETTERS ====================
    public String getNombre()
    {
        return nombre;
    }
    
    // ==================== METODOS ABSTRACTOS ====================
    public abstract void usar(Jugador j);
}