package prodcons_semaphore;

public class Main {

    /**
     * Numero de productores
     */
    public static final int N_PRODS = 5;

    public static final int N_CONS = 10;

    /**
     * Numero de elementos a producir/consumir en total
     */
    public static final int N_ELEM = 10000;

    /**
     * Tamanyo del buffer de Producto
     */
    public static final int TAM_BUFFER = 5;


    public static void main(String[] args) {
        Productor[] productores = new Productor[N_PRODS];
        Consumidor[] consumidores = new Consumidor[N_CONS];

        Compartido c = new Compartido(N_PRODS + N_CONS, TAM_BUFFER);

        for (int i = 0; i < N_PRODS; ++i) {
            productores[i] = new Productor(c, N_ELEM / N_PRODS);
        }
        for (int i = 0; i < N_CONS; ++i) {
            consumidores[i] = new Consumidor(c, N_ELEM / N_CONS);
        }

        for (int i = 0; i < N_PRODS; ++i) {
            productores[i].start();
        }
        for (int i = 0; i < N_CONS; ++i) {
            consumidores[i].start();
        }

        for (int i = 0; i < N_PRODS; ++i) {
            try {
                productores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < N_CONS; ++i) {
            try {
                consumidores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
