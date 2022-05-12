import GameUnit.Board;
import GameUnit.Ship;
import GameUnit.Symbol;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorsTest {
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
