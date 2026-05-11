package MarioParty;

import java.util.Scanner;

public class DadoEspecial extends Item 
{
    // ==================== CONSTRUCTOR ====================
    public DadoEspecial()
    {
        super("Dado Especial");
    }
    
    // ==================== EFECTO ====================
   @Override 
    public void usar(Jugador j)
    {
        Scanner sc = new Scanner(System.in);
        int distancia = 0;

        while(distancia < 1 || distancia > 6)
        {
            System.out.println(j.getNombre() + " elige distancia (1-6):");
            distancia = sc.nextInt();
        }

        j.setBonusDado(distancia);
        j.setDadoEspecialActivo(true);  
        System.out.println(j.getNombre() + " usa un Dado Especial! Avanzara " + distancia + " casillas.");
    }
}