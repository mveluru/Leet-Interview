package leetcode75.jee.datastructures;

public class Lnode {

    int data;
    Lnode nextRef;
    public Lnode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Lnode getNextRef() {
        return nextRef;
    }

    public void setNextRef(Lnode nextRef) {
        this.nextRef = nextRef;
    }
}
