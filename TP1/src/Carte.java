public class Carte {
    private String couleur;
    private String nom;
    private int valeur;

    public Carte(int n) {
        String[] couleurs = {"pique", "coeur", "carreau", "trèfle"};
        String[] noms = {"As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi"};

        this.couleur = couleurs[(n - 1) / 13];
        this.nom = noms[(n - 1) % 13];
        
        if ("As".equals(this.nom)) {
            this.valeur = 14; // l'as aura toujours la valeur la plus élevée, au lieu de prendre 1
        } else {
            this.valeur = (n - 1) % 13 + 1;
        }
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public int comparerCarte(Carte autreCarte) {
        if (this.valeur > autreCarte.getValeur()) 
            return 1;
        if (this.valeur < autreCarte.getValeur()) 
            return -1;
        
        return 0;
    }

    public String infosCarte(){
        return this.getNom() + " de " + this.getCouleur() + "; valeur : " + this.getValeur();
    }

}
