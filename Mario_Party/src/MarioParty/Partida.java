package MarioParty;

import java.util.Scanner;

public class Partida 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        boolean seguirJugando = true;
                   // ==================== CREAR TABLERO ====================
            Tablero tablero = new Tablero();
            tablero.crearTablero();
            
            // ==================== CREAR JUGADORES ====================
            System.out.println("Cuantos jugadores vais a ser?");
            int cantJug = sc.nextInt();
            sc.nextLine();
            
            for(int i = 0; i < cantJug; i++)
            {   
                Jugador j = new Jugador();
                System.out.println("Dame el nombre del Jugador " + (i + 1));
                String jNombre = sc.nextLine();
                j.setNombre(jNombre);
                j.setTablero(tablero);
                tablero.addJ(j);
            }
            tablero.colocarJugadores(); 
        while(seguirJugando)
        {    
            // ==================== CONFIGURAR RONDAS ====================
            System.out.println("Listo! Cuantas rondas quereis jugar?");
            int rondas = sc.nextInt();
            sc.nextLine();
            
            // ==================== BUCLE DE JUEGO ====================
            for(int ronda = 1; ronda <= rondas; ronda++)
            {
                System.out.println("============================== RONDA " + ronda + " ==================================");
                
                for(int turno = 0; turno < cantJug; turno++)
                {
                    Jugador jugadorActual = tablero.totJugadores.get(turno);
                    
                    int respuesta = -1;
                    int distancia = 0;
                    int tirarDado = 0;
                    
                    System.out.println("Es el turno de " + jugadorActual.getNombre());
                    
                    // ---------- MODO DE VISUALIZACION ----------
                    while(respuesta != 0 && respuesta != 1)
                    {
                        System.out.println("Escoge el modo de visualizacion del tablero:");
                        System.out.println("  [1] Revelar casillas hasta la siguiente estrella");
                        System.out.println("  [0] Introducir una distancia personalizada");
                        respuesta = sc.nextInt();
                        sc.nextLine();
                    }
                    
                    if(respuesta == 1)
                    {
                        jugadorActual.mostrarHastaEstrella();
                    }  
                    else
                    {
                        while(distancia < 1 || distancia > 6)
                        {
                            System.out.println("Introduce un valor entre el 1 y el 6");
                            distancia = sc.nextInt();
                            sc.nextLine();
                        } 
                        jugadorActual.mostrarSiguientes(distancia);
                    }
                    
                    // ---------- USAR ITEM ----------
                    if(!jugadorActual.getInventario().isEmpty())
                    {
                        int usar = -1;
                        while(usar != 0 && usar != 1)
                        {
                            System.out.println(jugadorActual.getNombre() + " tienes " + jugadorActual.getInventario().size() + " item(s). ¿Usar alguno? [1] Si [0] No");
                            usar = sc.nextInt();
                            sc.nextLine();
                        }

                        if(usar == 1)
                        {
                            for(int k = 0; k < jugadorActual.getInventario().size(); k++)
                            {
                                System.out.println(k + ") " + jugadorActual.getInventario().get(k).getNombre());
                            }
                            System.out.println("Cual usas?");
                            int elec = sc.nextInt();
                            sc.nextLine();

                            Item elegido = jugadorActual.getInventario().get(elec);
                            elegido.usar(jugadorActual);
                            jugadorActual.getInventario().remove(elec);
                        }
                    }
                    
                    // ---------- TIRAR DADO ----------
                    while(tirarDado != 1)
                    {
                        System.out.println(jugadorActual.getNombre() + " pulsa 1 para tirar el dado.");
                        tirarDado = sc.nextInt();
                        sc.nextLine();
                    }
                    
                    int pasos = jugadorActual.tirarDado();
                    System.out.println("Tiraste: " + pasos); 
                    System.out.println("Celda actual del Jugador: " + jugadorActual.getCasilla().getNombre());
                    System.out.println("Jugador " + jugadorActual.getNombre() + " avanza: " + pasos);
                    jugadorActual.avanzar(pasos);
                    System.out.println();
                    
                    // ---------- ACCION DE LA CASILLA FINAL ----------
                    System.out.println("Jugador " + jugadorActual.getNombre() + " llega a casilla: " + jugadorActual.getCasilla().getColor() + " posicion " + jugadorActual.getCasilla().getNombre());
                    jugadorActual.getCasilla().accion(jugadorActual);
                    System.out.println();
                    
                    System.out.println("Se ha acabado tu turno " + jugadorActual.getNombre());
                }
            }
            
            // ==================== FIN DE PARTIDA ====================
            int volverJugar = -1;
            while(volverJugar != 0 && volverJugar != 1)
            {
                System.out.println("1 para volver a jugar || 0 para salir");
                volverJugar = sc.nextInt();
                sc.nextLine();
            }
            
            if(volverJugar == 0)
            {
                seguirJugando = false;
            }
        }
    
        
        Jugador ganador = new Jugador();
        for(Jugador j : tablero.getTotJ())
        { 
            if(j.getMonedas()>ganador.getMonedas())
            {
               ganador = j;
                if (j.getEstrellas()>ganador.getEstrellas())
                {
                 ganador = j;
                } 
            } 
            
        }
        System.out.println(ganador.getNombre()+" has ganado con "+ganador.getEstrellas()+" estrellas y "+ganador.getMonedas()+" monedas.");
        System.out.println("Gracias por jugar!");
    }
}