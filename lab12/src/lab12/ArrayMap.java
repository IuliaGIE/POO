package lab12;

import java.util.*;



class ArrayMap<K, V> extends AbstractMap<K, V> {

    // Vectorul de chei
    private Vector<K> keys;

    // Vectorul de valori asociate
    private Vector<V> values;

    // Constructorul
    public ArrayMap() {
        keys = new Vector<>();
        values = new Vector<>();
    }

    // Metoda toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < keys.size(); i++) {
            sb.append(keys.get(i) + "=" + values.get(i));
            if (i < keys.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Metoda put()
    @Override
    public V put(K key, V value) {
        if (keys.contains(key)) {
            values.set(keys.indexOf(key), value);
            return value;
        }
        keys.add(key);
        values.add(value);
        return value;
    }

    // Metoda get()
    @Override
    public V get(Object key) {
        return values.get(keys.indexOf(key));
    }

    // Metoda keySet()
    @Override
    public Set<K> keySet() {
        return (Set<K>) keys;
    }

    // Metoda values()
    @Override
    public Collection<V> values() {
        return values;
    }

    // Metoda entrySet()
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        class ArrayMapEntry<K, V> implements Map.Entry<K, V> {

            // Câmpul cheie
            private K key;

            // Câmpul valoare
            private V value;

            // Constructorul
            public ArrayMapEntry(K key, V value) {
                this.key = key;
                this.value = value;
            }

            // Metoda getKey()
            @Override
            public K getKey() {
                return key;
            }

            // Metoda getValue()
            @Override
            public V getValue() {
                return value;
            }

            // Metoda setValue()
            @Override
            public V setValue(V value) {
                V oldValue = this.value;
                this.value = value;
                return oldValue;
            }
        }

        Set<Map.Entry<K, V>> entries = new HashSet<>();

        for (int i = 0; i < keys.size(); i++) {
            ArrayMapEntry<K, V> entry = new ArrayMapEntry<>(keys.get(i), values.get(i));
            entries.add(entry);
        }

        return entries;
    }

    public static void main(String[] args) {

        ArrayMap<String, Integer> dictionar = new ArrayMap<>();


        dictionar.put("cheie2", 2);
        dictionar.put("cheie3", 3);
        dictionar.put("cheie1", 1);

        System.out.println(dictionar);

        Iterator<Map.Entry<String, Integer>> iterator = dictionar.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
