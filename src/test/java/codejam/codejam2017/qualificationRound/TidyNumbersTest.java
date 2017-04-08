package codejam.codejam2017.qualificationRound;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 08/04/2017.
 */
public class TidyNumbersTest {

    @Test
    public void testcase1() {
        assertEquals("129", new TidyNumbers().findTinyNumber("132"));
    }

    @Test
    public void testcase2() {
        assertEquals("999", new TidyNumbers().findTinyNumber("1000"));
    }

    @Test
    public void testcase3() {
        assertEquals("7", new TidyNumbers().findTinyNumber("7"));
    }

    @Test
    public void testcase4() {
        assertEquals("99999999999999999", new TidyNumbers().findTinyNumber("111111111111111110"));
    }

    @Test
    public void testcase5() {
        assertEquals("111111111111111111", new TidyNumbers().findTinyNumber("111111111111111111"));
    }

    @Test
    public void testCase6() {
        assertEquals("299", new TidyNumbers().findTinyNumber("332"));
    }
}