import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class Random1001 {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawRandomFigure");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random rand = new Random();
		t1.penDown();
		t2.penDown();
		
		while(Math.hypot(Math.abs(t1.getX()-t2.getX()), Math.abs(t1.getY()-t2.getY()))>= 50) {
			t1.forward(rand.nextInt(10)+1);
			t1.left(rand.nextInt(361)-180);
			t2.forward(rand.nextInt(10)+1);
			t2.left(rand.nextInt(361)-180);
			SimpleWindow.delay(10);
		}
	}
}
