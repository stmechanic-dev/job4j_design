package Generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] data;
    private int count = 0;

    public SimpleArray(T[] data) {
        this.data = data;
    }

    public void add(T model) {
        data[count] = model;
        count++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        data[index] = null;
        System.arraycopy(data, index + 1, data, index, count - 1);
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<>() {
            private int n = 0;

            @Override
            public boolean hasNext() {
                return n < count;
            }

            @Override
            public T next() {
                return data[n++];
            }
        };
        return it;
    }
}
