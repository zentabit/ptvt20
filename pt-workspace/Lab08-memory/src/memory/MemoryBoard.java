package memory;

import java.util.Random;

import pair.Pair;
import pair.PairSet;

public class MemoryBoard {
	private MemoryCardImage board[][];
	private boolean ori[][];
	private int sz;
	
	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		sz = size;
		board = new MemoryCardImage[sz][sz];
		ori = new boolean[sz][sz];
		//createCards(backFileName, frontFileNames);
		createCards2(backFileName, frontFileNames);

	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		Random rand = new Random();
		
		for(String s: frontFileNames) {
			MemoryCardImage img = new MemoryCardImage(s, backFileName);
			int c = rand.nextInt(sz);
			int r = rand.nextInt(sz);
			
			while(board[r][c] != null) {
				c = rand.nextInt(sz);
				r = rand.nextInt(sz);
			}
			board[r][c] = img;
			ori[r][c] = false;
			
			while(board[r][c] != null) {
				c = rand.nextInt(sz);
				r = rand.nextInt(sz);
			}
			board[r][c] = img;
			ori[r][c] = false;
			
		}
	}

	private void createCards2(String backFileName, String[] frontFileNames) {
		Random rand = new Random();
		PairSet ps = new PairSet(sz, sz);
		
		for(String s: frontFileNames) {
			MemoryCardImage img = new MemoryCardImage(s, backFileName);
			Pair p1 = ps.pick();
			Pair p2 = ps.pick();
			
			board[p1.first()][p1.second()] = img;
			board[p2.first()][p2.second()] = img;
		}
	}
	/** Tar reda på brädets storlek. */
	public int getSize() {
		return sz;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		ori[r][c] = !ori[r][c];
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return ori[r][c];
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return board[r1][c1] == board[r2][c2];
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for(boolean[] r: ori) {
			for(boolean b: r) {
				if(b == false) {
					return false;
				}
			}
		}
		return true;
	}	
	
	public void print() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j]!=null) {
					System.out.print("hej ");
				}
				
			}
			System.out.println();
		}
	}
}
