package parte2.mensajes;

public class MCerrarConexion extends Mensaje {

    public MCerrarConexion(String origen, String destino) {
        super(TipoMensaje.CERRAR_CONEXION, origen, destino);
    }
}
