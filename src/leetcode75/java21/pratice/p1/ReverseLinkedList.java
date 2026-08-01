package leetcode75.java21.pratice.p1;

public class ReverseLinkedList {
    static class ListNode {
        int value;

        public ListNode getNextRef() {
            return nextRef;
        }

        public void setNextRef(ListNode next) {
            this.nextRef = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        ListNode nextRef;

        public ListNode(int value) {
            this.value = value;
            this.nextRef = null;
        }

    }

    ListNode head = null;
    ListNode tail = null;

    public void insert(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNextRef(newNode);
        tail = newNode;
        tail.setNextRef(null);
    }

    public void printList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.printf("%5d",currentNode.getValue());
            currentNode = currentNode.getNextRef();
        }
    }

    public void printReverseList() {
        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.getNextRef();
            currentNode.setNextRef(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
        printList();
    }


    public static void main(String[] args) {

        ReverseLinkedList list = new ReverseLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.printList();
        System.out.println();
        list.printReverseList();

    }
}

