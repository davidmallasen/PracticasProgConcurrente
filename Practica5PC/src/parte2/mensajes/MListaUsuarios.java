package parte2.mensajes;

public class MListaUsuarios extends Mensaje {

    public MListaUsuarios(String origen, String destino) {
        super(TipoMensaje.LISTA_USUARIOS, origen, destino);
    }
}
