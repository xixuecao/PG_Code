package test;

import java.util.ArrayList;

public class Board {
	private final static int BLANK = 0;
	private int[][] blocks;
	private final int n;
	
	public Board(int[][] blocks) {
		// construct a board from an n-by-n array of blocks
		// where blocks[i][j] = block in row i, column in j
		n = blocks.length;
		this.blocks = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				this.blocks[i][j] = blocks[i][j];
	}
	
	public int dimension() {
		// board dimension n
		return n;
	}
	
	private int getRow(int value) {
		return (value - 1) / n;
	}
	private int getCol(int value) {
		return (value - 1) % n;
	}
	private int getValue(int row, int col) {
		return row * n + col + 1;
	}
	
	public int hamming() {
		// number of blocks out of place
		int hamming = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (blocks[i][j] != BLANK && blocks[i][j] != getValue(i, j))
					hamming++;
		return hamming;
	}
	public int manhattan() {
		// sum of Manhattan distance between blocks and goal
		int manhattan = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (blocks[i][j] != BLANK && blocks[i][j] != getValue(i, j))
					manhattan += Math.abs(getRow(blocks[i][j]) - i) + Math.abs(getCol(blocks[i][j]) - j);
		return manhattan;
	}
	public boolean isGoal() {
		// is this board the goal board ?
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (blocks[i][j] != BLANK && blocks[i][j] != getValue(i, j))
					return false;
		return true;
	}
	
	public Board twin() {
		// a board that is obtained by exchanging any pair of blocks
		Board twinBoard = new Board(blocks);
		int firRow = 0;
		int firCol = 0;
		if (blocks[firRow][firCol] == BLANK)
			firCol++;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (blocks[i][j] != blocks[firRow][firCol] && blocks[i][j] != BLANK) {
					twinBoard.swap(firRow, firCol, i, j);
					return twinBoard;
				}
			}
		}
		return twinBoard;
	}
	private void swap(int firRow, int firCol, int secRow, int secCol) {
		int t = blocks[firRow][firCol];
		blocks[firRow][firCol] = blocks[secRow][secCol];
		blocks[secRow][secCol] = t;
	}
	public boolean equals(Object y) {
		// dose this board equal y ?
		if (y == null)
			return false;
		if (y == this)
			return true;
		if (y.getClass().isInstance(this)) {
			Board yb = (Board) y;
			if (yb.n != this.n) {
				return false;
			}else {
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++)
						if (yb.blocks[i][j] != blocks[i][j])
							return false;
				return true;
			}
		}else {
			return false;
		}
		
	}
	public Iterable<Board> neighbors() {
		// all neighboring boards
		ArrayList<Board> neighbors = new ArrayList<Board>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (blocks[i][j] == BLANK) {
					if (i > 0) {
						Board neighborT = new Board(blocks);
						neighborT.swap(i, j, i - 1, j);
						neighbors.add(neighborT);
					}
					if (i < n - 1) {
						Board neighborB = new Board(blocks);
						neighborB.swap(i, j, i + 1, j);
						neighbors.add(neighborB);
					}
					if (j > 0) {
						Board neighborL = new Board(blocks);
						neighborL.swap(i, j, i, j - 1);
						neighbors.add(neighborL);
					}
					if (j < n - 1) {
						Board neighborR = new Board(blocks);
						neighborR.swap(i, j, i, j + 1);
						neighbors.add(neighborR);
					}
				}
			}
		}
		return neighbors;
	}
	public String toString() {
		// string representation of this board
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(n + "\n");
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++)
				stringBuilder.append(String.format("%2d ", blocks[i][j]));
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		// unit test (no graded)
		int[][] test = {{0, 1}, {2, 3}};
		Board b = new Board(test);
		System.out.println(b);
		System.out.println(b.hamming());
		System.out.println(b.manhattan());
	}
}
