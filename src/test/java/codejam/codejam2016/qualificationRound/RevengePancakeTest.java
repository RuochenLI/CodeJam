package codejam.codejam2016.qualificationRound;import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 09/04/2016.
 */
public class RevengePancakeTest {

    @Test
    public void testrevengePancake() {
        assertEquals(1, RevengePancake.getMinTime(new LinkedList<>(Arrays.asList('-')), 0));

    }

    @Test
    public void testrevengePancake1() {
        assertEquals(1, RevengePancake.getMinTime(new LinkedList<>(Arrays.asList('-', '+')), 0));

    }

    @Test
    public void testrevengePancake2() {
        assertEquals(2, RevengePancake.getMinTime(new LinkedList<>(Arrays.asList('+', '-')), 0));

    }

    @Test
    public void testrevengePancake3() {
        assertEquals(0, RevengePancake.getMinTime(new LinkedList<>(Arrays.asList('+', '+', '+')), 0));

    }
    @Test
    public void testrevengePancake4() {
        assertEquals(3, RevengePancake.getMinTime(new LinkedList<>(Arrays.asList('-', '-', '+', '-')), 0));

    }

    @Test
    public void testrevengePancake5() {
        assertEquals(5, RevengePancake.getMinTime(new LinkedList<>(Arrays.asList('-', '-', '+', '-', '+', '-', '-', '+')), 0));

    }

    @Test
    public void testrevengePancake6() {
        assertEquals(4, RevengePancake.getMinTime(new LinkedList<>(Arrays.asList('+', '-', '+', '+', '+', '-')), 0));

    }
}
