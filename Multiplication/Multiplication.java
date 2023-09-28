import java.rmi.Remote;
import java.rmi.RemoteException; 

public interface Multiplication extends Remote{
    public int multiplication_a_b(int a, int b)throws RemoteException;
}
