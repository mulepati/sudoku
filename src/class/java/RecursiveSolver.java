

public class RecursiveSolver extends solveBoard {

    public RecursiveSolver(int[][] newBoard){
        super(newBoard);
    }


    public int[][] solveBoard(int[][] board2){
        RecursiveSolver newBoard = new RecursiveSolver(board2);
        if(newBoard.isSolved()) {
            return board2;
        } else {
            for(int[][] boards: newBoard.getNeighbors()) {
                int[][] result = solveBoard(boards);
                if(result != null) {
                    return result;
                }
            }

        }
        return null;
    }

}
