package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len-2; i++){

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int k = len - 1;

            for (int j = i + 1; j < len; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                // 这里比较关键，相当于固定住某个j，然后找k
                // 因为我们已经排序过数组，所以只要缩小k就有可能找到某个值
                while (j < k && nums[j] + nums[k] + nums[i] >0) {
                    k--;
                }

                // 如果在一轮j中，k都已经缩小到j了，但是还是没有满足条件的
                if( j == k) {
                    break;
                }

                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    res.add(l);
                }

            }

        }
        return res;
    }
}
