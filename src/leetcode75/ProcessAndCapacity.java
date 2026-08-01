package leetcode75;

import java.util.Arrays;

public class ProcessAndCapacity {

    public static void main(String[] args) {

        int[] process = {2, 5, 8};
        int processSize = 3;
        int[] capacity = {6, 7, 4};
        int capacitySize = 3;
        Arrays.sort(process);
        System.out.println(Arrays.toString(process));
        Arrays.sort(capacity);
        System.out.println(Arrays.toString(capacity));
        if (processSize > capacitySize){
            System.out.println("process can't process with given capacity");
        }

       for (int i=0;i<processSize;i++){
           for (int j=0;j<capacitySize;j++){
               if (i==j && process[i]<=capacity[i]){
                   System.out.println(process[i]+" "+capacity[j]);
               }else{
                   System.out.println("unable to process");
                   break;
               }

           }
       }
    }

}
