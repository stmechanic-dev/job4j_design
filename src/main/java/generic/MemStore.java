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
        try {
            int n = Integer.parseInt(id);
            mem.set(n, model);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect string format!");
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try {
            int n = Integer.parseInt(id);
            mem.remove(n);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect string format!");
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int n = 0;
        try {
            n = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect string format!");
        }
        return mem.get(n);
    }
}
