package sync.prodCons;

public class AlmacenTam1 implements Almacen {

	private Producto buf;

	public AlmacenTam1() {
		buf = null;
	}

	@Override
	public void almacenar(Producto producto) {
		if (buf == null) // Comprobaciones redundantes para ver que lo hacemos bien
			buf = producto;
		else
			System.out.println("Error al almacenar!");
	}

	@Override
	public Producto extraer() {
		Producto aux = null;
		if (buf != null) { // Comprobaciones redundantes para ver que lo hacemos bien
			aux = buf;
			buf = null;
		} else {
			System.out.println("Error al extraer!");
		}
		return aux;
	}

}
