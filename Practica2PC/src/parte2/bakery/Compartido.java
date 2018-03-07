package parte2.bakery;

public class Compartido {
    public int num;
    public int numThreads;

    //turn[i] = turno que tiene asignado el proceso i
    public volatile int[] turn;


    public Compartido(int numThreads) {
        this.numThreads = numThreads;
        this.num = 0;

        this.turn = new int[numThreads + 1]; // Usamos las posiciones 1..2M

        for (int i = 1; i <= numThreads; ++i) {
            turn[i] = 0;
        }
    }

    public static boolean miMayor(int a, int b, int c, int d) {
        return a > c || (a == c && b > d);
    }

    //Calcula el mayor de turn[i] con 1 <= i <= numThreads
    public int turnMax() {
        int max = turn[1];
        for (int i = 2; i <= numThreads; ++i) {
            if (turn[i] > max) {
                max = turn[i];
            }
        }
        return max;
    }
}