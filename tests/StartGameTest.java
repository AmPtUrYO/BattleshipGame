import GameUnit.OutOfBoardException;
import GameUnit.StartGame;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static GameUnit.StartGame.charToInt;
import static GameUnit.StartGame.getUserInput;

public class StartGameTest {

    @Test
    public void testCharToIntA(){
        int test = charToInt('A');
        Assert.assertEquals(0, test);
    }

    @Test
    public void testCharToIntB(){
        int test = charToInt('B');
        Assert.assertEquals(1, test);
    }

    @Test
    public void testCharToIntC(){
        int test = charToInt('C');
        Assert.assertEquals(2, test);
    }

    @Test
    public void testCharToIntD(){
        int test = charToInt('D');
        Assert.assertEquals(3, test);
    }

    @Test
    public void testCharToIntE(){
        int test = charToInt('E');
        Assert.assertEquals(4, test);
    }

    @Test
    public void testCharToIntZ(){
        int test = charToInt('Z');
        Assert.assertEquals(25, test);
    }

    @Test
    public void testGetUserInput1(){
        String data = "A1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int[] test = getUserInput();
        Assert.assertArrayEquals(new int[] {0,0}, test);
    }

    @Test
    public void testGetUserInput2(){
        String data = "a1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int[] test = getUserInput();
        Assert.assertArrayEquals(new int[] {0,0}, test);
    }

}
