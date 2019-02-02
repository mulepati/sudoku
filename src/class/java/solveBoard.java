
import java.util.*;


public class solveBoard {
    private int[][] board;

    public solveBoard(int[][] newBoard){
        board = newBoard;
    }

    public boolean isValid() {
        return validRow() && validColumn() && validGrid();
    }
    public boolean isSolved() {
        return filledRow() && isValid();
    }

    /*I moved the getNeighbors() fuction into a new class because it was a static method that did not seem ok.
    * Once moved to a new class it operates like any other field in a class function instead of being bad style
    * the getNeighbor fuction returns a list of all boards where when you add a new number the board is still
    * valid. */

    public List<int[][]> getNeighbors() {
        List<int[][]> boards = new ArrayList<>();
        int[][] newBoard = newBoard(board);

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

        solveBoard newBoard2 = new solveBoard(newBoard);
        if(newBoard2.isValid()) {
            return newBoard;
        }

        return null;
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


    private int[][] newBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        return newBoard;
    }

}
