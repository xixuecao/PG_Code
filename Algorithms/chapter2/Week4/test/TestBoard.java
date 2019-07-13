package test;
import java.util.ArrayList;
/**
 * @author evasean www.cnblogs.com/evasean/
 */
public class TestBoard {
    private static final int BLANK = 0;
    private final int n;
    private int[][] blocks;

    public TestBoard(int[][] inBlocks) {
        // construct a board from an n-by-n array of blocks
        // (where blocks[i][j] = block in row i, column j)
        n = inBlocks.length;
        blocks = new int[n][n];
        copy(blocks, inBlocks);
    }

    private void copy(int[][] toBlocks, int[][] fromBlocks) {
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                toBlocks[row][col] = fromBlocks[row][col];
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
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                if (blocks[row][col] != BLANK && blocks[row][col] != getValue(row, col))
                    hamming++;
        return hamming;
    }

    public int manhattan() {
        // sum of Manhattan distances between blocks and goal
        int manhattan = 0;
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                if (blocks[row][col] != BLANK && blocks[row][col] != getValue(row, col))
                    manhattan += Math.abs(getRow(blocks[row][col]) - row) + Math.abs(getCol(blocks[row][col]) - col);
        return manhattan;
    }

    public boolean isGoal() {
        // is this board the goal board?
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                if (blocks[row][col] != BLANK && blocks[row][col] != getValue(row, col))
                    return false;
        return true;
    }

    public TestBoard twin() {
        // a board that is obtained by exchanging any pair of blocks
        TestBoard twinBoard = new TestBoard(blocks);
        int firRow = 0;
        int firCol = 0;
        if (blocks[firRow][firCol] == BLANK)
            firCol++;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (blocks[row][col] != blocks[firRow][firCol] && blocks[row][col] != BLANK) {
                    twinBoard.swap(firRow, firCol, row, col);
                    return twinBoard;
                }
            }
        }
        return twinBoard;
    }

    private void swap(int vRow, int vCol, int wRow, int wCol) {
        int t = blocks[vRow][vCol];
        blocks[vRow][vCol] = blocks[wRow][wCol];
        blocks[wRow][wCol] = t;
    }

    public boolean equals(Object y) {
        // does this board equal y?
        if (y == null)
            return false;
        if (y == this)
            return true;
        if (y.getClass().isInstance(this)) {
            TestBoard yb = (TestBoard) y;
            if (yb.n != this.n)
                return false;
            else {
                for (int row = 0; row < n; row++)
                    for (int col = 0; col < n; col++)
                        if (yb.blocks[row][col] != blocks[row][col])
                            return false;
                return true;
            }
        } else
            return false;
    }

    public Iterable<TestBoard> neighbors() {
        // all neighboring boards
        ArrayList<TestBoard> neighbors = new ArrayList<TestBoard>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (blocks[row][col] == BLANK) {
                    // �հ׵�λ�÷ֱ����������ҵ�Ԫ�ؽ���һ��λ�þ͵õ�һ���ھ�board
                    // ���Ϸ�Ԫ�ػ���
                    if (row > 0) {
                        TestBoard neighborT = new TestBoard(blocks);
                        neighborT.swap(row, col, row - 1, col);
                        neighbors.add(neighborT);
                    }
                    // ���·�Ԫ�ػ���
                    if (row < n - 1) {
                        TestBoard neighborB = new TestBoard(blocks);
                        neighborB.swap(row, col, row + 1, col);
                        neighbors.add(neighborB);
                    }
                    // �����Ԫ�ػ���
                    if (col > 0) {
                        TestBoard neighborL = new TestBoard(blocks);
                        neighborL.swap(row, col, row, col - 1);
                        neighbors.add(neighborL);
                    }
                    // ���ұ�Ԫ�ػ���
                    if (col < n - 1) {
                        TestBoard neighborR = new TestBoard(blocks);
                        neighborR.swap(row, col, row, col + 1);
                        neighbors.add(neighborR);
                    }
                }
            }
        }
        return neighbors;
    }

    public String toString() {
        // string representation of this board (in the output format specified
        // below)
        StringBuilder sb = new StringBuilder();
        sb.append(n + "\n");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                //�������ǵ�n<128ʱԪ�ؿ��ܻ�ܴ����õ���%6d�������ύʱ������У�����
                //У�����Ҫ�������%2d������ֵ�У��
                sb.append(String.format("%2d ", blocks[row][col]));
            }
            sb.append("\n");
        }
        return sb.toString();
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