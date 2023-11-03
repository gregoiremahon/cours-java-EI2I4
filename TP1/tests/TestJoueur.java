import java.util.ArrayList;
import java.util.List;
public class TestJoueur {

    public static void main(String[] args) {
        TestJoueur testeur = new TestJoueur();
        testeur.testJouerCarte();
        testeur.testGagnerCartes();
        testeur.testAEncoreDesCartes();
    }

    public void testJouerCarte() {
        Joueur joueur = new Joueur();
        for (int i = 1; i <= 52; i++) {
            joueur.gagnerCartes(new ArrayList<>(List.of(new Carte(i))));
        }
        Carte carte = joueur.jouerCarte();
        afficherTest("testJouerCarte", carte != null);
    }

    public void testGagnerCartes() {
        Joueur joueur = new Joueur();
        int tailleInitiale = joueur.getPaquetCartes().getCartes().size();
        ArrayList<Carte> cartesGagnees = new ArrayList<>();
        cartesGagnees.add(new Carte(1));
        cartesGagnees.add(new Carte(2));
        joueur.gagnerCartes(cartesGagnees);
        afficherTest("testGagnerCartes", joueur.getPaquetCartes().getCartes().size() == tailleInitiale + 2);
    }

    public void testAEncoreDesCartes() {
        Joueur joueur = new Joueur();
        for (int i = 1; i <= 52; i++) {
            joueur.gagnerCartes(new ArrayList<>(List.of(new Carte(i))));
        }
        boolean aEncoreDesCartes = joueur.aEncoreDesCartes();
        afficherTest("testAEncoreDesCartes - au début", aEncoreDesCartes);

        int tailleInitiale = joueur.getPaquetCartes().getCartes().size();
        for (int i = 0; i < tailleInitiale; i++) {
            joueur.jouerCarte();
        }
        aEncoreDesCartes = joueur.aEncoreDesCartes();
        afficherTest("testAEncoreDesCartes - après avoir joué toutes les cartes", !aEncoreDesCartes);
    }

    private void afficherTest(String nomTest, boolean resultat) {
        System.out.println(nomTest + " : " + (resultat ? "SUCCÈS" : "ÉCHEC"));
    }
}
