package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC1293_ShortestPathInAGridWithObstaclesElimination {
    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        //需要一个seen[x][y] = min obstacles to reach (x, y)
        // seen记录的是到达seen[x][y] 点时候所需要的最少的障碍物
        int[][] seen = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        // q中存储的是到达x， y，所需要最少的障碍物
        Queue<int[]> q = new LinkedList<>();

        int steps = 0;

        q.offer(new int[]{0, 0, 0});
        seen[0][0] = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curXYO = q.poll();
                int curx = curXYO[0];
                int cury = curXYO[1];
                int curo = curXYO[2];

                // 如果走到了结果
                if(curx==m-1 && cury==n-1){
                    return steps;
                }

                for(int j = 0; j < 4; j++){
                    int x = curx + dx[j];
                    int y = cury + dy[j];
                    // 超过边界了
                    if(x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }

                    // grid[x][y] == 1， 那么是障碍，所以障碍还要+1
                    // grid[x][y] == 0, 说明是平地，障碍不变
                    int o = curo + grid[x][y];

                    // 如果，现在需要清理的的障碍物，seen中存储的的还要多
                    // 或者，现在需要清理的障碍物比能够清理的总数还要大
                    // 那么这条路径一定不是最优的，因为已经有最优的路径了
                    if(o >= seen[x][y] || o > k) {
                        continue;
                    }

                    // 如果上述条件全部满足，就更新seen
                    seen[x][y] = o;

                    q.offer(new int[]{x, y, o});
                }

            }

            // 更新完一轮以后，可以继续往下面走了
            steps++;
        }

        return -1;

    }
}
