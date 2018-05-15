package parte2.mensajes;

import javax.naming.OperationNotSupportedException;
import java.net.InetAddress;
import java.util.ArrayList;

public abstract class Mensaje {

    private TipoMensaje tipo;
    private String origen;
    private String destino;

    public Mensaje(TipoMensaje tipo, String origen, String destino) {
        this.tipo = tipo;
        this.origen = origen;
        this.destino = destino;
    }

    public TipoMensaje getTipo() {
        return tipo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getNombre() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("getNombre");
    }

    public ArrayList<String> getFicheros() throws
            OperationNotSupportedException {
        throw new OperationNotSupportedException("getFicheros");
    }

    public String getNombreFichero() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("getNombreFichero");
    }

    public ArrayList<String> getListaUsuarios() throws
            OperationNotSupportedException {
        throw new OperationNotSupportedException("getListaUsuarios");
    }

    public int getPuerto() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("getPuerto");
    }

    public InetAddress getIpServidor() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("getIpServidor");
    }
}
