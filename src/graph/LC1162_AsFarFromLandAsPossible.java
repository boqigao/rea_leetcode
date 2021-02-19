package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 考虑bfs的时候要考虑到根节点！
 */
public class LC1162_AsFarFromLandAsPossible {
    int[] di = new int[] {1, 0, -1, 0};
    int[] dj = new int[] {0, 1, 0, -1};
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        // 没有陆地
        if(q.size() == 0) {
            return -1;
        }

        boolean hasSea = false;
        int[] dist = new int[2];
        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            int curI = tmp[0];
            int curJ = tmp[1];
            dist[0] = curI;
            dist[1] = curJ;

            for (int k = 0; k < 4; k++) {
                int nextI = curI + di[k];
                int nextJ = curJ + dj[k];

                if (nextI >= 0 && nextJ >= 0
                        && nextI < row && nextJ < col
                && grid[nextI][nextJ] == 0) {
                    hasSea = true;
                    grid[nextI][nextJ] = grid[curI][curJ] + 1;
                    q.offer(new int[]{nextI, nextJ});
                }
            }
        }

        if (!hasSea) {
            return -1;
        }

        return grid[dist[0]][dist[1]] -1;

    }
}
