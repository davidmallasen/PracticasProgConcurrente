package multiBuffer.sync;

public class AlmacenTamN implements Almacen {

	/**
	 * Buffer de Productos de tamanyo tam, implementado como array circular
	 */
	private Producto[] buf;

	/**
	 * Tamanyo maximo del buffer
	 */
	private int tam;

	/**
	 * Indice donde extraer
	 */
	private int front;

	/**
	 * Indice donde insertar
	 */
	private int rear;

	/**
	 * Numero de elementos que han sido insertados
	 */
	private int numInsert;

	/**
	 * Numero de elementos que han sido extraidos
	 */
	private int numExtr;

	public AlmacenTamN(int tam) {
		this.buf = new Producto[tam];
		this.tam = tam;
		this.front = 0;
		this.rear = 0;
		this.numInsert = 0;
		this.numExtr = 0;
	}

	@Override
	public void almacenar(Producto producto) {
		if (numInsert - numExtr < tam) { // Hay hueco //Comprobaciones redundantes para ver que lo hacemos bien
			buf[rear] = producto;
			numInsert++;
			rear = (rear + 1) % tam;
		} else {
			System.out.println("Error al almacenar!");
		}
	}

	@Override
	public Producto extraer() {
		Producto aux = null;
		if (numInsert > numExtr) { // Hay algun elemento //Comprobaciones redundantes para ver que lo hacemos bien
			aux = buf[front];
			numExtr++;
			front = (front + 1) % tam;
		} else {
			System.out.println("Error al extraer!");
		}
		return aux;
	}
}
