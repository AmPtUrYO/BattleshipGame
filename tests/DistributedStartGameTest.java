import connection.DistributedStartGame;
import org.junit.Assert;
import org.junit.Test;

public class DistributedStartGameTest {

    @Test
    public void intToStringToInt1 (){
        int[] numbers = {'0', '0'};
        String string = DistributedStartGame.intToString(numbers);
        int[] test = DistributedStartGame.stringToInt(string);
        Assert.assertArrayEquals(numbers, test);
    }
}
