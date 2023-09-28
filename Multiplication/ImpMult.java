import java.rmi.RemoteException;

public class ImpMult implements Multiplication{

    @Override
    public int multiplication_a_b(int a, int b) throws RemoteException {
        int resultat = a * b;
        //System.out.println("Le résulat de " + a + " x " + b + " = " + resultat);
        return resultat;

    }
    
}
