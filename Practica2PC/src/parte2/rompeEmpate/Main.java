package parte2.rompeEmpate;

public class Main {
	// Numero de decrementos o incrementos por cada thread
	private static int N = 1000;
	// Numero de threads de cada tipo
	private static int M = 10;

	public static void main(String[] args) throws InterruptedException {
		Incrementador[] incrementadores = new Incrementador[M];
		Decrementador[] decrementadores = new Decrementador[M];

		Compartido c = new Compartido(2 * M);

		for (int i = 0; i < M; ++i) {
			// 1, 3, 5, ..., 2M - 1
			incrementadores[i] = new Incrementador(c, N, (2 * i) + 1);

			// 2, 4, 6, ..., 2M
			decrementadores[i] = new Decrementador(c, N, (2 * i) + 2);
		}
		
		for (int i = 0; i < M; ++i) {
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
