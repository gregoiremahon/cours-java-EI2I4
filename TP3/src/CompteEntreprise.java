public class CompteEntreprise extends Compte {
    private String nomEntreprise;

    public CompteEntreprise(int numero, double solde, String nomEntreprise) {
        super(numero, solde);
        this.nomEntreprise = nomEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    @Override
    public String toString() {
        return "CompteEntreprise{" +
               "nomEntreprise='" + nomEntreprise + '\'' +
               ", numero=" + getNumero() +
               ", solde=" + getSolde() +
               '}';
    }
}
