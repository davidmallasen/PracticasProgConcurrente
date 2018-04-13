package sync.incDec;

public class MonitorIncDec {
	private int s;

	public MonitorIncDec() {
		this.s = 0;
	}

	public synchronized void inc() {
		s++;
	}

	public synchronized void dec() {
		s--;
	}

	public int getS() {
		return s;
	}
}
