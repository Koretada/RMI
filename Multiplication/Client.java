import java.rmi.Remote;
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
         Multiplication stub = (Multiplication) reg.lookup("Multiplier"); 
       
         try (// Appel de la méthode distante à l'aide de l'objet obtenu
            Scanner scan = new Scanner(System.in)) {
            System.out.print("Entrez le premier nombre: ");
            // lire le 1er nombre
            int nbr1 = scan.nextInt();
            System.out.print("Entrez le deuxième nombre: ");
            int nbr2 = scan.nextInt();
            
            int reponse = stub.multiplication_a_b(nbr1,nbr2);
            System.out.println("Le résulat de " + nbr1 + " x " + nbr2 + " = " + reponse);
         } 
         
      } catch (Exception e) {
         System.err.println(e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
