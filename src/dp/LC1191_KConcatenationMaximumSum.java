package dp;

/**
 * 这道题有三种情况
 * 1. 最大子数组在第一个数组内部 比如
 * [-10, 2, 3, -10] 这样的话你再怎么加后面的也只是副作用
 *
 * 2. 最大子数组粘合在两个数组之间
 * 即 [1, -3, 1][1, -3, 1]
 * 这种情况下最大子数组在两个子数组之间，可想而知在后面再加也没有效果
 *
 * 3. 最大子数组达到了第二个子数组的尾部（即题目给的子数组和本身大于零）
 * [-5, 8][-5, 8]
 * 这样只要计算前两个数组的最大子数组max， 然后把后面的k-2个子数组的和全加上就好了
 */
public class LC1191_KConcatenationMaximumSum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int tmp = 0, max = 0, sum = 0;
        for (int i = 0; i < 2 * arr.length; i++) {
            // 如果当前值比0小，那直接当前值赋给下一个
            tmp = Math.max(tmp + arr[i % arr.length], arr[i % arr.length]);
            max = Math.max(max, tmp);

            // k = 1时候的特例
            if (i == arr.length - 1 && k == 1) {
                return max;
            }

            // 记录sum
            if (i < arr.length) {
                sum += arr[i];
            }
        }
        return (int)((long)(Math.max(0, sum) * (k-2) + max) % 1000000007);
    }
}
