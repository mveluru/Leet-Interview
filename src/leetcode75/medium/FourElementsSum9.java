package leetcode75.medium;

public class FourElementsSum9 {

    public static void main(String[] args) {
        //int[] nums = {2, 1, 6, 4, 2, 1};
        //int[] nums = {3, 1, 3, 3, 4};
        //int[] nums = {1, 3, 3, 3, 1};
        //int[] nums = {1, 3, 1, 1, 3, 3, 1};
        //int[] nums = {3, 3, 1, 1, 1, 2, 1};
        int[] nums = {2, 2, 3, 1, 1, 2, 1};
        //int[] nums = {1, 1, 1, 1, 3, 3, 3};
        //int[] nums = {1, 1, 1, 1, 3, 3, 3,1};
        //int[] nums = {1, 1, 1, 4, 4, 1, 1, 1, 1};

        int length = nums.length;
        int beginIndex = 0;
        int nextIndex = beginIndex + 1;
        int successorIndex = nextIndex + 1;
        int endIndex = length - 1;
        while (beginIndex < nextIndex && nextIndex < successorIndex && nextIndex < endIndex && successorIndex <= endIndex) {
            boolean isfound = false;
            for (int i = 0; i < length; i++) {
                if (i != beginIndex && i != nextIndex && i != successorIndex) {
                    if (9 == nums[beginIndex] + nums[nextIndex] + nums[successorIndex] + nums[i]) {
                        System.out.println(beginIndex + " " + nextIndex + " " + successorIndex + " " + i);
                        isfound = true;
                        break;
                    }
                }
            }
            if (isfound) {
                break;
            }
            beginIndex++;
            nextIndex++;
            successorIndex++;
        }


    }
}
