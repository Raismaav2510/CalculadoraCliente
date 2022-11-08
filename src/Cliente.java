import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname","192.168.1.112");
            Registry registry = LocateRegistry.getRegistry("192.168.1.112", 8080);
            Operaciones operaciones = (Operaciones) registry.lookup("calculadora");
            Interfaz interfaz = new Interfaz(operaciones);
            interfaz.setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
