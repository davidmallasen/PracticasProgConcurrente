package multiBuffer.lockCond;

public class Consumidor extends Thread {

	private MonitorProdCons monitor;
	private int N; // Numero de elementos a consumir
	private int M; // Numero de elementos a consumir cada vez

	public Consumidor(MonitorProdCons monitor, int N, int M) {
		this.monitor = monitor;
		this.N = N;
		this.M = M;
	}

	@Override
	public void run() {
		for (int i = 0; i < N / M; ++i) {
			monitor.extraer(M);
		}
	}
}
