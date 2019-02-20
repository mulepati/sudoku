import java.util.*;

public abstract class solveBoard {

    private int[][] board;

    abstract int[][] solveBoard(int[][] board2);

    public solveBoard(int[][] newBoard) {
        board = newBoard;
    }

    public boolean isValid() {
        return validRow() && validColumn() && validGrid();
    }
    public boolean isSolved() {
        return filledRow() && isValid();
    }

    private boolean filledRow() {

        for (int i = 0; i < 9; i++) {
            for (int cell : board[i]){
                if (cell == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<int[][]> getNeighbors() {
        List<int[][]> boards = new ArrayList<>();
        int[][] newBoard = newBoard(getBoard());

        for (int row = 0; row < newBoard.length; row++) {
            for (int col = 0; col < newBoard[row].length; col++) {
                for (int val = 1; val < 10; val++) {
                    if (newBoard[row][col] == 0 && !boards.contains(addNum(newBoard, row, col, val)) && addNum(newBoard, row, col, val) != null) {
                        boards.add(addNum(newBoard, row, col, val));
                    }
                }
            }

        }

        return boards;


    }

    private int[][] addNum(int[][] board, int x, int y, int z) {
        int[][] newBoard = newBoard(board);
        newBoard[x][y] = z;

        RecursiveSolver newBoard2 = new RecursiveSolver(newBoard);
        if(newBoard2.isValid()) {
            return newBoard;
        }

        return null;
    }

    private boolean validRow(){
        Set<Integer> rowSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int cell : board[i]) {
                if (rowSet.contains(cell) && cell != 0) {
                    rowSet.add(cell);
                    return false;
                } else if (rowSet.contains(cell) && cell == 0) {
                    rowSet.add(cell);
                }
                rowSet.add(cell);

            }
            rowSet.clear();
        }

        return true;
    }

    private boolean validColumn() {
        Set<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (columnSet.contains(board[j][i]) && board[j][i] != 0) {
                    columnSet.add(board[j][i]);
                    return false;
                } else if (columnSet.contains(board[j][i]) && board[j][i] == 0) {
                    columnSet.add(board[j][i]);
                }
                columnSet.add(board[j][i]);

            }
            columnSet.clear();
        }

        return true;
    }

    private boolean validGrid() {
        Set<Integer> gridSet = new HashSet<>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (gridSet.contains(board[i+k][j+l]) && board[i+k][j+l] != 0) {
                            return false;
                        } else if (gridSet.contains(board[i+k][j+l]) && board[i+k][j+l] == 0) {
                            gridSet.add(board[i+k][j+l]);
                        } else {
                            gridSet.add(board[i+k][j+l]);
                        }

                    }

                }
                gridSet.clear();

            }

        }

        return true;

    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] newBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        return newBoard;
    }

}
