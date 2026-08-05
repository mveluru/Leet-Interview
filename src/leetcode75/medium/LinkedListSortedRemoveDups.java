package leetcode75.medium;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSortedRemoveDups {

    public static class ListNode {
        int value;

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    ListNode head;
    ListNode tail;

    public void insert(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(null);
        }
    }

    public void printList() {
        if (head == null) {
            return;
        } else {
            ListNode current = head;
            while (current != null) {
                System.out.printf("%3d", current.value);
                current = current.getNext();
            }
        }
    }

    public void deleteNode(int value) {
        if (head.value == value) {
            head = head.getNext();
            return;
        }
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            if (current.value == value) {
                prev.setNext(current.getNext());
                if (current.getNext() == null) {
                    tail = prev;
                }
                break;
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        System.out.println("\nDeleted node with value: " + value);
    }

    public void deleteDuplicates() {
        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.getNext() != null) {
            if (current.value == current.getNext().value) {
                // Duplicate found: link current to the node after the duplicate
                current.setNext(current.getNext().getNext());

                // CRITICAL: Do NOT advance 'prev' or 'current' here.
                // We must re-evaluate 'current' against its new next neighbor.
            } else {
                // No duplicate: it is safe to advance both pointers forward
                prev = current;
                current = current.getNext();
            }
        }
    }

    public static void main(String[] args) {
        LinkedListSortedRemoveDups list = new LinkedListSortedRemoveDups();
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        list.insert(5);
        list.printList();
       // list.deleteNode(3);
       // list.deleteNode(3);
       // list.printList();
        //list.deleteNode(4);
        //list.printList();
        //list.deleteNode(5);
        //list.printList();
        list.deleteDuplicates();
        System.out.println("\nAfter removing duplicates:");
        list.printList();

    }
}
