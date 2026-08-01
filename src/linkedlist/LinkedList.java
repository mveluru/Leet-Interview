package linkedlist;

import leetcode75.jee.datastructures.Lnode;

import java.util.stream.IntStream;

public class LinkedList {
    static class LNode{
        int data;

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        LNode next;
        public LNode(int value){
            this.data=value;
            this.next=null;
        }


    }
    //implementation
    LNode head=null;
    LNode tail=null;

    public void insert(int value){
       LNode newNode = new LNode(value);
       if(head== null){
           head= newNode;
           tail= newNode;
           return;
       }
       tail.setNext(newNode);
       tail= newNode;
       tail.setNext(null);
    }

    public boolean find(int value){
       LNode currentNode = head;
       while (currentNode!=null){
           if(currentNode.getData()==value){
               System.out.printf("Data found:%3d",currentNode.getData());
               return true;
           }
           currentNode = currentNode.getNext();
       }
       return false;
    }

    public void insertAt(int value,int index){
        LNode newNode = new LNode(value);

        //LNode currentNode=head;
        //LNode prevNode=currentNode;
        if (head!=null &&  head.getData()==value){
            newNode.setNext(head);
            head= newNode;
        }

    }
    public void delete(int value){
        if (head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.getData()==value){
            head = head.getNext();
            return;
        }
        LNode currentNode = head;
        LNode prevNode = null;
        while (currentNode!=null){
            if (currentNode.getData()==value){
                assert prevNode != null;
                prevNode.setNext(currentNode.getNext());
                break;
            }else{
                prevNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }

    public void printlist(){
        LNode currentNode = head;
        while (currentNode!=null){
            System.out.printf("%3d",currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    public void reverseList(){
       LNode currentNode = head;
       LNode prevNode = null;
       while (currentNode!=null){
           LNode nextNode = currentNode.getNext();
           currentNode.setNext(prevNode);
           prevNode=currentNode;
           currentNode= nextNode;
       }
       head = prevNode;
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        IntStream.range(0,10).forEach(linkedList::insert);
        linkedList.printlist();
        linkedList.reverseList();
        System.out.println("\nAfter reverse");
        linkedList.printlist();
    }
}
