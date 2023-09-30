import java.util.Random;
import java.util.ArrayList;

public class EX12 {

    static String[] poemes = {
        "Le roi de la pampa retourne sa chemise", // Vers 1 Début
        "Le cheval Parthénon s'énerve sur sa frise",
        "Le vieux marin breton de tabac prit sa prise",
        "C'était à cinq o'clock qu'il sortait la marquise",
        "Du jeune avantageux la nymphe était éprise",
        "Il se penche il voudrait attraper sa valise",
        "Quand l'un avecque l'autre aussitôt sympathise",
        "Lorsqu'un jour exalté l'aède prosaïse",
        "Le marbre pour l'acide est une friandise",
        "Lorsque tout est fini lorsque l'on agonise", // Vers 1 Fin
        "pour la mettre à sécher aux cornes des taureaux", // Vers 2 Début
        "depuis que lord Elgin négligea ses naseaux",
        "pour du fin fond du nez exciter les arceaux",
        "pour consommer un thé puis des petits gâteaux",
        "snob un peu sur les bords des bords fondamenteaux",
        "que convoitait c'est sûr une horde d'escrocs",
        "se faire il pourrait bien que ce soit des jumeaux",
        "pour déplaire au profane aussi bien qu'aux idiots",
        "d'aucuns par-dessus tout prisent les escargots",
        "lorsque le marbrier astique nos tombeaux", // Vers 2 Fin
        "le cornédbîf en boîte empeste la remise", // Vers 3 début
        "le Turc de ce temps-là pataugeait dans sa crise",
        "sur l'antique bahut il choisit sa cerise",
        "le chauffeur indigène attendait dans la brise",
        "une toge il portait qui n'était pas de mise",
        "il se penche et alors à sa grande surprise",
        "la découverte alors voilà qui traumatise",
        "la critique lucide aperçoit ce qu'il vise",
        "sur la place un forain de feu se gargarise",
        "des êtres indécis vous parlent sans franchise", //Vers 3 Fin
        "et fermentent de même et les cuirs et les peaux", // Vers 4 Début
        "il chantait tout de même oui mais il chantait faux",
        "il n'avait droit qu'à une et le jour des Rameaux",
        "elle soufflait bien fort par-dessus les côteaux",
        "des narcisses on cueille ou bien on est des veaux",
        "il ne trouve aussi sec qu'un sac de vieux fayots",
        "on espère toujours être de vrais normaux",
        "il donne à la tribu des cris aux sens nouveaux",
        "qui sait si le requin boulotte les turbots?",
        "et tout vient signifier la fin des haricots", // Vers 4 Fin
        "Je me souviens encor de cette heure exeuquise", // Vers 5 début
        "Le cheval Parthénon s'énerve sur sa frise",
        "Souvenez-vous amis de ces îles de Frise",
        "On était bien surpris par cette plaine grise",
        "Quand on prend des photos de cette tour de Pise",
        "Il déplore il déplore une telle mainmise",
        "Et pourtant c'était lui le frère de feintise",
        "L'un et l'autre a raison non la foule insoumise",
        "Du voisin Papou suçote l'apophyse",
        "On vous fait devenir une orde marchandise", // Vers 5 Fin
        "les gauchos dans la plaine agitaient leurs drapeaux", // Vers 6 Début 
        "du climat londonien où s'ébattent les beaux",
        "où venaient par milliers s'échouer les harenceaux",
        "quand se carbonisait la fureur des châteaux",
        "d'où Galilée jadis jeta ses petits pots",
        "qui se plaît à flouer de pauvres provinciaux",
        "qui clochard devenant jetait ses oripeaux",
        "le vulgaire s'entête à vouloir des vers beaux",
        "que n'a pas dévoré la horde des mulots?",
        "on prépare la route aux penseurs sépulcraux", // Vers 6 Fin
        "nous avions aussi froid que nus sur la banquise", // Vers 7 Début
        "il grelottait le pauvre au bord de la Tamise",
        "nous regrettions un peu ce tas de marchandise",
        "un audacieux baron empoche toute accise",
        "d'un étrusque inscription la pierre était incise",
        "aller à la grande ville est bien une entreprise",
        "un frère même bas est la part indécise",
        "l'un et l'autre ont raison non la foule imprécise",
        "le gourmet en salade avale la cytise",
        "de la mort on vous greffe une orde bâtardise", // Vers 7 Fin
        "lorsque pour nous distraire y plantions nos tréteaux", // Vers 8 Début 
        "quand les grêlons fin de mars mitraillent les bateaux",
        "lorsqu'on voyait au loin flamber les arbrisseaux",
        "lorsque vient le pompier avec ses grandes eaux",
        "les Grecs et les Romains en vain cherchent leurs mots",
        "elle effraie le Berry comme les Morvandiaux",
        "que les parents féconds offrent aux purs berceaux",
        "à tous n'est pas donné d'aimer les chocs verbaux",
        "l'enfant pur aux yeux bleus aime les berlingots",
        "la mite a grignoté tissus os et rideaux", // Vers 8 Fin
        "Du pôle à Rosario fait une belle trotte", // Vers 9 Début 
        "La Grèce de Platon à coup sûr n'est point sotte",
        "On sèche le poisson dorade ou molve lotte",
        "Du Gange au Malabar le lord anglais zozotte",
        "L'esprit souffle et resouffle au-dessus de la botte",
        "Devant la boue urbaine on retrousse sa cotte",
        "Le généalogiste observe leur bouillotte",
        "Le poète inspiré n'est point un polyglotte",
        "Le loup est amateur de coq et de cocotte",
        "Le brave a beau crier ah cré nom saperloppe", // Vers 9 Fin
        "aventures on eut qui s'y pique s'y frotte", // Vers 10 Début
        "on comptait les esprits acérés à la hotte",
        "on sale le requin on fume à l'échalotte",
        "comme à Chandernagor le manant sent la crotte",
        "le touriste à Florence ignoble charibotte",
        "on gifle le marmot qui plonge sa menotte",
        "gratter le parchemin deviendra sa marotte",
        "une langue suffit pour emplir sa cagnotte",
        "le chat fait un festin de têtes de linotte",
        "le lâche peut arguer de sa mine pâlotte", // Vers 10 Fin
        "lorsqu'on boit du maté l'on devient argentin", // Vers 11 Début
        "lorsque Socrate mort passait pour un lutin",
        "lorsqu'on revient au port en essuyant un grain",
        "le colonel s'éponge un blason dans la main",
        "l'autocar écrabouille un peu d'esprit latin",
        "lorsqu'il voit la gadoue il cherche le purin",
        "il voudra retrouver le germe adultérin",
        "même s'il prend son sel au celte c'est son bien",
        "le chemin vicinal se nourrit de crotin",
        "les croque-morts sont là pour se mettre au turbin", // Vers 11 Fin
        "L'Amérique du Sud séduit les équivoques", // Vers 12 Début
        "Sa sculpture est illustre et dans le fond des coques",
        "Enfin on vend le tout homards et salicoques",
        "Ne fallait pas si loin agiter ses breloques",
        "Les rapports transalpins sont-ils biunivoques?",
        "On regrette à la fin les agrestes bicoques",
        "Frère je te comprends si parfois tu débloques",
        "Barde que tu me plais toujours tu soliloques",
        "On a bu du pinard à toutes les époques",
        "Cela considérant ô lecteur tu suffoques", // Vers 12 Fin
        "exaltent l'espagnol les oreilles baroques", // Vers 13 Début
        "on transporte et le marbre et débris et défroques",
        "on s'excuse il n'y a ni baleines ni phoques",
        "les Indes ont assez sans ça de pendeloques",
        "les banquiers d'Avignon changent-ils les baïoques?",
        "on mettait sans façon ses plus infectes loques",
        "frère je t'absoudrai si tu m'emberlucoques",
        "tu me stupéfies plus que tous les ventriloques",
        "grignoter des bretzels distrait bien des colloques",
        "comptant tes abattis lecteur tu te disloques", // Vers 13 Fin
        "si la cloche se tait et son terlintintin", // Vers 14 Début
        "si l'Europe le veut l'Europe ou son destin",
        "le mammifère est roi nous sommes son cousin",
        "l'écu de vair ou d'or ne dure qu'un matin",
        "le Beaune et le Chianti sont-ils le même vin?",
        "mais on n'aurait pas vu le métropolitain",
        "la gémellité vraie accuse son destin",
        "le métromane à force incarne le devin",
        "mais rien ne vaut grillé le morceau de boudin",
        "toute chose pourtant doit avoir une fin", // Vers 14 Fin
    
    };
    

