import java.util.Random;
import java.util.Scanner;

public class GameLoop {
	private Scanner scan;
	private Random rand;
	private Timer t;
	
	public GameLoop() {
		scan = new Scanner(System.in);
		rand = new Random();
		t = new Timer();
	}
	
	public void runGame() {
		while(true) {
			int n = rand.nextInt(100);
			print("Welcome: guess a number between 0 and 99!");
			t.startTimer();
			while(true) {
				print("Guess:");
				int g = scan.nextInt();
				if (g > n) {print("Lower!");}
				else if (g < n) {print("Higher!");}
				else {print("Yay!"); t.stopTimer(); break;}
			}
			print("It took you " + t.timeElapsed() + " seconds to guess.");
			print("Go again?(y/n)");
			String a = scan.next();
			if(a.equals("n")) {
				break;
			}
		}
		print("Bye!");
	}
	
	private static void print(String s) {
		System.out.println(s);
	}
}
