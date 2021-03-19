package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class LC135_Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        //记录结果的数组
        int[] nums = new int[ratings.length];

        Arrays.fill(nums, 1);

        // 先从左遍历
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                nums[i + 1] = nums[i] + 1;
            }
        }

        // 再从右遍历
        for (int i = ratings.length - 1; i >=1; i--) {
            if (ratings[i-1] > ratings[i] && nums[i-1] <= nums[i]) {
                nums[i-1] = nums[i] + 1;
            }
        }

        int res = 0;
        res = Arrays.stream(nums).sum();

        return res;
    }
}
