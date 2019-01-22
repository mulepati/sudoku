import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class Board implements BoardReader{

    //this is an array of an int array that contains 9 int arrays.
    private int[][] arrayRows = new int[9][9];

    public Board(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));

        //the variable x if for each row and increases every time a row is added to the arrayRows array.
        int i = 0;
        while(input.hasNextLine()) {
            char[] row;

            row = input.nextLine().toCharArray();

            //this for loop is to create an array of integers that will be added to the arrayrow from the array of characters
            for (int j = 0; j < row.length; j++) {
                if(row[j] == '.') {
                    arrayRows[i][j] = 0;
                } else {
                    arrayRows[i][j] = Character.getNumericValue(row[j]);
                }
            }

            i++;
        }
    }

    public String toString() {
        StringBuilder myBoard = new StringBuilder();
        //this for loop addeds each line of the array row on to a string to create the sudoku board.
        for (int i = 0; i < arrayRows.length; i++) {
            myBoard.append("\n" + Arrays.toString(arrayRows[i]));
        }
        return myBoard.toString();

    }

}
