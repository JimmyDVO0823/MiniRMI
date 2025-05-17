/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Invocador;
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
public class Invocador {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost",3232);
            IServer objetoRemoto = (IServer) reg.lookup("rmiserver");
            
            String saludo = objetoRemoto.darBienvenida("DFRANCO");
            System.out.println(saludo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
