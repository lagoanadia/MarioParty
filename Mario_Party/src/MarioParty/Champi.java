package MarioParty;

public class Champi extends Item 
{
    // ==================== CONSTRUCTOR ====================
    public Champi()
    {
        super("Champi");
    }
    
    // ==================== EFECTO ====================
    @Override 
    public void usar(Jugador j)
    {
        j.setBonusDado(3);
        System.out.println(j.getNombre() + " usa un Champi! +3 a la proxima tirada.");
    }
}