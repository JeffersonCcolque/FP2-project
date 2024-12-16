import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class Elecciones extends JFrame {
    private String llamar;
    private ArrayList<Dragon> dragones = new ArrayList<>();
    private ArrayList<Dragon> selectedDragones = new ArrayList<>();
    private JButton[] dragonButtons = new JButton[6];
    private int selectedCount = 0;
    private ArrayList<Dragon> dragonesj1 = new ArrayList<>();
    private ArrayList<Dragon> dragonesj2 = new ArrayList<>();
    private int jugadorActual = 0;
    
    public Elecciones(String llamar){
        this.llamar = llamar;
    }

    public Elecciones() {
        setTitle("Seleccionar Dragones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 3, 10, 10)); 
        
        cargarDragones();
        
        // Crear botones para cada dragón
        for (int i = 0; i < dragones.size(); i++) {
            final int index = i;
            JButton btn = new JButton(dragones.get(i).getNombre());
            btn.setPreferredSize(new Dimension(200, 250));
            
            // Añadir imagen del dragón si está disponible
            if (dragones.get(i).getImagen() != null) {
                ImageIcon icon = redimensionarImagen(new ImageIcon(dragones.get(i).getImagen()), 200, 200);
                btn.setIcon(icon);
                btn.setVerticalTextPosition(SwingConstants.BOTTOM);
                btn.setHorizontalTextPosition(SwingConstants.CENTER);
            }
            
            btn.addActionListener(e -> seleccionarDragon(index));
            add(btn);
            dragonButtons[i] = btn;
        }
        
        // Botón de confirmación
        JButton confirmBtn = new JButton("Confirmar Selección");
        confirmBtn.addActionListener(e -> confirmarSeleccion());
        add(confirmBtn);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void cargarDragones() {
        Object[][] atqFuego = new Object[][] {{"Llamarada", 50}, {"Tormenta de Fuego", 70}, {"Explosión Infernal", 100}};
        Object[][] defFuego = new Object[][] {{"Escudo de Fuego", 40}, {"Defensa Calorífica", 60}, {"Barricada Ardiente", 80}}; 
        Object[][] potFuego = new Object[][] {{"Potencia Infernal", 30}, {"Potencia Solar", 50}, {"Explosión Final", 100}};
        Dragon drafuego = new fuego("Ignil", 100, atqFuego, defFuego, potFuego,"FP2-project\\img\\fuego.jpg");

        Object[][] atqAgua = new Object[][] {{"Llamarada", 50}, {"Tormenta de Fuego", 70}, {"Explosión Infernal", 100}};
        Object[][] defAgua = new Object[][] {{"Escudo de Fuego", 40}, {"Defensa Calorífica", 60}, {"Barricada Ardiente", 80}}; 
        Object[][] potAgua = new Object[][] {{"Potencia Infernal", 30}, {"Potencia Solar", 50}, {"Explosión Final", 100}};
        Dragon draAgua = new agua("Vaporeon", 100, atqAgua, defAgua, potAgua,"FP2-project\\img\\agua.jpg");

        Object[][] atqAire = new Object[][] {{"Llamarada", 50}, {"Tormenta de Fuego", 70}, {"Explosión Infernal", 100}};
        Object[][] defAire = new Object[][] {{"Escudo de Fuego", 40}, {"Defensa Calorífica", 60}, {"Barricada Ardiente", 80}}; 
        Object[][] potAire = new Object[][] {{"Potencia Infernal", 30}, {"Potencia Solar", 50}, {"Explosión Final", 100}};
        Dragon draAire = new aire("Tempest", 100, atqAire, defAire, potAire,"FP2-project\\img\\aire.jpg");

        Object[][] atqHielo = new Object[][] {{"Llamarada", 50}, {"Tormenta de Fuego", 70}, {"Explosión Infernal", 100}};
        Object[][] defHielo = new Object[][] {{"Escudo de Fuego", 40}, {"Defensa Calorífica", 60}, {"Barricada Ardiente", 80}}; 
        Object[][] potHielo = new Object[][] {{"Potencia Infernal", 30}, {"Potencia Solar", 50}, {"Explosión Final", 100}};
        Dragon draHielo = new hielo("Frost", 100, atqHielo, defHielo, potHielo,"FP2-project\\img\\hielo.jpg");

        Object[][] atqLuz = new Object[][] {{"Llamarada", 50}, {"Tormenta de Fuego", 70}, {"Explosión Infernal", 100}};
        Object[][] defLuz = new Object[][] {{"Escudo de Fuego", 40}, {"Defensa Calorífica", 60}, {"Barricada Ardiente", 80}}; 
        Object[][] potLuz = new Object[][] {{"Potencia Infernal", 30}, {"Potencia Solar", 50}, {"Explosión Final", 100}};
        Dragon draLuz = new luz("Blaze", 100, atqLuz, defLuz, potLuz,"FP2-project\\img\\luz.jpg");

        Object[][] atqTierra = new Object[][] {{"Llamarada", 50}, {"Tormenta de Fuego", 70}, {"Explosión Infernal", 100}};
        Object[][] defTierra = new Object[][] {{"Escudo de Fuego", 40}, {"Defensa Calorífica", 60}, {"Barricada Ardiente", 80}}; 
        Object[][] potTierra = new Object[][] {{"Potencia Infernal", 30}, {"Potencia Solar", 50}, {"Explosión Final", 100}};
        Dragon draTierra = new tierra("Groot", 100, atqTierra, defTierra, potTierra,"FP2-project\\img\\tierra.jpg");
        
        dragones.add(drafuego);
        dragones.add(draAgua);
        dragones.add(draAire);
        dragones.add(draHielo);
        dragones.add(draLuz);
        dragones.add(draTierra);
    }

    private void seleccionarDragon(int index) {
        Dragon dragonSeleccionado = dragones.get(index);
        
        // Verificar si el dragón ya está seleccionado
        if (selectedDragones.contains(dragonSeleccionado)) {
            // Deseleccionar el dragón
            dragonButtons[index].setBackground(null);
            selectedDragones.remove(dragonSeleccionado);
            selectedCount--;
            return;
        }
        
        // Limitar a 3 dragones por jugador
        if (jugadorActual == 0) {
            if (dragonesj1.size() < 3) {
                dragonButtons[index].setBackground(Color.GREEN);
                dragonesj1.add(dragonSeleccionado);
                selectedDragones.add(dragonSeleccionado);
                selectedCount++;
                
                if (dragonesj1.size() == 3) {
                    JOptionPane.showMessageDialog(this, "Jugador 1 ha seleccionado 3 dragones.");
                    jugadorActual = 1;
                    resetSeleccion();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Jugador 1 ya ha seleccionado 3 dragones.");
            }
        } else {
            if (dragonesj2.size() < 3) {
                dragonButtons[index].setBackground(Color.GREEN);
                dragonesj2.add(dragonSeleccionado);
                selectedDragones.add(dragonSeleccionado);
                selectedCount++;
                
                if (dragonesj2.size() == 3) {
                    JOptionPane.showMessageDialog(this, "Jugador 2 ha seleccionado 3 dragones.");
                    confirmarSeleccion();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Jugador 2 ya ha seleccionado 3 dragones.");
            }
        }
    }
    
    private void resetSeleccion() {
        // Reiniciar colores y selecciones para el segundo jugador
        for (JButton btn : dragonButtons) {
            btn.setBackground(null);
        }
        selectedDragones.clear();
        selectedCount = 0;
        setTitle("Seleccionar Dragones Jugador 2");
    }
    
    public ArrayList<Dragon> getDragp1() {
        return dragonesj1;
    }

    public ArrayList<Dragon> getDragp2() {
        return dragonesj2;
    }
    
    private void confirmarSeleccion() {
        if (dragonesj1.size() == 3 && dragonesj2.size() == 3) {
            JOptionPane.showMessageDialog(this, "Dragones seleccionados para ambos jugadores.");
            SwingUtilities.invokeLater(() -> new Juego());
            dispose(); // Cerrar la ventana de selección
        } else {
            JOptionPane.showMessageDialog(this, "Ambos jugadores deben seleccionar 3 dragones.");
            SwingUtilities.invokeLater(() -> new Juego());
            dispose();
        }
    }
    
    // Método para redimensionar imágenes
    private ImageIcon redimensionarImagen(ImageIcon icono, int ancho, int alto) {
        Image imagen = icono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }
}