package prodcons_semaphore;

import java.util.concurrent.Semaphore;

public class Compartido {
    public int numThreads;
    public Semaphore empty, full, mutexP, mutexC;
    public AlmacenTamN buffer;

    public Compartido(int numThreads, int tamBuffer) {
        this.numThreads = numThreads;
        this.empty = new Semaphore(tamBuffer);
        this.full = new Semaphore(0);
        this.mutexP = new Semaphore(1);
        this.mutexC = new Semaphore(1);
        this.buffer = new AlmacenTamN(tamBuffer);
    }
}