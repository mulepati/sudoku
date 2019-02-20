import java.io.FileNotFoundException;
import java.util.*;

public class sudokuSolver {
    public static void main(String[] args) throws FileNotFoundException {
        //the file hard coded in.
        MainBoard newBoard = new MainBoard("puzzle.ss");
        MainBoard newBoard2 = new MainBoard("puzzle.ss");
        //the file location is not hard coded in.
//        System.out.println("type file location :");
//        String fileLocation = Scanner.nextLine();
//        Board newBoard = new Board(fileLocation);
        System.out.println("Prints out original board:");

        System.out.println(newBoard2);
        System.out.println();
        System.out.println("Is board valid: " + newBoard2.isValid());

        System.out.println("Is board solved: " +newBoard2.isSolved());

        newBoard2.recursiveSolve();
        System.out.println("solved with recursives:");
        System.out.println(newBoard2);

        System.out.println("Is board solved: " + newBoard2.isSolved());

        long t1 = System.nanoTime();
        System.out.println("Prints out original:");
        System.out.println(newBoard);
        long t2 = System.nanoTime();
        System.out.println("Time: " + String.valueOf(t2 - t1));

        System.out.println();

        long t3 = System.nanoTime();
        newBoard.dFSSolver();
        System.out.println("solved with DFS:");
        System.out.println(newBoard);
        long t4 = System.nanoTime();
        System.out.println("Time: " + String.valueOf(t4 - t3));

        /*The recursive is way faster for my code incomparation to DFS, I think that
        * DFS was slower because it has to store each of how it changes from stacks to list
        * and list to stacks to it might affect the time, I don't quite understand however because both
        * the DFS and recursive should be using O( n * m) my code however shows that it is way faster to
        * to use recursive*/
    }

}
