package parte2.mensajes;

public class MConexion extends Mensaje{
    public MConexion(int origen, int destino) {
        super(TipoMensaje.CONEXION, origen, destino);
    }
}
