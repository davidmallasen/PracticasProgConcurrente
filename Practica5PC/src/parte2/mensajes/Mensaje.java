package parte2.mensajes;

public abstract class Mensaje {

    private TipoMensaje tipo;
    private int origen;
    private int destino;

    public Mensaje(TipoMensaje tipo, int origen, int destino) {
        this.tipo = tipo;
        this.origen = origen;
        this.destino = destino;
    }

    public TipoMensaje getTipo() {
        return tipo;
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }
}
