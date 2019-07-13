package test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Solver {
	
	private SearchNode currentNode;
	private SearchNode twincurrentNode;
	private Stack<Board> solution;
	
	private class SearchNode implements Comparable<SearchNode> {
		public Board board;
		public int moves;
		public SearchNode preSearchNode;
		
		public final int priority;
		
		public SearchNode(Board inBoard, SearchNode inPreSearchNode) {
			board = inBoard;
			preSearchNode = inPreSearchNode;
			if (inPreSearchNode == null) moves =0;
			else moves = inPreSearchNode.moves + 1;
			priority = moves + board.manhattan();
		}
		
		public int compareTo(SearchNode o) {
			return Integer.compare(this.priority, o.priority);
		}
		
	}
	public Solver(Board initial) {
		
		if (initial == null) throw new IllegalArgumentException("Constructor argument Board is null!");
		currentNode = new SearchNode(initial, null);
		twincurrentNode = new SearchNode(initial.twin(), null);
		MinPQ<SearchNode> priorityQueue = new MinPQ<SearchNode>();
		MinPQ<SearchNode> twinPriorityQueue = new MinPQ<SearchNode>();
		priorityQueue.insert(currentNode);
		twinPriorityQueue.insert(twincurrentNode);
		while (true) {
			currentNode = priorityQueue.delMin();
			if (currentNode.board.isGoal()) break;
			putNeighBorsIntoPQ(currentNode, priorityQueue);
			
			twincurrentNode = twinPriorityQueue.delMin();
			if (twincurrentNode.board.isGoal()) break;
			putNeighBorsIntoPQ(twincurrentNode, twinPriorityQueue);
		}
	}
	
	private void putNeighBorsIntoPQ(SearchNode searchNode, MinPQ<SearchNode> pq) {
		Iterable<Board> neighbors = searchNode.board.neighbors();
		for (Board neighbor : neighbors) {
			if (searchNode.preSearchNode == null || !neighbor.equals(searchNode.preSearchNode.board))
				pq.insert(new SearchNode(neighbor, searchNode));
		}
	}
	public boolean isSolvable() {
		// is the initial board sovable ?
		return currentNode.board.isGoal();
		
	}
	public int moves() {
		// min number of moves to solve initial board: -1 if unsolvable
		if (currentNode.board.isGoal()) return currentNode.moves;
		return -1;
	}
	public Iterable<Board> solution() {
		// sequence of board in a shortest solution: null if unsolvable
		if (currentNode.board.isGoal()) {
			solution = new Stack<Board>();
			SearchNode node = currentNode;
			while (node != null) {
				solution.push(node.board);
				node = node.preSearchNode;
			}
			return solution;
		}else {
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		
		// creat initial borad from file
		In in = new In(args[0]);
		//In in = new In(StdIn.readString()); 
		int n = in.readInt();
		int[][] blocks = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				blocks[i][j] = in.readInt();
		Board initial = new Board(blocks);
		
		// solve the puzzle
		Solver solver = new Solver(initial);
		
		// print solution to standard output
		if (!solver.isSolvable())
			System.out.println("No solution possible");
		else {
			System.out.println("Minimum number of moves = " + solver.moves());
			for (Board board : solver.solution())
				System.out.println(board);
		}
	}
}
// F:\Algorithms\Week4\Data\puzzle04.txt
// F:\Algorithms\Week4\Data\puzzle3x3-unsolvable.txt