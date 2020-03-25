package memory;

import java.io.File;

import javax.swing.JOptionPane;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		int n = 0;

		while (n == 0) {
			MemoryBoard b = new MemoryBoard(4, "back.jpg", frontFileNames);
			MemoryWindow w = new MemoryWindow(b);
			int rounds = 0;

			w.drawBoard();

			while (!b.hasWon()) {
				w.waitForMouseClick();
				int row1 = w.getMouseRow();
				int col1 = w.getMouseCol();
				w.waitForMouseClick();
				int row2 = w.getMouseRow();
				int col2 = w.getMouseCol();

				if (!(b.frontUp(row1, col1) || b.frontUp(row2, col2))) {
					b.turnCard(row1, col1);
					b.turnCard(row2, col2);
				} else {
					continue;
				}
				w.drawBoard();

				if (!b.same(row1, col1, row2, col2)) {
					MemoryWindow.delay(1000);
					b.turnCard(row1, col1);
					b.turnCard(row2, col2);
					w.drawBoard();
				}
				rounds++;
			}

			n = JOptionPane.showConfirmDialog(null, "That took " + rounds + " rounds. Wanna go again?", "You won!",
					JOptionPane.YES_NO_OPTION);
		}
		System.exit(0);
	}
}
