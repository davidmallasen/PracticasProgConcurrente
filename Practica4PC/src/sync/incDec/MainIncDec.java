package sync.incDec;

public class MainIncDec {
	// Numero de decrementos o incrementos por cada thread
	private static int N = 1000;
	// Numero de threads de cada tipo
	private static int M = 10;

	public static void main(String[] args) throws InterruptedException {
		Incrementador[] incrementadores = new Incrementador[M];
		Decrementador[] decrementadores = new Decrementador[M];

		MonitorIncDec monitor = new MonitorIncDec();

		for (int i = 0; i < M; ++i) {
			incrementadores[i] = new Incrementador(monitor, N);
			decrementadores[i] = new Decrementador(monitor, N);
		}

		for (int i = 0; i < M; ++i) {
			incrementadores[i].start();
			decrementadores[i].start();
		}

		for (int i = 0; i < M; ++i) {
			incrementadores[i].join();
			decrementadores[i].join();
		}

		System.out.println(monitor.getS());
	}

}
