import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.Scanner;  
public class Client { 
   private Client() {} 
   
   public static void main(String[] args) {  
      try {  
         // Récupérer le registre
         Registry reg = LocateRegistry.getRegistry(null); 
    
         // Recherche dans le registre de l'objet distant
         Alphabet stub = (Alphabet) reg.lookup("Alphabet"); 
       
         try (// Appel de la méthode distante à l'aide de l'objet obtenu
            Scanner scan = new Scanner(System.in)) {

            System.out.print("Entrez la première lettre: ");
            String lettre1 = scan.nextLine();
            
            System.out.print("Entrez la deuxième lettre: ");
            String lettre2 = scan.nextLine();
               
            System.out.print("Entrez la troisième lettre: ");
            String lettre3 = scan.nextLine();

            System.out.print("Entrez la taille de la chaine de caractère souhaitez: ");
            int taille = scan.nextInt();

            // On récupère les informations retourner par le serveur
            StringBuilder reponse = stub.generation_chaine(lettre1, lettre2, lettre3, taille);
            System.out.println("La chaine obtenue est la suivante : " + reponse);
         } 
         
      } catch (Exception e) {
         System.err.println(e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
