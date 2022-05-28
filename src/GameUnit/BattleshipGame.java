package GameUnit;

public class BattleshipGame implements GameUI{

    public Board player1Board;
    public Board player2Board;
    public Ship[] player1Ships;
    public Ship[] player2Ships;

    public BattleshipGame (int boardSize, int numberOfShips){
        player1Board = new Board(boardSize);
        player2Board = new Board(boardSize);
        player1Ships = new Ship[numberOfShips];
        player2Ships = new Ship[numberOfShips];
        for (int i = 0; i < numberOfShips; i++){
            player1Ships[i] = new Ship(i + 2);
            player2Ships[i] = new Ship(i + 2);
        }
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
        board.ships += ship.getLength();
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
            opponentBoard.ships--;
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

}
