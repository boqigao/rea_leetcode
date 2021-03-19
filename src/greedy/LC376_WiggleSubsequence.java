package greedy;

/**
 * @see dp.LC376_WiggleSubsequence
 */
public class LC376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        int prevDiff = nums[1] - nums[0];
        int ret = prevDiff !=0 ?2:1;

        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i-1];
            if ((diff >0 && prevDiff<=0) ||
                    (diff<0 && prevDiff >=0)) {
                ret++;
                prevDiff = diff;
            }
        }

        return ret;
    }
}
