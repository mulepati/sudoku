import java.util.List;
import java.util.Stack;

public class DFSSolver extends solveBoard {


    public DFSSolver(int[][] newBoard) {
        super(newBoard);
    }

    public int[][] solveBoard(int[][] board2){
        DFSSolver boardForStack = new DFSSolver(board2);
        Stack<int[][]> boardStack = stackNeighbors(boardForStack);

        while(!boardStack.empty()) {
            int[][] boardPop = boardStack.pop();
            DFSSolver newBoard = new DFSSolver(boardPop);

            if(newBoard.isSolved()) {
                return boardPop;
            }

            for(int[][] boardNeighbors: newBoard.getNeighbors()) {
                if(!boardStack.contains(boardNeighbors)) {
                    boardStack.add(boardNeighbors);
                }

            }

        }

        return null;
    }

    private Stack<int[][]> stackNeighbors(DFSSolver board) {
        Stack<int[][]> boardStack = new Stack<>();

        List<int[][]> boards = board.getNeighbors();
        for(int[][] b: boards) {
            boardStack.push(b);
        }

        return boardStack;
    }


}
