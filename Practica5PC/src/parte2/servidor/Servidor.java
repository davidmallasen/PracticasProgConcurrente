package parte2.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor extends Thread {

    public static final int PUERTO_SERVIDOR = 9090;

    private ServerSocket l;

    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Servidor() {
        try {
            l = new ServerSocket(PUERTO_SERVIDOR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //LEER DE UN FICHERO USERS.TXT LA INFORMACION DE LOS USUARIOS
        // REGISTRADOS EN EL SISTEMA
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket s = l.accept();
                (new OyenteCliente(s)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected static void addUsuario(Usuario u) {
        //Hacer esto safe
        usuarios.add(u);
    }

    protected static ArrayList<String> getNombresUsuario() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Usuario u : usuarios) {
            nombres.add(u.getNombre());
        }
        return nombres;
    }

}
