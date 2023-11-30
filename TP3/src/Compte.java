public class Compte {
    private int numero;
    private double solde;

    public Compte(int numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public void crediter(double montant) {
        this.solde += montant;
    }

    public void debiter(double montant) {
        if (this.solde >= montant) {
            this.solde -= montant;
        } else {
            System.out.println("Solde insuffisant pour le débit.");
        }
    }

    public void realiserVirement(int numeroCompteBeneficiaire, Banque banque, double montant) {
        if (this.solde >= montant) {
            for (Compte compte : banque.getComptes()) {
                if (compte.getNumero() == numeroCompteBeneficiaire) {
                    this.debiter(montant);
                    compte.crediter(montant);
                    System.out.println("Virement réalisé avec succès.");
                    return;
                }
            }
            System.out.println("Compte bénéficiaire introuvable.");
        } else {
            System.out.println("Solde insuffisant pour le virement.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
               "numero=" + numero +
               ", solde=" + solde +
               '}';
    }
}
