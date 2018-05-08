package parte1;

public class Main {
    public static int N_PUERTO = 9090;

    public static void main(String[] args) throws Exception {
        Servidor servidor = new Servidor();
        Cliente cliente = new Cliente();

        servidor.start();
        cliente.start();
        servidor.join();
        cliente.join();
    }
}
