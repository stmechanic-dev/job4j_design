package list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleListTest {

    @Test
    public void whenSimpleListAddThenGet() {
        SimpleList<String> list = new SimpleList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        assertThat(list.get(1), is("second"));
        assertThat(list.get(0), is("first"));
        assertThat(list.get(2), is("third"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleList<String> list = new SimpleList<>();
        list.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleList<String> list = new SimpleList<>();
        list.add("first");
        Iterator<String> it = list.iterator();
        list.add("second");
        it.next();
    }
}