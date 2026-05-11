package MarioParty;

import java.util.ArrayList;

public class Tablero 
{
    // ==================== ATRIBUTOS ====================
    private ArrayList<Casilla> totCasillas = new ArrayList<>();
    protected ArrayList<Jugador> totJugadores = new ArrayList<>();   
    
    // ==================== CREACION DEL TABLERO ====================
    public void crearTablero()
    {
        Casilla c1 = new CasillaAzul("c1");
        Casilla c2 = new CasillaRoja("c2");
        Casilla c3 = new CasillaVerde("c3");
        Casilla c4 = new CasillaEstrella("c4");
        Casilla c5 = new CasillaRoja("c5");
        Casilla c6 = new CasillaAzul("c6");
        Casilla c7 = new CasillaVerde("c7");
        Casilla c8 = new CasillaRoja("c8");
        Casilla c9 = new CasillaAzul("c9");
        Casilla c10 = new CasillaAzul("c10");
        
        c1.setSiguiente(c2);
        c2.setSiguiente(c3);
        c3.setSiguiente(c4);
        c4.setSiguiente(c5);
        c5.setSiguiente(c6);
        c6.setSiguiente(c7);
        c6.setSiguiente(c9);
        c7.setSiguiente(c8);
        c8.setSiguiente(c10);
        c9.setSiguiente(c10);
        c10.setSiguiente(c1);
        
        totCasillas.add(c1);
        totCasillas.add(c2);
        totCasillas.add(c3);
        totCasillas.add(c4);
        totCasillas.add(c5);
        totCasillas.add(c6);
        totCasillas.add(c7);
        totCasillas.add(c8);
        totCasillas.add(c9);
        totCasillas.add(c10); 
    }
    
    // ==================== GESTION DE JUGADORES ====================
    public void addJ(Jugador j)
    {
        totJugadores.add(j);
    }
    
    public void colocarJugadores()
    {
        for(Jugador j : totJugadores)
        {
            j.setCasilla(totCasillas.get(0)); // en array dinamico hai que hacer .get() en vez de simplemente totCasillas(0)
        }
    }
    
    // ==================== GETTERS ====================
    public ArrayList<Jugador> getTotJ()
    {
        return totJugadores;
    }
    
    public ArrayList<Casilla> getCasillasList()
    {
        return totCasillas;       
    }
    
    public int getSizeT()
    {
        return totCasillas.size();
    }
    
    public int getSizeJ()
    {
        return totJugadores.size();
    }
}