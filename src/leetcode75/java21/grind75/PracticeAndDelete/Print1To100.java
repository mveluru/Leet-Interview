package leetcode75.java21.grind75.PracticeAndDelete;

public class Print1To100 {
    public static void print1to100(int i){
        if(i!=-1&&i<=100){
            System.out.print(i+"");
            Print1To100.print1to100(++i);
        }

    }
    public static void main(String[] args) {
        print1to100(0);

    }
}
