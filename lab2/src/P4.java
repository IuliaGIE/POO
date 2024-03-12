import java.util.Collection;
import java.util.Vector;

public class P4 {
    public static void main(String[] args){
        Vector<Integer> a = new Vector<>(5);
        Vector<Integer> b = new Vector<>(5);
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(6);
        a.add(7);

        b.add(2);
        b.add(4);
        b.add(5);
        b.add(7);
        b.add(9);

        System.out.println(a);
        System.out.println(b);
        System.out.println("Reuniune: " + reuniune(a, b));
        System.out.println("Intersectie: " + intersectie(a, b));
        Vector<Integer> c = a;
        a.removeAll(b);
        b.removeAll(c);
        System.out.println("Diferenta: " + a);
    }


    public static Vector intersectie(Vector<Integer> a, Vector<Integer> b){
        Vector<Integer> c = new Vector<>(a.size() + b.size());
        int i = 0, j = 0;
        for(i = 0; i < a.size(); i++)
            for(j = 0; j < b.size(); j++)
                if(a.get(i).equals(b.get(j)))
                    c.add(a.get(i));
        return c;
    }
    public static Vector reuniune(Vector<Integer> a, Vector<Integer> b){
        Vector<Integer> c = new Vector<>(a.size() + b.size());
        int i = 0, j = 0;
        while(i < a.size() && j < b.size()){
            if(a.get(i) < b.get(j)) {
                c.add(a.get(i));
                i++;
            }
            else {
                c.add(b.get(j));
                j++;
            }
        }
        while(i < a.size()){
            c.add(a.get(i));
            i++;
        }
        while(j < b.size()){
            c.add(b.get(j));
            j++;
        }
        return c;

    }
}
