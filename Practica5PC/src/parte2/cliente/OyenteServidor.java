package parte2.cliente;

import parte2.mensajes.Mensaje;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class OyenteServidor extends Thread {

    private Socket os;
    private ObjectInputStream fin;

    public OyenteServidor(Socket os) {
        try {
            this.os = os;
            fin = new ObjectInputStream(os.getInputStream());
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
                    case CONFIRMACION_CONEXION:
                        System.out.println("Conexion entre " + msj.getOrigen() +
                                " y " + msj.getDestino() + " establecida.");
                        break;
                    case CONFIRMACION_LISTA_USUARIOS:
                        ArrayList<String> listaUsuarios = msj.getListaUsuarios();
                        System.out.println("Lista de usuarios: ");
                        for (String s : listaUsuarios)
                            System.out.println(s);
                        break;
                    case EMITIR_FICHERO:
                        (new EmisorFichero(msj.getNombreFichero(),
                                msj.getPuerto())).start();
                        break;
                    case PREPARADO_SERVIDOR_CLIENTE:
                        (new ReceptorFichero(msj.getIpServidor(),
                                msj.getPuerto())).start();
                        break;
                    default:
                        throw new IllegalArgumentException(msj.getTipo().toString());
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
