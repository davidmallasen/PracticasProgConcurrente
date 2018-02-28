package parte2.rompeEmpate;

public class Compartido {
	public int num;
	public int numThreads;

	volatile int[] in; // in[i] = Numero de etapa en la que se encuentra el
						// proceso i; 0 indica etapa previa a la 1, antes de
						// empezar
	volatile int[] last; // last[i] = id del proceso que llego el ultimo a la
							// etapa i

	public Compartido(int numThreads) {
		this.numThreads = numThreads;
		num = 0;
		in = new int[numThreads + 1]; // Usamos las posiciones 1..2M
		last = new int[numThreads + 1];

		for (int i = 1; i <= numThreads; ++i) {
			in[i] = 0;
			last[i] = 0;
		}
	}
}