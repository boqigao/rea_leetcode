package dfs;

/**
 * 2021002：初见感想：完全没有想法，一点都不知道怎么做
 *
 * 核心是要标记所有走过的路！
 * 感觉好像和以前一个走迷宫很像
 *
 * 这道题的思路是这样的
 * 1. 遍历所有节点
 * 2. 当我们发现一个节点是1， 就先等于我们找到了一个岛屿的一部分
 *    因此res++
 *   2.1 然后，我们利用dfs，将这块岛屿的全部部分都标记成 “*”
 *
 * 这样的话，我们碰到新的 1，可以一定确定我们找到的，是新的岛屿！
 */
public class LC200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    // 将所有与当前格子关联的格子都标上星号 *
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        if (i>=grid.length
                // 注意，这里为什么要写成grid[0].length呢
                // 因为i很有可能是小于0的，如果i比0小，这里就报错了
                || j>=grid[0].length
                ||i<0
                ||j<0
                ||grid[i][j]!='1') {
            return;
        }

        grid[i][j] = '*';

        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
}
