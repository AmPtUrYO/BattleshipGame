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
}
