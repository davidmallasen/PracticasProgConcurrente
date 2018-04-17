package multiBuffer.lockCond;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorProdCons {

    private AlmacenTamN almacen;
    private int numDisponibles;
    private final int tamMax;

    private final Lock l;
    private final Condition condProd;
    private final Condition condCons;

    public MonitorProdCons(int tamAlmacen) {
        almacen = new AlmacenTamN(tamAlmacen);
        tamMax = tamAlmacen;
        numDisponibles = 0;

        l = new ReentrantLock();
        condProd = l.newCondition();
        condCons = l.newCondition();
    }

    public void almacenar(Producto[] p, int num) {
        l.lock();
        try {
            while (numDisponibles + num > tamMax)
                condProd.await();

            // Caben num
            for (int i = 0; i < num; ++i)
                almacen.almacenar(p[i]);
            numDisponibles += num;
            condCons.signalAll();

            System.out.println(numDisponibles);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }
    }

    public Producto[] extraer(int num) {
        l.lock();
        Producto[] p = new Producto[num];

        try {
            while (numDisponibles < num)
                condCons.await();

            // Hay al menos num disponibles
            for (int i = 0; i < num; ++i)
                p[i] = almacen.extraer();
            numDisponibles -= num;
            condProd.signalAll();

            System.out.println(numDisponibles);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }

        return p;
    }

}
