package twopointers;

import java.util.Map;

public class LC209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        int minLen = nums.length;

        boolean found = false;
        while (right < len) {
            while (sum < target && right < len) {
                sum += nums[right];
                right++;
            }

            while (sum >= target && left >= 0){
                found = true;
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;
            }
        }
        if (found) {
            return minLen;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        LC209_MinimumSizeSubarraySum test = new LC209_MinimumSizeSubarraySum();
        System.out.println(test.minSubArrayLen(7, new int[] {2,3,1,2,4,3,}));
    }
}
