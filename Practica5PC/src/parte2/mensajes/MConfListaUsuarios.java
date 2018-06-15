package parte2.mensajes;

import javax.naming.OperationNotSupportedException;
import java.net.InetAddress;
import java.util.ArrayList;

public class MConfListaUsuarios extends Mensaje {

    private ArrayList<String> nombres;

    public MConfListaUsuarios(InetAddress origen, InetAddress destino,
                              ArrayList<String> nombres) {
        super(TipoMensaje.LISTA_USUARIOS, origen, destino);
        this.nombres = nombres;
    }

    @Override
    public ArrayList<String> getListaUsuarios() throws OperationNotSupportedException {
        return nombres;
    }
}
