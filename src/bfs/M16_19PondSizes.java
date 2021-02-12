package bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class M16_19PondSizes {
    int[] di = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
    int[] dj = new int[]{0, 1, 0, -1, 1, -1, -1, 1};
    public int[] pondSizes(int[][] land) {
        if(land == null || land.length==0) {
            return new int[0];
        }
        int row = land.length;
        int column = land[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (land[i][j] == 0) {
                    int size = findSize(land, i, j);
                    pq.offer(size);
                }
            }
        }

        int n = pq.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    private int findSize(int[][] land, int i, int j) {
        if(i >= land.length || j >= land[0].length ||
        i < 0 || j < 0 || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        int curSize = 0;
        for(int k = 0; k < 8; k++) {
            int nextI = i + di[k];
            int nextJ = j + dj[k];
            curSize += findSize(land, nextI, nextJ);
        }

        return curSize + 1;
    }
}

