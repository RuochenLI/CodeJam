package codejam.codejam2016.qualificationRound;import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruochen on 09/04/2016.
 */
public class CountingSleepTest {

    @Test
    public void testZero() {
        Assert.assertEquals("INSOMNIA", CountingSleep.count(0));
    }

    @Test
    public void testCase2(){
        Assert.assertEquals("10", CountingSleep.count(1));
    }

    @Test
    public void testCase3(){
        Assert.assertEquals("90", CountingSleep.count(2));
    }

    @Test
    public void testCase4(){
        Assert.assertEquals("110", CountingSleep.count(11));
    }

    @Test
    public void testCase5(){
        Assert.assertEquals("5076", CountingSleep.count(1692));
    }

}
