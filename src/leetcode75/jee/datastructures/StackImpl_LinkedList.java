package leetcode75.jee.datastructures;

public class StackImpl_LinkedList {

    Lnode head;
    Lnode tail;

    public void push(int data) {
        //stack head always is top element
        Lnode newNode = new Lnode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Lnode nexNode = head;
            head = newNode;
            tail = nexNode;
            tail.setNextRef(null);
        }
    }// push data

    public void pop(){
        System.out.print(head.data+" ");
        Lnode nextNode = head.nextRef;
        head = nextNode;
    }

    public void traverse() {
        Lnode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.getNextRef();
        }
    }

    public static void main(String[] args){
        StackImpl_LinkedList sll = new StackImpl_LinkedList();
        sll.push(10);
        sll.push(20);
        sll.traverse();
    }
}
