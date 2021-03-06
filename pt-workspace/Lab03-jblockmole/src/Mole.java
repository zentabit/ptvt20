
public class Mole {
	private static final int W = 30;
	private static final int H = 50;
	private static final int BS = 10;
	private static final int SKYH = 15;
	
	Graphics g = new Graphics(W, H, BS);
	
	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	
	}
	
	public void dig() {
		int x = g.getWidth()/2;
		int y = g.getHeight()/2; // sätt mullvaden i mitten
		
		while(true) {
			if (x >= g.getWidth()) { // kolla så att mullvaden är innanför
				x = x-1;
			} else if (x < 0) {
				x = 0;
			} else if (y >= g.getHeight()) {
				y = y-1;
			} else if (y <= SKYH) {
				y = SKYH;
			}
			
			g.block(x, y, Colors.MOLE); // rita ut mullvaden
			char key = g.waitForKey();
			
			if (y == SKYH) {g.block(x, y, Colors.GRASS);} // fyll ut mullvadens spår
			else {g.block(x, y, Colors.TUNNEL);}
			if(key == 'w' && y > SKYH) {g.block(x, y=y-1, Colors.MOLE);} // flytta mullvaden ett snäpp
			else if(key == 'a') {g.block(x=x-1, y, Colors.MOLE);}
			else if(key == 's') {g.block(x, y=y+1, Colors.MOLE);}
			else if(key == 'd') {g.block(x=x+1, y, Colors.MOLE);}
		}
	}
	
	public void drawWorld() {
		g.rectangle(0, 0, W, H, Colors.SOIL);
		g.rectangle(0, 15, W, 1, Colors.GRASS);
		g.rectangle(0, 0, W, 15, Colors.SKY);
	}
	
}
