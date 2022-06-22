package GameUnit;
import java.util.Arrays;

public class Board {
    private final char[][] gameBoard;
    private int boardSize;
    private int ships = 0;

    public Board(int boardSize) {
        //Exeption: size restrictions
        this.boardSize = boardSize;
        gameBoard = new char[boardSize][boardSize];
        addWater();
    }

    private void addWater() {
        for (char[] row : gameBoard) {
            Arrays.fill(row, Symbol.WATER.getSymbol());
        }
    }

    public char[][] getBoard() {
        return gameBoard;
    }

    public void displayBoard() {
        char c = 'A';
        System.out.print("   ");
        for (int j = 0; j < gameBoard.length; j++) {
            System.out.printf("%-3s", c);
            c++;
        }
        System.out.println();
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.printf("%-3s", i + 1);
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.printf("%-3s", gameBoard[i][j]);
                //System.out.print("  ");
            }
            System.out.println("");
        }
    }

    public int shipsLeft(){
        return ships;
    }

    public void addShips(int length){
        this.ships += length;
    }

    public void hitShip(){
        this.ships--;
    }

    public int getBoardSize(){return boardSize;}
}
