package multiBuffer.sync;

public class Productor extends Thread {

	private MonitorProdCons monitor;
	private int N; // Numero de elementos a producir
	private int M; // Numero de elementos a producir cada vez

	public Productor(MonitorProdCons monitor, int N, int M) {
		this.monitor = monitor;
		this.N = N;
		this.M = M;
	}

	@Override
	public void run() {
		for (int i = 0; i < N / M; ++i) {
			monitor.almacenar(new Producto[M], M);
		}
	}

}
