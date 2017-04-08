package codejam.codejam2017.qualificationRound;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 08/04/2017.
 */
public class OversizePancakeFlipperTest {

    @Test
    public void testCase1() {
        assertEquals("3", new OversizedPancakeFlipper().findSolution("---+-++-", 3));
    }

    @Test
    public void testCase2() {
        assertEquals("0", new OversizedPancakeFlipper().findSolution("+++++", 4));
    }

    @Test
    public void testCase3() {
        assertEquals("IMPOSSIBLE", new OversizedPancakeFlipper().findSolution("-+-+-", 4));
    }

    @Test
    public void testCase4() {
        assertEquals("3", new OversizedPancakeFlipper().findSolution("-+-+-", 3));
    }
}
