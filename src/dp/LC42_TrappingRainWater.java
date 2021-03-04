package dp;

/**
 * 这道题不是dp而是一道双指针
 * 数组必有一个 ”山顶“（若有多个高度相同山顶，任取一个即可）。
 *
 * 根据”木桶原理“，山顶左侧的元素的盛水量 ，由左侧最大值决定；山顶右侧元素的盛水量，由右侧最大值决定。
 *
 * 双指针法的两个指针最终会停在 “山顶” 处。
 *
 *              top
 *               __
 *             _/  \       __
 *      __    /     \     /  \
 * _   /  \__/       \___/    \     __
 *  \_/                        \___/
 */
public class LC42_TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (left <= right) {
            if (leftMax < rightMax) {
                ans+=Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                ans+=Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }

        return ans;
    }
}
