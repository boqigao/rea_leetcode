package graph;

import java.util.*;

/**
 * 这道题没法用dfs做，因为他其实是一个最短权重路径的问题
 * dfs的话会有一个visited问题，你从某条路绕过来和另一条路绕过来结果并不一样
 */
public class LC1334_FindNumberOfSmallestNeighbors {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<Edge>> g = new HashMap<>();

        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            g.get(edge[0]).add(new Edge(edge[1], edge[2]));
            g.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }


        int[] dist = new int[n];

        //res[0] = minCityNumber, res[1] = whichCity
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            PriorityQueue <Edge> pq= new PriorityQueue<>(
                    Comparator.comparingInt(o->o.value));

            pq.offer(new Edge(i, 0));

            while (!pq.isEmpty()) {
                Edge curEdge= pq.poll();
                for (Edge neighbor: g.get(curEdge.neighbor)) {
                    if (neighbor.value + curEdge.value < dist[curEdge.neighbor]) {
                        dist[curEdge.neighbor] = neighbor.value + curEdge.value;
                        pq.offer(new Edge(neighbor.neighbor, dist[curEdge.neighbor]));
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[j] <= distanceThreshold){
                    count++;
                }
            }
            if( count <= res[0]) {
                res[0] = count;
                res[1] = i;
            }

        }

        return res[1];
    }

    class Edge {
        int neighbor;
        int value;

        public Edge(int d, int value) {
            this.neighbor = d;
            this.value = value;
        }
    }
}
