package bfs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC994_RottingOranges {
    int[] di = new int[] {1, 0, -1, 0};
    int[] dj = new int[] {0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length==0) {
            return 0;
        }

        Queue<int[]> q= new LinkedList<>();

        // 把所有烂橘子的位置放入队列
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==2) {
                    // 如果这个格子是烂橘子, 计算他扩散到所有岛屿所需要的时间
                    q.offer(new int[] {i, j});
                }
            }
        }

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curI = cur[0];
                int curJ = cur[1];
                for (int k = 0; k < 4; k++) {
                    int nextI = curI + di[k];
                    int nextJ = curJ + dj[k];

                    if(nextI >= grid.length || nextJ >= grid[0].length
                    || nextI < 0 || nextJ < 0 || grid[nextI][nextJ] ==2
                    || grid[nextI][nextJ] == 0) {
                        continue;
                    }

                    grid[nextI][nextJ] = 2;
                    q.offer(new int[] {nextI, nextJ});
                }
            }

            // 这里不能无脑++
            // 比如说上来一个[[0,2]]这种
            // 虽然q里一开始是有东西，但是我们传染了以后发现，2边上并没有好橘子
            // 所以我们得保证2边上有好橘子以后，才能加时间
            // 这里的判定其实就是确定2边上还有可供传染的好橘子！
            if (!q.isEmpty()) {
                res++;
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    // 如果这个格子是烂橘子, 计算他扩散到所有岛屿所需要的时间
                    return -1;
                }
            }
        }
        return res;

    }

}
