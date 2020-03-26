import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle{
	private int absentmindedness;
	private Random r;
	
	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		r = new Random();
		absentmindedness = r.nextInt(101);
	}
	
	public void raceStep() {
		int s = r.nextInt(101);
		if(s>absentmindedness) {
			super.raceStep();
		}
	}
	
	public String toString() {
		return "AbsentMindedTurtle (" + absentmindedness + "% Frånvarande)";
	}
}
