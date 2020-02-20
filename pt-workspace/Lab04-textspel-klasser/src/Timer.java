
public class Timer {
	private long start;
	private long end;
	private long diff;
	
	void startTimer() {
		start = System.currentTimeMillis();
	}
	
	void stopTimer() {
		end = System.currentTimeMillis();
		diff = end - start;
	}
	
	long timeElapsed() {
		return diff/1000;
	}
}
