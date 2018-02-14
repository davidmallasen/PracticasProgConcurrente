package parte2;

public class Decrementador extends Thread {
	
	private IntCompartido n;
	private int N;
	
	public Decrementador(IntCompartido n, int N) {
		this.n = n;
		this.N = N;
	}

	@Override
	public void run() {
		for(int i = 0; i < N; ++i)
			n.setN(n.getN() - 1);
	}
}
