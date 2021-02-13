package bfs;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * https://www.youtube.com/watch?v=cJayBq38VYw
 * 这道题是利用一个pq去做
 * 首先把最外圈的所有节点入队，然后把最小值A出队
 * 然后这个最小值就是当前已知的max，如果他的隔壁有比他还小B的，那他们的差值就是
 * 隔壁那个点的A-B就是B点的存水量
 */
public class LC407_TrappingRainWaterII {

    private int[] di = new int[] {0, 1, 0, -1};
    private int[] dj = new int[] {1, 0, -1, 0};
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        if(row <= 2) return 0;
        int col = heightMap[0].length;
        if(col <= 2) return 0;

        // 建立一个根据高度排序的pq
        PriorityQueue<Wall> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.height));

        // 建立一个int[][] 来记录是否visited
        // true 代表已经访问过 （已经入队出队）
        // false 代表还未访问过
        boolean[][] visited = new boolean[row][col];

        // 把最外围一圈的值放入pq
        for (int j = 0; j < col; j++){
            Wall wall1 = new Wall(0, j, heightMap[0][j]);
            Wall wall2 = new Wall(row-1, j, heightMap[row-1][j]);
            pq.offer(wall1);
            pq.offer(wall2);
            visited[0][j] = true;
            visited[row-1][j] = true;
        }

        for (int i = 1; i < row-1; i++) {
            Wall wall1 = new Wall(i, 0, heightMap[i][0]);
            Wall wall2 = new Wall(i, col-1, heightMap[i][col-1]);
            pq.offer(wall1);
            pq.offer(wall2);
            visited[i][0] = true;
            visited[i][col-1] = true;
        }

        int max = 0;
        int res = 0;
        while (!pq.isEmpty()) {

            Wall curWall = pq.poll();

            // 只有每次出队的时候才更新最大值！
            max = Math.max(curWall.height, max);

            int curI = curWall.row;
            int curJ = curWall.col;
            for (int k = 0; k < 4; k++){
                int nextI = curI + di[k];
                int nextJ = curJ + dj[k];

                // 如果没有访问过
                // **先做i，j的判断再做visited的判断** 不然会越界报错
                if ( nextI >= 0 && nextJ >= 0
                && nextI < row && nextJ < col && !visited[nextI][nextJ]) {
                    // 下一个点能存的水
                    if (heightMap[nextI][nextJ] < max) {
                        res += max - heightMap[nextI][nextJ];
                    }
                    Wall nextWall = new Wall(nextI, nextJ, heightMap[nextI][nextJ]);
                    pq.offer(nextWall);
                    visited[nextI][nextJ] = true;
                }
            }
        }

        return res;

    }

    class Wall{   //定义一个墙壁类
        private int row;
        private int col;
        private int height;
        public Wall(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

}
