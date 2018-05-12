package parte2.mensajes;

import java.util.ArrayList;

public class MConexion extends Mensaje {

    private String nombre;

    private ArrayList<String> ficheros;

    public MConexion(String origen, String destino, String nombre,
                     ArrayList<String> ficheros) {
        super(TipoMensaje.CONEXION, origen, destino);
        this.nombre = nombre;
        this.ficheros = ficheros;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public ArrayList<String> getFicheros() {
        return ficheros;
    }
}
