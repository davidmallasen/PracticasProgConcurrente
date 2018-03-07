package parte2.ticket;

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

            // Protocolo de entrada ticket

            // Protocolo de entrada rompeEmpate
            for (int j = 1; j <= c.numThreads; ++j) {
                // Recordar que el proceso i esta en la etapa j y es el ultimo
                c.in[numProceso] = j;
                c.in = c.in;
                c.last[j] = numProceso;
                c.last = c.last;
                for (int k = 1; k <= c.numThreads; ++k) {
                    if (numProceso != k) {
                        // Espera si el proceso k esta en una etapa posterior y
                        // el proceso i fue el ultimo en entrar a la etapa j
                        while (c.in[k] >= c.in[numProceso]
                                && c.last[j] == numProceso) ;
                    }
                }
            }

            // Seccion critica rompeEmpate
            c.turn[numProceso] = c.number;
            c.turn = c.turn;
            c.number++;

            // Protocolo de salida rompeEmpate
            c.in[numProceso] = 0;
            c.in = c.in;

            while (c.turn[numProceso] != c.next) ;

            // Seccion critica ticket
            c.num = c.num - 1;

            // Protocolo de salida ticket
            c.next++;
        }
    }
}