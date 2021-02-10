package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 这道题初见的想法是，dfs每个岛屿，然后
 * See dfs.LC200
 *
 * 1. 首先dfs找到每个岛屿，然后将其改名，比如说1，2,3，号岛屿
 *
 * 2. 对于每个0，检查其上下左右的不同的连通分量（岛屿），将其加在一起
 */
public class LC927_MakingALargeIsland {

    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};
    public int largestIsland(int[][] grid) {
        if(grid== null || grid.length ==0) {
            return 0;
        }
        int max = 0;
        int islandID = 2;
        int row = grid.length;
        int column = grid[0].length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(grid[i][j] == 1){
                    int size = getIslandSize(grid,i, j,islandID);
                    max = Math.max(max, size);
                    // map中存储的是每个岛屿的id，还有其大小
                    map.put(islandID, size);
                    islandID += 1;
                }
            }
        }

        //其实他这个都不是dfs，这个题核心还是上面的dfs！
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {

                // 如果当前位置是海，找到他上下左右的四个地方，
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();

                    for(int k = 0; k < 4; k++) {
                        int ki = i + dx[k];
                        int kj = j + dy[k];
                        // 如果其上下左右存在某个岛屿，就把当前岛屿的id存下来
                        // 为了避免重复，我们存在set里面
                        if(ki>=0&&kj>=0&&ki<row&&kj<column&&grid[ki][kj]!=0) {
                            set.add(grid[ki][kj]);
                        }
                    }

                    int sum = 1;
                    //对于每一个可被我们联通的岛屿，我们将其添加上
                    // 又因为这片海将被我们填海造陆，所以我们sum初始为1
                    for(int id : set) {
                        //
                        int size = map.get(id);
                        sum += size;
                    }

                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    private int getIslandSize(int[][] grid, int i, int j,
                         int islandID) {
        if(i<0 || j <0 || i>=grid.length || j >= grid[0].length
        || grid[i][j] != 1) {
            return 0;
        }
        // 在这里已经标记了这块岛屿的相关地区，所以在上层的for循环中，不会再进入到这个岛屿
        grid[i][j] = islandID;

        int sum = 0;
        for(int k = 0; k < 4; k++){
            int ki = i + dx[k];
            int kj = j + dy[k];
            sum+=getIslandSize(grid, ki, kj, islandID);
        }
        // 此处+1指的是当前岛屿的1
        return sum+1;

    }
}
