import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MainBoard {
    private int[][] boardRows;

    public MainBoard(String file) throws FileNotFoundException {
        BoardReader newBoard = BoardFactory.getBoardReader(file);
        this.boardRows = newBoard.readBoard();
    }

    public boolean isValid() {
        if(validRow() && validColumn() && validGrid()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSolved() {
        if(solvedRow() && solvedColumn() && solvedGrid()) {
            return true;
        } else {
            return false;
        }
    }
    public String toString(){
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

    private boolean solvedRow() {
        Set<Integer> rowSet = new HashSet<Integer>();

        for (int i = 0; i < 9; i++) {
            for(int cell : boardRows[i]){
                if(rowSet.contains(cell) && cell != 0){
                    rowSet.add(cell);
                    return false;
                } else if(rowSet.contains(cell) && cell == 0){
                    rowSet.add(cell);
                    return false;
                }else{
                    rowSet.add(cell);
                }
            }
            rowSet.clear();
        }

        return true;
    }

    private boolean solvedColumn() {
        Set<Integer> columnSet = new HashSet<Integer>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(columnSet.contains(boardRows[j][i]) && boardRows[j][i] != 0){
                    columnSet.add(boardRows[j][i]);
                    return false;
                } else if(columnSet.contains(boardRows[j][i]) && boardRows[j][i] == 0){
                    columnSet.add(boardRows[j][i]);
                    return false;
                }else{
                    columnSet.add(boardRows[j][i]);
                }
            }
            columnSet.clear();
        }

        return true;

    }

    private boolean solvedGrid() {
        Set<Integer> gridSet = new HashSet<Integer>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(gridSet.contains(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
                            return false;
                        } else if(gridSet.contains(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
                            gridSet.add(boardRows[i+k][j+l]);
                            return false;
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

    private boolean validRow(){
        Set<Integer> rowSet = new HashSet<Integer>();

        for (int i = 0; i < 9; i++) {
            for(int cell : boardRows[i]){
                if(rowSet.contains(cell) && cell != 0){
                    rowSet.add(cell);
                    return false;
                } else if(rowSet.contains(cell) && cell == 0){
                    rowSet.add(cell);
                }else{
                    rowSet.add(cell);
                }
            }
            rowSet.clear();
        }

        return true;
    }

    private boolean validColumn() {
        Set<Integer> columnSet = new HashSet<Integer>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(columnSet.contains(boardRows[j][i]) && boardRows[j][i] != 0){
                    columnSet.add(boardRows[j][i]);
                    return false;
                } else if(columnSet.contains(boardRows[j][i]) && boardRows[j][i] == 0){
                    columnSet.add(boardRows[j][i]);
                }else{
                    columnSet.add(boardRows[j][i]);
                }
            }
            columnSet.clear();
        }

        return true;
    }

    private boolean validGrid() {
        Set<Integer> gridSet = new HashSet<Integer>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(gridSet.contains(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
                            return false;
                        } else if(gridSet.contains(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
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


}

