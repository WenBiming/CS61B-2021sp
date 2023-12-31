package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        cmp = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        }
        T res = this.get(0);
        for (int i = 0; i < size(); i++) {
            if (cmp.compare(res, get(i)) < 0) {
                res = get(i);
            }

        }

        return res;
    }

    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        }

        T res = this.get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(res, get(i)) < 0) {
                res = get(i);
            }

        }

        return res;
    }
}
