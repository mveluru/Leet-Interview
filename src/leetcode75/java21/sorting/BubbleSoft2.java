package leetcode75.java21.sorting;

public class BubbleSoft2 {
    public static void main(String[] args){
        int[] arr={20,2,3,4,5,6,7,8,9,10};
        int temp=0;
        for(int i=0;i<arr.length;i++){
            boolean isBubble=true;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]>arr[j-1]){
                    isBubble=false;
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
            if(isBubble){
                break;
            }
        }
        System.out.println("Sorted array is:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
