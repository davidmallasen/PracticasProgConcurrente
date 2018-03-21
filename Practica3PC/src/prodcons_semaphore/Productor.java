package prodcons_semaphore;

public class Productor extends Thread {

    private Compartido c;
    private int N; // Numero de elementos a producir

    public Productor(Compartido c, int N) {
        this.c = c;
        this.N = N;
    }

    @Override
    public void run() {
        for (int i = 0; i < N; ++i) {
            try {
                c.empty.acquire();
                c.mutexP.acquire();
                c.buffer.almacenar(new Producto());
                c.mutexP.release();
                c.full.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
