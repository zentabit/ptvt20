import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleDrawRandomFigure {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawRandomFigure");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();
		t.penDown();
		for (int i = 0; i < 1000; i++) {
			t.forward(rand.nextInt(10)+1);
			t.left(rand.nextInt(361)-180);
			//SimpleWindow.delay(100);
		}
	}
}
