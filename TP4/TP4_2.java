import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

class CalculDePi extends JFrame {
    private final int TAILLE = 400;
    private JPanel panelDessin;
    private int nombreDeGrains;
    private double estimationPi;
    private JComboBox<Integer> comboBox;
    private JLabel labelEstimationPi;
    private ArrayList<Point> grains = new ArrayList<>();
    private boolean dessinerGrains = false;

    public CalculDePi() {
        super("Calcul de π grains de riz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        comboBox = new JComboBox<>();
        for (int i = 100; i <= 5000; i += 100) {
            comboBox.addItem(i);
        }
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreDeGrains = (int) comboBox.getSelectedItem();
                dessinerGrains = true;
                lancerLesGrains();
            }
        });
        add(comboBox, BorderLayout.NORTH);

        labelEstimationPi = new JLabel("Estimation de π: ");
        add(labelEstimationPi, BorderLayout.SOUTH);

        panelDessin = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dessinerCercleEtGrains(g);
            }
        };
        panelDessin.setPreferredSize(new Dimension(TAILLE, TAILLE));
        add(panelDessin, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void lancerLesGrains() {
        grains.clear();
        estimationPi = 0;
        int grainsDansLeCercle = 0;
        Random random = new Random();

        for (int i = 0; i < nombreDeGrains; i++) {
            int x = random.nextInt(TAILLE);
            int y = random.nextInt(TAILLE);
            grains.add(new Point(x, y));
            if (Math.pow(x - TAILLE / 2, 2) + Math.pow(y - TAILLE / 2, 2) <= Math.pow(TAILLE / 2, 2)) {
                grainsDansLeCercle++;
            }
        }

        estimationPi = 4.0 * grainsDansLeCercle / nombreDeGrains;
        labelEstimationPi.setText("Estimation de π: " + estimationPi);
        panelDessin.repaint();
    }

    private void dessinerCercleEtGrains(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval(0, 0, TAILLE, TAILLE);
        if (dessinerGrains) {
            for (Point grain : grains) {
                g.setColor(Color.RED);
                g.fillOval(grain.x, grain.y, 5, 5);
            }
            dessinerGrains = false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculDePi().setVisible(true));
    }
}
