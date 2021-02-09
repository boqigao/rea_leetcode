package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 想用bfs的时候，要考虑清楚根节点是什么，比如说这道题，根节点就是所有的0节点！
 */
public class LC542_01Matrix {
    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++) {
                if(matrix[i][j] == 0){
                    //把所有的0作为bfs的第一层,queue中存放的是当前i,j坐标距离0最近的距离
                    queue.offer(new int[]{i, j});
                } else {
                    // 这一步的设定也非常关键
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            int prevX = s[0];
            int prevY = s[1];

            for(int i = 0; i < 4; i++) {
                int x = prevX + dx[i];
                int y = prevY + dy[i];

                if(x < 0 || y < 0 || x >= row || y >=column
                        // 这里小于等于 + 1的原因是原来的位置需要+1才能移动到新位置
                || matrix[x][y] <= matrix[prevX][prevY] + 1){
                    continue;
                }

                matrix[x][y] = matrix[prevX][prevY] + 1;
                // 其实queue的x, y和matrix[x][y] 是相对应的，又因为matrix相当于是个全球变量
                // 所以只要把queue的x,y放进去就好
                queue.add(new int[]{x, y});
            }
        }
        return matrix;
    }
}