    static String[] obtenirSonnetAleatoire(String[] poemes, ArrayList<String> versUtilises) {
        Random rand = new Random();
        String[] sonnet = new String[14];
        for (int i = 0; i < 14; i++) {
            int debut;
            if (i < 8) { // Quatrains
                debut = (i / 4) * 10;
            } else { // Tercets
                debut = 8 + ((i - 8) / 3) * 10;
            }
            int indexAleatoire = debut + rand.nextInt(10);
            
            while (estDansSonnet(sonnet, poemes[indexAleatoire]) || estDansSonnet(versUtilises, poemes[indexAleatoire])) {
                indexAleatoire = debut + rand.nextInt(10);
            }
            
            sonnet[i] = poemes[indexAleatoire];
            String vers = poemes[indexAleatoire];
            versUtilises.add(vers);
        }
        return sonnet;
    }

    static boolean estDansSonnet(String[] sonnet, String vers) {
        for (String s : sonnet) {
            if (vers.equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    static boolean estDansSonnet(ArrayList<String> versUtilises, String vers) {
        return versUtilises.contains(vers);
    }

    static void afficherSonnet(String[] sonnet, int numeroPoeme) {
        int compteurVers = 0;
        System.out.println("Poeme de Raymond Queneau " + numeroPoeme + "\n");
        for (String vers : sonnet) {
            System.out.println(vers);
            compteurVers++;
            if ((compteurVers == 4 || compteurVers == 8) || (compteurVers == 11 || compteurVers == 14)) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> versUtilises = new ArrayList<>();
        String[] sonnet1 = obtenirSonnetAleatoire(poemes, versUtilises);
        afficherSonnet(sonnet1, 1);
        
        String[] sonnet2 = obtenirSonnetAleatoire(poemes, versUtilises);
        afficherSonnet(sonnet2, 2);
    }
}
