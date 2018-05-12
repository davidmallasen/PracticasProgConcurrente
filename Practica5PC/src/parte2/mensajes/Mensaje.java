package parte2.mensajes;

import javax.naming.OperationNotSupportedException;
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
        throw new OperationNotSupportedException();
    }

    public ArrayList<String> getFicheros() throws
            OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
