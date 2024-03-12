import java.util.Stack;

public class MyStack {
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
