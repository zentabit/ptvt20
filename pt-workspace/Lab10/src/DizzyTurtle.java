import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	private int dizzyness;
	private Random r;
	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		r = new Random();
		dizzyness = r.nextInt(5) + 1;
	}
	
	public void raceStep() {
		int s = r.nextInt(10) + 1;
		if(s>dizzyness) {
			super.raceStep();
		} else {
			double s2 = r.nextDouble();
			if(s2>0.5) {
				super.jumpTo(getX(), getY()+dizzyness);
			} else {
				super.jumpTo(getX(), getY()-dizzyness);
			}
		}
	}
	
	public String toString() {
		return "DizzyTurtle (Yrsel: " + dizzyness + ")";
	}
}
