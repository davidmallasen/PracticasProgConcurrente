package parte2.bakery;

public class Decrementador extends Thread {

    private Compartido c;
    private int N; // Numero de decrementos
    private int numProceso; // Numero de proceso

    public Decrementador(Compartido c, int N, int numProceso) {
        this.c = c;
        this.N = N;
        this.numProceso = numProceso;
    }

    @Override
    public void run() {
        for (int i = 0; i < N; ++i) {

            // Protocolo de entrada
            c.turn[numProceso] = 1;
            c.turn[numProceso] = c.turnMax() + 1;
            for (int j = 1; j <= c.numThreads; ++j) {
                if (j != numProceso) {
                    while (c.turn[j] != 0 &&
                            Compartido.miMayor(c.turn[numProceso], numProceso, c.turn[j], j))
                        ;
                }
            }

            // Seccion critica
            c.num = c.num - 1;

            // Protocolo de salida
            c.turn[numProceso] = 0;
        }
    }
}