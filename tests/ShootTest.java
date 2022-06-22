import GameUnit.*;
import org.junit.Assert;
import org.junit.Test;

public class ShootTest {
    @Test
    public void testShootHit() throws AlreadyPlacedException, OutOfBoardException {
        BattleshipGame game = new BattleshipGame(10, 1);
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(opponentBoard,testShip,0,0);
        game.shoot(ownBoard,opponentBoard,0,0);
        char[][] own = {{'X','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',}};
        char[][] opponent = {{'X','#','#','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',}};
        Assert.assertArrayEquals(own, ownBoard.getBoard());
        Assert.assertArrayEquals(opponent, opponentBoard.getBoard());
    }

    @Test
    public void testShootMiss() throws AlreadyPlacedException, OutOfBoardException{
        BattleshipGame game = new BattleshipGame(10, 1);
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(opponentBoard,testShip,0,0);
        game.shoot(ownBoard,opponentBoard,1,0);
        char[][] own = {{'~','~','~','~','~','~','~','~','~','~',},
                {'o','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',}};
        char[][] opponent = {{'#','#','#','~','~','~','~','~','~','~',},
                {'o','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',}};
        Assert.assertArrayEquals(own, ownBoard.getBoard());
        Assert.assertArrayEquals(opponent, opponentBoard.getBoard());
    }

    @Test (expected = AlreadyPlacedException.class)
    public void testShootAlreadyPlaced() throws AlreadyPlacedException, OutOfBoardException {
        BattleshipGame game = new BattleshipGame(10, 1);
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(opponentBoard, testShip, 0, 0);
        game.shoot(ownBoard, opponentBoard, 0, 0);
        game.shoot(ownBoard, opponentBoard, 0, 0);
        Assert.fail();
    }

    @Test (expected = OutOfBoardException.class)
    public void testShootOutOfBoard() throws AlreadyPlacedException, OutOfBoardException{
        BattleshipGame game = new BattleshipGame(10, 1);
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        game.shoot(opponentBoard, ownBoard,10,0);
        Assert.fail();
    }

    @Test (expected = OutOfBoardException.class)
    public void testShootOutOfBoard2() throws AlreadyPlacedException, OutOfBoardException{
        BattleshipGame game = new BattleshipGame(10, 1);
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        game.shoot(opponentBoard, ownBoard,0,10);
        Assert.fail();
    }
}
