public class TestJeuBataille {

    public static void main(String[] args) {
        TestJeuBataille testeur = new TestJeuBataille();
        testeur.testInitialiserJeu();
        testeur.testJouerTour();
        testeur.testBataille();
        testeur.testJoueurGagnant();
    }

    public void testInitialiserJeu() {
        JeuBataille jeu = new JeuBataille();
        afficherTest("testInitialiserJeu", jeu.getJoueur1().aEncoreDesCartes() && jeu.getJoueur2().aEncoreDesCartes());
    }

    public void testJouerTour() {
        JeuBataille jeu = new JeuBataille();
        jeu.jouerTour(false);
        afficherTest("testJouerTour", jeu.getCartesSurTable().isEmpty());
    }

    public void testBataille() {
        JeuBataille jeu = new JeuBataille();
        while (jeu.getJoueur1().aEncoreDesCartes() && jeu.getJoueur2().aEncoreDesCartes()) {
            jeu.jouerTour(false);
            if (!jeu.getCartesSurTable().isEmpty()) {
                jeu.bataille();
                afficherTest("testBataille", jeu.getCartesSurTable().isEmpty());
                break;
            }
        }
    }

    public void testJoueurGagnant() {
        JeuBataille jeu = new JeuBataille();
        while (jeu.getJoueur1().aEncoreDesCartes() && jeu.getJoueur2().aEncoreDesCartes()) {
            jeu.jouerTour(false);
        }
        Joueur gagnant = jeu.joueurGagnant();
        afficherTest("testJoueurGagnant", gagnant == jeu.getJoueur1() || gagnant == jeu.getJoueur2() || gagnant == null);
    }

    private void afficherTest(String nomTest, boolean resultat) {
        System.out.println(nomTest + " : " + (resultat ? "SUCCÈS" : "ÉCHEC"));
    }
}
