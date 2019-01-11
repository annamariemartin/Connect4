package app;
public class Board {
	private char[][] board = new char[7][7];
	//constructor
	public Board() {
		board = new char[7][7];
		reset();
	}
	
	public boolean tieGame() {
		return !isWinner('x') && !isWinner('o') && !anotherPlayPossible(); 
	}
	
	public void reset() {
		for(char[] row : board) {
			for(int c = 0; c < row.length; c++) {
				row[c] = '-';
			}
		}
	}
	

	public boolean isWinner(char player) {
		
		if(horizontalWin(player) || verticalWin(player) || diagonalPosWin(player) || diagonalNegWin(player)) return true;
		return false;
	}
	
	public boolean horizontalWin(char player) {
		for(int row = 0; row < board.length; row++) {
		int count = 0;
			for(int col = 0; col < board.length; col++) {
				if(board[row][col] == player) {
					count++;
				}
				else count = 0;
				if(count == 4) return true;
			}
		}
		return false;
	}
	
	public boolean verticalWin(char player) {
		for(int col = 0; col < board.length; col++) {
			int count = 0;
			for(int row = 0; row < board.length; row++) {
				if(board[row][col] == player) {
					count++;
				}
				else count = 0;
				if(count == 4) return true;
			}
		}
		return false;
	}
	
	public boolean diagonalPosWin(char player) {
		for(int row = 3; row < board.length; row++) {
			int count = 0;
			for(int col = 0; col <=row; col++) {
				if(board[row-col][col] == player) count++;
				else count = 0;
				
				if(count == 4) return true;
			}
		}
		for(int col = 1; col <= 3; col++) {
			int count = 0;
			int col_copy = col;
			for(int row = 6; row>= col; row--) {
				if(board[row][col_copy] == player) count++;
				else count = 0;
				
				col_copy ++;
				if(count == 4) return true;
			}
		}
		return false;
	}
	
	public boolean diagonalNegWin(char player) {
		for(int r = 0; r < board.length; r++) {
			int count = 0;
			int row_copy = r;
			for(int c = 0; row_copy < board.length; c++) {
				if(board[row_copy][c] == player) count++;
				else count = 0;
				row_copy++;
				if(count==4) return true;
			}
		}
		for(int c = 1; c <= 3; c++) {
			int count = 0;
			for(int r = 0; r+c < board.length; r++) {
				if(board[r][c+r] == player) count++;
				else count = 0;
				
				if (count == 4) return true;
			}
		}
		return false;
	}

	public boolean dropPiece(char player, int column) {
			if(column >= board.length || column < 0) return false;
			for(int y = board.length - 1; y >= 0; y--) {
				if(board[y][column] == '-') {
					board[y][column] = player;
					return true;
				}
			}
			return false;
		}

	
	public boolean anotherPlayPossible() {
		for(int x = board.length - 1; x >= 0; x--) { // should this go forwards or backwards
			for(int y = board.length - 1; y >= 0; y--) {
				if(board[y][x] == '-')return true;
			}
		}
		return false;
	}
	
		@Override
		public String toString() {
			String result = "";
			// print board
			for(char[] row : board) {
				for(char col : row) {
					result += col + " ";
				}
				// line break after each row
				result += "\n";
			}
			return result;
		}
}