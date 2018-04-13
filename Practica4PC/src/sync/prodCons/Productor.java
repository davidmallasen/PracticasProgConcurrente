package sync.prodCons;

public class Productor extends Thread {

	private MonitorProdCons monitor;
	private int N; // Numero de elementos a producir

	public Productor(MonitorProdCons monitor, int N) {
		this.monitor = monitor;
		this.N = N;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; ++i) {
			monitor.almacenar(new Producto());
		}
	}

}
