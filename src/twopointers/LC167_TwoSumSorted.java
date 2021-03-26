package twopointers;

public class LC167_TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;

        while (left < right) {
            int cur = numbers[right] + numbers[left];
            if (target == cur) {
                return  new int[]{left+1, right+1};
            } else if (cur > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {0,0};
    }
}
