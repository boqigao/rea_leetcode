package twopointers;

import java.util.Arrays;

public class LC16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[1] + nums[2] + nums[3];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length -1; j++) {
                int k = nums.length - 1;
                while (j < k) {
                    if (Math.abs(target - closest) < Math.abs(nums[i] + nums[j] + nums[k] - target)){
                        closest = nums[i] + nums[j] + nums[k];
                    }
                    if (nums[i] + nums[j] + nums[k] - target > 0) {
                        k--;
                    }
                }
            }
        }
        return closest;
    }
}
