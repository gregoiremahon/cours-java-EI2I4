import java.util.ArrayList;

public class TestPaquetCartes {

    public static void main(String[] args) {
        TestPaquetCartes testeur = new TestPaquetCartes();
        testeur.testAjouterCarte();
        testeur.testMelanger();
        testeur.testDistribuer();
        testeur.testJouerPremiereCarte();
        testeur.testAjouterCarteAuDessous();
        testeur.testEstVide();
    }

    public void testAjouterCarte() {
        PaquetCartes paquet = new PaquetCartes();
        Carte carte = new Carte(1);
        paquet.ajouterCarte(carte);
        afficherTest("testAjouterCarte", paquet.getCartes().contains(carte));
    }

    public void testMelanger() {
        PaquetCartes paquet = new PaquetCartes();
        for (int i = 1; i <= 52; i++) {
            paquet.ajouterCarte(new Carte(i));
        }
        ArrayList<Carte> cartesAvantMelange = new ArrayList<>(paquet.getCartes());
        paquet.melanger();
        afficherTest("testMelanger", !cartesAvantMelange.equals(paquet.getCartes()));
    }

    public void testDistribuer() {
        PaquetCartes paquet = new PaquetCartes();
        for (int i = 1; i <= 52; i++) {
            paquet.ajouterCarte(new Carte(i));
        }
        ArrayList<ArrayList<Carte>> paquets = paquet.distribuer();
        afficherTest("testDistribuer", paquets.get(0).size() == 26 && paquets.get(1).size() == 26 && paquet.estVide());
    }

    public void testJouerPremiereCarte() {
        PaquetCartes paquet = new PaquetCartes();
        Carte carte = new Carte(1);
        paquet.ajouterCarte(carte);
        Carte carteJouee = paquet.jouerPremiereCarte();
        afficherTest("testJouerPremiereCarte", carte.equals(carteJouee) && paquet.estVide());
    }

    public void testAjouterCarteAuDessous() {
        PaquetCartes paquet = new PaquetCartes();
        Carte carte = new Carte(1);
        paquet.ajouterCarteAuDessous(carte);
        afficherTest("testAjouterCarteAuDessous", paquet.getCartes().contains(carte));
    }

    public void testEstVide() {
        PaquetCartes paquet = new PaquetCartes();
        afficherTest("testEstVide - au début", paquet.estVide());
        paquet.ajouterCarte(new Carte(1));
        afficherTest("testEstVide - après ajout", !paquet.estVide());
        paquet.jouerPremiereCarte();
        afficherTest("testEstVide - après avoir joué la carte", paquet.estVide());
    }

    private void afficherTest(String nomTest, boolean resultat) {
        System.out.println(nomTest + " : " + (resultat ? "SUCCÈS" : "ÉCHEC"));
    }
}
