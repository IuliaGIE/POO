import java.util.Hashtable;
import java.util.Enumeration;

class HSet extends Hashtable {
    public boolean add(Object value) {
        if (!containsKey(value)) {
            put(value, value);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        Enumeration keys = keys();
        while (keys.hasMoreElements()) {
            result.append(keys.nextElement());
            if (keys.hasMoreElements()) {
                result.append(", ");
            }
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Object remove(Object key) {
        return super.remove(key);
    }
}

class Test3 {
    public static void main(String args[]) {
        HSet set = new HSet();
        set.add("Laborator");
        set.add("Agregare");
        set.add("Mostenire");
        System.out.println(set);
        System.out.println(set.size());
        set.add("Laborator");
        if (set.size() == 4) {
            System.out.println("Mulțimea nu trebuie să conțină duplicate!");
        }
        System.out.println(set.remove("POO"));
        System.out.println(set.remove("Laborator"));
        if (set.size() != 2) {
            System.out.println("Ștergerea nu funcționează!");
        }
        set.add("Supradefinire");
        set.add("Supraincarcare");
        System.out.println(set);
    }
}
