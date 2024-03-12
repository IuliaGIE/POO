package lab08.lab08;

import java.util.*;

public class ArrayMap<K, V> extends AbstractMap<K, V> {

    private ArrayList<ArrayMapEntry<K, V>> entries = new ArrayList<>();

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(entries);
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public V put(K key, V value) {
        for (ArrayMapEntry<K, V> entry : entries) {
            if (Objects.equals(entry.getKey(), key)) {
                return entry.setValue(value);
            }
        }
        ArrayMapEntry<K, V> newEntry = new ArrayMapEntry<>(key, value);
        entries.add(newEntry);
        return null;
    }
}

