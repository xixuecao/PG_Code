import edu.princeton.cs.algs4.*;

public class Percolation {
	private static final boolean BLOCK=false;
	private static final boolean OPEN=true;
	
	private final WeightedQuickUnionUF topUF;
	private final WeightedQuickUnionUF bottomUF;
	private int n;
	
	private boolean[][] grid;
	private boolean isPercolate=false;
	private int numOfOpen=0;
	
	public Percolation(int n) {
		// create n-by-n grid, with all sites blocked
		if (n<1) 
			throw new IllegalArgumentException("grid size should be bigger than 1!");
		this.n=n;
		topUF=new WeightedQuickUnionUF(n*n+1);
		bottomUF=new WeightedQuickUnionUF(n*n+1);
		
		grid=new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j]=BLOCK;
	}
	
	public void open(int row, int col) {
		// open site (row, col) if it is not open already
		if (row<1||col<1||row>n||col>n)
			throw new IllegalArgumentException("intput row or col is not illegal!");
		if (grid[row-1][col-1]==OPEN)
			return;
		grid[row-1][col-1]=OPEN;
		numOfOpen++;
		
		if (n==1) {
			topUF.union(0, 1);
			bottomUF.union(0, 1);
			isPercolate=true;
			return;
		}
		
		if (row==1)
			topUF.union(n*n, col-1);
		if (row==n)
			bottomUF.union(n*n, n*(n-1)+col-1);
		// top
		if (row>1&&grid[row-2][col-1]==OPEN) {
			topUF.union((row-2)*n+col-1, (row-1)*n+col-1);
			bottomUF.union((row-2)*n+col-1, (row-1)*n+col-1);
		}
		// bottom
		if (row<n&&grid[row][col-1]==OPEN) {
			topUF.union(row*n+col-1, (row-1)*n+col-1);
			bottomUF.union(row*n+col-1, (row-1)*n+col-1);
		}
		// left
		if (col>1&&grid[row-1][col-2]==OPEN) {
			topUF.union((row-1)*n+col-2, (row-1)*n+col-1);
			bottomUF.union((row-1)*n+col-2, (row-1)*n+col-1);
		}
		// right
		if (col<n&&grid[row-1][col]==OPEN) {
			topUF.union((row-1)*n+col, (row-1)*n+col-1);
			bottomUF.union((row-1)*n+col, (row-1)*n+col-1);
		}
		if (!isPercolate&&numOfOpen>=n&&topUF.connected(n*n, (row-1)*n+col-1)&&bottomUF.connected(n*n, (row-1)*n+col-1))
			isPercolate=true;
	}
	
	public boolean isOpen(int row, int col) {
		// is site (row, col) open?
		if (row<1||col<1||row>n||col>n)
			throw new IllegalArgumentException("intput row or col is not illegal!");
		return grid[row-1][col-1]==OPEN;
	}
	
	public boolean isFull(int row, int col){
		// is site (row, col) full?
		if (row<1||col<1||row>n||col>n)
			throw new IllegalArgumentException("intput row or col is not illegal!");
		if (isOpen(row, col)&&topUF.connected(n*n, (row-1)*n+col-1)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int numberOfOpenSites() {
		// number of open sites
		return numOfOpen;
	}
	
	public boolean percolates() {
		// does the system percolate?
		return isPercolate;
	}
	
	private void printResult(int row,int col) {
		System.out.println("p("+row+","+col+") is open= "+isOpen(row, col)+"; is Full= "+isFull(row, col)+"; percolates= "+percolates());
	}
	private static void fileInputCheck(String inpiut) {
		In in=new In(inpiut);
		String s=null;
		int n=-1;
		while (in.hasNextLine()) {
			s=in.readLine();
			if (s!=null&&!s.trim().equals(""))
				break;
		}
		s=s.trim();
		n=Integer.parseInt(s);
		Percolation p=new Percolation(n);
		while (in.hasNextLine()) {
			s=in.readLine();
			if (s!=null&&!s.trim().equals("")) {
				s=s.trim();
				String[] sa=s.split("\\s+");
				if (sa.length!=2)
					break;
				int row=Integer.parseInt(sa[0]);
				int col=Integer.parseInt(sa[1]);
				p.open(row, col);
				p.printResult(row, col);
			}
		}
	}
	public static void main(String[] args) {
		// test client (optional)
		fileInputCheck(args[0]);
	}
}