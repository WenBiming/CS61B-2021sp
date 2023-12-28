package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSingle() {
        IntList lst1 = IntList.of(23);
        boolean changed1 = IntListExercises.squarePrimes(lst1);
        assertEquals("529", lst1.toString());
        assertTrue(changed1);

        IntList lst2 = IntList.of(22);
        boolean changed2 = IntListExercises.squarePrimes(lst2);
        assertEquals("22", lst2.toString());
        assertFalse(changed2);
    }
    @Test
    public void testSquarePrimesMore() {
        IntList lst = IntList.of(14, 17, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 289 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }
}
