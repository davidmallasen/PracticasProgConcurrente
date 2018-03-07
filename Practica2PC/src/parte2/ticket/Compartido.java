package parte2.ticket;

public class Compartido {
    public int num;
    public int numThreads;

    public volatile int[] in; // in[i] = Numero de etapa en la que se
    // encuentra el proceso i; 0 indica etapa previa a la 1, antes de empezar
    public volatile int[] last; // last[i] = id del proceso que llego el ultimo
    // a la etapa i

    //Cual es el siguiente turno a coger
    public volatile int number;
    //Cual es el siguiente turno a atender
    public volatile int next;
    //turn[i] = turno que tiene asignado el proceso i
    public volatile int[] turn;


    public Compartido(int numThreads) {
        this.numThreads = numThreads;
        this.num = 0;
        this.in = new int[numThreads + 1]; // Usamos las posiciones 1..2M
        this.last = new int[numThreads + 1];

        this.number = 1;
        this.next = 1;
        this.turn = new int[numThreads + 1]; // Usamos las posiciones 1..2M

        for (int i = 1; i <= numThreads; ++i) {
            in[i] = 0;
            last[i] = 0;
            turn[i] = 0;
        }
    }
}