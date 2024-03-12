class MyArray {
    private int[] v;
    private int size;

    public MyArray() {
        this(100);
    }

    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }

    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }

    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }

    public int getSize() {
        return size;
    }
}

class MyQueue{
    private MyArray arr;
    private final int infinit = 9500;
    private int first, last, n;

    public MyQueue(){
        arr = new MyArray();
        first = 0;
        last = 0;
        n = 0;
    }

    public int getSize(){
        return n;
    }

    public void enqueue(int value){
        if (n != infinit) {
            ++n;
            arr.set(last++, value);
        }
        else {
            System.out.println("Coada plina.");
        }
    }

    public int dequeue(){
        int p = arr.get(first++);
        n--;
        return p;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = first; i < last; i++)
            sb.append(arr.get(i)).append(" ");
        return sb.toString();
    }

}


public class Ex3 {
    public static void main(String args[]) {
        MyQueue queue = new MyQueue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(-1);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.enqueue(9);
        queue.enqueue(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(22);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("");
        System.out.println(queue);
    }
}
