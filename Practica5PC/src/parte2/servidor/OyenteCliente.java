package parte2.servidor;

import parte2.mensajes.MConfConexion;
import parte2.mensajes.Mensaje;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class OyenteCliente extends Thread {
    private Socket s;
    private ObjectInputStream fin;
    private ObjectOutputStream fout;

    public OyenteCliente(Socket s) {
        try {
            this.s = s;
            this.fin = new ObjectInputStream(s.getInputStream());
            this.fout = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Mensaje msj;
        while (true) {
            try {
                msj = (Mensaje) fin.readObject();
                switch (msj.getTipo()) {
                    case CONEXION:
                        Servidor.addUsuario(new Usuario(msj.getNombre(),
                                msj.getOrigen(), msj.getFicheros()));
                        fout.writeObject(new MConfConexion(s.getInetAddress(),
                                msj.getOrigen()));
                        break;
                    case LISTA_USUARIOS:
                        ArrayList<String> nombres = Servidor
                                .getNombresUsuario();
                        break;
                    case PEDIR_FICHERO:
                        break;
                    case PREPARADO_CLIENTE_SERVIDOR:
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } catch (OperationNotSupportedException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
