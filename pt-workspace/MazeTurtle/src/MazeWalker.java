import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle t;
	
	
	public MazeWalker(Turtle turtle) {
		this.t = turtle;
	}
	
	public void walk(Maze m) {
		int forwards = 0;
		int turns = 0;
		// medan vi inte är i slutet
		while(!(m.atExit(t.getX(), t.getY()))) {
			// om vi inte har vägg till vänster, sväng vänster
			if(!(m.wallAtLeft(t.getDirection(), t.getX(), t.getY()))) {
				t.left(90);
				turns++;
			}
			// om vi har vägg framför, sväng höger
			while(m.wallInFront(t.getDirection(), t.getX(), t.getY())) {
				t.left(-90);
				turns++;
			}
			// rita ut paddan, vänta en sekund
			t.forward(1);
			forwards++;
			SimpleWindow.delay(1);
		}
		System.out.println("Steps: " + forwards);
		System.out.println("Turns: " + turns);

	}
		
		
}
