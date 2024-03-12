package lab12;

import java.util.ArrayList;
import java.util.Collections;

public class GenericListMethods implements GenericInterface {

    @Override
    public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (list.isEmpty()) {
            return null;
        }
        return Collections.max(list);
    }

    @Override
    public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (list.get(mid).compareTo(key) == 0) {
            return mid;
        } else if (list.get(mid).compareTo(key) > 0) {
            return binarySearch(list, key, start, mid - 1);
        } else {
            return binarySearch(list, key, mid + 1, end);
        }
    }
    public static void main(String[] args) {
        GenericListMethods methods = new GenericListMethods();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        ArrayList<Integer> noDuplicates = methods.removeDuplicates(list);
        System.out.println(noDuplicates); // [1, 2, 3]

        int max = methods.max(list);
        System.out.println(max); // 3

        int position = methods.binarySearch(list, 2, 0, list.size() - 1);
        System.out.println(position); // 1

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Ana");
        strings.add("Maria");
        strings.add("Ioana");
        strings.add("Ana");

        ArrayList<String> noDuplicateStrings = methods.removeDuplicates(strings);
        System.out.println(noDuplicateStrings); // [Ana, Maria, Ioana]

        String maxString = methods.max(strings);
        System.out.println(maxString); // Maria

        int positionInStrings = methods.binarySearch(strings, "Ioana", 0, strings.size());
        System.out.println(positionInStrings); // 2

        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(1.5);
        doubles.add(2.3);
        doubles.add(3.1);
        doubles.add(4.2);

        ArrayList<Double> noDuplicateDoubles = methods.removeDuplicates(doubles);
        System.out.println(noDuplicateDoubles); // [1.5, 2.3, 3.1, 4.2]

        double maxDouble = methods.max(doubles);
        System.out.println(maxDouble); // 4.2

        int positionInDoubles = methods.binarySearch(doubles, 2.3, 0, doubles.size());
        System.out.println(positionInDoubles); // 1
    }
}
