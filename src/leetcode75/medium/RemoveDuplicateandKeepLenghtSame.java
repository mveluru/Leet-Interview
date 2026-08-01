package leetcode75.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateandKeepLenghtSame {

    private static void removeduplicateelement(int[] array) {
        int length = array.length;
        String[] stringarray ;
        Set<String> integerset ;

        if (length >= 1 && length <= 3 * (Math.pow(10, 4))) {
            stringarray = new String[length];
            integerset = new HashSet<>();
            for (int i : array) {
                if (i >= -100 && i <= 100) {
                    integerset.add(String.valueOf(i));
                } else {
                    return;
                }
            }

            int iterator = -1;
            for (String s : integerset) {
                iterator++;
                stringarray[iterator] = s;

            }

            if (array.length > integerset.size()) {
                for (int i = 0; i < stringarray.length; i++) {
                    if (stringarray[i] == null) {
                        stringarray[i] = "_";
                    }

                }
            }
        }else{
            return;
        }

        System.out.println("Numbers of elements: "+ integerset.size() +" \nArray including _ : " + Arrays.toString(stringarray));

    }

    public static void main(String[] args) {
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int[] nums = {1, 1, 2};
        int[] nums = {10, 9, 8, 8, 7, 7, 0, 0, 1, 2, 3, 4, 5};
        //int[] nums = {10, 9, 8, 8, 7, 7, 0, 0, 1, 2, 3, 4, 500};
        RemoveDuplicateandKeepLenghtSame.removeduplicateelement(nums);

    }
}
