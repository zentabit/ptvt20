import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class MoveSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int x = w.getClickedX();
			int y = w.getClickedY();
			sq.erase(w);
			sq.move(x - sq.getX(), y - sq.getY());
			sq.draw(w);
		}
	}
}
