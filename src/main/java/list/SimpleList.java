package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleList<E> implements Iterable<E> {
    private Node[] container = new Node[10];
    Node<E> node;
    private int point;
    private int count = 0;
    private int modCount = 0;

    public E get(int index) {
        Objects.checkIndex(index, count);
        return (E) container[index];
    }

    public void add(E model) {
        if (count == container.length) {
            expand();
        }
        if (container[0] == null) {
            node = new Node<>(null, model, null);
        } else {
            node = new Node<E>(container[count - 1], model, null);
        }
        modCount++;

    }

    @Override
    public Iterator<E> iterator() {
        int expectedCount = modCount;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return container[point] != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[point++];
            }
        };
    }

    private void expand() {
        Object[] tmp = container;
        container = new Node[count * 2];
        System.arraycopy(tmp, 0, container, 0, container.length);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
