package stack;

import java.util.Stack;

/**
 * 这道题的概念叫做单调增栈
 * 在栈中维护者一组heights列表的index
 * 然后这些index对应的高度，从栈底到栈顶是递增的
 *
 * 这样的话，每次pop出来一个curIndex，我们可以通过heights[curIndex]获取其当前高度
 *
 * 然后我们又知道，栈里的所有index对应的高度，都比当前高度矮，
 * ↑ 这句话好理解
 *
 * [[但是在当前i到下一个height(nextIndex), where nextIndex = stack.peek()之间的，都比当前index高]]
 * ↑ 这句话需要深入理解
 * 如何理解？当我们出栈一个curIndex之后，栈中的下一个nextIndex可以保证
 * 1. 首先在curIndex左边
 * 2. 在curIndex和nextIndex之间，没有比height[curIndex]矮的高度！
 * 因为在我们扫描到 i = curIndex的时候，比curIndex高的就肯定都出栈了。
 *
 *
 * 所以我们可以通过
 * （i - stack.peek() - 1) * height(curIndex)来计算了
 *
 * 比如这里我们扫描到第一个3的时候，5已经出栈了
 * [1,5,3,4,3,2,1]
 */
public class LC84_LargestRectanglesInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Stack<Integer> stack = new Stack<>();

        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int curIndex = stack.pop();
                int curMaxHeight = tmp[curIndex];

                int nextIndex = stack.peek();
                area = Math.max(area, (i - nextIndex-1) * curMaxHeight);
            }

            stack.push(i);
        }

        return area;
    }
}
