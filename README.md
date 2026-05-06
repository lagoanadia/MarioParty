# 🎲 MarioPartyV1

Implementación en Java de un juego de mesa por turnos inspirado en la saga **Mario Party**, ejecutable por consola. El proyecto recrea las mecánicas básicas del juego original: jugadores que recorren un tablero, lanzan dados, recogen monedas y compiten por estrellas.

Desarrollado como práctica del módulo de **Programación** del ciclo de **DAM (Desarrollo de Aplicaciones Multiplataforma)**, con el objetivo de aplicar los principios de la **Programación Orientada a Objetos** en un caso real.

## 📖 Descripción

Al iniciar la partida, el programa solicita el número de jugadores y sus nombres. Cada jugador es colocado en la casilla inicial del tablero y, por turnos, lanza un dado virtual para avanzar. Antes de tirar, el jugador puede consultar las próximas casillas o ver la distancia hasta la siguiente estrella.

El tablero contiene **bifurcaciones** que permiten al jugador elegir su camino, y **cuatro tipos de casillas** con efectos distintos sobre las monedas y las estrellas.

## ✨ Funcionalidades

- **Configuración dinámica** de la partida: número de jugadores, nombres y rondas a jugar.
- **Sistema de turnos rotativo** entre todos los jugadores registrados.
- **Tirada de dado aleatoria** (valores del 1 al 6).
- **Gestión de bifurcaciones**: cuando una casilla tiene varios caminos posibles, el jugador elige cuál tomar.
- **Cuatro tipos de casillas** con comportamientos polimórficos:
  - 🔵 **Azul:** otorga 3 monedas al jugador.
  - 🔴 **Roja:** descuenta 5 monedas al jugador.
  - 🟢 **Verde:** efecto aleatorio (todos ganan monedas, el jugador avanza casillas extra, o no pasa nada).
  - ⭐ **Estrella:** intercambia 20 monedas por una estrella, o regala 10 monedas si no hay suficientes.
- **Vista previa del recorrido**: el jugador puede consultar las casillas siguientes o la distancia hasta la próxima estrella antes de jugar.

## 🛠️ Tecnologías

| Capa            | Tecnología               |
|-----------------|--------------------------|
| Lenguaje        | Java                     |
| Entrada/Salida  | `java.util.Scanner` (consola) |
| Aleatoriedad    | `java.util.Random`       |
| Estructuras     | `java.util.ArrayList`    |
| IDE de desarrollo | NetBeans (proyecto Ant) |

## 🧠 Conceptos de POO aplicados

- **Herencia:** la clase abstracta `Casilla` define la estructura común y obliga a sus subclases (`CasillaAzul`, `CasillaRoja`, `CasillaVerde`, `CasillaEstrella`) a implementar el método `accion()`.
- **Polimorfismo:** cada tipo de casilla redefine `accion(Jugador j)` con su propio efecto, llamado de forma uniforme desde el bucle de juego.
- **Encapsulación:** los atributos de `Jugador` y `Casilla` son privados y se acceden a través de getters y setters.
- **Composición:** un `Tablero` contiene listas de `Casilla` y `Jugador`; cada `Jugador` referencia a su `Tablero` y a su `Casilla` actual.
- **Operador `instanceof`:** se utiliza para detectar casillas estrella durante el avance y aplicar reglas especiales.
- **Colecciones dinámicas:** uso de `ArrayList` para gestionar el conjunto de casillas, jugadores y caminos posibles desde una bifurcación.

## 📁 Estructura del proyecto
MarioPartyV1/
├── src/
│   └── mariopartyv1/
│       ├── Partida.java          # Clase principal con el método main y el bucle de juego
│       ├── Tablero.java          # Construcción del tablero y gestión de jugadores
│       ├── Jugador.java          # Atributos del jugador y lógica de movimiento
│       ├── Casilla.java          # Clase abstracta base de las casillas
│       ├── CasillaAzul.java      # Casilla que otorga monedas
│       ├── CasillaRoja.java      # Casilla que resta monedas
│       ├── CasillaVerde.java     # Casilla con efecto aleatorio
│       └── CasillaEstrella.java  # Casilla que canjea monedas por estrellas
├── nbproject/                    # Configuración del proyecto NetBeans
├── build.xml                     # Script de construcción Ant
└── manifest.mf                   # Manifiesto del JAR
## ▶️ Ejecución

### Requisitos previos

- **JDK 8** o superior instalado.
- **NetBeans** (recomendado, ya que el proyecto está configurado con Ant) o cualquier IDE compatible con Java.

### Pasos para ejecutar

1. Clonar el repositorio:
```bash
   git clone https://github.com/lagoanadia/MarioParty.git
```
2. Abrir el proyecto `MarioPartyV1` desde NetBeans (`File > Open Project`).
3. Ejecutar la clase `Partida.java` (clic derecho > `Run File`).
4. Seguir las instrucciones por consola: introducir número de jugadores, nombres y rondas.

### Ejecución manual desde terminal

```bash
cd MarioPartyV1/src
javac mariopartyv1/*.java
java mariopartyv1.Partida
```

## 🔮 Posibles mejoras

- Implementar **minijuegos** entre rondas, como en el juego original.
- Determinar un **ganador** al finalizar las rondas según monedas y estrellas.
- Migrar la interfaz de consola a una **GUI con Swing o JavaFX**.
- Persistir partidas en disco mediante **serialización** o ficheros JSON.
- Añadir **tests unitarios** (JUnit) para validar las reglas del juego.
- Refactorizar la entrada por consola para validar valores incorrectos del usuario.

## 👤 Autoría

Proyecto desarrollado como parte del ciclo formativo de **Desarrollo de Aplicaciones Multiplataforma (DAM)**.
