
public class Bullet {
	int x;
	int y;
	private int velY;
	
	public Bullet(int x, int y, int velY) {
		this.x = x;
		this.y = y;
		this.velY = velY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getVelY() {
		return velY;
	}
}
