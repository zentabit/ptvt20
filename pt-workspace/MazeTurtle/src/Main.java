import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Maze m;
		SimpleWindow w;
		Turtle t;
		MazeWalker mw;
		m = new Maze(n);
		w = new SimpleWindow(400, 400, "MazeTest");
		t = new Turtle(w, m.getXEntry(), m.getYEntry());
		t.penDown();
		mw = new MazeWalker(t);
		m.draw(w);
		mw.walk(m);
	}

}
