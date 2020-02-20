import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SpaceInvaders {

	public static void main(String[] args) {
		int width = 80;
		int height = 24;
		
		ArrayList<Invader> Invaders = new ArrayList<Invader>();
		ArrayList<Bullet> Bullets = new ArrayList<Bullet>();

		Invaders.add(new Invader(2, 0, 1));
		Invaders.add(new Invader(20, 10, 1));
		Bullets.add(new Bullet(20, 20, -1));
		
		
		
		String[][] screen = new String[height][width];
		for(int i = 0; i < screen.length; i++) {
			for(int j = 0; j < screen[i].length; j++) {
				screen[i][j] = " ";
			}
		}
		
		for(Invader inv:Invaders) {
			screen[inv.getY()][inv.getX()] = "O";
		}
		
		for(Bullet bul:Bullets) {
			screen[bul.getY()][bul.getX()] = ".";
		}
		
		while(true) {
			updateInvaders(Invaders, screen);
			updateBullets(Bullets, screen);
			//clearScreen();
			draw(screen);
			try
			{
			    Thread.sleep(3000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
		}
		
	
	}

	private static void updateBullets(ArrayList<Bullet> bullets, String[][] screen) {
		for(Bullet bul:bullets) {
			screen[bul.getY()][bul.getX()] = " ";
			bul.y = bul.y + bul.getVelY();
			screen[bul.getY()][bul.getX()] = ".";
		}
	}
	

	private static void updateInvaders(ArrayList<Invader> invaders, String[][] screen) {
		for(Invader inv:invaders) {
			screen[inv.getY()][inv.getX()] = " ";
			inv.y = inv.y + inv.getVelY();
			screen[inv.getY()][inv.getX()] = "O";
		}
	}

	private static void draw(String[][] s) {
		// skapa textsträng med rutan (spaces)

		
		//StringBuilder screen = new StringBuilder(row.repeat(h) + );
		// byt ut alla spaces mot objekt
		// skriv ut på skärmen
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s[i].length; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	public static void clearScreen() {  
		final String ESC = "\033[";
		System.out.print(ESC + "2J");  
	} 
	

}
