package leetcode75.java21.pratice.datastructures;

public class LList {
    LNode head;
    LNode tail;

    public void insertData(int data) {
        LNode newNode = new LNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNextRef(null);
        } else {
            tail.setNextRef(newNode);
            tail = newNode;
            tail.setNextRef(null);
        }
    }

    public void insertHead(int data) {
        LNode newNode = new LNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNextRef(null);
        }
    }

    public void traverse() {
        LNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNextRef();
        }
    }
    public void deleteHead() {
        if (head != null) {
            head = head.getNextRef();
        }
    }
    public void deleteTail() {
        if (tail != null) {
            tail = tail.getNextRef();
        }
    }
    public void deletedata(int data) {
        LNode temp = head;
        LNode prev = null;
        while (temp != null) {
            if (temp.getData() == data) {
                assert prev != null;
                prev.setNextRef(temp.getNextRef());
                System.out.println("data deleted: " + data);
                break;
            }else{
                prev = temp;
                temp = temp.getNextRef();

            }
            //System.out.println("data not found: " + data);
        }
    }
    public static void main(String[] args) {
        LList llist = new LList();
        for (int i = 0; i < 10; i++) {
            llist.insertData(i);
        }
        llist.traverse();
        System.out.println();
        llist.deleteHead();
        llist.traverse();
        llist.deletedata(9);
        System.out.println();
        llist.traverse();
    }
}
