import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class DessinEnCouleur extends JFrame {
    private Color couleurActuelle = Color.BLACK;
    private ArrayList<Point> points = new ArrayList<>();
    private JPanel zoneDessin;

    public DessinEnCouleur() {
        setTitle("Dessin en couleur");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton btnCouleur = new JButton("Choisir Couleur");
        btnCouleur.addActionListener(e -> choisirCouleur());
        add(btnCouleur, BorderLayout.NORTH);

        JButton btnNouvelleLigne = new JButton("Nouvelle Ligne");
        btnNouvelleLigne.addActionListener(e -> nouvelleLigne());
        add(btnNouvelleLigne, BorderLayout.SOUTH);

        zoneDessin = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(couleurActuelle);
                for (int i = 0; i < points.size() - 1; i++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(i + 1);
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        };
        zoneDessin.setPreferredSize(new Dimension(800, 550));
        zoneDessin.setBackground(Color.WHITE);
        zoneDessin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });
        add(zoneDessin, BorderLayout.CENTER);
    }

    private void choisirCouleur() {
        couleurActuelle = JColorChooser.showDialog(this, "Choisir une couleur", couleurActuelle);
    }

    private void nouvelleLigne() {
        points.clear();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DessinEnCouleur().setVisible(true);
        });
    }
}
