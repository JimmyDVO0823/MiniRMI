/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.Server;

import Interface.IServer;
import java.net.InetAddress;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author LENOVO LOQ
 */
public class Server extends UnicastRemoteObject implements IServer {

    public Server() throws RemoteException {

    }

    public static void main(String[] args) throws Exception {
        Server s = new Server();
        s.iniciarServidor();
    }

    public void iniciarServidor() {
        try {
            int port = 3232;
            String dirIP = (InetAddress.getLocalHost().toString());
            System.out.println("Escuchando en " + dirIP + port);

            Registry reg = LocateRegistry.createRegistry(port);
            reg.bind("rmiserver", this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String darBienvenida(String nombre) throws RemoteException {
        System.out.println("Ejecutando el saludo");
        return "Hola " + nombre + ". Bienvenido!";
    }

    @Override
    public int calcularMayor(int i, int i1) throws RemoteException {
        System.out.println("Ejecutando el saludo");
        if (i > i1) {
            return i;
        } else {
            return i1;
        }
    }
}
