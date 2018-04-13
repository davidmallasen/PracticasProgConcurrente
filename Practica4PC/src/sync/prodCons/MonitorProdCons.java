package sync.prodCons;

public class MonitorProdCons {

	private AlmacenTamN almacen;
	private int numDisponibles;
	private final int tamMax;

	public MonitorProdCons(int tamAlmacen) {
		almacen = new AlmacenTamN(tamAlmacen);
		tamMax = tamAlmacen;
		numDisponibles = 0;
	}

	public synchronized void almacenar(Producto p) {
		try {
			while (numDisponibles == tamMax)
				wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//numDisponibles < tamMax
		almacen.almacenar(p);
		numDisponibles++;
		notifyAll();
	}

	public synchronized Producto extraer() {
		Producto p = null;
		
		try {
			while (numDisponibles == 0)
				wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//numDisponibles > 0
		p = almacen.extraer();
		numDisponibles--;
		notifyAll();
		return p;
	}

}
