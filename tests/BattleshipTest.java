import GameUnit.*;
import org.junit.Assert;
import org.junit.Test;

public class BattleshipTest {

    @Test
    public void testBoard() {
        Board testBoard = new Board(10);
        char[][] a = {{'~','~','~','~','~','~','~','~','~','~',},
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
    }

    @Test
    public void testShip(){
        Ship testShip = new Ship(3);
        Assert.assertEquals(3, testShip.getLength());
    }

    @Test
    public void testPlaceShip() throws AlreadyPlacedException, OutOfBoardException {
        Battleship game = new Battleship();
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
    }

    @Test
    public void testPlaceTwoShips() throws AlreadyPlacedException, OutOfBoardException{
        Battleship game = new Battleship();
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
    }

    @Test (expected = AlreadyPlacedException.class)
    public void testPlaceTwoShipsOnTop() throws AlreadyPlacedException, OutOfBoardException {
        Battleship game = new Battleship();
        Board testBoard = new Board(10);
        Ship testShip = new Ship(3);
        Ship testShip2 = new Ship(3);
        game.placeShip(testBoard, testShip, 0, 0);
        game.placeShip(testBoard, testShip2, 0, 2);
    }

    @Test (expected = OutOfBoardException.class)
    public void testPlaceShipOutside() throws AlreadyPlacedException, OutOfBoardException {
        Battleship game = new Battleship();
        Board testBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(testBoard, testShip, 0, 7);
    }

    @Test
    public void testShootHit() throws AlreadyPlacedException, OutOfBoardException{
        Battleship game = new Battleship();
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
        Battleship game = new Battleship();
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
        Battleship game = new Battleship();
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(opponentBoard, testShip, 0, 0);
        game.shoot(ownBoard, opponentBoard, 0, 0);
        game.shoot(ownBoard, opponentBoard, 0, 0);
    }

    @Test (expected = OutOfBoardException.class)
    public void testShootOutOfBoard() throws AlreadyPlacedException, OutOfBoardException{
        Battleship game = new Battleship();
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        game.shoot(opponentBoard, ownBoard,10,0);
    }

    @Test (expected = OutOfBoardException.class)
    public void testShootOutOfBoard2() throws AlreadyPlacedException, OutOfBoardException{
        Battleship game = new Battleship();
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        game.shoot(opponentBoard, ownBoard,0,10);
    }

    @Test
    public void testSymbol(){
        char water = Symbol.WATER.getSymbol();
        char ship = Symbol.SHIP.getSymbol();
        char hit = Symbol.HIT.getSymbol();
        char miss = Symbol.MISS.getSymbol();
        Assert.assertEquals('~', water);
        Assert.assertEquals('#', ship);
        Assert.assertEquals('X', hit);
        Assert.assertEquals('o', miss);
    }
}
