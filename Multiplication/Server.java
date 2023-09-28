import java.rmi.RemoteException; 
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 
public class Server extends ImpMult { 
   public Server() {} 
   
   public static void main(String args[]) { 
      try { 
         // crée l'objet distant
         ImpMult obj = new ImpMult(); 
         // ici, nous exportons l'objet distant vers le stub
         Multiplication stub = (Multiplication) UnicastRemoteObject.exportObject(obj, 0);  
         // Liaison de l'objet distant (stub) dans le Registre
         Registry reg = LocateRegistry.getRegistry(); 
         reg.bind("Multiplier", stub);  
         System.out.println("Le Serveur est prêt..."); 
      } catch (Exception e) { 
         System.err.println(e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}

