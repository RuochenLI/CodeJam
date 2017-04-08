package codejam.codejam2017.qualificationRound;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 08/04/2017.
 */
public class BathroomStallsTest {

    @Test
    public void testCase1() {
        assertEquals("1 0", new BathroomStalls().findSolution(4, 2));
    }

    @Test
    public void testCase2() {
        assertEquals("1 0", new BathroomStalls().findSolution(5, 2));
    }

    @Test
    public void testCase3() {
        assertEquals("1 1", new BathroomStalls().findSolution(6, 2));
    }

    @Test
    public void testCase4() {
        assertEquals("0 0", new BathroomStalls().findSolution(1000, 1000));
    }

    @Test
    public void testCase5() {
        assertEquals("500 499", new BathroomStalls().findSolution(1000, 1));
    }

}