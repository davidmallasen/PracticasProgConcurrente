package parte2.mensajes;

import java.net.InetAddress;

public class MListaUsuarios extends Mensaje {

    public MListaUsuarios(InetAddress origen, InetAddress destino) {
        super(TipoMensaje.LISTA_USUARIOS, origen, destino);
    }
}
