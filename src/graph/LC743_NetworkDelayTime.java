package graph;

import java.util.*;

public class LC743_NetworkDelayTime {
    static List<List<Edge>> graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new ArrayList<>();

        for (int i = 1; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = dijkstra(k, n);

        for (int i =0; i< dist.length; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }

    /**
     * https://www.youtube.com/watch?v=pVfj6mxhdMw
     * @param i 当前节点的值
     * @param n 总节点数
     * @return
     */
    private static int[] dijkstra (int i, int n) {
        // dist保存从i节点出发到任意节点的最短距离
        int[] dist = new int[n+1];

        // 最开始的初始化，所有的节点都是无线距离
        Arrays.fill(dist, Integer.MAX_VALUE);

        // pq保存的是到下一个节点的cost，还有最小值
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));

        // 从自己出发到自己作为0？
        pq.offer(new Edge(i, 0));

        while (!pq.isEmpty()) {
            // 当前节点是距离A最近的节点
            Edge curEdge = pq.poll();
            for (Edge nextEdge: graph.get(curEdge.dest)) {
                // 如果从 i节点 到当前节点已有的cost
                // + 当前节点到下一个节点的cost
                // 比已经记录的距离小，那么就更新距离
                // 如果不存在这个值，说明当前节点的所有子节点已经无法通过当前节点来改善
                // 因此当前节点出队以后，就结束。
                if (curEdge.cost + nextEdge.cost < dist[nextEdge.dest]) {
                    dist[nextEdge.dest] = curEdge.cost + nextEdge.cost;

                    // 节点更新，这样可以找nextEdge的下一个edge
                    // 同时dist[]数组已经更新过了，那就把新的Edge也放进去
                    // 这个新的Edge中存的是从i节点到达dest节点的最小距离。。
                    // 其实对于Edge这个类是有一种复用的感觉
                    // 他这里的newEdge其实就是一个Vertex
                    // 和shortestDistancefromA的组合
                    // 因为这道题他不需要你记录PreviousVertex
                    pq.offer(new Edge(nextEdge.dest, dist[nextEdge.dest]));
                }
            }
        }

        // dist[i] 其实就是存的从i到i的最小距离。。这里非常巧妙
        return dist;


    }


    static class Edge {
        int dest;
        int cost;

        Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public String toString() {
            return this.dest + " " + this.cost;
        }
    }
}
