import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class Board {

    //this is an array of an int array that contains 9 int arrays.
    private int[][] arrayRows = new int[9][];

    public Board(String file) throws FileNotFoundException{
        Scanner input = new Scanner(new File(file));

        //the variable x if for each row and increases every time a row is added to the arrayRows array.
        int x = 0;
        while(input.hasNextLine()) {
            char[] row;
            int[] rowInt = new int[9];

            row = input.nextLine().toCharArray();

            //this for loop is to create an array of integers that will be added to the arrayrow from the array of characters
            for (int j = 0; j < row.length; j++) {
                if(row[j] == '.') {
                    rowInt[j] = 0;
                } else {
                    rowInt[j] = Character.getNumericValue(row[j]);
                }
            }

            arrayRows[x] = rowInt.clone();
            x++;
        }
    }

    public String toString() {
        String myBoard = "";
        //this for loop addeds each line of the array row on to a string to create the sudoku board.
        for (int i = 0; i < arrayRows.length; i++) {
            myBoard += "\n" + Arrays.toString(arrayRows[i]);
        }
        return myBoard;

    }
    //I tried, do I need to do it any other way?

}
