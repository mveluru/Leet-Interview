package leetcode75.jee.datastructures;

import java.util.stream.IntStream;

public class Stack {
    int top=-1;
    int[] stac=null;
    public Stack(int stacksize){
        stac = new int[stacksize];
    }

    public void push(int data){
        if(!isStackfull()){
        stac[++top]=data;
        System.out.println("Added element "+data);
        }else{
            System.out.println("stack over flow");
        }
    }

    public void pop(){

        if (!isStackEmpty()){
        int element = stac[top];
        top--;
        System.out.println("popped out: " +element);
        }else{
            System.out.println("Stack under flow");
        }

    }

    public void peek(){
        System.out.println("peek element "+ stac[top]);
    }

    public boolean isStackfull(){
        return this.top == stac.length;
    }

    public boolean isStackEmpty(){
        return this.top ==-1;
    }



    public static void main(String[] args) {
        Stack s = new Stack(12);
        IntStream intStream = IntStream.rangeClosed(1,13);
        intStream.forEach(value ->s.push(value) );
        for(int i=0;i<11;i++){
            s.pop();
        }

    }

}
