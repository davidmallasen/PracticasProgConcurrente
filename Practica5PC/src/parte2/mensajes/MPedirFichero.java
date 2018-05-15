package parte2.mensajes;

public class MPedirFichero extends Mensaje {

    private String nombreFichero;

    public MPedirFichero(String origen, String destino, String nombreFichero) {
        super(TipoMensaje.PEDIR_FICHERO, origen, destino);
        this.nombreFichero = nombreFichero;
    }

    public String getNombreFichero() {
        return this.nombreFichero;
    }
}
