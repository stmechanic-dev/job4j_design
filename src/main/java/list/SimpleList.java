package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleList<E> implements Iterable<E> {
    private Node<E> head;
    private int modCount = 0;

    public void add(E value) {
        Node<E> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            modCount++;
            return;
        }
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, modCount);
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        int expectedCount = modCount;
        return new Iterator<>() {
            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E value = node.item;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
