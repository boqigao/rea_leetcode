package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 这道题做法是单调栈
 * 注意单调栈一般都储存的是索引！
 */
public class LC503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            // 得到当前的值
            int num = nums[i % len];

            // 如果栈非空，并且当前值比 nums[栈顶元素]大
            // 注意栈顶元素就是当前的最小元素

            //为啥这里用while呢，因为可能会连续pop吗
            // 是的，比如[1, 1, 2]的时候当i = 2时候，会连续pop出前两个1

            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < len) {
                stack.push(i);
            }
        }

        return res;
    }

    public int[] nextGreaterElementsSlow(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + nums.length; j++) {
                int next = j % nums.length;
                if (nums[next] > nums[i]) {
                    res[i] = nums[next];
                    break;
                }
            }
        }
        return res;
    }

}
