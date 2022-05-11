import GameUnit.*;
import org.junit.Assert;
import org.junit.Test;

public class BattleshipTest {
    @Test
    public void test() {}

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
    public void testGame() throws AlreadyPlacedException, OutOfBoardException {
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
    public void testShoot() throws AlreadyPlacedException, OutOfBoardException{
        Battleship game = new Battleship();
        Board ownBoard = new Board(10);
        Board opponentBoard = new Board(10);
        Ship testShip = new Ship(3);
        game.placeShip(opponentBoard,testShip,0,0);
        game.shoot(opponentBoard, ownBoard,0,0);
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
}
