package GameUnit;

public class BattleshipGame implements GameUI{

    private final Player player1;
    private final Player player2;

    public BattleshipGame (int boardSize, int numberOfShips){
        this.player1 = new Player(boardSize, numberOfShips);
        this.player2 = new Player(boardSize, numberOfShips);
    }

    public void placeShip(Board board, Ship ship, int x, int y)
            throws AlreadyPlacedException, OutOfBoardException {
        // horizontal
        if (checkIfOutside(board, x, y + ship.getLength())) {
            throw new OutOfBoardException();
        }
        if(board.getBoard()[x][y] != '~' || board.getBoard()[x][y + ship.getLength()] != '~' ){
            throw new AlreadyPlacedException();
        }

        for (int i = 0; i < ship.getLength(); i++) {
            board.getBoard()[x][y + i] = '#';
        }
        board.addShips(ship.getLength());
        // vertical? adjust AlreadyPlacedException for horizontal
    }

    public boolean shoot(Board ownBoard, Board opponentBoard, int x, int y)
            throws OutOfBoardException, AlreadyPlacedException{
        if(checkIfOutside(ownBoard, x, y)){
            throw new OutOfBoardException();
        }
        if(ownBoard.getBoard()[x][y] != Symbol.WATER.getSymbol()){
            throw new AlreadyPlacedException();
        }
        if(opponentBoard.getBoard()[x][y] == Symbol.SHIP.getSymbol()){
            ownBoard.getBoard()[x][y] = Symbol.HIT.getSymbol();
            opponentBoard.getBoard()[x][y] = Symbol.HIT.getSymbol();
            opponentBoard.hitShip();
            return true;
        }else{
            ownBoard.getBoard()[x][y] = Symbol.MISS.getSymbol();
            opponentBoard.getBoard()[x][y] = Symbol.MISS.getSymbol();
            return false;
        }

    }

    private static boolean checkIfOutside(Board board, int x, int y){
        return (x >= board.getBoard().length) || (y >= board.getBoard().length);
    }

    public Player getPlayer(int number) {
        if(number == 1){
            return player1;
        }else if(number == 2){
            return player2;
        }else{
            return player1;
        }
    }

}
