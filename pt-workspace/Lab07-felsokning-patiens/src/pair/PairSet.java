package pair;

import java.util.Random;

public class PairSet {
	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();
	/** Skapar en mängd av alla talpar (a,b) sådana att
        0 <= a < rows  och  0 <= b < cols */
	public PairSet(int rows, int cols) {
			n = rows*cols;
			pairs = new Pair[n];
			
			for(int a = 0; a<rows; a++) {
				for(int b = 0; b<cols; b++) {
					pairs[b*rows+a] = new Pair(a, b);
					
				}
			}
	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		for(int i = 0; i<n; i++) {
			if(pairs[i] != null) {
				return true;
			}
		}
		return false;
	}

	/** Hämtar ett slumpmässigt valt talpar ur mängden. Mängden
	 	blir ett element mindre. Om mängden är tom returneras null. */
	public Pair pick() {
		if(n>0) {
			int r = rand.nextInt(n);
			//System.out.println(r);
			Pair elem = new Pair(pairs[r].first(), pairs[r].second());
			pairs[r] = pairs[n-1];
			//pairs[n-1] = null;
			n--;
			return elem;
		}
		
		return null;
	}
	
	public void print() {
		for(int i = 0; i < n; i++) {
			System.out.println(pairs[i]);
		}
	}
}
