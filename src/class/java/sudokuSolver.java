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


        long t1 = System.nanoTime();
        newBoard2.recursiveSolve();
        long t2 = System.nanoTime();
        System.out.println("solved with recursives:");
        System.out.println(newBoard2);
        System.out.println("Time Recursive: " + String.valueOf(t2 - t1));

        System.out.println();

        long t3 = System.nanoTime();
        newBoard.dFSSolver();
        long t4 = System.nanoTime();
        System.out.println("solved with DFS:");
        System.out.println(newBoard);
        System.out.println("Time DFS: " + String.valueOf(t4 - t3));

        /*The DFS is faster, I believe that because of the use of stacks
        * while DFS has time complexity of O(e + v) recursive however has a time
        * completixy of O(n * m) so one has a better time complex which is why it might be faster.
        * That is the only thing I can think of.*/
    }

}
