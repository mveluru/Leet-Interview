package leetcode75.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1) {
        int[] result =  new int[nums1.length];
        Arrays.fill(result, -1);
        // Stack to store the INDICES of the elements--important
        Stack<Integer> stack = new Stack();
        // Loop through the array from left to right
        for (int i = 0; i < nums1.length; i++) {


            // logs to understand
            if(!stack.isEmpty()){
                System.out.println("peek element index   "+stack.peek());
            }else{
                System.out.println("peek element index   "+ true);
            }

            /*
             * While the stack is not empty and the current element
             * is larger than the element at the index on top of the stack:
             * We found the "Next Greater Element" for that stored index!
             */
             while (!stack.isEmpty() && nums1[i]> nums1[stack.peek()]) {
                 result[stack.pop()] = nums1[i];
             }
             stack.push(i);
        }
        // Any indices left over in the stack have no greater element to their right
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        int[] result = nextGreaterElement(nums);

        System.out.println("Original: " + Arrays.toString(nums));
        System.out.println("Result:   " + Arrays.toString(result));
    }
}
