package multiBuffer.sync;

public class MonitorProdCons {

	private AlmacenTamN almacen;
	private int numDisponibles;
	private final int tamMax;

	public MonitorProdCons(int tamAlmacen) {
		almacen = new AlmacenTamN(tamAlmacen);
		tamMax = tamAlmacen;
		numDisponibles = 0;
	}

	public synchronized void almacenar(Producto[] p, int num) {
		try {
			while (numDisponibles + num > tamMax)
				wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Caben num
		for (int i = 0; i < num; ++i)
			almacen.almacenar(p[i]);
		numDisponibles += num;
		notifyAll();
		
		System.out.println(numDisponibles);
	}

	public synchronized Producto[] extraer(int num) {
		Producto[] p = new Producto[num];

		try {
			while (numDisponibles < num)
				wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Hay al menos num disponibles
		for (int i = 0; i < num; ++i)
			p[i] = almacen.extraer();
		numDisponibles -= num;
		notifyAll();
		
		System.out.println(numDisponibles);
		
		return p;
	}

}
