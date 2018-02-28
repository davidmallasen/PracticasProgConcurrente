package parte1;

public class Decrementador extends Thread {

	private Compartido c;
	private int N;

	public Decrementador(Compartido c, int N) {
		this.c = c;
		this.N = N;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; ++i) {
			c.in2 = true; // Protocolo de entrada
			c.last = 2;
			while (c.in1 && c.last == 2)
				;
			// Seccion critica
			c.num = c.num - 1;

			c.in2 = false; // Protocolo de salida
			// Fin seccion critica
		}
	}
}