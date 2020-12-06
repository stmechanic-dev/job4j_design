package generic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int n = findByIndex(id);
        if (n == -1) {
            return false;
        } else {
            mem.set(n, model);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        int n = findByIndex(id);
        if (n == -1) {
            return false;
        } else {
            mem.remove(n);
            return true;
        }
    }

    @Override
    public T findById(String id) {
        int n = findByIndex(id);
        if (n != -1) {
            return mem.get(n);
        } else {
            throw new NoSuchElementException("Incorrect id!");
        }
    }

    private int findByIndex(String id) {
        return mem.stream()
                .map(Base::getId)
                .map(x -> x.indexOf(id))
                .findFirst()
                .orElse(-1);
    }
}
