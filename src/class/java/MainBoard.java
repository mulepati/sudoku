import java.io.FileNotFoundException;

public class MainBoard {
    private int[][] boardRows;

    public MainBoard(String file) throws FileNotFoundException {
        BoardReader newBoard = BoardFactory.getBoardReader(file);
        this.boardRows = newBoard.readBoard();
    }

    public boolean isValid() {
        solveBoard newBoard = new RecursiveSolver(boardRows);
        return newBoard.isValid();
    }

    public boolean isSolved() {
        solveBoard newBoard = new RecursiveSolver(boardRows);
        return newBoard.isSolved();
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

    public void recursiveSolve(){
        solveBoard board = new RecursiveSolver(boardRows);
        boardRows = board.solveBoard(boardRows);
    }

    public void dFSSolver(){
        solveBoard board = new DFSSolver(boardRows);
        boardRows = board.solveBoard(boardRows);
    }

    /* I created a new solveBoard class that has most of the commands that checks things in the board
    * I don't quite know if I did it right but I feel like it was better to have all the helper function in
    * a new class so that I don't have to make them static like my previous code, while I left the recursive
    * in my main board function because it is a recursive function that has to be static is a way.*/


}

