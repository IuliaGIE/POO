package lab7;

import java.util.*;

class LinkedSet<E> extends LinkedList<E> implements Set<E> {
    @Override
    public boolean add(E obj) {
        if (!contains(obj)) {
            return super.add(obj);
        }
        return false;
    }

    @Override
    public void add(int i, E obj) {
        if (!contains(obj)) {
            super.add(i, obj);
        }
    }

    @Override
    public E set(int i, E obj) {
        if (!contains(obj)) {
            return super.set(i, obj);
        }
        return obj;
    }
}
