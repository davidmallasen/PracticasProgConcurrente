package parte2.bakery;

public class Incrementador extends Thread {

	private Compartido c;
	private int N;
	private int i;	//Numero de proceso

	public Incrementador(Compartido c, int N, int i) {
		this.c = c;
		this.N = N;
		this.i = i;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; ++i) {
			c.in1 = true; // Protocolo de entrada
			c.last = 1;
			while (c.in2 && c.last == 1)
				;
			// Seccion critica
			c.num = c.num + 1;

			c.in1 = false; // Protocolo de salida
			// Fin seccion critica
		}
	}
}