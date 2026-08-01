package leetcode75.java21.algorithms;

import java.util.stream.IntStream;

public class LinkedList {
    LLNode head;
    LLNode tail;

    public void insetData(int data) {
        LLNode newNode = new LLNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNextRef(newNode);
        tail = newNode;
        tail.setNextRef(null);
    }
    public  void deleteNode(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.getData() == data) {
            System.out.println("Data found in Head Node " + head.getData());
            head = head.getNextRef();
            return;
        }
        LLNode temp = head.getNextRef();
        LLNode prev = head;
        while (temp.getNextRef() != null) {
            if (temp.getData() == data) {
                System.out.println("Data found " + temp.getData());
                prev.setNextRef(temp.getNextRef());
                break;
            }else{
                prev = temp;
                temp = temp.getNextRef();
            }
        }
        if(temp.getData() == data && temp.getNextRef()==null){
            System.out.println("Data found in Tail Node " + temp.getData());
            assert prev != null;
            prev.setNextRef(null);
            tail=prev;
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
        }else{
            LLNode temp = head;
            while (temp.getNextRef() != null) {
                System.out.print(temp.getData()+" ");
                temp = temp.getNextRef();
            }
        }
    }

  public static void main(String[] args){
      IntStream intStream = IntStream.range(0,50);
      LinkedList linkedList = new LinkedList();
     intStream.forEach(linkedList::insetData);
     linkedList.traverse();
    }
}
