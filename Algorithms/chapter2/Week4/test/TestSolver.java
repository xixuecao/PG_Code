package test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * @author evasean www.cnblogs.com/evasean/
 */
public class TestSolver {
    
    private SearchNode currentNode;
    private SearchNode twincurrentNode;
    private Stack<TestBoard> solution;
    
    private class SearchNode implements Comparable<SearchNode>{
        public TestBoard board;
        public int moves;
        public SearchNode preSearchNode;
        
        public final int priority;
        
        public SearchNode(TestBoard inboard, SearchNode inPreSearchNode){
            board = inboard;
            preSearchNode = inPreSearchNode;
            if(inPreSearchNode == null) moves = 0;    
            else moves = inPreSearchNode.moves + 1;
            priority = moves + board.manhattan();
        }

        @Override
        public int compareTo(SearchNode o) {
            return Integer.compare(this.priority, o.priority);
        }
    }
    
    
    public TestSolver(TestBoard initial) {
        // find a solution to the initial board (using the A* algorithm)
        if(initial == null)
            throw new IllegalArgumentException("Constructor argument Board is null!");
        currentNode = new SearchNode(initial,null);
        twincurrentNode = new SearchNode(initial.twin(),null);
        MinPQ<SearchNode> priorityQueue = new MinPQ<SearchNode>();
        MinPQ<SearchNode> twinPriorityQueue = new MinPQ<SearchNode>();
        priorityQueue.insert(currentNode);
        twinPriorityQueue.insert(twincurrentNode);
        while(true){
            currentNode = priorityQueue.delMin();
            if(currentNode.board.isGoal()) break;
            putNeighBorsIntoPQ(currentNode,priorityQueue);
            
            twincurrentNode = twinPriorityQueue.delMin();
            if(twincurrentNode.board.isGoal()) break;
            putNeighBorsIntoPQ(twincurrentNode,twinPriorityQueue);
        }
    }
    
    private void putNeighBorsIntoPQ(SearchNode searchNode, MinPQ<SearchNode> pq){
        Iterable<TestBoard> neighbors = searchNode.board.neighbors();
        for(TestBoard neighbor : neighbors){
            //ֻ���ڵ�ǰ�����ڵ���ھ��ǵ�borad���뵱ǰ�ڵ��preSearchNode��borad��ͬ
            //�Ž����ھӷ������ȶ���
            
            if(searchNode.preSearchNode==null || !neighbor.equals(searchNode.preSearchNode.board))
                pq.insert(new SearchNode(neighbor,searchNode));
        }
    }

    public boolean isSolvable() {
        // is the initial board solvable?
        return currentNode.board.isGoal();
    }

    public int moves() {
        // min number of moves to solve initial board; -1 if unsolvable
        if(currentNode.board.isGoal())
            return currentNode.moves;
        else
            return -1;
    }

    public Iterable<TestBoard> solution() {
        // sequence of boards in a shortest solution; null if unsolvable
        if(currentNode.board.isGoal()){
            solution = new Stack<TestBoard>();
            SearchNode node = currentNode;
            while(node != null){
                solution.push(node.board);
                node = node.preSearchNode;
            }
            return solution;
        }else
            return null;
    }

    public static void main(String[] args) {
        // solve a slider puzzle (given below)
        // create initial board from file
//        In in = new In(args[0]);
        In in = new In(StdIn.readString()); //���ز���֮��
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        TestBoard initial = new TestBoard(blocks);

        // solve the puzzle
        TestSolver solver = new TestSolver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (TestBoard board : solver.solution())
                StdOut.println(board);
        }
    }
}
