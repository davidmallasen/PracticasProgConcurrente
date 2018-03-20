package prodcons_semaphore;

public class AlmacenTam1 implements Almacen {

	private Producto buf;

	public AlmacenTam1() {
		buf = null;
	}

	@Override
	public void almacenar(Producto producto) {
		if (buf == null)
			buf = producto;
		else
			System.out.println("Error al almacenar!");
	}

	@Override
	public Producto extraer() {
		Producto aux = null;
		if (buf != null) {
			aux = buf;
			buf = null;
		} else {
			System.out.println("Error al extraer!");
		}
		return aux;
	}

}
