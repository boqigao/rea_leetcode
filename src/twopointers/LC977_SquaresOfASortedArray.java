package twopointers;

import java.util.Arrays;
import java.util.Map;

public class LC977_SquaresOfASortedArray {
    public int[] sortedSquaresStupid(int[] nums) {
        int[] res = new int[nums.length];
        System.arraycopy(nums,0, res,0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            res[i] = res[i] * res[i];
        }

        Arrays.sort(res);
        return res;

    }

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int i = 0, j = len - 1, k = len - 1;
        int[] res = new int[len];
        while (i <= j) {
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                res[k] = nums[i] * nums[i];
                k--;
                i++;
            } else {
                res[k] = nums[j] * nums[j];
                k--;
                j--;
            }
        }
        return res;
    }
}
