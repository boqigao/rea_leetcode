package graph;

import java.util.*;

public class LC133_CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // 这个map就是记录一个visited，如果已经visit过，就放入map中
        // map中一一匹配的存过的老点和新点
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);

        Queue<Node> queue = new LinkedList<>();

        // 队列中保存的是原图的节点，其实就是bfs访问每个节点，然后再new一个新的节点进去
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                // 如果map中还没有记录过这个neighbor
                if (!map.containsKey(neighbor)) {
                    // map中没有neighbor，说明没有访问过这个neighbor
                    // 所以在需要new一个新的neighbor出来
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // 把老点放进queue中
                    queue.add(neighbor);
                }

                // 把这个新neighbor加入新list中
                // map.get(cur)->找到的是老图的点对应的新图的点
                // newNode.neighbors.add (map.get(neighbor))
                // map.get(neighbors) 找到的是 老neighbor对应的新neighbor
                // 所以就是 newNode.neighbor.add(newNeighbors)
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
