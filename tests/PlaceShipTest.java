import GameUnit.*;
import org.junit.Assert;
import org.junit.Test;

public class PlaceShipTest {
    @Test
    public void placeShip() throws AlreadyPlacedException, OutOfBoardException {
        BattleshipGame game = new BattleshipGame(10, 1);
        Board testBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(testBoard,testShip,0,0);
        char[][] a = {{'#','#','#','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',}};
        Assert.assertArrayEquals(a, testBoard.getBoard());
        Assert.assertEquals(3, testBoard.shipsLeft());
    }

    @Test
    public void placeTwoShips() throws AlreadyPlacedException, OutOfBoardException{
        BattleshipGame game = new BattleshipGame(10, 1);
        Board testBoard = new Board(10);
        Ship testShip = new Ship(3);
        Ship testShip2 = new Ship(3);
        game.placeShip(testBoard,testShip,0,0);
        game.placeShip(testBoard,testShip2,0,3);
        char[][] a = {{'#','#','#','#','#','#','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',},
                {'~','~','~','~','~','~','~','~','~','~',}};
        Assert.assertArrayEquals(a, testBoard.getBoard());
        Assert.assertEquals(6, testBoard.shipsLeft());
    }

    @Test (expected = AlreadyPlacedException.class)
    public void placeTwoShipsOnTop() throws AlreadyPlacedException, OutOfBoardException {
        BattleshipGame game = new BattleshipGame(10, 1);
        Board testBoard = new Board(10);
        Ship testShip = new Ship(3);
        Ship testShip2 = new Ship(3);
        game.placeShip(testBoard, testShip, 0, 0);
        game.placeShip(testBoard, testShip2, 0, 2);
    }

    @Test (expected = OutOfBoardException.class)
    public void placeShipOutside() throws AlreadyPlacedException, OutOfBoardException {
        BattleshipGame game = new BattleshipGame(10, 1);
        Board testBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(testBoard, testShip, 0, 7);
    }

    @Test (expected = OutOfBoardException.class)
    public void placeShipOutside2() throws AlreadyPlacedException, OutOfBoardException {
        BattleshipGame game = new BattleshipGame(10, 1);
        Board testBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(testBoard, testShip, 10, 0);
    }

    @Test
    public void placeShipOutside3() throws AlreadyPlacedException, OutOfBoardException{

    }

}
