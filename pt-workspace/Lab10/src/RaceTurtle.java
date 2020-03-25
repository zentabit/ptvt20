import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;
	private Random r;
	
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		r = new Random();
		penDown();
		left(-90);
	}
	
	public void raceStep() {
		int step = r.nextInt(5)+1;
		forward(step);
	}
	
	public String toString() {
		return "Nummer " + nbr;
	}
}
