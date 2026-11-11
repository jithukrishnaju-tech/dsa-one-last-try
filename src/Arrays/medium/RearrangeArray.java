package Arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, -1, -3, -4};
        int[] ans = rearrangeArrayOptimized(nums);
    }


        public int[] rearrangeArray(int[] nums) {
            List<Integer> pNUmber = new ArrayList<>();
            List<Integer> nNUmber = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if(nums[i] > 0) {
                    pNUmber.add(nums[i]);
                } else {
                    nNUmber.add(nums[i]);
                }
            }

            int pIndex = 0;
            int nIndex = 0;

            for (int i = 0; i < n / 2; i++) {
                nums[2 * i] = pNUmber.get(i);
                nums[2 * i + 1] = nNUmber.get(i);
            }

            return nums;
        }

    public static int[] rearrangeArrayOptimized(int[] nums) {
        int pIndex = 0;
        int nIndex = 1;
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                res[pIndex] = nums[i];
                pIndex+=2;
            } else {
                res[nIndex] = nums[i];
                nIndex+=2;
            }
        }

        return res;
    }
}
