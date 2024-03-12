class MyArray {
    private int v[];
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
    private final int Infinit = 9500;
    private int prim, ultim, n;

    public MyQueue(){
        this.arr = new MyArray();
        this.prim = 0;
        this.ultim = 0;
        this.n = 0;
    }

    public int getSize(){
        return n;
    }

    public void enqueue(int value){
        if(n == Infinit){
            System.out.println("Coada plina.");
            return;
        }
        ++n;
        arr.set(ultim++, value);
    }

    public int dequeue(){
        int pos = arr.get(prim++);
        n--;
        return pos;
    }

    public boolean isEmpty(){
        if(n == 0)
            return true;
        else
            return false;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = prim; i < ultim; i++)
            sb.append(arr.get(i)).append(" ");
        String s = sb.toString();
        return s;
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
