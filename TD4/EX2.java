import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class FenetreNumerotee extends JFrame implements MouseListener {
    private String nomFenetre;
    static int instanceCounter = 0;
    int counter = 0;

    public FenetreNumerotee(String nom) {
        super(nom);
        instanceCounter++;
        counter = instanceCounter;
        this.nomFenetre = nom;
        this.setLocation(350 * counter, 500);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        afficherDetailsEvenement("Clic", e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        afficherDetailsEvenement("Appui", e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        afficherDetailsEvenement("Relâchement", e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    private void afficherDetailsEvenement(String typeEvenement, MouseEvent e) {
        System.out.println("Événement: " + typeEvenement + " sur " + nomFenetre +
                           " - Coordonnées: x=" + e.getX() + ", y=" + e.getY());
    }

    public static void main(String[] args) {
        FenetreNumerotee fenetre1 = new FenetreNumerotee("Fenêtre 1");
        FenetreNumerotee fenetre2 = new FenetreNumerotee("Fenêtre 2");
        FenetreNumerotee fenetre3 = new FenetreNumerotee("Fenêtre 3");

        fenetre1.setVisible(true);
        fenetre2.setVisible(true);
        fenetre3.setVisible(true);
    }
}
