package MarioParty;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador 
{
    // ==================== ATRIBUTOS ====================
    private String nombre;
    private int numEstrellas;
    private int numMonedas;  
    private Casilla casilla;
    private Tablero tablero;
    private ArrayList<Item> inventario = new ArrayList<>();
    private int bonusDado = 0;
    private boolean dadoEspecialActivo = false;
   
    // ==================== CONSTRUCTOR ====================
    public Jugador()
    {
        nombre = "Bot";
        numEstrellas = 0;
        numMonedas = 0;
    }
   
    // ==================== GETTERS ====================
    public String getNombre()
    {
        return nombre;
    }
    
    public int getMonedas()
    {
        return numMonedas;
    }
    
    public int getEstrellas()
    {
        return numEstrellas;
    }
    
    public Casilla getCasilla()
    {
        return casilla;
    }
    
    public Tablero getTablero()
    {
        return tablero;
    }
    public ArrayList<Item> getInventario()
    {
        return inventario;
    }
   // ==================== GESTION DE INVENTARIO ====================
    public boolean addItem(Item i)
    {
        if(inventario.size() >= 3)
        {
            System.out.println(nombre + " tiene el inventario lleno!");
            return false;
        }
        inventario.add(i);
        return true;
    }
    // ==================== SETTERS ====================
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setCasilla(Casilla c)
    {
        this.casilla = c;
    }
    
    public void setTablero(Tablero t)
    {
        this.tablero = t;
    }
    public void setBonusDado(int bonus)
    {
        this.bonusDado = bonus;
    }

    public void setDadoEspecialActivo(boolean activo)
    {
        this.dadoEspecialActivo = activo;
    }

    // ==================== MODIFICADORES DE ESTADO ====================
    public int alterEstrellas(int cantidad)
    {
        numEstrellas += cantidad;
        if(numEstrellas < 0)
        {
            numEstrellas = 0;
        }
        return numEstrellas;
    } 
   
    public int alterMonedas(int cantidad)
    {
        numMonedas += cantidad;
        if(numMonedas < 0)    
        {
            numMonedas = 0;
        }
        return numMonedas;
    }
    
    // ==================== MOVIMIENTO ====================
    public int tirarDado()
    {
        int pasos;

        if(dadoEspecialActivo)
        {
            pasos = bonusDado;          // usa exactamente lo elegido
            dadoEspecialActivo = false; // se gasta
        }
        else
        {
            Random dado = new Random();
            pasos = dado.nextInt(6) + 1;
            pasos += bonusDado;         // suma champiñón si lo hay
        }

        bonusDado = 0;   // se gasta en cualquier caso
        return pasos;
    }
  
    public void avanzar(int pasos)
    {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < pasos; i++)
        {
            if(casilla.getSiguienteList().size() == 1)
            {
                casilla = casilla.getSiguiente();
            }
            else
            {
                System.out.println("Bifurcacion!");
                for(int j = 0; j < casilla.getSiguienteList().size(); j++)
                {
                    System.out.println(j + ") " + casilla.getSiguienteList().get(j).getNombre());
                }
                System.out.println("Que camino escoges?");
                int opcion = 0;
                opcion = sc.nextInt();
                casilla = casilla.getSiguienteList().get(opcion);           
            }
            
            /// CONSULTADO ///////////////////////////
            if(casilla instanceof CasillaEstrella)
            {
                casilla.accion(this);
                pasos++;
            }
        }
    }
   
    // ==================== VISUALIZACION DEL TABLERO ====================
    public void mostrarHastaEstrella()
    {  
        Casilla cTemp = casilla;
        int distancia = 0;
        while(!(cTemp instanceof CasillaEstrella))
        {
            if(cTemp.getSiguienteList().size() > 1)
            {
                System.out.println("↓↓↓ Bifurcacion, elegir camino al llegar ↓↓↓");
            }
            cTemp = cTemp.getSiguiente();
            distancia++;
            System.out.println(cTemp.getColor() + " - Distancia: " + distancia);
        }
    }
    
    public void mostrarSiguientes(int cantidad)
    {
        int distancia = 0;
        Casilla cTemp = casilla;
        while(distancia < cantidad)
        {
            if(cTemp.getSiguienteList().size() > 1)
            {
                System.out.println("↓↓↓ Bifurcacion, elegir camino al llegar ↓↓↓");
            }
            cTemp = cTemp.getSiguiente();
            distancia++;
            System.out.println(cTemp.getColor() + " - Distancia: " + distancia);
        }
    }

}