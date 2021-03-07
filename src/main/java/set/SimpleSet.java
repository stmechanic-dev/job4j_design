package set;

import list.SimpleArray;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> set = new SimpleArray<>();
    private int countSize = 0;
    private int point = 0;

    public boolean add(E e) {
        for (int i = 0; i < countSize; i++) {
            if (Objects.isNull(e)) {
                if (null == set.get(i)) {
                    return false;
                }
            } else if (e.equals(set.get(i))) {
                return false;
            }
        }
        set.add(e);
        countSize++;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return point < countSize;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return set.get(point++);
            }
        };
    }
}
