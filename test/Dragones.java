
package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Dragones {
    private int ataque;
    private int vida;
    
    public Dragones(){
        
    }
    
    public JPanel panel(){
        JPanel panel = new JPanel(new GridLayout(2,1,20,20));
        panel.setBackground(Color.green);
        
        JPanel Starriba = new JPanel(new BorderLayout());
        Starriba.setBackground(Color.yellow);
        JButton cambiar = new JButton("volver");
        Starriba.add(cambiar, BorderLayout.CENTER);
        
        panel.add(Starriba);
        
        JPanel opciones = new JPanel(new GridLayout(1,3,20,20));
        JButton ataque1 = new JButton("Ataque fuego");
        JButton ataque2 = new JButton("Ataque 2");
        JButton ataque3 = new JButton("Ataque 3");
        opciones.add(ataque1);
        opciones.add(ataque2);
        opciones.add(ataque3);
        panel.add(opciones);
        
        return panel;
    }
}
