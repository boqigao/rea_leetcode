package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 这道题和某一道abc的题很像
 */
public class LC684_RedundantConnection {
    private Map<Integer, Node> map = new HashMap<>();

    class Node {
        int data;
        Node parent;
        int rank;
    }

    /**
     * 创造一个只有1个元素的集合
     * @param data
     */
    public void makeSet (int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    public void union(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if (parent1.data == parent2.data) {
            return;
        }

        // 如果1号set的代表结点 = 2号set的代表结点
        if (parent1.rank >= parent2.rank) {
            if(parent1.rank == parent2.rank) {
                parent1.rank += 1;
            }
            parent2.parent = parent1;

        } else {
            parent1.parent = parent2;
        }
    }

    public int findSet (int data) {
        return findSet(map.get(data)).data;
    }

    private Node findSet (Node node) {
        Node parent = node.parent;
        if(parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if (!map.containsKey(u)) {
                makeSet(u);
            }

            if (!map.containsKey(v)) {
                makeSet(v);
            }

            int parentU = findSet(u);
            int parentV = findSet(v);

            // 如果两个点在一个集合里，那么一定产生一个环
            if (parentU == parentV) {
                return edge;
            }

            // 否则就把uv并起来
            union(u, v);
        }

        return new int[0];
    }
}
