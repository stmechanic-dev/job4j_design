package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[10];
    private int point;
    private int count = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    public void add(T model) {
        if (count == container.length) {
            expand();
        }
        container[count++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedCount = modCount;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[point++];
            }
        };
    }

    private void expand() {
        Object[] tmp = container;
        container = new Object[count * 2];
        System.arraycopy(tmp, 0, container, 0, container.length);
    }
}
