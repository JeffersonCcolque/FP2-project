package test;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class Cuadros extends JFrame{
    public Cuadros (){
        setTitle("Juego");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelprincipal = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.setBackground(Color.red);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        JLabel turno = new JLabel("Turno de...");
        panel2.add(turno, new FlowLayout(FlowLayout.CENTER));
        
        JPanel panel3 = new JPanel(new GridLayout(2,1,20,20));
        panel3.setBackground(Color.green);
        
        JPanel Starriba = new JPanel(new BorderLayout());
        Starriba.setBackground(Color.yellow);
        JButton cambiar = new JButton("cambiar");
        Starriba.add(cambiar, BorderLayout.CENTER);
        
        panel3.add(Starriba);
        
        JPanel opciones = new JPanel(new GridLayout(1,3,20,20));
        JButton ataque = new JButton("Ataque");
        JButton defensa = new JButton("defensa");
        JButton potenciar = new JButton("potenciar");
        opciones.add(ataque);
        opciones.add(defensa);
        opciones.add(potenciar);
        panel3.add(opciones);
        
        ataque.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Dragones dr = new Dragones();
                panel3.setVisible(false);
                panelprincipal.add(dr.panel(), BorderLayout.SOUTH);
                dr.panel().setPreferredSize(new Dimension(getWidth(), 150));
            }
            
        });
        
        
        
        
        
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.white);
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.black);
        
        panelprincipal.add(panel1, BorderLayout.CENTER);
        panelprincipal.add(panel2, BorderLayout.NORTH);
        panelprincipal.add(panel3, BorderLayout.SOUTH);
        panelprincipal.add(panel4, BorderLayout.EAST);
        panel3.setPreferredSize(new Dimension(getWidth(), 150));

        panelprincipal.add(panel5, BorderLayout.WEST);
        
        add(panelprincipal);
        setVisible(true);
    }
    public static void main(String[] args){
        new Cuadros();
    }
    
    public JPanel asd(){
        JPanel panelasd = new JPanel();
        return panelasd;
    }
    
}
