package parte2.ticket;

public class Decrementador extends Thread {

	private Compartido c;
	private int N;
	private int i; //Numero de proceso

	public Decrementador(Compartido c, int N, int i) {
		this.c = c;
		this.N = N;
		this.i = i;
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