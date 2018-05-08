package parte1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente extends Thread {

    @Override
    public void run() {
        try {
            Socket sb = new Socket(InetAddress.getLocalHost(), Main.N_PUERTO);
            BufferedReader fin = new BufferedReader(new InputStreamReader(sb
                    .getInputStream()));
            PrintWriter fout = new PrintWriter(sb.getOutputStream());

            fout.println("prueba.txt");
            fout.flush();
            String contenido = fin.readLine();
            System.out.println(contenido);

            sb.close();
            fin.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
