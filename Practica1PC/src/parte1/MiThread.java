package parte1;

public class MiThread extends Thread {
	private long milis;
	
	public MiThread(long T) {
		this.milis = T;
	}
	
	@Override
	public void run() {
		System.out.println(this.getId());
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(this.getId());
	}
}
