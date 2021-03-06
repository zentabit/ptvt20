import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w;
	private double x;
	private double y;
	private int a;
	private boolean isPenDown = false;
	
	
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.a = 90;
		w.moveTo((int)Math.round(x), (int) Math.round(y));
	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo((int)Math.round(x), (int) Math.round(y));
		double x1 = x + n*Math.cos(Math.toRadians(a));
		double y1 = y - n*Math.sin(Math.toRadians(a));
		
		if(isPenDown) {
			w.lineTo((int) Math.round(x1), (int) Math.round(y1));
		} else {
			w.moveTo((int) Math.round(x1), (int) Math.round(y1));
		}
		
		x = x1;
		y = y1;
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		a += beta;
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
		w.moveTo((int) Math.round(x), (int) Math.round(y));
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		a = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return a;
	}
}
