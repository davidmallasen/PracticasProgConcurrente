package parte2.cliente;

import parte2.mensajes.MCerrarConexion;
import parte2.mensajes.MConexion;
import parte2.mensajes.MListaUsuarios;
import parte2.mensajes.MPedirFichero;
import parte2.servidor.Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Thread {

    /**
     * Nombre de usuario
     */
    private String nombre;

    /**
     * Direccion ip de la maquina
     */
    private InetAddress ip;

    /**
     * Ficheros que proporciona el usuario
     */
    private ArrayList<String> ficheros;

    // Comunicacion con el servidor
    private Socket s;
    private ObjectOutputStream fout;

    //Comunicacion con el usuario
    private Scanner sc;

    public Cliente(InetAddress ip) {
        try {
            this.ip = ip;
            this.sc = new Scanner(System.in);
            this.ficheros = new ArrayList<>();
            this.s = new Socket(ip, Servidor.PUERTO_SERVIDOR);
            this.fout = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String seguir;
        System.out.println("==============================");
        System.out.println("Introduzca el nombre de usuario: ");
        nombre = sc.nextLine();
        do {
            System.out.println("Introduzca un nombre de fichero: ");
            ficheros.add(sc.nextLine());
            System.out.println("Quiere introducir otro fichero? (s/n): ");
            seguir = sc.nextLine();
        } while (!seguir.equals("n"));
        System.out.println("==============================\n");

        (new OyenteServidor(s)).start();

        try {
            fout.writeObject(new MConexion(nombre, "servidor", nombre, ficheros));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int opcion;
        System.out.println("==============================");
        do {
            System.out.println("1 - Recibir la lista de usuarios conectados.");
            System.out.println("2 - Descargar fichero.");
            System.out.println("0 - Salir.");
            System.out.println("Introduzca una opcion: ");
            opcion = sc.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        fout.writeObject(new MListaUsuarios(nombre, "servidor"));
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre del fichero: ");
                        String nFich = sc.nextLine();
                        fout.writeObject(new MPedirFichero(nombre,
                                "servidor", nFich));
                        break;
                    case 0:
                        fout.writeObject(new MCerrarConexion(nombre, "servidor"));
                        s.close();
                        fout.close();
                        sc.close();
                        System.out.println("Conexion con el servidor cerrada.");
                        break;
                    default:
                        System.out.println("Error. Opcion no reconocida.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    s.close();
                    fout.close();
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("==============================");
        } while (opcion != 0);
    }
}
