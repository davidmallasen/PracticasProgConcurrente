package parte1;

public class Parte1 {
	private static int N = 10;
	private static int T = 500;

	public static void main(String[] args) throws InterruptedException {
		MiThread[] procesos = new MiThread[N];
		
		for(int i = 0; i < N; ++i) {
			procesos[i] = new MiThread(T);
			procesos[i].start();
		}
		for(int i = 0; i < N; ++i) {
			procesos[i].join();
		}
		System.out.println("Todos los threads han terminado.");
	}

}
