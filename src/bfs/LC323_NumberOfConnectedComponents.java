package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 这道题是一个经典的洪水漫灌算法，flood fill
 *
 * 这道题虽然现在不熟，但是理解了还是很简单
 */
public class LC323_NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        //构造邻接表
        List<Set<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        //添加边
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            // 如果还没有visit过某个点
            if(!visited[i]) {
                dfs(i, adjList, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int v, List<Set<Integer>> adjList,
                     boolean[] visited) {
        // 将这个点标记为来过了
        visited[v] = true;

        // 访问其所有相邻接点，并将其标记为访问过
        for(int w: adjList.get(v)) {
            if (!visited[w]){
                dfs(w, adjList, visited);
            }
        }
    }
}
