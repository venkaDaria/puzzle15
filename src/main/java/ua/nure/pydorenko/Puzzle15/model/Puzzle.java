package ua.nure.pydorenko.Puzzle15.model;

import java.util.Arrays;
import java.util.Random;

public class Puzzle {

	private int[][] blocks;

	private static final int[][] ANSWER = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
			{ 13, 14, 15, 0 } };

	public Puzzle() {
		blocks = copy(ANSWER);
		shuffle();
	}

	public int[][] getBlocks() {
		return blocks;
	}

	private int[][] copy(int[][] source) {
		int[][] dest = new int[source.length][source[0].length];
		for (int i = 0; i < dest.length; i++)
			dest[i] = Arrays.copyOf(source[i], source[i].length);
		return dest;
	}

	private boolean isSolvable() {
		int count = 0;
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (blocks[i][j] == 0) {
					count += (i + 1);
					continue;
				}
				for (int ki = i; ki < blocks.length; ki++) {
					int startPos = ki == i ? j + 1 : 0;
					for (int kj = startPos; kj < blocks[i].length; kj++) {
						if (blocks[ki][kj] == 0) {
							continue;
						}
						if (blocks[ki][kj] < blocks[i][j]) {
							count++;
						}
					}
				}
			}
		}
		System.out.println();
		System.out.println(Arrays.deepToString(blocks));
		System.out.println("Count: " + count);
		return count % 2 == 0;
	}

	public void shuffle() {
		do {
			tryShuffle();
		} while (!isSolvable());
	}

	private void tryShuffle() {
		Random random = new Random();
		for (int i = blocks.length - 1; i > 0; i--) {
			for (int j = blocks[i].length - 1; j > 0; j--) {
				int m = random.nextInt(i + 1);
				int n = random.nextInt(j + 1);
				int temp = blocks[i][j];
				blocks[i][j] = blocks[m][n];
				blocks[m][n] = temp;
			}
		}
	}

	public boolean isSolved() {
		return Arrays.deepEquals(blocks, ANSWER);
	}

	public boolean move(int wid, int hid) {
		boolean res = false;
		if (wid - 1 >= 0 && blocks[wid - 1][hid] == 0) {
			blocks[wid - 1][hid] = blocks[wid][hid];
			blocks[wid][hid] = 0;
			res = true;
		} else if (wid + 1 < blocks.length && blocks[wid + 1][hid] == 0) {
			blocks[wid + 1][hid] = blocks[wid][hid];
			blocks[wid][hid] = 0;
			res = true;
		} else if (hid + 1 < blocks[0].length && blocks[wid][hid + 1] == 0) {
			blocks[wid][hid + 1] = blocks[wid][hid];
			blocks[wid][hid] = 0;
			res = true;
		} else if (hid - 1 >= 0 && blocks[wid][hid - 1] == 0) {
			blocks[wid][hid - 1] = blocks[wid][hid];
			blocks[wid][hid] = 0;
			res = true;
		}
		return res;
	}
}
