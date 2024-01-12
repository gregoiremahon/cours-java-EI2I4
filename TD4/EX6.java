/*
 * EXERCICE 6 TD4
 * Un peu de dessin avec le clavier
 * 
 * Réaliser une fenêtre intitulée "Dessin en clavier" qui permettra à l'utilisateur de faire du 
 * dessin en utilisant les touches fléchées du clavier. Le dessin débutera en un point précis de la fenêtre (position 20x20)
 * et on procédera à un incrément de 5pixels pour chaque pression sur une touche fléchée.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class DessinEnClavier extends JFrame {
    private int x = 20, y = 20; // Position initiale
    private ArrayList<Point> points = new ArrayList<>(); // Liste pour stocker les points

    public DessinEnClavier() {
        setTitle("Dessin en clavier");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        points.add(new Point(x, y)); // Ajouter le point initial à la liste

        JPanel panelDessin = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < points.size() - 1; i++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(i + 1);
                    g.drawLine(p1.x, p1.y, p2.x, p2.y); // Dessiner une ligne entre les points
                }
                g.fillOval(x, y, 5, 5); // Dessiner un point à la position (x, y)
            }
        };
        panelDessin.setFocusable(true);
        panelDessin.requestFocusInWindow();

        panelDessin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        y -= 5; 
                        break;
                    case KeyEvent.VK_DOWN:  
                        y += 5; 
                        break;
                    case KeyEvent.VK_LEFT:  
                        x -= 5; 
                        break;
                    case KeyEvent.VK_RIGHT: 
                        x += 5; 
                        break;
                    /*case KeyEvent.VK_SPACE:
                        points.add(new Point(x, y));
                        break;*/
                }
                points.add(new Point(x, y));
                panelDessin.repaint(); // Redessine l'entièreté du panel
            }
        });
        add(panelDessin);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DessinEnClavier().setVisible(true);
        });
    }
}
