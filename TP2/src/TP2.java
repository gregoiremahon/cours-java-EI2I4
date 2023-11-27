import java.util.Scanner;
import java.util.Random;

public class TP2 {
    private static Banque banque = new Banque("Société Géniale");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = -1;
        genererComptesAleatoires(20);
        while (choix != 6) {
            afficherMenu();
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    ouvrirCompte(scanner);
                    break;
                case 2:
                    afficherTousLesComptes();
                    break;
                case 3:
                    effectuerVirement(scanner, banque);
                    break;
                case 4:
                    afficherComptesCertainType(scanner, banque);
                    break;
                case 5:
                    banque.trierComptesParSolde();
                    afficherTousLesComptes();
                    break;
                case 6:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } 
        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("Bienvenue dans la gestion de la Banque " + banque.getNom() + " !");
        System.out.println("Quelle action souhaitez vous effectuer ? " + "\n");
        System.out.println("1. Ouvrir un nouveau compte");
        System.out.println("2. Afficher tous les comptes");
        System.out.println("3. Effectuer un virement entre deux comptes");
        System.out.println("4. Afficher les comptes par type");
        System.out.println("5. Trier les comptes en fonction de leur solde");
        System.out.println("6. Quitter" + "\n");
        System.out.print("Entrez votre choix : ");
    }

    private static int choisirTypeCompte(Scanner scanner){
        System.out.println("1. Compte pour entreprise");
        System.out.println("2. Compte pour personne physique");
        System.out.println("3. Compte pour personne anonyme");
        int choixCompte = -1;
        while (!(choixCompte >= 1 && choixCompte <= 3)){
            choixCompte = scanner.nextInt();
            if(!(choixCompte >= 1 && choixCompte <= 3)) System.out.println("Choix invalide, veuillez recommencer.");
        }
        scanner.nextLine();
        return choixCompte;
        
    }

    private static void ouvrirCompte(Scanner scanner) {
        System.out.print("Entrez le numéro de compte : ");
        int numero = scanner.nextInt();
        System.out.print("Entrez le solde initial : ");
        double solde = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Quel type de compte ? ");
        int typeCompte = choisirTypeCompte(scanner); // 1 = compte pour entreprise, 2 = compte personne, 3 = compte personne anonyme

        switch (typeCompte) {
            case 1: // Compte entreprise
                ouvrirCompteEntreprise(scanner, numero, solde);
                break;
            case 2: // Compte personne physique
                ouvrirComptePersonnePhysique(scanner, numero, solde, false);
                break;
            case 3: // Compte personne anonyme
                ouvrirComptePersonnePhysique(scanner, numero, solde, true);
                break;
        }
        System.out.println("Compte ouvert avec succès." + "\n");
    }

    private static void ouvrirCompteEntreprise(Scanner scanner, int numero, double solde){
        System.out.print("Entrez le nom de l'entreprise : ");
        String nomEntreprise = scanner.nextLine();
        CompteEntreprise nouveauCompte = new CompteEntreprise(numero, solde, nomEntreprise);
        banque.ouvrirCompte(nouveauCompte);
    }

    private static void ouvrirComptePersonnePhysique(Scanner scanner, int numero, double solde, boolean estAnonyme){
        System.out.print("Entrez le nom du titulaire du compte : ");
        String nomTitulaire = scanner.nextLine();
        System.out.print("Entrez le prénom du titulaire du compte : ");
        String prenomTitulaire = scanner.nextLine();
        System.out.print("Limite de découvert : ");
        double decouvertAutorise = scanner.nextDouble();
        scanner.nextLine();
        ComptePersonnePhysique nouveauComptePersonnePhysique = new ComptePersonnePhysique(numero, solde, nomTitulaire, prenomTitulaire, decouvertAutorise, estAnonyme);
        banque.ouvrirCompte(nouveauComptePersonnePhysique);
    }

    private static void afficherTousLesComptes() {
        banque.afficherComptes();
    }

    private static void afficherComptesCertainType(Scanner scanner, Banque banque){
        int numeroTypeCompte = choisirTypeCompte(scanner); // 1 = compte pour entreprise, 2 = compte personne, 3 = compte personne anonyme
        String typeCompte; 
        switch (numeroTypeCompte) {
            case 1:
                typeCompte = "CompteEntreprise";
                banque.afficherComptesParType(typeCompte);
                break;
            case 2:
                typeCompte = "ComptePersonnePhysique";
                banque.afficherComptesParType(typeCompte);
                break;
            case 3:
                typeCompte = "ComptePersonneAnonyme";
                banque.afficherComptesParType(typeCompte);
                break;
            default:
                System.out.println("Le type de compte est invalide. Veuillez recommencer le processus.");
                break;
        }
    }

    private static void effectuerVirement(Scanner scanner, Banque banque){
        System.out.println("Voulez vous vous connecter afin d'afficher la liste des comptes ? [Y]/N");
        String reponse = scanner.nextLine().trim().toUpperCase();
        boolean connexionStatus = reponse.isEmpty() || reponse.equals("Y");
        if (connexionStatus){
            while (!(connexionAdmin(scanner))){
                System.out.println("Mot de passe incorrect, veuillez réessayer.");
            }
            afficherTousLesComptes();
        } 
        Compte compte = connexionUtilisateur(banque, scanner);
        System.out.println("Veuillez entrer l'identifiant du compte bénéficiaire : ");
        int numeroBeneficiaire = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Montant du virement : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        compte.realiserVirement(numeroBeneficiaire, banque, montant);
    }

    public static Compte connexionUtilisateur(Banque banque, Scanner scanner) {
        System.out.println("Veuillez entrer votre numero de compte : ");
        int numeroCompte = scanner.nextInt();
        scanner.nextLine();
        Compte trouverCompte = trouverCompte(numeroCompte, banque);
        if (trouverCompte != null){
            return trouverCompte;
        } System.out.println("Choix incorrect, veuillez recommencer le processus.");
        return null;
    }

    public static Compte trouverCompte(int numeroCompte, Banque banque) {
        for (Compte compte : banque.getComptes()) {
            if (compte.getNumero() == numeroCompte) {
                return compte;
            }
        }
        return null;
    }

    private static boolean connexionAdmin(Scanner scanner){
        System.out.println("Veuillez entrer votre identifiant :");
        String identifiant = scanner.nextLine(); // à implémenter
        System.out.println("Veuillez entrer votre mot de passe :");
        String motDePasse = scanner.nextLine().trim().toLowerCase();
        return "admin".equals(motDePasse); // à sécuriser :) TBC
    }

    private static void genererComptesAleatoires(int nombreDeComptes) {
        Random random = new Random();
        String[] noms = {"Dupont", "Durand", "Lefebvre", "Moreau", "Laurent"};
        String[] prenoms = {"Jean", "Marie", "Julie", "Luc", "Anna"};

        for (int i = 0; i < nombreDeComptes; i++) {
            int typeCompte = random.nextInt(3); // 0 pour ComptePersonnePhysique, 1 pour ComptePersonnePhysique anonyme, 2 pour CompteEntreprise
            int numero = i + 1;  // Numéro de compte ordonné
            double solde = random.nextDouble() * 10000;  // Solde aléatoire

            switch (typeCompte) {
                case 0: // ComptePersonnePhysique
                    String nom = noms[random.nextInt(noms.length)];
                    String prenom = prenoms[random.nextInt(prenoms.length)];
                    double decouvertAutorise = random.nextDouble() * 1000;
                    ComptePersonnePhysique comptePP = new ComptePersonnePhysique(numero, solde, nom, prenom, decouvertAutorise, false);
                    banque.ouvrirCompte(comptePP);
                    break;
                case 1: // ComptePersonnePhysique anonyme
                    nom = "Anonyme";
                    prenom = "Anonyme";
                    decouvertAutorise = random.nextDouble() * 1000;
                    ComptePersonnePhysique compteAnonyme = new ComptePersonnePhysique(numero, solde, nom, prenom, decouvertAutorise, true);
                    banque.ouvrirCompte(compteAnonyme);
                    break;
                case 2: // CompteEntreprise
                    String nomEntreprise = "Entreprise" + i;
                    CompteEntreprise compteEntreprise = new CompteEntreprise(numero, solde, nomEntreprise);
                    banque.ouvrirCompte(compteEntreprise);
                    break;
            }
        }
    }

}
