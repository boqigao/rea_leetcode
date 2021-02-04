package dfs;

/**
 * 这道题暴力dfs倒是不会错，但是会超时
 * 想要不超时的话，还是要考虑dp来做， 与其说dp，可能记忆体更靠谱点？
 */
public class LC329_LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        // 边际情况
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;

        // 自动初始化为0
        // 此处memory代表的是记录从mn点出发能达到的最大值
        int[][] memory = new int[m][n];

        // 边际条件已经计算过，因此结果最少也为1
        int res = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, i,j,m,n,memory);
                res = Math.max(res, max);
            }
        }
        return res;
    }


    /**
     * 这个dfs寻找的值，和return的值，就是当前ij情况下的最大值
     * @param matrix
     * @param i
     * @param j
     * @param m
     * @param n
     * @param memory
     * @return
     */
    private int dfs (int[][] matrix,
                     int i, int j,
                     int m, int n,
                     int[][] memory){
        if(memory[i][j]!=0) return memory[i][j];

        // max记录的是当前ij点的max
        int max = 1;
        int len = 0;
        int preVal = matrix[i][j];

        // 如果右边大
        if (j+1<matrix[0].length && matrix[i][j+1] > preVal) {
            // 需要注意的是，这里所有的1+dfs（）代表的是，我们已经确定有更大的值了，所以在新的结果里可以把当前ij的值加入链条中去，使其增加1
            // 非常类似于很多tree的题目
            len = Math.max(len, 1+ dfs(matrix, i, j + 1, m, n, memory));
        }
        // 如果左边大
        if (j-1>=0 && matrix[i][j-1] > preVal) {
            len = Math.max(len, 1+ dfs(matrix, i, j - 1,m, n, memory));
        }
        // 如果下边大
        if (i-1>=0 && matrix[i-1][j] > preVal) {
            len = Math.max(len, 1+ dfs(matrix, i - 1, j, m, n, memory));
        }
        // 如果上边大
        if (i+1<matrix.length && matrix[i+1][j] > preVal) {
            len = Math.max(len, 1+ dfs(matrix, i + 1, j, m, n, memory));
        }
        // 经过上面所有的dfs，len已经可以确定为新的结果了，因此更新max，并且把max存入memory中，返回max即可
        max = Math.max(len, max);
        memory[i][j] = max;
        return max;
    }
}


/**
 * 我知道为什么结果不对！
 * 更新 memory[i][j]的时候，如果不是在dfs内部更新就没有意义了！举例
 *
 * 譬如说有这样一个matrix
 * [19,18,17,16,15,14,13,12,11,10],
 * [20,21,22,23,24,25,26,27,28,29],
 * [39,38,37,36,35,34,33,32,31,30]
 *
 * 你做19的时候，其实已经把第二行全部遍历了一遍了，但是！这个时候你如果不在dfs内部更新memory的话，你更新完的只有19！
 * 但是做过的计算，实际上已经包含第二行第三行全部了，
 * 这样你从18开始计算的话，你第二行第三行又要跑一遍，因为你memory的第二行，第三行是空的！
 *
 */
class LC329_LongestIncreasingPathInMatrixTimeOut {
    int res;
    public int longestIncreasingPath(int[][] matrix) {
        res = 0;
        int[][] memory = new int[matrix.length][matrix[0].length];

        // memory[i][j]: 从i行j列开始出发的，能够得到的最大长度
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                memory[i][j] = 0;
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                memory[i][j] = dfs(matrix, memory,i,j, 1, 1);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix,
                    int[][] memory,
                     int i,
                     int j,
                     int tmpAns,
                    int returnAns) {
        // 每次进来都更新结果
        if (memory[i][j]!=0) {
            return tmpAns+memory[i][j];
        }

        res = Math.max(res, tmpAns);
        returnAns = Math.max(returnAns, tmpAns);

        int preVal = matrix[i][j];

        // 如果右边大
        if (j+1<matrix[0].length && matrix[i][j+1] > preVal) {
            // 我这里写的++--其实是回溯的情况，这里并不需要使用回溯，所以越弄越复杂
            tmpAns++;
            returnAns = Math.max(returnAns, dfs(matrix,memory, i, j + 1, tmpAns, returnAns));
            tmpAns--;
        }
        // 如果左边大
        if (j-1>=0 && matrix[i][j-1] > preVal) {
            tmpAns++;
            returnAns = Math.max(dfs(matrix,memory, i, j - 1, tmpAns, returnAns),returnAns);
            tmpAns--;
        }
        // 如果下边大
        if (i-1>=0 && matrix[i-1][j] > preVal) {
            tmpAns++;
            returnAns = Math.max(dfs(matrix, memory, i - 1, j, tmpAns, returnAns),returnAns);
            tmpAns--;
        }
        // 如果上边大
        if (i+1<matrix.length && matrix[i+1][j] > preVal) {
            tmpAns++;
            returnAns = Math.max(dfs(matrix, memory, i + 1, j, tmpAns, returnAns), returnAns);
            tmpAns--;
        }

        // 我现在想走完了整个函数就更新一次结果，怎么走呢
        // 注意，我们一定要在dfs内部更新memory，这样才有意义
        memory[i][j] = returnAns;
        return returnAns;
    }
}
