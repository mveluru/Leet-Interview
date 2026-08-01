package leetcode75.medium;

public class Stack1 {
    int[] stack;
    int top;
    public Stack1(int stackSize) {
        stack = new int[stackSize];
        top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == stack.length - 1;
    }
    public void push(int data) {
        if (!isFull()) {
            stack[++top] = data;
        }
    }
    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return -1;
    }
    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        return -1;
    }
    public int size() {
        return top + 1;
    }
    public void printStack() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }

        }
    }
    public static void main(String[] args) {
        Stack1 stack1 = new Stack1(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.printStack();
        stack1.pop();
        System.out.println();
        stack1.printStack();

    }
}
