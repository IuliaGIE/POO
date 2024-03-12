import java.util.Arrays;

public class ex8 {
    public static void main(String[] args){
        double[] arr = new double[5];
        for(int i = 0; i < 5; i++){
            arr[i] = Math.random();
        }
        Arrays.sort(arr);
        for (double element: arr) {
            System.out.println(element);
        }

        int poz = Arrays.binarySearch(arr, 0.5);
        System.out.println(poz);
    }
}
