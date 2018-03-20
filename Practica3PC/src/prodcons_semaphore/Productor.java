package prodcons_semaphore;

public class Productor extends Thread {

	private Compartido c;
	private int N; // Numero de elementos a producir

	public Productor(Compartido c, int N) {
		this.c = c;
		this.N = N;
	}
	
	@Override
    public void run() {
		for(int i = 0; i < N; ++i) {
			//Crea un producto y lo hace llegar a uno de los consumidores
		}
    }

}
