package leetcode75.easy;

import java.util.Arrays;

public class Fibonacci {

    protected int[] fiboseries(int n) {
        int[] fibo = new int[n];
        if (n == 0) {
            fibo[0] = 0;
            return fibo;

        } else if (n == 1) {
            fibo[0] = 0;
            fibo[1] = 1;
            return fibo;
        } else {
            fibo[0] = 0;
            fibo[1] = 1;
            for (int i = 2; i < n; i++)
                fibo[i] = fibo[i - 2] + fibo[i - 1];
        }
        return fibo;
    }

    protected  int fiborecursion(int n){
        if (n>30 && n<0){
            return 0;
        }
        if ((n==0 || n==1))
            return n;
       return (fiborecursion(n-1)+fiborecursion(n-2));
    }

    protected  int[] fiboarray(int n){
        int[] fibo = new int[n];
        for (int i=0;i<n;i++){
            fibo[i] = this.fiborecursion(i);
        }
        return fibo;
    }


 public static void main(String[] args){
     Fibonacci fibo  = new Fibonacci();
     Arrays.stream(fibo.fiboseries(15)).forEach(e-> System.out.print(e+" "));
     System.out.println("Using Recursion");
     int[] fibarray = fibo.fiboarray(10);
     Arrays.stream(fibarray).forEach(e-> System.out.print(e+" "));
 }

}
