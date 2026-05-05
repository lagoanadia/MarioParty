package mariopartyv1;


import java.util.Scanner;


public class Partida 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
 //==========================================CREAR TABLERO===============================================================
        int rondas=0;
        Tablero tablero = new Tablero();
        tablero.crearTablero();
 //==========================================CREAR JUGADORES=============================================================
        int cantJug=0;
        System.out.println("Cuantos jugadores vais a ser?");
        cantJug = sc.nextInt();
        sc.nextLine();
        
          for(int i=0; i<cantJug; i++)
        {   
            Jugador j = new Jugador();
        //  ==========NOMBRES JUGADORES=================
            System.out.println("Dame el nombre dels Jugador "+(i+1));
            String jNombre = sc.nextLine();
            j.setNombre(jNombre);
        //  =========COLOCAR JUGADORES EN TABLERO=======    
            j.setTablero(tablero);
            tablero.addJ(j);
            tablero.colocarJugadores(); 
        }
//====================================VARIABLES PARA VER SIGUIENTES CASILLAS====================================================     
        int respuesta=0;
        int distancia=0;
      
// ==========================================BUCLE JUGABLE=======================================================================       
 
       System.out.println("Listo! Cuantas rondas quereis jugar?");
       rondas = sc.nextInt();
       sc.nextLine();
       
       int turno =0;
       for(int i=0; i<rondas;i++)
       {     
           if (turno== tablero.totJugadores.size())
           {
              turno = 0;
           }
           Jugador jugadorActual =  tablero.totJugadores.get(turno);
           
           System.out.println("RONDA "+i);
           System.out.println("Celdas delante del Jugador:");
           System.out.println("1 para mostrar hasta la siguente casilla estrella || 0 para mostrar hasta una distancia introducida por ti");
           respuesta = sc.nextInt();  
           if(respuesta==1){jugadorActual.mostrarHastaEstrella();}  
           if(respuesta==0)
           {
             distancia = sc.nextInt();
             sc.nextLine();
             jugadorActual.mostrarSiguientes(distancia);
           }
           System.out.println("Es el turno de "+jugadorActual.getNombre());
           while(respuesta != 1)
           {
            System.out.println(jugadorActual.getNombre()+" pulsa 1 para tirar el dado.");
            respuesta = sc.nextInt();
           }
           int pasos = jugadorActual.tirarDado();
           System.out.println("Tiraste: "+pasos); 
           System.out.println("Celda actual del Jugador: "+jugadorActual.getCasilla().getNombre());
           System.out.println("Juagdor "+jugadorActual.getNombre()+ " avanza:"+pasos);
           jugadorActual.avanzar(pasos);
           System.out.println();
            
           System.out.println("Juagdor "+jugadorActual.getNombre()+ " llega a casilla: "+jugadorActual.getCasilla().getNombre());
           jugadorActual.getCasilla().accion(jugadorActual);
           System.out.println();
           
           System.out.println("Se ha acabado tu turno "+jugadorActual.getNombre()+" estas son las casillas que te quedan delante:");
         
          turno++;       
       }         
    }
}
