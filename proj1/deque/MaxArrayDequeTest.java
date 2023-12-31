package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void maxNoArgTest() {
        MaxArrayDeque<Double> a = new MaxArrayDeque<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 10; i >= 0; i --)
            a.addFirst(i * 1.0);

        Double actual = 10.0;
        Double expect = a.max();
        assertEquals(actual, expect);
    }

    @Test
    public void maxArgTest() {
        MaxArrayDeque<Integer> a = new MaxArrayDeque<>(null);
        for (int i = 10; i >= 0; i --)
            a.addFirst(i);
        int actual = 10;
        int expect = a.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        assertEquals(actual, expect);
    }
}
