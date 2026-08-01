package leetcode75.java21.algorithms;

import java.util.stream.IntStream;

public class Stack {
    int[] stack;
    int top = 0;

    public Stack(int size) {
        stack = new int[size];
        top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == stack.length - 1;
    }
    public int size() {
        return top + 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        return stack[top--];

    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        return stack[top];
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

    public static void main(String[] args) {
        int size = 50;
        Stack stack = new Stack(size);
        IntStream.range(0, size).forEach(stack::push);
        stack.print();
    }
}
