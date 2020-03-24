package cardgame;

import pair.Pair;
import pair.PairSet;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NBR_ITERATIONS = 10000000;
		int utgang = 0;
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
	
	static int run() {
		PairSet ps = new PairSet(4,13);
		int i = 0;
		
		while(ps.more()) {
			Pair p = ps.pick();
			if(p.second() == i) {
				return 0;
			}
			if(i == 2) {
				i = 0;
			} else {
				i++;
			}
		}
		
		return 1;
	}

}
