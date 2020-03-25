import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> ts = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> winners = new ArrayList<RaceTurtle>();
		for(int i = 1; i<9; i++) {
			ts.add(new RaceTurtle(w, i));
		}
		
		while(!ts.isEmpty()) {
			for(int i = 0; i<ts.size(); i++) {
				if(ts.get(i).getX() > RaceWindow.X_END_POS) {
					winners.add(ts.get(i));
					ts.remove(i);
				} else {
					ts.get(i).raceStep();
				}
			}
			RaceWindow.delay(1);
		}
		
		for(int i = 0; i<winners.size(); i++) {
			System.out.println("På plats " + (i+1) + ": " + winners.get(i).toString());
			//System.out.println("På plats " + i+1);
		}
		
		// orättvisor i form av att padda 1 kontrolleras före sista paddan. Om två kommer i mål samtidigt läggs därför den sista paddan efter den första
		// dessutom är ju inte steglängden reguljär och vi kan inte kontrollera precis när paddan passerar mållinjen vilket innebär
	}

}
