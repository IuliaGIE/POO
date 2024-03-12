import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class P3 {
    public static void main(String[] args){
    Vector<Integer> v = genVectRandon(20);
    System.out.println(v);

    int sters = deleteX(v, 6);
    System.out.println(sters);

    int maxi, indexMin, medAritm;
    maxi = max(v);
    System.out.println("Maximul: " + maxi);
    System.out.println("Index minim: " + findMin(v));
    System.out.println("Media aritmetica: " + aritmetic(v));

    }

    public static int aritmetic(Vector<Integer> vect){
        int sum = 0;
        for(int i = 0; i < vect.size(); i++)
            sum += vect.get(i);
        sum /= vect.size();
        return sum;
    }
    public static int findMin(Vector<Integer> vect){
        int minn = Collections.min(vect);
        for(int i = 0; i < vect.size(); i++){
            if(vect.get(i).equals(minn))
                return i;
        }
        return 0;
    }
    public static int max(Vector<Integer> vect){
        return Collections.max(vect);
    }
    public static int deleteX(Vector vect, int x){
        int ct = 0;
        for(int i = 0; i < vect.size(); i++){
            if(vect.get(i).equals(x)){
                ct++;
                vect.remove(i);
            }
        }
        return ct;
    }
    public static Vector genVectRandon(int n){
        Vector vect = new Vector<>();
        Random generator= new Random();
        for(int i = 0; i < n; i++){
            vect.add(generator.nextInt(11));
        }
        return vect;
    }
}
