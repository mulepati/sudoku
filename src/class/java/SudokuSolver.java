import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    public static void main(String[] args) throws FileNotFoundException {
        //the file hard coded in.
        MainBoard newBoard = new MainBoard("sudoku.sdk");
        MainBoard newBoard2 = new MainBoard("puzzle.ss");
        //the file location is not hard coded in.
//        System.out.println("type file location :");
//        String fileLocation = Scanner.nextLine();
//        Board newBoard = new Board(fileLocation);
        System.out.println(newBoard);
        System.out.println(newBoard2);

        System.out.println(newBoard.isValid());

        System.out.println(newBoard.isSolved());

    }
}
