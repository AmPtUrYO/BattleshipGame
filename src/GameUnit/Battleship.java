package GameUnit;

public class Battleship implements GameUI{
    public static void main(String[] args) {

    }

    public void placeShip(Board board, Ship ship, int x, int y)
            throws AlreadyPlacedException, OutOfBoardException {
        // horizontal
        if (y + ship.getLength() > board.getBoard().length || y < 0) {
            throw new OutOfBoardException();
        }
        if(board.getBoard()[x][y] != '~'){ // für gesamte Länge
            throw new AlreadyPlacedException();
        }

        for (int i = 0; i < ship.getLength(); i++) {
            board.getBoard()[x][y + i] = '#';
        }
        // vertical?
    }

    public boolean shoot(Board ownBoard, Board opponentBoard, int x, int y)
            throws OutOfBoardException, AlreadyPlacedException{
        if(x >= ownBoard.getBoard().length){
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

    public int charToInt(char y){
        return (int) y - 65;
    }

}
