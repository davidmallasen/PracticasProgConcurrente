package parte1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket l = new ServerSocket(Main.N_PUERTO);
            Socket sa = l.accept();
            BufferedReader fin = new BufferedReader(new InputStreamReader(sa
                    .getInputStream()));
            PrintWriter fout = new PrintWriter(sa.getOutputStream());

            String nombreFichero = fin.readLine();
            fout.println(nombreFichero);
            fout.flush();

            l.close();
            sa.close();
            fin.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
