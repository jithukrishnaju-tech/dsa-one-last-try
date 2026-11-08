package Arrays.medium;

import java.util.Arrays;

public class MajorityElementsOne {
    public static void main(String[] args) {
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int ans = majorityElementOptimum(nums);
        System.out.println(ans);
    }

    public static int majorityElementBruteForce(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 1;
            int currentNumber = nums[i];
            for (int j = i+1; j < n; j++) {
                if(nums[j] == currentNumber) {
                    count++;
                }
            }

            if(count > n/2) {
                return currentNumber;
            }
        }
        return -1;
    }

    public static int majorityElementBetter(int[] nums) {

        // also we can use hashmap for this purpose with tc will stay in O(N)

        Arrays.sort(nums);
        int n = nums.length;
        if(n==1) return nums[0];
        int count = 1;
        int currentElement = nums[0];

        for (int i = 1; i < n; i++) {
            if(nums[i] != currentElement) {
                currentElement = nums[i];
            } else {
                count++;
            }

            if(count > n/2) return currentElement;
        }
        return  -1;
    }

    public static int majorityElementOptimum(int[] nums) {
        int n = nums.length;
        int count = 1;
        int currentElement = nums[0];

        for (int i = 1; i < n; i++) {
            if(nums[i] == currentElement) {
                count++;
            }
            else if(nums[i] != currentElement) {
                count--;
            }
            if(count == 0) {
                currentElement = nums[i];
                count = 1;
            }
        }

        // verifying current element

        int verifyCount = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == currentElement) {
                verifyCount++;
            }
        }

        if(verifyCount > n/2) return currentElement;
        return -1;
    }

}
