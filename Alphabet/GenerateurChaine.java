import java.util.Random;

public class GenerateurChaine {

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Veuillez fournir 4 arguments : 3 lettres distinctes et un numéro de taille.");
            return;
        }

        String lettre1 = args[0];
        String lettre2 = args[1];
        String lettre3 = args[2];
        int taille = Integer.parseInt(args[3]);

        if (lettre1.length() != 1 || lettre2.length() != 1 || lettre3.length() != 1) {
            System.out.println("Les trois premiers arguments doivent être des lettres distinctes.");
            return;
        }

        if (lettre1.equals(lettre2) || lettre1.equals(lettre3) || lettre2.equals(lettre3)) {
            System.out.println("Les trois premiers arguments doivent être des lettres distinctes.");
            return;
        }

        Random random = new Random();
        StringBuilder chaine = new StringBuilder();

        // Créer un tableau de lettres pour faciliter la sélection aléatoire
        String[] lettres = {lettre1, lettre2, lettre3};
        
        String derniereLettre = "";
        String avantDerniereLettre = "";

        for (int i = 0; i < taille; i++) {
            String lettre;
            
            // Tant que la lettre choisie est la même que la précédente ou celle d'avant, en choisir une autre
            do {
                lettre = lettres[random.nextInt(3)];
            } while (lettre.equals(derniereLettre) && lettre.equals(avantDerniereLettre));

            chaine.append(lettre);

            avantDerniereLettre = derniereLettre;
            derniereLettre = lettre;
        }

        System.out.println("Chaine générée : " + chaine.toString());
    }
}
