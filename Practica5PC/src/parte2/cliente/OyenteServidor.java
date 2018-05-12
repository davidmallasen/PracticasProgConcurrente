package parte2.cliente;

import parte2.mensajes.Mensaje;
import parte2.mensajes.TipoMensaje;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class OyenteServidor extends Thread {

    private Socket os;
    private ObjectInputStream fin;

    public OyenteServidor(InetAddress ip, int puerto) {
        try {
            os = new Socket(ip, puerto);
            fin = new ObjectInputStream(os.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run () {
        Mensaje msj;
        while(true) {
            try {
                msj = (Mensaje) fin.readObject();
                switch (msj.getTipo()) {
                    case CONFIRMACION_CONEXION:
                        break;
                    case CONFIRMACION_LISTA_USUARIOS:
                        break;
                    case EMITIR_FICHERO:
                        break;
                    case PREPARADO_SERVIDOR_CLIENTE:
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
