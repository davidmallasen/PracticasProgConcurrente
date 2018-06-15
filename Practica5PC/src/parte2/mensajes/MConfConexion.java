package parte2.mensajes;

import java.net.InetAddress;

public class MConfConexion extends Mensaje {

    public MConfConexion(InetAddress origen, InetAddress destino) {
        super(TipoMensaje.CONFIRMACION_CONEXION, origen, destino);
    }
}
