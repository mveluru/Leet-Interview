package leetcode75.java21.pratice.datastructures;

public class LNode {
    int data;

    public LNode getNextRef() {
        return nextRef;
    }

    public void setNextRef(LNode nextRef) {
        this.nextRef = nextRef;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    LNode nextRef;
    public LNode(int data){
        this.data=data;
    }
}
