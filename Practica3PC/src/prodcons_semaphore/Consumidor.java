package prodcons_semaphore;

public class Consumidor extends Thread{
	private Compartido c;
	private int N; // Numero de elementos a consumir

	public Consumidor(Compartido c, int N) {
		this.c = c;
		this.N = N;
	}
	
	@Override
    public void run() {
		for(int i = 0; i < N; ++i) {
			//Recoger producto producido por un productor y consumirlo.
		}
    }
}
