package dp;

/**
 * 这道题主要看的是已知的sum是不是小于0
 */
public class LC53_MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int res =nums[0];
        int sum = 0;
        for (int num : nums) {
            // 如果sum比0大，那么sum肯定是为后面做贡献的，所以要加上
            if (sum > 0) {
                sum += num;

            }
            // 如果sum比0小，那么sum只能起到副作用，还不如从这个数字开始
            else {
                sum = num;
            }
            res = Math.max(res, sum);
        }

        return res;
    }

    public int maxSubArray2 (int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int res = Integer.MIN_VALUE;
        int tmp = -1;

        for (int i = 0; i < nums.length; i++) {
            tmp = Math.max(nums[i], nums[i] + tmp);
            res = Math.max(res, tmp);
        }

        return res;

    }
}
