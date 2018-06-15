package parte2.servidor;

import java.net.InetAddress;
import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private InetAddress ip;
    private ArrayList<String> ficheros;

    public Usuario(String nombre, InetAddress ip, ArrayList<String> ficheros) {
        this.nombre = nombre;
        this.ip = ip;
        this.ficheros = ficheros;
    }

    public String getNombre() {
        return nombre;
    }

    public InetAddress getIp() {
        return ip;
    }

    public ArrayList<String> getFicheros() {
        return ficheros;
    }
}
