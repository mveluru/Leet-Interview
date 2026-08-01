package leetcode75.jee.datastructures;

public class PriorityQueueNodeImpl {
    PriorityQueueNode head;

    public void insertData(int data, int priority) {
        PriorityQueueNode newpqNode = new PriorityQueueNode(data, priority);

        if (head == null) {
            head = newpqNode;
            head.setPnodeNextRef(null);
        } else {
            if (head.getPriority() >= priority) {
                PriorityQueueNode tempPQNODE = head;
                head = newpqNode;
                newpqNode.setPnodeNextRef(tempPQNODE);

            } else {
                PriorityQueueNode tempPQNODE = head.getPnodeNextRef();
                PriorityQueueNode previousPQNode = head;
                while (tempPQNODE != null) {
                    if (tempPQNODE.getPriority() >= priority) {
                        previousPQNode.setPnodeNextRef(newpqNode);
                        newpqNode.setPnodeNextRef(tempPQNODE);
                        break;

                    } else if (tempPQNODE.getPriority() < priority) {
                        previousPQNode = tempPQNODE;
                        tempPQNODE = tempPQNODE.getPnodeNextRef();
                    }
                }//end of loop

            }

        }

    }

    public void dequeue() {
        if (head == null) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Data: " + head.getData() + " Priority: " + head.getPriority());
            head = head.getPnodeNextRef();
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Queue is Empty");
        } else {
            PriorityQueueNode tempPQNODE = head;
            while (tempPQNODE != null) {
                System.out.println("Data: "+ tempPQNODE.getData() + " Priority: " + tempPQNODE.getPriority());
                tempPQNODE = tempPQNODE.getPnodeNextRef();
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueueNodeImpl pq = new PriorityQueueNodeImpl();
        pq.insertData(10, 7);
        pq.insertData(11, 7);
        pq.insertData(9, 4);
        pq.insertData(21, 4);
        pq.insertData(4, 1);
        pq.insertData(8, 5);
        pq.insertData(5, 2);
        pq.insertData(6, 3);
        pq.insertData(7, 0);

        pq.traverse();

        System.out.println("dequeue ");
        pq.dequeue();

        System.out.println("Traverse ");
       pq.traverse();
    }
}
