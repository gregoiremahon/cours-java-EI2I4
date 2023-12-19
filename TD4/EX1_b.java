import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MaFenetre extends JFrame {
    private class EcouteurSouris implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clic détecté: x=" + e.getX() + ", y=" + e.getY());
        }

        public void mousePressed(MouseEvent e) {
            System.out.println("Souris appuyée: x=" + e.getX() + ", y=" + e.getY());
        }

        public void mouseReleased(MouseEvent e) {
            System.out.println("Souris relâchée: x=" + e.getX() + ", y=" + e.getY());
        }

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}
    }


    public MaFenetre() {
        super("Fenêtre avec Écouteur de Souris");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EcouteurSouris ecouteur = new EcouteurSouris();
        this.addMouseListener(ecouteur);
    }
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clic détecté: x=" + e.getX() + ", y=" + e.getY());
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Souris appuyée: x=" + e.getX() + ", y=" + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Souris relâchée: x=" + e.getX() + ", y=" + e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Souris entrée dans la fenetre: x=" + e.getX() + ", y=" + e.getY());
        
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Souris sortie de la fenetre: x=" + e.getX() + ", y=" + e.getY());
    }

    public static void main(String[] args) {
        MaFenetre fenetre = new MaFenetre();
        fenetre.setVisible(true);
    }
}
