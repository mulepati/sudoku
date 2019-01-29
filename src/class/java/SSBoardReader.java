import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SSBoardReader implements BoardReader {
    private int[][] arrayRows = new int[9][9];
//    private int[][] arrayColumn = new int[9][9];
//    private int[][] arrayGrid = new int[9][9];

    public SSBoardReader(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));

        int i = 0;
        while(input.hasNextLine()) {
            char[] row;
            int x = 0;
            boolean containsDash = false;
            row = input.nextLine().toCharArray();

            for (int j = 0; j < row.length; j++) {
                if(row[j] == '.' && i < 10) {
                    arrayRows[i][x] = 0;
                    x++;
                } else if(row[j] == '|'){
                    //do nothing
                } else if(row[j] == '-') {
                    containsDash = true;
                }else {
                    arrayRows[i][x] = Character.getNumericValue(row[j]);
                    x++;
                }
            }
            i++;

            if(containsDash) {
                i--;
            }
        }
    }

    public int[][] readBoard() {
        return arrayRows;
    }
}
