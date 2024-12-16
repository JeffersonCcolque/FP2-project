import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Juego extends JFrame {
    private ArrayList<Dragon> dragonesP1 = new ArrayList<>();
    private ArrayList<Dragon> dragonesP2 = new ArrayList<>();
    private Dragon dragonJugador1;
    private Dragon dragonJugador2;
    private int turnoJugador = 1;
    private Elecciones su = new Elecciones("llamar");

    private JLabel infoLabel;
    private JPanel buttonPanel;
    private JProgressBar barraVidaJ1, barraVidaJ2;

    public Juego() {
        setTitle("Dragon City - PvP");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        infoLabel = new JLabel("Jugador 1 - Turno inicial", SwingConstants.CENTER);
        add(infoLabel, BorderLayout.NORTH);

        barraVidaJ1 = new JProgressBar(0, 100);
        barraVidaJ2 = new JProgressBar(0, 100);
        barraVidaJ1.setStringPainted(true);
        barraVidaJ2.setStringPainted(true);
        barraVidaJ1.setForeground(Color.GREEN);
        barraVidaJ2.setForeground(Color.GREEN);

        JPanel vidaPanel = new JPanel(new GridLayout(2, 2));
        vidaPanel.add(new JLabel("Jugador 1: "));
        vidaPanel.add(barraVidaJ1);
        vidaPanel.add(new JLabel("Jugador 2: "));
        vidaPanel.add(barraVidaJ2);
        add(vidaPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new GridLayout(2, 2));
        inicializarEquipos();
        inicializarBotonesPrincipales();
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setPreferredSize(new Dimension(getWidth(), 150));

        actualizarInfo();
        setVisible(true);
    }

    private void inicializarEquipos() {
        // Ejemplo de inicialización de dragones (puedes sustituir esto por una lógica más avanzada)
        
            dragonesP1 = su.getDragp1();
            dragonesP2 = su.getDragp2();
        
            if (dragonesP1 == null || dragonesP1.isEmpty()) {
                throw new IllegalStateException("El equipo de dragones del Jugador 1 está vacío o no inicializado.");
            }
            if (dragonesP2 == null || dragonesP2.isEmpty()) {
                throw new IllegalStateException("El equipo de dragones del Jugador 2 está vacío o no inicializado.");
            }
        
        

        // Inicializar dragones activos
        dragonJugador1 = dragonesP1.get(0);
        dragonJugador2 = dragonesP2.get(0);
    }

    private void inicializarBotonesPrincipales() {
        buttonPanel.removeAll();
        JButton atacarBtn = new JButton("Atacar");
        JButton defenderBtn = new JButton("Defender");
        JButton potenciarBtn = new JButton("Potenciar");
        JButton cambiarBtn = new JButton("Cambiar Dragón");

        atacarBtn.addActionListener(e -> mostrarOpciones("ataque"));
        defenderBtn.addActionListener(e -> mostrarOpciones("defensa"));
        potenciarBtn.addActionListener(e -> mostrarOpciones("potencia"));
        cambiarBtn.addActionListener(e -> cambiarDragon());

        buttonPanel.add(atacarBtn);
        buttonPanel.add(defenderBtn);
        buttonPanel.add(potenciarBtn);
        buttonPanel.add(cambiarBtn);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private void mostrarOpciones(String tipo) {
        Dragon dragonActual = obtenerDragonActual();
        Object[][] opciones = tipo.equals("ataque") ? dragonActual.getAtaques() :
                      tipo.equals("defensa") ? dragonActual.getDefensa() : dragonActual.getPotencia();

        buttonPanel.removeAll();
        for (int i = 0; i < opciones.length; i++) {
            String texto = (String) opciones[i][0]; // Obtener el texto de la primera columna
            int valor = (Integer) opciones[i][1];  // Obtener el valor de la segunda columna

            JButton opcionBtn = new JButton(texto); // Usar el texto como etiqueta del botón
            opcionBtn.addActionListener(e -> {
                realizarAccion(tipo, valor); // Usar el valor como parámetro de nivel
                cambiarTurno();
            });

            buttonPanel.add(opcionBtn);
        }

        buttonPanel.revalidate();
        buttonPanel.repaint();


        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> inicializarBotonesPrincipales());
        buttonPanel.add(volverBtn);

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private void realizarAccion(String tipo, int nivel) {
        Dragon atacante = obtenerDragonActual();
        Dragon oponente = obtenerDragonOponente();
    
        switch (tipo) {
            case "ataque":
                // Obtener el daño desde el arreglo de ataques
                Object[][] ataques = atacante.getAtaques();
                if (nivel < ataques.length) {
                    int dano = (Integer) ataques[nivel][1]; // Nivel específico
                    oponente.setVida(oponente.getVida() - dano); // Reducir vida del oponente
                    infoLabel.setText("¡" + atacante.getNombre() + " realizó un ataque causando " + dano + " de daño!");
                } else {
                    infoLabel.setText("Nivel de ataque inválido.");
                }
                break;
    
            case "defensa":
                // Obtener el valor defensivo desde el arreglo de defensas
                Object[][] defensas = atacante.getDefensa();
                if (nivel < defensas.length) {
                    int defensa = (Integer) defensas[nivel][1]; // Nivel específico
                    atacante.setVida(atacante.getVida() + defensa); // Aumentar vida del atacante
                    infoLabel.setText("¡" + atacante.getNombre() + " aumentó su defensa en " + defensa + " puntos!");
                } else {
                    infoLabel.setText("Nivel de defensa inválido.");
                }
                break;
    
            case "potencia":
                // Obtener el valor de potencia desde el arreglo de potencias
                Object[][] potencias = atacante.getPotencia();
                if (nivel < potencias.length) {
                    int potencia = (Integer) potencias[nivel][1]; // Nivel específico
                    atacante.setAtaque(atacante.getAtaques() + potencia); // Aumentar ataque del atacante
                    infoLabel.setText("¡" + atacante.getNombre() + " aumentó su potencia en " + potencia + " puntos!");
                } else {
                    infoLabel.setText("Nivel de potencia inválido.");
                }
                break;
    
            default:
                infoLabel.setText("Acción no reconocida.");
                break;
        }
    
        actualizarInfo(); // Actualizar las barras de vida y la información
    }
    

    private void cambiarDragon() {
        ArrayList<Dragon> equipoActual = turnoJugador == 1 ? dragonesP1 : dragonesP2;

        JFrame cambioFrame = new JFrame("Cambiar Dragón - Jugador " + turnoJugador);
        cambioFrame.setSize(300, 150);
        cambioFrame.setLayout(new GridLayout(1, equipoActual.size()));

        for (Dragon dragon : equipoActual) {
            JButton dragonBtn = new JButton(dragon.getNombre());
            dragonBtn.addActionListener(e -> {
                if (turnoJugador == 1) dragonJugador1 = dragon;
                else dragonJugador2 = dragon;
                infoLabel.setText("Jugador " + turnoJugador + " cambió a: " + dragon.getNombre());
                cambioFrame.dispose();
                cambiarTurno();
            });
            cambioFrame.add(dragonBtn);
        }
        cambioFrame.setVisible(true);
    }

    private Dragon obtenerDragonActual() {
        return turnoJugador == 1 ? dragonJugador1 : dragonJugador2;
    }

    private Dragon obtenerDragonOponente() {
        return turnoJugador == 1 ? dragonJugador2 : dragonJugador1;
    }

    private void cambiarTurno() {
        turnoJugador = (turnoJugador == 1) ? 2 : 1;
        actualizarInfo();
    }

    private void actualizarInfo() {
        barraVidaJ1.setValue(dragonJugador1.getVida());
        barraVidaJ2.setValue(dragonJugador2.getVida());
        infoLabel.setText("Turno del Jugador " + turnoJugador + " - Dragón: " + obtenerDragonActual().getNombre());
    }

    public static void main(String[] args) {
        new Juego();
    }
}
