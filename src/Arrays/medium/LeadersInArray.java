package Arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 1, 2};
        List<Integer> ans = leadersOptimum(nums);
        System.out.println(ans);
    }

    public static List<Integer> leadersBruteForce(int[] nums) {
        List<Integer> leaderList = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currentElement = nums[i];
            boolean canWeAdd = true;
            for (int j = i+1; j < n; j++) {
                if(nums[j] >= currentElement) {
                    canWeAdd = false;
                    break;
                }
            }

            if(canWeAdd) leaderList.add(currentElement);
        }
        return leaderList;
    }

    public static List<Integer> leadersOptimum(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[n-1]);
        int largerElement = nums[n-1];
        for(int i = n-2; i>=0; i--) {
            if(nums[i] > largerElement) {
                list.add(nums[i]);
                largerElement = nums[i];
            }
        }

        return list.reversed();
    }
}
