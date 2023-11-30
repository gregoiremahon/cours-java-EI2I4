public class ComptePersonnePhysique extends Compte {
    private String nom;
    private String prenom;
    private double decouvertAutorise;
    private boolean estAnonyme;

    public ComptePersonnePhysique(int numero, double solde, String nom, String prenom, double decouvertAutorise, boolean estAnonyme) {
        super(numero, solde);
        this.nom = nom;
        this.prenom = prenom;
        this.decouvertAutorise = decouvertAutorise;
        this.estAnonyme = estAnonyme;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setAnonyme(boolean estAnonyme) {
        this.estAnonyme = estAnonyme;
    }

    public boolean getAnonymat(){
        return estAnonyme;
    }

    @Override
    public String toString() {
        if (estAnonyme) {
            return "ComptePersonneAnonyme{" +
                   "numero=" + getNumero() +
                   ", solde=" + getSolde() +
                   ", estAnonyme=" + estAnonyme +
                   '}';
        } else {
            return "ComptePersonnePhysique{" +
                   "nom='" + nom + '\'' +
                   ", prenom='" + prenom + '\'' +
                   ", decouvertAutorise=" + decouvertAutorise +
                   ", numero=" + getNumero() +
                   ", solde=" + getSolde() +
                   '}';
        }
    }
}
