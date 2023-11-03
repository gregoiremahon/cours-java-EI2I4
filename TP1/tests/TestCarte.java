public class TestCarte {

    public static void main(String[] args) {
        TestCarte testeur = new TestCarte();
        testeur.testConstructeur();
        testeur.testComparerCarte();
        testeur.testInfosCarte();
    }

    public void testConstructeur() {
        Carte carte = new Carte(1);
        afficherTest("testConstructeur - As de pique", "As".equals(carte.getNom()) && "pique".equals(carte.getCouleur()) && carte.getValeur() == 14);

        Carte carte2 = new Carte(15); // Deux de coeur
        afficherTest("testConstructeur - Deux de coeur", "Deux".equals(carte2.getNom()) && "coeur".equals(carte2.getCouleur()) && carte2.getValeur() == 2);
    }

    public void testComparerCarte() {
        Carte carte1 = new Carte(1); // As de pique
        Carte carte2 = new Carte(14); // As de coeur
        Carte carte3 = new Carte(27); // As de carreau
        Carte carte4 = new Carte(15); // Deux de coeur
        Carte carte5 = new Carte(28); // Deux de carreau

        // Comparaison des As
        afficherTest("testComparerCarte - égalité carte1 et carte2", carte1.comparerCarte(carte2) == 0);
        afficherTest("testComparerCarte - égalité carte1 et carte3", carte1.comparerCarte(carte3) == 0);
        afficherTest("testComparerCarte - égalité carte3 et carte2", carte3.comparerCarte(carte2) == 0);

        // Comparaison As et Deux
        afficherTest("testComparerCarte - carte1 > carte4", carte1.comparerCarte(carte4) > 0);
        afficherTest("testComparerCarte - carte2 > carte5", carte2.comparerCarte(carte5) > 0);
        afficherTest("testComparerCarte - carte3 > carte4", carte3.comparerCarte(carte4) > 0);

        // Comparaison entre Deux
        afficherTest("testComparerCarte - égalité carte4 et carte5", carte4.comparerCarte(carte5) == 0);
    }

    public void testInfosCarte() {
        Carte carte = new Carte(1); // As de pique
        afficherTest("testInfosCarte - As de pique", "As de pique; valeur : 14".equals(carte.infosCarte()));

        Carte carte2 = new Carte(15); // Deux de coeur
        afficherTest("testInfosCarte - Deux de coeur", "Deux de coeur; valeur : 2".equals(carte2.infosCarte()));
    }

    private void afficherTest(String nomTest, boolean resultat) {
        System.out.println(nomTest + " : " + (resultat ? "SUCCÈS" : "ÉCHEC"));
    }
}
