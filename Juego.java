import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Juego extends JFrame {
    private Dragon[] dragones = { new fuego(), new agua(), new tierra() };
    private Dragon dragonJugador1, dragonJugador2;
    private int turnoJugador = 1;

    private JLabel infoLabel;
    private JPanel buttonPanel;

    public Juego() {
        setTitle("Dragon City - PvP");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        infoLabel = new JLabel("Jugador 1 - Turno inicial", SwingConstants.CENTER);
        add(infoLabel, BorderLayout.NORTH);
        
        JPanel imagenes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        imagenes.setBackground(Color.red);
        add(imagenes, BorderLayout.CENTER);

        buttonPanel = new JPanel(new GridLayout(2, 2));
        inicializarBotonesPrincipales();
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setPreferredSize(new Dimension(getWidth(), 150));

        dragonJugador1 = dragones[0];
        dragonJugador2 = dragones[1];
        actualizarInfo();
        
        setVisible(true);
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
        String[] opciones = tipo.equals("ataque") ? dragonActual.getAtaques() : 
                            tipo.equals("defensa") ? dragonActual.getDefensas() : dragonActual.getPotencias();

        buttonPanel.removeAll();
        for (String opcion : opciones) {
            JButton opcionBtn = new JButton(opcion);
            opcionBtn.addActionListener(e -> {
                infoLabel.setText("Jugador " + turnoJugador + " usó: " + opcion);
                cambiarTurno();
            });
            buttonPanel.add(opcionBtn);
        }

        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> inicializarBotonesPrincipales());
        buttonPanel.add(volverBtn);

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private void cambiarDragon() {
        JFrame cambioFrame = new JFrame("Cambiar Dragón - Jugador " + turnoJugador);
        cambioFrame.setSize(300, 150);
        cambioFrame.setLayout(new GridLayout(1, 3));

        for (Dragon dragon : dragones) {
            JButton dragonBtn = new JButton(dragon.nombre);
            dragonBtn.addActionListener(e -> {
                if (turnoJugador == 1) dragonJugador1 = dragon;
                else dragonJugador2 = dragon;

                infoLabel.setText("Jugador " + turnoJugador + " cambió a: " + dragon.nombre);
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

    private void cambiarTurno() {
        turnoJugador = (turnoJugador == 1) ? 2 : 1;
        actualizarInfo();
    }

    private void actualizarInfo() {
        String dragonActual = obtenerDragonActual().nombre;
        infoLabel.setText("Turno del Jugador " + turnoJugador + " - Dragón: " + dragonActual);
        inicializarBotonesPrincipales();
    }

    public static void main(String[] args) {
        new Juego();
    }
}