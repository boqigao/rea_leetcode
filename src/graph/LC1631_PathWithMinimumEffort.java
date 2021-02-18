package graph;

// 看到连通性问题，就要像巴普洛夫的狗一样！考虑并查集！！
// 看到最小权重问题！就要像巴普洛夫的狗一样！考虑dijkstra！

import java.util.*;

public class LC1631_PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<int[]> edges = new ArrayList<>();

        // 把所有边加入图中
        // 每一行n个点，所以第k个点就是行数 （i）*每列的点数字（n） + j
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int id = i * col +j;
                if (i > 0) {
                    edges.add(new int[]{id-col, id, Math.abs(heights[i][j] - heights[i-1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id-1, id, Math.abs(heights[i][j] - heights[i][j-1])});
                }
            }
        }

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        UnionFind uf = new UnionFind(row * col);
        int ans = 0;
        for (int edge[] : edges) {
            int source = edge[0];
            int dest = edge[1];
            int value = edge[2];
            uf.union(source, dest);
            if (uf.connected(0, row * col -1)) {
                ans = value;
                break;
            }
        }

        return ans;


    }

    class UnionFind {
        // 每个节点的父节点
        int[] parent;

        // 当前节点的规模
        int[] size;

        // 节点的个数
        int n;

        // 当前连通分量数目
        int setCount;

        // 初始化的构造函数
        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0 ; i < n; i++) {
                parent[i] = i;
            }
        }

        // 返回当前set的根节点, 顺便compression path
        public int findSet (int x) {
            if (parent[x] == x) {
                return x;
            } else {
                parent[x] = findSet(parent[x]);
                return parent[x];
            }
        }

        public boolean union(int x, int y) {
            x = findSet(x);
            y = findSet(y);
            if ( x == y) {
                return false;
            }

            // 如果x比y小，那就xy做交换，总之一定要把小的并到大的上面
            if (size[x] < size[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            parent[y] = x;
            size[x] += size[y];
            setCount--;
            return true;
        }

        public boolean connected (int x, int y) {
            x = findSet(x);
            y = findSet(y);
            return x == y;
        }

    }
}
