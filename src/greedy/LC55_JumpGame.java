package greedy;

public class LC55_JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) return true;

        int maxDis = nums[0];
        for (int i = 1; i < len - 1; i++) {
            // 这个判定很重要，
            // 这里的意思是i位置本身是可达到的，不然直接就return false了

            if (i <= maxDis) {
                maxDis = Math.max(maxDis, nums[i] + i);
            }
        }

        return maxDis >= len - 1;

    }
}
