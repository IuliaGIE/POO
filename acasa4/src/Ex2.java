import java.util.Stack;

class SortedArray extends Array {
    @Override
    public void addElement(Integer x) {
        super.addElement(x);
        sort();
    }
}

class MyStack {
    private Stack<Integer> stack;

    public MyStack() {
        stack = new Stack<>();
    }

    public void push(Integer x) {
        stack.push(x);
    }

    public Integer pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            return null;
        }
    }

    public int getSize() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Array array = new Array();
        array.addElement(5);
        array.addElement(3);
        array.addElement(7);

        System.out.println("Array elements: " + array);

        SortedArray sortedArray = new SortedArray();
        sortedArray.addElement(5);
        sortedArray.addElement(3);
        sortedArray.addElement(7);

        System.out.println("Sorted Array elements: " + sortedArray);

        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack elements: " + stack);
        System.out.println("Popped element from stack: " + stack.pop());
    }
}
