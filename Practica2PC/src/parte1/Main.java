package parte1;

public class Main {
	// Numero de decrementos o incrementos por cada thread
	private static int N = 10000;
	
	public static void main(String[] args) throws InterruptedException {
		Incrementador incrementador;
		Decrementador decrementador;

		Compartido c = new Compartido();
		
		incrementador = new Incrementador(c, N);
		decrementador = new Decrementador(c, N);

		incrementador.start();
		decrementador.start();

		incrementador.join();
		decrementador.join();

		System.out.println(c.num);
	}
}
