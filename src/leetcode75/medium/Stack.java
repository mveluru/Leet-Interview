package leetcode75.medium;

import java.util.stream.IntStream;

public class Stack {
    int[] stack;
    int top;

    private Stack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }

    private boolean isFull() {
        return top == stack.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void push(int data) {
        if (!isFull()) {
            stack[++top] = data;
        }
        // System.out.println(peek());
    }

    private void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(peek());
            System.out.println(stack[top--]);

        }

    }

    private int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            return stack[top];
        }
        return 0;
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        IntStream.rangeClosed(1, 20).forEach(stack::push);
        stack.printStack();
         stack.pop();
        System.out.println("After popping: " );
        stack.printStack();
    }
}
