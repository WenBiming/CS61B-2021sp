package DebugExercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class DebugExerciseTest {
    @Test
    public void testDivideThenRound1() {
        int a = 10, b = 4;
        int expected = 3;
        int actual = DebugExercise1.divideThenRound(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testArrayMax() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {-1, -2, -3, -4, -5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = DebugExercise2.arrayMax(a, b);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testArraySum() {
        int[] a = {1, 2, -1, -2};
        int expected = 0;
        int acutal = DebugExercise2.arraySum(a);
        assertEquals(expected, acutal);
    }
}
