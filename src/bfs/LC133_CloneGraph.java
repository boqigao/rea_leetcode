package bfs;

import java.util.*;

public class LC133_CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);


        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node nei : cur.neighbors) {
                if(!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val, new ArrayList<>()));
                    // 把每个邻居节点加到que中
                    queue.add(nei);
                }

                // 把新的邻居节点加到邻居中
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
}
