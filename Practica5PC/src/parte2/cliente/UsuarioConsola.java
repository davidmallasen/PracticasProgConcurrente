package parte2.cliente;

import java.io.ObjectOutputStream;
import java.util.Scanner;

public class UsuarioConsola extends Thread {

    private ObjectOutputStream fout;

    private Scanner sc;

    public UsuarioConsola(ObjectOutputStream fout, Scanner sc) {
        this.fout = fout;
        this.sc = sc;
    }

    @Override
    public void run() {
    }
}
