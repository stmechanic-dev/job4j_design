package set;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddThanFalse() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertThat(set.add(2), Is.is(false));
    }

    @Test
    public void whenAddNullElement() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(null);
        assertThat(set.add(null), Is.is(false));
    }
}