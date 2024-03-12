package lab08.lab08;

import java.util.Iterator;
public class LinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, first);
        first = newNode;
        if (last == null) {
            last = newNode;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
