package leetcode75.jee.datastructures;

import java.util.Random;

public class Queue {

    int rear =-1;
    int front =0;
    int currentSize=0;
    int[] queue;
    public Queue(int queueSize){
        this.queue = new int[queueSize];
    }

    public void enqueue(int data){
        if (!isQueuefull()){
            queue[++rear]=data;
            this.currentSize++;
        }else{
            System.out.println("Queue over flow");
        }
        System.out.println("Added Element "+queue[rear]);
    }

    public void dequeue(){
        if(!isQueueemppty()){
            int element = queue[front];
            front++;
            this.currentSize--;
            System.out.println("Dequed element "+element);
        }else{
            System.out.println("Queue is underflow");
        }
    }
    public int peek(){
        return queue[front];
    }

    public boolean isQueuefull(){
        if (currentSize==queue.length){
            return true;
        }
        return false;
    }

    public boolean isQueueemppty(){
        if (this.currentSize==0 && rear ==-1){
            return  true;
        }
        return false;
    }

    public void resetQueue(){
        this.currentSize=-1;
        this.rear=-1;
        this.front=0;

    }

    public static void main(String[] args){
        Queue queue = new Queue(11);
        Random r = new Random();
        for (int i=0;i<10;i++){
            queue.enqueue(r.nextInt(100));
        }

        for(int i=0;i<=10;i++){
            queue.dequeue();
        }

    }
}
