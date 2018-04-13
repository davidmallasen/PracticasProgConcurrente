package sync.prodCons;

public class Consumidor extends Thread {

	private MonitorProdCons monitor;
	private int N; // Numero de elementos a consumir

	public Consumidor(MonitorProdCons monitor, int N) {
		this.monitor = monitor;
		this.N = N;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; ++i) {
			monitor.extraer();
		}
	}
}
