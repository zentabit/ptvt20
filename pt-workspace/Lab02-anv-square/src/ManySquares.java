import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class ManySquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int finx = w.getClickedX();
			int finy = w.getClickedY();
			int x = sq.getX();
			int y = sq.getY();
			int stepx = (int)(finx - x)/10;
			int stepy = (int)(finy - y)/10;
			
			while (Math.abs(finx - x) > 10) {
				sq.move(stepx, stepy);
				sq.draw(w);
				x += stepx;
			}
			
		}
	}
}
