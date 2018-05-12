package parte2.servidor;

import java.net.InetAddress;
import java.util.ArrayList;

public class Usuario {

    private int idUsuario;
    private InetAddress ip;
    private ArrayList<String> ficheros;

    public Usuario(int idUsuario, InetAddress ip, ArrayList<String> ficheros) {
        this.idUsuario = idUsuario;
        this.ip = ip;
        this.ficheros = ficheros;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public InetAddress getIp() {
        return ip;
    }

    public ArrayList<String> getFicheros() {
        return ficheros;
    }
}
