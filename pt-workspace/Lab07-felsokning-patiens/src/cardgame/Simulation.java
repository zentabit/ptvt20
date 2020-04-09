package cardgame;

import pair.Pair;
import pair.PairSet;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NBR_ITERATIONS = 1000000;
		int utgang = 0; // antal gånger patiensen går ut
		for(int i = 0; i < NBR_ITERATIONS; i++) {
			int result = run();
			//System.out.println("Omgång " + i);
			if(result == 1) {
				utgang++;
			}
		}
		//System.out.println(utgang);
		double s = (double) utgang/NBR_ITERATIONS;
		System.out.println(s);
	}
	
	// kör en runda av patiensen
	// returnerar 1 om den går ut, 0 annars
	static int run() {
		PairSet ps = new PairSet(4,13);
		int i = 0;
		
		while(ps.more()) {
			Pair p = ps.pick();
			if(p.second() == i) { // är det samma kort som siffran
				return 0; // aj då!
			}
			// jätteful räknare för att hålla koll på siffran
			if(i == 2) {
				i = 0;
			} else {
				i++;
			}
		}
		
		return 1;
	}

}
