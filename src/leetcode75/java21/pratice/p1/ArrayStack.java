package leetcode75.java21.pratice.p1;

public class ArrayStack {
    private int top;
    private final int[] stack;

    public ArrayStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be positive");
        }

        this.top = -1;
        this.stack = new int[size];
    }

    public boolean isStackFull() {
        return top == stack.length - 1;
    }

    public boolean isStackEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if (isStackFull()) {
            System.out.println("Stack is full");
            return;
        }

        stack[++top] = num;
        System.out.println("Pushed to stack: " + num);
    }

    public int pop() {
        if (isStackEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int poppedValue = stack[top--];
        System.out.println("Data popped out: " + poppedValue);
        return poppedValue;
    }

    public int peek() {
        if (isStackEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return stack[top];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println("Top value: " + stack.peek());

        stack.pop();
        stack.pop();

        System.out.println("Top value after popping: " + stack.peek());
    }
}
