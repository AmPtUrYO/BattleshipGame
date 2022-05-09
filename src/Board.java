import java.util.Arrays;

public class Board {
    private final char[][] gameBoard;
    private int boardSize;

    public Board(int boardSize) {
        //Exeption: size restrictions
        this.boardSize = boardSize;
        gameBoard = new char[boardSize][boardSize];
        addWater();
    }

    private void addWater() {
        for (char[] row : gameBoard) {
            Arrays.fill(row, '~');
        }
    }

    public char[][] getBoard() {
        return gameBoard;
    }
}
