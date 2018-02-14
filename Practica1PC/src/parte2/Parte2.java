package parte2;

public class Parte2 {
	// Numero de decrementos o incrementos por cada thread
	private static int N = 100;
	// Numero de threads
	private static int M = 100;

	public static void main(String[] args) throws InterruptedException {
		Incrementador[] incrementadores = new Incrementador[M];
		Decrementador[] decrementadores = new Decrementador[M];
		
		IntCompartido n = new IntCompartido();
		
		for(int i = 0; i < M; ++i) {
			incrementadores[i] = new Incrementador(n, N);
			decrementadores[i] = new Decrementador(n, N);
			
			incrementadores[i].start();
			decrementadores[i].start();
		}
		
		for(int i = 0; i < M; ++i) {
			incrementadores[i].join();
			decrementadores[i].join();
		}
		
		System.out.println(n.getN());
	}
}
