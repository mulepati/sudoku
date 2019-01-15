import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    public static void main(String[] args) throws FileNotFoundException {
        //the file hard coded in.
        Board newBoard = new Board("C:\\Users\\Samek\\Desktop\\CS 142\\SudokuSolver-stuff\\sudoku.sdk");

        //the file location is not hard coded in.
//        System.out.println("type file location :");
//        String fileLocation = Scanner.nextLine();
//        Board newBoard = new Board(fileLocation);
        System.out.println(newBoard);

    }
}
