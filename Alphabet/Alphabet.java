import java.rmi.Remote;
import java.rmi.RemoteException; 

public interface Alphabet extends Remote{
    public StringBuilder generation_chaine(String lettre1, String lettre2, String lettre3, int taille)throws RemoteException;
    //public StringBuilder aleatoire(String lettre1, String lettre2, String lettre3, int taille);
}
