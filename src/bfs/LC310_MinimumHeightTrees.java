package bfs;

import java.util.*;

public class LC310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }

        if(n == 1) {
            res.add(0);
            return res;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        //顶点的度
        int[] degree = new int[n];

        // 构建图
        for (int i = 0; i < edges.length; i++) {
            if(graph.containsKey(edges[i][0])) {
                graph.put(edges[i][1], new ArrayList<>());
            }
            if(graph.containsKey(edges[i][1])) {
                graph.put(edges[i][2], new ArrayList<>());
            }

            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                q.offer(i);
            }
        }


        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                list.add(cur);
                for(int nei : graph.get(cur)) {
                    degree[nei]--;
                    if(degree[nei] == 1){
                        q.offer(nei);
                    }
                }
            }
            res = list;
        }

        return res;


    }
}
