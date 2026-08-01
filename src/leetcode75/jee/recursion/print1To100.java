package leetcode75.jee.recursion;

public class print1To100 {

    private static void print100(int i){
        if (i!=-1 && i<101){
            System.out.print(i+" ");
            print100(++i);
        }
    }
    public static void main(String[] args){
        print100(0);
    }
}
