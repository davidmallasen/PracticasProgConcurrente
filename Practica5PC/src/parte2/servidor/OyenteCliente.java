package parte2.servidor;

import parte2.mensajes.Mensaje;

import java.io.*;
import java.net.Socket;

public class OyenteCliente extends Thread{
    private Socket s;
    private ObjectInputStream fin;

    public OyenteCliente(Socket s) {
        try {
            this.s = s;
            this.fin = new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Mensaje msj;
        while(true) {
            try {
                msj = (Mensaje) fin.readObject();
                switch (msj.getTipo()) {
                    case CONEXION:
                        break;
                    case LISTA_USUARIOS:
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
            }
        }
    }
}
