class Pos {
	int x;
	int y;
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
    private static boolean[][] rowFlags = new boolean[9][10];
	private static boolean[][] colFlags = new boolean[9][10];
	private static boolean[][] blockFlags = new boolean[9][10];
	private static List<Pos> blankPos = new ArrayList<Pos>();
    public void solveSudoku(char[][] board) {
    	init();
    	for (int i = 0; i < 9; ++i) {
    		for (int j = 0; j < 9; ++j) {
    			if (board[i][j] == '.') {
    				blankPos.add(new Pos(i, j));
    			} else {
    				setAllFlags(i, j, board[i][j] - '0', true);
    			}
    		}
    	}
        solve(board, blankPos.size() - 1);
    }
    private static void init() {
		blankPos.clear();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 10; ++j) {
				rowFlags[i][j] = false;
				colFlags[i][j] = false;
				blockFlags[i][j] = false;
			}
		}
	}
    private static int getBlockNum(int row, int col) {
		return (row / 3) * 3 + (col / 3);
	}
	private static void setAllFlags(int row, int col, int number, boolean flag) {
		rowFlags[row][number] = flag;
		colFlags[col][number] = flag;
		blockFlags[getBlockNum(row, col)][number] = flag;
	}
	private static boolean isValid(int row, int col, int number) {
		return !rowFlags[row][number] && !colFlags[col][number] && !blockFlags[getBlockNum(row, col)][number];
	}
	private static boolean solve(char[][] board, int index) {
		if (index < 0) {
			return true;
		}
		int row = blankPos.get(index).x;
		int col = blankPos.get(index).y;
		for (int num = 1; num <= 9; ++num) {
			if (isValid(row, col, num)) {
				board[row][col] = (char)(num + '0');
				setAllFlags(row, col, num, true);
				if (solve(board, index - 1)) {
					return true;
				}
				setAllFlags(row, col, num, false);
			}
		}
		return false;
	}
}