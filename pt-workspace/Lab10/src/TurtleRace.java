import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> ts = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> winners = new ArrayList<RaceTurtle>();
		Random r = new Random();
		
		for(int i = 1; i<9; i++) {
			int s = r.nextInt(3);
			switch(s) {
				case 0: ts.add(new MoleTurtle(w, i));
						break;
				case 1: ts.add(new AbsentMindedTurtle(w, i));
						break;
				case 2: ts.add(new DizzyTurtle(w, i));
						break;
			}
		}
		
		for(int i = 0; i<ts.size(); i++) {
			System.out.println("Nummer " + (i+1) + " - " + ts.get(i).toString());
		}
		
		System.out.println("Lets race!");
		
		// kör racet!
		while(!ts.isEmpty()) {
			for(int i = 0; i<ts.size(); i++) {
				if(ts.get(i).getX() > RaceWindow.X_END_POS) {
					winners.add(ts.get(i));
					ts.remove(i);
				} else {
					ts.get(i).raceStep();
				}
			}
			RaceWindow.delay(20);
		}
		
		for(int i = 0; i<3; i++) {
			System.out.println("På plats " + (i+1) + ": " + winners.get(i).toString());
		}
		
		// orättvisor i form av att padda 1 kontrolleras före sista paddan. Om två kommer i mål samtidigt läggs därför den sista paddan efter den första
		// dessutom är ju inte steglängden reguljär och vi kan inte kontrollera precis när paddan passerar mållinjen vilket innebär
	}

}
