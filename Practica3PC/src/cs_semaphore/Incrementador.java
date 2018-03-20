package cs_semaphore;

public class Incrementador extends Thread {

	private Compartido c;
	private int N; // Numero de decrementos
	private int numProceso; // Numero de proceso

	public Incrementador(Compartido c, int N, int numProceso) {
		this.c = c;
		this.N = N;
		this.numProceso = numProceso;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; ++i) {
			try {
				c.mutex.acquire();
				c.num = c.num + 1;
				c.mutex.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}