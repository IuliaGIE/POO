package lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SListSet extends LinkedList<Object> implements SortedSet<Object> {

    private Comparator<Object> comparator;

    public SListSet() {
        this.comparator = null;
    }

    public SListSet(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator<Object> comparator() {
        return comparator;
    }

    @Override
    public boolean add(Object o) {
        if (!contains(o)) {
            super.add(o);
            Collections.sort(this, comparator);
            return true;
        }
        return false;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return get(0);
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return get(size() - 1);
    }

    @Override
    public SortedSet<Object> subSet(Object from, Object to) {
        SListSet subSet = new SListSet(comparator);
        for (Object element : this) {
            if (comparator.compare(element, from) >= 0 && comparator.compare(element, to) < 0) {
                subSet.add(element);
            }
        }
        return subSet;
    }

    @Override
    public SortedSet<Object> headSet(Object to) {
        SListSet headSet = new SListSet(comparator);
        for (Object element : this) {
            if (comparator.compare(element, to) < 0) {
                headSet.add(element);
            } else {
                break;
            }
        }
        return headSet;
    }

    @Override
    public SortedSet<Object> tailSet(Object from) {
        SListSet tailSet = new SListSet(comparator);
        boolean startAdding = false;
        for (Object element : this) {
            if (comparator.compare(element, from) >= 0) {
                startAdding = true;
            }
            if (startAdding) {
                tailSet.add(element);
            }
        }
        return tailSet;
    }

    public static void main(String[] args) {
        SListSet wordSet = new SListSet();

        try (BufferedReader br = new BufferedReader(new FileReader("lab7/test01.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[\\s\\p{Punct}]+");
                for (String word : words) {
                    wordSet.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Distincte în ordine crescatoare: ");
        for (Object word : wordSet) {
            System.out.println(word);
        }

        System.out.println("\n");
        System.out.println("Distincte în ordine descrescatoare: ");
        SListSet descWordSet = new SListSet(Collections.reverseOrder());
        descWordSet.addAll(wordSet);
        for (Object word : descWordSet) {
            System.out.println(word);
        }
    }
}