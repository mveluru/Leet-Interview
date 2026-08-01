package leetcode75.jee.datastructures;

import java.util.stream.IntStream;

public class LList {

    Lnode head = null;
    Lnode tail = null;

    public void insertData(int data) {
        Lnode newNode = new Lnode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextRef(newNode);
            tail = newNode;
            tail.setNextRef(null);
        }
    }

    public void traverse() {
        if (head != null) {
            Lnode tempNode = head;
            while (tempNode != null) {
                System.out.print(tempNode.getData() + " ");
                tempNode = tempNode.getNextRef();
            }
        } else {
            System.out.println("list is empty");
        }
    }

    public void deleteData(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.getData() == data) {
            head = head.getNextRef();
        } else {
            Lnode tempNode = head.getNextRef();
            //Lnode datafound = null;
            Lnode previousNode = head;
            while (tempNode != null) {
                if (tempNode.getData() == data) {
                    //System.out.println(data);
                    break;
                } else if (tempNode.getData() != data) {
                    previousNode = tempNode;
                    tempNode = tempNode.getNextRef();
                }
            }
            if (tempNode.getNextRef() != null && tempNode.getData() == data) {
                previousNode.setNextRef(tempNode.getNextRef());
                tempNode.setNextRef(null);
            } else if (tempNode.getNextRef() == null) {
                previousNode.setNextRef(null);
                tail = previousNode;
            }

        }
    }


    public void swapData(int data) {
        Lnode tempNode = head.getNextRef();
        Lnode previousNode = head;
        if (head.getData() == data) {
            //swap with next element
            Lnode temp = head.getNextRef();
            int tempdata = head.getData();
            head.setData(temp.getData());
            temp.setData(tempdata);
        } else {
            while (tempNode != null) {
                if (tempNode.getData() == data) {
                    if (tempNode.getNextRef() != null) {
                        Lnode nextNode = tempNode.getNextRef();
                        int tempnodedata = tempNode.getData();
                        tempNode.setData(tempNode.getNextRef().getData());
                        nextNode.setData(tempnodedata);
                        break;
                    } else {
                        System.out.println("unable to swap -data found in tail node");
                        break;
                    }

                } else {
                    previousNode = tempNode;
                    tempNode = tempNode.getNextRef();

                }
            }
        }


    }

    private void insertBeforeSpecificElement(int insertbeforedata, int data) {
        Lnode newNode = new Lnode(data);
        if (head != null && head.getData() == insertbeforedata) {
            Lnode tempNode = head;
            head = newNode;
            head.setNextRef(tempNode);
        } else {
            Lnode nextNode = head.getNextRef();
            Lnode previousNode = head;
            while (nextNode != null) {
                if (nextNode.getData() == insertbeforedata) {
                    previousNode.setNextRef(newNode);
                    newNode.setNextRef(nextNode);
                    break;
                } else {
                    previousNode = nextNode;
                    nextNode = nextNode.nextRef;
                }
            }
        }
    }

    public void reverseList() {
        Lnode previousNode = null;
        Lnode currentNode = head;
        Lnode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.nextRef;
            currentNode.setNextRef(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        if (currentNode == null) {
            head.setNextRef(null);
            head = previousNode;
        }


    }

    public static void main(String[] args) {
        IntStream stream = IntStream.range(0, 30);
        LList ll = new LList();
        stream.forEach(ll::insertData);
        ll.traverse();
        int swap_element = 5;
        System.out.println("\n swap data with next node of the element " + swap_element);
        ll.swapData(swap_element);
        ll.traverse();

        System.out.println();
        ll.reverseList();
        System.out.println();
        ll.traverse();
        System.out.println();
        ll.deleteData(29);
        System.out.println();
        ll.traverse();
        System.out.println();
        ll.deleteData(12);
        System.out.println();
        ll.traverse();
        System.out.println();
        ll.insertBeforeSpecificElement(5,200);
        ll.insertBeforeSpecificElement(0,210);
        ll.insertBeforeSpecificElement(9,220);
        ll.traverse();

    }
}
