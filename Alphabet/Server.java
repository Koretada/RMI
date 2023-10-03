import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 
public class Server extends ImpAlph { 
   public Server() {} 
   
   public static void main(String args[]) { 
      try { 
         // crée l'objet distant
         ImpAlph obj = new ImpAlph(); 
         
         // ici, nous exportons l'objet distant vers le stub
         Alphabet stub = (Alphabet) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Liaison de l'objet distant (stub) dans le Registre
         Registry reg = LocateRegistry.getRegistry(); 
         
         //reg.bind("Multiplier", stub);
         reg.rebind("Alphabet", stub);
         System.out.println("Le Serveur est prêt..."); 
         
      } catch (Exception e) { 
         System.err.println(e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
