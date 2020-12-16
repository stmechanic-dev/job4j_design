package generic;

import java.util.ArrayList;
import java.util.List;

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
        }
        mem.set(n, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int n = findByIndex(id);
        if (n == -1) {
            return false;
        }
        mem.remove(n);
        return true;
    }

    @Override
    public T findById(String id) {
        int n = findByIndex(id);
        if (n != -1) {
            return mem.get(n);
        }
        return null;
    }

    private int findByIndex(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
