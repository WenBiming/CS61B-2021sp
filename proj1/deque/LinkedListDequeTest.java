package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.LinkedList;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());
//
		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {



        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    public void testGetItem() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addFirst(1);
        lld1.addLast(2);
        int a = lld1.get(0);
        int b = lld1.get(1);
        assertEquals(a, 1);
        assertEquals(b,2);

        int c = lld1.getRecursive(0);
        int d = lld1.getRecursive(1);
        assertEquals(c, 1);
        assertEquals(d, 2);
    }
    @Test
    public void testGetItemLarge() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        final int N = 500;
        final int M = N * 2;
        for (int i = 0; i < M; i++) {
            lld1.addLast(i);
        }

        for (int i = 0; i < N; i++) {
            int x = lld1.get(i);
            assertEquals(i, x);
        }

        for (int i = M - 1; i > N; i--) {
            int x = lld1.get(i);
            assertEquals(i, x);
        }
    }

    @Test
    public void testEqual() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();

        final int M = 100;
        for (int i = 0; i < M; i++) {
            lld1.addLast(i);
            lld2.addLast(i);
        }
        assertTrue(lld1.equals(lld2));
        lld1.removeFirst();
        assertNotEquals(lld1, lld2);

        ArrayDeque<Integer> lld3 = new ArrayDeque<>();
        for (int i = 0; i < M; i ++) {
            lld3.addLast(i);
        }

        assertEquals(lld2, lld3);

    }

    @Test
    public void testIterator() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            a.addLast(i);
        }

        Iterator<Integer> it = a.iterator();
        for (int i = 0; i < 10; i++) {
            int x = it.next();
            assertEquals(x, i);
        }

        assertFalse(it.hasNext());
    }
    @Test
    public void testRandomized() {
        final int M = 100000;
        LinkedListDeque<Integer> testL = new LinkedListDeque<>();
        assertTrue(testL.isEmpty());
        LinkedList<Integer> correctL = new LinkedList<>();
        for (int i = 0; i < M; i ++) {
            int opNumber = StdRandom.uniform(0, 5);
            int randVal = StdRandom.uniform(0, 100);
            if (opNumber == 0) {
                correctL.addFirst(randVal);
                testL.addFirst(randVal);
            } else if(opNumber == 1) {
                correctL.addLast(randVal);
                testL.addLast(randVal);
            } else if(opNumber == 2) {
                if (testL.isEmpty())
                    continue;
                int a = correctL.removeFirst();
                int b = testL.removeFirst();
                assertEquals(a, b);

            } else if(opNumber == 3) {
                if (testL.isEmpty())
                    continue;
                int a = correctL.removeLast();
                int b = testL.removeLast();
                assertEquals(a, b);
            } else if (opNumber == 4) {
                if (testL.size() <= randVal)
                    continue;
                int a = correctL.get(randVal);
                int b = testL.get(randVal);
                assertEquals(a, b);
            }
        }
    }
}
