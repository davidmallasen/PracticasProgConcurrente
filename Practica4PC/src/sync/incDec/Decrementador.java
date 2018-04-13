package sync.incDec;

public class Decrementador extends Thread {

	private MonitorIncDec monitor;
	private int N; // Numero de decrementos

	public Decrementador(MonitorIncDec monitor, int N) {
		this.monitor = monitor;
		this.N = N;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; ++i) {
			monitor.dec();
		}
	}
}
