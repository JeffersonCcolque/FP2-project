import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class principal extends JFrame {

    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety for Swing components
        SwingUtilities.invokeLater(() -> new principal());
    }

    public principal() {
        // Configuración del marco principal
        setTitle("Juego de Dragones");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usamos diseño nulo para posicionar los elementos manualmente

        JLabel lblPerfil = new JLabel();
        ImageIcon perfilIcon = redimensionarImagen(new ImageIcon("FP2-project\\img\\fondo_pant.jpg"),600,500); // Ruta de la imagen de perfil
        lblPerfil.setIcon(perfilIcon);
        lblPerfil.setBounds(0, 0, 600, 500); // Colocar la imagen centrada en la parte superior
        

        // Creación de botones con mejoras de estilo
        JButton eleg = new JButton("Elegir Dragones");
        eleg.setBounds(100, 300, 150, 50);
        eleg.setFont(new Font("Arial", Font.BOLD, 12));
        eleg.setBackground(new Color(100, 200, 100)); // Color verde claro
        eleg.setForeground(Color.WHITE);

        JButton rand = new JButton("Dragones Aleatorios");
        rand.setBounds(300, 300, 150, 50);
        rand.setFont(new Font("Arial", Font.BOLD, 12));
        rand.setBackground(new Color(100, 150, 200)); // Color azul claro
        rand.setForeground(Color.WHITE);

        // Añadir ActionListeners con expresiones lambda (Java 8+)
        eleg.addActionListener(e -> elegir());
        rand.addActionListener(e -> dragRandom());

        // Añadir componentes
        add(eleg);
        add(rand);
        add(lblPerfil);

        // Hacer visible el marco
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
    }

    public ImageIcon redimensionarImagen(ImageIcon icono, int ancho, int alto) {
        Image imagen = icono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }

    public void dragRandom() {    
        SwingUtilities.invokeLater(() -> new DragonesRand());
    }

    public void elegir() {
    // Abrir la pantalla de selección de dragones
    SwingUtilities.invokeLater(() -> new Elecciones());
    dispose();
    }   

}
