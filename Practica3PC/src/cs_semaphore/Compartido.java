package cs_semaphore;

import java.util.concurrent.Semaphore;

public class Compartido {
    public int num;
    public int numThreads;
    public Semaphore mutex;

    public Compartido(int numThreads) {
        this.numThreads = numThreads;
        this.num = 0;
        this.mutex = new Semaphore(1);
    }
}