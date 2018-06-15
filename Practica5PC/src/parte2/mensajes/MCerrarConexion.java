package parte2.mensajes;

import java.net.InetAddress;

public class MCerrarConexion extends Mensaje {

    public MCerrarConexion(InetAddress origen, InetAddress destino) {
        super(TipoMensaje.CERRAR_CONEXION, origen, destino);
    }
}
