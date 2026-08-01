package leetcode75.jee.datastructures;

public class PriorityQueueNode {
    private PriorityQueueNode pnodeNextRef;
    private  int data;
    private  int priority;

    public PriorityQueueNode(int data , int priority){
        this.priority = priority;
        this.data = data;

    }

    public PriorityQueueNode getPnodeNextRef() {
        return pnodeNextRef;
    }

    public void setPnodeNextRef(PriorityQueueNode pnodeNextRef) {
        this.pnodeNextRef = pnodeNextRef;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
