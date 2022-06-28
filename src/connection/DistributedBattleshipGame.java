package connection;

import GameUnit.*;

public class DistributedBattleshipGame extends BattleshipGame {
    public DistributedBattleshipGame(int boardSize, int numberOfShips) {
        super(boardSize, numberOfShips);
    }

    @Override
    public boolean shoot(Board ownBoard, Board opponentBoard, int x, int y) throws OutOfBoardException, AlreadyPlacedException {
        if(checkIfOutside(ownBoard, x, y)){
            throw new OutOfBoardException();
        }
        if(opponentBoard.getBoard()[x][y] != Symbol.WATER.getSymbol()){
            throw new AlreadyPlacedException();
        }
        if(ownBoard.getBoard()[x][y] == Symbol.SHIP.getSymbol()){
            ownBoard.getBoard()[x][y] = Symbol.HIT.getSymbol();
            ownBoard.hitShip();
            return true;
        }else{
            ownBoard.getBoard()[x][y] = Symbol.MISS.getSymbol();
            return false;
        }
    }
}
