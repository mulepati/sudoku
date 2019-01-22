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
        Map<Integer, Boolean> rowMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 9; i++) {
            for(int cell : boardRows[i]){
                if(rowMap.containsKey(cell) && cell != 0){
                    rowMap.put(cell, false);
                    return false;
                } else if(rowMap.containsKey(cell) && cell == 0){
                    rowMap.put(cell, true);
                    return false;
                }else{
                    rowMap.put(cell, true);
                }
            }
            rowMap.clear();
        }

        return true;
    }

    private boolean solvedColumn() {
        Map<Integer, Boolean> columnMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(columnMap.containsKey(boardRows[j][i]) && boardRows[j][i] != 0){
                    columnMap.put(boardRows[j][i], false);
                    return false;
                } else if(columnMap.containsKey(boardRows[j][i]) && boardRows[j][i] == 0){
                    columnMap.put(boardRows[j][i], true);
                    return false;
                }else{
                    columnMap.put(boardRows[j][i], true);
                }
            }
            columnMap.clear();
        }

        return true;

    }

    private boolean solvedGrid() {
        Map<Integer, Boolean> gridMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(gridMap.containsKey(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
                            return false;
                        } else if(gridMap.containsKey(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
                            gridMap.put(boardRows[i+k][j+l], true);
                            return false;
                        } else {
                            gridMap.put(boardRows[i+k][j+l], true);
                        }

                    }

                }
                gridMap.clear();

            }

        }

        return true;
    }

    private boolean validRow(){
        Map<Integer, Boolean> rowMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 9; i++) {
            for(int cell : boardRows[i]){
                if(rowMap.containsKey(cell) && cell != 0){
                    rowMap.put(cell, false);
                    return false;
                } else if(rowMap.containsKey(cell) && cell == 0){
                    rowMap.put(cell, true);
                }else{
                    rowMap.put(cell, true);
                }
            }
            rowMap.clear();
        }

        return true;
    }

    private boolean validColumn() {
        Map<Integer, Boolean> columnMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(columnMap.containsKey(boardRows[j][i]) && boardRows[j][i] != 0){
                    columnMap.put(boardRows[j][i], false);
                    return false;
                } else if(columnMap.containsKey(boardRows[j][i]) && boardRows[j][i] == 0){
                    columnMap.put(boardRows[j][i], true);
                }else{
                    columnMap.put(boardRows[j][i], true);
                }
            }
            columnMap.clear();
        }

        return true;
    }

    private boolean validGrid() {
        Map<Integer, Boolean> gridMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(gridMap.containsKey(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
                            return false;
                        } else if(gridMap.containsKey(boardRows[i+k][j+l]) && boardRows[i+k][j+l] != 0){
                            gridMap.put(boardRows[i+k][j+l], true);
                        } else {
                            gridMap.put(boardRows[i+k][j+l], true);
                        }

                    }

                }
                gridMap.clear();

            }

        }

        return true;

    }


}

