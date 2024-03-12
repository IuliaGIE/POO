import java.util.Enumeration;
import java.util.Hashtable;

public class HSet extends Hashtable {
    public boolean add(Object value){
        if (!containsKey(value)) {
            put(value, value);
            return true;
        }
        return false;
    }



    public String toString(){
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
