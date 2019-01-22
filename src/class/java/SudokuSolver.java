import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    public static void main(String[] args) throws FileNotFoundException {
        //the file hard coded in.
        BoardReader newBoard = BoardFactory.getBoard("sudoku.sdk");
        BoardReader newBoard2 = BoardFactory.getBoard("puzzle.ss");
        //the file location is not hard coded in.
//        System.out.println("type file location :");
//        String fileLocation = Scanner.nextLine();
//        Board newBoard = new Board(fileLocation);
        System.out.println(newBoard);
        System.out.println(newBoard2);

    }
}
