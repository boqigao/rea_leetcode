package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题的意思应该是所有有环的路径都不是需要的路径
 * 自己思路是对的，一定要坚持下去！
 */
public class LC802_FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int row = graph.length;
        int col = graph[0].length;
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                g.get(i).add(graph[i][j]);
            }
        }

        // 0 没访问过，1访问过，2安全，3环
        int[] visited = new int[row];

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            if (dfs(i, g, visited) == 2) res.add(i);
        }
        return res;

    }

    private int dfs(int i, List<List<Integer>>g, int[] visited){

        // 如果访问过了，说明有个环
        if (visited[i] == 1) return 3;

        // 如果访问过了，但是不为0，也不为1
        // 说明已经在前面的过程中更新过了，只要把它存的值返回就好了
        if (visited[i] != 0) return visited[i];

        visited[i] = 1;
        for (int next : g.get(i)) {
            // 只要访问过的有3，那么前面所有的节点都是环中节点
            if(dfs(next, g, visited) == 3) {
                visited[i] = 3;
                return 3;
            }
        }

        // 遍历过所有后续节点，不成环，那么这个点也不成环
        // 这里需要的注意的是他从后往前把所有不为环的节点也提前标记出来了
        visited[i] = 2;
        return 2;
    }
}
