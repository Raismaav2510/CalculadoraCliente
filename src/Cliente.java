import javax.swing.*;
import java.net.InetAddress;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) throws Exception{
        try {
            String ipLocal = JOptionPane.showInputDialog("Ingresa la dirección IP de este equipo");
            String ipServidor = JOptionPane.showInputDialog("Ingresa la dirección IP del servidor");
            System.setProperty("java.rmi.server.hostname", ipLocal);
            Registry registry = LocateRegistry.getRegistry(ipServidor, 8080);
            Operaciones operaciones = (Operaciones) registry.lookup("calculadora");
            Interfaz interfaz = new Interfaz(operaciones);
            interfaz.setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
