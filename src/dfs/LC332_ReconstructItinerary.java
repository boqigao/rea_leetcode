package dfs;

import java.util.*;

/**
 * 这道题可以用图来理解，每一个城市代表一个顶点
 * 每一张机票代表一条边
 *
 * 就是欧拉路径，那个7桥问题
 * hierholzer算法
 *
 * PriorityQueue可以实现自动排序
 */
public class LC332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // PQ可以实现自动排序！！
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        // 做一个邻接表形式的图
        for(List<String> ticket : tickets) {
            if(!map.containsKey(ticket.get(0))) {
                PriorityQueue<String> q = new PriorityQueue<>();
                map.put(ticket.get(0), q);
            }

            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK", res, map);
        return res;
    }

    private void dfs(String s, LinkedList<String> res,
                     Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> q = map.get(s);
        while (q != null && !q.isEmpty()) {
            // pq一定是弹出一个小的！
            dfs(q.poll(), res, map);
        }

        //在链表中可以addFirst！
        res.addFirst(s);
    }
}
