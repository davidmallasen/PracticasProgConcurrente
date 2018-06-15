package parte2.mensajes;

import java.net.InetAddress;

public class MPedirFichero extends Mensaje {

    private String nombreFichero;

    public MPedirFichero(InetAddress origen, InetAddress destino, String nombreFichero) {
        super(TipoMensaje.PEDIR_FICHERO, origen, destino);
        this.nombreFichero = nombreFichero;
    }

    public String getNombreFichero() {
        return this.nombreFichero;
    }
}
