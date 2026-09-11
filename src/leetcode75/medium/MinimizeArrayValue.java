package leetcode75.medium;
/*
Let's use the example nums = [3, 7, 1, 6].
 We track the running prefix sum and calculate the minimum possible maximum for each
 prefix.Index (\(i\))ElementRunning Prefix Sum (\(S\))Number of Elements (\(i+1\))Required Max \(\lceil S / (i+1) \rceil\)0331\(\lceil 3 / 1 \rceil = \mathbf{3}\)17102\(\lceil 10 / 2 \rceil = \mathbf{5}\)21113\(\lceil 11 / 3 \rceil = 4\)36174\(\lceil 17 / 4 \rceil = \mathbf{5}\)The largest required maximum encountered is 5.
 */
// Leet problem 2439. Minimize Maximum of Array
public class MinimizeArrayValue {

    public static void main(String[] args){
        //int[] nums = {3,7,1,6};
        int[] nums ={10,1};

        int indexCount=0;
        double preSum=0;
        double maxInt =0;
        for (int num : nums) {
           preSum+=num;
           indexCount++;
           double curCeilAvg= Math.ceil(preSum / indexCount);
           maxInt=Math.max(maxInt,curCeilAvg);
      }// for loop
        System.out.println((int) maxInt);

    }
}
