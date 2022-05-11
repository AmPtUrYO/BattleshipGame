package GameUnit;

public class Battleship implements GameUI{
    public static void main(String[] args) {

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
            return true;
        }else{
            ownBoard.getBoard()[x][y] = Symbol.MISS.getSymbol();
            opponentBoard.getBoard()[x][y] = Symbol.MISS.getSymbol();
            return false;
        }

    }

    public int charToInt(char y){ // in App?
        return (int) y - 65;
    }

    private static boolean checkIfOutside(Board board, int x, int y){
        return (x >= board.getBoard().length) || (y >= board.getBoard().length) || x < 0 || y < 0;
    }

}
