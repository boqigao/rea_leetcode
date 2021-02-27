package dp;

import java.util.Stack;

public class LC85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];
        for (int i =0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        int[] curHist = new int[matrix[0].length];

        curHist = mat[0];

        int res = largestHistogram(curHist);

        for (int i = 1; i< matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (mat[i][j] == 0) {
                    curHist[j] = 0;
                } else {
                    curHist[j]++;
                }
            }
            res = Math.max(res, largestHistogram(curHist));
        }

        return res;
    }
    public int largestHistogram(int[] heights) {
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
