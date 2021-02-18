package graph;

import java.util.*;

public class LC743_SecondTime {

    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        LC743_SecondTime test = new LC743_SecondTime();
        System.out.println(test.networkDelayTime(times, n, k));
    }

    Map<Integer, List<Edge>> graph;
    public int networkDelayTime(int[][] times, int n, int k) {

        graph = new HashMap<>();

        // 这里如果不给所有的边都加上的话，后面会报nullPointer的错
        for (int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        // 建立图
        // 因为节点id是从1-n
        // 方便起见我们建立图时候就用 0 - n-1
        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u - 1).add(new Edge(v - 1, w));
        }

        int[] dist = dijkstra (k - 1, n);

        for (int i = 0; i < n; i++ ) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }

    private int[] dijkstra(int k, int n) {
        // new一个节点来保存n
        int[] dist = new int[n];

        // 将所有值定义为最大值
        Arrays.fill(dist,Integer.MAX_VALUE);

        // 初始节点自己到自己的距离设置为0
        dist[k] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.value));

        pq.offer(new Edge(k, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            for (Edge neighbors : graph.get(curEdge.vertices)) {
                // 如果通过当前最小边到达的节点能更近
                if (neighbors.value + curEdge.value
                < dist[neighbors.vertices]) {
                    dist[neighbors.vertices] = neighbors.value
                            +curEdge.value;
                    pq.offer(new Edge(neighbors.vertices, dist[neighbors.vertices]));
                }
            }
        }

        return dist;

    }

    class Edge {
        int vertices;
        int value;

        public Edge(int Vertices, int value) {
            this.vertices = Vertices;
            this.value = value;
        }
    }
}
