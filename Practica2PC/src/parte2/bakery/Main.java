package parte2.bakery;

public class Main {
	// Numero de decrementos o incrementos por cada thread
	private static int N = 100;
	// Numero de threads
	private static int M = 100;

	public static void main(String[] args) throws InterruptedException {
		Incrementador[] incrementadores = new Incrementador[M];
		Decrementador[] decrementadores = new Decrementador[M];

		Compartido c = new Compartido();

		for (int i = 0; i < M; ++i) {
			incrementadores[i] = new Incrementador(c, N, (2 * i) + 1);	//1, 3, 5, ..., 2M - 1
			decrementadores[i] = new Decrementador(c, N, (2 * i) + 2);	//2, 4, 6, ..., 2M

			incrementadores[i].start();
			decrementadores[i].start();
		}

		for (int i = 0; i < M; ++i) {
			incrementadores[i].join();
			decrementadores[i].join();
		}

		System.out.println(c.num);
	}
}
