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
        setResizable(false); // Prevenir redimensionamiento

        // Verificar existencia del archivo de imagen
        File fondoFile = new File("C:\\Users\\jefer\\Documents\\Nueva carpeta (2)\\FP2_Proyec\\FP2-project\\img\\fondo.png");
        ImageIcon fondoIcon;
        
        try {
            if (fondoFile.exists()) {
                fondoIcon = redimensionarImagen(new ImageIcon(fondoFile.getPath()), 500, 400);
            } else {
                // Imagen de respaldo si no se encuentra el archivo
                fondoIcon = new ImageIcon(getClass().getResource("/recursos/fondo_defecto.png"));
            }
        } catch (Exception e) {
            // Manejar caso de error de imagen
            System.err.println("Error al cargar la imagen de fondo: " + e.getMessage());
            fondoIcon = new ImageIcon(); // Icono vacío
        }

        // Crear fondo de pantalla
        JLabel fondoLabel = new JLabel(fondoIcon);
        fondoLabel.setBounds(50, 50, 600, 500); // Aseguramos que cubra todo el marco

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
        add(fondoLabel); // Fondo al final para que quede detrás

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
        // Implementar lógica de selección aleatoria de dragones
        System.out.println("Seleccionando dragones aleatorios");
    }

    public void elegir() {
        // Implementar lógica de selección manual de dragones
        System.out.println("Eligiendo dragones");
    }
}