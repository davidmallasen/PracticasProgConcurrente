package parte2.bakery;

public class Compartido {
	public int num;
	volatile public boolean in1, in2;
	volatile int last;

	public Compartido() {
		num = 0;
		in1 = false;
		in2 = false;
		last = 1;
	}
}