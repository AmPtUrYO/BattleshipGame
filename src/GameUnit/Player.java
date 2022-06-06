package GameUnit;

public class Player {
    private Board ownBoard;
    private Board opponentBoard;
    public Ship[] ships;

    public Player(int boardSize, int numberOfShips){
        ownBoard = new Board(boardSize);
        opponentBoard = new Board(boardSize);
        ships = new Ship[numberOfShips];
        for (int i = 0; i < numberOfShips; i++){
            ships[i] = new Ship(i + 2);
        }
    }

    public Board getOwnBoard(){
        return ownBoard;
    }

    public Board getOpponentBoard(){
        return opponentBoard;
    }

    public Ship[] getShips() {
        return ships;
    }
}
