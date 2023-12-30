package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        for (int i = 4; i <= 6; i += 1) {
            a.addLast(i);
            b.addLast(i);
        }
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bl = new BuggyAList();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bl.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeBl = bl.size();
                assertEquals(size, sizeBl);
            } else if (operationNumber == 2) {
                if (L.size() == 0)
                    continue;
                int a = L.getLast();
                int lastBl = bl.getLast();
                assertEquals(a, lastBl);

                int sizeBefore = L.size();
                int sizelastBlBefore = bl.size();
                assertEquals(sizeBefore, sizelastBlBefore);

                L.removeLast();
                bl.removeLast();
                if (L.size() != 0)
                    assertEquals(L.getLast(), bl.getLast());
                assertEquals(L.size(), bl.size());

            }
        }
    }
}
