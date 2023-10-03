import java.rmi.RemoteException;
import java.util.Random;

public class ImpAlph implements Alphabet{

    StringBuilder chaine;

    @Override
    // Méthode principal que le serveur va exécuter quand il va recevoir l'objet 'Alphabet' venant du client
    public StringBuilder generation_chaine(String lettre1, String lettre2, String lettre3, int taille) throws RemoteException {
        chaine = new StringBuilder(taille);
        
        // La méthode aleatoire va se charger d'effectuer la generation de la chaine
        chaine = aleatoire(lettre1, lettre2, lettre3, taille);
        return chaine;
    }

    // Méthode qui va permettre de vérifier s'il existe des sous chaînes identiques au fur et a mesure que la chaine soit générée
    public static boolean verifierSousChainesIdentiques(String chaine) {
        int longueurChaine = chaine.length();

        for (int longueurSousChaine = 1; longueurSousChaine <= longueurChaine / 2; longueurSousChaine++) {
            for (int i = 0; i <= longueurChaine - 2 * longueurSousChaine; i++) {
                String sousChaine1 = chaine.substring(i, i + longueurSousChaine);
                String sousChaine2 = chaine.substring(i + longueurSousChaine, i + 2 * longueurSousChaine);

                if (sousChaine1.equals(sousChaine2)) {
                    return true; // Si une sous-chaîne identique est trouvée, retourne true
                }
            }
        }
        return false; // Aucune sous-chaîne identique trouvée
    }
    
    // Méthode qui vérifie qu'il n'y a pas de caractère identique côte à côte
    public static boolean verifCaractereIdentique(String chaine){
        int longeurChaine = chaine.length();
        if (chaine.charAt(longeurChaine-1) == chaine.charAt(longeurChaine-2)){
                return false; // Si il existe un caractère identique adjacent, retourne false
        }
        return true; // Aucun caractère adjacent identique

}
    // Méthode qui va générer la chaine en respectant les contraintes
    public StringBuilder aleatoire(String lettre1, String lettre2, String lettre3, int taille){
        Random random = new Random();

                // Chaine qui va contenir tous les sous ensembles différents
                StringBuilder chaine = new StringBuilder();

                String[] lettres = {lettre1, lettre2, lettre3};
                String lettre_choisit = lettres[random.nextInt(3)];
                chaine.append(lettre_choisit);
                int i;
                for(i=1; i<taille; i++){
                        lettre_choisit = lettres[random.nextInt(3)];
                        String chaine_passage = chaine + lettre_choisit;

                        // Tant qu'il y a des sous chaines adjacentes identiques ou qu'il y a un caractère adjacent identique on regénère une nouvelle lettre
                        while (verifierSousChainesIdentiques(chaine_passage) || !verifCaractereIdentique(chaine_passage)){
                                lettre_choisit = lettres[random.nextInt(3)];
                                chaine_passage = chaine + lettre_choisit;
                        }
                        chaine.append(lettre_choisit);
                }
                return chaine;
        }

    
    
}
