import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	private Random r;
	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		r = new Random();
	}
	
	public void raceStep() {
		double s = r.nextDouble();
		if(s<0.3) {
			penUp();
		} else {
			penDown();
		}
		super.raceStep();
	}
	
	public String toString() {
		return "MoleTurtle";
	}
}
