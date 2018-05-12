package parte2.cliente;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

    /**
     * Nombre de usuario
     */
    private String nombre;

    /**
     * Direccion ip de la maquina
     */
    private InetAddress ip;

    private Socket s;
    private BufferedReader fin;
    private PrintWriter fout;

    public Cliente(String nombre, InetAddress ip) {
        this.nombre = nombre;
        this.ip = ip;
    }
}
