package sync.incDec;

public class Incrementador extends Thread {

	private MonitorIncDec monitor;
	private int N; // Numero de decrementos

	public Incrementador(MonitorIncDec monitor, int N) {
		this.monitor = monitor;
		this.N = N;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; ++i) {
			monitor.inc();
		}
	}
}
