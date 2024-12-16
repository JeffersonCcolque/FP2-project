import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Juego extends JFrame {
    private Dragon[] equipoJugador1, equipoJugador2;
    private Dragon dragonJugador1, dragonJugador2;
    private int turnoJugador = 1;

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
        
        JPanel imagenes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        imagenes.setBackground(Color.red);
        add(imagenes, BorderLayout.CENTER);
        
        barraVidaJ1 = new JProgressBar(0, 100);
        barraVidaJ2 = new JProgressBar(0, 100);
        barraVidaJ1.setStringPainted(true);
        barraVidaJ2.setStringPainted(true);
        barraVidaJ1.setForeground(Color.GREEN);
        barraVidaJ2.setForeground(Color.GREEN);

        JPanel vidaPanel = new JPanel(new GridLayout(1, 2));
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
        equipoJugador1 = new Dragon[]{new fuego(), new agua(), new tierra()};
        equipoJugador2 = new Dragon[]{new agua(), new tierra(), new fuego()};
        dragonJugador1 = equipoJugador1[0];
        dragonJugador2 = equipoJugador2[0];
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
        for (int i = 0; i < opciones.length; i++) {
            int nivel = i; // Nivel del botón actual
            JButton opcionBtn = new JButton(opciones[i]);
            opcionBtn.addActionListener(e -> {
                realizarAccion(tipo, nivel);
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

    private void realizarAccion(String tipo, int nivel) {
        Dragon atacante = obtenerDragonActual();
        Dragon oponente = obtenerDragonOponente();

        switch (tipo) {
            case "ataque":
                switch (nivel) {
                    case 0: oponente.vida -=10;
                        System.out.print(oponente.vida);
                        break;
                    case 1: oponente.vida -=20;
                        System.out.print(oponente.vida);
                        break;
                    case 2: oponente.vida -=30;
                        System.out.print(oponente.vida);
                        break;
                };
                for(String elemento:atacante.getFortalezas()){
                    if(oponente.elemento.equals(elemento)){
                        oponente.vida -=10;
                    }
                }
                for(String elemento:atacante.getDebilidades()){
                    if(oponente.elemento.equals(elemento)){
                        oponente.vida +=10;
                    }
                }
                infoLabel.setText("¡" + atacante.nombre + " usó un ataque de nivel " + (nivel + 1) + " e hizo de daño!");
                break;
            case "defensa":
                switch (nivel) {
                    case 0: atacante.dfns +=10;
                        System.out.print(atacante.vida);
                        break;
                    case 1: atacante.dfns +=20;
                        System.out.print(atacante.vida);
                        break;
                    case 2: atacante.dfns +=30;
                        System.out.print(atacante.vida);
                        break;
                };
                infoLabel.setText("¡" + atacante.nombre + " aumentó su defensa en puntos!");
                break;
            case "potencia":
                switch (nivel) {
                    case 0: atacante.vida +=20;
                        System.out.print(atacante.vida);
                        break;
                    case 1: atacante.atk +=20;
                        System.out.print(atacante.atk);
                        break;
                    case 2: atacante.vida +=10;
                        atacante.atk +=10;
                        break;
                };
                infoLabel.setText("¡" + atacante.nombre + " aumentó su ataque en puntos!");
                break;
        }
    }

    private void cambiarDragon() {
        Dragon[] equipoActual = turnoJugador == 1 ? equipoJugador1 : equipoJugador2;
        JFrame cambioFrame = new JFrame("Cambiar Dragón - Jugador " + turnoJugador);
        cambioFrame.setSize(300, 150);
        cambioFrame.setLayout(new GridLayout(1, equipoActual.length));

        for (Dragon dragon : equipoActual) {
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
    private Dragon obtenerDragonOponente() {
        return turnoJugador == 1 ? dragonJugador2 : dragonJugador1;
    }

    private void cambiarTurno() {
        turnoJugador = (turnoJugador == 1) ? 2 : 1;
        actualizarInfo();
    }

    private void actualizarInfo() {
        barraVidaJ1.setValue(dragonJugador1.vida);
        barraVidaJ2.setValue(dragonJugador2.vida);
        infoLabel.setText("Turno del Jugador " + turnoJugador + " - Dragón: " + obtenerDragonActual().nombre);
        inicializarBotonesPrincipales();
    }

    public static void main(String[] args) {
        new Juego();
    }
}