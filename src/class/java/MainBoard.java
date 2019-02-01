import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class MainBoard {
    private int[][] boardRows;

    public MainBoard(String file) throws FileNotFoundException {
        BoardReader newBoard = BoardFactory.getBoardReader(file);
        this.boardRows = newBoard.readBoard();
    }

    public boolean isValid(int[][] board) {
        return validRow(board) && validColumn(board) && validGrid(board);
    }

    public boolean isSolved(int[][] board) {

        return filledRow(board) && isValid(board);
    }

    public int[][] getBoard() {
        return boardRows;
    }

    public String toString() {
        if(boardRows == null){
            return "invalid board";
        }
        StringBuilder myBoard = new StringBuilder();
        //this for loop addeds each line of the array row on to a string to create the sudoku board.
        for (int[] row : boardRows) {
            StringBuilder rows = new StringBuilder();
            for (int number : row) {
                rows.append(number);
            }
            myBoard.append("\n");
            myBoard.append(rows.toString());
        }
        return myBoard.toString();

    }

    /*Recursive Backtracking Solver, this method just solves the board changing the object into a solved board if the
    board that was called in is valid. I made this function inside the MainBoard class because I have all my other
    functions avaliable to me in this class. I could have added a new class to solve everything which would have been
    easy enough but I would then have to rewrite additional code and repeat other code.*/
    public void solve(){
        boardRows = solveBoard(boardRows);
    }

    private boolean filledRow(int[][] boardRows) {

        for (int i = 0; i < 9; i++) {
            for (int cell : boardRows[i]){
                if (cell == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validRow(int[][] boardRows){
        Set<Integer> rowSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int cell : boardRows[i]) {
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

    private boolean validColumn(int[][] boardRows) {
        Set<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (columnSet.contains(boardRows[j][i]) && boardRows[j][i] != 0) {
                    columnSet.add(boardRows[j][i]);
                    return false;
                } else if (columnSet.contains(boardRows[j][i]) && boardRows[j][i] == 0) {
                    columnSet.add(boardRows[j][i]);
                }
                columnSet.add(boardRows[j][i]);

            }
            columnSet.clear();
        }

        return true;
    }

    private boolean validGrid(int[][] boardRows) {
        Set<Integer> gridSet = new HashSet<>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (gridSet.contains(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0) {
                            return false;
                        } else if (gridSet.contains(boardRows[i+k][j+l]) && boardRows[i+k][j+l] == 0) {
                            gridSet.add(boardRows[i+k][j+l]);
                        } else {
                            gridSet.add(boardRows[i+k][j+l]);
                        }

                    }

                }
                gridSet.clear();

            }

        }

        return true;

    }

    private List<int[][]> getNeighbors(int[][] board) {
        List<int[][]> boards = new ArrayList<>();
        int[][] newBoard = newBoard(board);

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                for (int k = 1; k < 10; k++) {
                    if (newBoard[i][j] == 0 && !boards.contains(addNum(newBoard, i, j, k)) && addNum(newBoard, i, j, k) != null) {
                        boards.add(addNum(newBoard, i, j, k));
                    }
                }
            }

        }

        return boards;


    }

    private int[][] addNum(int[][] board, int x, int y, int z) {
        int[][] newBoard = newBoard(board);
        newBoard[x][y] = z;
        if(isValid(newBoard)) {
            return newBoard;
        }

        return null;
    }

    private int[][] solveBoard(int[][] board) {
        if(isSolved(board)) {
            return board;
        } else {
            for(int[][] boards: getNeighbors(board)) {
                 int[][] result = solveBoard(boards);
                 if(result != null) {
                     return result;
                 }
            }

        }
        return null;
    }

    private int[][] newBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        return newBoard;
    }


}

