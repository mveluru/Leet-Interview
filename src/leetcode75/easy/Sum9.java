package leetcode75.easy;

public class Sum9 {

    public static void main(String[] args) {
        //int[] nums = {2, 1, 6, 4, 2, 1};
        //int[] nums = {3, 1, 3, 3, 4};
        //int[] nums = {1, 3, 3, 3, 1};
        //int[] nums = {1, 3, 1, 1, 3, 3, 1};
        //int[] nums = {3, 3, 1, 1, 1, 3, 1};
        //int[] nums = {1, 1, 1, 1, 3, 3, 3};
        //int[] nums = {1, 1, 1, 1, 3, 3, 3, 1};
        int[] nums = {1, 1, 1, 4, 4, 1, 1,1,1};

        int beginIndex = 0;
        int nextIndex = beginIndex + 1;
        int endIndex = nums.length - 1;
        while (beginIndex < nextIndex && nextIndex <= endIndex) {
            boolean isvaluesFound = false;
            for (int i = 0; i < nums.length; i++) {
                if ((i != beginIndex && i != nextIndex)) {
                    if (nums[beginIndex] + nums[nextIndex] + nums[i] == 9) {
                        System.out.println("index1: " + beginIndex + " index2: " + nextIndex + " index3: " + i);
                        System.out.println(nums[beginIndex] + " " + nums[nextIndex] + " " + nums[i]);
                        isvaluesFound = true;
                        break;
                        //i=nums.length-1;
                    }
                }

            }//for loop

            if (isvaluesFound) {
                break;
            }
            beginIndex++;
            nextIndex++;

        }
    }
}
