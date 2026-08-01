package leetcode75.java21.pratice.datastructures;

public class Stack {
    private final int stackSize;
    private int[] stack;
    private int top=-1;
    public Stack(int maxSize) {
        this.stackSize=maxSize;
        stack=new int[stackSize];
    }
    public void push(int data) {
        if (top==stackSize-1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = data;
        }
    }
    public void pop() {
        if (top==-1) {
            System.out.println("Stack is empty");
        } else {
             int value = stack[top--];
            System.out.println("popped value: "+value);
        }
    }
    public void peek() {
        if (top==-1) {
            System.out.println("Stack is empty");
        }else{
            System.out.println("peeked value: "+stack[top]);
        }
    }
    public boolean isEmpty() {
        return top==-1;
    }
    public boolean isFull() {
        return top==stackSize-1;
    }

    public static void main(String[] args) {
        Stack stack=new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
       stack.pop();
       stack.pop();
       stack.peek();
    }
}
