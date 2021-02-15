package graph;

import java.util.*;

/**
 * 有向有权图的一般做法
 * Map<String, List<Node>>
 * a, { {b,value}, {c, value}};
 *
 * Node : (String, Integer)
 *
 *
 * 这道题主要是建立图比较难想，但是图建好了以后，接下来的步骤还是非常好理解
 * https://www.youtube.com/watch?v=UcDZM6Ap5P4
 * 参考这位印度老哥
 */
public class LC399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Node>> map = new HashMap<>();

        // 建立图
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            Node nodeAtoB = new Node(b, values[i]);
            Node nodeBtoA = new Node(a, 1/values[i]);
            map.get(a).add(nodeAtoB);
            map.get(a).add(new Node(a, 1));
            map.get(b).add(nodeBtoA);
            map.get(b).add(new Node(b, 1));
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            res[i] = dfs(source, dest, map, new HashSet());
        }

        return res;

    }

    private double dfs(String source, String dest, Map<String, List<Node>> map, Set<String> visited) {
        if(!(map.containsKey(source) && map.containsKey(dest))) {
            return -1.0;
        }
        if(source.equals(dest)) {
            return 1.0;
        }
        visited.add(source);
        // 这里是一个dfs，因为对于每一个节点的下一个节点他都先走到底
        for (Node nextNode : map.get(source)) {
            if (!visited.contains(nextNode.dest)) {
                double ans = dfs(nextNode.dest, dest, map, visited);
                if (ans != -1.0) {
                    return ans * nextNode.value;
                }
            }
        }
        return -1;
    }

    class Node {
        String dest;
        double value;

        public Node(String dest, double value) {
            this.dest = dest;
            this.value = value;
        }
    }

}

