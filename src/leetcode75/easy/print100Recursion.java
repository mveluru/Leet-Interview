package leetcode75.easy;

public class print100Recursion {

    static void print(int i){

        if (i>-1 && i<=100){
            System.out.print(i+" ");
            print(i+1);
        }

    }
    public static void main(String[] args) {
        print(1);
    }
}
