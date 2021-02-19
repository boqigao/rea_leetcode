package graph;
/**
 * 这道题是染色法
 * 可以想象由某一条曲线切割所有的边，如果能完美切割所有的边，同时这条曲线不与自身交叉
 * 那么这个图就是二分图
 *
 * 一个图可能有多个联通分量，如果每个联通分量都是二分图，那么这个图一定是二分图
 */
public class LC785_IsGraphBipartite {
    private boolean[] visited;
    // 每个顶点的颜色，0是蓝色，1是绿色
    private int[] colors;

    private int[][] graph;
    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        // 顶点的个数就是图的长度
        int v = graph.length;
        visited = new boolean[v];
        colors = new int[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (!dfs(v, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int v, int color) {
        // 访问v
        visited[v] = true;
        // 将v染色
        colors[v] = color;

        for(int w : graph[v]) {
            // 如果相邻接点w还没有被遍历过
            if (!visited[w]) {
                // 如果相邻接点检测到不是二分图了，就返回false
                if (!dfs(w, 1-color)) {
                    return false;
                }
            }

            // 如果以及访问过了，同时邻接的点和当前点的颜色一样
            // 其实这里最重要，就是类似于别的dfs的终止判定
            if (colors[v] == colors[w]) {
                return false;
            }
        }

        return true;
    }
}
