package codejam.codejam2017.round1B;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 22/04/2017.
 */
public class CruiseControlTest {

    @Test
    public void testCase1() {
        assertEquals("101,000000", new CruiseControl().calculateSpeed(2525, 1, Collections.singletonList(2400L), Collections.singletonList(5)));
    }

    @Test
    public void testCase2() {
        assertEquals("100,000000", new CruiseControl().calculateSpeed(300, 2, Arrays.asList(120L, 60L), Arrays.asList(60, 90)));
    }

    @Test
    public void testCase3() {
        assertEquals("33,333333", new CruiseControl().calculateSpeed(100, 2, Arrays.asList(80L, 70L), Arrays.asList(100, 10)));
    }

}